package com.lantaiyuan.ebus.custom.dao.travelaround;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.custom.model.travelaround.TravelAround;
import com.lantaiyuan.ebus.custom.model.travelaround.TravelAroundQueryModel;

public interface TravelAroundMapper extends BaseDAO<TravelAround, TravelAroundQueryModel>{
	List<TravelAround> selectByPage(TravelAroundQueryModel model);
	List<TravelAround> queryTravelList(String cityCode);

	/**
	 * @descption 增加PV数
	 * @param id
	 * @return
	 */
	int addPv(String id);
	
	/**
	 * @descption 减少库存数
	 * @param travelAroundId
	 * @param integer 
	 * @return
	 */
	int reduceTicketNum(@Param("id")String travelAroundId, @Param("num")Integer ticketNum);
}