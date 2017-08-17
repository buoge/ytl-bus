package com.lantaiyuan.ebus.custom.service;

import com.lantaiyuan.ebus.custom.model.acquisition.base.BaseModel;
import com.lantaiyuan.ebus.custom.model.enummodel.CMDEnum;

public interface DataCollectServiceI {
	void handleDataCollection(CMDEnum cmdEnum, String json);

	void save(BaseModel o,String tableName );
}
