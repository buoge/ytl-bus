/**
 * @Title: TicketStatus.java
 * @Package com.lantaiyuan.ebus.custom.model
 * Company:深圳市蓝泰源信息技术股份有限公司
 * @author Yuan.Tan
 * @date 2017年2月22日 下午8:23:05
 */
package com.lantaiyuan.ebus.custom.model;

import java.math.BigDecimal;

import org.lanqiao.ssm.common.model.Model;

/**
  * @ClassName: TicketStatus 车票状态表
  * Company:深圳市蓝泰源信息技术股份有限公司
  * @author Yuan.Tan
  * @date 2017年2月22日 下午8:23:05
  */
public class TicketStatus extends Model {

	/**
	  * @Fields serialVersionUID :
	  */
	private static final long serialVersionUID = 1L;
	private String orderNo;
	private String ticketId;
	private String takeDate;
	private String ticketStatus;
	private BigDecimal  price;
	private Integer  cityCode;
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
	 * @return the ticketId
	 */
	public String getTicketId() {
		return ticketId;
	}
	/**
	 * @param ticketId the ticketId to set
	 */
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	/**
	 * @return the takeDate
	 */
	public String getTakeDate() {
		return takeDate;
	}
	/**
	 * @param takeDate the takeDate to set
	 */
	public void setTakeDate(String takeDate) {
		this.takeDate = takeDate;
	}
	/**
	 * @return the ticketStatus
	 */
	public String getTicketStatus() {
		return ticketStatus;
	}
	/**
	 * @param ticketStatus the ticketStatus to set
	 */
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * @return the cityCode
	 */
	public Integer getCityCode() {
		return cityCode;
	}
	/**
	 * @param cityCode the cityCode to set
	 */
	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}
	
}	