package com.lantaiyuan.ebus.custom.dao;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import com.lantaiyuan.ebus.custom.model.RelRouteStation;
import com.lantaiyuan.ebus.custom.model.RelRouteStationQueryModel;
import com.lantaiyuan.ebus.custom.model.UpAndDownStation;
import com.lantaiyuan.ebus.custom.model.mytrail.StationInMyTrail;
import com.lantaiyuan.ebus.realtime.model.RouteSimpleInfo;

/**
 * 
 * @Title: RelRouteStationMapper.java
 * @Package com.lantaiyuan.ebus.custom.dao
 * @Description:
 * @author yangyang
 * @date 2016年12月21日 下午5:56:07
 * @version v1.0
 */
public interface RelRouteStationMapper extends BaseDAO<RelRouteStation, RelRouteStationQueryModel> {

	List<Integer> getStationsIdByRouteId(@Param("routeId") String routeId, @Param("direction") int direction,
			@Param("cityCode") String cityCode);

	List<RouteSimpleInfo> queryRoutesIdByStationId(@Param("stationId") String stationId,
			@Param("cityCode") String cityCode);

	List<RelRouteStation> getCityRelRouteStation(@Param("routeId") String routeId, @Param("direction") int direction,
			@Param("cityCode") String cityCode);

	int getStationNo(@Param("routeId") String routeId, @Param("stationId") int stationId,
			@Param("direction") int direction, @Param("cityCode") String cityCode);
	
	List<RelRouteStation> getAllRelRouteStations();
	
	List<RelRouteStation> getStationRoutes(@Param("stationId") int stationId, 
			@Param("cityCode") String cityCode);
	/**
	 * 功能描述:获取两个站序中间的所有站点关系
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月25日 上午10:21:06
	 */
	List<StationInMyTrail> getRelRouteStationBetweenTwoStations(@Param("routeId")String routeId, @Param("direction")int direction, @Param("cityCode")String cityCode, @Param("startStationNo")int startStationNo, @Param("endStationNo")int endStationNo);

	/**
	 * 功能描述:得到最近的站点
	 * 作者:温海金
	 * 最后更改时间 : 2017年6月29日 下午2:22:01
	 */
	UpAndDownStation getNearestStation(@Param("routeid") String routeid, @Param("direction") Integer direction, @Param("citycode") String citycode, @Param("currentlongitude") BigDecimal currentlongitude, @Param("currentlatitude") BigDecimal currentlatitude);

}