package com.lantaiyuan.ebus.custom.service;

import java.util.List;
import java.util.Map;

import org.lanqiao.ssm.common.core.service.BaseServiceI;

import com.lantaiyuan.ebus.custom.model.RelRouteStation;
import com.lantaiyuan.ebus.custom.model.RelRouteStationQueryModel;
import com.lantaiyuan.ebus.custom.model.mytrail.StationInMyTrail;
import com.lantaiyuan.ebus.realtime.model.RouteSimpleInfo;

/**
 * @Title: RelRouteStationServiceI.java
 * @Package com.lantaiyuan.ebus.custom.service
 * @Description:
 * @author yangyang
 * @date 2016年12月21日 下午3:43:50
 * @version v1.0
 */
public interface RelRouteStationServiceI extends BaseServiceI<RelRouteStation, RelRouteStationQueryModel> {

	List<Integer> getStationsIdByRouteId(String routeId, int direction, String cityCode);

	List<RouteSimpleInfo> getRoutesIdByStationId(String stationId, String cityCode);

	int getStationNo(String routeId, int stationId, int direction, String cityCode);

	Map<String, RelRouteStation> getCityRelRouteStation(String routeId, int direction, String cityCode);

	/**
	 * 功能描述:获取两个站序中间的所有站点关系
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月25日 上午10:19:05
	 */
	List<StationInMyTrail> getRelRouteStationBetweenTwoStations(String routeId, int direction, String cityCode, int startStationNo, int endStationNo);

}
