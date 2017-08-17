package com.lantaiyuan.ebus.custom.service.impl;

import com.lantaiyuan.ebus.carpool.model.CarpoolMatch;
import com.lantaiyuan.ebus.carpool.model.CarpoolOrder;
import com.lantaiyuan.ebus.carpool.model.CarpoolOrderQueryModel;
import com.lantaiyuan.ebus.carpool.model.CarpoolRouteStation;
import com.lantaiyuan.ebus.carpool.model.jpush.PushMsg;
import com.lantaiyuan.ebus.common.util.DistanceUtil;
import com.lantaiyuan.ebus.common.util.Tools;
import com.lantaiyuan.ebus.custom.dao.CarpoolMatchMapper;
import com.lantaiyuan.ebus.custom.dao.CarpoolOrderMapper;
import com.lantaiyuan.ebus.custom.dao.CarpoolRouteStationMapper;
import com.lantaiyuan.ebus.custom.model.carpool.*;
import com.lantaiyuan.ebus.custom.model.enummodel.CarpoolMatchStatusEnum;
import com.lantaiyuan.ebus.custom.service.CarpoolOrderServiceI;
import com.lantaiyuan.ebus.custom.service.PushMsgServiceI;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.lanqiao.ssm.common.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * 用户拼车业务订单
 *
 * @author yangyang
 * @date 2017年6月13日 下午3:21:41
 */
@Service("carpoolOrderService")
public class CarpoolOrderServiceImpl extends BaseService<CarpoolOrder, CarpoolOrderQueryModel>
		implements CarpoolOrderServiceI {

	@Autowired
	private CarpoolOrderMapper carpoolOrderMapper;

	@Autowired
	private CarpoolMatchMapper carpoolMatchMapper;

	@Autowired
	private CarpoolRouteStationMapper carpoolRouteStationMapper;

	@Autowired
	private PushMsgServiceI pushMsgService;

	@Override
	public BaseDAO<CarpoolOrder, CarpoolOrderQueryModel> getDao() {
		return carpoolOrderMapper;
	}

	/**
	 * 获取订单拼车动态
	 *
	 * @param orderNo
	 *            订单号
	 * @param userLon
	 *            用户经度
	 * @param userLat
	 *            用户纬度
	 * @return 返回拼车订单拼车动态
	 */
	@Override
	public CarpoolDynamics getCarpoolDynamics(String orderNo, double userLon, double userLat) {
		CarpoolDetail carpoolDetail = carpoolOrderMapper.selectOrderAndMatchByOrderNo(orderNo);
		CarpoolDynamics carpoolDynamics = new CarpoolDynamics();
		if (StringUtils.isEmpty(carpoolDetail)) {
			return carpoolDynamics;
		}
		// 由于支付成功便会将用户拼车状态更改为拼车中，所以对于此类真空地带得造个拼车数据
		if (StringUtils.isEmpty(carpoolDetail.getCarpoolMatch())) {
			CarpoolMatch carpoolMatch = new CarpoolMatch();
			carpoolMatch.setMatchStatus(carpoolDetail.getCarpoolOrder().getMatchStatus());
			carpoolMatch.setMatchPersons((byte) 1);
			carpoolMatch.setMatchTimes(1);
			carpoolMatch.setRequiredPersons((byte) 20);
			carpoolMatch.setMatchExpectTime(-1);
			carpoolDetail.setCarpoolMatch(carpoolMatch);
		}

		// 计算人距离起始站的距离
		double distance = DistanceUtil.countDistance(userLon, userLat,
				carpoolDetail.getCarpoolOrder().getRealStartLon().doubleValue(),
				carpoolDetail.getCarpoolOrder().getRealStartLat().doubleValue());
		// 系统建议的上车时间
		Date expectAboardTime = carpoolDetail.getCarpoolOrder().getExpectAboardTime();
		// 拼车时长
		long matchCostTime = 0;
		if (Objects.equals(carpoolDetail.getCarpoolOrder().getMatchStatus(), CarpoolMatchStatusEnum.CARPOOLING.val())) { // 拼车中，设置已拼车时间
			matchCostTime = Tools.secondsTimeDiff(new Date(), carpoolDetail.getCarpoolOrder().getApplyTime());
		} else {
			matchCostTime = Tools.secondsTimeDiff(
					StringUtils.isEmpty(carpoolDetail.getCarpoolMatch().getDepartTime()) ? new Date()
							: carpoolDetail.getCarpoolMatch().getDepartTime(),
					carpoolDetail.getCarpoolOrder().getApplyTime());
		}

		List<PushMsg> carpoolPushMsgList = pushMsgService.selectByOrderNo(orderNo);
		List<JpushDynamics> dynamics = new ArrayList<>();
		carpoolPushMsgList
				.forEach(pushMsg -> dynamics.add(new JpushDynamics(pushMsg.getPushMsg(), pushMsg.getGmtCreate())));

		carpoolDynamics.carpoolRouteId(carpoolDetail.getCarpoolMatch().getCarpoolRouteId())
				.carpoolRouteName(carpoolDetail.getCarpoolRouteName()).distance(distance).dynamics(dynamics)
				.endStation(carpoolDetail.getCarpoolOrder().getRealEndPlace()).expectAboardTime(expectAboardTime)
				// TODO 需要按照临时型和规律型重新写
				.initialAboardTime(carpoolDetail.getCarpoolOrder().getLatestStartTime())
				.paidPrice(carpoolDetail.getCarpoolOrder().getPaidPrice()).matchCostTime(matchCostTime)
				.matchedPersons(Integer.valueOf(carpoolDetail.getCarpoolMatch().getMatchPersons()))
				.matchedTimes(carpoolDetail.getCarpoolOrder().getMatchTimes())
				.matchExpectTime(carpoolDetail.getCarpoolMatch().getMatchExpectTime())
				.realPrice(carpoolDetail.getCarpoolOrder().getRealPrice())
				.requiredPersons(Integer.valueOf(carpoolDetail.getCarpoolMatch().getRequiredPersons()))
				.startStation(carpoolDetail.getCarpoolOrder().getRealStartPlace())
				.matchStatus(carpoolDetail.getCarpoolOrder().getMatchStatus())
				.matchId(carpoolDetail.getCarpoolOrder().getMatchId());
		return carpoolDynamics;
	}

	@Override
	public Page<CarpoolMatchResult> findMatchResultByPage(CarpoolMatchResultQueryModel model, int page,
			String cityCode) {
		if (!"-1".equals(cityCode) && (StringUtils.isEmpty(model.getCityCode()) || "-1".equals(model.getCityCode()))) {
			model.setCityCode(cityCode);
		}
		model.getPageModel().setNowPage(page);
		List<CarpoolMatchResult> matchResultList = carpoolMatchMapper.findMatchResultByPage(model);
		model.getPageModel().setRows(matchResultList);
		return model.getPageModel();
	}

	@Override
	public Page<CarpoolOrder> findMatchPersonByPage(CarpoolOrderQueryModel model, int page, String cityCode) {
		if (!"-1".equals(cityCode) && (StringUtils.isEmpty(model.getCityCode()) || "-1".equals(model.getCityCode()))) {
			model.setCityCode(cityCode);
		}
		model.getPageModel().setNowPage(page);
		List<CarpoolOrder> matchPersionList = carpoolOrderMapper.findMatchPersonByPage(model);
		model.getPageModel().setRows(matchPersionList);
		return model.getPageModel();
	}

	@Override
	public Map<String, Object> getMatchRouteInfo(CarpoolRouteStation model) {
		List<CarpoolRouteStation> stationList = carpoolRouteStationMapper.findByRouteId(model);
		Map<String, Object> matchMap = new HashMap<>();
		matchMap.put("stationList", stationList);
		matchMap.put("assistStation", "");
		return matchMap;
	}

	@Override
	public int updateStatusToPaid(String orderNo) {
		return carpoolOrderMapper.updateStatusToPaid(orderNo);
	}

}
