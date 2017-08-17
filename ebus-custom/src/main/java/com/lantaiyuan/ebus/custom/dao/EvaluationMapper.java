package com.lantaiyuan.ebus.custom.dao;

import java.util.List;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import com.lantaiyuan.ebus.custom.model.Evaluation;
import com.lantaiyuan.ebus.custom.model.EvaluationPieQueryModel;
import com.lantaiyuan.ebus.custom.model.EvaluationQueryModel;

public interface EvaluationMapper extends BaseDAO<Evaluation, EvaluationQueryModel>{

	List<Evaluation> findEvalutionListByPage(EvaluationQueryModel evaluationQueryModel);
 
	List<Evaluation> findEvaluationPieByPage(EvaluationPieQueryModel evaluationPieQueryModel);

}