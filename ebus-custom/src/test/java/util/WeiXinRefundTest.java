package util;

import org.lanqiao.ssm.common.pay.wexin.util.WeiXinPayHelper;
import com.tencent.protocol.refund_protocol.RefundResData;
import com.tencent.protocol.refund_query_protocol.RefundQueryResData;
/**
 * 描述:微信服务测试类
 * 作者:温海金
 * 最后更改时间:下午6:23:43
 */
public class WeiXinRefundTest {
	
	public static void main(String[] args) {
		//1.生成预付订单
		//String orderInfo = WeiXinPayHelper.createOrderInfo("123456", "预支付订单测试", "0.01");
		//2.调起支付
		//UnifiedOrderRespose unifiedOrder = WeiXinPayHelper.makeUnifiedOrder(orderInfo);
		//3.签名
		//Map<String, Object> signMap = WeiXinPayHelper.getOrderInfoWithSign(unifiedOrder);
		//3.订单查询
		//String queryInfo = WeiXinPayHelper.createQueryInfo("123456");
		//4.申请退款
		/*RefundReqData refundReqData = new RefundReqData(null, "2017050314433813926391", null, "2017050314433813926391", 1, 1, Configure.getMchid(), "CNY");
		try {
			RefundResData requestRefundService = WeiXinPayHelper.requestRefundService(refundReqData);
			System.out.println(requestRefundService);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		RefundResData requestRefundService = WeiXinPayHelper.requestRefundService("2017050314433813926391", "2017050314433813926391", 1, 1);
		System.out.println(requestRefundService.getResult_code());
		//5.退款查询
		/*RefundQueryReqData refundQueryReqData = new RefundQueryReqData(null, "2017050314433813926391", null, "2017050314433813926391", null);
		try {
			RefundQueryResData refundQueryResult = WeiXinPayHelper.requestRefundQueryService(refundQueryReqData);
			System.out.println(refundQueryResult);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		RefundQueryResData requestRefundQueryService = WeiXinPayHelper.requestRefundQueryService("2017050314433813926391", "2017050314433813926391");
		System.out.println(requestRefundQueryService.getResult_code());
	}
}
