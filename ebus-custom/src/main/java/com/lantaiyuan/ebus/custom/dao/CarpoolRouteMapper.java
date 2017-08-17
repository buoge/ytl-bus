package com.lantaiyuan.ebus.custom.dao;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.carpool.model.CarpoolRoute;
import com.lantaiyuan.ebus.carpool.model.CarpoolRouteQueryModel;
import com.lantaiyuan.ebus.custom.model.carpool.CarpoolRouteDetail;

/**
 * 拼车线路
 * @author yangyang
 * @date 2017年6月14日 下午2:24:14 
 */
public interface CarpoolRouteMapper extends BaseDAO<CarpoolRoute, CarpoolRouteQueryModel>{
   
	/**
	 * 查看线路详情
	 * @author yangyang
	 * @param carpoolRouteId
	 * @return
	 */
	CarpoolRouteDetail selectRouteDetailByCarpoolRouteId(@Param("carpoolRouteId")String carpoolRouteId);
}