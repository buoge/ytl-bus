package com.lantaiyuan.ebus.custom.model.mytrail;
/**
 * 描述:我的行程中的车辆信息
 * 作者:温海金
 * 最后更改时间:下午3:57:28
 */
public class BusInMyTrail {
	/**
	 * 车辆ID
	 */
	private String busId;
	/**
	 * 车牌号
	 */
	private String busNumber;
	
	public String getBusId() {
		return busId;
	}
	public void setBusId(String busId) {
		this.busId = busId;
	}
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	
	
	public BusInMyTrail() {
	}
	
	public BusInMyTrail(String busId, String busNumber) {
		super();
		this.busId = busId;
		this.busNumber = busNumber;
	}
	
	
}
