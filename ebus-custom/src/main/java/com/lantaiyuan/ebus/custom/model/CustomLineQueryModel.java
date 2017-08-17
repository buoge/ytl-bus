package com.lantaiyuan.ebus.custom.model;

import java.math.BigDecimal;
import java.util.Date;

import org.lanqiao.ssm.common.model.BaseModel;

public class CustomLineQueryModel extends BaseModel<CustomLine> {
	
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String id;
    
    private String routeno;
    
    private String routeid;
   
    private String routename;

    private String shortname;

    private BigDecimal distance;

    private BigDecimal price;

    private String startworktime;
    
    private String offworktime;

    private String startstation;

    private BigDecimal startlongitude;

    private BigDecimal startlatitude;

    private String endstation;

    private BigDecimal endlongitude;

    private BigDecimal endlatitude;

    private Integer status;

    private String citycode;

    private Integer applicantuserid;

    private Integer count;

    private Date createtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRouteno() {
        return routeno;
    }

    public void setRouteno(String routeno) {
        this.routeno = routeno == null ? null : routeno.trim();
    }
    
    public String getRouteid() {
    	return routeid;
    }
    
    public void setRouteid(String routeid) {
    	this.routeid = routeid;
    }
    

    public String getRoutename() {
        return routename;
    }

    public void setRoutename(String routename) {
        this.routename = routename == null ? null : routename.trim();
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname == null ? null : shortname.trim();
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStartworktime() {
        return startworktime;
    }

    public void setStartworktime(String startworktime) {
        this.startworktime = startworktime == null ? null : startworktime.trim();
    }

    public String getOffworktime() {
        return offworktime;
    }

    public void setOffworktime(String offworktime) {
        this.offworktime = offworktime == null ? null : offworktime.trim();
    }

    public String getStartstation() {
        return startstation;
    }

    public void setStartstation(String startstation) {
        this.startstation = startstation == null ? null : startstation.trim();
    }

    public BigDecimal getStartlongitude() {
        return startlongitude;
    }

    public void setStartlongitude(BigDecimal startlongitude) {
        this.startlongitude = startlongitude;
    }

    public BigDecimal getStartlatitude() {
        return startlatitude;
    }

    public void setStartlatitude(BigDecimal startlatitude) {
        this.startlatitude = startlatitude;
    }

    public String getEndstation() {
        return endstation;
    }

    public void setEndstation(String endstation) {
        this.endstation = endstation == null ? null : endstation.trim();
    }

    public BigDecimal getEndlongitude() {
        return endlongitude;
    }

    public void setEndlongitude(BigDecimal endlongitude) {
        this.endlongitude = endlongitude;
    }

    public BigDecimal getEndlatitude() {
        return endlatitude;
    }

    public void setEndlatitude(BigDecimal endlatitude) {
        this.endlatitude = endlatitude;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }

    public Integer getApplicantuserid() {
        return applicantuserid;
    }

    public void setApplicantuserid(Integer applicantuserid) {
        this.applicantuserid = applicantuserid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}