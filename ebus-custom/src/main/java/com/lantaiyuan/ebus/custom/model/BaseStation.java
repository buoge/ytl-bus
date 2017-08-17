package com.lantaiyuan.ebus.custom.model;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;
import org.lanqiao.ssm.common.model.Model;


public class BaseStation extends Model {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer stationid;

    private String name;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private BigDecimal longitudein;

    private BigDecimal latitudein;

    private BigDecimal longitudeout;

    private BigDecimal latitudeout;

    private Integer stationflag;

    private Integer stationstatus;

    @NotEmpty(message = "城市编码不能为空")
    private String citycode;
    
    private Double distance = 0.0;
    
    private Integer stationno = 0;
    
    public Integer getStationno() {
        return stationno;
    }

    public void setStationno(Integer stationno) {
        this.stationno = stationno;
    }

    public Double getDistance() {
    	return distance;
    }
    
    public void setDistance(Double distance) {
    	this.distance = distance;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStationid() {
        return stationid;
    }

    public void setStationid(Integer stationid) {
        this.stationid = stationid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitudein() {
        return longitudein;
    }

    public void setLongitudein(BigDecimal longitudein) {
        this.longitudein = longitudein;
    }

    public BigDecimal getLatitudein() {
        return latitudein;
    }

    public void setLatitudein(BigDecimal latitudein) {
        this.latitudein = latitudein;
    }

    public BigDecimal getLongitudeout() {
        return longitudeout;
    }

    public void setLongitudeout(BigDecimal longitudeout) {
        this.longitudeout = longitudeout;
    }

    public BigDecimal getLatitudeout() {
        return latitudeout;
    }

    public void setLatitudeout(BigDecimal latitudeout) {
        this.latitudeout = latitudeout;
    }

    public Integer getStationflag() {
        return stationflag;
    }

    public void setStationflag(Integer stationflag) {
        this.stationflag = stationflag;
    }

    public Integer getStationstatus() {
        return stationstatus;
    }

    public void setStationstatus(Integer stationstatus) {
        this.stationstatus = stationstatus;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }

    public BaseStation copyStation(BaseStation stationOld) {
	BaseStation station = new BaseStation();
	station.setId(stationOld.getId());
	station.setStationid(stationOld.getStationid());
	station.setName(stationOld.getName());
	station.setLongitude(stationOld.getLongitude());
	station.setLatitude(stationOld.getLatitude());
	station.setLongitudein(stationOld.getLongitudein());
	station.setLatitudein(stationOld.getLatitudein());

	station.setLongitudeout(stationOld.getLongitudeout());
	station.setLatitudeout(stationOld.getLatitudeout());
	station.setStationflag(stationOld.getStationflag());
	
	station.setCitycode(stationOld.getCitycode());
	station.setStationstatus(stationOld.getStationstatus());
	station.setDistance(stationOld.getDistance());
	return station ;
    }
    
    @Override
	public String toString() {
		return "Station [id=" + id + ", stationid=" + stationid + ", name=" + name + ", longitude=" + longitude
				+ ", latitude=" + latitude + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((stationid == null) ? 0 : stationid.hashCode());
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
		BaseStation other = (BaseStation) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (stationid == null) {
			if (other.stationid != null)
				return false;
		} else if (!stationid.equals(other.stationid))
			return false;
		return true;
	}
}