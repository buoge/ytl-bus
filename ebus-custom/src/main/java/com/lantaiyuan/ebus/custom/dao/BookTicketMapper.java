package com.lantaiyuan.ebus.custom.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import com.lantaiyuan.ebus.custom.model.BookTicket;
import com.lantaiyuan.ebus.custom.model.BookTicketQueryModel;
import com.lantaiyuan.ebus.custom.model.MyTickets;
import com.lantaiyuan.ebus.custom.model.TicketDetail;
import com.lantaiyuan.ebus.custom.model.TicketDetailQueryModel;

/**
 * 
  * @ClassName: BookTicketMapper
  * @author Yuan.Tan
  * @date 2016年11月8日 上午11:42:41
  *
 */
public interface BookTicketMapper extends BaseDAO<BookTicket, BookTicketQueryModel>{

	List<MyTickets> queryMyTickets(@Param("userid")String userid,@Param("citycode")String citycode);
	
	int updateStatusToValid(String orderNo);
	
	TicketDetail queryTicketDetail(TicketDetailQueryModel ticketDetailQueryModel);
	
	List<BookTicket> queryBookedTicket(@Param("userid")String userid,@Param("routeid")String routeid);
	
	List<BookTicket> queryBookedTicket(@Param("userid")String userid,@Param("routeid")String routeid,@Param("citycode")String citycode);
 
	int updateStatusToUsed(String ticketId);

	int updateStatusToRefund(List<String> ticketIdList);

	List<BookTicket> queryUnPaidTicketOrder(Map<String, Object> params);
}