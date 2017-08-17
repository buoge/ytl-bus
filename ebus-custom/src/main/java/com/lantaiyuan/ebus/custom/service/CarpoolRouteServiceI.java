package com.lantaiyuan.ebus.custom.service;

import com.lantaiyuan.ebus.custom.model.carpool.CarpoolRouteDetail;

/**
 * 拼车生成的线路
 * @author yangyang
 * @date 2017年6月14日 下午2:48:53 
 *
 */
public interface CarpoolRouteServiceI {

	/**
	 * 查看线路详情
	 * @author yangyang
	 * @param carpoolRouteId
	 * @param userLon
	 * @param userLat
	 * @return
	 */
	CarpoolRouteDetail carpoolRouteDetail(String carpoolRouteId, double userLon, double userLat);


	
}