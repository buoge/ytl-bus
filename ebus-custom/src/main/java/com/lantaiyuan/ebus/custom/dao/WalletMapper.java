package com.lantaiyuan.ebus.custom.dao;

import java.math.BigDecimal;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import com.lantaiyuan.ebus.custom.model.Wallet;
import com.lantaiyuan.ebus.custom.model.WalletQueryModel;

public interface WalletMapper extends BaseDAO<Wallet, WalletQueryModel> {

	int addBalanceByUserId(Wallet wallet);
	
	int reduceBalance(@Param("userId")String userId, @Param("balance")BigDecimal balance);
}