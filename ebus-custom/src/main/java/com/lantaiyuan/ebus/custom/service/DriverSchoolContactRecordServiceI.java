package com.lantaiyuan.ebus.custom.service;

import java.util.List;

import org.lanqiao.ssm.common.core.service.BaseServiceI;

import com.lantaiyuan.ebus.custom.model.DriverSchoolContactRecord;
import com.lantaiyuan.ebus.custom.model.DriverSchoolContactRecordQueryModel;
import com.lantaiyuan.ebus.custom.model.DriverSchoolSignUp;
import com.lantaiyuan.ebus.custom.model.DriverSchoolSignUpContact;

public interface DriverSchoolContactRecordServiceI extends BaseServiceI<DriverSchoolContactRecord, DriverSchoolContactRecordQueryModel>{

	int insertSelective(DriverSchoolContactRecord record, DriverSchoolSignUp signUp);

	List<DriverSchoolContactRecord> selectBySignUpId(String signUpId);

	int insertSelective(DriverSchoolSignUpContact signUpContact, String cityCode);

	
}
