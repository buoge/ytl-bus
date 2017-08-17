package com.lantaiyuan.ebus.realtime.model;

import java.math.BigDecimal;

import org.lanqiao.ssm.common.model.Model;

import com.lantaiyuan.ebus.custom.model.BaseRoute;
/**
 * 描述:BaseLine对象中的route相关属性
 * 作者:温海金
 * 最后更改时间:上午11:00:12
 */
public class RouteInBaseLine extends Model {
    
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String routeid;

    private String routeno;

    private String routename;

    private String shortname;

    private Integer routetype;

    private BigDecimal distance = BigDecimal.valueOf(0.0);

    private String price;

    private String startstation;

    private String endstation;

    private Integer status;
    
    private Integer direction;

    private String citycode;
    
    private Integer reversal = 0;
    
    private String starttime;
    
    private String endtime;

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
        this.routeid = routeid;
    }

    public String getRouteno() {
        return routeno;
    }

    public void setRouteno(String routeno) {
        this.routeno = routeno;
    }

    public String getRoutename() {
        return routename;
    }

    public void setRoutename(String routename) {
        this.routename = routename;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
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
        this.price = price;
    }

    public String getStartstation() {
        return startstation;
    }

    public void setStartstation(String startstation) {
        this.startstation = startstation;
    }

    public String getEndstation() {
        return endstation;
    }

    public void setEndstation(String endstation) {
        this.endstation = endstation;
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
        this.citycode = citycode;
    }

    public Integer getReversal() {
        return reversal;
    }

    public void setReversal(Integer reversal) {
        this.reversal = reversal;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    
    public RouteInBaseLine(BaseRoute baseRoute) {
	this.id = baseRoute.getId();
	this.routeid = baseRoute.getRouteid();
	this.routeno = baseRoute.getRouteno();
	this.routename = baseRoute.getRoutename();
	this.shortname = baseRoute.getShortname();
	this.routetype = baseRoute.getRoutetype();
	this.distance = baseRoute.getDistance();
	this.price = baseRoute.getPrice();
	this.startstation = baseRoute.getStartstation();
	this.endstation = baseRoute.getEndstation();
	this.status = baseRoute.getStatus();
	this.direction = baseRoute.getDirection();
	this.citycode = baseRoute.getCitycode();
	this.reversal = baseRoute.getReversal();
	this.starttime = baseRoute.getStarttime();
	this.endtime = baseRoute.getEndtime();
    }

    public RouteInBaseLine() {
    }
    
    
    
}