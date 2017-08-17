package com.lantaiyuan.ebus.realtime.dao;

import java.util.List;

import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.realtime.model.LeavingCarAlert;
import com.lantaiyuan.ebus.realtime.model.LeavingCarAlertQueryModel;

public interface LeavingCarAlertMapper extends BaseDAO<LeavingCarAlert, LeavingCarAlertQueryModel>{

    List<LeavingCarAlert> selectByCondition(LeavingCarAlertQueryModel leavingCarAlertQM);
   
}