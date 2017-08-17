package com.lantaiyuan.ebus.service.impl;

import javax.annotation.Resource;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import com.lantaiyuan.ebus.dao.BaseStationMapper;
import com.lantaiyuan.ebus.model.BaseStation;
import com.lantaiyuan.ebus.model.BaseStationQueryModel;
import com.lantaiyuan.ebus.service.BaseStationServiceI;

/**
 * 描述:站点管理业务类 作者:温海金 最后更改时间:上午11:50:22 待修改
 */
@CacheConfig(cacheNames = "nearStation")
@Service("baseStationService")
public class BaseStationServiceImpl extends BaseService<BaseStation, BaseStationQueryModel> implements BaseStationServiceI {
	@Resource
	private BaseStationMapper baseStationMapper;

	@Override
	public BaseDAO<BaseStation, BaseStationQueryModel> getDao() {
		return baseStationMapper;
	}

	@Override
	public BaseStation queryStationByTicketIdAndStationNo(String ticketId, int direction, int onBusStationNo) {
		return baseStationMapper.queryStationByTicketIdAndStationNo(ticketId, direction, onBusStationNo);
	}

	@Override
	public BaseStation getStationByStationIdAndCityCode(Integer stationId, String cityCode) {
		return baseStationMapper.getStationByStationIdAndCityCode(stationId, cityCode);
	}
}