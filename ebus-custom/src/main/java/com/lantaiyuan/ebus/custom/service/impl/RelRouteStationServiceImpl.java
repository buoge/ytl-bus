package com.lantaiyuan.ebus.custom.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.lantaiyuan.ebus.custom.dao.RelRouteStationMapper;
import com.lantaiyuan.ebus.custom.model.RelRouteStation;
import com.lantaiyuan.ebus.custom.model.RelRouteStationQueryModel;
import com.lantaiyuan.ebus.custom.model.mytrail.StationInMyTrail;
import com.lantaiyuan.ebus.custom.service.RelRouteStationServiceI;
import com.lantaiyuan.ebus.realtime.model.RouteSimpleInfo;

/**
 * @Title: RelRouteStationServiceImpl.java
 * @Package com.lantaiyuan.ebus.custom.service.impl
 * @Description:
 * @author yangyang
 * @date 2016年12月21日 下午4:20:15
 * @version v1.0
 */
@Service("relRouteStationService")
public class RelRouteStationServiceImpl extends BaseService<RelRouteStation, RelRouteStationQueryModel>
		implements RelRouteStationServiceI {

	@Resource
	private RelRouteStationMapper relRouteStationMapper;

	@Override
	public BaseDAO<RelRouteStation, RelRouteStationQueryModel> getDao() {
		return relRouteStationMapper;
	}

	/***
	 * <p>Title: getRoutesIdByStationId</p> 
	 * <p>Description: 根据stationId获取所有经过该站点的线路信息的routeIds</p>
	 * @author liuhao
	 */
	@Override
	public List<RouteSimpleInfo> getRoutesIdByStationId(String stationId, String cityCode) {
		return relRouteStationMapper.queryRoutesIdByStationId(stationId, cityCode);
	}

	@Override
	public List<Integer> getStationsIdByRouteId(String routeId, int direction, String cityCode) {
		return relRouteStationMapper.getStationsIdByRouteId(routeId, direction, cityCode);
	}

	@Override
	public int getStationNo(String routeId, int stationId, int direction, String cityCode) {
		return relRouteStationMapper.getStationNo(routeId,stationId,direction,cityCode);
	}
	
	/**
	 * 查出当前城市该线路（上行或下行）的所有线站关系
	 * 
	 * @auther yangyang
	 */
	@Override
	public Map<String, RelRouteStation> getCityRelRouteStation(String routeId, int direction,
			 String cityCode) {
		List<RelRouteStation> relList = relRouteStationMapper.getCityRelRouteStation(routeId, direction, cityCode);
		if (CollectionUtils.isEmpty(relList)) {
			return Collections.emptyMap();
		}
		Map<String, RelRouteStation> keyIsStationNo = new HashMap<>();
		relList.forEach(rel -> {
			keyIsStationNo.put(String.valueOf(rel.getStationno()), rel);
		});
		return keyIsStationNo;
	}
	/**
	 * 功能描述:获取两个站序中间的所有站点关系
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月25日 上午10:21:06
	 */
	@Override
	public List<StationInMyTrail> getRelRouteStationBetweenTwoStations(String routeId, int direction, String cityCode, int startStationNo, int endStationNo) {
		return relRouteStationMapper.getRelRouteStationBetweenTwoStations(routeId, direction, cityCode, startStationNo, endStationNo);
	}
	
}
