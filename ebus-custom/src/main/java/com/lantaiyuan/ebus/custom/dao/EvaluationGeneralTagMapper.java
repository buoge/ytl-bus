package com.lantaiyuan.ebus.custom.dao;

import java.util.List;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import com.lantaiyuan.ebus.custom.model.EvaluationGeneralTag;
import com.lantaiyuan.ebus.custom.model.EvaluationGeneralTagQueryModel;

public interface EvaluationGeneralTagMapper extends BaseDAO<EvaluationGeneralTag, EvaluationGeneralTagQueryModel>{

	List<EvaluationGeneralTag> findObjectsByCondition(EvaluationGeneralTagQueryModel generalTagQueryModel);
	
}