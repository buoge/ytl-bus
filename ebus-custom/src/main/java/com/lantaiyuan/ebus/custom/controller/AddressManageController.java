/**
* <p>Title: FavoriteController.java</p>
* <p>Copyright: Copyright (c) 2016</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.custom.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lantaiyuan.ebus.custom.model.UserAddressSetting;
import com.lantaiyuan.ebus.custom.service.AddressManageServiceI;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/***
 * 
* <p>Title: AddressManageController</p>
* <p>Description: 地址管理控制器</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年6月8日 下午3:09:13
 */
@RestController
@RequestMapping("/addressManage")
public class AddressManageController extends BasicController{
	@Resource
	private AddressManageServiceI addressManageService;
	
	@ApiOperation(value = "根据用户输入userId查询所有地址管理信息  返回json")
	@GetMapping(value = "/find" )
	public Json getAddressManageList(@ApiParam(value = "userid") @RequestParam Integer userid,@ApiParam(value = "citycode") @RequestParam String citycode) {
		 return setSimpleSuccess(addressManageService.findEntityByUserIdAndCityCode(userid, citycode));
	}
	
	@ApiOperation(value = "新增指定类别地址 返回json")
	@GetMapping(value = "/addition" )
	public Json add(@Valid UserAddressSetting UserAddressSetting) {
		return addressManageService.saveOrUpdate(UserAddressSetting) ? setSimpleSuccess() : setFailed("新增或修改失败！");
	}
}
