package com.lantaiyuan.ebus.custom.model.enummodel;

/**
 * 
 * @Title: OrderPayStatusEnum.java
 * @Description:订单状态(0-未支付 1-已支付 2-已取消 3-订单失效 4-退款申请中 5-已退款 )
 * @author YvanTan
 * @date 2017年2月15日 下午6:03:01
 */
public enum OrderPayStatusEnum {
	NOTPAY(0),
	PAID(1),
	CANCELED(2), 
	INVALID(3),
	REFUNDING(4),
	REFUNDED(5);
	private int payStaus;
	OrderPayStatusEnum(int payStaus) {
		this.payStaus = payStaus;
	}
	public int getPayStaus() {
		return payStaus;
	} 
}