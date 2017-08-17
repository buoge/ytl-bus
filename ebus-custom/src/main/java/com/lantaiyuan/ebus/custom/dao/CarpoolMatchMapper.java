package com.lantaiyuan.ebus.custom.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.carpool.model.CarpoolMatch;
import com.lantaiyuan.ebus.carpool.model.CarpoolMatchQueryModel;
import com.lantaiyuan.ebus.custom.model.carpool.CarpoolMatchAndRouteResultModel;
import com.lantaiyuan.ebus.custom.model.carpool.CarpoolMatchResult;
import com.lantaiyuan.ebus.custom.model.carpool.CarpoolMatchResultQueryModel;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import java.util.List;

/**
 * 撮合动态mapper
 * @author yangyang
 * @date 2017年6月13日 下午3:34:20 
 *
 */
public interface CarpoolMatchMapper extends BaseDAO<CarpoolMatch, CarpoolMatchQueryModel>{
    
	/**
	 * 根据撮合id找出该撮合的最新动态
	 * @author yangyang
	 * @param matchId
	 * @return
	 */
	CarpoolMatch selectByMatchId(@Param("matchId")String matchId);

	List<CarpoolMatchResult> findMatchResultByPage(CarpoolMatchResultQueryModel model);
	/**
	 * 功能描述:根据当前位置获取经过该位置的拼车信息
	 * 作者:温海金
	 * 最后更改时间 : 2017年7月18日 下午4:17:55
	 */
	List<CarpoolMatchAndRouteResultModel> findCarpoolRoutesByCurrentPlace(@Param("startlongitude")BigDecimal startlongitude, @Param("startlatitude")BigDecimal startlatitude, @Param("citycode")String citycode);

}