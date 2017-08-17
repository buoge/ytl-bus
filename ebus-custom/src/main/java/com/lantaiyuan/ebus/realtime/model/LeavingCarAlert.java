package com.lantaiyuan.ebus.realtime.model;

import java.util.Date;

/**
 * 
 * LeavingCarAlert
 * 数据库表：t_leaving_car_alert_dynamic
 */
public class LeavingCarAlert {

    /**
     * 主键
     * 表字段 : t_leaving_car_alert_dynamic.ID
     */
    private String id;

    /**
     * 用户ID
     * 表字段 : t_leaving_car_alert_dynamic.USER_ID
     */
    private String userId;

    /**
     * 线路ID
     * 表字段 : t_leaving_car_alert_dynamic.ROUTE_ID
     */
    private String routeId;

    /**
     * 车辆ID（车牌号）
     * 表字段 : t_leaving_car_alert_dynamic.VEHICLE_ID
     */
    private String vehicleId;

    /**
     * 创建时间
     * 表字段 : t_leaving_car_alert_dynamic.CREATE_TIME
     */
    private Date createTime;

    /**
     * 数据状态（1：未提醒 2：已提醒）默认为1
     * 表字段 : t_leaving_car_alert_dynamic.STATUS
     */
    private Short status;
    
    /**
     * 城市编码
     * 表字段 : t_leaving_car_alert_dynamic.CITY_CODE
     */
    private String cityCode;
    
    /**
     * 线路方向 0-上行 1-下行
     * 表字段 : t_leaving_car_alert_dynamic.DIRECTION
     */
    private Integer direction;
    
    /**
     * 获取 主键 字段:t_leaving_car_alert_dynamic.ID
     *
     * @return t_leaving_car_alert_dynamic.ID, 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 主键 字段:t_leaving_car_alert_dynamic.ID
     *
     * @param id the value for t_leaving_car_alert_dynamic.ID, 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 用户ID 字段:t_leaving_car_alert_dynamic.USER_ID
     *
     * @return t_leaving_car_alert_dynamic.USER_ID, 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置 用户ID 字段:t_leaving_car_alert_dynamic.USER_ID
     *
     * @param userId the value for t_leaving_car_alert_dynamic.USER_ID, 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取 线路ID 字段:t_leaving_car_alert_dynamic.ROUTE_ID
     *
     * @return t_leaving_car_alert_dynamic.ROUTE_ID, 线路ID
     */
    public String getRouteId() {
        return routeId;
    }

    /**
     * 设置 线路ID 字段:t_leaving_car_alert_dynamic.ROUTE_ID
     *
     * @param routeId the value for t_leaving_car_alert_dynamic.ROUTE_ID, 线路ID
     */
    public void setRouteId(String routeId) {
        this.routeId = routeId == null ? null : routeId.trim();
    }

    /**
     * 获取 车辆ID（车牌号） 字段:t_leaving_car_alert_dynamic.VEHICLE_ID
     *
     * @return t_leaving_car_alert_dynamic.VEHICLE_ID, 车辆ID（车牌号）
     */
    public String getVehicleId() {
        return vehicleId;
    }

    /**
     * 设置 车辆ID（车牌号） 字段:t_leaving_car_alert_dynamic.VEHICLE_ID
     *
     * @param vehicleId the value for t_leaving_car_alert_dynamic.VEHICLE_ID, 车辆ID（车牌号）
     */
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId == null ? null : vehicleId.trim();
    }

    /**
     * 获取 创建时间 字段:t_leaving_car_alert_dynamic.CREATE_TIME
     *
     * @return t_leaving_car_alert_dynamic.CREATE_TIME, 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 字段:t_leaving_car_alert_dynamic.CREATE_TIME
     *
     * @param createTime the value for t_leaving_car_alert_dynamic.CREATE_TIME, 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    
   
}