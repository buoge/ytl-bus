package com.lantaiyuan.ebus.custom.dao;

import com.lantaiyuan.ebus.carpool.model.UserOd;
import com.lantaiyuan.ebus.carpool.model.UserOdQueryModel;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import java.util.List;

public interface UserOdMapper extends BaseDAO<UserOd, UserOdQueryModel>{

    int insertBatch(List<UserOd> list);

    int deleteOldOD();
    /**
     * 功能描述:根据用户ID得到常用OD点
     * 作者:温海金
     * 最后更改时间 : 2017年7月20日 下午2:40:07
     */
	UserOd getODByUserId(@Param("userId") Integer userId);

}