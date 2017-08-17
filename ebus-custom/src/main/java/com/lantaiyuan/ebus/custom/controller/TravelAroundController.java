package com.lantaiyuan.ebus.custom.controller;

import javax.annotation.Resource;
import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.lantaiyuan.ebus.custom.service.TickcetSchedualServiceI;
import com.lantaiyuan.ebus.custom.service.TravelAroundServiceI;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 
  * @ClassName: TravelAroundController
  * @Description: 周边游控制器
  * @author Yuan.Tan
  * @date 2017年7月18日 下午3:16:50
  *
 */
@RestController
@RequestMapping("/travelAround")
public class TravelAroundController extends BasicController   {
	@Resource
	private TravelAroundServiceI travelAroundService;
	
	/**
	  * queryTravelList(查某城市下的基本信息)
	 */
	@ApiOperation(value = "查某城市下的基本信息  ")
	@GetMapping(value = "/list")
	public Json queryTravelList(@ApiParam(value = "城市编码") @RequestParam String cityCode) {
		return setSimpleSuccess(travelAroundService.queryTravelList(cityCode));
	}
	
	/**
	  * queryTravelDetail(查某周边游信息信息)
	 */
	@ApiOperation(value = "查某周边游信息信息 ")
	@GetMapping(value = "/detail")
	public Json queryTravelDetail(@ApiParam(value = "周边游ID") @RequestParam String id) {
		return setSimpleSuccess(travelAroundService.queryTravelDetail(id));
	}
}
