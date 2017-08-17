package com.lantaiyuan.ebus.custom.model.enummodel;

/**
 * 
 * @Title: WalletRecordStatusEnum.java
 * @Description:(钱包流水记录状态枚举类)
 * @author YvanTan
 * @date 2017年2月15日 下午6:03:01
 */
public enum WalletRecordStatusEnum {
	NOTPAY("0"),
	PAID("1");
	private String status;
	WalletRecordStatusEnum(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	} 
}