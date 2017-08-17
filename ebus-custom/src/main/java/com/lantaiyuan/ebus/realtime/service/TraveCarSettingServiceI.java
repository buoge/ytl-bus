package com.lantaiyuan.ebus.realtime.service;

import java.util.List;

import org.lanqiao.ssm.common.core.service.BaseServiceI;

import com.lantaiyuan.ebus.realtime.model.TraveCarSetting;
import com.lantaiyuan.ebus.realtime.model.TraveCarSettingQueryModel;

public interface TraveCarSettingServiceI extends BaseServiceI <TraveCarSetting, TraveCarSettingQueryModel>{
    /**
     * 功能描述:条件查询上下车设置信息
     * 作者:温海金
     * 最后更改时间 : 2017年2月20日 下午6:11:03
     */
    List<TraveCarSetting> selectByCondition(TraveCarSettingQueryModel traveCarSettingQM);
    
    /**
     * 功能描述:更新实体类，不设置提醒状态为未提醒，主要供后台自己更改提醒状态调用
     * 作者:温海金
     * 最后更改时间 : 2017年3月21日 下午5:14:04
     */
    public int updateEntity(TraveCarSetting record);
}
