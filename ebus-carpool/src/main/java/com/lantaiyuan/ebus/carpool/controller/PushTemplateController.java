package com.lantaiyuan.ebus.carpool.controller;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.model.Json;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lantaiyuan.ebus.carpool.controller.base.BasicController;
import com.lantaiyuan.ebus.carpool.model.jpush.PushTemplate;
import com.lantaiyuan.ebus.carpool.service.PushMsgService;
import com.lantaiyuan.ebus.carpool.service.PushTemplateService;


/**
 * 描述:消息模板业务控制类
 * 作者:温海金
 * 最后更改时间:下午3:05:41
 */
@EnableAutoConfiguration
@RestController
@RequestMapping("/pushTemplate")
public class PushTemplateController extends BasicController {
	@Resource
	private PushTemplateService pushTemplateService;
	
	@Resource
	private PushMsgService pushMsgService;
	
	/**
	 * 功能描述:创建极光推送模板
	 * 作者:温海金
	 * 最后更改时间 : 2017年7月14日 下午6:42:33
	 */
	@PostMapping("/createPushTemplate")
	public Json createPushTemplate(PushTemplate pushTemplate) {
		return setSimpleSuccess(pushTemplateService.insertSelective(pushTemplate));
	}
	/**
	 * 功能描述:获取极光模板对象
	 * 作者:温海金
	 * 最后更改时间 : 2017年7月14日 下午6:42:48
	 */
	@GetMapping("/getPushTemplateById")
	public Json getPushTemplateById(@RequestParam Integer id) {
		return setSimpleSuccess(pushTemplateService.getPushTemplateById(id));
	}
	/**
	 * 功能描述:根据用户ID获取极光ID
	 * 作者:温海金
	 * 最后更改时间 : 2017年7月14日 下午6:44:27
	 */
	@GetMapping("/getRegIdByUserId")
	public Json getRegIdByUserId(@RequestParam Integer userId) {
		return setSimpleSuccess(pushMsgService.getRegIdByUserId(userId));
	}
	
	/**
	 * 功能描述:根据用户ID获取简单的用户信息
	 * 作者:温海金
	 * 最后更改时间 : 2017年7月14日 下午6:44:27
	 */
	@GetMapping("/getUserSimpleInfoByUserId")
	public Json getUserSimpleInfoByUserId(@RequestParam Integer userId) {
		return setSimpleSuccess(pushMsgService.getUserSimpleInfoByUserId(userId));
	}
	

}
