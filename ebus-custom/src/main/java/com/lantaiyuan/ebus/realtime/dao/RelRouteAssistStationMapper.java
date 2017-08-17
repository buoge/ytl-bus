package com.lantaiyuan.ebus.realtime.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.realtime.model.RelRouteAssistStation;
import com.lantaiyuan.ebus.realtime.model.RelRouteAssistStationQueryModel;

/**
 * 
* @Title: RelRouteAssistStationMapper.java
* @Package com.lantaiyuan.ebus.custom.dao
* @Description: 
* @author yangyang   
* @date 2016年12月21日 下午6:44:42
* @version v1.0
 */
public interface RelRouteAssistStationMapper extends BaseDAO<RelRouteAssistStation, RelRouteAssistStationQueryModel>{

	RelRouteAssistStation getRelRouteAssitStation(@Param("routeId")String routeId, @Param("direction")int direction, 
			@Param("cityCode")String cityCode);

	List<RelRouteAssistStation> getAllRelRouteStations();
   
}