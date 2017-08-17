package com.lantaiyuan.ebus.realtime.model;

import org.lanqiao.ssm.common.model.Model;

/**
 * 
 * RouteAndRealTimeQueryModel 
 * TODO
 * @author yangyang
 * @date 2017年6月27日 下午5:32:14 
 *
 */
public class RouteAndRealTimeQueryModel extends Model{

	private static final long serialVersionUID = 7658819278479034437L;
	
	private RealTimeQueryModel realTimeQueryModel;
	
	private Double userLon;
	
	private Double userLat;

	public RealTimeQueryModel getRealTimeQueryModel() {
		return realTimeQueryModel;
	}

	public void setRealTimeQueryModel(RealTimeQueryModel realTimeQueryModel) {
		this.realTimeQueryModel = realTimeQueryModel;
	}

	public Double getUserLon() {
		return userLon;
	}

	public void setUserLon(Double userLon) {
		this.userLon = userLon;
	}

	public Double getUserLat() {
		return userLat;
	}

	public void setUserLat(Double userLat) {
		this.userLat = userLat;
	}
	
	

}
