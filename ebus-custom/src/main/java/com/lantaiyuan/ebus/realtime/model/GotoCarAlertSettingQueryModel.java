package com.lantaiyuan.ebus.realtime.model;

import java.util.Date;

import org.lanqiao.ssm.common.model.BaseModel;

public class GotoCarAlertSettingQueryModel extends BaseModel<GotoCarAlertSetting>{


    /**
     * 
     */
    private static final long serialVersionUID = 4299604579782709771L;

    /**
     * 主键
     * 表字段 : jpush_goto_car_alert_setting.ID
     */
    private String id;

    /**
     * 用户ID
     * 表字段 : jpush_goto_car_alert_setting.USER_ID
     */
    private Integer userId;

    /**
     * 城市编码
     * 表字段 : jpush_goto_car_alert_setting.CITY_CODE
     */
    private String cityCode;

    /**
     * 上下班标签(1-上班提醒  2-下班提醒)
     * 表字段 : jpush_goto_car_alert_setting.TAG
     */
    private Integer tag;

    /**
     * 提醒策略（1-只一次  2-周一到周五 3-每天）
     * 表字段 : jpush_goto_car_alert_setting.ALERT_STRATEGY
     */
    private Integer alertStrategy;

    /**
     * 是否已提醒（0-未提醒（默认） 1-已提醒）
     * 表字段 : jpush_goto_car_alert_setting.IS_REMIND
     */
    private Boolean isRemind;

    /**
     * 是否开启（0-未开启 1-已开启）
     * 表字段 : jpush_goto_car_alert_setting.IS_OPEN
     */
    private Boolean isOpen;

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

    /**
     * 创建时间
     * 表字段 : jpush_goto_car_alert_setting.CREATE_TIME
     */
    private Date createTime;

    /**
     * 获取 主键 字段:jpush_goto_car_alert_setting.ID
     *
     * @return jpush_goto_car_alert_setting.ID, 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 主键 字段:jpush_goto_car_alert_setting.ID
     *
     * @param id the value for jpush_goto_car_alert_setting.ID, 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 用户ID 字段:jpush_goto_car_alert_setting.USER_ID
     *
     * @return jpush_goto_car_alert_setting.USER_ID, 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置 用户ID 字段:jpush_goto_car_alert_setting.USER_ID
     *
     * @param userId the value for jpush_goto_car_alert_setting.USER_ID, 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取 城市编码 字段:jpush_goto_car_alert_setting.CITY_CODE
     *
     * @return jpush_goto_car_alert_setting.CITY_CODE, 城市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置 城市编码 字段:jpush_goto_car_alert_setting.CITY_CODE
     *
     * @param cityCode the value for jpush_goto_car_alert_setting.CITY_CODE, 城市编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * 获取 上下班标签(1-上班提醒  2-下班提醒) 字段:jpush_goto_car_alert_setting.TAG
     *
     * @return jpush_goto_car_alert_setting.TAG, 上下班标签(1-上班提醒  2-下班提醒)
     */
    public Integer getTag() {
        return tag;
    }

    /**
     * 设置 上下班标签(1-上班提醒  2-下班提醒) 字段:jpush_goto_car_alert_setting.TAG
     *
     * @param tag the value for jpush_goto_car_alert_setting.TAG, 上下班标签(1-上班提醒  2-下班提醒)
     */
    public void setTag(Integer tag) {
        this.tag = tag;
    }

    /**
     * 获取 提醒策略（1-只一次  2-周一到周五 3-每天） 字段:jpush_goto_car_alert_setting.ALERT_STRATEGY
     *
     * @return jpush_goto_car_alert_setting.ALERT_STRATEGY, 提醒策略（1-只一次  2-周一到周五 3-每天）
     */
    public Integer getAlertStrategy() {
        return alertStrategy;
    }

    /**
     * 设置 提醒策略（1-只一次  2-周一到周五 3-每天） 字段:jpush_goto_car_alert_setting.ALERT_STRATEGY
     *
     * @param alertStrategy the value for jpush_goto_car_alert_setting.ALERT_STRATEGY, 提醒策略（1-只一次  2-周一到周五 3-每天）
     */
    public void setAlertStrategy(Integer alertStrategy) {
        this.alertStrategy = alertStrategy;
    }

    /**
     * 获取 是否已提醒（0-未提醒（默认） 1-已提醒） 字段:jpush_goto_car_alert_setting.IS_REMIND
     *
     * @return jpush_goto_car_alert_setting.IS_REMIND, 是否已提醒（0-未提醒（默认） 1-已提醒）
     */
    public Boolean getIsRemind() {
        return isRemind;
    }

    /**
     * 设置 是否已提醒（0-未提醒（默认） 1-已提醒） 字段:jpush_goto_car_alert_setting.IS_REMIND
     *
     * @param isRemind the value for jpush_goto_car_alert_setting.IS_REMIND, 是否已提醒（0-未提醒（默认） 1-已提醒）
     */
    public void setIsRemind(Boolean isRemind) {
        this.isRemind = isRemind;
    }

    /**
     * 获取 是否开启（0-未开启 1-已开启） 字段:jpush_goto_car_alert_setting.IS_OPEN
     *
     * @return jpush_goto_car_alert_setting.IS_OPEN, 是否开启（0-未开启 1-已开启）
     */
    public Boolean getIsOpen() {
        return isOpen;
    }

    /**
     * 设置 是否开启（0-未开启 1-已开启） 字段:jpush_goto_car_alert_setting.IS_OPEN
     *
     * @param isOpen the value for jpush_goto_car_alert_setting.IS_OPEN, 是否开启（0-未开启 1-已开启）
     */
    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    /**
     * 获取 开始时间 字段:jpush_goto_car_alert_setting.START_TIME
     *
     * @return jpush_goto_car_alert_setting.START_TIME, 开始时间
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置 开始时间 字段:jpush_goto_car_alert_setting.START_TIME
     *
     * @param startTime the value for jpush_goto_car_alert_setting.START_TIME, 开始时间
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    /**
     * 获取 结束时间 字段:jpush_goto_car_alert_setting.END_TIME
     *
     * @return jpush_goto_car_alert_setting.END_TIME, 结束时间
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置 结束时间 字段:jpush_goto_car_alert_setting.END_TIME
     *
     * @param endTime the value for jpush_goto_car_alert_setting.END_TIME, 结束时间
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    /**
     * 获取 创建时间 字段:jpush_goto_car_alert_setting.CREATE_TIME
     *
     * @return jpush_goto_car_alert_setting.CREATE_TIME, 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 字段:jpush_goto_car_alert_setting.CREATE_TIME
     *
     * @param createTime the value for jpush_goto_car_alert_setting.CREATE_TIME, 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
