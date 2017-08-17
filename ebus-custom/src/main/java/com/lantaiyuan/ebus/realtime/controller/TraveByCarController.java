package com.lantaiyuan.ebus.realtime.controller;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lantaiyuan.ebus.realtime.service.TraveByCarServiceI;

/**
 * 描述:下车提醒控制类(对应动态表)
 * 作者:温海金
 * 最后更改时间:下午3:52:50
 */
@RestController
@RequestMapping("/traveByCar")
public class TraveByCarController extends BasicController{
        
    @Resource
    private TraveByCarServiceI traveByCarService;
   
}
