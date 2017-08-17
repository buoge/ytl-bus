package com.lantaiyuan.ebus.realtime.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.lanqiao.ssm.common.model.Model;


public class RouteDetailQueryModel extends Model {

	private static final long serialVersionUID = 8528360500303833328L;
	@NotBlank
	private String routeid;
	@NotNull
	private Double longitude;
	@NotNull
	private Double latitude; 
	@NotNull
	private Integer direction;
	@NotBlank
	private String citycode;
	
	public RouteDetailQueryModel() {
		super();
	}
	
	public RouteDetailQueryModel(String routeid, Double longitude, Double latitude, Integer direction,
			String citycode) {
		super();
		this.routeid = routeid;
		this.longitude = longitude;
		this.latitude = latitude;
		this.direction = direction;
		this.citycode = citycode;
	}

	public String getRouteid() {
		return routeid;
	}
	public void setRouteid(String routeid) {
		this.routeid = routeid;
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
	public Integer getDirection() {
		return direction;
	}
	public void setDirection(Integer direction) {
		this.direction = direction;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	@Override
	public String toString() {
		return "RouteDetailQueryModel [routeid=" + routeid + ", longitude=" + longitude + ", latitude=" + latitude
				+ ", direction=" + direction + ", citycode=" + citycode + "]";
	}
	

}
