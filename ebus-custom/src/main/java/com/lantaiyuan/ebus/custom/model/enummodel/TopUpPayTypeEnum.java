package com.lantaiyuan.ebus.custom.model.enummodel;

/**
 * 
 * @Title: TopUpPayTypeEnum.java
 * @Description:(余额充值的支付类型)
 * @author YvanTan
 * @date 2017年2月15日 下午6:03:01
 */
public enum TopUpPayTypeEnum {
	WEIXIN("1"),
	ALIPAY("2");
	private String payType;
	TopUpPayTypeEnum(String payType) {
		this.payType = payType;
	}
	public String getPayType() {
		return payType;
	} 
}