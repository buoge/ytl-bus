package com.lantaiyuan.ebus.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import com.lantaiyuan.ebus.model.RelRouteBus;
import com.lantaiyuan.ebus.model.RelRouteBusQueryModel;

/**
 * @Title: RelRouteBusMapper.java
 * @Package com.lantaiyuan.ebus.task.dao
 * @Description:
 * @author yangyang
 * @date 2017年1月16日 上午9:49:23
 * @version v1.0
 */
@Mapper
public interface RelRouteBusMapper extends BaseDAO<RelRouteBus, RelRouteBusQueryModel> {

	/**
	 * 更新线车关系
	 * 
	 * @author yangyang
	 * @param relRouteBus
	 * @return
	 */
	int updateRelRouteBus(RelRouteBus relRouteBus);

	/**
	 * 获取线车关系
	 * 
	 * @author yangyang
	 * @param cityCode
	 * @param vehicleId
	 * @return
	 */
	RelRouteBus getRelRouteBus(@Param("cityCode") String cityCode, @Param("vehicleId") int vehicleId);

	/**
	 * 添加线车关系
	 * @author yangyang
	 * @param cityCode
	 * @param vehicleId
	 * @param routeNo
	 * @return
	 */
	int insertRelRouteBus(@Param("cityCode") String cityCode, @Param("vehicleId") int vehicleId,
			@Param("routeNo") String routeNo);

}