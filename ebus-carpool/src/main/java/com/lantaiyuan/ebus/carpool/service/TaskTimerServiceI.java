/**
* <p>Title: TaskTimerServiceI.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.carpool.service;

import org.lanqiao.ssm.common.core.service.BaseServiceI;

import com.lantaiyuan.ebus.carpool.model.CarpoolOrder;
import com.lantaiyuan.ebus.carpool.model.CarpoolOrderQueryModel;

/**
* <p>Title: TaskTimerServiceI</p>
* <p>Description: 定时业务接口</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年7月13日 下午1:50:11
*/
public interface TaskTimerServiceI extends BaseServiceI<CarpoolOrder, CarpoolOrderQueryModel>{
	int handleUsersInitiatingCarpool(Integer type);
	int handleUsersJoiningCarpool(Integer type);
	int handleUsersCompensatingCarpool(Integer matchStatus, Integer repayStatus);
	
	int handleUsersDrawbackCarpool();
}
