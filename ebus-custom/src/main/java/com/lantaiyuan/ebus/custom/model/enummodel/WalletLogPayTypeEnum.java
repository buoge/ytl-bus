package com.lantaiyuan.ebus.custom.model.enummodel;

/**
 * 
 * @Title: WalletLogPayTypeEnum.java
 * @Description:(钱包流水记录的支付类型枚举类)
 * @author YvanTan
 * @date 2017年2月15日 下午6:03:01
 */
public enum WalletLogPayTypeEnum {
	WEIXIN("1"),
	ALIPAY("2"),
	WALLET_PAY("3"),
	REFUND("4");
	private String payType;
	WalletLogPayTypeEnum(String payType) {
		this.payType = payType;
	}
	public String getpayType() {
		return payType;
	} 
}