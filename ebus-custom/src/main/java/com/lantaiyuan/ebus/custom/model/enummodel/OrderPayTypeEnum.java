package com.lantaiyuan.ebus.custom.model.enummodel;

/**
 * 
 * @Title: OrderPayTypeEnum.java
 * @Description:(订单支付类型)
 * @author YvanTan
 * @date 2017年2月15日 下午6:03:01
 */
public enum OrderPayTypeEnum {
	ALIPAY("1"),
	WEIXIN("2"),
	OTHER("3"),
	WALLET("4"),
	NOTPAY("100");
	private String payType;
	OrderPayTypeEnum(String payType) {
		this.payType = payType;
	}
	public String getPayType() {
		return payType;
	} 
}