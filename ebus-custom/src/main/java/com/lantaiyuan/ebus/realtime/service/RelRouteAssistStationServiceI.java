package com.lantaiyuan.ebus.realtime.service;

import java.util.List;

import org.lanqiao.ssm.common.core.service.BaseServiceI;

import com.lantaiyuan.ebus.realtime.model.MapPath;
import com.lantaiyuan.ebus.realtime.model.RelRouteAssistStation;
import com.lantaiyuan.ebus.realtime.model.RelRouteAssistStationQueryModel;

/**
 * @Title: RelRouteStationServiceI.java
 * @Package com.lantaiyuan.ebus.custom.service
 * @Description:
 * @author yangyang
 * @date 2016年12月21日 下午3:43:50
 * @version v1.0
 */
public interface RelRouteAssistStationServiceI extends BaseServiceI<RelRouteAssistStation, RelRouteAssistStationQueryModel> {

	MapPath getRelRouteAssitStation(String routeId, int direction, String cityCode);

	List<RelRouteAssistStation> getAllRelRouteStations();

	

}
