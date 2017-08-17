package com.lantaiyuan.ebus.service;


import org.lanqiao.ssm.common.core.service.BaseServiceI;

import com.lantaiyuan.ebus.model.RelRouteBus;
import com.lantaiyuan.ebus.model.RelRouteBusQueryModel;

public interface RelRouteBusServiceI extends BaseServiceI<RelRouteBus, RelRouteBusQueryModel> {

	boolean updateRouteNo(String cityCode, int vehicleId, String routeNo);

	RelRouteBus getRelRouteBus(String cityCode, int vehicleId);

	boolean insertRelRouteBus(String cityCode, int vehicleId, String routeNo);

	
	
}
