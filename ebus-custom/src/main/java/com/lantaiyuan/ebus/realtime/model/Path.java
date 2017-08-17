package com.lantaiyuan.ebus.realtime.model;

import org.lanqiao.ssm.common.model.Model;

/**
 * @Title: Path.java
 * @Package com.lantaiyuan.ebus.realtime.model
 * @Description:
 * @author yangyang
 * @date 2016年12月21日 下午2:46:38
 * @version v1.0
 */
public class Path extends Model {

	private static final long serialVersionUID = 8804291945756436390L;

	private Double longitude;
	private Double latitude;

	public Path() {
	}

	public Path(Double longitude, Double latitude) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}



}
