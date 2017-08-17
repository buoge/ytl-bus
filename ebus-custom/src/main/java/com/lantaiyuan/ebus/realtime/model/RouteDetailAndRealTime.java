package com.lantaiyuan.ebus.realtime.model;

import org.lanqiao.ssm.common.model.Model;

/**
 * 线路详情和实时公交
 * @author yangyang
 * @date 2017年6月27日 下午5:39:06 
 */
public class RouteDetailAndRealTime extends Model{

	private static final long serialVersionUID = -8554817868736826255L;
	
	private RouteDetail routeDetail;
	
	private RealTime nearestBus;

	public RouteDetailAndRealTime() {
		super();
	}

	public RouteDetailAndRealTime(RouteDetail routeDetail, RealTime realTime) {
		super();
		this.routeDetail = routeDetail;
		this.nearestBus = realTime;
	}

	public RouteDetail getRouteDetail() {
		return routeDetail;
	}

	public void setRouteDetail(RouteDetail routeDetail) {
		this.routeDetail = routeDetail;
	}

	public RealTime getNearestBus() {
		return nearestBus;
	}

	public void setNearestBus(RealTime nearestBus) {
		this.nearestBus = nearestBus;
	}
	

}
