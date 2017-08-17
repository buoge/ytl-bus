package com.lantaiyuan.ebus.realtime.dao;

import java.util.List;

import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.realtime.model.GotoCarAlertSetting;
import com.lantaiyuan.ebus.realtime.model.GotoCarAlertSettingQueryModel;

public interface GotoCarAlertSettingMapper extends BaseDAO<GotoCarAlertSetting, GotoCarAlertSettingQueryModel>{
    List<GotoCarAlertSetting> selectByCondition(GotoCarAlertSettingQueryModel gotoCarAlertSettingQM);
}