package com.lantaiyuan.ebus.custom.service;

import java.util.List;
import java.util.Map;
import org.lanqiao.ssm.common.core.service.BaseServiceI;
import com.lantaiyuan.ebus.custom.model.WalletRecord;
import com.lantaiyuan.ebus.custom.model.WalletRecordQueryModel;

/**
 * 描述:钱包业务接口
 * 作者:YvanTan
 * 最后更改时间:下午3:59:08
 */
public interface WalletRecordServiceI extends BaseServiceI<WalletRecord, WalletRecordQueryModel> {

	List<WalletRecord> queryMyBills(String userid);

	Map<String, Object> topUp(String userid, String paytype, String amount);
	
	WalletRecord queryWalletLogByRecordId(String recordId);
	
	/**
	  * queryTopUplogByUserId(根据用户id查询最近一次 状态未支付的充值流水)
	 */
	WalletRecord queryOneTopUplogByUserId(String userId);

}
