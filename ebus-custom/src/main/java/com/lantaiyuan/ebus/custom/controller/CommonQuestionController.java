package com.lantaiyuan.ebus.custom.controller;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lantaiyuan.ebus.custom.service.CommonQuestionServiceI;

/**
 * 常见问题
 * @author yangyang
 * @date 2017年6月12日 下午2:17:13 
 *
 */
@RestController
@RequestMapping("/commonQuestion")
public class CommonQuestionController extends BasicController  {
	
	@Resource
	private CommonQuestionServiceI commonQuestionService;
	
	@GetMapping("/all")
	public Json all() {
		return setSimpleSuccess(commonQuestionService.selectAll());
	}

	
}
