package com.lantaiyuan.ebus.custom.model.enummodel;

/**
 * 
 * @Title: TicketStatusEnum.java
 * @Description:(车票状态枚举类)
 * @author YvanTan
 * @date 2017年2月15日 下午6:03:01
 */
public enum TicketStatusEnum {
	NOTPAY("0"),
	PAID("1"),
	USED("2"),
	EXPIRED("3"),
	REFUNDED("4");
	private String status;
	TicketStatusEnum(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	} 
}