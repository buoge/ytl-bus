package com.lantaiyuan.ebus.service;


import org.lanqiao.ssm.common.core.service.BaseServiceI;

import com.lantaiyuan.ebus.model.BaseRoute;
import com.lantaiyuan.ebus.model.BaseRouteQueryModel;

public interface BaseRouteServiceI extends BaseServiceI<BaseRoute, BaseRouteQueryModel> {

	String getRouteNo(String routeId, int direction, String cityCode);

	
}
