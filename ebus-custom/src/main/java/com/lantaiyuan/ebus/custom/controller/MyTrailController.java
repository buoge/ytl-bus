/**
* <p>Title: MySettingsController.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.custom.controller;

import java.math.BigDecimal;

import javax.annotation.Resource;
import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.lantaiyuan.ebus.custom.service.MySettingsServiceI;

/**
 * 描述:我的行程
 * 作者:温海金
 * 最后更改时间:上午11:37:13
 */
@RestController
@RequestMapping("/myTrail")
public class MyTrailController extends BasicController{
	@Resource
	private MySettingsServiceI mySettingsService;
	
	/**
	 * 功能描述:根据用户Id查看我的行程列表
	 * 作者:温海金
	 * 最后更改时间 : 2017年2月23日 下午5:08:39
	 */
	@GetMapping(value = "/getMyTrailByUserId/{userId}")
	public Json getMyTrailByUserId(@PathVariable Integer userId) {
		return setSimpleSuccess(mySettingsService.selectByUserId(userId));
	}
	
	/**
	 * 获取我的行程
	 * 
	 * @param request
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/myTrailById")
	public Json getMyTrailById(@RequestParam(value = "id", required = false) String id) {
		return setSimpleSuccess(mySettingsService.getMyTrailById(id));
	}
	
	/**
	 * 获取我的行程
	 * 
	 * @param request
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/myTrailDetail/{entityId}")
	public Json myTrailDetail(@PathVariable  String entityId) {
		return setSimpleSuccess(mySettingsService.getMyTrailDetail(entityId));
	}

}
