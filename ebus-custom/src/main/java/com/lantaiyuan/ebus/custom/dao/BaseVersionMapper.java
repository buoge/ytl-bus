package com.lantaiyuan.ebus.custom.dao;


import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.custom.model.BaseVersion;
import com.lantaiyuan.ebus.custom.model.BaseVersionQueryModel;

/**
 * 描述:版本管理dao持久层
 * 作者:温海金
 * 最后更改时间:上午11:47:23
 */
public interface BaseVersionMapper extends BaseDAO<BaseVersion, BaseVersionQueryModel>{

    BaseVersion queryBaseVersion(@Param(value = "cityCode") String cityCode, @Param(value = "type") String type);
    /**
     * 功能描述:获取最新的版本信息
     * 作者:温海金
     * 最后更改时间 : 2017年3月22日 下午1:59:59
     */
    BaseVersion getFinalVersion();

}
