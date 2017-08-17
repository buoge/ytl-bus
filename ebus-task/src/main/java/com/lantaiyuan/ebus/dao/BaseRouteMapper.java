package com.lantaiyuan.ebus.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.model.BaseRoute;
import com.lantaiyuan.ebus.model.BaseRouteQueryModel;

@Mapper
public interface BaseRouteMapper extends BaseDAO<BaseRoute, BaseRouteQueryModel>{

	String getRouteNo(@Param("cityCode")String cityCode, @Param("direction")int direction, 
			@Param("routeId")String routeId);
	
}