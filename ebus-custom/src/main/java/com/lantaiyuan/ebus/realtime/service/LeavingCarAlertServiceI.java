package com.lantaiyuan.ebus.realtime.service;

import java.util.List;

import org.lanqiao.ssm.common.core.service.BaseServiceI;

import com.lantaiyuan.ebus.realtime.model.LeavingCarAlert;
import com.lantaiyuan.ebus.realtime.model.LeavingCarAlertQueryModel;

public interface LeavingCarAlertServiceI extends BaseServiceI<LeavingCarAlert, LeavingCarAlertQueryModel>{

    List<LeavingCarAlert> selectByCondition(LeavingCarAlertQueryModel leavingCarAlertQM);

}
