package com.lantaiyuan.ebus.custom.dao;

import java.util.List;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import com.lantaiyuan.ebus.custom.model.WalletRecord;
import com.lantaiyuan.ebus.custom.model.WalletRecordQueryModel;

public interface WalletRecordMapper extends BaseDAO<WalletRecord, WalletRecordQueryModel> {
 
	List<WalletRecord> queryMyBills(String userid);

	WalletRecord queryWalletLogByRecordId(String recordId);

	WalletRecord queryOneTopUplogByUserId(String userId);

}