/**
 * @Title: TicketOrder.java
 * @Package com.lantaiyuan.ebus.custom.model
 * Company:深圳市蓝泰源信息技术股份有限公司
 * @author Yuan.Tan
 * @date 2017年2月22日 下午8:23:05
 */
package com.lantaiyuan.ebus.custom.model;

import java.math.BigDecimal;
import java.util.Date;

/**
  * @ClassName: TicketOrder 车票订单
  * Company:深圳市蓝泰源信息技术股份有限公司
  * @author Yuan.Tan
  * @date 2017年2月22日 下午8:23:05
  */
public class TicketOrder  extends BaseComparableOrder {
	private String orderNo;
	private String payType;
	private String routeName;
	private String orderStatus;
	private Integer  totalTickets;
	private BigDecimal  amount;
	private Date createTime;
	private String sourceLocation;
	private String targetLocation;
	private String takeTime; 
	private Integer  distance;
	private Integer  spendTime;
	private String routeId;
	/**
	 * @return the orderNo
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * @return the payType
	 */
	public String getPayType() {
		return payType;
	}
	/**
	 * @param payType the payType to set
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}
	/**
	 * @return the routeName
	 */
	public String getRouteName() {
		return routeName;
	}
	/**
	 * @param routeName the routeName to set
	 */
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}
	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * @return the totalTickets
	 */
	public int getTotalTickets() {
		return totalTickets;
	}
	/**
	 * @param totalTickets the totalTickets to set
	 */
	public void setTotalTickets(int totalTickets) {
		this.totalTickets = totalTickets;
	}
	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the sourceLocation
	 */
	public String getSourceLocation() {
		return sourceLocation;
	}
	/**
	 * @param sourceLocation the sourceLocation to set
	 */
	public void setSourceLocation(String sourceLocation) {
		this.sourceLocation = sourceLocation;
	}
	/**
	 * @return the targetLocation
	 */
	public String getTargetLocation() {
		return targetLocation;
	}
	/**
	 * @param targetLocation the targetLocation to set
	 */
	public void setTargetLocation(String targetLocation) {
		this.targetLocation = targetLocation;
	}
	/**
	 * @return the takeTime
	 */
	public String getTakeTime() {
		return takeTime;
	}
	/**
	 * @param takeTime the takeTime to set
	 */
	public void setTakeTime(String takeTime) {
		this.takeTime = takeTime;
	}
	/**
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}
	/**
	 * @param distance the distance to set
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}
	/**
	 * @return the spendTime
	 */
	public int getSpendTime() {
		return spendTime;
	}
	/**
	 * @param spendTime the spendTime to set
	 */
	public void setSpendTime(int spendTime) {
		this.spendTime = spendTime;
	}
	public String getRouteId() {
		return routeId;
	}
	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

}
