package com.lantaiyuan.ebus.realtime.model;

import org.lanqiao.ssm.common.model.Model;
/***
 * 
* <p>Title: RouteSimpleInfo</p>
* <p>Description: </p>
* <p>Company: lty</p>
* @author liuhao
* @date 2016年12月21日 下午5:55:00
 */
public class RouteSimpleInfo extends Model{
	public RouteSimpleInfo() {
		super();
	}
	public RouteSimpleInfo(String routeId, Integer direction) {
		super();
		this.routeId = routeId;
		this.direction = direction;
	}
	private static final long serialVersionUID = 1410285147741465749L;
	
	private String routeId;
	private Integer direction;
	public String getRouteId() {
		return routeId;
	}
	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}
	public Integer getDirection() {
		return direction;
	}
	public void setDirection(Integer direction) {
		this.direction = direction;
	}

}
