package com.lantaiyuan.ebus.service.impl;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.stereotype.Service;

import com.lantaiyuan.ebus.dao.BaseRouteMapper;
import com.lantaiyuan.ebus.model.BaseRoute;
import com.lantaiyuan.ebus.model.BaseRouteQueryModel;
import com.lantaiyuan.ebus.service.BaseRouteServiceI;

/**
 * @author yangyang
 * @date 2017年4月20日 下午3:54:13 
 *
 */
@Service("baseRouteService")
public class BaseRouteServiceImpl extends BaseService<BaseRoute, BaseRouteQueryModel> implements BaseRouteServiceI {
	@Resource
	private BaseRouteMapper baseRouteMapper;

	@Override
	public BaseDAO<BaseRoute, BaseRouteQueryModel> getDao() {
		return baseRouteMapper;
	}

	/**
	 * 根据routeId, direction, cityCode获取routeNo
	 * @author yangyang
	 * @param routeId
	 * @param direction
	 * @param cityCode
	 * @return
	 */
	@Override
	public String getRouteNo(String routeId, int direction, String cityCode) {
		return baseRouteMapper.getRouteNo(cityCode, direction, routeId);
	}

}
