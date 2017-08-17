package com.lantaiyuan.ebus.realtime.model;

import java.io.Serializable;
import java.util.List;

import com.lantaiyuan.ebus.custom.model.BaseStation;

/**
 * 描述:站点附近信息模型（包括附件站点及附近线路）
 * 作者:温海金
 * 最后更改时间:下午4:33:15
 */
public class StationNearInfo implements Serializable {

	public StationNearInfo() {
	}
	
	public StationNearInfo(BaseStation currentStation, List<BaseLine> currentStationLines, List<BaseStation> nearbyStations,BaseStation regularStation,BaseLine regularLine) {
		this.currentStation = currentStation;
		this.currentStationLines = currentStationLines;
		this.nearbyStations = nearbyStations;
		this.regularStation = regularStation;
		this.regularLine = regularLine;
	}
	private static final long serialVersionUID = -3239024958126696138L;
	
	/************new added by liuhao on regular search*****************/
	//常用查询站点
	private BaseStation regularStation;
	
	//常用查询线路
	private BaseLine regularLine;
	/**************************end***************************************/
	
	private BaseStation currentStation;
	private List<BaseLine> currentStationLines;
	private List<BaseStation> nearbyStations;
	public BaseStation getCurrentStation() {
		return currentStation;
	}
	public void setCurrentStation(BaseStation currentStation) {
		this.currentStation = currentStation;
	}
	public List<BaseLine> getCurrentStationLines() {
		return currentStationLines;
	}
	public void setCurrentStationLines(List<BaseLine> currentStationLines) {
		this.currentStationLines = currentStationLines;
	}
	public List<BaseStation> getNearbyStations() {
		return nearbyStations;
	}
	public void setNearbyStations(List<BaseStation> nearbyStations) {
		this.nearbyStations = nearbyStations;
	}

	/**
	* @return regularStation
	*/
	public BaseStation getRegularStation() {
		return regularStation;
	}

	/**
	* @param regularStation 要设置的 regularStation
	*/
	public void setRegularStation(BaseStation regularStation) {
		this.regularStation = regularStation;
	}

	/**
	* @return regularLine
	*/
	public BaseLine getRegularLine() {
		return regularLine;
	}

	/**
	* @param regularLine 要设置的 regularLine
	*/
	public void setRegularLine(BaseLine regularLine) {
		this.regularLine = regularLine;
	}
	
}
