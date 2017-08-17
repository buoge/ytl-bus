/**
* <p>Title: FavoriteQueryModel.java</p>
* <p>Copyright: Copyright (c) 2016</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.realtime.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.lanqiao.ssm.common.model.BaseModel;

/**
* <p>Title: FavoriteQueryModel</p>
* <p>Description: </p>
* <p>Company: lty</p>
* @author liuhao
* @date 2016年12月22日 下午6:39:57
*/
public class FavoriateQueryModel extends BaseModel<Object>{
	/***serialVersionUID***/
	private static final long serialVersionUID = 1L;
	
	private Integer id;

	@NotNull
    private Integer userid;

    private String routeid;

    private String tag;

    @NotNull
    private Integer stationid;

    private String stationname;

    @NotNull
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
		this.routeid = routeid;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
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
		this.stationname = stationname;
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
		this.citycode = citycode;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

}
