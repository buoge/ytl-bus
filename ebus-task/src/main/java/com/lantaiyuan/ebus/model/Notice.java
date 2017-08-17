package com.lantaiyuan.ebus.model;

import java.util.Date;

import org.lanqiao.ssm.common.model.Model;

/**
 * 
 * Notice
 * 数据库表：WEATHER_NOTICE
 */
public class Notice extends Model {

    /**
     * 
     */
    private static final long serialVersionUID = -7780209130216322167L;

    /**
     * 主键
     * 表字段 : WEATHER_NOTICE.ID
     */
    private String id;

    /**
     * 重要性等级（1-一般  2-较重要  3-非常重要）
     * 表字段 : WEATHER_NOTICE.IMPORTANT_GRADE
     */
    private Short importantGrade;

    /**
     * 通知范围（1-所有城市 2-全城 3-指定地点范围 4-指定线路范围）
     * 表字段 : WEATHER_NOTICE.NOTICE_RANGE
     */
    private Short noticeRange;

    /**
     * 距离范围（单位米）按指定地点范围发送时有值
     * 表字段 : WEATHER_NOTICE.DISTANCE_RANGE
     */
    private Integer distanceRange;

    /**
     * 城市编码(按全城发布和按线路发布时填写)
     * 表字段 : WEATHER_NOTICE.CITY_CODE
     */
    private String cityCode;

    /**
     * 已选线路（多条线路中间以逗号分割）按线路发布时填写
     * 表字段 : WEATHER_NOTICE.ROUTE_STR
     */
    private String routeStr;

    /**
     * 通知内容
     * 表字段 : WEATHER_NOTICE.CONTENT
     */
    private String content;

    /**
     * 发布时间
     * 表字段 : WEATHER_NOTICE.PUBLISH_TIME
     */
    private Date publishTime;

    /**
     * 1-未发布 2-已发布
     * 表字段 : WEATHER_NOTICE.PUBLISH_STATUS
     */
    private Short publishStatus;

    /**
     * 创建时间
     * 表字段 : WEATHER_NOTICE.CREATE_TIME
     */
    private Date createTime;

    /**
     * 获取 主键 字段:WEATHER_NOTICE.ID
     *
     * @return WEATHER_NOTICE.ID, 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 主键 字段:WEATHER_NOTICE.ID
     *
     * @param id the value for WEATHER_NOTICE.ID, 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 距离范围（单位米）按指定地点范围发送时有值 字段:WEATHER_NOTICE.DISTANCE_RANGE
     *
     * @return WEATHER_NOTICE.DISTANCE_RANGE, 距离范围（单位米）按指定地点范围发送时有值
     */
    public Integer getDistanceRange() {
        return distanceRange;
    }

    /**
     * 设置 距离范围（单位米）按指定地点范围发送时有值 字段:WEATHER_NOTICE.DISTANCE_RANGE
     *
     * @param distanceRange the value for WEATHER_NOTICE.DISTANCE_RANGE, 距离范围（单位米）按指定地点范围发送时有值
     */
    public void setDistanceRange(Integer distanceRange) {
        this.distanceRange = distanceRange;
    }

    /**
     * 获取 城市编码(按全城发布和按线路发布时填写) 字段:WEATHER_NOTICE.CITY_CODE
     *
     * @return WEATHER_NOTICE.CITY_CODE, 城市编码(按全城发布和按线路发布时填写)
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置 城市编码(按全城发布和按线路发布时填写) 字段:WEATHER_NOTICE.CITY_CODE
     *
     * @param cityCode the value for WEATHER_NOTICE.CITY_CODE, 城市编码(按全城发布和按线路发布时填写)
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * 获取 已选线路（多条线路中间以逗号分割）按线路发布时填写 字段:WEATHER_NOTICE.ROUTE_STR
     *
     * @return WEATHER_NOTICE.ROUTE_STR, 已选线路（多条线路中间以逗号分割）按线路发布时填写
     */
    public String getRouteStr() {
        return routeStr;
    }

    /**
     * 设置 已选线路（多条线路中间以逗号分割）按线路发布时填写 字段:WEATHER_NOTICE.ROUTE_STR
     *
     * @param routeStr the value for WEATHER_NOTICE.ROUTE_STR, 已选线路（多条线路中间以逗号分割）按线路发布时填写
     */
    public void setRouteStr(String routeStr) {
        this.routeStr = routeStr == null ? null : routeStr.trim();
    }

    /**
     * 获取 通知内容 字段:WEATHER_NOTICE.CONTENT
     *
     * @return WEATHER_NOTICE.CONTENT, 通知内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置 通知内容 字段:WEATHER_NOTICE.CONTENT
     *
     * @param content the value for WEATHER_NOTICE.CONTENT, 通知内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取 发布时间 字段:WEATHER_NOTICE.PUBLISH_TIME
     *
     * @return WEATHER_NOTICE.PUBLISH_TIME, 发布时间
     */
    public Date getPublishTime() {
        return publishTime;
    }

    /**
     * 设置 发布时间 字段:WEATHER_NOTICE.PUBLISH_TIME
     *
     * @param publishTime the value for WEATHER_NOTICE.PUBLISH_TIME, 发布时间
     */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    /**
     * 获取 创建时间 字段:WEATHER_NOTICE.CREATE_TIME
     *
     * @return WEATHER_NOTICE.CREATE_TIME, 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 字段:WEATHER_NOTICE.CREATE_TIME
     *
     * @param createTime the value for WEATHER_NOTICE.CREATE_TIME, 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Short getImportantGrade() {
        return importantGrade;
    }

    public void setImportantGrade(Short importantGrade) {
        this.importantGrade = importantGrade;
    }

    public Short getNoticeRange() {
        return noticeRange;
    }

    public void setNoticeRange(Short noticeRange) {
        this.noticeRange = noticeRange;
    }

    public Short getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Short publishStatus) {
        this.publishStatus = publishStatus;
    }
    
}