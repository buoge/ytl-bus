package com.lantaiyuan.ebus.custom.model;

import java.math.BigDecimal;
import java.util.Date;

import org.lanqiao.ssm.common.model.Model;

/***
 * 
* <p>Title: RouteStationRelation</p>
* <p>Description: 线站自定义实体类</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年3月31日 下午3:18:17
 */
public class RouteStationRelation extends Model {
    private static final long serialVersionUID = 1L;
    
    /**
     * 线路id
     * 表字段 : rel_route_station.routeId
     */
    private String routeid;

    /**
     * 站点id
     * 表字段 : rel_route_station.stationId
     */
    private String stationid;

    /**
     * 先前站点id
     * 表字段 : rel_route_station.previousStationId
     */
    private Integer previousstationid;

    /**
     * 下一站点id
     * 表字段 : rel_route_station.nextStationId
     */
    private Integer nextstationid;

    /**
     * 在该线路中是几站
     * 表字段 : rel_route_station.stationNo
     */
    private Integer stationno;

    /**
     * 创建时间
     * 表字段 : rel_route_station.createTime
     */
    private Date createtime;

    /**
     * 线路方向 0-上行 1-下行
     * 表字段 : rel_route_station.direction
     */
    private Integer direction;

    private String name;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private BigDecimal longitudein;

    private BigDecimal latitudein;

    private BigDecimal longitudeout;

    private BigDecimal latitudeout;

    private Integer stationflag;

    private Integer stationstatus;

	public String getRouteid() {
		return routeid;
	}

	public void setRouteid(String routeid) {
		this.routeid = routeid;
	}

	public String getStationid() {
		return stationid;
	}

	public void setStationid(String stationid) {
		this.stationid = stationid;
	}

	public Integer getPreviousstationid() {
		return previousstationid;
	}

	public void setPreviousstationid(Integer previousstationid) {
		this.previousstationid = previousstationid;
	}

	public Integer getNextstationid() {
		return nextstationid;
	}

	public void setNextstationid(Integer nextstationid) {
		this.nextstationid = nextstationid;
	}

	public Integer getStationno() {
		return stationno;
	}

	public void setStationno(Integer stationno) {
		this.stationno = stationno;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getDirection() {
		return direction;
	}

	public void setDirection(Integer direction) {
		this.direction = direction;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "RouteStationRelation [routeid=" + routeid + ", stationid=" + stationid + ", previousstationid="
				+ previousstationid + ", nextstationid=" + nextstationid + ", stationno=" + stationno + ", createtime="
				+ createtime + ", direction=" + direction + ", name=" + name + ", longitude=" + longitude
				+ ", latitude=" + latitude + ", longitudein=" + longitudein + ", latitudein=" + latitudein
				+ ", longitudeout=" + longitudeout + ", latitudeout=" + latitudeout + ", stationflag=" + stationflag
				+ ", stationstatus=" + stationstatus + "]";
	}

}