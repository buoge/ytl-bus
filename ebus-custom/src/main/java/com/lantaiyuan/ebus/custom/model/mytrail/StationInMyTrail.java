package com.lantaiyuan.ebus.custom.model.mytrail;

import java.math.BigDecimal;

/**
 * 描述:我的行程中的站点信息
 * 作者:温海金
 * 最后更改时间:下午4:55:31
 */
public class StationInMyTrail {
	/**
	 * 站点ID
	 */
	private Integer stationid;
	/**
	 * 站点名称
	 */
    private String name;
    /**
     * 站点经度
     */
    private BigDecimal longitude;
    /**
     * 站点纬度
     */
    private BigDecimal latitude;
    /**
     * 站序
     */
    private Integer stationNo;
    
	public Integer getStationid() {
		return stationid;
	}
	public void setStationid(Integer stationid) {
		this.stationid = stationid;
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
	public Integer getStationNo() {
		return stationNo;
	}
	public void setStationNo(Integer stationNo) {
		this.stationNo = stationNo;
	}
    
    
}
