package com.lantaiyuan.ebus.oauthlogin.controller;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lantaiyuan.ebus.oauthlogin.model.WxAccessToken;
import com.lantaiyuan.ebus.oauthlogin.service.WxServiceI;

@RestController
@RequestMapping("/wx")
public class WxController extends BasicController {
	
	@Resource
	private WxServiceI wxService;

	/**
	 * 根据code获取access token等信息
	 * code:第三方通过code进行获取access_token的时候需要用到，code的超时时间为10分钟，
	 * 一个code只能成功换取一次access_token即失效。code的临时性和一次保障了微信授权登录的安全性。
	 * 第三方可通过使用https和state参数，进一步加强自身授权登录的安全性(授权在移动端完成)
	 * 
	 * @author yangyang
	 * @param code
	 * @return
	 */
	@GetMapping("/accesstoken/{code}")
	public Json accessToken(@PathVariable String code) {
		WxAccessToken wxAccessToken = wxService.accessToken(code);
		if (StringUtils.isEmpty(wxAccessToken)) {
			return setFailed("微信获取accessToken出错");
		}
		return setSimpleSuccess(wxAccessToken);
	}
	
	/**
	 * 通过refresh_token刷新access_token
	 * access_token有效期只有2h
	 * refresh_token有效期30d
	 * 如果refresh_token失效，需要用户重新授权
	 * @author yangyang
	 * @param userId
	 * @return
	 */
	@GetMapping("/refreshToken/{refreshCode}")
	public Json refreshToken(@PathVariable String refreshCode) {
		WxAccessToken wxAccessToken = wxService.refreshCode(refreshCode);
		if (StringUtils.isEmpty(wxAccessToken)) {
			return setFailed("微信刷新accessToken出错");
		}
		return setSimpleSuccess(wxAccessToken);
	}

}
