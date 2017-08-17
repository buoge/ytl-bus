package com.lantaiyuan.ebus.realtime.model;

import org.lanqiao.ssm.common.model.Model;

/**
 * @Title: BusDesc.java
 * @Package com.lantaiyuan.ebus.realtime.model
 * @Description: 车辆实时信息详情描述
 * @author yangyang
 * @date 2017年1月6日 下午1:43:48
 * @version v1.0
 */
public class BusDesc extends Model {

	private static final long serialVersionUID = 5671750849363871720L;

	private Integer stationnumber;// 距离当前站点的站点数量
	private Double distance; // 距离当前站点的距离（单位米）
	private Integer time; // 距离到达当前站点的预计时间

	private String stationid;// 站点ID
	private Integer type; // 0 到站 1 过站
	private Double longitude; // 经度
	private Double latitude; // 纬度
	
	public BusDesc stationnumber(Integer stationnumber) {
		setStationnumber(stationnumber);
		return this;
	}
	
	public BusDesc distance(Double distance) {
		setDistance(distance);
		return this;
	}
	
	public BusDesc time(Integer time) {
		setTime(time);
		return this;
	}
	
	public BusDesc stationid(String stationid) {
		setStationid(stationid);
		return this;
	}
	
	public BusDesc type(Integer type) {
		setType(type);
		return this;
	}
	
	public BusDesc longitude(Double longitude) {
		setLongitude(longitude);
		return this;
	}
	
	public BusDesc latitude(Double latitude) {
		setLatitude(latitude);
		return this;
	}
	
	public Integer getStationnumber() {
		return stationnumber;
	}
	public void setStationnumber(Integer stationnumber) {
		this.stationnumber = stationnumber;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	public String getStationid() {
		return stationid;
	}
	public void setStationid(String stationid) {
		this.stationid = stationid;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
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

	@Override
	public String toString() {
		return "stationnumber=" + stationnumber + ", time=" + time;
	}
	
	
}
