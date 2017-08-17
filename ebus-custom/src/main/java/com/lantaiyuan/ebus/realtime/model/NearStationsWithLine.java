package com.lantaiyuan.ebus.realtime.model;

import java.util.List;

import org.lanqiao.ssm.common.model.Model;

/**
 * 描述:附近的站点及线路相关信息
 * 作者:温海金
 * 最后更改时间:下午2:29:55
 */
public class NearStationsWithLine extends Model{
	
	private static final long serialVersionUID = -7878987824113497760L;

	public NearStationsWithLine(List<StationAndBaseLines> stationList) {
		this.stationList = stationList;
	}

	private List<StationAndBaseLines> stationList;

	public List<StationAndBaseLines> getStationList() {
	    return stationList;
	}

	public void setStationList(List<StationAndBaseLines> stationList) {
	    this.stationList = stationList;
	}

	
}
