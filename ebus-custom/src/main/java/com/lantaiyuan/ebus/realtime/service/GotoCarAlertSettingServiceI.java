package com.lantaiyuan.ebus.realtime.service;

import java.util.List;

import org.lanqiao.ssm.common.core.service.BaseServiceI;

import com.lantaiyuan.ebus.realtime.model.GotoCarAlertSetting;
import com.lantaiyuan.ebus.realtime.model.GotoCarAlertSettingModel;
import com.lantaiyuan.ebus.realtime.model.GotoCarAlertSettingQueryModel;
/**
 * 描述:消息提醒设置业务接口
 * 作者:温海金
 * 最后更改时间:下午2:24:19
 */
public interface GotoCarAlertSettingServiceI extends BaseServiceI<GotoCarAlertSetting, GotoCarAlertSettingQueryModel>{
    List<GotoCarAlertSetting> selectByCondition(GotoCarAlertSettingQueryModel gotoCarAlertSettingQM);

    int insertArray(String gotoCarAlertSettings);

    int updateArray(String gotoCarAlertSettings);

    List<GotoCarAlertSetting> getGotoCarAlertSettings(String cityCode, Integer userId);

    int insertArrayWithDataModels(List<GotoCarAlertSettingModel> objs);

    int updateArrayWithDataModels(List<GotoCarAlertSettingModel> objs);
    
    public int updateEntity(GotoCarAlertSetting record);
}
