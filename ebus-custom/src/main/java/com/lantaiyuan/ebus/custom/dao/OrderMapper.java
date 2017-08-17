package com.lantaiyuan.ebus.custom.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import com.lantaiyuan.ebus.custom.model.Order;
import com.lantaiyuan.ebus.custom.model.OrderQueryModel;
import com.lantaiyuan.ebus.custom.model.TicketOrder;
import com.lantaiyuan.ebus.custom.model.TicketStatus;

/**
 * 
  * @ClassName: OrderMapper
  * @author Yuan.Tan
  * @date 2016年11月8日 上午11:43:07
  *
 */
public interface OrderMapper extends BaseDAO<Order, OrderQueryModel> {
	 
	Order selectByOrderNo(String orderno);
	
	/**
	 * 查询数据库状态为未支付的订单  
	 */
	Order selectUnpaidByOrderNo(String orderno);
 
	int queryUnPaidOrderNums(String userid);

	List<Order> queryUnPaidOrder(String userid);
	
	/**
	 * 功能描述:查询包车订单
	 * 作者:温海金
	 * 最后更改时间 : 下午5:10:30
	 */
	List<Map<String, Object>> selectBookBusOrder(Map<String, String> paramMap);
 
	Integer  queryOrderTypeByOrderNo(String orderno);
	
	/**
	 * 功能描述:更改base_order表的orderStatus状态为2------ 订单状态(0-未支付 1-已支付 2-已取消 )
	 * 作者:温海金
	 * 最后更改时间 : 下午3:41:58
	 * @return 
	 */
	int updateOrder(String orderNo);
	
	/**
	 * 功能描述:更改base_bookBus表的status状态为3------ （0-待报价 1-待付款 2-待派车 3-已取消  4-已完成）
	 * 作者:温海金
	 * 最后更改时间 : 下午3:41:58
	 * @return 
	 */
	int updateBookBus(String goodsId);

	List<TicketOrder> queryTicketOrderList(@Param("userId")int userid, @Param("cityCode")String citycode);

	/**
	
	  * queryTicketDetailByOrderNo(这里用一句话描述这个方法的作用)
	  * @param @param orderNo
	  * @param @return    设定文件
	  * @return List<TicketStatus>    返回类型
	  */
	List<TicketStatus> queryTicketDetailByOrderNo(String orderNo);
	
}