package com.lantaiyuan.ebus.custom.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.custom.model.Cities;
import com.lantaiyuan.ebus.custom.model.ServiceIp;
import com.lantaiyuan.ebus.custom.model.ServiceIpQueryModel;
/**
 * 描述:城市IP服务配置数据库持久层
 * 作者:温海金
 * 最后更改时间:上午11:16:56
 */
public interface ServiceIpMapper extends BaseDAO<ServiceIp, ServiceIpQueryModel>{
	
	/**
	 * 查出城市
	 * @auther yangyang
	 */
	List<ServiceIp> getCitites(@Param("cityCode")String cityCode);

	Integer selectAuthorityByCityCode(@Param("cityCode")String cityCode);

	/**
	 * 查出城市代码、城市名称、图片链接，提供给手机端的接口
	 * @auther yangyang
	 * @return
	 */
	List<Cities> getCititesForMobile();

	ServiceIp getServiceIp(@Param("cityCode")String cityCode);
	
	/**
	 * 功能描述:获取所有的cityCode
	 * 作者:温海金
	 * 最后更改时间 : 2017年3月24日 下午4:54:35
	 */
	Set<String> getAllDistinctCityCodes();
	
	/**
	 * 查询城市发现权限
	 * @author yangyang
	 * @param cityCode
	 * @return
	 */
	String selectAuthDescByCityCode(@Param("cityCode")String cityCode);

}