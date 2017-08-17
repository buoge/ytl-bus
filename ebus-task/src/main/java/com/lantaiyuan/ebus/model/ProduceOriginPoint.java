package com.lantaiyuan.ebus.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 存入kafka的O点信息
 * @author yangyang
 * @date 2017年5月22日 下午3:18:20 
 *
 */
public class ProduceOriginPoint implements Serializable{

	/** 
	* @Fields serialVersionUID
	*/ 
	private static final long serialVersionUID = -8514512819502759819L;
	public ProduceOriginPoint() {
		super();
	}
	public ProduceOriginPoint routeId(Integer routeId) {
		this.routeId = routeId;
		return this;
	}
	public ProduceOriginPoint direction(Integer direction) {
		this.direction = direction;
		return this;
	}
	public ProduceOriginPoint vehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
		return this;
	}
	public ProduceOriginPoint userId(String userId) {
		this.userId = userId;
		return this;
	}
	public ProduceOriginPoint startStationId(String startStationId) {
		this.startStationId = startStationId;
		return this;
	}
	public ProduceOriginPoint startTime(Date startTime) {
		this.startTime = startTime;
		return this;
	}
	public ProduceOriginPoint cityCode(String cityCode) {
		this.cityCode = cityCode;
		return this;
	}
	private Integer routeId;
	private Integer direction;
	private Integer vehicleId;
	private String userId;
	private String startStationId;
	private Date startTime;
	private String cityCode;
	public Integer getRouteId() {
		return routeId;
	}
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}
	public Integer getDirection() {
		return direction;
	}
	public void setDirection(Integer direction) {
		this.direction = direction;
	}
	public Integer getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStartStationId() {
		return startStationId;
	}
	public void setStartStationId(String startStationId) {
		this.startStationId = startStationId;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

}
