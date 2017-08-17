package com.lantaiyuan.ebus.custom.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.lanqiao.ssm.common.core.service.BaseServiceI;
import com.alipay.api.AlipayApiException;
import com.lantaiyuan.ebus.custom.model.BaseComparableOrder;
import com.lantaiyuan.ebus.custom.model.BookBusOrder;
import com.lantaiyuan.ebus.custom.model.BookTicketOrder;
import com.lantaiyuan.ebus.custom.model.Order;
import com.lantaiyuan.ebus.custom.model.OrderQueryModel;
import com.lantaiyuan.ebus.custom.model.TicketOrder;
import com.lantaiyuan.ebus.custom.model.TicketStatus;
import com.lantaiyuan.ebus.custom.model.travelaround.TravelAroundOrder;
import com.lantaiyuan.ebus.custom.model.travelaround.TravelAroundOrderDetail;

/**
 * 
 * @ClassName: OrderServiceI
 * @author Yuan.Tan
 * @date 2016年11月8日 上午11:50:27
 *
 */
public interface OrderServiceI extends BaseServiceI<Order, OrderQueryModel> {
	/**
	 * applyCustomBus(申请专车（包车）)
	 */
	Map<String, String> applyCustomBus(BookBusOrder bookBusOrder);

	Map<String, String> buyTicket(BookTicketOrder bookTicketOrder);

	Order selectByOrderNo(String orderno);
	
	/**
	 * 查询数据库状态为未支付的订单  
	 */
	Order selectUnpaidByOrderNo(String orderno);

	Map<String, String> queryOrderStatus(String orderno);

	Map<String, Object> payTicket(String orderno, String paytype);

	/**
	 * queryUnPaidOrder(根据用户id查询 用户欲提交当前订单(包括订票和专车申请)前 是否有未支付订单，若结果大于等于1表示有未支付订单)
	 */
	int queryUnPaidOrderNums(String userid);

	List<Order> queryUnPaidOrder(String userid);

	/**
	 * 功能描述:查询包车订单 作者:温海金 最后更改时间 : 下午5:14:24
	 */
	List<Map<String, Object>> selectBookBusOrder(Integer userId, String citycode);

	/**
	 * payBookBus(支付专车申请费用 ,返回支付签名给前端APP 让其调用第三方)
	 */
	HashMap<String, Object> payBookBus(String orderno, String paytype);

	/**
	 * queryOrderTypeByOrderNo(根据订单号查询订单类型)
	 */
	int queryOrderTypeByOrderNo(String orderno);

	/**
	 * 功能描述:取消订单编号 作者:温海金 最后更改时间 : 下午3:39:25
	 * 
	 * @return
	 */
	int cancelOrder(String orderNo, String goodsId);
	
	/**
	 * 功能描述:查询车票订单列表
	 * 作者:YvanTan
	 * 最后更改时间 : 下午3:03:20
	 */
	List<TicketOrder> queryTicketOrderList(int userid, String citycode);

	List<TicketStatus> queryTicketDetailByOrderNo(String orderNo);

	Map<String, Object> refundTicket(int userid, String orderNo,String ticketIdList);

	Map<String, Object> payOrderByWallet(String userId, String orderNo);

	int cancelTicetOrder(String orderNo);

	Map<String, Object> dealAliPayRefund(String orderNo, BigDecimal totalMount) throws AlipayApiException;

	Map<String, Object> dealWeiXinRefund(String orderNo, int orderFee, int refundFee);

	List<BaseComparableOrder> queryOrderList(int userId, String cityCode);

	/**
	 * 生成周边游订单
	 */
	Map<String, Object> creatTravelOrder(TravelAroundOrder travelOrder);
	
	TravelAroundOrderDetail queryTravelOrderByOrderNo(String orderNo);
	
	/**
	 * 修改周边游订单为支付状态
	 */
	int updateTravelOrderToPaid(String orderNo);
	
	void modifyOrderStatusAfterPaid(String orderNo);
}
