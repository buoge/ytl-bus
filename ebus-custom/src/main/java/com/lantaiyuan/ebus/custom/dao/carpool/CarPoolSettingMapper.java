package com.lantaiyuan.ebus.custom.dao.carpool;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import com.lantaiyuan.ebus.custom.model.carpool.CarPoolSetting;
import com.lantaiyuan.ebus.custom.model.carpool.CarPoolSettingQueryModel;

public interface CarPoolSettingMapper extends BaseDAO<CarPoolSetting, CarPoolSettingQueryModel>{
	CarPoolSetting selectByUserId(Integer userId);
}