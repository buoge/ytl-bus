package com.lantaiyuan.ebus.oauthlogin.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lantaiyuan.ebus.common.weather.seniverse.RestTemplateSigleton;
import com.lantaiyuan.ebus.oauthlogin.constant.Constants;
import com.lantaiyuan.ebus.oauthlogin.model.WxAccessToken;
import com.lantaiyuan.ebus.oauthlogin.service.WxServiceI;

/**
 * 微信service
 * 
 * @author yangyang
 * @date 2017年6月19日 下午4:43:37
 *
 */
@Service("wxService")
public class WxServiceImpl implements WxServiceI {

	private static Logger logger = LoggerFactory.getLogger(WxServiceImpl.class);

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
	@Override
	public WxAccessToken accessToken(String code) {
		Map<String, String> urlVariables = new HashMap<>();
		urlVariables.put("WX_APP_ID", Constants.WX_APP_ID);
		urlVariables.put("WX_APP_SECRET", Constants.WX_APP_SECRET);
		urlVariables.put("CODE", code);

		ResponseEntity<WxAccessToken> responseEntity = null;
		try {
			responseEntity = RestTemplateSigleton.getInstance().getForEntity(Constants.WX_ACCESS_TOKEN_URL,
					WxAccessToken.class, urlVariables);
		} catch (Exception e) {
			logger.error("微信获取accessToken出错", e);
		}

		if (StringUtils.isEmpty(responseEntity)) {
			return null;
		}
		return responseEntity.getBody();
	}

	/**
	 * 通过refresh_token刷新access_token
	 * access_token有效期只有2h
	 * refresh_token有效期30d
	 * 如果refresh_token失效，需要用户重新授权
	 * @author refreshCode
	 * @param userId
	 * @return
	 */
	@Override
	public WxAccessToken refreshCode(String refreshCode) {
		Map<String, String> urlVariables = new HashMap<>();
		urlVariables.put("WX_APP_ID", Constants.WX_APP_ID);
		urlVariables.put("WX_REFRESH_TOKEN", refreshCode);
		ResponseEntity<WxAccessToken> responseEntity = null;
		try {
			responseEntity = RestTemplateSigleton.getInstance().getForEntity(Constants.WX_REFRESH_TOKEN_URL,
					WxAccessToken.class, urlVariables);
		} catch (Exception e) {
			logger.error("微信刷新accessToken出错", e);
		}

		if (StringUtils.isEmpty(responseEntity)) {
			return null;
		}
		return responseEntity.getBody();
	}

}
