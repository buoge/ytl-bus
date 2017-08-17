package com.lantaiyuan.ebus.custom.controller;

import javax.annotation.Resource;
import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lantaiyuan.ebus.custom.model.MyTrailEvaluate;
import com.lantaiyuan.ebus.custom.model.MyTrailEvaluateQueryModel;
import com.lantaiyuan.ebus.custom.service.MyTrailEvaluateServiceI;

/**
 * 描述:我的行程评价业务控制器
 * 作者:温海金
 * 最后更改时间:上午10:37:50
 */
@RestController
@RequestMapping("/myTrailEvaluate")
public class MyTrailEvaluateController extends BasicController{
   
    @Resource
    private MyTrailEvaluateServiceI myTrailEvaluateService;
    
    /**
     * 功能描述:新增我的行程评价信息
     * 作者:温海金
     * 最后更改时间 : 2017年1月4日 上午11:47:57
     */
    @PostMapping(value = "/addMyTrailEvaluate")
    public Json addMyTrailEvaluate(MyTrailEvaluate myTrailEvaluate) {
	return setSimpleSuccess(myTrailEvaluateService.insertSelective(myTrailEvaluate));
    }

    
    /**
     * 功能描述:修改我的行程评价信息
     * 作者:温海金
     * 最后更改时间 : 2017年1月4日 下午5:13:42
     */
    @PostMapping(value = "updateMyTrailEvaluate")
    public Json updateMyTrailEvaluate(MyTrailEvaluate myTrailEvaluate) {
	return setSimpleSuccess(myTrailEvaluateService.updateByPrimaryKeySelective(myTrailEvaluate));
    }
    
    /**
     * 功能描述:根据id删除我的行程评价信息
     * 作者:温海金
     * 最后更改时间 : 2017年1月4日 下午5:20:23
     */
    @DeleteMapping(value = "deleteMyTrailEvaluate/{id}")
    public Json deleteMyTrailEvaluate(@PathVariable String id) {
	return setSimpleSuccess(myTrailEvaluateService.deleteByPrimaryKey(id));
    }
    
    /**
     * 功能描述:分页查询我的行程评价信息
     * 作者:温海金
     * 最后更改时间 : 2017年1月4日 下午5:03:52
     */
    @PostMapping(value = "getMyTrailEvaluateByPage")
    public Json getMyTrailEvaluateByPage(MyTrailEvaluateQueryModel myTrailEvaluateQM, int page) {
	//TODO
	return null;
    }
}
