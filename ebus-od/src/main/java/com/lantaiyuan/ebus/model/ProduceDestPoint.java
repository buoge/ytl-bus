package com.lantaiyuan.ebus.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 存入kafka的D点信息
 * @author yangyang
 * @date 2017年5月22日 下午3:18:20 
 *
 */
public class ProduceDestPoint implements Serializable{
	/** 
	* @Fields serialVersionUID 
	*/ 
	private static final long serialVersionUID = 5578637904877563277L;
	public ProduceDestPoint() {
		super();
	}
	public ProduceDestPoint routeId(Integer routeId) {
		this.routeId = routeId;
		return this;
	}
	public ProduceDestPoint direction(Integer direction) {
		this.direction = direction;
		return this;
	}
	public ProduceDestPoint vehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
		return this;
	}
	public ProduceDestPoint userId(String userId) {
		this.userId = userId;
		return this;
	}
	public ProduceDestPoint endStationId(String endStationId) {
		this.endStationId = endStationId;
		return this;
	}
	public ProduceDestPoint endTime(Date endTime) {
		this.endTime = endTime;
		return this;
	}
	public ProduceDestPoint cityCode(String cityCode) {
		this.cityCode = cityCode;
		return this;
	}
	public ProduceDestPoint lon(double lon) {
		this.lon = lon;
		return this;
	}
	public ProduceDestPoint lat(double lat) {
		this.lat = lat;
		return this;
	}
	private Integer routeId;
	private Integer direction;
	private Integer vehicleId;
	private String userId;
	private String endStationId;
	private Date endTime;
	private String cityCode;
	private double lon;
	private double lat;
	
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
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
	public String getEndStationId() {
		return endStationId;
	}
	public void setEndStationId(String endStationId) {
		this.endStationId = endStationId;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	@Override
	public String toString() {
		return "ProduceDestPoint [routeId=" + routeId + ", direction=" + direction + ", vehicleId=" + vehicleId
				+ ", userId=" + userId + ", endStationId=" + endStationId + ", endTime=" + endTime + ", cityCode="
				+ cityCode + ", lon=" + lon + ", lat=" + lat + "]";
	}

}
