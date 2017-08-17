/**
* <p>Title: QueryController.java</p>
* <p>Copyright: Copyright (c) 2016</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.custom.controller;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lantaiyuan.ebus.custom.service.AppCustomServiceI;

/***
 * 
* @Title: AppCustomController.java 
* @Package com.lantaiyuan.ebus.custom.controller 
* @Description: 坐公交自定义需求controller 
* @author 刘浩 
* @date 2017年3月31日 下午4:31:17 
* @version V1.0
 */
@RestController
@RequestMapping("/customApp")
public class AppCustomController extends BasicController{
	@Resource
	private AppCustomServiceI appCustomService;
	
	/***
	 * 
	* <p>Title: routeIdStationsByCitycode</p>
	* <p>Description: 根据citycode获取所有routeId_direction基础数据</p>
	 */
	@GetMapping(value = "/routeIdStationsByCitycode")
	public Json routeIdStationsByCitycode (@RequestParam String citycode) {
	    return setSimpleSuccess(appCustomService.getRouteStationRelationsByCitycode(citycode)); 
	}
	
	@GetMapping(value = "/routeIdDirectionStationNoByCitycode")
	public Json routeIdDirectionStationNoByCitycode (String citycode) {
		return setSimpleSuccess(appCustomService.getRouteIdDirectionStationNoByCitycode(citycode)); 
	}
	
	/***
	 * 
	* <p>Title: allBusOfBB</p>
	* <p>Description: 获取蚌埠所有车辆基础数据</p>
	 */
	@GetMapping(value = "/allBusOfBB")
	public Json allBusOfBB () {
	    return setSimpleSuccess(appCustomService.selectAllBus()); 
	}
}
