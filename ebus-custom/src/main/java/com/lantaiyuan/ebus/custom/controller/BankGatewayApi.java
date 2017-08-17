package com.lantaiyuan.ebus.custom.controller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.lanqiao.ssm.common.pay.alipay.core.Config;
import org.lanqiao.ssm.common.pay.alipay.core.SignUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alipay.api.AlipayApiException;
import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;
import com.lantaiyuan.ebus.common.util.RequestUtil;
import com.lantaiyuan.ebus.custom.model.Order;
import com.lantaiyuan.ebus.custom.model.Wallet;
import com.lantaiyuan.ebus.custom.model.WalletRecord;
import com.lantaiyuan.ebus.custom.model.WeiXinReturnModel;
import com.lantaiyuan.ebus.custom.service.BookBusServiceI;
import com.lantaiyuan.ebus.custom.service.BookTicketServiceI;
import com.lantaiyuan.ebus.custom.service.CarpoolOrderServiceI;
import com.lantaiyuan.ebus.custom.service.OrderServiceI;
import com.lantaiyuan.ebus.custom.service.WalletRecordServiceI;
import com.lantaiyuan.ebus.custom.service.WalletServiceI;
import com.tencent.common.Configure;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * @ClassName: BankGatewayApi Company:深圳市蓝泰源信息技术股份有限公司
 * @author Yuan.Tan
 * @date 2016年12月20日 下午2:26:47
 */
@RestController
@RequestMapping("/bankGatewayApi")
public class BankGatewayApi {
	@Resource
	private OrderServiceI orderService;
	@Resource
	private BookTicketServiceI bookTicketService;
	@Resource
	private BookBusServiceI bookBusService;
	@Resource
	private WalletRecordServiceI walletRecordService;
	@Resource
	private WalletServiceI walletService;
	@Resource
	private CarpoolOrderServiceI carpoolOrderService;
	private static final Logger logger = LoggerFactory.getLogger(BankGatewayApi.class);
	
	/**
	 * weiXinReturn( 支付结果通用通知 
	 * 应用场景
	 * 支付完成后，微信会把相关支付结果和用户信息发送给商户，商户需要接收处理，并返回应答。
	 * 对后台通知交互时，如果微信收到商户的应答不是成功或超时，微信认为通知失败，微信会通过一定的策略定期重新发起通知，尽可能提高通知的成功率，
	 * 但微信不保证通知最终能成功。 （通知频率为15/15/30/180/1800/1800/1800/1800/3600，单位：秒）
	 * 注意：同样的通知可能会多次发送给商户系统。商户系统必须能够正确处理重复的通知。
	 * 推荐的做法是，当收到通知进行处理时，首先检查对应业务数据的状态，判断该通知是否已经处理过，如果没有处理过再进行处理，如果处理过直接返回结果成功。
	 * 在对业务数据进行状态检查和处理之前，要采用数据锁进行并发控制，以避免函数重入造成的数据混乱。
	 * 特别提醒：商户系统对于支付结果通知的内容一定要做签名验证，防止数据泄漏导致出现“假通知”，造成资金损失。
	 * 技术人员可登进微信商户后台扫描加入接口报警群。 )
	 */
	@PostMapping(value = "/weiXinReturn")
	public String weiXinReturn(HttpServletRequest request) {
		String success = SysGlobalConstants.WEI_XIN_RETURN_SUCCESS;
		String result;
		try (InputStream inStream = request.getInputStream();
				ByteArrayOutputStream outSteam = new ByteArrayOutputStream();) {
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = inStream.read(buffer)) != -1) {
				outSteam.write(buffer, 0, len);
			}
			result = new String(outSteam.toByteArray(), SysGlobalConstants.UNICODE_TRANSFORMATION_FORMAT_8);
			XStream xStream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));
			xStream.alias(SysGlobalConstants.XML, WeiXinReturnModel.class);
			WeiXinReturnModel weiXinReturnModel = (WeiXinReturnModel) xStream.fromXML(result);
			// 1 先判断充值回调
			WalletRecord walletRecordLog = walletRecordService
					.queryWalletLogByRecordId(weiXinReturnModel.getOut_trade_no());
			if (walletRecordLog != null &&  !SysGlobalConstants.PAY_STATUS_SUCCESS_CODE.equals(walletRecordLog.getPayStatus())) {
				return updateWalletLogByWeiXinReturn(walletRecordLog, weiXinReturnModel);
			}
			//查询数据库状态为未支付的订单
			Order order = orderService.selectUnpaidByOrderNo(weiXinReturnModel.getOut_trade_no());
			if (null == order) {
				logger.warn(weiXinReturnModel.getOut_trade_no() + "***order was paid***");
			} else if (weiXinReturnModel != null && Configure.getMchid().equals(weiXinReturnModel.getMch_id())
					&& SysGlobalConstants.SUCCESS_FLAG.equals(weiXinReturnModel.getReturn_code())
					&& SysGlobalConstants.SUCCESS_FLAG.equals(weiXinReturnModel.getResult_code())) {
				String orderNo = order.getOrderno();
				if (weiXinReturnModel.getOut_trade_no().equals(orderNo) && weiXinReturnModel.getTotal_fee()
						.equals(order.getAmount().multiply(new BigDecimal(100)).toBigInteger().toString())) {
					// 更改支付状态 已经支付
					order.setOrderstatus((byte) 1);
					// 更改支付类型 1-支付宝 2-微信
					order.setPaytype((byte) 2);
					order.setPaytime(new Date());
					if (orderService.updateByPrimaryKeySelective(order) == SysGlobalConstants.UPDATE_ONE_RECORD_SUCCESS) {
						orderService.modifyOrderStatusAfterPaid(orderNo);
					}
				}
			}
		} catch (Exception e) {
			logger.error("微信回调异常", e);
		}
		return success;
	}

	/**
	  * alipayReturn(App支付服务器异步通知参数说明)
	  * 回调说明地址：https://doc.open.alipay.com/docs/doc.htm?spm=a219a.7629140.0.0.A8ar2n&treeId=204&articleId=105301&docType=1
	 */
	@PostMapping(value = "/alipayReturn")
	public String alipayReturn(HttpServletRequest request) {
		// 支付宝响应消息
		String responseMsg = SysGlobalConstants.SUCCESS_RESPONSE_MSG;
		// 1. 解析请求参数
		Map<String, String> params = RequestUtil.getRequestParams(request);
		// 2. 验证签名
		try {
			SignUtils.verifySign(params);
		} catch (AlipayApiException e) {
			logger.error("支付宝回调异常", e);
		}
		if (!(Config.PID.equals(params.get(SysGlobalConstants.PARAM_SELLER_ID)) && Config.APPID.equals(params.get(SysGlobalConstants.PARAM_APP_ID)))) {
			return SysGlobalConstants.FAIL_RESPONSE_MSG;
		}
		String orderNo = params.get(SysGlobalConstants.PARAM_OUT_TRADE_NO);
		// 1 先判断充值回调
		WalletRecord walletRecordLog = walletRecordService.queryWalletLogByRecordId(orderNo);
		if (walletRecordLog != null &&  !SysGlobalConstants.PAY_STATUS_SUCCESS_CODE.equals(walletRecordLog.getPayStatus())) {
			return updateWalletLogByAlipayReturn(walletRecordLog, params);
		}
		// 2 查询数据库状态为未支付的订单 再处理车票、包车订单
		Order order = orderService.selectUnpaidByOrderNo(orderNo);
		if (null == order) {
			responseMsg = SysGlobalConstants.RESPONSE_ORDER_WAS_PAID;
		} else {
			if (!order.getAmount().toString().equals(params.get(SysGlobalConstants.PARAM_TOTAL_AMOUNT))) {
				responseMsg = SysGlobalConstants.RESPONSE_AMOUNT_NOT_MATCH;
			} else {
				// 更改支付状态 已经支付
				order.setOrderstatus((byte) 1);
				// 更改支付类型 1-支付宝
				order.setPaytype((byte) 1);
				order.setPaytime(new Date());
				if (orderService.updateByPrimaryKeySelective(order) == SysGlobalConstants.UPDATE_ONE_RECORD_SUCCESS) {
					orderService.modifyOrderStatusAfterPaid(orderNo);
				}
			}
		}
		return responseMsg;
	}

	/**
	 * updateWalletLogByAlipayReturn 根据支付宝回调结果修改充值记录（钱包余额增加充值流水记录的状态）
	 * @param AlipayReturnParams
	 */
	private String updateWalletLogByAlipayReturn(WalletRecord walletRecordLog, Map<String, String> AlipayReturnParams) {
		String responseMsg = SysGlobalConstants.FALSE_RESPONSE_MSG;
		if (!walletRecordLog.getAmount().toString().equals(AlipayReturnParams.get(SysGlobalConstants.PARAM_TOTAL_AMOUNT))) {
			responseMsg = SysGlobalConstants.RESPONSE_AMOUNT_NOT_MATCH;
		} else {
			// 1-已支付
			walletRecordLog.setPayStatus(SysGlobalConstants.PAY_STATUS_SUCCESS_CODE);
			if (walletRecordService.updateByPrimaryKeySelective(walletRecordLog) == SysGlobalConstants.UPDATE_ONE_RECORD_SUCCESS) {
				String userId = walletRecordLog.getUserId();
				BigDecimal amount = walletRecordLog.getAmount();
				Wallet wallet = new Wallet(userId, amount);
				if (walletService.addBalanceByUserId(wallet) == SysGlobalConstants.UPDATE_ONE_RECORD_SUCCESS) {
					// 更新签名
					walletService.updateWalletSign(userId);
					responseMsg = SysGlobalConstants.SUCCESS_RESPONSE_MSG;
				}
			}
		}
		return responseMsg;
	}

	/**
	 * updateWalletLogByWeiXinReturn(根据微信回调结果修改充值记录（钱包余额增加充值流水记录的状态）)
	 */
	private String updateWalletLogByWeiXinReturn(WalletRecord walletRecordLog, WeiXinReturnModel weiXinReturnModel) {
		String success = SysGlobalConstants.WEI_XIN_RETURN_SUCCESS;
		if (weiXinReturnModel != null && Configure.getMchid().equals(weiXinReturnModel.getMch_id())
				&& SysGlobalConstants.SUCCESS_FLAG.equals(weiXinReturnModel.getReturn_code())
				&& SysGlobalConstants.SUCCESS_FLAG.equals(weiXinReturnModel.getResult_code())
				&& weiXinReturnModel.getTotal_fee().equals(walletRecordLog.getAmount().multiply(new BigDecimal(100)).toBigInteger().toString())) {
			// 1-已支付
			walletRecordLog.setPayStatus(SysGlobalConstants.PAY_STATUS_SUCCESS_CODE);
			if (walletRecordService.updateByPrimaryKeySelective(walletRecordLog) == SysGlobalConstants.UPDATE_ONE_RECORD_SUCCESS) {
				String userId = walletRecordLog.getUserId();
				BigDecimal amount = walletRecordLog.getAmount();
				Wallet wallet = new Wallet(userId, amount);
				if (walletService.addBalanceByUserId(wallet) == SysGlobalConstants.UPDATE_ONE_RECORD_SUCCESS) {
					// 更新签名
					walletService.updateWalletSign(userId);
				}
			}
		}
		return success;
	}
}
