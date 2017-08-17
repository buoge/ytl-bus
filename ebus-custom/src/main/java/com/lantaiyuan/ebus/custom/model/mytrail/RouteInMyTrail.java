package com.lantaiyuan.ebus.custom.model.mytrail;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 描述:我的行程中的线路信息
 * 作者:温海金
 * 最后更改时间:下午4:16:28
 */
public class RouteInMyTrail {
	
	/**
	 * 线路ID
	 */
	@JsonIgnore
	private String routeid;
	/**
	 * 车辆方向（格式：开往+终点站名称）
	 */
	private String direction;
	/**
	 * 总行程
	 */
	private Double distance;
	/**
	 * 线路名称
	 */
	private String routename;
	/**
	 * 上车时间
	 */
	private Date starttime;
	/**
	 * 下车时间
	 */
	private Date endtime;
	/**
	 * 行程总用时
	 */
	private Integer time;
	
	
	public String getRouteid() {
		return routeid;
	}
	public void setRouteid(String routeid) {
		this.routeid = routeid;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public String getRoutename() {
		return routename;
	}
	public void setRoutename(String routename) {
		this.routename = routename;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	
	
	public RouteInMyTrail() {
	}
	
	public RouteInMyTrail(String routeid, String direction, Double distance, String routename, Date starttime, Date endtime, Integer time) {
		super();
		this.routeid = routeid;
		this.direction = direction;
		this.distance = distance;
		this.routename = routename;
		this.starttime = starttime;
		this.endtime = endtime;
		this.time = time;
	}
	
}
