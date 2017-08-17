package com.lantaiyuan.ebus.oauthlogin.model.enummodel;

/**
 * 支付宝授权类型枚举
 * 
 * @author yangyang
 * @date 2017年6月20日 上午11:27:14 
 *
 */
public enum AlipayGrantTypeEnum {
	
	AUTHORIZATION_CODE(1, "authorization_code"),
	REFRESH_TOKEN(2, "refresh_token");

	
	private Integer val;
	private String desc;
	
	private AlipayGrantTypeEnum(Integer val, String desc) {
		this.val = val;
		this.desc = desc;
	}
	
	public Integer val() {
		return val;
	}
	
	public String desc() {
		return desc;
	}

}
