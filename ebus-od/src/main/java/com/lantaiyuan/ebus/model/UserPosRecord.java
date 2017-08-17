/**
* <p>Title: UserPosRecord.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.model;

import java.math.BigDecimal;
import java.util.Date;

/**
* <p>Title: UserPosRecord</p>
* <p>Description: 用户10s位置跟踪记录</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年5月4日 下午5:14:22
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
	
	//用户上传位置时间
	private Date currenttime;
	
	//用户经度 
	private BigDecimal longitude;
	
	//用户纬度
	private BigDecimal latitude;

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

	/**
	* @return currenttime
	*/
	public Date getCurrenttime() {
		return currenttime;
	}

	/**
	* @param currenttime 要设置的 currenttime
	*/
	public void setCurrenttime(Date currenttime) {
		this.currenttime = currenttime;
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
	
}
