package com.lantaiyuan.ebus.service;

import org.lanqiao.ssm.common.core.service.BaseServiceI;

import com.lantaiyuan.ebus.model.BaseStation;
import com.lantaiyuan.ebus.model.BaseStationQueryModel; 

public interface BaseStationServiceI extends BaseServiceI<BaseStation, BaseStationQueryModel> {
    BaseStation queryStationByTicketIdAndStationNo(String ticketId,int direction,int onBusStationNo);
    
    BaseStation getStationByStationIdAndCityCode(Integer stationId, String cityCode);
}
