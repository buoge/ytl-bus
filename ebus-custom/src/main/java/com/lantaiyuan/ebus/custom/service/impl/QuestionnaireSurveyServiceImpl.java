package com.lantaiyuan.ebus.custom.service.impl;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.stereotype.Service;

import com.lantaiyuan.ebus.custom.dao.QuestionnaireSurveyMapper;
import com.lantaiyuan.ebus.custom.model.QuestionnaireSurvey;
import com.lantaiyuan.ebus.custom.model.QuestionnaireSurveyQueryModel;
import com.lantaiyuan.ebus.custom.service.QuestionnaireSurveyServiceI;

/**
 * 问卷调查
 * @author yangyang
 * @date 2017年6月12日 下午2:55:07 
 */
@Service("questionnaireSurveyService")
public class QuestionnaireSurveyServiceImpl extends BaseService<QuestionnaireSurvey, QuestionnaireSurveyQueryModel>
		implements QuestionnaireSurveyServiceI {
	@Resource
	private QuestionnaireSurveyMapper questionnaireSurveyMapper;

	@Override
	public BaseDAO<QuestionnaireSurvey, QuestionnaireSurveyQueryModel> getDao() {
		return questionnaireSurveyMapper;
	}
	
	/**
	 * 查出最近的问卷信息 
	 * @author yangyang
	 * @return
	 */
	@Override
	public QuestionnaireSurvey selectLastQuestionnaire() {
		return questionnaireSurveyMapper.selectLastQuestionnaire();
	}

}