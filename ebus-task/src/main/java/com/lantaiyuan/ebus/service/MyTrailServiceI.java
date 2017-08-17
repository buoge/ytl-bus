package com.lantaiyuan.ebus.service;


import org.lanqiao.ssm.common.core.service.BaseServiceI;

import com.lantaiyuan.ebus.model.MyTrail;
import com.lantaiyuan.ebus.model.MyTrailQueryModel;
import com.lantaiyuan.ebus.model.ProduceDestPoint;
import com.lantaiyuan.ebus.model.ProduceOriginPoint;

public interface MyTrailServiceI extends BaseServiceI<MyTrail, MyTrailQueryModel> {

	void insertOriginPoint(ProduceOriginPoint originPoint);
	
	void updateDestPoint(ProduceDestPoint destPoint);
	
}
