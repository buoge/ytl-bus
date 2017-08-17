package com.lantaiyuan.ebus.custom.service;

import java.util.List;
import java.util.Map;
import org.lanqiao.ssm.common.core.service.BaseServiceI;

import com.lantaiyuan.ebus.custom.model.BaseStation;
import com.lantaiyuan.ebus.custom.model.BaseStationQueryModel;
import com.lantaiyuan.ebus.custom.model.StationNameInfo;
import com.lantaiyuan.ebus.realtime.model.BaseLine;
import com.lantaiyuan.ebus.realtime.model.NearStationsWithLine;
import com.lantaiyuan.ebus.realtime.model.RealTime;
import com.lantaiyuan.ebus.realtime.model.RealTimeQueryModel;
import com.lantaiyuan.ebus.realtime.model.RouteDetailAndRealTime;
import com.lantaiyuan.ebus.realtime.model.RouteDetailQueryModel;
import com.lantaiyuan.ebus.realtime.model.StationAndBaseLines;
import com.lantaiyuan.ebus.realtime.model.StationNearInfo;

public interface BaseStationServiceI extends BaseServiceI<BaseStation, BaseStationQueryModel> {

	BaseStation queryStationByName(String stationName, String cityCode);

	List<StationNameInfo> queryStationList(String stationname, String citycode);

	List<BaseStation> getStationByName(String stationName, String cityCode);

	StationNearInfo getNearestInfo(BaseStation baseStation);

	Map<String, List<StationAndBaseLines>> nearStationsWithRouteFiveAndTen(BaseStation baseStation);

	NearStationsWithLine nearStations(BaseStation baseStation);
    
    BaseStation getStationById(String stationId,String cityCode);
    
    List<BaseLine> getRoutesByStationId(String stationID, String cityCode)throws Exception;
    
    List<BaseLine> getRoutesByStationName(String stationName, String cityCode)throws Exception;

	Map<String, BaseStation> getCityStations(String cityCode, String routeId, int direction);

	List<BaseStation> getStationsByIds(String routeId, String cityCode, int direction);
    
    BaseStation queryStationByTicketIdAndStationNo(String ticketId,int direction,int onBusStationNo);
    
    void updataTheCorrectOfGps (BaseStation station);
    
    void updataTheCorrectOfGps (List<BaseStation> stations);

	List<RealTime> getRealTimeInfo(RealTimeQueryModel realTime);

	List<BaseStation> getAllStations();
	
	List<BaseLine> getRoutesByStationIdAndStationName(String stationId,String stationName,String cityCode);

	List<BaseStation> queryStationsByStationIdsAndCityCodes(List<BaseStationQueryModel> model);

	Object removeDduplicateStation(String cityCode);

	RealTime getNearestBusRealTime(RealTimeQueryModel realTime);

	List<BaseLine> getLinesNearBy(BaseStation nearestStation);

	RouteDetailAndRealTime getRouteDetailAndRealTime(RouteDetailQueryModel routeDetailQueryModel);

	
}
