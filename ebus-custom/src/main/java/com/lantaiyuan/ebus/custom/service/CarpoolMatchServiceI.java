package com.lantaiyuan.ebus.custom.service;

import java.math.BigDecimal;
import java.util.List;

import com.lantaiyuan.ebus.carpool.model.CarpoolMatch;
import com.lantaiyuan.ebus.carpool.model.CarpoolRouteStation;
import com.lantaiyuan.ebus.custom.model.carpool.CarpoolMatchAndRouteResultModel;

/**
 * 拼车动态
 * @author yangyang
 * @date 2017年6月13日 下午3:15:48 
 */
public interface CarpoolMatchServiceI {

	/**
	 * 根据撮合id找出该撮合的最新动态
	 * @author yangyang
	 * @param matchId
	 * @return
	 */
	CarpoolMatch selectByMatchId(String matchId);
	
	/**
	 * 功能描述:根据当前位置获取经过该位置的拼车信息
	 * 作者:温海金
	 * 最后更改时间 : 2017年7月18日 下午4:17:55
	 */
	List<CarpoolMatchAndRouteResultModel> findCarpoolRoutesByCurrentPlace(BigDecimal startlongitude, BigDecimal startlatitude, String citycode);
	/**
	 * 功能描述:获取符合条件的站点信息
	 * 作者:温海金
	 * 最后更改时间 : 2017年7月18日 下午6:47:00
	 */
	CarpoolRouteStation findStartOrEndStation(String carpoolRouteId, Byte stationType);
	
}