package com.lantaiyuan.ebus.custom.service;

import java.math.BigDecimal;
import java.util.List;
import org.lanqiao.ssm.common.core.service.BaseServiceI;
import org.lanqiao.ssm.common.page.Page;
import com.lantaiyuan.ebus.custom.model.BookBusQueryModel;
import com.lantaiyuan.ebus.custom.model.CustomLine;
import com.lantaiyuan.ebus.custom.model.CustomLineApplication;
import com.lantaiyuan.ebus.custom.model.CustomLineQueryModel;

public interface CustomLineServiceI extends BaseServiceI<CustomLine, CustomLineQueryModel> {

	List<CustomLine> findMayFocLineByUserId(Integer userId, String citycode);

	List<CustomLine> findAllCustomLine();

	List<CustomLine> findCustomLineByStartAndDistinctPlace(Integer userid, BigDecimal startlongitude,
			BigDecimal startlatitude, BigDecimal endlongitude, BigDecimal endlatitude, String citycode, Integer status);

	void updateLineStatus(String lineid, Integer status);

	public void updateLineStatusIfCountFull(String lineid);

	/**
	 * 
	 * 
	 * queryCustomLinIdByrouteId(根据前端app传的routeId去数据库后台base_custom_line表查询字段id(
	 * 别名：CustomLinId))
	 *
	 * @Title: queryCustomLinIdByrouteId @param @param routeId @param @return
	 * 设定文件 @return String 返回类型 @throws
	 */
	String queryCustomLinIdByRouteId(String routeId);

	String queryCustomLinIdByRouteId(String routeId, String citycode);

	Page<CustomLine> findCustomLineListByPage(int page, int pageSize, int status, String cityCode, String startStation,
			String endStation);

	Object findOrderByPage(BookBusQueryModel model, int page);

	boolean refuseRefund(String orderNo, String orderDetailId);

	boolean approveRefund(String orderNo, String orderDetailId);

	boolean applyRefund(String orderNo, String orderDetailId, String remark);

	Object findVerifyOrderByPage(BookBusQueryModel model, int page);

	void apply(CustomLine customLine, CustomLineApplication customLineApplication);
	/**
	 * 功能描述:专线开通
	 * 作者:温海金
	 * 最后更改时间 : 2017年2月21日 下午4:18:34
	 */
	int openCustomLine(String id);
	/**
	 * 功能描述:根据当前位置获取经过该位置的专线信息
	 * 作者:温海金
	 * 最后更改时间 : 2017年7月17日 下午6:38:39
	 */
	List<CustomLine> findCustomRoutesByCurrentPlace(BigDecimal startlongitude, BigDecimal startlatitude, String citycode);

}
