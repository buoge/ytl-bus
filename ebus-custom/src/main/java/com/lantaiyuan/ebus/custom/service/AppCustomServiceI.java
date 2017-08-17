package com.lantaiyuan.ebus.custom.service;

import java.util.List;

import com.lantaiyuan.ebus.custom.model.Bus;
import com.lantaiyuan.ebus.custom.model.StationRecord;
import com.lantaiyuan.ebus.custom.model.RouteStationRelationCollection;

public interface AppCustomServiceI {
	
	List<RouteStationRelationCollection> getRouteStationRelationsByCitycode(String citycode);
	
	List<Bus> selectAllBus();
	
	List<StationRecord> getRouteIdDirectionStationNoByCitycode(String citycode);
}