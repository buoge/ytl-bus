package com.lantaiyuan.ebus.custom.service;

import org.lanqiao.ssm.common.core.service.BaseServiceI;

import com.lantaiyuan.ebus.custom.model.QuestionnaireSurvey;
import com.lantaiyuan.ebus.custom.model.QuestionnaireSurveyQueryModel;

/**
 * 问卷调查
 * @author yangyang
 * @date 2017年6月12日 下午2:59:04 
 *
 */
public interface QuestionnaireSurveyServiceI extends BaseServiceI<QuestionnaireSurvey, QuestionnaireSurveyQueryModel> {

	/**
	 * 查出最近的问卷信息
	 * @author yangyang
	 * @return
	 */
	QuestionnaireSurvey selectLastQuestionnaire();

}
