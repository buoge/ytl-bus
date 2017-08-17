package com.lantaiyuan.ebus.custom.model.acquisition.base;

import java.io.Serializable;
import java.util.Date;
/**
 * 
* @Title: BaseModel.java 
* @Description: 收集数据基础类
* @author 刘伟  15818570028@163.com   
* @date 2017年2月15日 下午2:07:38 
* @version V1.2.0
 */
public class BaseModel implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//用户id
    private String userid;
    //手机设备id
    private String phonemodel;
    //当前时间
    private Date currenttime;
    //当前经度
    private String longitude;
    //当前纬度
	private String latitude;
	
	
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPhonemodel() {
		return phonemodel;
	}
	public void setPhonemodel(String phonemodel) {
		this.phonemodel = phonemodel;
	}
	public Date getCurrenttime() {
		return currenttime;
	}
	public void setCurrenttime(Date currenttime) {
		this.currenttime = currenttime;
	}
    
    
}
