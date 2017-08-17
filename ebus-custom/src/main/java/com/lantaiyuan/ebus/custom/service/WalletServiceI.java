package com.lantaiyuan.ebus.custom.service;

import java.util.Map;
import org.lanqiao.ssm.common.core.service.BaseServiceI;
import com.lantaiyuan.ebus.custom.model.Wallet;
import com.lantaiyuan.ebus.custom.model.WalletQueryModel;

/**
 * 描述:钱包业务接口
 * 作者:YvanTan
 * 最后更改时间:下午3:59:08
 */
public interface WalletServiceI extends BaseServiceI<Wallet, WalletQueryModel> {

	Map<String, Object> queryMyBalance(String userid);

	int addBalanceByUserId(Wallet wallet);
	
	/**
	  * updateWalletSign(根据userId生成钱包钱包签名)
	 */
	void updateWalletSign(String userid);

	Object generateWalletSign(String userId);
}
