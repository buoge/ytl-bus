/**
 * @Title: WalletServiceImpl.java
 * @Package com.lantaiyuan.ebus.custom.service.impl
 * Company:深圳市蓝泰源信息技术股份有限公司
 * @author Yuan.Tan
 * @date 2017年2月17日 下午8:08:09
 */
package com.lantaiyuan.ebus.custom.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.lanqiao.ssm.common.pay.alipay.util.AlipayHelper;
import org.lanqiao.ssm.common.pay.wexin.util.WeiXinPayHelper;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;
import com.lantaiyuan.ebus.common.util.Tools;
import com.lantaiyuan.ebus.custom.dao.WalletRecordMapper;
import com.lantaiyuan.ebus.custom.model.WalletRecord;
import com.lantaiyuan.ebus.custom.model.WalletRecordQueryModel;
import com.lantaiyuan.ebus.custom.model.enummodel.TopUpPayTypeEnum;
import com.lantaiyuan.ebus.custom.service.WalletRecordServiceI;
import com.tencent.util.UnifiedOrderRespose;

/**
 * @ClassName: WalletServiceImpl 
 * Company:深圳市蓝泰源信息技术股份有限公司
 * @author Yuan.Tan
 * @date 2017年2月17日 下午8:08:09
 */
@Service("walletRecordService")
public class WalletRecordServiceImpl extends BaseService<WalletRecord, WalletRecordQueryModel>
		implements WalletRecordServiceI {
	@Resource
	private WalletRecordMapper walletRecordMapper;

	public BaseDAO<WalletRecord, WalletRecordQueryModel> getDao() {
		return walletRecordMapper;
	}

	@Override
	public List<WalletRecord> queryMyBills(String userid) {
		return walletRecordMapper.queryMyBills(userid);
	}

	@Override
	public Map<String, Object> topUp(String userid, String paytype, String amount) {
		// 充值流水号
		String recordId = Tools.generateOrderNo();
		// 操作类型-1：充值
		String optType = "1";
		Map<String, Object> signMap = new HashMap<>();
		WalletRecord walletRecord = new WalletRecord(recordId, userid, new BigDecimal(amount), optType, paytype);
		int flag = walletRecordMapper.insertSelective(walletRecord);
		// 代表充值流水记录已经存进数据库表：钱包交易记录表
		if (flag == SysGlobalConstants.UPDATE_ONE_RECORD_SUCCESS) {
			// 根据充值方式返回不同的支付签名
			// 微信
			if (TopUpPayTypeEnum.WEIXIN.getPayType().equals(paytype)) {
				Map<String, Object> params = WeiXinPayHelper.createOrderInfo(recordId, recordId, amount);
				signMap.put(SysGlobalConstants.PARAM_PAY_SIGN, params);
			} else if (TopUpPayTypeEnum.ALIPAY.getPayType().equals(paytype)) {
				// 支付宝
				JSONObject bizContent = new JSONObject();
				bizContent.put(SysGlobalConstants.PARAM_TOTAL_AMOUNT, amount);
				bizContent.put(SysGlobalConstants.PARAM_SUBJECT, "充值" + amount);
				bizContent.put(SysGlobalConstants.PARAM_BODY, "pay_infomation");
				bizContent.put(SysGlobalConstants.PARAM_OUT_TRADE_NO, recordId);
				signMap.put(SysGlobalConstants.PARAM_PAY_SIGN, AlipayHelper.buildAlipayOrder(bizContent));
			}
		}
		return signMap;	
	}

	@Override
	public WalletRecord queryWalletLogByRecordId(String recordId) {
		return walletRecordMapper.queryWalletLogByRecordId(recordId);
	}

	@Override
	public WalletRecord queryOneTopUplogByUserId(String userId) {
		return walletRecordMapper.queryOneTopUplogByUserId(userId);
	}
}
