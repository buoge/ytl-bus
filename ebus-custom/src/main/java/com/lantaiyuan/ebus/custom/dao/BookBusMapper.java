package com.lantaiyuan.ebus.custom.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import com.lantaiyuan.ebus.custom.model.BookBus;
import com.lantaiyuan.ebus.custom.model.BookBusQueryModel;
/** 
  * @ClassName: BookBusMapper
  * @author Yuan.Tan
  * @date 2016年11月8日 上午11:42:33
  *
 */
public interface BookBusMapper extends BaseDAO<BookBus, BookBusQueryModel>{
	
	int updateStatusToTwo(String orderNo);
	
	List<BookBus> findBookBusByPage(BookBusQueryModel model);
	
	BookBus findBookBusDetailById(String goodsId);
	
	int updateQuote(@Param("quotedPrice")String quotedPrice,@Param("userId")String userId,
			@Param("userName")String userName,@Param("goodsId")String goodsId);
	
	int updateOrder(@Param("quotedPrice")String quotedPrice,@Param("orderNo")String orderNo);
	
	//订单管理列表
	List<BookBus> findBookBusByPageForOrder(BookBusQueryModel model);
	
	//订单审核列表
	List<BookBus> findBookBusByPageForOrderVerify(BookBusQueryModel model);
	
	//申请退款
	int updateOrderApplyRefund(@Param("orderNo")String orderNo,@Param("remark")String remark);
	
	int updateBookBusApplyRefund(String goodsId);
	
	//拒绝退款
	int updateOrderRefuseRefund(String orderNo);
	
	int updateBookBusRefuseRefund(String goodsId);
	
	//同意退款
	int updateOrderApproveRefund(String orderNo);
	
	int updateBookBusApproveRefund(String goodsId);
	
	/**
	 * 功能描述:根据包车Id查询申请人ID
	 * 作者:温海金
	 * 最后更改时间 : 2017年2月21日 下午5:19:49
	 */
	Integer getUserIdByGoodsId(@Param("goodsId") String goodsId);

	/**
	 * 查询离发车剩余天数
	 */
	int queryRemainDays(String goodsId);
}