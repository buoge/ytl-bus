package com.lantaiyuan.ebus.custom.controller;

import com.lantaiyuan.ebus.custom.service.CarpoolOrderServiceI;
import com.lantaiyuan.ebus.custom.service.CarpoolRouteServiceI;
import com.lantaiyuan.ebus.realtime.model.BusDesc;
import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 拼车
 * 
 * @author yangyang
 * @date 2017年6月14日 上午10:32:30
 *
 */
@RestController
@RequestMapping("/carpool/dynamic")
public class CarpoolDynamicController extends BasicController {

	@Resource
	private CarpoolOrderServiceI carpoolOrderService;
	
	@Resource
	private CarpoolRouteServiceI carpoolRouteService;

	/**
	 * 拼车动态
	 * 
	 * @author yangyang
	 * @param orderNo
	 * @param userLon
	 * @param userLat
	 * @return
	 */
	@GetMapping(value = "/user/{userLon}/{userLat}/{orderNo}")
	public Json carpoolDynamic(@PathVariable String orderNo, @PathVariable double userLat,
			@PathVariable double userLon) {
		return setSimpleSuccess(carpoolOrderService.getCarpoolDynamics(orderNo, userLon, userLat));
	}

	/**
	 * 拼车线路详情
	 * @author yangyang
	 * @param carpoolRouteId
	 * @return
	 */
	@GetMapping(value = "/route/{userLon}/{userLat}/{carpoolRouteId}")
	public Json carpoolRoute(@PathVariable String carpoolRouteId,@PathVariable double userLat,
			@PathVariable double userLon) {
		return setSimpleSuccess(carpoolRouteService.carpoolRouteDetail(carpoolRouteId, userLon, userLat));
	}

	/**
	 * 拼车 
	 * 车辆实时信息 由于还不知道会如何存放实时信息，暂时先这样处理 TODO
	 * 
	 * @author yangyang
	 * @param carpoolRouteId
	 * @param userStationNo
	 * @return
	 */
	@GetMapping(value = "/bus/{carpoolRouteId}/{userStationNo}")
	public Json bus(@PathVariable String carpoolRouteId, @PathVariable Integer userStationNo) {
		return setSimpleSuccess(new BusDesc());
	}

}
