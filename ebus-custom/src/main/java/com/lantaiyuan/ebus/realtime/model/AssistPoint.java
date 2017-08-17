package com.lantaiyuan.ebus.realtime.model;

/** 
  * @Title: AssistPoint.java
  * @Package com.lantaiyuan.ebus.realtime.model
  * @Description: 
  * @author yangyang   
  * @date 2017年2月16日 下午1:48:42
  * @version v1.0  
 */
public class AssistPoint {
	
	public AssistPoint() {
		super();
	}

	public AssistPoint(Double distance, Double longitude, Double latitude) {
		super();
		this.distance = distance;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	private Double distance;
	
	private Double longitude;
	
	private Double latitude;

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
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
	
	

}
