package com.lantaiyuan.ebus.service.impl;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.stereotype.Service;

import com.lantaiyuan.ebus.dao.RelRouteBusMapper;
import com.lantaiyuan.ebus.model.RelRouteBus;
import com.lantaiyuan.ebus.model.RelRouteBusQueryModel;
import com.lantaiyuan.ebus.service.RelRouteBusServiceI;

/**
 * @author yangyang
 * @date 2017年4月20日 下午3:54:13 
 */
@Service("relRouteBusService")
public class RelRouteBusServiceImpl extends BaseService<RelRouteBus, RelRouteBusQueryModel> implements RelRouteBusServiceI {
	@Resource
	private RelRouteBusMapper relRouteBusMapper;

	@Override
	public BaseDAO<RelRouteBus, RelRouteBusQueryModel> getDao() {
		return relRouteBusMapper;
	}
	
	/**
	 * 更新线车关系
	 * @author yangyang
	 * @param cityCode
	 * @param vehicleId
	 * @param routeNo			新的routeNo
	 * @return
	 */
	@Override
	public boolean updateRouteNo(String cityCode, int vehicleId, String routeNo) {
		return relRouteBusMapper.updateRelRouteBus(new RelRouteBus(routeNo, vehicleId, cityCode)) >= 1;
	}
	
	/**
	 * 获取线车关系
	 * @author yangyang
	 * @param cityCode
	 * @param vehicleId
	 * @return
	 */
	@Override
	public RelRouteBus getRelRouteBus(String cityCode, int vehicleId) {
		return relRouteBusMapper.getRelRouteBus(cityCode, vehicleId);
	}
	
	/**
	 * 添加线车关系
	 * @author yangyang
	 * @param cityCode
	 * @param vehicleId
	 * @param routeNo
	 * @return
	 */
	@Override
	public boolean insertRelRouteBus(String cityCode, int vehicleId, String routeNo) {
		return relRouteBusMapper.insertRelRouteBus(cityCode, vehicleId, routeNo) >= 1;
	}


}
