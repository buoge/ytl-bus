package com.lantaiyuan.ebus.custom.service;

import org.lanqiao.ssm.common.core.service.BaseServiceI;
import org.lanqiao.ssm.common.page.Page;

import com.lantaiyuan.ebus.custom.model.DriverSchoolSignUp;
import com.lantaiyuan.ebus.custom.model.DriverSchoolSignUpQueryModel;

public interface DriverSchoolSignUpServiceI extends BaseServiceI<DriverSchoolSignUp, DriverSchoolSignUpQueryModel>{

	/**
	 * 分页查询驾校报名信息
	 * @author yangyang
	 * @param model
	 * @return
	 */
	Page<DriverSchoolSignUp> findDriverSchoolSignUpByPage(DriverSchoolSignUpQueryModel model);

	
	
	
}
