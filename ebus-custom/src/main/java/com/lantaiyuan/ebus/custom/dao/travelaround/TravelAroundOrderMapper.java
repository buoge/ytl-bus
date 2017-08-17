package com.lantaiyuan.ebus.custom.dao.travelaround;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import com.lantaiyuan.ebus.custom.model.travelaround.TravelAroundOrder;
import com.lantaiyuan.ebus.custom.model.travelaround.TravelAroundOrderDetail;
import com.lantaiyuan.ebus.custom.model.travelaround.TravelAroundOrderQueryModel;
import com.lantaiyuan.ebus.custom.model.travelaround.TravelAroundOrderResult;

public interface TravelAroundOrderMapper extends BaseDAO<TravelAroundOrder, TravelAroundOrderQueryModel> {
	/**
	 * 
	 * @param userId
	 * @param cityCode
	 * @return 周边游订单列表
	 */
	List<TravelAroundOrderResult> queryTravelOrderList(@Param("userId")int userId, @Param("cityCode")String cityCode);

	TravelAroundOrderDetail queryTravelOrderByOrderNo(String orderNo);

	int updateTravelOrderToPaid(String orderNo);
}