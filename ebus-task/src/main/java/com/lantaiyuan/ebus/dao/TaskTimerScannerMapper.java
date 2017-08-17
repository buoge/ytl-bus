package com.lantaiyuan.ebus.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lantaiyuan.ebus.model.BaseTravelOrder;
import com.lantaiyuan.ebus.model.Favoriate;
import com.lantaiyuan.ebus.model.RelRouteBus;

/**
 * 描述:定时任务持久层接口
 * 作者:温海金
 * 最后更改时间:上午10:42:12
 */
@Mapper
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


	String findRouteNoByRouteIdAndCity(@Param("routeId")String routeId,@Param("cityCode")String cityCode);
	
	List<String> findVehicleIdByrouteNoAndCity(Map<String, Object> params);
 
	List<String> queryUnPaidOrderNo();

	/**
	 * 功能描述:每天凌晨定时清空用户上车提醒动态表JPUSH_ALREADY_ALERT_DYNAMIC
	 * 作者:温海金
	 * 最后更改时间 : 2017年2月24日 上午10:41:17
	 */
	void clearTheDataOfAlreadyAlert();
	
	/**
	 * 功能描述: 每天凌晨定时清空用户下车提醒动态表中已经提醒过的数据#DELETE from t_trave_car_setting where IS_REMIND = TRUE;
	 * 作者:温海金
	 * 最后更改时间 : 2017年3月21日 下午6:01:29
	 */
	void clearTheDataInLeavingCarAlert();
	
	int insertToRelRouteBus(List<RelRouteBus> relRouteBusList);

	int updateStatusToUsed(String ticketId);
	
	int addRemainTicketNum(String orderNo);
	/**
	 * 功能描述:根据线路ID和cityCode查询收藏列表
	 * 作者:YvanTan
	 * 最后更改时间 : 2017年5月2日 下午7:23:32
	 */
	List<Favoriate> findFavoriateByRouteAndCity(@Param("routeId") String routeId, @Param("cityCode") String cityCode);
	/**
	 * 功能描述:更新订单表 过期未支付(60分钟)的周边游订单为：3-订单失效
	 * 作者:YvanTan
	 * 最后更改时间 : 2017年7月31日 下午7:23:32
	 */
	int updateBaseOrderStatusToInvalid();
	
	/**
	 * 功能描述:更新周边游订单详情表base_booktravel  过期未支付(60分钟)的周边游订单为：4-订单失效
	 * 作者:YvanTan
	 * 最后更改时间 : 2017年7月31日 下午7:23:32
	 */
	int updateTravelOrderStatusToInvalid();
	
	/**
	 * 功能描述:根据周边游ID分组 统计未支付周边游订单的总票数
	 * 作者:YvanTan
	 * 最后更改时间 : 2017年7月31日 下午7:23:32
	 */
	List<BaseTravelOrder> queryUnPaidTravelOrderTicketNum();
	
	/**
	 * 功能描述:根据周边游ID将超时未支付周边游订单的票重新进入票池
	 * 作者:YvanTan
	 * 最后更改时间 : 2017年7月31日 下午7:23:32
	 */
	int updateTravelTicketNumById(@Param("id")String id,@Param("num")int num);
}