package com.lantaiyuan.ebus.realtime.model;

import java.math.BigDecimal;
import java.util.Date;

import org.lanqiao.ssm.common.model.BaseModel;

/***
 * 
* <p>Title: BdCommonSearch</p>
* <p>Description: 大数据常用查询实体类</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年4月27日 下午4:30:30
 */
public class BdCommonSearchQueryModel extends BaseModel<BdCommonSearch>{
    /***serialVersionUID***/
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String userId;

    private String routeId;

    private Integer direction;

    private String routeName;

    private Integer aboardStationId;

    private String aboardStationName;

    private String aboardPosition;

    private Date aboardTime;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private String citycode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId == null ? null : routeId.trim();
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName == null ? null : routeName.trim();
    }

    public Integer getAboardStationId() {
        return aboardStationId;
    }

    public void setAboardStationId(Integer aboardStationId) {
        this.aboardStationId = aboardStationId;
    }

    public String getAboardStationName() {
        return aboardStationName;
    }

    public void setAboardStationName(String aboardStationName) {
        this.aboardStationName = aboardStationName == null ? null : aboardStationName.trim();
    }

    public String getAboardPosition() {
        return aboardPosition;
    }

    public void setAboardPosition(String aboardPosition) {
        this.aboardPosition = aboardPosition == null ? null : aboardPosition.trim();
    }

    public Date getAboardTime() {
        return aboardTime;
    }

    public void setAboardTime(Date aboardTime) {
        this.aboardTime = aboardTime;
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

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }
}