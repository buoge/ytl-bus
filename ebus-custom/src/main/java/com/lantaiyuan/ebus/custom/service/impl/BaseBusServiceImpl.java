package com.lantaiyuan.ebus.custom.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lantaiyuan.ebus.custom.dao.BaseBusMapper;
import com.lantaiyuan.ebus.custom.model.BaseBus;
import com.lantaiyuan.ebus.custom.model.BaseBusQueryModel;
import com.lantaiyuan.ebus.custom.service.BaseBusServiceI;
import com.lantaiyuan.ebus.realtime.model.RealTime;

/**
 * @Title: BaseBusServiceImpl.java
 * @Package com.lantaiyuan.ebus.custom.service.impl
 * @Description:
 * @author yangyang
 * @date 2016年12月21日 下午4:07:16
 * @version v1.0
 */
@Service("baseBusService")
public class BaseBusServiceImpl extends BaseService<BaseBus, BaseBusQueryModel> implements BaseBusServiceI {

	@Resource
	private BaseBusMapper baseBusMapper;
	

	@Override
	public BaseDAO<BaseBus, BaseBusQueryModel> getDao() {
		return baseBusMapper;
	}

	/**
	 * 获取某一城市所有车辆，并放入map中
	 * @auther yangyang
	 * @param cityCode
	 * @return
	 */
	@Override
	public Map<String, BaseBus> getCityBus(String cityCode) {
		List<BaseBus> busList = baseBusMapper.getCityBus(cityCode);
		if(StringUtils.isEmpty(busList)) {
			return Collections.emptyMap();
		}
		Map<String, BaseBus> map = new HashMap<>();
		busList.forEach(bus -> {
			map.put(bus.getVehicleid(), bus);
		});
		return map;
	}
	
	@Override
	public Map<String, BaseBus> getBuses(List<RealTime> busList, String cityCode) {
		List<String> vehicleIds = new ArrayList<>();
		busList.forEach(bus -> {
			vehicleIds.add(bus.getBus().getVehicleid());
		});
		List<BaseBus> list = baseBusMapper.getBuses(cityCode, vehicleIds);
		Map<String, BaseBus> map = new HashMap<>();
		list.forEach(bus -> {
			map.put(bus.getVehicleid(), bus);
		});
		return map;
	}
	

}
