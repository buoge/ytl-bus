/**
 * @Title: WalletServiceImpl.java
 * @Package com.lantaiyuan.ebus.custom.service.impl
 * Company:深圳市蓝泰源信息技术股份有限公司
 * @author Yuan.Tan
 * @date 2017年2月17日 下午8:08:09
 */
package com.lantaiyuan.ebus.custom.service.impl;

import java.math.BigDecimal;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.lanqiao.ssm.common.pay.alipay.util.AlipayHelper;
import org.lanqiao.ssm.common.pay.wexin.util.WeiXinPayHelper;
import org.lanqiao.ssm.common.rsa.BalanceSignUtil;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;
import com.lantaiyuan.ebus.custom.dao.WalletMapper;
import com.lantaiyuan.ebus.custom.dao.WalletRecordMapper;
import com.lantaiyuan.ebus.custom.dao.WalletSignMapper;
import com.lantaiyuan.ebus.custom.model.Wallet;
import com.lantaiyuan.ebus.custom.model.WalletQueryModel;
import com.lantaiyuan.ebus.custom.model.WalletRecord;
import com.lantaiyuan.ebus.custom.model.WalletSign;
import com.lantaiyuan.ebus.custom.model.enummodel.TopUpPayTypeEnum;
import com.lantaiyuan.ebus.custom.model.enummodel.WalletStatusEnum;
import com.lantaiyuan.ebus.custom.service.WalletServiceI;
import com.tencent.protocol.pay_query_protocol.ScanPayQueryResData;

/**
 * @ClassName: WalletServiceImpl 
 * Company:深圳市蓝泰源信息技术股份有限公司
 * @author Yuan.Tan
 * @date 2017年2月17日 下午8:08:09
 */
@Service("walletService")
public class WalletServiceImpl extends BaseService<Wallet, WalletQueryModel> implements WalletServiceI {
	@Resource
	private WalletMapper walletMapper;
	@Resource
	private WalletSignMapper walletSignMapper;
	@Resource
	private WalletRecordMapper walletRecordMapper;

	public BaseDAO<Wallet, WalletQueryModel> getDao() {
		return walletMapper;
	}

	@Override
	public Map<String, Object> queryMyBalance(String userid) {
		WalletRecord topUpLogFromDb = walletRecordMapper.queryOneTopUplogByUserId(userid);
		if (topUpLogFromDb != null) {
			queryPayStatusFromThird(topUpLogFromDb);
		}
		Map<String, Object> balanceMap = new HashMap<>();
		Wallet myWallet = walletMapper.selectByPrimaryKey(userid);
		if (myWallet == null) {
			// 初始化钱包
			BigDecimal amount = new BigDecimal("0.00");
			Wallet initWallet = new Wallet(userid, amount);
			walletMapper.insertSelective(initWallet);
			myWallet = walletMapper.selectByPrimaryKey(userid);
			// 钱包初始化后，调用签名方法
			try {
				String rsaSign = BalanceSignUtil.rsaSign(JSON.toJSONString(myWallet));
				WalletSign walletSign = new WalletSign(userid, rsaSign);
				walletSignMapper.insertSelective(walletSign);
			} catch (SignatureException e) {
				logger.error(SysGlobalConstants.PARAM_USER_ID + userid + "钱包初始化签名失败", e);
			}
		}
		balanceMap.put(SysGlobalConstants.PARAM_WALLET_BALANCE, myWallet.getBalance());
		balanceMap.put(SysGlobalConstants.PARAM_WALLET_FROZEN_STTUS, myWallet.getFrozen());
		return balanceMap;
	}

	/**
	 * <p>
	 * Title: addBalanceByUserId
	 * </p>
	 * @param wallet：wallet实例的金额代表变动的金额数
	 */
	@Override
	public int addBalanceByUserId(Wallet wallet) {
		// wallet实例的金额代表变动的金额数
		String userid = wallet.getUserId();
		Wallet myWalletInDb = walletMapper.selectByPrimaryKey(String.valueOf(userid));
		WalletSign myWalletSign = walletSignMapper.selectByPrimaryKey(userid);
		// 修改前要验签
		String rsaSign = "";
		try {
			// 钱包更新总流程：更新余额前验证签名，通过则更新，否则冻结账户
			rsaSign = BalanceSignUtil.rsaSign(JSON.toJSONString(myWalletInDb));
			String rsaSignInDb = myWalletSign.getSign();
			if (rsaSign.equals(rsaSignInDb)) {
				return walletMapper.addBalanceByUserId(wallet);
			} else {
				myWalletInDb.setFrozen(WalletStatusEnum.FROZEN.getStatus());
				walletMapper.updateByPrimaryKeySelective(myWalletInDb);
			}
		} catch (SignatureException e) {
			logger.error("修改金额前验证签名失败", e);
		}
		return 0;
	}

	@Override
	public void updateWalletSign(String userid) {
		String rsaSign = "";
		try {
			rsaSign = BalanceSignUtil.rsaSign(JSON.toJSONString(walletMapper.selectByPrimaryKey(userid)));
		} catch (SignatureException e) {
			logger.error(SysGlobalConstants.PARAM_USER_ID + userid + "更新签名信息失败", e);
			return;
		}
		WalletSign walletSign = new WalletSign(userid, rsaSign);
		walletSignMapper.updateByPrimaryKeySelective(walletSign);
	}

	/**
	 * queryPayStatusFromThird(根据充值流水记录 直接发送请求到第三方 查询支付结果，根据结果更新余额)
	 */
	public void queryPayStatusFromThird(WalletRecord topUpLogFromDb) {
		String succcss = "SUCCESS";
		String userId = topUpLogFromDb.getUserId();
		String orderNo = topUpLogFromDb.getRecordId();
		// 1-微信 2-支付宝
		String payType = topUpLogFromDb.getPayType();
		BigDecimal amount = topUpLogFromDb.getAmount();
		// 微信
		if (TopUpPayTypeEnum.WEIXIN.getPayType().equals(payType)) {
			String weiXinQueryInfo = WeiXinPayHelper.createQueryInfo(orderNo);
			// 调用查询接口查看订单状态
			ScanPayQueryResData result = WeiXinPayHelper.WeiXinOrderQuery(weiXinQueryInfo);
			if (result != null && result.getReturn_code().equals(succcss) && result.getResult_code().equals(succcss)
					&& result.getTrade_state().equals(succcss) && result.getOut_trade_no().equals(orderNo)
					&& result.getTotal_fee().equals(amount.multiply(new BigDecimal(100)).toBigInteger().toString())) {
				// 1更新流水
				topUpLogFromDb.setPayStatus(SysGlobalConstants.PAY_STATUS_SUCCESS_CODE);
				walletRecordMapper.updateByPrimaryKeySelective(topUpLogFromDb);
				// 2更新余额
				Wallet modifyWallet = new Wallet(userId, amount);
				if (addBalanceByUserId(modifyWallet) == SysGlobalConstants.UPDATE_ONE_RECORD_SUCCESS) {
					// 3更新签名
					updateWalletSign(userId);
				}
			}
		}
		// 支付宝
		if (TopUpPayTypeEnum.ALIPAY.getPayType().equals(payType)) {
			AlipayTradeQueryResponse alipayTradeQueryResponse = new AlipayTradeQueryResponse();
			try {
				alipayTradeQueryResponse = AlipayHelper.alipayTradeQuery(orderNo);
			} catch (AlipayApiException e) {
				logger.error("调用支付宝查询接口异常:" + "错误码-" + e.getErrCode() + ",errMsg:" + e.getErrMsg(), e);
				return;
			}
			if (alipayTradeQueryResponse != null && SysGlobalConstants.ALIPAY_TRADE_SUCCESS.equals(alipayTradeQueryResponse.getTradeStatus())
					&& amount.toString().equals(alipayTradeQueryResponse.getTotalAmount())) {
				// 1更新流水
				topUpLogFromDb.setPayStatus(SysGlobalConstants.PAY_STATUS_SUCCESS_CODE);
				walletRecordMapper.updateByPrimaryKeySelective(topUpLogFromDb);
				// 2更新余额
				Wallet modifyWallet = new Wallet(userId, amount);
				if (addBalanceByUserId(modifyWallet) == SysGlobalConstants.UPDATE_ONE_RECORD_SUCCESS) {
					// 3更新签名
					updateWalletSign(userId);
				}
			}
		}
	}

	@Override
	public Object generateWalletSign(String userId) {
		String rsaSign = "";
		try {
			rsaSign = BalanceSignUtil.rsaSign(JSON.toJSONString(walletMapper.selectByPrimaryKey(userId)));
		} catch (SignatureException e) {
			return null;
		}
		return rsaSign;
	}
}
