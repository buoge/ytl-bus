package com.lantaiyuan.ebus.realtime.controller;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lantaiyuan.ebus.realtime.model.TraveCarSetting;
import com.lantaiyuan.ebus.realtime.service.TraveCarSettingServiceI;


/**
 * 描述:上下车展现设置控制器
 * 作者:温海金
 * 最后更改时间:下午3:52:50
 */
@RestController
@RequestMapping("/traveCarSetting")
public class TraveCarSettingController extends BasicController{
   
    @Resource
    private TraveCarSettingServiceI traveCarSettingService;
    
    /**
     * 功能描述:新增上下车站点设置
     * 作者:温海金
     * 最后更改时间 : 2017年1月4日 上午11:47:57
     */
    @PostMapping(value = "/addTraveCarSetting")
    public Json addTraveCarSetting(TraveCarSetting traveCarSetting) {
	return setSimpleSuccess(traveCarSettingService.insertSelective(traveCarSetting));
    }
    
    @PostMapping(value = "/updateTraveCarSetting")
    public Json updateTraveCarSetting(TraveCarSetting traveCarSetting) {
	return setSimpleSuccess(traveCarSettingService.updateByPrimaryKeySelective(traveCarSetting));
    }
    /**
     * 功能描述:根据id删除版本信息
     * 作者:温海金
     * 最后更改时间 : 2017年1月4日 下午5:20:23
     */
    @DeleteMapping(value = "deleteTraveCarSetting/{id}")
    public Json deleteTraveCarSetting(@PathVariable String id) {
	return setSimpleSuccess(traveCarSettingService.deleteByPrimaryKey(id));
    }
    
    /**
     * 功能描述:分页查询版本信息
     * 作者:温海金
     * 最后更改时间 : 2017年1月4日 下午5:03:52
     */
    /*@PostMapping(value = "getBaseVersionByPage")
    public Json getTraveCarSettingServiceByPage(TraveCarSettingQueryModel versionQueryModel, int page) {
	return setSimpleSuccess(traveCarSettingService.getBaseVersionByPage(versionQueryModel, page));
    }*/
}
