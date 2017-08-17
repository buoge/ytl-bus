package com.lantaiyuan.ebus.custom.service;

import java.math.BigDecimal;
import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipayTradeFastpayRefundQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.tencent.protocol.refund_protocol.RefundResData;
import com.tencent.protocol.refund_query_protocol.RefundQueryResData;

/**
 * 描述:支付业务接口
 * 作者:YvanTan
 * 最后更改时间:下午3:59:08
 */
public interface PayServiceI {
	
	/**
	 * @throws AlipayApiException 
	 * @Title: alipayRefund
	 * @Description: 支付宝退款申请
	 * @param orderNo 订单号
	 * @param refundRequestNo 退款请求号(商户系统唯一)
	 * @param amount 金额（需要退款的金额，该金额不能大于订单金额,单位为元，支持两位小数）
	 */
	AlipayTradeRefundResponse alipayRefund(String orderNo,String refundRequestNo,BigDecimal amount) throws AlipayApiException;
	
	/**
	 * @Title: alipayRefundQuery
	 * @Description: 支付宝退款结果查询
	 * @param orderNo 订单号
	 * @param refundRequestNo 退款请求号(商户系统唯一)
	 * @throws AlipayApiException 
	 */
	AlipayTradeFastpayRefundQueryResponse alipayRefundQuery(String orderNo,String refundRequestNo) throws AlipayApiException;
    
	/**
	 * @Title: weiXinRefund
	 * @Description: 微信退款
	 * @param orderNo 订单号
	 * @param OrderFee 订单总金额(单位：分)
	 * @param refundFee 退款金额(单位：分)
	 */
	RefundResData weiXinRefund(String orderNo, int OrderFee, int refundFee);
	
	/**
	 * @Title: weiXinRefundQuery
	 * @Description: 微信退款结果查询
	 * @param orderNo 订单号
	 * @param refundRequestNo 退款请求号(商户系统唯一)
	 */
	RefundQueryResData weiXinRefundQuery(String orderNo,String refundRequestNo);
}
