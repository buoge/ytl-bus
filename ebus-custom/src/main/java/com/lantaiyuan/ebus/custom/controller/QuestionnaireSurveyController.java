package com.lantaiyuan.ebus.custom.controller;

import java.util.Objects;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lantaiyuan.ebus.custom.model.QuestionnaireSurvey;
import com.lantaiyuan.ebus.custom.service.QuestionnaireSurveyServiceI;

/**
 * 问卷调查
 * @author yangyang
 * @date 2017年6月12日 下午2:19:41 
 *
 */
@RestController
@RequestMapping("/questionnaireSurvey")
public class QuestionnaireSurveyController extends BasicController {
	@Resource
	private QuestionnaireSurveyServiceI questionnaireSurveyService;
	
	/**
	 * 查询出最近的问卷信息
	 * @author yangyang
	 * @return
	 */
	@GetMapping(value = "/last")
	public Json selectLastQuestionnaire() {
		QuestionnaireSurvey questionnaireSurvey = questionnaireSurveyService.selectLastQuestionnaire();
		if (Objects.isNull(questionnaireSurvey)) {
			questionnaireSurvey = new QuestionnaireSurvey();
		}
		return setSimpleSuccess(questionnaireSurvey);
	}
	
}