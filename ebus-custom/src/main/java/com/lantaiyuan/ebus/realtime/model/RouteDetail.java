package com.lantaiyuan.ebus.realtime.model;

import java.util.List;

import org.lanqiao.ssm.common.model.Model;

import com.lantaiyuan.ebus.custom.model.BaseStation;

/**
* @Title: Stations.java
* @Package com.lantaiyuan.ebus.realtime.model
* @Description: 
* @author yangyang   
* @date 2016年12月21日 下午2:40:18
* @version v1.0
 */
public class RouteDetail extends Model {

	private static final long serialVersionUID = 4638561886244696254L;
	
	private MapPath mapPath;
	private RouteInBaseLine route;
	private List<RealTime> carList ;
	private List<BaseStation> station;
	private BaseStation currentStation;
	
	public RouteDetail(RouteInBaseLine route, List<BaseStation> station, BaseStation conrentStation,List<RealTime> carList) {
		super();
		this.route = route;
		this.station = station;
		this.currentStation = conrentStation;
		this.carList = carList;
	}
	
	public RouteDetail(RouteInBaseLine route, List<BaseStation> station, BaseStation conrentStation,List<RealTime> carList ,MapPath mapPath) {
		super();
		this.route = route;
		this.station = station;
		this.currentStation = conrentStation;
		this.carList = carList;
		this.mapPath = mapPath;
	}
	
	public RouteDetail() {
		super();
	}
	
	public List<RealTime> getCarList() {
		return carList;
	}
	public void setCarList(List<RealTime> carList) {
		this.carList = carList;
	}
	public RouteInBaseLine getRoute() {
		return route;
	}
	public void setRoute(RouteInBaseLine route) {
		this.route = route;
	}
	
	public List<BaseStation> getStation() {
		return station;
	}
	public void setStation(List<BaseStation> station) {
		this.station = station;
	}
	public BaseStation getCurrentStation() {
		return currentStation;
	}
	public void setCurrentStation(BaseStation currentStation) {
		this.currentStation = currentStation;
	}


	public MapPath getMapPath() {
		return mapPath;
	}

	public void setMapPath(MapPath mapPath) {
		this.mapPath = mapPath;
	}

}
