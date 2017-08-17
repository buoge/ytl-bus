package com.lantaiyuan.ebus.realtime.controller;

import javax.annotation.Resource;
import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lantaiyuan.ebus.realtime.model.AppUser;
import com.lantaiyuan.ebus.realtime.model.AppUserRegister;
import com.lantaiyuan.ebus.realtime.service.AppUserServiceI;
import com.wordnik.swagger.annotations.ApiOperation;

/**
  * @ClassName: AppUserController
  * Company:深圳市蓝泰源信息技术股份有限公司
  * @author Yuan.Tan
  * @date 2016年12月22日 下午2:05:40
 */
@RestController
@RequestMapping("/appUser")
public class AppUserController extends BasicController  {
	@Resource
	private AppUserServiceI appUserService;
	 
	@ApiOperation(value = "APP用户注册登录")
	@PostMapping(value = "/registerAndLogin" )
	public Json registerAndLogin(AppUserRegister appUserRegister) {
		return setSimpleSuccess(appUserService.registerAndLogin(appUserRegister));
	}
	
	@ApiOperation(value = "APP用户修改个人信息")
	@PostMapping(value = "/update" )
	public Json update(AppUserRegister appUserRegister) {
		return setSimpleSuccess(appUserService.update(appUserRegister));
	}
	
	@ApiOperation(value = "APP用户注销登录")
	@PostMapping(value = "/logout" )
	public Json logout(AppUserRegister appUserRegister) {
		return setSimpleSuccess(appUserService.logout(appUserRegister));
	}
	
	/**
	 * 用户修改个人信息，通过userId
	 * @auther yangyang
	 * @return
	 */
	@PostMapping(value = "/updateByUserId" )
	public Object updateByUserId(AppUser user) {
		int result = appUserService.updateByUserId(user);
		return result > 0 ? setSimpleSuccess() : setFailed();
	}
	
	/**
	 * 功能描述:保存用户对应的app
	 * 作者:温海金
	 * 最后更改时间 : 2017年2月20日 下午2:12:06
	 */
	@GetMapping(value = "/saveRegistrationId/{userId}/{registrationId}/{lastLoginSysType}")
	public Json saveRegistrationId(@PathVariable Integer userId, @PathVariable String registrationId, @PathVariable int lastLoginSysType) {
	    	appUserService.setRegistrationIdIfNotExist(userId, registrationId, lastLoginSysType);
		return setSimpleSuccess();
	}

}
