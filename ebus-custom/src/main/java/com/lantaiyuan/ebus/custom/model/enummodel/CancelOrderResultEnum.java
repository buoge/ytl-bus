package com.lantaiyuan.ebus.custom.model.enummodel;

/**
 * 
 * @Title: CancelOrderResultEnum.java
 * @Description:订单取消结果(0-失败 1-成功 )
 * @author YvanTan
 * @date 2017年2月15日 下午6:03:01
 */
public enum CancelOrderResultEnum {
	FAIL(0),
	SUCCESS(1);
	private int cancelResult;
	CancelOrderResultEnum(int cancelResult) {
		this.cancelResult = cancelResult;
	}
	public int getCancelResult() {
		return cancelResult;
	} 
}