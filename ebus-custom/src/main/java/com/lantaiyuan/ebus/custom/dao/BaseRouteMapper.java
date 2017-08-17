package com.lantaiyuan.ebus.custom.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.custom.model.BaseRoute;
import com.lantaiyuan.ebus.custom.model.BaseRouteQueryModel;
import com.lantaiyuan.ebus.custom.model.BusNumInfo;
import com.lantaiyuan.ebus.custom.model.TravelAroundRoute;
import com.lantaiyuan.ebus.realtime.model.RouteInBaseLine;
import com.lantaiyuan.ebus.realtime.model.RouteSimpleInfo;

public interface BaseRouteMapper extends BaseDAO<BaseRoute, BaseRouteQueryModel>{

	List<BusNumInfo> queryBusNumList(@Param("busnum")String busnum,@Param("citycode")String citycode);

	List<RouteInBaseLine> getRouteByName(@Param("routeName")String routeName,@Param("cityCode")String cityCode,@Param("season")int decideSeason);

	RouteInBaseLine getRouteByRouteId(@Param("routeId")String routeId, @Param("direction")int direction, 
			@Param("cityCode")String cityCode, @Param("season")int season);
	
	List<BaseRoute> queryRoutesByIds(@Param("routeSimpleInfo")List<RouteSimpleInfo> routesId,@Param("season")Integer season);

	List<BaseRoute> queryRoutesByStationId(@Param("stationId")String stationId, @Param("cityCode")String cityCode, @Param("season")int decideSeason);
	
	List<RouteInBaseLine> queryRoutesByStationIdAndStationName(@Param("stationId")String stationId,@Param("stationName")String stationName, @Param("cityCode")String cityCode, @Param("season")int decideSeason);
	
	List<RouteInBaseLine> getCityRoutes(@Param("cityCode")String cityCode,@Param("season")int season);

	List<RouteInBaseLine> getAllRoutes(@Param("season")int season);

	BaseRoute getRouteByIdAndDirection(@Param("cityCode")String cityCode, @Param("routeId")String routeId, @Param("direction")Integer direction);
	
	//根据线路关键字（数字）精确查询线路
	List<BaseRoute> getRoutesByKeywordNumber(@Param("cityCode")String cityCode, @Param("keyword")String keyword);

	/**
	 * 功能描述:查询符合起始点经纬度范围内乘车方案的人民公交
	 * 作者:温海金
	 * 最后更改时间 : 2017年6月8日 下午5:29:05
	 */
	List<BaseRoute> findRoutesByStartAndDistinctPlace(@Param("startlongitude")BigDecimal startlongitude, @Param("startlatitude")BigDecimal startlatitude, @Param("endlongitude")BigDecimal endlongitude, @Param("endlatitude")BigDecimal endlatitude,
			@Param("citycode")String citycode);
	
	/**
	 * 功能描述:根据起点信息查询经过当前位置的人民公交
	 * 作者:温海金
	 * 最后更改时间 : 2017年7月17日 下午5:52:59
	 */
	List<BaseRoute> findRoutesByCurrentPlace(@Param("startlongitude")BigDecimal startlongitude, @Param("startlatitude")BigDecimal startlatitude, @Param("citycode")String citycode);

	List<TravelAroundRoute> queryCustomList(Map<String, Object> params);
	
	/***
	 * 
	* <p>Title: selectByCityCode</p>
	* <p>Description: 根据cityCode和routeType查询当前城市专线信息</p>
	 */
	List<BaseRoute> selectByCityCode(@Param("cityCode")String cityCode, @Param("routeType")Integer routeType);
}