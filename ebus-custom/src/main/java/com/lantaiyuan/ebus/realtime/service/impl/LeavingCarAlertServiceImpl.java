package com.lantaiyuan.ebus.realtime.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.stereotype.Service;

import com.lantaiyuan.ebus.realtime.dao.LeavingCarAlertMapper;
import com.lantaiyuan.ebus.realtime.model.LeavingCarAlert;
import com.lantaiyuan.ebus.realtime.model.LeavingCarAlertQueryModel;
import com.lantaiyuan.ebus.realtime.service.LeavingCarAlertServiceI;

/**
 * 功能描述:上下车提醒业务实现类
 * 作者:温海金
 * 最后更改时间 : 2017年02月17日 上午10:28:42
 */
@Service("leavingCarAlertService")
public class LeavingCarAlertServiceImpl extends BaseService<LeavingCarAlert, LeavingCarAlertQueryModel> implements LeavingCarAlertServiceI {

	@Resource
	private LeavingCarAlertMapper leavingCarAlertMapper;
	
	@Override
	public BaseDAO<LeavingCarAlert, LeavingCarAlertQueryModel> getDao() {
	    return leavingCarAlertMapper;
	}

	@Override
	public List<LeavingCarAlert> selectByCondition(LeavingCarAlertQueryModel leavingCarAlertQM) {
	    return leavingCarAlertMapper.selectByCondition(leavingCarAlertQM);
	}
	
}