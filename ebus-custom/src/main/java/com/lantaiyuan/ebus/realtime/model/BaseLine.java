package com.lantaiyuan.ebus.realtime.model;

import org.lanqiao.ssm.common.model.Model;


/**
 * 描述:对Line进行代码重构
 * 作者:温海金
 * 最后更改时间:上午10:38:28
 */
public class BaseLine extends Model {

	private static final long serialVersionUID = 4633343433468221813L;

	private RouteInBaseLine routeInBaseLine;
	
	private RealTime realTime;
	
	public RouteInBaseLine getRouteInBaseLine() {
	    return routeInBaseLine;
	}

	public void setRouteInBaseLine(RouteInBaseLine routeInBaseLine) {
	    this.routeInBaseLine = routeInBaseLine;
	}

	public RealTime getRealTime() {
	    return realTime;
	}

	public void setRealTime(RealTime realTime) {
	    this.realTime = realTime;
	}

	public BaseLine(RouteInBaseLine routeInBaseLine, RealTime realTime) {
		this.routeInBaseLine = routeInBaseLine;
		this.realTime = realTime;
	}

	public BaseLine() {

	}

}
