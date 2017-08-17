package com.lantaiyuan.ebus.realtime.controller;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lantaiyuan.ebus.realtime.model.LeavingCarAlert;
import com.lantaiyuan.ebus.realtime.service.LeavingCarAlertServiceI;


/**
 * 描述:下车提醒控制类(对应动态表)
 * 作者:温海金
 * 最后更改时间:下午3:52:50
 */
@RestController
@RequestMapping("/leavingCarAlert")
public class LeavingCarAlertController extends BasicController{
   
    @Resource
    private LeavingCarAlertServiceI leavingCarAlertService;
    
    /**
     * 功能描述:新增下车提醒信息至动态表
     * 作者:温海金
     * 最后更改时间 : 2017年1月4日 上午11:47:57
     */
    @PostMapping(value = "/addLeavingCarAlert")
    public Json addLeavingCarAlert(LeavingCarAlert leavingCarAlert) {
	return setSimpleSuccess(leavingCarAlertService.insertSelective(leavingCarAlert));
    }
    
    
    /**
     * 功能描述:更新下车提醒信息
     * 作者:温海金
     * 最后更改时间 : 2017年1月4日 下午5:13:42
     */
    @PostMapping(value = "/updateLeavingCarAlert")
    public Json updateLeavingCarAlert(LeavingCarAlert leavingCarAlert) {
	return setSimpleSuccess(leavingCarAlertService.updateByPrimaryKeySelective(leavingCarAlert));
    }
    
    /**
     * 功能描述:根据ID从动态表中删除下车提醒信息
     * 作者:温海金
     * 最后更改时间 : 2017年1月4日 下午5:20:23
     */
    @DeleteMapping(value = "deleteLeavingCarAlert/{id}")
    public Json deleteLeavingCarAlert(@PathVariable String id) {
	return setSimpleSuccess(leavingCarAlertService.deleteByPrimaryKey(id));
    }
    
}
