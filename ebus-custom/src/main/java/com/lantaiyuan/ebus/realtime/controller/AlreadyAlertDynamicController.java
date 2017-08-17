package com.lantaiyuan.ebus.realtime.controller;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lantaiyuan.ebus.realtime.service.AlreadyAlertDynamicServiceI;
@RestController
@RequestMapping("/alreadyAlertDynamic")
public class AlreadyAlertDynamicController extends BasicController  {
    @Resource 
    private AlreadyAlertDynamicServiceI alertDynamicService;
    
}
