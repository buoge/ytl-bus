package com.lantaiyuan.ebus.realtime.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.lanqiao.ssm.common.model.Model;


public class RealTimeQueryModel extends Model {

	private static final long serialVersionUID = 2330611006808557512L;
	@NotBlank
	private String routeid;
	@NotNull
	private String stationid;
	@NotNull
	private Integer direction;
	@NotNull
	private Integer userstationno;
	@NotBlank
	private String citycode;
	
	public RealTimeQueryModel() {
		super();
	}

	public RealTimeQueryModel(String routeid, String stationid, Integer direction, Integer userstationno, String citycode) {
		super();
		this.routeid = routeid;
		this.stationid = stationid;
		this.direction = direction;
		this.userstationno = userstationno;
		this.citycode = citycode;
	}
	
	public RealTimeQueryModel routeid(String routeid) {
		setRouteid(routeid);
		return this;
	}
	public RealTimeQueryModel stationid(String stationid) {
		setStationid(stationid);
		return this;
	}
	public RealTimeQueryModel direction(Integer direction) {
		setDirection(direction);
		return this;
	}
	public RealTimeQueryModel userstationno(Integer userstationno) {
		setUserstationno(userstationno);
		return this;
	}
	public RealTimeQueryModel citycode(String citycode) {
		setCitycode(citycode);
		return this;
	}
	public String getRouteid() {
		return routeid;
	}
	public void setRouteid(String routeid) {
		this.routeid = routeid;
	}
	public String getStationid() {
		return stationid;
	}
	public void setStationid(String stationid) {
		this.stationid = stationid;
	}
	public Integer getDirection() {
		return direction;
	}
	public void setDirection(Integer direction) {
		this.direction = direction;
	}
	public Integer getUserstationno() {
		return userstationno;
	}
	public void setUserstationno(Integer userstationno) {
		this.userstationno = userstationno;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	@Override
	public String toString() {
		return "RealTimeQueryModel [routeid=" + routeid + ", stationid=" + stationid + ", direction=" + direction
				+ ", userstationno=" + userstationno + ", citycode=" + citycode + "]";
	}
	
	
	

}
