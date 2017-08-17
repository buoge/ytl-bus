package com.lantaiyuan.ebus.oauthlogin.service;

import com.lantaiyuan.ebus.oauthlogin.model.WxAccessToken;

/**
 * 微信service
 * @author yangyang
 * @date 2017年6月19日 下午4:35:53 
 *
 */
public interface WxServiceI {

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
	WxAccessToken refreshCode(String refreshCode);

	/**
	 * 通过refresh_token刷新access_token
	 * access_token有效期只有2h
	 * refresh_token有效期30d
	 * 如果refresh_token失效，需要用户重新授权
	 * @author refreshCode
	 * @param userId
	 * @return
	 */
	WxAccessToken accessToken(String code);
	
	

}
