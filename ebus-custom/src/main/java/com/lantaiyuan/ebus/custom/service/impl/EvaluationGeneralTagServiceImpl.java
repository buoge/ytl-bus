package com.lantaiyuan.ebus.custom.service.impl;

import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;

import org.apache.shiro.util.CollectionUtils;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.stereotype.Service;
import com.lantaiyuan.ebus.custom.dao.EvaluationGeneralTagMapper;
import com.lantaiyuan.ebus.custom.model.EvaluationGeneralTag;
import com.lantaiyuan.ebus.custom.model.EvaluationGeneralTagQueryModel;
import com.lantaiyuan.ebus.custom.service.EvaluationGeneralTagServiceI;

@Service("evaluationGeneralTagService")
public class EvaluationGeneralTagServiceImpl extends BaseService<EvaluationGeneralTag, EvaluationGeneralTagQueryModel> implements EvaluationGeneralTagServiceI {
	@Resource
	private EvaluationGeneralTagMapper evaluationGeneralTagMapper;

	@Override
	public BaseDAO<EvaluationGeneralTag, EvaluationGeneralTagQueryModel> getDao() {
		return evaluationGeneralTagMapper;
	}
	
	@Override
	public int insertSelective(EvaluationGeneralTag record) {
		record.setId(UUID.randomUUID().toString());
		return super.insertSelective(record);
	}

	@Override
	public List<EvaluationGeneralTag> findObjectsByCondition(EvaluationGeneralTagQueryModel generalTagQueryModel) {
		return evaluationGeneralTagMapper.findObjectsByCondition(generalTagQueryModel);
	}

	@Override
	public EvaluationGeneralTag getEvaluationGeneralTagByAllStars(EvaluationGeneralTagQueryModel generalTagQueryModel) {
		List<EvaluationGeneralTag> generalTags = findObjectsByCondition(generalTagQueryModel);
		if (!CollectionUtils.isEmpty(generalTags)) {
			return generalTags.get(0);
		}
		return new EvaluationGeneralTag();
	}

}