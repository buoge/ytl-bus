package com.lantaiyuan.ebus.realtime.model;

import java.util.List;

import org.lanqiao.ssm.common.model.Model;

public class MapPath extends Model {

	private static final long serialVersionUID = -6087525905907221108L;

	private Double startLongitude;
	private Double startLatitude;
	private Double endLongitude;
	private Double endLatitude;
	private List<Path> path;

	public MapPath() {
	}

	public MapPath(Double startLongitude, Double startLatitude, Double endLongitude, Double endLatitude,
			List<Path> path) {
		this.startLongitude = startLongitude;
		this.startLatitude = startLatitude;
		this.endLongitude = endLongitude;
		this.endLatitude = endLatitude;
		this.path = path;
	}

	public MapPath(List<Path> path) {
		super();
		this.path = path;
	}

	public Double getStartLongitude() {
		return startLongitude;
	}

	public void setStartLongitude(Double startLongitude) {
		this.startLongitude = startLongitude;
	}

	public Double getStartLatitude() {
		return startLatitude;
	}

	public void setStartLatitude(Double startLatitude) {
		this.startLatitude = startLatitude;
	}

	public Double getEndLongitude() {
		return endLongitude;
	}

	public void setEndLongitude(Double endLongitude) {
		this.endLongitude = endLongitude;
	}

	public Double getEndLatitude() {
		return endLatitude;
	}

	public void setEndLatitude(Double endLatitude) {
		this.endLatitude = endLatitude;
	}

	public List<Path> getPath() {
		return path;
	}

	public void setPath(List<Path> path) {
		this.path = path;
	}

}
