package com.lantaiyuan.ebus.custom.controller;

import java.util.Collections;
import java.util.List;
import javax.annotation.Resource;

import org.apache.shiro.util.CollectionUtils;
import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lantaiyuan.ebus.custom.model.Cities;
import com.lantaiyuan.ebus.custom.model.FindAuth;
import com.lantaiyuan.ebus.custom.model.ServiceIp;
import com.lantaiyuan.ebus.custom.model.ServiceIpQueryModel;
import com.lantaiyuan.ebus.custom.service.ServiceIpServiceI;

/**
 * 描述:城市IP配置控制类 作者:温海金 最后更改时间:下午3:52:50
 */
@RestController
@RequestMapping("/serviceIp")
public class ServiceIpController extends BasicController {

	@Resource
	private ServiceIpServiceI serviceIpService;

	/**
	 * 功能描述:新增城市服务IP对象 作者:温海金 最后更改时间 : 2016年12月28日 上午11:45:20
	 */
	@PostMapping(value = "/addServiceIp")
	public Json addServiceIp(ServiceIp serviceIp) {
		return setSimpleSuccess(serviceIpService.insertSelective(serviceIp));
	}

	/**
	 * 功能描述:修改城市服务IP对象 作者:温海金 最后更改时间 : 2016年12月28日 上午11:49:13
	 */
	@PostMapping(value = "/updateServiceIp")
	public Json updateServiceIp(ServiceIp serviceIp) {
		return setSimpleSuccess(serviceIpService.updateByPrimaryKeySelective(serviceIp));
	}
	
	/**
	 * 获取所有城市
	 * @auther yangyang
	 */
	@GetMapping(value = "/cities")
	public Json getAllCities() {
		List<Cities> list = serviceIpService.getCititesForMobile(); 
		return setSimpleSuccess(CollectionUtils.isEmpty(list)? Collections.emptyList() : list);
	}
	
	/**
	 * 获取所有城市
	 * @auther yangyang
	 */
	@GetMapping(value = "/find/auth/{cityCode}")
	public Json getCityFindAuth(@PathVariable String cityCode) {
		FindAuth findAuth = serviceIpService.getCityFindAuth(cityCode);
		return setSimpleSuccess(findAuth);
	}
	
	/**
	 * 功能描述:删除城市服务IP对象 作者:温海金 最后更改时间 : 2016年12月28日 上午11:51:40
	 */
	@DeleteMapping(value = "/deleteServiceIp/{id}")
	public Json deleteServiceIp(@PathVariable String id) {
		return setSimpleSuccess(serviceIpService.deleteByPrimaryKey(id));
	}

	/**
	 * 功能描述:分页查询城市IP信息列表 作者:温海金 最后更改时间 : 2016年12月28日 下午7:12:19
	 */
	@PostMapping(value = "getServiceIpByPage")
	public Json getServiceIpByPage(ServiceIpQueryModel serviceIpQueryModel) {
		return setSimpleSuccess(serviceIpService.findObjectsByPage(serviceIpQueryModel));
	}
	
	
}
