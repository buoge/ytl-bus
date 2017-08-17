package com.lantaiyuan.ebus.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import com.lantaiyuan.ebus.model.BaseStation;
import com.lantaiyuan.ebus.model.BaseStationQueryModel;
@Mapper
public interface BaseStationMapper extends BaseDAO<BaseStation, BaseStationQueryModel> {

	/**
	 * 功能描述:根据车票id、专线线路方向，用户上车站点的站序，查询上车地点的信息  By YvanTan
	 */
	BaseStation queryStationByTicketIdAndStationNo(@Param("ticketId") String ticketId,@Param("direction") int direction, @Param("onBusStationNo") int onBusStationNo);

	BaseStation getStationByStationIdAndCityCode(@Param("stationId")Integer stationId, @Param("cityCode")String cityCode);
	 
}