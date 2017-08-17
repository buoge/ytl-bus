package com.lantaiyuan.ebus.custom.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.custom.model.BaseBus;
import com.lantaiyuan.ebus.custom.model.BaseBusQueryModel;

/**
 * 车辆mapper
 * @Title: BaseBusMapper.java
 * @Package com.lantaiyuan.ebus.custom.dao
 * @Description:
 * @author yangyang
 * @date 2017年3月22日 上午10:19:16
 * @version v1.0
 */
public interface BaseBusMapper extends BaseDAO<BaseBus, BaseBusQueryModel> {

	/**
	 * 获取某城市所有车辆
	 * @auther yangyang
	 * @param cityCode
	 * @return
	 */
	List<BaseBus> getCityBus(@Param("cityCode") String cityCode);

	List<BaseBus> getBuses(@Param("cityCode") String cityCode, @Param("vehicleIds") List<String> vehicleIds);

	/**
	 * 获取所有车辆
	 * @auther yangyang
	 * @return
	 */
	List<BaseBus> getAllBuses();

}