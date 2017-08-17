package com.lantaiyuan.ebus.custom.model;

import java.math.BigDecimal;

import org.lanqiao.ssm.common.model.Model;

public class StationCount extends Model{

	private static final long serialVersionUID = -3492766973818189437L;
	
	private String stationName;
	private BigDecimal lon;
	private BigDecimal lan;
	private int count;
	private int start_count;
	private int end_count;
	private int start_or_end;//0: start, 1: end, 2: start and end
	
	public static StationCount newInstance(String stationName,BigDecimal lon,BigDecimal lan,
			int count, int start_or_end) {
		StationCount sc = new StationCount();
		sc.setCount(count);
		sc.setLan(lan);
		sc.setLon(lon);
		sc.setStart_or_end(start_or_end);
		sc.setStationName(stationName);
		return sc;
	}
	
	public int getStart_count() {
		return start_count;
	}
	public void setStart_count(int start_count) {
		this.start_count = start_count;
	}



	public int getEnd_count() {
		return end_count;
	}



	public void setEnd_count(int end_count) {
		this.end_count = end_count;
	}



	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	
	public BigDecimal getLon() {
		return lon;
	}

	public void setLon(BigDecimal lon) {
		this.lon = lon;
	}

	public BigDecimal getLan() {
		return lan;
	}

	public void setLan(BigDecimal lan) {
		this.lan = lan;
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getStart_or_end() {
		return start_or_end;
	}
	public void setStart_or_end(int start_or_end) {
		this.start_or_end = start_or_end;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lan == null) ? 0 : lan.hashCode());
		result = prime * result + ((lon == null) ? 0 : lon.hashCode());
		result = prime * result + ((stationName == null) ? 0 : stationName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StationCount other = (StationCount) obj;
		if (lan == null) {
			if (other.lan != null)
				return false;
		} else if (!lan.equals(other.lan))
			return false;
		if (lon == null) {
			if (other.lon != null)
				return false;
		} else if (!lon.equals(other.lon))
			return false;
		if (stationName == null) {
			if (other.stationName != null)
				return false;
		} else if (!stationName.equals(other.stationName))
			return false;
		return true;
	}
	
	

}
