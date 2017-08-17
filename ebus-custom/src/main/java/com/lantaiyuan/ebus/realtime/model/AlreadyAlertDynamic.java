package com.lantaiyuan.ebus.realtime.model;

import java.util.Date;

import org.lanqiao.ssm.common.model.Model;

public class AlreadyAlertDynamic extends Model{

    /**
     * 
     */
    private static final long serialVersionUID = 315250269579935109L;

    /**
     * 主键ID
     * 表字段 : jpush_already_alert_dynamic.ID
     */
    private String id;

    /**
     * 提醒设置表（JPUSH_GOTO_CAR_ALERT_SETTING）的ID
     * 表字段 : jpush_already_alert_dynamic.GOTO_CAR_ALERT_SETTING_ID
     */
    private String gotoCarAlertSettingId;

    /**
     * 车辆ID
     * 表字段 : jpush_already_alert_dynamic.VEHICLE_ID
     */
    private String vehicleId;

    /**
     * 线路ID
     * 表字段 : jpush_already_alert_dynamic.ROUTE_ID
     */
    private String routeId;
    /**
     * 上下班标签(1-上班提醒  2-下班提醒)
     * 表字段 : jpush_goto_car_alert_setting.TAG
     */
    private Integer tag;
    /**
     * 创建时间
     * 表字段 : jpush_already_alert_dynamic.CREATE_TIME
     */
    private Date createTime;

    /**
     * 获取 主键ID 字段:jpush_already_alert_dynamic.ID
     *
     * @return jpush_already_alert_dynamic.ID, 主键ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 主键ID 字段:jpush_already_alert_dynamic.ID
     *
     * @param id the value for jpush_already_alert_dynamic.ID, 主键ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    /**
     * 获取 提醒设置表（JPUSH_GOTO_CAR_ALERT_SETTING）的ID 字段:jpush_already_alert_dynamic.GOTO_CAR_ALERT_SETTING_ID
     *
     * @return jpush_already_alert_dynamic.GOTO_CAR_ALERT_SETTING_ID, 提醒设置表（JPUSH_GOTO_CAR_ALERT_SETTING）的ID
     */
    public String getGotoCarAlertSettingId() {
        return gotoCarAlertSettingId;
    }

    /**
     * 设置 提醒设置表（JPUSH_GOTO_CAR_ALERT_SETTING）的ID 字段:jpush_already_alert_dynamic.GOTO_CAR_ALERT_SETTING_ID
     *
     * @param gotoCarAlertSettingId the value for jpush_already_alert_dynamic.GOTO_CAR_ALERT_SETTING_ID, 提醒设置表（JPUSH_GOTO_CAR_ALERT_SETTING）的ID
     */
    public void setGotoCarAlertSettingId(String gotoCarAlertSettingId) {
        this.gotoCarAlertSettingId = gotoCarAlertSettingId == null ? null : gotoCarAlertSettingId.trim();
    }

    /**
     * 获取 车辆ID 字段:jpush_already_alert_dynamic.VEHICLE_ID
     *
     * @return jpush_already_alert_dynamic.VEHICLE_ID, 车辆ID
     */
    public String getVehicleId() {
        return vehicleId;
    }

    /**
     * 设置 车辆ID 字段:jpush_already_alert_dynamic.VEHICLE_ID
     *
     * @param vehicleId the value for jpush_already_alert_dynamic.VEHICLE_ID, 车辆ID
     */
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId == null ? null : vehicleId.trim();
    }

    /**
     * 获取 线路ID 字段:jpush_already_alert_dynamic.ROUTE_ID
     *
     * @return jpush_already_alert_dynamic.ROUTE_ID, 线路ID
     */
    public String getRouteId() {
        return routeId;
    }

    /**
     * 设置 线路ID 字段:jpush_already_alert_dynamic.ROUTE_ID
     *
     * @param routeId the value for jpush_already_alert_dynamic.ROUTE_ID, 线路ID
     */
    public void setRouteId(String routeId) {
        this.routeId = routeId == null ? null : routeId.trim();
    }

    /**
     * 获取 创建时间 字段:jpush_already_alert_dynamic.CREATE_TIME
     *
     * @return jpush_already_alert_dynamic.CREATE_TIME, 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 字段:jpush_already_alert_dynamic.CREATE_TIME
     *
     * @param createTime the value for jpush_already_alert_dynamic.CREATE_TIME, 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
