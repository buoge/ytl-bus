package com.lantaiyuan.ebus.custom.controller;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lantaiyuan.ebus.custom.model.EvaluationGeneralTagQueryModel;
import com.lantaiyuan.ebus.custom.service.EvaluationGeneralTagServiceI;

/**
 * 描述:综合评价控制类
 * 作者:温海金
 * 最后更改时间:下午4:10:43
 */
@RestController
@RequestMapping("/evaluationGeneralTag")
public class EvaluationGeneralTagController extends BasicController  {
	@Resource
	private EvaluationGeneralTagServiceI evaluationGeneralTagService;
	
	@GetMapping(value = "/getEvaluationGeneralTagByAllStars")
	public Json getEvaluationGeneralTagByAllStars(EvaluationGeneralTagQueryModel generalTagQueryModel) {
		return setSimpleSuccess(evaluationGeneralTagService.getEvaluationGeneralTagByAllStars(generalTagQueryModel));
	}
}
