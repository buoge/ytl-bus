package com.lantaiyuan.ebus.custom.model;

import java.math.BigDecimal;

import org.lanqiao.ssm.common.model.Model;

/** 
  * @Title: OriDestPoint.java
  * @Package com.lantaiyuan.ebus.custom.model
  * @Description: 
  * @author yangyang   
  * @date 2017年2月27日 下午4:16:45
  * @version v1.0  
 */
public class OriDestPoint extends Model {

	private static final long serialVersionUID = 4251086624327273642L;
	private String stationId;
	private String cityCode;
	private String stationName;
	private BigDecimal lon;
	private BigDecimal lat;
	private Integer startCount;
	private Integer endCount;
	private int startOrEnd;
	
	@Override
	public String toString() {
		return "OriDestPoint [cityCode=" + cityCode + ", stationId=" + stationId + "]";
	}

	public OriDestPoint startCount(Integer startCount) {
		this.startCount = startCount;
		return this;
	}
	
	public OriDestPoint endCount(Integer endCount) {
		this.endCount = endCount;
		return this;
	}
	
	public OriDestPoint startOrEnd(int startOrEnd) {
		this.startOrEnd = startOrEnd;
		return this;
	}
	
	public OriDestPoint stationId(String stationId) {
		this.stationId = stationId;
		return this;
	}
	
	public OriDestPoint cityCode(String cityCode) {
		this.cityCode = cityCode;
		return this;
	}
	
	public OriDestPoint stationName(String stationName) {
		this.stationName = stationName;
		return this;
	}
	
	public OriDestPoint lon(BigDecimal lon) {
		this.lon = lon;
		return this;
	}
	
	public OriDestPoint lat(BigDecimal lat) {
		this.lat = lat;
		return this;
	}
	
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public BigDecimal getLon() {
		return lon;
	}
	public void setLon(BigDecimal lon) {
		this.lon = lon;
	}
	public BigDecimal getLat() {
		return lat;
	}
	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}
	public Integer getStartCount() {
		return startCount;
	}
	public void setStartCount(Integer startCount) {
		this.startCount = startCount;
	}
	public Integer getEndCount() {
		return endCount;
	}
	public void setEndCount(Integer endCount) {
		this.endCount = endCount;
	}
	public int getStartOrEnd() {
		return startOrEnd;
	}
	public void setStartOrEnd(int startOrEnd) {
		this.startOrEnd = startOrEnd;
	}
	

}
