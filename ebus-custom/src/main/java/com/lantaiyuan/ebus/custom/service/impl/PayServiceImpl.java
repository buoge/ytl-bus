package com.lantaiyuan.ebus.custom.service.impl;

import java.math.BigDecimal;
import java.util.UUID;

import org.lanqiao.ssm.common.pay.alipay.util.AlipayHelper;
import org.lanqiao.ssm.common.pay.wexin.util.WeiXinPayHelper;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipayTradeFastpayRefundQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.lantaiyuan.ebus.common.constants.PayConstants;
import com.lantaiyuan.ebus.custom.service.PayServiceI;
import com.tencent.protocol.refund_protocol.RefundResData;
import com.tencent.protocol.refund_query_protocol.RefundQueryResData;

/**
 * 描述:支付业务实现类
 * 作者:YvanTan
 * 最后更改时间:2017-05-24 下午3:59:08
 */
@Service("payService")
public class PayServiceImpl implements PayServiceI {

	@Override
	public AlipayTradeRefundResponse alipayRefund(String orderNo,String refundRequestNo, BigDecimal amount) throws AlipayApiException {
		JSONObject refundRequeset = new JSONObject();
		refundRequeset.put(PayConstants.PARAM_OUT_TRADE_NO, orderNo);
		refundRequeset.put(PayConstants.PARAM_OUT_REQUEST_NO, refundRequestNo);
		refundRequeset.put(PayConstants.PARAM_REFUND_AMOUNT, amount);
		return AlipayHelper.alipayRefund(refundRequeset);
	}

	@Override
	public AlipayTradeFastpayRefundQueryResponse alipayRefundQuery(String orderNo, String refundRequestNo) throws AlipayApiException {
		JSONObject bizContent = new JSONObject();
		bizContent.put(PayConstants.PARAM_OUT_TRADE_NO, orderNo);
		bizContent.put(PayConstants.PARAM_OUT_REQUEST_NO, refundRequestNo);
		return AlipayHelper.alipayRefundQueryRequest(bizContent);
	}

	@Override
	public RefundResData weiXinRefund(String orderNo, int OrderFee, int refundFee) {
		//退款申请号-商户系统唯一
		String refundRequestNo = System.currentTimeMillis()+UUID.randomUUID().toString();
		return WeiXinPayHelper.requestRefundService(orderNo,refundRequestNo,OrderFee,refundFee);
	}

	@Override
	public RefundQueryResData weiXinRefundQuery(String orderNo, String refundRequestNo) {
		return  WeiXinPayHelper.requestRefundQueryService(orderNo,refundRequestNo);
	}

}
