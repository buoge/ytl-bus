package com.lantaiyuan.ebus.realtime.service;

import java.util.List;

import org.lanqiao.ssm.common.core.service.BaseServiceI;

import com.lantaiyuan.ebus.custom.model.BaseRoute;
import com.lantaiyuan.ebus.custom.model.BaseStation;
import com.lantaiyuan.ebus.custom.model.BaseStationQueryModel;
import com.lantaiyuan.ebus.realtime.model.RealTime;
import com.lantaiyuan.ebus.realtime.model.RealTimeQueryModel;

public interface TravelServiceI extends BaseServiceI<BaseStation,BaseStationQueryModel>{

	Integer getUserStationNo(String routeId, BaseStation userStation, int direction);
	
	boolean isNearStation(BaseStation station, double longitude, double latitude, double red);

	List<RealTime> getBusList(RealTimeQueryModel realTime, BaseStation userStation);

	RealTime getNearestBus(String cityCode, BaseStation userStation, BaseRoute route, Integer userStationNo);

	RealTime getNearestBus(List<RealTime> busList);

	
}
