/**
* <p>Title: QueryController.java</p>
* <p>Copyright: Copyright (c) 2016</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.custom.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lantaiyuan.ebus.custom.model.CheckDataResult;
import com.lantaiyuan.ebus.custom.service.BaseRouteServiceI;
/**
 * 
* @Title: CheckDataController.java
* @Package com.lantaiyuan.ebus.custom.controller
* @Description: 
* @author yangyang   
* @date 2017年1月18日 上午10:02:48
* @version v1.0
 */
@RestController
@RequestMapping("/checkData")
public class CheckDataController extends BasicController{
	@Resource
	private BaseRouteServiceI baseRouteService;
	
	@GetMapping(value = "/all")
	public Json checkAll () {
		List<CheckDataResult> list = new ArrayList<>();
		Set<String> repeatedRelRouteStation = baseRouteService.findErrorData();
		list.add(new CheckDataResult(repeatedRelRouteStation, "重复的线站关系，返回结构为routeId:direction:stationId:cityCode"));
		List<String> routesWithoutRelRouteStation = baseRouteService.findErrorRoutes();
		list.add(new CheckDataResult(routesWithoutRelRouteStation, "没有线站关系的线路，返回结构为routeId:direction:cityCode"));
		List<String> missingStation = baseRouteService.findErrorStationNo();
		list.add(new CheckDataResult(missingStation, "站序有问题的线站关系，返回结构为routeId:direction:cityCode"));
		Set<String> repeatedStation = baseRouteService.findDuplicatedStations();
		list.add(new CheckDataResult(repeatedStation, "重复的站点，返回结构为stationId:cityCode"));
		List<String> stationWithoutRelRouteStation = baseRouteService.stationWithOutRoutes();
		list.add(new CheckDataResult(stationWithoutRelRouteStation, "没有线路经过的站点，返回结构为stationId:cityCode"));
		Set<String> repeatedAssistStation = baseRouteService.findDuplicateAssistStations();
		list.add(new CheckDataResult(repeatedAssistStation, "重复的辅助坐标，返回结构为routeId:direction:cityCode"));
		Set<String> repeatedRelRouteBus = baseRouteService.findDuplicateRelRouteBus();
		list.add(new CheckDataResult(repeatedRelRouteBus, "重复的线车关系，返回结构为vehicleId:cityCode"));
		Set<String> repeatedBus = baseRouteService.findDuplicateBus();
		list.add(new CheckDataResult(repeatedBus, "重复的车，返回结构为vehicleId:cityCode"));
		Set<String> repeatedRoute = baseRouteService.findDuplicateRoute();
		list.add(new CheckDataResult(repeatedRoute, "重复的线路，返回结构为routeId:direction:cityCode"));
		if(CollectionUtils.isEmpty(repeatedRoute)) {
			List<String> checkRouteReversal = baseRouteService.checkRouteReversal();
			list.add(new CheckDataResult(checkRouteReversal, "需要更改的线路换向，返回结构为routeId:cityCode"));
		}else {
			list.add(new CheckDataResult(Collections.emptyList(), "需要更改的线路换向无法检测，请先完成重复线路去重。"));
		}
	    return setSimpleSuccess(list); 
	}
	
	
	/**
	 * 找出rel_route_station中的错误数据
	 * @auther yangyang
	 */
	@GetMapping(value = "/errorData")
	public Json errorData () {// 找出重复的线站关系 rel_route_station
	    return setSimpleSuccess(baseRouteService.findErrorData()); 
	}
	
	@GetMapping(value = "/routesWithoutRelRouteStation")
	public Json routesWithoutRelRouteStation () {// 找出没有线站关系的线路
		return setSimpleSuccess(baseRouteService.findErrorRoutes()); 
	}
	
	@GetMapping(value = "/duplicateStations")
	public Json duplicateStations () {// 找出重复的站点 base_station
		return setSimpleSuccess(baseRouteService.findDuplicatedStations()); 
	}
	
	@GetMapping(value = "/duplicateAssistStations")
	public Json duplicateAssistStations () {// 找出重复的辅助坐标 rel_route_assist_station
		return setSimpleSuccess(baseRouteService.findDuplicateAssistStations()); 
	}
	
	@GetMapping(value = "/duplicateRelRouteBus")
	public Json duplicateRelRouteBus () {// 找出重复的线车关系 rel_route_bus
		return setSimpleSuccess(baseRouteService.findDuplicateRelRouteBus()); 
	}
	
	@GetMapping(value = "/duplicateBus")
	public Json duplicateBus () {// 找出重复车 base_bus
		return setSimpleSuccess(baseRouteService.findDuplicateBus()); 
	}
	
	@GetMapping(value = "/duplicateRoute")
	public Json duplicateRoute () {// 找出重复线路 base_route
		return setSimpleSuccess(baseRouteService.findDuplicateRoute()); 
	}
	
	@GetMapping(value = "/checkRouteReversal")
	public Json checkRouteReversal () {// 线路换向是否需要更改 base_route
		return setSimpleSuccess(baseRouteService.checkRouteReversal()); 
	}
	
}
