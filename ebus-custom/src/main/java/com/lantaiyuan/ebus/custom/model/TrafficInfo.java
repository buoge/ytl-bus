package com.lantaiyuan.ebus.custom.model;

public class TrafficInfo {
	private String cityCode;//城市id
	private String routeId;//线路id
	private String routeName;//线路名称
	private String trafficArea;//拥堵区域	
	private String trafficLevel;//N-轻微 M-较拥堵 H-严重拥堵
	private String trafficMsg;//道路拥堵详细情况说明
	private String trafficTime;//时间
	
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getRouteId() {
		return routeId;
	}
	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public String getTrafficArea() {
		return trafficArea;
	}
	public void setTrafficArea(String trafficArea) {
		this.trafficArea = trafficArea;
	}
	public String getTrafficLevel() {
		return trafficLevel;
	}
	public void setTrafficLevel(String trafficLevel) {
		this.trafficLevel = trafficLevel;
	}
	public String getTrafficMsg() {
		return trafficMsg;
	}
	public void setTrafficMsg(String trafficMsg) {
		this.trafficMsg = trafficMsg;
	}
	public String getTrafficTime() {
		return trafficTime;
	}
	public void setTrafficTime(String trafficTime) {
		this.trafficTime = trafficTime;
	}
	
 

}
