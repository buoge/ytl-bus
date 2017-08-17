package com.lantaiyuan.ebus.oauthlogin.service.impl;

import org.lanqiao.ssm.common.pay.alipay.core.AlipayClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayOpenAuthTokenAppQueryRequest;
import com.alipay.api.request.AlipayOpenAuthTokenAppRequest;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipayOpenAuthTokenAppQueryResponse;
import com.alipay.api.response.AlipayOpenAuthTokenAppResponse;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.lantaiyuan.ebus.oauthlogin.model.enummodel.AlipayGrantTypeEnum;
import com.lantaiyuan.ebus.oauthlogin.service.AlipayServiceI;

@Service("alipay")
public class AlipayServiceImpl implements AlipayServiceI {

	private static Logger logger = LoggerFactory.getLogger(AlipayServiceImpl.class);
	private static final AlipayClient alipayClient = AlipayClientFactory.getAlipayClientInstance();
//	private static final AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",
//			Constants.ALIPAY_APP_ID, Constants.APP_PRIVATE_KEY, "json", "utf-8", Constants.ALIPAY_PUBLIC_KEY, "RSA2");

	/**
	 * 使用用户的授权码换取用户的access token
	 * 
	 * 
	 * @author yangyang
	 * @param authCode
	 *            未过期使用authorization code，与refreshToken二选一
	 * @param refreshToken
	 *            过期使用refresh code换取新的，与authCode二选一
	 * @param grantTypeEnum
	 * @return
	 */
	@Override
	public AlipaySystemOauthTokenResponse userAccessToken(String authCode, String refreshToken,
			AlipayGrantTypeEnum grantTypeEnum) {
		AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
		if (grantTypeEnum == AlipayGrantTypeEnum.AUTHORIZATION_CODE) {
			request.setCode(authCode);
		} else {
			request.setRefreshToken(refreshToken);
		}
		request.setGrantType(grantTypeEnum.desc());
		AlipaySystemOauthTokenResponse oauthTokenResponse = null;
		try {
			oauthTokenResponse = alipayClient.execute(request);
		} catch (AlipayApiException e) {
			logger.error("支付宝获取用户access token出错", e);
		}
		return oauthTokenResponse;
	}

	/**
	 * 使用用户的access token获取用户信息
	 * 
	 * 
	 * @author yangyang
	 * @param accessToken
	 * @return
	 */
	@Override
	public AlipayUserInfoShareResponse userInfo(String accessToken) {
		AlipayUserInfoShareRequest request = new AlipayUserInfoShareRequest();
		AlipayUserInfoShareResponse userinfoShareResponse = null;
		try {
			userinfoShareResponse = alipayClient.execute(request, accessToken);
		} catch (AlipayApiException e) {
			// 处理异常
			logger.error("支付宝使用access token获取用户信息出错", e);
		}
		return userinfoShareResponse;
	}

	/**
	 * 第三方应用授权 使用app_auth_code换取app_auth_token
	 * 
	 * @author yangyang
	 * @param authCode
	 *            授权码
	 * @return
	 */
	@Override
	public AlipayOpenAuthTokenAppResponse thirdAuthToken(String authCode) {
		AlipayOpenAuthTokenAppRequest request = new AlipayOpenAuthTokenAppRequest();
		request.setBizContent("{\"grant_type\":\"authorization_code\",\"code\":\"" + authCode + "\"}");
		AlipayOpenAuthTokenAppResponse response = null;
		try {
			response = alipayClient.execute(request);
		} catch (AlipayApiException e) {
			logger.error("支付宝使用app_auth_code换取app_auth_token出错", e);
		}
		return response;
	}

	/**
	 * 第三方应用授权 查询某个app_auth_token对应的授权信息
	 * 
	 * @author yangyang
	 * @param authToken
	 * @return
	 */
	@Override
	public AlipayOpenAuthTokenAppQueryResponse queryThirdAuthTokenInfo(String authToken) {
		AlipayOpenAuthTokenAppQueryRequest request = new AlipayOpenAuthTokenAppQueryRequest();
		request.setBizContent("{\"app_auth_token\":\"" + authToken + "\"}");
		AlipayOpenAuthTokenAppQueryResponse response = null;
		try {
			response = alipayClient.execute(request);
		} catch (AlipayApiException e) {
			logger.error("查询app_auth_token对应授权信息出错", e);
		}
		return response;
	}

}
