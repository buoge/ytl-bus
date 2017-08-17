package com.lantaiyuan.ebus.realtime.controller;


import java.util.List;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.lantaiyuan.ebus.realtime.model.GotoCarAlertSetting;
import com.lantaiyuan.ebus.realtime.model.GotoCarAlertSettingModel;
import com.lantaiyuan.ebus.realtime.service.GotoCarAlertSettingServiceI;

@RestController
@RequestMapping("/gotoCarAlertSetting")
public class GotoCarAlertSettingController extends BasicController{
    @Resource 
    private GotoCarAlertSettingServiceI gotoCarAlertSettingService;
    
    /**
     * 功能描述:批量新增上车提醒配置信息
     * 作者:温海金
     * 参数:gotoCarAlertSettings格式 
     * {"alertStrategy":"2","cityCode":"0917","endTime":"08:30","isOpen":"0","startTime":"08:30","tag":"2","userId":"10"};
     * {"alertStrategy":"2","cityCode":"0917","endTime":"08:30","isOpen":"0","startTime":"08:30","tag":"1","userId":"10"}
     * 最后更改时间 : 2017年1月4日 上午11:47:57
     */
    @PostMapping(value = "/addGotoCarAlertSettingArr")
    public Json addGotoCarAlertSettingArr(String gotoCarAlertSettings) {
	List<GotoCarAlertSettingModel> objs = JSON.parseArray(gotoCarAlertSettings, GotoCarAlertSettingModel.class);
	return setSimpleSuccess(gotoCarAlertSettingService.insertArrayWithDataModels(objs));
    }
    /**
     * 功能描述:批量新增上车提醒配置信息
     * 作者:温海金
     * 参数:gotoCarAlertSettings格式 
     * {"alertStrategy":"2","cityCode":"0917","endTime":"08:30","isOpen":"0","startTime":"08:30","tag":"2","userId":"10"};
     * {"alertStrategy":"2","cityCode":"0917","endTime":"08:30","isOpen":"0","startTime":"08:30","tag":"1","userId":"10"}
     * 最后更改时间 : 2017年1月4日 上午11:47:57
     */
   /* @PostMapping(value = "/addGotoCarAlertSettingArr4Android")
    public Json addGotoCarAlertSettingArr4Android(String gotoCarAlertSettings) {
	return setSimpleSuccess(gotoCarAlertSettingService.insertArray(gotoCarAlertSettings));
    }*/
    /**
     * 功能描述:新增上车提醒配置信息
     * 作者:温海金
     * 最后更改时间 : 2017年1月4日 上午11:47:57
     */
    @PostMapping(value = "/addGotoCarAlertSetting")
    public Json addGotoCarAlertSetting(GotoCarAlertSetting GotoCarAlertSetting) {
	return setSimpleSuccess(gotoCarAlertSettingService.insertSelective(GotoCarAlertSetting));
    }
    
    /**
     * 功能描述:批量更新上车提醒配置信息
     * 参数:与批量新增唯一的区别就是客户端会把实体id传过来
     * 作者:温海金
     * 最后更改时间 : 2017年1月4日 下午5:13:42
     */
    @PostMapping(value = "updateGotoCarAlertSettingArr")
    public Json updateGotoCarAlertSettingArr(String gotoCarAlertSettings) {
	List<GotoCarAlertSettingModel> objs = JSON.parseArray(gotoCarAlertSettings, GotoCarAlertSettingModel.class);
	return setSimpleSuccess(gotoCarAlertSettingService.updateArrayWithDataModels(objs));
    }
    //test
   /* @PostMapping(value = "updateGotoCarAlertSettingArr4Android")
    public Json updateGotoCarAlertSettingArr4Android(String gotoCarAlertSettings) {
	return setSimpleSuccess(gotoCarAlertSettingService.updateArray(gotoCarAlertSettings));
    }*/
    //test
  /*  @RequestMapping(value = "addGotoCarAlertSettingArr1")
    public Json insertArray(GotoCarAlertSetting[] gotoCarAlertSettings) {
	System.err.println(gotoCarAlertSettings.length);
	return setSimpleSuccess();
    }
    //test
    @RequestMapping(value = "addGotoCarAlertSettingArr2")
    public Json insertArray(ArrayList<GotoCarAlertSetting> gotoCarAlertSettings) {
	System.err.println(gotoCarAlertSettings.size());
	return setSimpleSuccess();
    }*/
    
    
    /**
     * 功能描述:更新上车提醒配置信息
     * 作者:温海金
     * 最后更改时间 : 2017年1月4日 下午5:13:42
     */
    @PostMapping(value = "updateGotoCarAlertSetting")
    public Json updateGotoCarAlertSetting(GotoCarAlertSetting GotoCarAlertSetting) {
	return setSimpleSuccess(gotoCarAlertSettingService.updateByPrimaryKeySelective(GotoCarAlertSetting));
    }
    
    /**
     * 功能描述:根据城市编码和用户Id查询提醒设置信息
     * 作者:温海金
     * 最后更改时间 : 2017年3月3日 下午4:09:58
     */
    @GetMapping(value = "getGotoCarAlertSettings/{cityCode}/{userId}")
    public Json getGotoCarAlertSettings(@PathVariable("cityCode") String cityCode, @PathVariable("userId") Integer userId){
	List<GotoCarAlertSetting> gotoCarAlertSettings = gotoCarAlertSettingService.getGotoCarAlertSettings(cityCode, userId);
	return setSimpleSuccess(gotoCarAlertSettings);
    }
    
}
