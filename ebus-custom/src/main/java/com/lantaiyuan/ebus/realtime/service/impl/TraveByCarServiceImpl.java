package com.lantaiyuan.ebus.realtime.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.lantaiyuan.ebus.common.util.DistanceUtil;
import com.lantaiyuan.ebus.common.util.GpsCorrectUtil;
import com.lantaiyuan.ebus.common.util.Tools;
import com.lantaiyuan.ebus.custom.model.BaseRoute;
import com.lantaiyuan.ebus.custom.model.BaseStation;
import com.lantaiyuan.ebus.custom.model.BaseStationQueryModel;
import com.lantaiyuan.ebus.custom.service.BaseRouteServiceI;
import com.lantaiyuan.ebus.custom.service.BaseStationServiceI;
import com.lantaiyuan.ebus.custom.service.ServiceIpServiceI;
import com.lantaiyuan.ebus.realtime.model.AlreadyAlertDynamic;
import com.lantaiyuan.ebus.realtime.model.AlreadyAlertDynamicQueryModel;
import com.lantaiyuan.ebus.realtime.model.AppUser;
import com.lantaiyuan.ebus.realtime.model.Favoriate;
import com.lantaiyuan.ebus.realtime.model.GotoCarAlertSetting;
import com.lantaiyuan.ebus.realtime.model.GotoCarAlertSettingQueryModel;
import com.lantaiyuan.ebus.realtime.model.RealTime;
import com.lantaiyuan.ebus.realtime.model.TraveCarSetting;
import com.lantaiyuan.ebus.realtime.model.TraveCarSettingQueryModel;
import com.lantaiyuan.ebus.realtime.service.AlreadyAlertDynamicServiceI;
import com.lantaiyuan.ebus.realtime.service.AppUserServiceI;
import com.lantaiyuan.ebus.realtime.service.FavoriateServiceI;
import com.lantaiyuan.ebus.realtime.service.GotoCarAlertSettingServiceI;
import com.lantaiyuan.ebus.realtime.service.JpushServiceI;
import com.lantaiyuan.ebus.realtime.service.LeavingCarAlertServiceI;
import com.lantaiyuan.ebus.realtime.service.TraveByCarServiceI;
import com.lantaiyuan.ebus.realtime.service.TraveCarSettingServiceI;
import com.lantaiyuan.ebus.realtime.service.TravelServiceI;

/**
 * 功能描述:上下车提醒业务实现类
 * 作者:温海金
 * 最后更改时间 : 2017年02月17日 上午10:28:42
 */
@Service("traveByCarService")
public class TraveByCarServiceImpl extends BaseService<BaseStation, BaseStationQueryModel> implements TraveByCarServiceI {

	private static final Double DISTANTS_FROM_CURRENT_STATION = 800.00;

	private static final Double DISTANTS_FROM_USER_STATION = 800.00;

	@Resource
	private TravelServiceI travelServiceNew;

	@Resource
	private FavoriateServiceI favoriateService;

	@Resource
	private BaseRouteServiceI baseRouteService;

	@Resource
	private BaseStationServiceI baseStationService;

	@Resource
	private LeavingCarAlertServiceI leavingCarAlertService;

	@Resource
	private TraveCarSettingServiceI traveCarSettingService;

	@Resource
	private AppUserServiceI appUserService;

	@Resource
	private JpushServiceI jpushService;

	@Resource
	private ServiceIpServiceI serviceIpService;

	@Resource
	private GotoCarAlertSettingServiceI gotoCarAlertSettingService;

	@Resource
	private AlreadyAlertDynamicServiceI alreadyAlertDynamicService;

	private static final String formatStr = "HH:mm";
	private static SimpleDateFormat sdf = new SimpleDateFormat(formatStr);

	private static boolean isInZone(long tStart, long tEnd, long t) {
		return tStart <= t && t <= tEnd;
	}

	private static long getLong(String timeStr) throws Exception {
		return sdf.parse(timeStr).getTime();
	}

	private static long getCurrentTime() throws Exception {
		return getLong(sdf.format(new Date()));
	}

	private static Boolean isCurrentTimeInZone(String startTime, String endTime) {
		try {
			if (isInZone(getLong(startTime), getLong(endTime), getCurrentTime())) {
				return true;
			}
		} catch (Exception e) {
			//TODO 打日志 数据格式解析错误
		}
		return false;
	}



	@Override
	public BaseDAO<BaseStation, BaseStationQueryModel> getDao() {
		return null;
	}

	/**
	  * 每天凌晨定时清空用户下车提醒动态表中已经提醒过的数据#DELETE from t_trave_car_setting where IS_REMIND = TRUE;
	  */
	@Override
	public int clearTheDataInLeavingCarAlert() {
		return alreadyAlertDynamicService.clearTheDataInLeavingCarAlert();
	}

	/**
	 * 功能描述:根据前端每10秒传过来的用户信息进行下车提醒消息推送
	 * 作者:温海金
	 * 最后更改时间 : 2017年3月6日 下午3:17:58
	 */
	@Override
	public void jpushLeavingCarByDateCollection(String datacollection) {
		//1.拿到用户数据
		JSONObject dataJsonObj = JSONObject.parseObject(datacollection);
		if (StringUtils.isEmpty(dataJsonObj.get("userid"))) {//用户没有登入
			return;
		}
		String userId = dataJsonObj.get("userid").toString();
		Double longitude = Double.valueOf(dataJsonObj.get("longitude").toString());//经度
		Double latitude = Double.valueOf(dataJsonObj.get("latitude").toString());//纬度
		//处理cityCode
		String cityCode = handleCityCode((String) dataJsonObj.get("citycode"));
		//2.根据用户数据查询下车站点设置表
		TraveCarSettingQueryModel traveCarSettingQM = new TraveCarSettingQueryModel();
		traveCarSettingQM.setUserId(userId);
		traveCarSettingQM.setType((short) 2);//下车
		traveCarSettingQM.setIsRemind(false);
		traveCarSettingQM.setCityCode(cityCode);
		List<TraveCarSetting> traveCarSettings = traveCarSettingService.selectByCondition(traveCarSettingQM);
		//3.遍历下车站点设置表，比对用户与所设置下车站距离
		traveCarSettings.forEach(traveCarSetting -> {
			//Double longitude2 = traveCarSetting.getLongitude().doubleValue();
			//Double latitude2 = traveCarSetting.getLatitude().doubleValue();
			//得到基础数据中用户的经纬度
			//TODO 以下获取下车站经纬度方法有改需需要重新测试
			BaseStation baseStation = baseStationService.getStationById(traveCarSetting.getStationId(), cityCode);
			//对当前用户进行纠偏处理，将高德转化为谷歌
			double[] latlng = GpsCorrectUtil.gcj02_To_Gps84(baseStation.getLatitude().doubleValue(), baseStation.getLongitude().doubleValue());
			Double longitude2 = latlng[0];
			Double latitude2 = latlng[1];
			//4.若距离小于800m暂定（后续会定义成常量）则提醒用户下车
			//5不需要进行GPS矫正，因为上下车提醒设置中的经纬度也是前台传过来的，二者对应
			/*double[] latlng = GpsCorrectUtil.gcj02_To_Gps84(latitude, longitude);
			Double correctLatitude = latlng[0];
			Double correctLongitude = latlng[1];*/
			if (traveCarSetting.getIsRemind()) {//已经提醒过了，解决上面设置是否提醒条件不生效的问题
				return;
			}
			Double countDistance = DistanceUtil.countDistance(longitude, latitude, longitude2, latitude2);
			if (countDistance >= 0 && countDistance < DISTANTS_FROM_USER_STATION) {
				//jpushService.jpushByUserId(Integer.valueOf(userId), "您现在所处位置已经接近您设置的下车点，请确认是否下车并做好下车准备！");
				AppUser appUser = appUserService.getAppUserById(Integer.valueOf(userId));
				//消息推送不需要额外参数，传空
				jpushService.jpushToTheOneUser(appUser, "您现在所处位置已经接近您设置的下车点，请确认是否下车并做好下车准备！",null);
				//6.为已发送消息提醒的设置信息更改状态
				traveCarSetting.setIsRemind(true);
				traveCarSettingService.updateEntity(traveCarSetting);
			}
		});

	}

	/**
	 * 功能描述:根据前端每10秒传过来的用户信息进行上车提醒消息推送
	 * 作者:温海金
	 * 最后更改时间 : 2017年3月3日 下午3:32:55
	 */
	@Override
	public void jpushGotoCarByDateCollection(String datacollection) {
		JSONObject dataJsonObj = JSONObject.parseObject(datacollection);
		if (StringUtils.isEmpty(dataJsonObj.get("userid"))) {//用户没有登入
			return;
		}
		Integer userId = Integer.valueOf(dataJsonObj.get("userid").toString());
		Double longitude = Double.valueOf(dataJsonObj.get("longitude").toString());//经度
		Double latitude = Double.valueOf(dataJsonObj.get("latitude").toString());//纬度
		//处理cityCode
		String cityCode = handleCityCode((String) dataJsonObj.get("citycode"));

		if (!StringUtils.isEmpty(userId) && !StringUtils.isEmpty(cityCode) && !StringUtils.isEmpty(longitude) && !StringUtils.isEmpty(latitude)) {
			//1.查看该用户是否开启上车提醒功能（可能有两条信息）
			GotoCarAlertSettingQueryModel gotoCarAlertSettingQM = new GotoCarAlertSettingQueryModel();
			gotoCarAlertSettingQM.setUserId(userId);
			gotoCarAlertSettingQM.setCityCode(cityCode);
			gotoCarAlertSettingQM.setIsOpen(true);
			List<GotoCarAlertSetting> gotoCarAlertSettings = gotoCarAlertSettingService.selectByCondition(gotoCarAlertSettingQM);
			//这一步是从数据库中查，查出来是一个list forEach遍历看是否符合提醒条件
			gotoCarAlertSettings.forEach(gotoCarAlertSetting -> {
				Integer alertStrategy = gotoCarAlertSetting.getAlertStrategy();
				switch (alertStrategy) {
				case 1://仅提醒一次：查看是否已经提醒
					if (!gotoCarAlertSetting.getIsRemind()) {
						//判断时间条件
						jugeIsNeed2PushInfo(userId, longitude, latitude, cityCode, gotoCarAlertSetting);
					}
					break;
				case 2://周一到周五：判断当前是否是周末
					if (Tools.dayForWeek() != 6 && Tools.dayForWeek() != 7) {
						//判断时间条件
						jugeIsNeed2PushInfo(userId, longitude, latitude, cityCode, gotoCarAlertSetting);
					}
					break;
				case 3://每天: 直接判断是否符合提醒条件
							//判断时间条件
					jugeIsNeed2PushInfo(userId, longitude, latitude, cityCode, gotoCarAlertSetting);
					break;
				default:
					break;
				}
			});
		}
	}

	/**
	 * 功能描述:处理城市代码
	 * 作者:温海金
	 * 最后更改时间 : 2017年3月24日 下午5:49:07
	 */
	public String handleCityCode(String cityCode) {
		Set<String> cityCodes = serviceIpService.getAllDistinctCityCodes();
		//如果cityCode不在内存中的cityCode集合内，则转化为集合类对应的cityCode
		if (!cityCodes.contains(cityCode)) {
			String subCityCode = cityCode.substring(0, 4);
			Iterator<String> iterator = cityCodes.iterator();
			while (iterator.hasNext()) {
				String theCityCode = iterator.next();
				if (theCityCode.startsWith(subCityCode)) {
					cityCode = theCityCode;
				}
			}
		}
		return cityCode;
	}

	/**
	 * 功能描述:消息推送业务时间判断
	 * 作者:温海金
	 * 最后更改时间 : 2017年3月3日 下午3:32:55
	 */
	private void jugeIsNeed2PushInfo(Integer userId, Double longitude, Double latitude, String cityCode, GotoCarAlertSetting gotoCarAlertSetting) {
		String startTime = gotoCarAlertSetting.getStartTime();
		String endTime = gotoCarAlertSetting.getEndTime();
		if (isCurrentTimeInZone(startTime, endTime)) {//当前时间在用户设置的提醒时间范围内
			pushImpl(userId, cityCode, longitude, latitude, gotoCarAlertSetting.getId(), gotoCarAlertSetting.getTag());
		}
	}

	/**
	 * 功能描述:消息推送业务逻辑判断
	 * 作者:温海金
	 * 最后更改时间 : 2017年3月3日 下午3:33:25
	 */
	private void pushImpl(Integer userId, String cityCode, Double longitude, Double latitude, String gotoCarAlertSettingId, Integer tag) {
		//1.获取当前用户收藏列表
		List<Favoriate> favoriates = favoriateService.findFavoriateByUserIdAndCityCode(userId, cityCode);
		//2.遍历用户列表，通过线路id获取车辆信息 travelServiceNew.getNearestBus
		favoriates.forEach(favoriate -> {
			String routeid = favoriate.getRouteid();
			String citycode = favoriate.getCitycode();
			Integer stationid = favoriate.getStationid();
			Integer direction = favoriate.getDirection();
			//3.获取线路信息
			BaseRoute baseRoute = baseRouteService.getRouteByIdAndDirection(citycode, routeid, direction);
			//4.获取上车站点信息
			BaseStation baseStation = baseStationService.getStationById(stationid.toString(), citycode);
			Double distance = -1.0;
			//对当前用户进行纠偏处理，将高德转化为谷歌
			double[] latlng = GpsCorrectUtil.gcj02_To_Gps84(latitude, longitude);
			Double correctLatitude = latlng[0];
			Double correctLongitude = latlng[1];

			//计算用户当前位置与上车站点的距离
			if (baseStation != null && baseStation.getLongitude() != null && baseStation.getLatitude() != null) {
				distance = DistanceUtil.countDistance(correctLongitude, correctLatitude, baseStation.getLongitude().doubleValue(),
						baseStation.getLatitude().doubleValue());
			}
			//判断用户与站点的位置是否小于800m(暂定),后面改成常量
			if (distance > 0 && distance < DISTANTS_FROM_USER_STATION) {
				//5.得到站点在线路中的站序
				Integer userStationNo = travelServiceNew.getUserStationNo(routeid, baseStation, direction);
				//6.实时信息
				RealTime nearestBus = travelServiceNew.getNearestBus(citycode, baseStation, baseRoute, userStationNo);
				if (null != nearestBus.getDesc().getDistance() && nearestBus.getDesc().getDistance() < DISTANTS_FROM_CURRENT_STATION) {
					//是否已经给当前用户推送过该趟车辆的信息
					AlreadyAlertDynamicQueryModel alreadyAlertDynamicQM = new AlreadyAlertDynamicQueryModel();
					alreadyAlertDynamicQM.setGotoCarAlertSettingId(gotoCarAlertSettingId);
					alreadyAlertDynamicQM.setRouteId(routeid);
					alreadyAlertDynamicQM.setVehicleId(nearestBus.getBus().getVehicleid());
					alreadyAlertDynamicQM.setTag(tag);
					List<AlreadyAlertDynamic> isRemindList = alreadyAlertDynamicService.selectByCondition(alreadyAlertDynamicQM);
					GotoCarAlertSetting updateGotoCarSetting = gotoCarAlertSettingService.selectByPrimaryKey(gotoCarAlertSettingId);
					if (isRemindList.size() == 0 || (1 == updateGotoCarSetting.getAlertStrategy())) {//今天还未对该趟车辆进行提醒,或者用户设置只提醒一次，然后重新更新了设置信息
						//8.对当前用户发送消息推送 : routeid表示哪条线路  userid表示具体用户
						AppUser appUser = appUserService.getAppUserById(userId);
						//消息推送不需要额外参数，传空
						jpushService.jpushToTheOneUser(appUser, "您收藏的线路（" + baseRoute.getShortname() + "）的车辆将要到站，若您正在等待该线路，请做好上车准备！",null);
						//将我的设置里面的提醒状态改为1  gotoCarAlertSettingService.getById(gotoCarAlertSettingId); updateSelective
						updateGotoCarSetting.setIsRemind(true);
						gotoCarAlertSettingService.updateEntity(updateGotoCarSetting);
						//新建一张表记录对当前用户已经进行了一次提醒 要记录是上班提醒还是下班提醒 记录车辆信息 该表为动态表 每天凌晨清空一次
						AlreadyAlertDynamic alreadyAlertDynamic = new AlreadyAlertDynamic();
						alreadyAlertDynamic.setGotoCarAlertSettingId(gotoCarAlertSettingId);
						alreadyAlertDynamic.setRouteId(routeid);
						alreadyAlertDynamic.setVehicleId(nearestBus.getBus().getVehicleid());
						alreadyAlertDynamic.setTag(tag);
						alreadyAlertDynamicService.insertSelective(alreadyAlertDynamic);
					}
				}
			}

		});
	}

	/**
	 * 每天凌晨定时清空用户上车提醒动态表JPUSH_ALREADY_ALERT_DYNAMIC
	 */
	@Override
	public int clearTheDataOfAlreadyAlert() {
		return alreadyAlertDynamicService.clearTheDataOfAlreadyAlert();
	}

	/**
	 * 功能描述:上下车消息推送
	 * 作者:温海金
	 * 最后更改时间 : 2017年3月24日 下午5:24:43
	 */
	@Override
	@Async("remind")
	public void jpush4GoToCarAndLeavingCar(String datacollection) {
		//上车提醒消息推送
		this.jpushGotoCarByDateCollection(datacollection);
		//下车提醒消息推送
		this.jpushLeavingCarByDateCollection(datacollection);
	}

}