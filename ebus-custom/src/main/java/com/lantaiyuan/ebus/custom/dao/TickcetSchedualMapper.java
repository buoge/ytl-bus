package com.lantaiyuan.ebus.custom.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import com.lantaiyuan.ebus.custom.model.TickcetSchedual;
import com.lantaiyuan.ebus.custom.model.TickcetSchedualQueryModel;

/**
 * 
  * @ClassName: TickcetSchedualMapper
  * @author Yuan.Tan
  * @date 2016年11月8日 上午11:43:20
  *
 */
public interface TickcetSchedualMapper extends BaseDAO<TickcetSchedual, TickcetSchedualQueryModel>{
 
	List<TickcetSchedual> queryTicketByRouteId(String routeid);
 
	int updateRemainTicketNum(String orderNo);
	
	List<TickcetSchedual> queryTicketByRouteId(@Param("routeId")String routeId,@Param("cityCode")String cityCode);
	
	List<TickcetSchedual> getTicketsBeforeMakeOrder(Map<String, Object> params);

	int addRemainTicketNum(String orderNo);
	
	int addRemainTicketNumByTicketId(String ticketId);
}