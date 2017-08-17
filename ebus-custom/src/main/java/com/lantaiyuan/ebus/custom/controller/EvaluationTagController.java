package com.lantaiyuan.ebus.custom.controller;

import javax.annotation.Resource;
import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lantaiyuan.ebus.custom.model.EvaluationTag;
import com.lantaiyuan.ebus.custom.service.EvaluationTagServiceI;

/**
 * 描述:司机评价标签自定义处理控制器
 * 作者:温海金
 * 最后更改时间:下午4:09:39
 */
@RestController
@RequestMapping("/evaluationTag")
public class EvaluationTagController extends BasicController {

	@Resource
	private EvaluationTagServiceI evaluationTagService;

	
	@PostMapping(value = "/addEvaluationTag")
	public Json addEvaluationTag(EvaluationTag evaluationTag) {
		return setSimpleSuccess(evaluationTagService.insertSelective(evaluationTag));
	}

	
	@PostMapping(value = "/updateEvaluationTag")
	public Json updateEvaluationTag(EvaluationTag evaluationTag) {
		return setSimpleSuccess(evaluationTagService.updateByPrimaryKeySelective(evaluationTag));
	}
	
	
	@DeleteMapping(value = "/deleteEvaluationTag/{id}")
	public Json deleteEvaluationTag(@PathVariable String id) {
	    	return setSimpleSuccess(evaluationTagService.deleteByPrimaryKey(id));
	}
	/**
	 * 功能描述:前端根据星级查询司机评价标签，按照count数量降序排列
	 * 作者:温海金
	 * 最后更改时间 : 2017年2月27日 下午5:25:50
	 */
	@GetMapping(value = "getEvaluationTagByCountDesc")
	public Json getEvaluationTagByCountDesc(Integer starLevel) {
	    	return setSimpleSuccess(evaluationTagService.getEvaluationTagByCountDesc(starLevel));
	}

}
