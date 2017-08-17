package com.lantaiyuan.ebus.carpool.dao;

import com.lantaiyuan.ebus.carpool.model.UserOd;
import com.lantaiyuan.ebus.carpool.model.UserOdQueryModel;
import org.apache.ibatis.annotations.Mapper;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import java.util.List;

@Mapper
public interface UserOdMapper extends BaseDAO<UserOd, UserOdQueryModel>{

    int insertBatch(List<UserOd> list);

    int deleteOldOD();

}