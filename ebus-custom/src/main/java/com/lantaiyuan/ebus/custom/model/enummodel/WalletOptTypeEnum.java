package com.lantaiyuan.ebus.custom.model.enummodel;

/**
 * 
 * @Title: WalletOptTypeEnum.java
 * @Description:(钱包操作枚举类)
 * @author YvanTan
 * @date 2017年2月15日 下午6:03:01
 */
public enum WalletOptTypeEnum {
	TOPUP("1"),
	WITHDRAW("2"),
	WALLET_PAY("3"),
	REFUND("4");
	private String optType;
	WalletOptTypeEnum(String optType) {
		this.optType = optType;
	}
	public String getOptType() {
		return optType;
	} 
}