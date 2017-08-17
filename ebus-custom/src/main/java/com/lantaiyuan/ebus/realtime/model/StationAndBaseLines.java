package com.lantaiyuan.ebus.realtime.model;

import java.util.List;

import org.lanqiao.ssm.common.model.Model;

import com.lantaiyuan.ebus.custom.model.BaseStation;

/**
 * 描述:站点及线路对象（与StationAndRoutes对应）
 * 作者:温海金
 * 最后更改时间:下午2:18:19
 */
public class StationAndBaseLines extends Model {

	private static final long serialVersionUID = -6317257950237273660L;

	public StationAndBaseLines(BaseStation station, List<BaseLine> lines) {
		this.station = station;
		this.lines = lines;
	}

	private BaseStation station;
	private List<BaseLine> lines;

	public BaseStation getStation() {
		return station;
	}

	public void setStation(BaseStation station) {
		this.station = station;
	}

	public List<BaseLine> getLines() {
	    return lines;
	}

	public void setLines(List<BaseLine> lines) {
	    this.lines = lines;
	}

}
