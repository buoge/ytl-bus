package com.lantaiyuan.ebus.custom.dao;

import java.util.List;

import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.custom.model.DriverSchoolContactRecord;
import com.lantaiyuan.ebus.custom.model.DriverSchoolContactRecordQueryModel;

public interface DriverSchoolContactRecordMapper extends BaseDAO<DriverSchoolContactRecord, DriverSchoolContactRecordQueryModel>{
   
    
    /**
     * 根据报名id，查出该用户的所有联系记录
     * @author yangyang
     * @param signUpId
     * @return
     */
    List<DriverSchoolContactRecord> selectBySignUpId(String signUpId);
}