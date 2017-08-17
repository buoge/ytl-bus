package com.lantaiyuan.ebus.realtime.model;


public class GotoCarAlertSettingModel{

    /**
     * 主键
     * 表字段 : jpush_goto_car_alert_setting.ID
     */
    private String entityId;

    /**
     * 用户ID
     * 表字段 : jpush_goto_car_alert_setting.USER_ID
     */
    private String userId;

    /**
     * 城市编码
     * 表字段 : jpush_goto_car_alert_setting.CITY_CODE
     */
    private String cityCode;

    /**
     * 上下班标签(1-上班提醒  2-下班提醒)
     * 表字段 : jpush_goto_car_alert_setting.TAG
     */
    private String tag;

    /**
     * 提醒策略（1-只一次  2-周一到周五 3-每天）
     * 表字段 : jpush_goto_car_alert_setting.ALERT_STRATEGY
     */
    private String alertStrategy;

    /**
     * 是否开启（0-未开启 1-已开启）
     * 表字段 : jpush_goto_car_alert_setting.IS_OPEN
     */
    private String isOpen;

    /**
     * 开始时间
     * 表字段 : jpush_goto_car_alert_setting.START_TIME
     */
    private String startTime;

    /**
     * 结束时间
     * 表字段 : jpush_goto_car_alert_setting.END_TIME
     */
    private String endTime;

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getAlertStrategy() {
        return alertStrategy;
    }

    public void setAlertStrategy(String alertStrategy) {
        this.alertStrategy = alertStrategy;
    }

    public String getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(String isOpen) {
        this.isOpen = isOpen;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


    
}
