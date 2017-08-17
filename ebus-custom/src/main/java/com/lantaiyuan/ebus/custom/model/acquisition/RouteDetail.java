package com.lantaiyuan.ebus.custom.model.acquisition;

import com.lantaiyuan.ebus.custom.model.acquisition.base.BaseModel;

/** 
  * @Title: RouteDetail.java
  * @Package com.lantaiyuan.ebus.custom.model.acquisition
  * @Description: 线路详情埋点模型
  * @author yangyang   
  * @date 2017年2月14日 下午4:52:28
  * @version v1.0  
 */
public class RouteDetail extends BaseModel{
	
	private static final long serialVersionUID = -7665082513199648665L;
	private String routeid;
	private Integer direction;
	private String stationId;
	private String citycode;
	public String getRouteid() {
		return routeid;
	}
	public void setRouteid(String routeid) {
		this.routeid = routeid;
	}
	public Integer getDirection() {
		return direction;
	}
	public void setDirection(Integer direction) {
		this.direction = direction;
	}
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
}
