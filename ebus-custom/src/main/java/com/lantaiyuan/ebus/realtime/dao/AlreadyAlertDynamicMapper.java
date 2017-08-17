package com.lantaiyuan.ebus.realtime.dao;

import java.util.List;

import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.realtime.model.AlreadyAlertDynamic;
import com.lantaiyuan.ebus.realtime.model.AlreadyAlertDynamicQueryModel;

public interface AlreadyAlertDynamicMapper extends BaseDAO<AlreadyAlertDynamic, AlreadyAlertDynamicQueryModel>{
   
    List<AlreadyAlertDynamic> selectByCondition(AlreadyAlertDynamicQueryModel alreadyAlertDynamicQM);
    /**
     * 每天凌晨定时清空用户上车提醒动态表JPUSH_ALREADY_ALERT_DYNAMIC
     */
    int clearTheDataOfAlreadyAlert();
    /**
     * 每天凌晨定时清空用户下车提醒动态表中已经提醒过的数据#DELETE from t_trave_car_setting where IS_REMIND = TRUE;
     */
    int clearTheDataInLeavingCarAlert();
}