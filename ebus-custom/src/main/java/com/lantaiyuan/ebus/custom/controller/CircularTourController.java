/**
* <p>Title: FavoriteController.java</p>
* <p>Copyright: Copyright (c) 2016</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.custom.controller;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lantaiyuan.ebus.custom.model.CircularTour;
import com.lantaiyuan.ebus.custom.model.CircularTourQueryModel;
import com.lantaiyuan.ebus.custom.service.CircularTourServiceI;
import com.lantaiyuan.ebus.realtime.model.valid.First;
import com.lantaiyuan.ebus.realtime.model.valid.Second;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/***
 * 
* <p>Title: CircularTourController</p>
* <p>Description: 周边游控制器</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年6月12日 下午2:51:29
 */
@RestController
@RequestMapping("/circularTour")
public class CircularTourController extends BasicController{
	@Resource
	private CircularTourServiceI circleTourService;
	
	/**
	 * 分页查询周边游项目
	 * 
	 * @param page
	 * @param rows
	 */
	@GetMapping(value = "/list")
	public Json getFindProperty(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer rows, String cityCode) {
		CircularTourQueryModel model = new CircularTourQueryModel();
		model.getPageModel().setPageShow(rows);
		model.setCityCode(cityCode);
		return setSimpleSuccess(circleTourService.findEntityByPage(model, page));
	}
	
	@ApiOperation(value = "查询特定地址信息 返回json")
	@GetMapping(value = "/get" )
	public Json getAddressManageRecord(@ApiParam(value = "id") @RequestParam String id, @ApiParam(value = "cityCode") @RequestParam String cityCode) {
		return setSimpleSuccess(circleTourService.findEntityById(id, cityCode));
	}
	
	@ApiOperation(value = "新增周边游项目信息 返回json")
	@GetMapping(value = "/addition" )
	public Json add(@Validated({First.class}) CircularTour circularTour) {
		return circleTourService.save(circularTour) ? setSimpleSuccess() : setFailed();
	}
	
	@ApiOperation(value = "修改指定周边游项目信息 返回json")
	@GetMapping(value = "/revision" )
	public Json update(@Validated({Second.class}) CircularTour circularTour) {
		return circleTourService.update(circularTour) ? setSimpleSuccess() : setFailed();
	}

	@ApiOperation(value = "删除指定周边游项目信息 返回json")
	@GetMapping(value = "/deletion" )
	public Json delete(@ApiParam(value = "id") @RequestParam String id, @ApiParam(value = "cityCode") @RequestParam String cityCode) {		
		return circleTourService.delete(id, cityCode) ? setSimpleSuccess() : setFailed();
	}
	
}
