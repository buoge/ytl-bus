package com.lantaiyuan.ebus.custom.model;

import java.math.BigDecimal;

/**
 * 描述:上车点和下车点
 * 作者:温海金
 * 最后更改时间:下午2:13:36
 */
public class UpAndDownStation {

	private Integer stationid;

	private Integer stationNo;

	private String name;
	
	private BigDecimal longitude;
	
	private BigDecimal latitude;
	
	private Double distance;

	public Integer getStationid() {
		return stationid;
	}

	public void setStationid(Integer stationid) {
		this.stationid = stationid;
	}

	public Integer getStationNo() {
		return stationNo;
	}

	public void setStationNo(Integer stationNo) {
		this.stationNo = stationNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}
}
