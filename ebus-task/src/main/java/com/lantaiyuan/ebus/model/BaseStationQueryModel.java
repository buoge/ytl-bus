package com.lantaiyuan.ebus.model;

import java.math.BigDecimal;

import org.lanqiao.ssm.common.model.BaseModel;

public class BaseStationQueryModel extends BaseModel<BaseStation> {
    /**
     * 
     */
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

    private String citycode;

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
}