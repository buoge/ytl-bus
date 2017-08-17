package com.lantaiyuan.ebus.custom.controller;


import javax.annotation.Resource;

import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lantaiyuan.ebus.custom.service.WeatherServiceI;

/**
 * 描述:天气信息控制器
 * 作者:温海金 
 * 最后更改时间:下午3:36:16
 */
@RestController
@RequestMapping("/weather")
public class WeatherController extends BasicController {

	@Resource
	private WeatherServiceI weatherService;

	/**
	 * 功能描述:查看心知天气情况
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月18日 下午4:38:22
	 */
	@GetMapping(value = "/query")
	public Json query(String cityName, @RequestParam(defaultValue = "-1") String userId) {
		return setSimpleSuccess(weatherService.getSeniverseWeatherAndNoticeHistory(cityName, userId));
	}
	
}
