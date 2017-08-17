package com.lantaiyuan.ebus.custom.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.custom.model.BaseStation;
import com.lantaiyuan.ebus.custom.model.BaseStationQueryModel;
import com.lantaiyuan.ebus.custom.model.StationNameInfo;

public interface BaseStationMapper extends BaseDAO<BaseStation, BaseStationQueryModel> {

	BaseStation queryStationByName(@Param("stationName") String stationName, @Param("cityCode") String cityCode);

	List<StationNameInfo> queryStationList(@Param("stationName") String stationName,
			@Param("cityCode") String cityCode);

	List<BaseStation> getStationByName(@Param("stationName") String stationName, @Param("cityCode") String cityCode);

	BaseStation getStationById(@Param("stationId") String stationId, @Param("cityCode") String cityCode);

	List<BaseStation> getStationsByIds( @Param("routeId") String routeId,
			@Param("cityCode") String cityCode, @Param("direction") int direction);

	/**
	 * 功能描述:得到附近的所有站点信息 作者:温海金 最后更改时间 : 2016年12月21日 下午6:23:15
	 */
	List<BaseStation> getNearStations(@Param(value = "currentStation") BaseStation currentStation,
			@Param(value = "distance") Integer distance);

	BaseStation getStationByStationId(@Param("stationId") String stationId, @Param("cityCode") String cityCod);
	
	/**
	 * 功能描述:根据车票id、专线线路方向，用户上车站点的站序，查询上车地点的信息  By YvanTan
	 */
	BaseStation queryStationByTicketIdAndStationNo(@Param("ticketId") String ticketId,@Param("direction") int direction, @Param("onBusStationNo") int onBusStationNo);
	List<BaseStation> getCityStations(@Param("cityCode")String cityCode,@Param("routeId") String routeId, 
			 @Param("direction") int direction);

	List<BaseStation> getAllStations();

	/**
	 * 根据站点id和citycode查找站点信息
	 * @auther yangyang
	 * @param model
	 * @return
	 */
	List<BaseStation> queryStationsByStationIdsAndCityCodes(@Param("model")List<BaseStationQueryModel> model);

	/**
	 * 
	 */
	List<BaseStation> getStationByCityCode(@Param("cityCode")String cityCode);

	/**
	 * 说明：查询某个城市，站点表中站点名称出现次数大于times的站点名称和次数
	 * @param cityCode
	 * @param times
	 */
	List<Map<String, String>> queryTimesOfStation(@Param("cityCode")String cityCode, @Param("times")int times);

	/**
	 * 说明：查询某个城市，站点表中站点名称出现次数大于times的站点详情
	 * @param cityCode
	 * @param times
	 */
	List<BaseStation> queryStationDetail(@Param("cityCode")String cityCode, @Param("times")int times);
	

}