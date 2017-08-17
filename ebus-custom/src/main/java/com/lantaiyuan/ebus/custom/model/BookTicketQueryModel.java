package com.lantaiyuan.ebus.custom.model;

import java.util.Date;

import org.lanqiao.ssm.common.model.BaseModel;

/**
 * 
 * @ClassName: BookTicketQueryModel
 * @author Yuan.Tan
 * @date 2016年11月8日 上午11:46:07
 *
 */
public class BookTicketQueryModel extends BaseModel<BookTicket> {

	private static final long serialVersionUID = 1L;

	private String goodsid;

	private String orderdetailid;

	private String routeid;

	private String sourcelocation;

	private String targetlocation;

	private String taketime;

	private String takedate;

	private String ticketstatus;
	
	private String citycode;

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
	 * @return the ceatetime
	 */
	public Date getCeatetime() {
		return ceatetime;
	}

	/**
	 * @param ceatetime the ceatetime to set
	 */
	public void setCeatetime(Date ceatetime) {
		this.ceatetime = ceatetime;
	}

	private Date ceatetime;

	public String getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid == null ? null : goodsid.trim();
	}

	public String getOrderdetailid() {
		return orderdetailid;
	}

	public void setOrderdetailid(String orderdetailid) {
		this.orderdetailid = orderdetailid == null ? null : orderdetailid.trim();
	}

	public String getRouteid() {
		return routeid;
	}

	public void setRouteid(String routeid) {
		this.routeid = routeid == null ? null : routeid.trim();
	}

	public String getSourcelocation() {
		return sourcelocation;
	}

	public void setSourcelocation(String sourcelocation) {
		this.sourcelocation = sourcelocation == null ? null : sourcelocation.trim();
	}

	public String getTargetlocation() {
		return targetlocation;
	}

	public void setTargetlocation(String targetlocation) {
		this.targetlocation = targetlocation == null ? null : targetlocation.trim();
	}

	public String getTaketime() {
		return taketime;
	}

	public void setTaketime(String taketime) {
		this.taketime = taketime;
	}

	public String getTakedate() {
		return takedate;
	}

	public void setTakedate(String takedate) {
		this.takedate = takedate;
	}

	/**
	 * @return the citycode
	 */
	public String getCitycode() {
		return citycode;
	}

	/**
	 * @param citycode the citycode to set
	 */
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
}