package com.lantaiyuan.ebus.oauthlogin.controller;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.response.AlipayOpenAuthTokenAppQueryResponse;
import com.alipay.api.response.AlipayOpenAuthTokenAppResponse;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.lantaiyuan.ebus.oauthlogin.model.enummodel.AlipayGrantTypeEnum;
import com.lantaiyuan.ebus.oauthlogin.service.AlipayServiceI;

@RestController
@RequestMapping("/alipay")
public class AlipayController extends BasicController{
	
	@Resource
	private AlipayServiceI alipayService;
	
	/**
	 * 使用用户的授权码获取access token
	 * 
	 * @author yangyang
	 * @param app_id
	 * @param source
	 * @param scope
	 * @param auth_code
	 * @return
	 */
	@GetMapping("/accessToken/user")
	public Json authtoken(String app_id, String source,String scope, String auth_code) {
		AlipaySystemOauthTokenResponse response = alipayService.userAccessToken(auth_code, null, AlipayGrantTypeEnum.AUTHORIZATION_CODE);
		return StringUtils.isEmpty(response) ? setFailed() : setSimpleSuccess(response);
	}
	
	/**
	 * 使用accessToken获取用户信息
	 * 
	 * @author yangyang
	 * @param accessToken
	 * @return
	 */
	@GetMapping("/userInfo/{accessToken}")
	public Json UserInfo(@PathVariable String accessToken) {
		AlipayUserInfoShareResponse response = alipayService.userInfo(accessToken);
		return StringUtils.isEmpty(response) ? setFailed() : setSimpleSuccess(response);
	}
	
	/**
	 * 第三方应用授权
	 * 使用app_auth_code获取app_auth_token
	 * 
	 * 参数没有遵循驼峰命名法：参数为支付宝回调附在url后面的
	 * @author yangyang
	 * @param app_id
	 * @param source
	 * @param app_auth_code
	 * @return
	 */
	@GetMapping("/authToken/3rd")
	public Json thirdAuthtoken(String app_id, String source,String app_auth_code) {
		AlipayOpenAuthTokenAppResponse response = alipayService.thirdAuthToken(app_auth_code);
		return StringUtils.isEmpty(response) ? setFailed() : setSimpleSuccess(response);
	}
	
	/**
	 * 第三方应用授权
	 * 使用app_auth_token查看具体有哪些授权信息
	 * 
	 * @author yangyang
	 * @param authToken
	 * @return
	 */
	@GetMapping("/authToken/authInfo/3rd/{authToken}")
	public Json thirdAuthTokenRelevantInfo(@PathVariable String authToken) {
		AlipayOpenAuthTokenAppQueryResponse response = alipayService.queryThirdAuthTokenInfo(authToken);
		return StringUtils.isEmpty(response) ? setFailed() : setSimpleSuccess(response);
	}
}
