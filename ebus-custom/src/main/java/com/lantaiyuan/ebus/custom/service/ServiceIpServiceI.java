package com.lantaiyuan.ebus.custom.service;

import java.util.List;
import java.util.Set;

import org.lanqiao.ssm.common.core.service.BaseServiceI;
import org.lanqiao.ssm.common.page.Page;

import com.lantaiyuan.ebus.custom.model.Cities;
import com.lantaiyuan.ebus.custom.model.FindAuth;
import com.lantaiyuan.ebus.custom.model.ServiceIp;
import com.lantaiyuan.ebus.custom.model.ServiceIpQueryModel;

/**
 * 描述:城市IP配置服务接口
 * 作者:温海金
 * 最后更改时间:上午11:29:20
 */
public interface ServiceIpServiceI extends BaseServiceI<ServiceIp, ServiceIpQueryModel> {

    /**
     * 功能描述:分页查询城市IP配置对象列表
     * 作者:温海金
     * 最后更改时间 : 2016年12月28日 下午2:22:56
     */
    Page<ServiceIp> findObjectsByPage(ServiceIpQueryModel serviceQM, int page);

    /**
     * 获取城市 for web 后台
     * @auther yangyang
     */
	List<ServiceIp> getCities(String cityCode);
	 /**
     * 查找发现权限
     * @auther yangyang
     */
	Integer selectAuthorityByCityCode(String cityCode);
	/**
     * 获取城市 for 手机端
     * @auther yangyang
     */
	List<Cities> getCititesForMobile();
	
	/**
     * 获取某城市的ip配置信息
     * @auther yangyang
     */
	ServiceIp getServiceIp(String cityCode);
	/**
	 * 功能描述:获取所有的cityCode
	 * 作者:温海金
	 * 最后更改时间 : 2017年3月24日 下午4:54:35
	 */
	Set<String> getAllDistinctCityCodes();
	
	
	FindAuth getCityFindAuth(String cityCode);

}
