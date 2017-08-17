package com.lantaiyuan.ebus.realtime.model;

import java.util.List;
import java.util.Set;

import org.lanqiao.ssm.common.model.Model;

import com.lantaiyuan.ebus.custom.model.BaseStation;
import com.lantaiyuan.ebus.realtime.model.gaode.MyPoi;
/***
 * 
* <p>Title: RouteStation</p>
* <p>Description: </p>
* <p>Company: lty</p>
* @author liuhao
* @date 2016年12月20日 下午6:29:07
* version 1.0
 */

public class RouteStation extends Model{
	public RouteStation(List<RouteInBaseLine> routes, Set<BaseStation> stations, List<MyPoi> myPois) {
		this.routes = routes;
		this.stations = stations;
		this.myPois = myPois;
	}
	public RouteStation() {
		
	}
	private static final long serialVersionUID = 8385790895546628335L;
    
	private List<RouteInBaseLine> routes;
 	private Set<BaseStation> stations;
 	
 	//新增地点集合  
 	private List<MyPoi> myPois;
 	
	public List<RouteInBaseLine> getRoutes() {
		return routes;
	}
	public void setRoutes(List<RouteInBaseLine> routes) {
		this.routes = routes;
	}
	public Set<BaseStation> getStations() {
		return stations;
	}
	public void setStations(Set<BaseStation> stations) {
		this.stations = stations;
	}
	/**
	* @return myPois
	*/
	public List<MyPoi> getMyPois() {
		return myPois;
	}
	/**
	* @param myPois 要设置的 myPois
	*/
	public void setMyPois(List<MyPoi> myPois) {
		this.myPois = myPois;
	}
	
}
