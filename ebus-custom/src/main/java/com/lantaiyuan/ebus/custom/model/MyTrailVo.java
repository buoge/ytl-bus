package com.lantaiyuan.ebus.custom.model;


import java.util.Date;

import org.lanqiao.ssm.common.model.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 描述:我的行程（手机端展示）对象
 * 作者:温海金
 * 最后更改时间:上午11:40:00
 */
public class MyTrailVo extends Model{

	private static final long serialVersionUID = 1805487207675897484L;

	//主键id
    private Integer id;

    //用户id
    private Integer userid;
    
    //日期
    private String date;
    
    //上车时间
    @JsonIgnore
    private Date startTime;
    
    //上车时间显示值
    private String startTimeVal;
    
    //星期
    private String week;
    
    //总行程
    private Double trailDistance;
    
    //总用时(分钟)
    private Integer timeUnit;
    
    //上车站ID
    private Integer startStationId;
    
    //上车站名称
    private String startStationName;
    
    //下车站ID
    private Integer endStationId;
    
    //下车站名称
    private String endStationName;
    
    //线路名称
    private String routeName;
    
    //碳排放
    private Double carbonEmission;
    
    //评价状态（0-未评价 1-已评价）
    private Integer evaluateStatus;
    
    //城市编码
    @JsonIgnore
    private String cityCode;
    
    //线路ID
    @JsonIgnore
    private String routeId;
    
    //线路方向
    @JsonIgnore
    private Integer direction;
    
    
    //下车时间
    @JsonIgnore
    private Date endTime;
    

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public Double getTrailDistance() {
		return trailDistance;
	}

	public void setTrailDistance(Double trailDistance) {
		this.trailDistance = trailDistance;
	}

	public Integer getTimeUnit() {
		return timeUnit;
	}

	public void setTimeUnit(Integer timeUnit) {
		this.timeUnit = timeUnit;
	}

	public Integer getStartStationId() {
		return startStationId;
	}

	public void setStartStationId(Integer startStationId) {
		this.startStationId = startStationId;
	}

	public String getStartStationName() {
		return startStationName;
	}

	public void setStartStationName(String startStationName) {
		this.startStationName = startStationName;
	}

	public Integer getEndStationId() {
		return endStationId;
	}

	public void setEndStationId(Integer endStationId) {
		this.endStationId = endStationId;
	}

	public String getEndStationName() {
		return endStationName;
	}

	public void setEndStationName(String endStationName) {
		this.endStationName = endStationName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public Integer getDirection() {
		return direction;
	}

	public void setDirection(Integer direction) {
		this.direction = direction;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getStartTimeVal() {
		return startTimeVal;
	}

	public void setStartTimeVal(String startTimeVal) {
		this.startTimeVal = startTimeVal;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public Double getCarbonEmission() {
		return carbonEmission;
	}

	public void setCarbonEmission(Double carbonEmission) {
		this.carbonEmission = carbonEmission;
	}

	public Integer getEvaluateStatus() {
		return evaluateStatus;
	}

	public void setEvaluateStatus(Integer evaluateStatus) {
		this.evaluateStatus = evaluateStatus;
	}
    
}