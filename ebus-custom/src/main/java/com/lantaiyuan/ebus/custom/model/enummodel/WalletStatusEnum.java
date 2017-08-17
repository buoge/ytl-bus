package com.lantaiyuan.ebus.custom.model.enummodel;

/**
 * 
 * @Title: WalletStatusEnum.java
 * @Description:(钱包状态枚举类)
 * @author YvanTan
 * @date 2017年2月15日 下午6:03:01
 */
public enum WalletStatusEnum {
	FROZEN(1),
	NORMAL(0);
	private int status;
	WalletStatusEnum(int status) {
		this.status = status;
	}
	public int getStatus() {
		return status;
	} 
}