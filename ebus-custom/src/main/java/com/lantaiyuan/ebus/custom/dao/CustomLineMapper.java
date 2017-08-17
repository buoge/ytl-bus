package com.lantaiyuan.ebus.custom.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import com.lantaiyuan.ebus.custom.model.BookBus;
import com.lantaiyuan.ebus.custom.model.BookBusQueryModel;
import com.lantaiyuan.ebus.custom.model.CustomLine;
import com.lantaiyuan.ebus.custom.model.CustomLineQueryModel;

/**
 * 描述:专线管理持久层
 * 作者:温海金
 * 最后更改时间:下午2:54:31
 */
public interface CustomLineMapper extends BaseDAO<CustomLine,CustomLineQueryModel>{

	List<CustomLine> findObjectByIds(Map<String, Object> queryMap);

	List<CustomLine> findAllCustomLine();
	
	List<CustomLine> findCustomLineListByPage(CustomLineQueryModel model);

	List<CustomLine> findCustomLineByStartAndDistinctPlace(Map<String, Object> paramMap);

	List<CustomLine> findTempLineByStartAndDistinctPlace(Map<String, Object> paramMap);
	
	void updateLineStatus(Map<String, Object> paramMap);

	List<CustomLine> findMayFocLine(Map<String, Object> queryMap);

	String queryCustomLinIdByRouteId(String routeId);
	
	String queryCustomLinIdByRouteId(@Param("routeId")String routeId,@Param("cityCode")String cityCode);
	
	int getApplicationCountByUserIdAndLineId(Map<String, Object> paramMap);
	
	List<BookBus> findOrderByPage(BookBusQueryModel model);
	
	List<BookBus> findVerifyOrderByPage(BookBusQueryModel model);
	
	int updateOrderApplyRefund(@Param("orderNo")String orderNo,@Param("remark")String remark);
	
	int updateTicketApplyRefund(String orderDetailId);
	
	int updateOrderRefuseRefund(String orderNo);
	
	int updateTicketRefuseRefund(String orderDetailId);
	
	int updateOrderApproveRefund(String orderNo);
	
	int updateTicketApproveRefund(String orderDetailId);
	
	/**
	 * 功能描述:根据专线Id查询参与人的Id
	 * 作者:温海金
	 * 最后更改时间 : 2017年2月21日 下午4:32:03
	 */
	List<Integer> getPaticalUserIdByLineId(@Param("routeId") String routeId);

	/**
	  * queryUserIdByOrderNo(根据orderNo查询userId)
	 */
	String queryUserIdByOrderNo(String orderNo);

	float queryAmountIdByOrderNo(String orderNo);
	
	/**
	 * 功能描述:根据起点信息查询经过当前位置的专线信息
	 * 作者:温海金
	 * 最后更改时间 : 2017年7月17日 下午6:27:56
	 */
	List<CustomLine> findCustomRoutesByCurrentPlace(@Param("startlongitude")BigDecimal startlongitude, @Param("startlatitude")BigDecimal startlatitude, @Param("citycode")String citycode);
	
}