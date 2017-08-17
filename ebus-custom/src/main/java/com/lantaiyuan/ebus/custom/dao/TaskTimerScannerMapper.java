package com.lantaiyuan.ebus.custom.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.lantaiyuan.ebus.custom.model.RelRouteBus;

/**
 * 描述:定时任务持久层接口
 * 作者:温海金
 * 最后更改时间:上午10:42:12
 */
public interface TaskTimerScannerMapper {
	/**
	 * 功能描述:若30分钟没有付款则更改订单表的状态为订单失效
	 * 作者:温海金
	 * 最后更改时间 : 2016年11月21日 上午10:31:48
	 */
	int invalidOrderStatus(Date date);
	
	/**
	 * 功能描述:若30分钟没有付款则包车表中待付款的状态改为已取消
	 * 作者:温海金
	 * 最后更改时间 : 2016年11月25日 上午10:03:50
	 */
	int invalidBookBusStatus(Date date);
	/**
	 * 功能描述:小于当前日期且isOpenToBuy=1的票改为isOpenToBuy=0（不开放购买）
	 * 作者:温海金
	 * 最后更改时间 : 2016年11月28日 下午5:13:53
	 * @param date 
	 */
	//int updateTickcetStatusBeforeNow(String dateStr);
	int updateTickcetStatusBeforeNow(Date date);
	/**
	 * 功能描述:开放购买当前日期到当月最后一天的票 
	 * 作者:温海金
	 * 最后更改时间 : 2016年11月28日 下午5:14:58
	 */
	int updateTickcetStatus4now2lastDay(Date date);
	/**
	 * 功能描述:开放购买下个月的票
	 * 作者:温海金
	 * 最后更改时间 : 2016年11月28日 下午5:15:26
	 */
	int updateTickcetStatusNextMonth();

	 
	int modifyTickcetStatusToExpired(Date date);
	
	List<String> queryUnPaidTicketOrderNum();
	
	int modifyTicketOrderStatus(String orderNo);
	 
	int updateRelRouteBus(Map<String, Object> params);

	int insertToRelRouteBus(List<RelRouteBus> relRouteBusList);

	String findRouteNoByRouteIdAndCity(@Param("routeId")String routeId,@Param("cityCode")String cityCode);
	
	List<String> findVehicleIdByrouteNoAndCity(Map<String, Object> params);
 
	List<String> queryUnPaidOrderNo();
}