package com.lantaiyuan.ebus.custom.dao;

import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.custom.model.QuestionnaireSurvey;
import com.lantaiyuan.ebus.custom.model.QuestionnaireSurveyQueryModel;

/**
 * 问卷调查
 * @author yangyang
 * @date 2017年6月12日 下午2:56:33 
 *
 */
public interface QuestionnaireSurveyMapper extends BaseDAO<QuestionnaireSurvey, QuestionnaireSurveyQueryModel>{

	/**
	 * 查出最近的问卷信息
	 * @author yangyang
	 * @return
	 */
	QuestionnaireSurvey selectLastQuestionnaire();
}