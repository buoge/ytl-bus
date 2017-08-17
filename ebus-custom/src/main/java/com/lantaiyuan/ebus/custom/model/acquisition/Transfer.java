package com.lantaiyuan.ebus.custom.model.acquisition;

import com.lantaiyuan.ebus.custom.model.acquisition.base.BaseModel;

/** 
  * @Title: Transfer.java
  * @Package com.lantaiyuan.ebus.custom.model.acquisition
  * @Description: 
  * @author yangyang   
  * @date 2017年2月14日 下午4:55:06
  * @version v1.0  
 */
public class Transfer extends BaseModel{
	
	private static final long serialVersionUID = -8963394390588439451L;
	private String startplace;// "起点名称",
	private String endplace;// "终点名称",
	private String startlon;// "起点经度", 
	private String startlat;// "起点经度",
	private String endlon;// "终点经度", 
	private String endlat;// "终点纬度", 
	private String citycode;// "城市编码",
	public String getStartplace() {
		return startplace;
	}
	public void setStartplace(String startplace) {
		this.startplace = startplace;
	}
	public String getEndplace() {
		return endplace;
	}
	public void setEndplace(String endplace) {
		this.endplace = endplace;
	}
	public String getStartlon() {
		return startlon;
	}
	public void setStartlon(String startlon) {
		this.startlon = startlon;
	}
	public String getStartlat() {
		return startlat;
	}
	public void setStartlat(String startlat) {
		this.startlat = startlat;
	}
	public String getEndlon() {
		return endlon;
	}
	public void setEndlon(String endlon) {
		this.endlon = endlon;
	}
	public String getEndlat() {
		return endlat;
	}
	public void setEndlat(String endlat) {
		this.endlat = endlat;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	
}
