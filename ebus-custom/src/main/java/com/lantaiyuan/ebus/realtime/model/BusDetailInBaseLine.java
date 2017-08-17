package com.lantaiyuan.ebus.realtime.model;

import org.lanqiao.ssm.common.model.Model;

/**
 * 描述:BaseLine中的BusDetail相关属性
 * 作者:温海金
 * 最后更改时间:上午11:02:34
 */
public class BusDetailInBaseLine extends Model {

	private static final long serialVersionUID = 7141982332178323197L;

	private String vehicleid;// 车辆编号
	
	private String busplatenumber; // 车牌
	
	private Integer stationnumber;// 距离当前站点的站点数量(单独设值)
	
	private Double distance; // 距离当前站点的距离（单位米）（单独设值）
	
	private Integer time; // 距离到达当前站点的预计时间（单独设值）
	
	private Integer bustype;// 车辆类型

	private Integer type; // 0 到站 1 过站（单独设值）

	public String getVehicleid() {
	    return vehicleid;
	}

	public void setVehicleid(String vehicleid) {
	    this.vehicleid = vehicleid;
	}

	public String getBusplatenumber() {
	    return busplatenumber;
	}

	public void setBusplatenumber(String busplatenumber) {
	    this.busplatenumber = busplatenumber;
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

	public Integer getBustype() {
	    return bustype;
	}

	public void setBustype(Integer bustype) {
	    this.bustype = bustype;
	}

	public Integer getType() {
	    return type;
	}

	public void setType(Integer type) {
	    this.type = type;
	}
	
	
}
