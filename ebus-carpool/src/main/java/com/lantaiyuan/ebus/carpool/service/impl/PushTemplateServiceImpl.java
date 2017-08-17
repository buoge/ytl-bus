package com.lantaiyuan.ebus.carpool.service.impl;

import java.util.Map;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lantaiyuan.ebus.carpool.dao.PushTemplateMapper;
import com.lantaiyuan.ebus.carpool.model.jpush.PushTemplate;
import com.lantaiyuan.ebus.carpool.model.jpush.PushTemplateQueryModel;
import com.lantaiyuan.ebus.carpool.service.PushTemplateService;
import com.lantaiyuan.ebus.carpool.util.PlaceholderUtils;

@Service
public class PushTemplateServiceImpl extends BaseService<PushTemplate, PushTemplateQueryModel> implements PushTemplateService {
	
	@Autowired
	private PushTemplateMapper pushTemplateMapper;
	
	@Override
	public BaseDAO<PushTemplate, PushTemplateQueryModel> getDao() {
		return pushTemplateMapper;
	}

	@Override
	public PushTemplate getPushTemplateById(Integer id) {
		return pushTemplateMapper.getPushTemplateById(id);
	}

	@Override
	public String getJpushTitle(Integer id) {
		return getPushTemplateById(id).getTitle();
	}

	@Override
	public String getJpushMsg(Integer id, Map<String, String> varMap) {
		return PlaceholderUtils.resolvePlaceholders(getPushTemplateById(id).getContent(), varMap);
	}

}
