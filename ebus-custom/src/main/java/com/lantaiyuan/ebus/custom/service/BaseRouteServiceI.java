package com.lantaiyuan.ebus.custom.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import org.lanqiao.ssm.common.core.service.BaseServiceI;

import com.lantaiyuan.ebus.custom.model.AllLines;
import com.lantaiyuan.ebus.custom.model.AllRoutesVo;
import com.lantaiyuan.ebus.custom.model.BaseRoute;
import com.lantaiyuan.ebus.custom.model.BaseRouteQueryModel;
import com.lantaiyuan.ebus.custom.model.BaseStation;
import com.lantaiyuan.ebus.custom.model.BusNumInfo;
import com.lantaiyuan.ebus.custom.model.GeneralRoute;
import com.lantaiyuan.ebus.custom.model.SysUser;
import com.lantaiyuan.ebus.realtime.model.MapPath;
import com.lantaiyuan.ebus.realtime.model.RealTime;
import com.lantaiyuan.ebus.realtime.model.RouteDetail;
import com.lantaiyuan.ebus.realtime.model.RouteDetailQueryModel;
import com.lantaiyuan.ebus.realtime.model.RouteInBaseLine;
import com.lantaiyuan.ebus.realtime.model.RouteSimpleInfo;
import com.lantaiyuan.ebus.realtime.model.RouteStation;
import com.lantaiyuan.ebus.realtime.model.SimpleRouteCustom;

public interface BaseRouteServiceI extends BaseServiceI<BaseRoute, BaseRouteQueryModel> {

	List<BusNumInfo> queryBusNumList(String busnum, String citycode);

	List<RouteInBaseLine> getRouteByName(String routeName, String cityCode,int decideSeason);

	RouteStation getRouteAndStationByName(String name, String cityCode);
	
	List<RouteInBaseLine> getRoutesByAudioInfo(String routeName, String cityCode);

	List<BaseRoute> getRoutesByIds(List<RouteSimpleInfo> routeSimple);

	RouteDetail getRouteDetail(RouteDetailQueryModel routeDetail);
	
	List<BaseRoute> getRoutesByStationId(String stationId,String cityCode,int decideSeason);
	
	List<RouteInBaseLine> queryRoutesByStationIdAndStationName(String stationId,String stationName,String cityCode, int decideSeason);

	Set<String> findErrorData();

	List<String> findErrorRoutes();

	Set<String> findDuplicatedStations();

	Set<String> findDuplicateAssistStations();

	Set<String> findDuplicateRelRouteBus();

	Set<String> findDuplicateBus();

	Set<String> findDuplicateRoute();

	List<String> checkRouteReversal();

	List<String> stationWithOutRoutes();

	List<String> findErrorStationNo();

	void correctBusLonAndLan(List<RealTime> carlist, MapPath mapPath);

	MapPath processMapPath(String routeId, Integer direction, String cityCode);

	BaseRoute getRouteByIdAndDirection(String citycode, String routeid, Integer direction);

	List<RouteInBaseLine> getRoutesByRouteName(String routeName, SysUser sysUser);
	
	//语音接口精确查询线路
	SimpleRouteCustom getRoutesByKeywordNumber(String keyword, String cityCode);

	/**
	 * 功能描述:查询符合起始点经纬度范围内乘车方案的人民公交
	 * 作者:温海金
	 * 最后更改时间 : 2017年6月8日 下午5:29:05
	 */
	List<GeneralRoute> findRoutesByStartAndDistinctPlace(BigDecimal startlongitude, BigDecimal startlatitude, BigDecimal endlongitude, BigDecimal endlatitude, String citycode);
	/**
	 * 功能描述:根据起始点经纬度查询所有公交路线
	 * 作者:温海金
	 * 最后更改时间 : 2017年6月8日 下午6:12:12
	 * @param userid 
	 */
	AllRoutesVo findAllRoutesByStartAndDistinctPlace(BigDecimal startlongitude, BigDecimal startlatitude, BigDecimal endlongitude, BigDecimal endlatitude, String citycode);

	/**
	 * 功能描述:根据起点信息查询经过当前位置的所有路线（包括人民公交，专线，拼车线路）
	 * 作者:温海金
	 * 最后更改时间 : 2017年7月17日 下午6:00:13
	 */
	AllLines findAllLinesByCurrentLocation(BigDecimal startlongitude, BigDecimal startlatitude, String citycode);

	List<BaseRoute> findSpecialLines(String cityCode, Integer routeType);
}
