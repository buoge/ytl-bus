package com.lantaiyuan.ebus.custom.dao;

import java.util.List;
import com.lantaiyuan.ebus.carpool.model.CarpoolRouteStation;
import com.lantaiyuan.ebus.carpool.model.CarpoolRouteStationQueryModel;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

/**
 * 拼车线站关系
 * 
 * @author yangyang
 * @date 2017年6月14日 下午2:28:16
 *
 */
public interface CarpoolRouteStationMapper extends BaseDAO<CarpoolRouteStation, CarpoolRouteStationQueryModel> {

	List<CarpoolRouteStation> findByRouteId(CarpoolRouteStation model);
	/**
	 * 功能描述:查询起点站或终点站
	 * 作者:温海金
	 * 最后更改时间 : 2017年7月18日 下午6:36:00
	 * @param stationType 
	 * @param carpoolRouteId 
	 */
	CarpoolRouteStation findStartOrEndStation(@Param("carpoolRouteId") String carpoolRouteId, @Param("stationType") Byte stationType);
}