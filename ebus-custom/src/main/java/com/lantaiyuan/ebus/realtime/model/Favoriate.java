package com.lantaiyuan.ebus.realtime.model;

import java.util.Date;

import org.lanqiao.ssm.common.model.Model;

public class Favoriate extends Model{
    /***serialVersionUID***/
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer userid;

    private String routeid;

    private String tag;

    private Integer stationid;

    private String stationname;

    private Integer direction;

    private Integer collectionstatus;

    private String citycode;

    private Date createdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getRouteid() {
        return routeid;
    }

    public void setRouteid(String routeid) {
        this.routeid = routeid == null ? null : routeid.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public Integer getStationid() {
        return stationid;
    }

    public void setStationid(Integer stationid) {
        this.stationid = stationid;
    }

    public String getStationname() {
        return stationname;
    }

    public void setStationname(String stationname) {
        this.stationname = stationname == null ? null : stationname.trim();
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Integer getCollectionstatus() {
        return collectionstatus;
    }

    public void setCollectionstatus(Integer collectionstatus) {
        this.collectionstatus = collectionstatus;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}