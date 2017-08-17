package com.lantaiyuan.ebus.realtime.dao;

import java.util.List;

import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.realtime.model.TraveCarSetting;
import com.lantaiyuan.ebus.realtime.model.TraveCarSettingQueryModel;

public interface TraveCarSettingMapper extends BaseDAO<TraveCarSetting, TraveCarSettingQueryModel>{
    /**
     * 功能描述:条件查询上下车设置信息
     * 作者:温海金
     * 最后更改时间 : 2017年2月20日 下午6:11:03
     */
    List<TraveCarSetting> selectByCondition(TraveCarSettingQueryModel traveCarSettingQM);
}