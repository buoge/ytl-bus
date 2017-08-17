package com.lantaiyuan.ebus.custom.model.mytrail;

import java.util.List;

/**
 * 描述:我的线路地图详情展现对象
 * 作者:温海金
 * 最后更改时间:下午3:54:31
 */
public class MyTrailDetail {
	/**
	 * 车辆信息
	 */
	private BusInMyTrail bus;
	
	/**
	 * 线路信息
	 */
	private RouteInMyTrail routeDesc;
	
	/**
	 * 轨迹打点信息
	 */
	private List<LinePath> linePaths;
	
	/**
	 * 行程途径站点信息
	 */
	private List<StationInMyTrail> stations;

	public BusInMyTrail getBus() {
		return bus;
	}

	public void setBus(BusInMyTrail bus) {
		this.bus = bus;
	}

	public RouteInMyTrail getRouteDesc() {
		return routeDesc;
	}

	public void setRouteDesc(RouteInMyTrail routeDesc) {
		this.routeDesc = routeDesc;
	}

	public List<LinePath> getLinePath() {
		return linePaths;
	}

	public void setLinePath(List<LinePath> linePaths) {
		this.linePaths = linePaths;
	}

	public List<StationInMyTrail> getStations() {
		return stations;
	}

	public void setStations(List<StationInMyTrail> stations) {
		this.stations = stations;
	}

	public MyTrailDetail() {
	}

	public MyTrailDetail(BusInMyTrail bus, RouteInMyTrail routeDesc, List<LinePath> linePaths, List<StationInMyTrail> stations) {
		super();
		this.bus = bus;
		this.routeDesc = routeDesc;
		this.linePaths = linePaths;
		this.stations = stations;
	}
	
}
