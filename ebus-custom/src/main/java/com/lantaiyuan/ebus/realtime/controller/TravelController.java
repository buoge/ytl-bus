package com.lantaiyuan.ebus.realtime.controller;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lantaiyuan.ebus.custom.service.BaseRouteServiceI;
import com.lantaiyuan.ebus.custom.service.BaseStationServiceI;
import com.lantaiyuan.ebus.realtime.model.RealTimeQueryModel;
import com.lantaiyuan.ebus.realtime.model.RouteDetailQueryModel;
import com.wordnik.swagger.annotations.ApiOperation;

/**
 * @Title: BaseRouteController.java
 * @Package com.lantaiyuan.ebus.custom.controller
 * @Description:
 * @author yangyang
 * @date 2016年12月21日 下午5:37:51
 * @version v1.0
 */
@RestController
@RequestMapping("/travel")
public class TravelController extends BasicController {
	@Resource
	private BaseRouteServiceI baseRouteService;

	@Resource
	private BaseStationServiceI baseStationService;

	/**
	 * 查看线路详情
	 * 
	 * @param routeId
	 *            线路gprsId
	 * @param longitude
	 *            经度
	 * @param latitude
	 *            纬度
	 * @param direction
	 *            上下行
	 * @param cityCode
	 *            城市编码
	 * @return
	 */
	@ApiOperation(value = "线路详情")
	@GetMapping(value = "/routeDetail")
	public Json getStationsByRouteId(@Valid RouteDetailQueryModel routeDetail) {
		return setSimpleSuccess(baseRouteService.getRouteDetail(routeDetail));
	}

	/**
	 * 获取实时公交信息
	 * 
	 * @auther yangyang
	 */
	@ApiOperation(value = "实时信息")
	@GetMapping(value = "/realTime")
	public Json getBusRealTimeInfo(@Valid RealTimeQueryModel realTime) {
		return setSimpleSuccess(baseStationService.getRealTimeInfo(realTime));
	}

	@ApiOperation(value = "普通公交、已开通专线距用户起点站最近一辆车实时信息")
	@GetMapping(value = "/realTime/nearestBus")
	public Json getNearestBusRealTimeInfo(@Valid RealTimeQueryModel realTime) {
		return setSimpleSuccess(baseStationService.getNearestBusRealTime(realTime));
	}

	/**
	 * 获取线路详情和实时信息
	 * @author yangyang
	 * @param routeDetail
	 * @return
	 */
	@GetMapping(value = "/routeDetail/realTime")
	public Json getRouteAndNearestBusInfo(@Valid RouteDetailQueryModel routeDetail) {
		return setSimpleSuccess(baseStationService.getRouteDetailAndRealTime(routeDetail));
	}

}
