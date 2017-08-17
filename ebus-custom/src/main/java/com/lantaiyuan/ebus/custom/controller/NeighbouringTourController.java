/**
* <p>Title: FavoriteController.java</p>
* <p>Copyright: Copyright (c) 2016</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.custom.controller;

import java.util.UUID;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lantaiyuan.ebus.custom.model.neighbouringtour.TouristSettings;
import com.lantaiyuan.ebus.custom.model.travelaround.TravelAround;
import com.lantaiyuan.ebus.custom.model.travelaround.TravelAroundQueryModel;
import com.lantaiyuan.ebus.custom.service.NeighbouringTourServiceI;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/***
 * 
* <p>Title: NeighbouringTourController</p>
* <p>Description: 周边游控制器</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年7月17日 下午4:37:35
 */
@RestController
@RequestMapping("/neighbouringTour")
public class NeighbouringTourController extends BasicController{
	@Resource
	private NeighbouringTourServiceI neighbouringTourService;
	
	
	/***************************************************常用旅客模块***************************************/
	@ApiOperation(value = "根据用户输入userId查询所有常用旅客信息  返回json")
	@GetMapping(value = "/find" )
	public Json getAddressManageList(@ApiParam(value = "userid") @RequestParam @NotNull Integer userid,@ApiParam(value = "citycode") @RequestParam @NotBlank String citycode) {
		 return setSimpleSuccess(neighbouringTourService.findEntitiesByUserIdAndCityCode(userid, citycode));
	}
	
	@ApiOperation(value = "新增或修改常用旅客信息 返回json")
	@GetMapping(value = "/additionOrRevision" )
	public Json add(@Valid TouristSettings touristSettings) {
		return neighbouringTourService.saveOrUpdate(touristSettings) ? setSimpleSuccess() : setFailed("新增或修改失败！");
	}
	
	@ApiOperation(value = "删除常用旅客信息 返回json")
	@GetMapping(value = "/deletion" )
	public Json del(@ApiParam(value = "id") @RequestParam @NotBlank String id) {
		return neighbouringTourService.deleteByPrimaryKey(id) > 0 ? setSimpleSuccess() : setFailed("删除失败！");
	}
	
	/***************************************************web后端***************************************/
	@ApiOperation(value = "分页查询周边游项目  返回json")
	@GetMapping(value = "/list")
	public Json getByPage(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer rows, TravelAroundQueryModel model) {
		model.getPageModel().setPageShow(rows);
		return setSimpleSuccess(neighbouringTourService.findEntityByPage(model, page));
	}
	
	@ApiOperation(value = "根据主键id获取周边游项目 返回json")
	@GetMapping(value = "/get" )
	public Json getById(@ApiParam(value = "id") @RequestParam String id) {
		return setSimpleSuccess(neighbouringTourService.findTravelAroundById(id));
	}
	
	@ApiOperation(value = "新增周边游项目 返回json")
	@PostMapping(value = "/addTravel" )
//	public Json addTravel(HttpServletRequest request, @RequestBody TravelAround travelAround, @RequestParam(value = "files",required = false) MultipartFile[] files) {
	public Json addTravel(@RequestBody TravelAround travelAround) {
//		String fileUploadUrls = neighbouringTourService.getFilesUploadedPath(files);
//		travelAround.setPics(fileUploadUrls);
		travelAround.setId(UUID.randomUUID().toString());
		return neighbouringTourService.addTravelAround(travelAround) ? setSimpleSuccess() : setFailed("新增失败！");
	}
	
	@ApiOperation(value = "修改周边游项目 返回json")
	@PostMapping(value = "/updateTravel" )
	public Json updateTravel(@RequestBody TravelAround travelAround) {
		return neighbouringTourService.updateTravelAround(travelAround) ? setSimpleSuccess() : setFailed("修改失败！");
	}
	
	@ApiOperation(value = "删除周边游项目 返回json")
	@DeleteMapping(value = "/delTravel" )
	public Json deletion(@ApiParam(value = "id") @RequestParam String id) {
		return neighbouringTourService.delTravelById(id) ? setSimpleSuccess() : setFailed("删除失败！");
	}
	
	@ApiOperation(value = "获取当前城市专线线路 返回json")
	@GetMapping(value = "/specialLines" )
	public Json findSpecialLines(@ApiParam(value = "cityCode") @RequestParam String cityCode) {
		return setSimpleSuccess(neighbouringTourService.findSpecialLinesByCityCode(cityCode));
	}
}
