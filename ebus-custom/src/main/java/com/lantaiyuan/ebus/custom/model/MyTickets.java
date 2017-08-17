package com.lantaiyuan.ebus.custom.model;

import java.math.BigDecimal;
import java.util.Date;

import org.lanqiao.ssm.common.model.Model;

public class MyTickets  extends Model{
	private static final long serialVersionUID = 1L;
	private String routeid;
    private String sourcelocation;
    private String targetlocation;
    private String taketime;
    private String ticketstatus;
    private BigDecimal price;
    private BigDecimal distance;
    private Integer budgettime;//预计到达目的地需要多少时间，以分钟为单位
    private Integer numbers;//车票张数
	/**
	 * @return the routeid
	 */
	public String getRouteid() {
		return routeid;
	}
	/**
	 * @param routeid the routeid to set
	 */
	public void setRouteid(String routeid) {
		this.routeid = routeid;
	}
	/**
	 * @return the sourcelocation
	 */
	public String getSourcelocation() {
		return sourcelocation;
	}
	/**
	 * @param sourcelocation the sourcelocation to set
	 */
	public void setSourcelocation(String sourcelocation) {
		this.sourcelocation = sourcelocation;
	}
	/**
	 * @return the targetlocation
	 */
	public String getTargetlocation() {
		return targetlocation;
	}
	/**
	 * @param targetlocation the targetlocation to set
	 */
	public void setTargetlocation(String targetlocation) {
		this.targetlocation = targetlocation;
	}
	/**
	 * @return the taketime
	 */
	public String getTaketime() {
		return taketime;
	}
	/**
	 * @param taketime the taketime to set
	 */
	public void setTaketime(String taketime) {
		this.taketime = taketime;
	}
	/**
	 * @return the ticketstatus
	 */
	public String getTicketstatus() {
		return ticketstatus;
	}
	/**
	 * @param ticketstatus the ticketstatus to set
	 */
	public void setTicketstatus(String ticketstatus) {
		this.ticketstatus = ticketstatus;
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
	 * @return the distance
	 */
	public BigDecimal getDistance() {
		return distance;
	}
	/**
	 * @param distance the distance to set
	 */
	public void setDistance(BigDecimal distance) {
		this.distance = distance;
	}
	/**
	 * @return the budgettime
	 */
	public Integer getBudgettime() {
		return budgettime;
	}
	/**
	 * @param budgettime the budgettime to set
	 */
	public void setBudgettime(Integer budgettime) {
		this.budgettime = budgettime;
	}
	/**
	 * @return the numbers
	 */
	public Integer getNumbers() {
		return numbers;
	}
	/**
	 * @param numbers the numbers to set
	 */
	public void setNumbers(Integer numbers) {
		this.numbers = numbers;
	}
    
}