package com.lantaiyuan.ebus.custom.service;

import java.util.List;
import java.util.Map;

import org.lanqiao.ssm.common.core.service.BaseServiceI;

import com.lantaiyuan.ebus.custom.model.BaseBus;
import com.lantaiyuan.ebus.custom.model.BaseBusQueryModel;
import com.lantaiyuan.ebus.realtime.model.RealTime;

public interface BaseBusServiceI extends BaseServiceI<BaseBus, BaseBusQueryModel>{

	Map<String, BaseBus> getCityBus(String cityCode);

	Map<String, BaseBus> getBuses(List<RealTime> busList, String cityCode);
	
}
