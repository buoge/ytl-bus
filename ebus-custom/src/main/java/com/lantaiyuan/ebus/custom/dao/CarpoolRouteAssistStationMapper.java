package com.lantaiyuan.ebus.custom.dao;

import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.custom.model.carpool.CarpoolRouteAssistStation;
import com.lantaiyuan.ebus.custom.model.carpool.CarpoolRouteAssistStationQueryModel;

/**
 * 拼车线路辅助站点
 * @author yangyang
 * @date 2017年6月14日 下午2:23:39 
 */
public interface CarpoolRouteAssistStationMapper
		extends BaseDAO<CarpoolRouteAssistStation, CarpoolRouteAssistStationQueryModel> {

	CarpoolRouteAssistStation findStationMapByMatchid(String matchId);
	

}