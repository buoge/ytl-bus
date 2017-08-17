package com.lantaiyuan.ebus.custom.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lantaiyuan.ebus.custom.dao.AppCustomMapper;
import com.lantaiyuan.ebus.custom.model.BaseStation;
import com.lantaiyuan.ebus.custom.model.BaseStationQueryModel;
import com.lantaiyuan.ebus.custom.model.Bus;
import com.lantaiyuan.ebus.custom.model.RouteStationRelationCollection;
import com.lantaiyuan.ebus.custom.model.StationRecord;
import com.lantaiyuan.ebus.custom.service.AppCustomServiceI;

@Service("appCustomService")
public class AppCustomService extends BaseService<BaseStation, BaseStationQueryModel>implements AppCustomServiceI{
	@Resource
	private AppCustomMapper appCustomMapper;
	
	@Override
	public List<RouteStationRelationCollection> getRouteStationRelationsByCitycode(String citycode) {
		return appCustomMapper.getRouteStationRelationsByCitycode(citycode);
	}
	
	@Override
	public List<StationRecord> getRouteIdDirectionStationNoByCitycode(String citycode) {
		return StringUtils.isEmpty(citycode) ? appCustomMapper.getRouteIdDirectionStationNoAllCities() : appCustomMapper.getRouteIdDirectionStationNoByCityCode(citycode);
	}

	@Override
	public BaseDAO<BaseStation, BaseStationQueryModel> getDao() {
		return appCustomMapper;
	}

	/***
	* <p>Title: selectAllBus</p>
	* <p>Description: </p>

	*/
	@Override
	public List<Bus> selectAllBus() {
		return appCustomMapper.selectAllBus();
	}

}
