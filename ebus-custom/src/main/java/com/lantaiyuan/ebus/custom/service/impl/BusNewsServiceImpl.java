package com.lantaiyuan.ebus.custom.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.lanqiao.ssm.common.page.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;
import com.lantaiyuan.ebus.custom.dao.BusNewsMapper;
import com.lantaiyuan.ebus.custom.model.BusNews;
import com.lantaiyuan.ebus.custom.model.BusNewsQueryModel;
import com.lantaiyuan.ebus.custom.model.BusNewsResult;
import com.lantaiyuan.ebus.custom.model.BusNewsResultQueryModel;
import com.lantaiyuan.ebus.custom.model.LostProperty;
import com.lantaiyuan.ebus.custom.model.LostPropertyQueryModel;
import com.lantaiyuan.ebus.custom.model.ServiceIp;
import com.lantaiyuan.ebus.custom.model.enummodel.BusNewsTypeEnum;
import com.lantaiyuan.ebus.custom.model.enummodel.JpushTypeEnum;
import com.lantaiyuan.ebus.custom.service.BusNewsServiceI;
import com.lantaiyuan.ebus.custom.service.ServiceIpServiceI;
import com.lantaiyuan.ebus.realtime.model.AppUser;
import com.lantaiyuan.ebus.realtime.service.AppUserServiceI;
import com.lantaiyuan.ebus.realtime.service.JpushServiceI;

/**
 * @Title: BusNewsServiceImpl.java
 * @Package com.lantaiyuan.ebus.custom.service.impl
 * @Description:
 * @author yangyang
 * @date 2016年12月20日 下午2:22:50
 * @version v1.0
 */
@Service("busNewsService")
public class BusNewsServiceImpl extends BaseService<BusNews, BusNewsQueryModel> implements BusNewsServiceI {

	@Resource
	private BusNewsMapper busNewsMapper;
	
	@Resource
	private ServiceIpServiceI serviceIpService;
	
	@Resource
	private JpushServiceI jpushService;
	
	@Resource
	private AppUserServiceI appUserService;
	
	@Override
	public BaseDAO<BusNews, BusNewsQueryModel> getDao() {
		return busNewsMapper;
	}

	@Override
	public List<BusNewsResult> getFiveBigNews(String cityCode) {
		return busNewsMapper.getFiveBigNews(cityCode);
	}

	@Override
	public Page<BusNewsResult> findSmallNewsByPage(BusNewsResultQueryModel model, int page) {
		model.getPageModel().setNowPage(page);
		List<BusNewsResult> list = busNewsMapper.findSmallNewsByPage(model);
		model.getPageModel().setRows(list);
		return model.getPageModel();
	}
	
	@Override
	public Page<LostProperty> findLostPropertyByPage(LostPropertyQueryModel model, int page) {
		model.getPageModel().setNowPage(page);
		List<LostProperty> list = busNewsMapper.findLostPropertyByPage(model);
		list.forEach(lost -> {
			lost.setBrief(lost.getBrief());
		});
		model.getPageModel().setRows(list);
		return model.getPageModel();
	}

	@Override
	public boolean insertNews(BusNews news, String ip) {
		int count = busNewsMapper.countIp(ip);
		ServiceIp service = serviceIpService.getServiceIp(news.getCityCode());
		// 超过每日限制上传条数
		if (StringUtils.isEmpty(service.getTimes()) || count >= service.getTimes()) {
			return false;
		}
		// 重复上传，根据title 和 cityCode 判断是否重复
		if (busNewsMapper.checkDuplicate(news) >= 1) {
			return false;
		}
		// 不再使用第三方新闻链接，全部通过我们自己的链接打开新闻
		news.setContent_url("/release/news.jsp");
		int insertResult = busNewsMapper.insertNews(news, ip);
		if (insertResult >= 1 && news.getType() == BusNewsTypeEnum.HEADTITLE.getType()) {// 大标题添加成功
			List<Integer> list = busNewsMapper.findBigNews(news.getCityCode());
			if (list.size() > 5) {// 将更早的大标题新闻置为小标题新闻[大标题新闻只保留5条]
				list = list.subList(0, list.size() - 5);
				busNewsMapper.changeBigToSmall(list);
			}
		}
		boolean result = insertResult >= 1;
		if (result) {
			news.setNewsCategory((byte)1);
			jpushMessage(news);
		}
		return result;
	}
	/**
	 * 从后台增加新闻
	 * cityCode需要按情况看，如果是超级管理员，可以选择城市，反之只能添加本市的新闻，在web页面完成判断
	 * @auther yangyang
	 */
	@Override
	public boolean insertFromWebapp(BusNews news) {
		news.setSource((byte)0);//0:自己添加
		news.setCreatetime(new Date());
		boolean result = busNewsMapper.insertFromWebapp(news) >= 1;
		if (result) { // newsCategory	1：公交动态，2：失物招领
			jpushMessage(news);
		}
		return result;
	}
	
	/**
	 * 更新新闻
	 * 超级管理员，可以更改城市，在web页面完成判断
	 * @auther yangyang
	 */
	@Override
	public boolean updateNews(BusNews news) {
		return busNewsMapper.updateNews(news) >= 1;
	}
	
	/**
	 * 分页查询公交新闻
	 * @auther yangyang
	 */
	@Override
	public Page<BusNews> findBusNewsByPage(BusNewsQueryModel model, int page,String cityCode) {
		if(!"-1".equals(cityCode) && (StringUtils.isEmpty(model.getCityCode()) || "-1".equals(model.getCityCode()))) {
			model.setCityCode(cityCode);
		}
		model.getPageModel().setNowPage(page);
		List<BusNews> list = busNewsMapper.findBusNewsByPage(model);
		model.getPageModel().setRows(list);
		return model.getPageModel();
	}
	
	/**
	 * 删除公交新闻
	 * @auther yangyang
	 */
	@Override
	public boolean deleteBusNews(int id) {
		return busNewsMapper.deleteByPrimaryKey(String.valueOf(id)) >= 1;
	}
	
	/**
	 * 获取新闻详情
	 * @auther yangyang
	 */
	@Override
	public BusNews getNewsDetail(int id) {
		return busNewsMapper.selectByPrimaryKey(String.valueOf(id));
	}

	/**
	 * 获取新闻内容
	 * @author yangyang
	 */
	@Override
	public String getNewsContent(int id) {
		return busNewsMapper.selectNewsContent(id);
	}
	
	/**
	 * 推送失物招领或资讯消息
	 * @author yangyang
	 * @param news
	 */
	private void jpushMessage(BusNews news) { 
		// newsCategory	1：公交动态，2：失物招领
		String msgContent;
		JpushTypeEnum jpushType;
		if (news.getNewsCategory() == 2) {
			msgContent = "有新的失物招领信息";
			jpushType = JpushTypeEnum.LOST_AND_FOUND;
		} else {
			msgContent = "有新的资讯信息";
			jpushType = JpushTypeEnum.NEWS;
		}
		
		Map<String, String> extras = new HashMap<>();
		extras.put(SysGlobalConstants.MSG_TYPE, jpushType.value());
		
		if (StringUtils.isEmpty(news.getCityCode()) || "-1".equals(news.getCityCode())) { // 所有城市 
			jpushService.jpushMessageToAllUsers(msgContent, extras);
		} else { // 特定城市
			jpushService.jmessageToCityUsers(news.getCityCode(), msgContent, extras);
		}
	}

	@Override
	public Boolean showAngle(String userId, String lastRequestTime, JpushTypeEnum jpushTypeEnum) {
		return busNewsMapper.getCountByCondition(getCityCodeByUserId(userId), lastRequestTime, jpushTypeEnum.value()) > 0;
	}
	
	private String getCityCodeByUserId(String userId) {
		AppUser appUser = appUserService.getAppUserById(Integer.valueOf(userId));
		return appUser==null ? "EMPTY" : appUser.getCitycode();
	}
}
