package com.lantaiyuan.ebus.common.constants;
/**
 * 描述:该文件用于保存支付相关的常量
 * 作者:YvanTan
 * 最后更改时间:2017-05-23 9:25:21
 */

public class PayConstants {
	/***
	 * 参数：reason
	 */
	public static final String PARAM_REASON = "reason";
	
	/***
	 * 参数：status
	 */
	public static final String PARAM_STATUS = "status";
	
	/**
	 *支付宝-商户系统订单号    out_trade_no
	 */
	public static final String  PARAM_OUT_TRADE_NO= "out_trade_no";
	
	/**
	 *支付宝-金额（需要退款的金额，该金额不能大于订单金额,单位为元，支持两位小数）    refund_amount 
	 */
	public static final String  PARAM_REFUND_AMOUNT= "refund_amount";
	
	/**
	 *支付宝-退款请求号(商户系统唯一) out_request_no
	 */
	public static final String  PARAM_OUT_REQUEST_NO= "out_request_no";

	/**
	 *支付宝-退款资金变化标志： "Y"
	 */
	public static final String  ALIPAY_FUND_CHANGE_YES =  "Y";

}
