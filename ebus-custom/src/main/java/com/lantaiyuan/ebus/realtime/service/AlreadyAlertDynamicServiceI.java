package com.lantaiyuan.ebus.realtime.service;

import java.util.List;

import org.lanqiao.ssm.common.core.service.BaseServiceI;

import com.lantaiyuan.ebus.realtime.model.AlreadyAlertDynamic;
import com.lantaiyuan.ebus.realtime.model.AlreadyAlertDynamicQueryModel;
/**
 * 描述:已提醒信息存储业务实现接口
 * 作者:温海金
 * 最后更改时间:下午2:24:19
 */
public interface AlreadyAlertDynamicServiceI extends BaseServiceI<AlreadyAlertDynamic, AlreadyAlertDynamicQueryModel>{
    
    List<AlreadyAlertDynamic> selectByCondition(AlreadyAlertDynamicQueryModel alreadyAlertDynamicQM);
    /**
     * 功能描述:每天凌晨12点定时清空上车提醒数据动态表JPUSH_ALREADY_ALERT_DYNAMIC
     * 作者:温海金
     * 最后更改时间 : 2017年3月4日 上午10:37:56
     */
    int clearTheDataOfAlreadyAlert();
    
    /**
     * 功能描述:每天凌晨12点定时清空下车车提醒数据动态表t_trave_car_setting
     * 作者:温海金
     * 最后更改时间 : 2017年3月4日 上午10:37:56
     */
    int clearTheDataInLeavingCarAlert();
}
