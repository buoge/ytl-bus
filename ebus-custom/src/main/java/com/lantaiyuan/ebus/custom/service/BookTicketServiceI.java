package com.lantaiyuan.ebus.custom.service;

import java.util.List;
import java.util.Map;
import org.lanqiao.ssm.common.core.service.BaseServiceI;
import com.lantaiyuan.ebus.custom.model.BookTicket;
import com.lantaiyuan.ebus.custom.model.BookTicketQueryModel;
import com.lantaiyuan.ebus.custom.model.MyTicketInfo;
import com.lantaiyuan.ebus.custom.model.TicketDetailQueryModel;

/**
 * 
  * @ClassName: BookTicketServiceI
  * @author Yuan.Tan
  * @date 2016年11月8日 上午11:49:52
  *
 */
public interface BookTicketServiceI extends BaseServiceI<BookTicket, BookTicketQueryModel>{
	 
	List<MyTicketInfo> queryMyTickets(String userid,String citycode);
	
	/**
	 * 
	  * updateStatusToValid(支付成功后根据订单号 修改车票状态为有效)
	  * @param @param orderNo
	  * @return int    返回类型
	 */
	int updateStatusToValid(String orderNo);

	Map<String, String> generateTicketCode(TicketDetailQueryModel ticketDetailQueryModel);
	
	/**
	 * 
	  * updateStatusToUsed(根据网关发来的车票id，修改车票状态为已使用)
	  * @param @param ticketId
	  * @return int    返回类型
	 */
	int updateStatusToUsed(String ticketId);

	/**
	  * updateTicketStatusFromGw(接收车载验票设备发来的车票信息，对验证通过的车票做处理：状态改为 2-已使用)
	  */
	void updateTicketStatusFromGw(String ticketInfo);

	/**
	  * queryUnPaidTicketOrder(查询待支付的车票订单)
	  */
	List<BookTicket> queryUnPaidTicketOrder(Integer userid, String routeId, String citycode, String[] takeDateArr);

}
