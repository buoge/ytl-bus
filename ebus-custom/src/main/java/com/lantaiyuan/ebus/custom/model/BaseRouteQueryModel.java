package com.lantaiyuan.ebus.custom.model;

import java.math.BigDecimal;
import java.util.Date;

import org.lanqiao.ssm.common.model.BaseModel;

public class BaseRouteQueryModel extends BaseModel<BaseRoute> {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String routeid;

    private String routeno;

    private String routename;

    private String shortname;

    private Integer routetype;

    private BigDecimal distance;

    private String price;

    private String summerstarttime;

    private String summerendtime;

    private String winterstarttime;

    private String winterendtime;

    private String startstation;

    private String endstation;

    private Integer status;

    private Integer direction;

    private String citycode;

    private Date summerenddate;

    private Date summerstartdate;

    private Date winterenddate;

    private Date winterstartdate;

    private Integer reversal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRouteid() {
        return routeid;
    }

    public void setRouteid(String routeid) {
        this.routeid = routeid == null ? null : routeid.trim();
    }

    public String getRouteno() {
        return routeno;
    }

    public void setRouteno(String routeno) {
        this.routeno = routeno == null ? null : routeno.trim();
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

    public Integer getRoutetype() {
        return routetype;
    }

    public void setRoutetype(Integer routetype) {
        this.routetype = routetype;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getSummerstarttime() {
        return summerstarttime;
    }

    public void setSummerstarttime(String summerstarttime) {
        this.summerstarttime = summerstarttime == null ? null : summerstarttime.trim();
    }

    public String getSummerendtime() {
        return summerendtime;
    }

    public void setSummerendtime(String summerendtime) {
        this.summerendtime = summerendtime == null ? null : summerendtime.trim();
    }

    public String getWinterstarttime() {
        return winterstarttime;
    }

    public void setWinterstarttime(String winterstarttime) {
        this.winterstarttime = winterstarttime == null ? null : winterstarttime.trim();
    }

    public String getWinterendtime() {
        return winterendtime;
    }

    public void setWinterendtime(String winterendtime) {
        this.winterendtime = winterendtime == null ? null : winterendtime.trim();
    }

    public String getStartstation() {
        return startstation;
    }

    public void setStartstation(String startstation) {
        this.startstation = startstation == null ? null : startstation.trim();
    }

    public String getEndstation() {
        return endstation;
    }

    public void setEndstation(String endstation) {
        this.endstation = endstation == null ? null : endstation.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        this.citycode = citycode == null ? null : citycode.trim();
    }

    public Date getSummerenddate() {
        return summerenddate;
    }

    public void setSummerenddate(Date summerenddate) {
        this.summerenddate = summerenddate;
    }

    public Date getSummerstartdate() {
        return summerstartdate;
    }

    public void setSummerstartdate(Date summerstartdate) {
        this.summerstartdate = summerstartdate;
    }

    public Date getWinterenddate() {
        return winterenddate;
    }

    public void setWinterenddate(Date winterenddate) {
        this.winterenddate = winterenddate;
    }

    public Date getWinterstartdate() {
        return winterstartdate;
    }

    public void setWinterstartdate(Date winterstartdate) {
        this.winterstartdate = winterstartdate;
    }

    public Integer getReversal() {
        return reversal;
    }

    public void setReversal(Integer reversal) {
        this.reversal = reversal;
    }
}