package com.lantaiyuan.ebus.custom.controller;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.lantaiyuan.ebus.custom.model.BaseVersion;
import com.lantaiyuan.ebus.custom.model.BaseVersionQueryModel;
import com.lantaiyuan.ebus.custom.service.VersionServiceI;


/**
 * 描述:版本更新控制类
 * 作者:温海金
 * 最后更改时间:下午3:52:50
 */
@RestController
@RequestMapping("/version")
public class VersionController extends BasicController{
   
    @Resource
    private VersionServiceI versionService;
    
    /**
     * 功能描述:新增版本信息
     * 作者:温海金
     * 最后更改时间 : 2017年1月4日 上午11:47:57
     */
    @PostMapping(value = "/addVersion")
    public Json addVersion(@Validated BaseVersion baseVersion) {
	return setSimpleSuccess(versionService.insertSelective(baseVersion));
    }
    
    /**
     * 功能描述:版本查询与更新接口
     * 作者:温海金
     * 最后更改时间 : 2017年1月4日 上午11:44:01
     */
    @GetMapping(value = "/needUpdate/{citycode}/{versionid}/{type}")
    public Json isNeedUpdate(@PathVariable String citycode, @PathVariable String versionid,@PathVariable String type) {
	return setSimpleSuccess(versionService.queryBaseVersion(citycode, versionid, type));
    }
    
    /**
     * 功能描述:修改版本信息
     * 作者:温海金
     * 最后更改时间 : 2017年1月4日 下午5:13:42
     */
    @PostMapping(value = "/updateVersion")
    public Json updateVersion(BaseVersion baseVersion) {
	return setSimpleSuccess(versionService.updateByPrimaryKeySelective(baseVersion));
    }
    
    /**
     * 功能描述:根据id删除版本信息
     * 作者:温海金
     * 最后更改时间 : 2017年1月4日 下午5:20:23
     */
    @DeleteMapping(value = "/deleteVersion/{id}")
    public Json deleteVersion(@PathVariable String id) {
	return setSimpleSuccess(versionService.deleteByPrimaryKey(id));
    }
    
    /**
     * 功能描述:分页查询版本信息
     * 作者:温海金
     * 最后更改时间 : 2017年1月4日 下午5:03:52
     */
    @PostMapping(value = "/getBaseVersionByPage")
    public Json getBaseVersionByPage(BaseVersionQueryModel versionQueryModel,  @RequestParam int page) {
	return setSimpleSuccess(versionService.getBaseVersionByPage(versionQueryModel, page));
    }
    
    /**
     * 功能描述:获取数据库中最新的版本信息
     * 作者:温海金
     * 最后更改时间 : 2017年3月22日 下午1:57:45
     */
    @GetMapping(value = "/getFinalVersion")
    public Json getFinalVersion() {
	return setSimpleSuccess(versionService.getFinalVersion());
    }
}
