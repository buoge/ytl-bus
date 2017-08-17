package com.lantaiyuan.ebus.custom.controller;

import javax.annotation.Resource;
import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lantaiyuan.ebus.custom.model.StatisticsQueryModel;
import com.lantaiyuan.ebus.custom.service.StatisticsServiceI;
import com.wordnik.swagger.annotations.ApiOperation;

/** 
  * @Title: StatisticsController.java
  * @Package com.lantaiyuan.ebus.custom.controller
  * @Description: 
  * @author yangyang   
  * @date 2017年2月17日 下午5:21:36
  * @version v1.0  
 */
@RestController
@RequestMapping("/stat")
public class StatisticsController extends BasicController {
	
	@Resource
	private StatisticsServiceI statisticsService;
	
	@ApiOperation(value = "用户统计")
	@PostMapping(value = "/user")
	public Json user() {
		return setSimpleSuccess(statisticsService.userStatistics());
	}
	
	@ApiOperation(value = "趋势统计")
	@PostMapping(value = "/trend")
	public Json trend(StatisticsQueryModel model) {
		return setSimpleSuccess(statisticsService.trendStatistics(model));
	}
	
	@ApiOperation(value = "城市OD导向图")
	@PostMapping(value = "/od")
	public Json od(String cityCode) {
		return setSimpleSuccess(statisticsService.odMap(cityCode));
	}
	
	
}
