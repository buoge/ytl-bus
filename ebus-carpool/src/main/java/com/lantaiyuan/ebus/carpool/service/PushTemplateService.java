package com.lantaiyuan.ebus.carpool.service;

import java.util.Map;

import org.lanqiao.ssm.common.core.service.BaseServiceI;

import com.lantaiyuan.ebus.carpool.model.jpush.PushTemplate;
import com.lantaiyuan.ebus.carpool.model.jpush.PushTemplateQueryModel;

public interface PushTemplateService extends BaseServiceI<PushTemplate, PushTemplateQueryModel>{
	
	PushTemplate getPushTemplateById(Integer id);
	
	String getJpushTitle(Integer id);
	
	String getJpushMsg(Integer id, Map<String, String> varMap);
	
}
