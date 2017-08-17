package com.lantaiyuan.ebus.custom.model;

import java.math.BigDecimal;
import org.lanqiao.ssm.common.model.Model;

public class TicketDetail  extends Model{
	private static final long serialVersionUID = 1L;
	private Integer userid;
	private String takedate;
	private BigDecimal price;
	private String citycode;
	private String routeid;
    private String orderno;
    private String timestamp;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getTakedate() {
		return takedate;
	}
	public void setTakedate(String takedate) {
		this.takedate = takedate;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getRouteid() {
		return routeid;
	}
	public void setRouteid(String routeid) {
		this.routeid = routeid;
	}
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}   