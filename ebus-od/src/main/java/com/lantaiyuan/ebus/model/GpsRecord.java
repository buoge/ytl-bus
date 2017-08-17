/**
* <p>Title: GpsRecord.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.model;

import java.math.BigDecimal;
import java.util.Date;

/**
* <p>Title: GpsRecord</p>
* <p>Description: gps包记录</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年5月4日 下午5:31:34
*/
public class GpsRecord {
	private Integer azimuth;
	private Integer direction;
	private Date eventTime;
	private Integer gprsId;
	private Integer gpsKm;
	private Integer height;
	private BigDecimal latitude;
	private BigDecimal longitude;
	private Integer nextAway;
	private Integer nextStationId;
	private Integer nextTime;
	private String packetType;
	private String protocolVersion;
	private Integer runstatus;
	private Integer signal;
	private Integer speed;
	private Integer temp;
	private Integer vehicleId;
	/**
	* @return azimuth
	*/
	public Integer getAzimuth() {
		return azimuth;
	}
	/**
	* @param azimuth 要设置的 azimuth
	*/
	public void setAzimuth(Integer azimuth) {
		this.azimuth = azimuth;
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
	* @return eventTime
	*/
	public Date getEventTime() {
		return eventTime;
	}
	/**
	* @param eventTime 要设置的 eventTime
	*/
	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}
	/**
	* @return gprsId
	*/
	public Integer getGprsId() {
		return gprsId;
	}
	/**
	* @param gprsId 要设置的 gprsId
	*/
	public void setGprsId(Integer gprsId) {
		this.gprsId = gprsId;
	}
	/**
	* @return gpsKm
	*/
	public Integer getGpsKm() {
		return gpsKm;
	}
	/**
	* @param gpsKm 要设置的 gpsKm
	*/
	public void setGpsKm(Integer gpsKm) {
		this.gpsKm = gpsKm;
	}
	/**
	* @return height
	*/
	public Integer getHeight() {
		return height;
	}
	/**
	* @param height 要设置的 height
	*/
	public void setHeight(Integer height) {
		this.height = height;
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
	* @return nextAway
	*/
	public Integer getNextAway() {
		return nextAway;
	}
	/**
	* @param nextAway 要设置的 nextAway
	*/
	public void setNextAway(Integer nextAway) {
		this.nextAway = nextAway;
	}
	/**
	* @return nextStationId
	*/
	public Integer getNextStationId() {
		return nextStationId;
	}
	/**
	* @param nextStationId 要设置的 nextStationId
	*/
	public void setNextStationId(Integer nextStationId) {
		this.nextStationId = nextStationId;
	}
	/**
	* @return nextTime
	*/
	public Integer getNextTime() {
		return nextTime;
	}
	/**
	* @param nextTime 要设置的 nextTime
	*/
	public void setNextTime(Integer nextTime) {
		this.nextTime = nextTime;
	}
	/**
	* @return packetType
	*/
	public String getPacketType() {
		return packetType;
	}
	/**
	* @param packetType 要设置的 packetType
	*/
	public void setPacketType(String packetType) {
		this.packetType = packetType;
	}
	/**
	* @return protocolVersion
	*/
	public String getProtocolVersion() {
		return protocolVersion;
	}
	/**
	* @param protocolVersion 要设置的 protocolVersion
	*/
	public void setProtocolVersion(String protocolVersion) {
		this.protocolVersion = protocolVersion;
	}
	/**
	* @return runstatus
	*/
	public Integer getRunstatus() {
		return runstatus;
	}
	/**
	* @param runstatus 要设置的 runstatus
	*/
	public void setRunstatus(Integer runstatus) {
		this.runstatus = runstatus;
	}
	/**
	* @return signal
	*/
	public Integer getSignal() {
		return signal;
	}
	/**
	* @param signal 要设置的 signal
	*/
	public void setSignal(Integer signal) {
		this.signal = signal;
	}
	/**
	* @return speed
	*/
	public Integer getSpeed() {
		return speed;
	}
	/**
	* @param speed 要设置的 speed
	*/
	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
	/**
	* @return temp
	*/
	public Integer getTemp() {
		return temp;
	}
	/**
	* @param temp 要设置的 temp
	*/
	public void setTemp(Integer temp) {
		this.temp = temp;
	}
	/**
	* @return vehicleId
	*/
	public Integer getVehicleId() {
		return vehicleId;
	}
	/**
	* @param vehicleId 要设置的 vehicleId
	*/
	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}
	
}
