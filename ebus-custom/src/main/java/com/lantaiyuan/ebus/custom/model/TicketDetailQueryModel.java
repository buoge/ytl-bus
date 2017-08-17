package com.lantaiyuan.ebus.custom.model;

import org.lanqiao.ssm.common.model.Model;

public class TicketDetailQueryModel  extends Model{
	private static final long serialVersionUID = 1L;
	private Integer userid;
	private String routeid;
    private String sourcelocation;
    private String targetlocation;
    private String ticketstatus;
    private String citycode;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getRouteid() {
		return routeid;
	}
	public void setRouteid(String routeid) {
		this.routeid = routeid;
	}
	public String getSourcelocation() {
		return sourcelocation;
	}
	public void setSourcelocation(String sourcelocation) {
		this.sourcelocation = sourcelocation;
	}
	public String getTargetlocation() {
		return targetlocation;
	}
	public void setTargetlocation(String targetlocation) {
		this.targetlocation = targetlocation;
	}
	public String getTicketstatus() {
		return ticketstatus;
	}
	public void setTicketstatus(String ticketstatus) {
		this.ticketstatus = ticketstatus;
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