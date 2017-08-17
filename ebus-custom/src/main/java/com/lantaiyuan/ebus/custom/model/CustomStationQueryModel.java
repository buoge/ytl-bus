package com.lantaiyuan.ebus.custom.model;

import java.math.BigDecimal;

import org.lanqiao.ssm.common.model.BaseModel;

import com.wordnik.swagger.annotations.*;

@ApiModel
public class CustomStationQueryModel extends BaseModel<CustomStation>{
	
    /**
     * 
     **/
    private static final long serialVersionUID = 1L;

    private String id;

    private String stationid;

    private String name;
    
    @ApiParam(value = "站点经度")
    private BigDecimal longitude;

    @ApiParam(value = "站点纬度")
    private BigDecimal latitude;

    private BigDecimal longitudein;

    private BigDecimal latitudein;

    private BigDecimal longitudeout;

    private BigDecimal latitudeout;

    private Integer stationflag;

    private Integer stationstatus;

    private String lineid;//需要保存到关系表里面
    
    private Integer stationno;//需要保存到关系表里面
    
    @ApiParam(value = "城市编码")
    private String citycode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getStationid() {
        return stationid;
    }

    public void setStationid(String stationid) {
        this.stationid = stationid == null ? null : stationid.trim();
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

    public String getLineid() {
        return lineid;
    }

    public void setLineid(String lineid) {
        this.lineid = lineid;
    }

    public Integer getStationno() {
        return stationno;
    }

    public void setStationno(Integer stationno) {
        this.stationno = stationno;
    }
    
    
}