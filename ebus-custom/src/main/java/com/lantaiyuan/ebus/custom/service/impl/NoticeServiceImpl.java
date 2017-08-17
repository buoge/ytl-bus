package com.lantaiyuan.ebus.custom.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.lanqiao.ssm.common.page.Page;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.lantaiyuan.ebus.common.constants.GlobalMap;
import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;
import com.lantaiyuan.ebus.common.util.DistanceUtil;
import com.lantaiyuan.ebus.custom.dao.NoticeMapper;
import com.lantaiyuan.ebus.custom.model.JpushDemo;
import com.lantaiyuan.ebus.custom.model.Notice;
import com.lantaiyuan.ebus.custom.model.NoticeHistory;
import com.lantaiyuan.ebus.custom.model.NoticePoint;
import com.lantaiyuan.ebus.custom.model.NoticeQueryModel;
import com.lantaiyuan.ebus.custom.model.ServiceIp;
import com.lantaiyuan.ebus.custom.model.SysUser;
import com.lantaiyuan.ebus.custom.model.TrafficInfo;
import com.lantaiyuan.ebus.custom.model.UserPosRecord;
import com.lantaiyuan.ebus.custom.model.enummodel.JpushNoticeTypeEnum;
import com.lantaiyuan.ebus.custom.model.enummodel.JpushRangeEnum;
import com.lantaiyuan.ebus.custom.model.enummodel.JpushTypeEnum;
import com.lantaiyuan.ebus.custom.model.enummodel.NoticeEnum;
import com.lantaiyuan.ebus.custom.service.NoticeHistoryServiceI;
import com.lantaiyuan.ebus.custom.service.NoticePointServiceI;
import com.lantaiyuan.ebus.custom.service.NoticeServiceI;
import com.lantaiyuan.ebus.custom.service.ServiceIpServiceI;
import com.lantaiyuan.ebus.realtime.dao.FavoriateMapper;
import com.lantaiyuan.ebus.realtime.model.Favoriate;
import com.lantaiyuan.ebus.realtime.service.AppUserServiceI;
import com.lantaiyuan.ebus.realtime.service.FavoriateServiceI;
import com.lantaiyuan.ebus.realtime.service.JpushServiceI;

/**
 * 描述:版本更新业务类 
 * 作者:温海金 
 * 最后更改时间:下午3:50:59
 */
@Service("noticeService")
public class NoticeServiceImpl extends BaseService<Notice, NoticeQueryModel> implements NoticeServiceI {
	
	private static final String PUBLISH_2_ALL_CITY = "ALL_USER";

	@Resource
	private FavoriateServiceI favoriateService;
	
	@Resource
	private NoticeMapper noticeMapper;
	
	@Resource
	private NoticeHistoryServiceI noticeHitoryService;
	
	@Resource
	private NoticePointServiceI noticePointService;
	
	@Resource
	private ServiceIpServiceI serviceIpService;
	
	@Resource
	private JpushServiceI jpushService;
	
	@Resource
	private FavoriateMapper favoriateMapper;
	
	@Resource
	private AppUserServiceI appUserService;
	
	@Resource(name="kafkaTemplate4jpushTopic")
	private KafkaTemplate<Integer, String> kafkaTemplate4jpushTopic;
	
	public BaseDAO<Notice, NoticeQueryModel> getDao() {
		return noticeMapper;
	}

	/**
	 * 功能描述:新增紧急通知信息
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月18日 下午4:56:26
	 */
	@Override
	public int insertAndPublishNotice(Notice notice, SysUser currentUser) {
		//1.紧急通知持久化
		String noticeId = UUID.randomUUID().toString();
		notice.setId(noticeId);
		//2.发送消息
		Short noticeRange = notice.getNoticeRange();
		NoticeEnum rangeTypeEnum = NoticeEnum.valueOf(noticeRange);
		//3.获取当前城市的图片地址和公交公司标题
		Assert.notNull(currentUser, "操作失败，必须先登入app后台系统才能发布通知！");
		String citycode = currentUser.getCitycode();
		ServiceIp serviceIp = serviceIpService.getServiceIp(citycode);
		String imgurl = serviceIp.getImgurl();
		String busCompanyTitle = serviceIp.getBusCompanyTitle();
		notice.setCityCode(citycode);
		//为角标服务的额外参数值
		Map<String, String> extras = new HashMap<String,String>();
		extras.put(SysGlobalConstants.MSG_TYPE, JpushTypeEnum.NOTICE.value());
		switch (rangeTypeEnum) {
			//所有城市
			case RANGE_ALL_CITY:
				Assert.isTrue(SysGlobalConstants.ADMIN_CITYCODE.equals(citycode), "只有管理员才能按所有城市发布信息");
				//1.向所有用户发送消息
				JpushDemo jpush2All = new JpushDemo(JpushNoticeTypeEnum.MESSAGE, JpushTypeEnum.NOTICE, notice.getContent(), JpushRangeEnum.ALL_USER);
				kafkaTemplate4jpushTopic.sendDefault(JSONObject.toJSONString(jpush2All));
				jpushService.jpushMessageToAllUsers(notice.getContent(), extras);
				//2.将信息进行历史记录存储，USER_ID保存PUBLISH_2_ALL_CITY = "ALL_USER"
				noticeHitoryService.insertSelective(new NoticeHistory(noticeId, PUBLISH_2_ALL_CITY, notice.getContent(), busCompanyTitle, imgurl));
				break;
			//全城
			case RANGE_THE_ONE_CITY:
				Assert.isTrue(!SysGlobalConstants.ADMIN_CITYCODE.equals(citycode), "管理员用户不能发布全城信息");
				//1.向指定城市用户发送消息
				Map<String, UserPosRecord> userPosRecoreInTheCity = GlobalMap.userPosMap.get(citycode);
				if(userPosRecoreInTheCity != null){
					Collection<UserPosRecord> usersIncity = userPosRecoreInTheCity.values();
					usersIncity.forEach(userPosRecord -> {
						String regId = appUserService.getRegIdByUserId(Integer.valueOf(userPosRecord.getUserid()));
						JpushDemo jpush2TheOneCity = new JpushDemo(JpushNoticeTypeEnum.MESSAGE, JpushTypeEnum.NOTICE, notice.getContent(), JpushRangeEnum.SIGLE_USER)
								.buidRegId(regId);
						kafkaTemplate4jpushTopic.sendDefault(JSONObject.toJSONString(jpush2TheOneCity));
						//TODO 暂时保留原生态的消息推送方式
						jpushService.jmessageByUserId(Integer.valueOf(userPosRecord.getUserid()), notice.getContent(), extras);
					});
				}
				//2.将信息进行历史记录存储，USER_ID保存当前城市的cityCode
				noticeHitoryService.insertSelective(new NoticeHistory(noticeId, citycode, notice.getContent(), busCompanyTitle, imgurl));
				break;
			//指定地点
			case RANGE_THE_ALLOWED_PLACE:
				Assert.isTrue(!SysGlobalConstants.ADMIN_CITYCODE.equals(citycode), "管理员用户不能按指定地点发布信息");
				NoticePoint[] noticePoints = notice.getNoticePoints();
				//1.找出指定范围内的用户信息列表，得到users
				Integer distanceRange = notice.getDistanceRange();
				//得到该城市的用户信息
				Map<String, UserPosRecord> cityMap = GlobalMap.userPosMap.get(citycode);
				//遍历打点信息，比较用户当前位置与打点距离
				for(NoticePoint noticePoint : noticePoints) {
					//设置ID和noticeId
					noticePoint.setId(UUID.randomUUID().toString());
					noticePoint.setNoticeid(notice.getId());
					noticePointService.insertSelective(noticePoint);
					if(cityMap != null){
						Collection<UserPosRecord> values = cityMap.values();
						//遍历用户列表比较用户位置与打点距离
						values.forEach(userPosRecord -> {
							double distance = DistanceUtil.countDistance(noticePoint.getLongitude(), noticePoint.getLatitude(), userPosRecord.getLongitude(), userPosRecord.getLatitude());
							if(distance < distanceRange) {//符合通知条件，发送消息并进行历史存储
								//发送消息
								String regId = appUserService.getRegIdByUserId(Integer.valueOf(userPosRecord.getUserid()));
								JpushDemo jpush2TheSigleUser = new JpushDemo(JpushNoticeTypeEnum.MESSAGE, JpushTypeEnum.NOTICE, notice.getContent(), JpushRangeEnum.SIGLE_USER)
										.buidRegId(regId);
								kafkaTemplate4jpushTopic.sendDefault(JSONObject.toJSONString(jpush2TheSigleUser));
								//TODO 暂时保留原生态的消息推送方式
								jpushService.jmessageByUserId(Integer.valueOf(userPosRecord.getUserid()), notice.getContent(), extras);
								//历史通知存储
								noticeHitoryService.insertSelective(new NoticeHistory(noticeId, userPosRecord.getUserid(), notice.getContent()));
							}
						});
					}
				}
				break;
			//指定线路
			case RANGE_THE_ALLOWED_ROUTE:
				Assert.isTrue(!SysGlobalConstants.ADMIN_CITYCODE.equals(citycode), "管理员用户不能按指定线路发布信息");
				//1.获得线路串，截取并遍历
				String routeStr = notice.getRouteStr();
				String[] routeIds = routeStr.split("\\,");
				for(String routeId : routeIds) {
					List<Integer> userIds = favoriateService.findUserIdByRouteId(routeId);
					userIds.forEach(userId -> {
						//2.向指定线路的关注（收藏）对象发送消息
						String regId = appUserService.getRegIdByUserId(userId);
						JpushDemo jpush2TheSigleUser = new JpushDemo(JpushNoticeTypeEnum.MESSAGE, JpushTypeEnum.NOTICE, notice.getContent(), JpushRangeEnum.SIGLE_USER)
								.buidRegId(regId);
						kafkaTemplate4jpushTopic.sendDefault(JSONObject.toJSONString(jpush2TheSigleUser));
						//TODO 暂时保留原生态的消息推送方式
						jpushService.jmessageByUserId(userId, notice.getContent(), extras);
						//3.将信息进行历史记录存储，USER_ID保存用户ID
						noticeHitoryService.insertSelective(new NoticeHistory(noticeId, userId.toString(), notice.getContent(), busCompanyTitle, imgurl));
					});
				}
				break;
			default:
				break;
		}
		return super.insertSelective(notice);
	}
	
	/**
	 * 功能描述:通知信息分页查询
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月18日 下午4:56:16
	 */
	@Override
	public Page<Notice> listByPage(NoticeQueryModel noticeQM) {
		covertPublishStartAndEndTime(noticeQM);
		List<Notice> notices = noticeMapper.listByPage(noticeQM);
		addNoticePoints2Notice(notices);
		noticeQM.getPageModel().setRows(notices);
		return noticeQM.getPageModel();
	}

	/**
	 * 功能描述:将地图打点对象添加到通知中
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月17日 上午9:22:39
	 */
	private void addNoticePoints2Notice(List<Notice> notices) {
		notices.forEach(notice -> {//为通知信息填充打点信息
			List<NoticePoint> noticePoints = noticePointService.getPointsByNoticeId(notice.getId());
			notice.setNoticePoints(noticePoints.toArray(new NoticePoint[noticePoints.size()]));
		});
	}
	/**
	 * 功能描述:前台条件查询时间转化
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月15日 下午7:56:52
	 */
	private void covertPublishStartAndEndTime(NoticeQueryModel noticeQM) {
		String publishTimeStart = noticeQM.getPublishTimeStart();
		if(!StringUtils.isEmpty(publishTimeStart)) {
			noticeQM.setPublishTimeStart(publishTimeStart+" 00:00:00");
		}
		
		String publishTimeEnd = noticeQM.getPublishTimeEnd();
		if(!StringUtils.isEmpty(publishTimeEnd)) {
			noticeQM.setPublishTimeEnd(publishTimeEnd+" 23:59:59");
		}
	}

	/**
	 * 功能描述:紧急通知信息条件查询
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月18日 下午6:34:39
	 */
	@Override
	public List<Notice> listByCondition(NoticeQueryModel noticeQM) {
		return noticeMapper.listByCondition(noticeQM);
	}
	
	@Override
	public List<Favoriate> findFavoriateByRouteAndCity(String routeId, String cityCode) {
		return favoriateMapper.findFavoriateByRouteAndCity(routeId, cityCode);
	}

	@Override
	public void uploadTraffic(TrafficInfo trafficInfo) {
		List<Favoriate> favoriateList = findFavoriateByRouteAndCity(trafficInfo.getRouteId(), trafficInfo.getCityCode());
		favoriateList.forEach(favoriate ->{
			jpushService.jpushByUserId(favoriate.getUserid(), trafficInfo.getTrafficMsg(),null);
		});
	}
	
	@Override
	public int updateSelective(Notice notice, SysUser currentUser) {
		//2.发送消息
		Short noticeRange = notice.getNoticeRange();
		NoticeEnum rangeTypeEnum = NoticeEnum.valueOf(noticeRange);
		//3.获取当前城市的图片地址和公交公司标题
		Assert.notNull(currentUser, "操作失败，必须先登入app后台系统才能发布通知！");
		String citycode = currentUser.getCitycode();
		ServiceIp serviceIp = serviceIpService.getServiceIp(citycode);
		String imgurl = serviceIp.getImgurl();
		String busCompanyTitle = serviceIp.getBusCompanyTitle();
		notice.setCityCode(citycode);
		//为角标服务的额外参数值
		Map<String, String> extras = new HashMap<String,String>();
		extras.put(SysGlobalConstants.MSG_TYPE, JpushTypeEnum.NOTICE.value());
		switch (rangeTypeEnum) {
			//所有城市
			case RANGE_ALL_CITY:
				Assert.isTrue(SysGlobalConstants.ADMIN_CITYCODE.equals(citycode), "只有管理员才能按所有城市发布信息");
				//1.向所有用户发送消息
				jpushService.jpushMessageToAllUsers(notice.getContent(), extras);
				//2.将信息进行历史记录存储，USER_ID保存PUBLISH_2_ALL_CITY = "ALL_USER"
				noticeHitoryService.insertSelective(new NoticeHistory(notice.getId(), PUBLISH_2_ALL_CITY, notice.getContent(), busCompanyTitle, imgurl));
				break;
			//全城
			case RANGE_THE_ONE_CITY:
				Assert.isTrue(!SysGlobalConstants.ADMIN_CITYCODE.equals(citycode), "管理员用户不能发布全城信息");
				//1.向指定城市用户发送消息
				Map<String, UserPosRecord> userPosRecoreInTheCity = GlobalMap.userPosMap.get(citycode);
				if(userPosRecoreInTheCity != null){
					Collection<UserPosRecord> usersIncity = userPosRecoreInTheCity.values();
					usersIncity.forEach(userPosRecord -> {
						jpushService.jmessageByUserId(Integer.valueOf(userPosRecord.getUserid()), notice.getContent(), extras);
					});
				}
				//2.将信息进行历史记录存储，USER_ID保存当前城市的cityCode
				noticeHitoryService.insertSelective(new NoticeHistory(notice.getId(), citycode, notice.getContent(), busCompanyTitle, imgurl));
				break;
			//指定地点
			case RANGE_THE_ALLOWED_PLACE:
				Assert.isTrue(!SysGlobalConstants.ADMIN_CITYCODE.equals(citycode), "管理员用户不能按指定地点发布信息");
				NoticePoint[] noticePoints = notice.getNoticePoints();
				//1.找出指定范围内的用户信息列表，得到users
				Integer distanceRange = notice.getDistanceRange();
				//得到该城市的用户信息
				Map<String, UserPosRecord> cityMap = GlobalMap.userPosMap.get(citycode);
				if(cityMap != null){
					Collection<UserPosRecord> values = cityMap.values();
					//遍历打点信息，比较用户当前位置与打点距离
					for(NoticePoint noticePoint : noticePoints) {
						//遍历用户列表比较用户位置与打点距离
						//设置ID和noticeId
						noticePoint.setId(UUID.randomUUID().toString());
						noticePoint.setNoticeid(notice.getId());
						noticePointService.insertSelective(noticePoint);
						values.forEach(userPosRecord -> {
							double distance = DistanceUtil.countDistance(noticePoint.getLongitude(), noticePoint.getLatitude(), userPosRecord.getLongitude(), userPosRecord.getLatitude());
							if(distance < distanceRange) {//符合通知条件，发送消息并进行历史存储
								//发送消息
								jpushService.jmessageByUserId(Integer.valueOf(userPosRecord.getUserid()), notice.getContent(), extras);
								//历史通知存储
								noticeHitoryService.insertSelective(new NoticeHistory(notice.getId(), userPosRecord.getCitycode(), notice.getContent()));
							}
						});
						
					}
				}
				break;
			//指定线路
			case RANGE_THE_ALLOWED_ROUTE:
				Assert.isTrue(!SysGlobalConstants.ADMIN_CITYCODE.equals(citycode), "管理员用户不能按指定线路发布信息");
				//1.获得线路串，截取并遍历
				String routeStr = notice.getRouteStr();
				String[] routeIds = routeStr.split("\\,");
				for(String routeId : routeIds) {
					List<Integer> userIds = favoriateService.findUserIdByRouteId(routeId);
					userIds.forEach(userId -> {
						//2.向指定线路的关注（收藏）对象发送消息
						jpushService.jmessageByUserId(userId, notice.getContent(), extras);
						//3.将信息进行历史记录存储，USER_ID保存用户ID
						noticeHitoryService.insertSelective(new NoticeHistory(notice.getId(), userId.toString(), notice.getContent(), busCompanyTitle, imgurl));
					});
				}
				break;
			default:
				break;
		}
		return super.updateByPrimaryKeySelective(notice);
	}

	/**
	 * 功能描述:获取当前后台系统用户所在城市
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月16日 下午4:52:10
	 */
	@Override
	public String getCityNameByCurrentUser(SysUser currentUser) {
		Assert.notNull(currentUser, "操作失败，必须先登入app后台系统才能发布通知！");
		ServiceIp serviceIp = serviceIpService.getServiceIp(currentUser.getCitycode());
		return serviceIp.getCityname();
	}
}
