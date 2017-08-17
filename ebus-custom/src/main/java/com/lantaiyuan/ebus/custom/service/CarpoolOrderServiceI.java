package com.lantaiyuan.ebus.custom.service;

import com.lantaiyuan.ebus.carpool.model.CarpoolOrder;
import com.lantaiyuan.ebus.carpool.model.CarpoolOrderQueryModel;
import com.lantaiyuan.ebus.carpool.model.CarpoolRouteStation;

import java.util.Map;

import org.lanqiao.ssm.common.core.service.BaseServiceI;
import org.lanqiao.ssm.common.page.Page;
import com.lantaiyuan.ebus.custom.model.carpool.CarpoolDynamics;
import com.lantaiyuan.ebus.custom.model.carpool.CarpoolMatchResult;
import com.lantaiyuan.ebus.custom.model.carpool.CarpoolMatchResultQueryModel;

/**
 * 用户拼车业务信息
 * @author yangyang
 * @date 2017年6月13日 下午3:15:48 
 */
public interface CarpoolOrderServiceI extends BaseServiceI<CarpoolOrder, CarpoolOrderQueryModel>{

	/**
	 * 拼车动态
	 * @author yangyang
	 * @param orderNo
	 * @param userLon
	 * @param userLat
	 * @return
	 */
	CarpoolDynamics getCarpoolDynamics(String orderNo, double userLon, double userLat);

	Page<CarpoolMatchResult> findMatchResultByPage(CarpoolMatchResultQueryModel model, int page, String cityCode);

	Page<CarpoolOrder> findMatchPersonByPage(CarpoolOrderQueryModel model, int page, String cityCode);

	Map<String, Object> getMatchRouteInfo(CarpoolRouteStation model);
	
	int updateStatusToPaid(String orderNo);
}