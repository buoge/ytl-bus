package com.lantaiyuan.ebus.custom.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;
import com.lantaiyuan.ebus.custom.model.SysUser;
import com.lantaiyuan.ebus.custom.service.BaseRouteServiceI;

/**
 * 描述:实时公交线路对外访问接口
 * 作者:温海金
 * 最后更改时间:下午6:03:25
 */
@RestController
@RequestMapping("/baseRoute")
public class BaseRouteController extends BasicController{
	@Resource
	private BaseRouteServiceI baseRouteService;
	
	/**
	 * 功能描述:根据名称模糊匹配线路信息
	 * 作者:温海金
	 * 参数说明:这边q表示线路名称，应前端要求，用q表示
	 * 最后更改时间 : 2017年5月4日 下午6:04:47
	 */
	@GetMapping(value = "/routes")
	public Object getRoutesByRouteName(@RequestParam(defaultValue = "") String q, HttpSession session) {
		SysUser user = (SysUser)session.getAttribute(SysGlobalConstants.USER_SESSION_KEY);
		return setSimpleSuccess(baseRouteService.getRoutesByRouteName(q, user));
	}
}
