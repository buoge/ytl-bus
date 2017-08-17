package com.lantaiyuan.ebus.realtime.controller;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Range;
import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lantaiyuan.ebus.custom.model.enummodel.CMDEnum;
import com.lantaiyuan.ebus.custom.service.DataCollectServiceI;
import com.lantaiyuan.ebus.realtime.model.valid.First;
import com.lantaiyuan.ebus.realtime.model.valid.User;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * 
 * 
 * @Description: hibernate-validation验证测试类
 * 
 * @author wei.liu
 * 
 * @date 2016年12月23日 下午3:35:01
 * 
 * @version V1.0
 * 
 */
@RestController
public class ValidController extends BasicController {
	@Autowired
	DataCollectServiceI DataCollectService;

	@ApiOperation(value = "spring验证测试", httpMethod = "GET", notes = "显示用户")
	@RequestMapping(value = "/index/test2", method = RequestMethod.GET)
	public Json test2(@Validated User user) {
		return setSimpleSuccess(user);
	}

	@RequestMapping(value = "/index/test3", method = RequestMethod.GET)
	public String test3(
			@Range(min = 1, max = 9, message = "年级只能从1-9") @RequestParam(name = "grade", required = true) int grade,
			@Min(value = 1, message = "班级最小只能1") @Max(value = 99, message = "班级最大只能99") @RequestParam(name = "classroom", required = true) int classroom) {
		DataCollectService.handleDataCollection(CMDEnum.BUS_EVALUTION, "{}");
		return "" + grade + classroom;
	}

	@RequestMapping(value = "/index/test4", method = RequestMethod.GET)
	public Json test4(@Validated({ First.class }) User user) {
		return setSimpleSuccess(user);
	}
}