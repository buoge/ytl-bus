package com.lantaiyuan.ebus.oauthlogin.service;

import com.alipay.api.response.AlipayOpenAuthTokenAppQueryResponse;
import com.alipay.api.response.AlipayOpenAuthTokenAppResponse;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.lantaiyuan.ebus.oauthlogin.model.enummodel.AlipayGrantTypeEnum;

public interface AlipayServiceI {


	AlipayOpenAuthTokenAppResponse thirdAuthToken(String code);

	AlipayOpenAuthTokenAppQueryResponse queryThirdAuthTokenInfo(String authToken);

	AlipaySystemOauthTokenResponse userAccessToken(String authCode, String refreshToken,
			AlipayGrantTypeEnum grantTypeEnum);

	AlipayUserInfoShareResponse userInfo(String accessToken);

}
