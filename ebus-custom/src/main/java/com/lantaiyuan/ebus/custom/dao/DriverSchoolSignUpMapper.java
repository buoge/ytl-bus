package com.lantaiyuan.ebus.custom.dao;

import java.util.List;

import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.custom.model.DriverSchoolSignUp;
import com.lantaiyuan.ebus.custom.model.DriverSchoolSignUpQueryModel;

public interface DriverSchoolSignUpMapper extends BaseDAO<DriverSchoolSignUp, DriverSchoolSignUpQueryModel>{
   
    
    /**
     * 分页查询驾校报名信息
     * @author yangyang
     * @param model
     * @return
     */
	List<DriverSchoolSignUp> findDriverSchoolSignUpByPage(DriverSchoolSignUpQueryModel model);

	/**
	 * 根据手机号码查看预约记录
	 * @author yangyang
	 * @param tel
	 */
	int selectByTel(String tel);
}