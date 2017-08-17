package com.lantaiyuan.ebus.custom.model;

/**
 * 描述:用户位置信息埋点
 * 作者:温海金
 * 最后更改时间:下午1:51:53
 */
public class UserPosRecord {
	//城市编码
	private String citycode;
	
	//用户位置
	private String position;
	
	//用户ID
	private String userid;
	
	//用户设备标识码
	private String phonemodel;
	
	//用户经度 
	private Double longitude;
	
	//用户纬度
	private Double latitude;

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

	/**
	* @return position
	*/
	public String getPosition() {
		return position;
	}

	/**
	* @param position 要设置的 position
	*/
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	* @return userid
	*/
	public String getUserid() {
		return userid;
	}

	/**
	* @param userid 要设置的 userid
	*/
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	* @return phonemodel
	*/
	public String getPhonemodel() {
		return phonemodel;
	}

	/**
	* @param phonemodel 要设置的 phonemodel
	*/
	public void setPhonemodel(String phonemodel) {
		this.phonemodel = phonemodel;
	}

	
	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public UserPosRecord() {
		super();
	}

	public UserPosRecord(String citycode, String userid, Double longitude, Double latitude) {
		super();
		this.citycode = citycode;
		this.userid = userid;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	
}
