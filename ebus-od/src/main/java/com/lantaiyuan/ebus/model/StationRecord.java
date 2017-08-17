package com.lantaiyuan.ebus.model;

import java.math.BigDecimal;

/***
 * 
* <p>Title: RouteStationRelation</p>
* <p>Description: 线路id方向站序（大数据OD支持类）</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年3月31日 下午3:18:17
 */
public class StationRecord{
    /**
     * 线路id
     * 表字段 : rel_route_station.routeId
     */
    private String routeid;

    /**
     * 站点id
     * 表字段 : rel_route_station.stationId
     */
    private String stationid;

    /**
     * 在该线路中是几站
     * 表字段 : rel_route_station.stationNo
     */
    private Integer stationno;

    /**
     * 线路方向 0-上行 1-下行
     * 表字段 : rel_route_station.direction
     */
    private Integer direction;

    private String name;

    private BigDecimal longitude;

    private BigDecimal latitude;
 
    private String routeiddirectionstationno;
    
    private String citycode;

	/**
	* @return routeid
	*/
	public String getRouteid() {
		return routeid;
	}

	/**
	* @param routeid 要设置的 routeid
	*/
	public void setRouteid(String routeid) {
		this.routeid = routeid;
	}

	/**
	* @return stationid
	*/
	public String getStationid() {
		return stationid;
	}

	/**
	* @param stationid 要设置的 stationid
	*/
	public void setStationid(String stationid) {
		this.stationid = stationid;
	}

	/**
	* @return stationno
	*/
	public Integer getStationno() {
		return stationno;
	}

	/**
	* @param stationno 要设置的 stationno
	*/
	public void setStationno(Integer stationno) {
		this.stationno = stationno;
	}

	/**
	* @return direction
	*/
	public Integer getDirection() {
		return direction;
	}

	/**
	* @param direction 要设置的 direction
	*/
	public void setDirection(Integer direction) {
		this.direction = direction;
	}

	/**
	* @return name
	*/
	public String getName() {
		return name;
	}

	/**
	* @param name 要设置的 name
	*/
	public void setName(String name) {
		this.name = name;
	}

	/**
	* @return longitude
	*/
	public BigDecimal getLongitude() {
		return longitude;
	}

	/**
	* @param longitude 要设置的 longitude
	*/
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	/**
	* @return latitude
	*/
	public BigDecimal getLatitude() {
		return latitude;
	}

	/**
	* @param latitude 要设置的 latitude
	*/
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	/**
	* @return routeiddirectionstationno
	*/
	public String getRouteiddirectionstationno() {
		return routeiddirectionstationno;
	}

	/**
	* @param routeiddirectionstationno 要设置的 routeiddirectionstationno
	*/
	public void setRouteiddirectionstationno(String routeiddirectionstationno) {
		this.routeiddirectionstationno = routeiddirectionstationno;
	}

	/**
	* @return citycode
	*/
	public String getCitycode() {
		return citycode;
	}

	/**
	* @param citycode 要设置的 citycode
	*/
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
    
}