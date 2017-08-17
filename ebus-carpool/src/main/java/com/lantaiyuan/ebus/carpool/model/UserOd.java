package com.lantaiyuan.ebus.carpool.model;

import org.lanqiao.ssm.common.model.Model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户od表
 * UserOd
 * 数据库表：user_od
 */
public class UserOd extends Model{

    private static final long serialVersionUID = 2557754215473249437L;

    /**
     * 记录od唯一号
     * 表字段 : user_od.id
     */
    private String id;

    /**
     * 计算出来日期
     * 表字段 : user_od.calculated_date
     */
    private Date calculatedDate;

    /**
     * 消息属性(1:已消费，2:收藏，3:搜索计算，4:热点站点)
     * 表字段 : user_od.type
     */
    private Integer type;

    /**
     * 星期(1:周一，2：周二，依此类推)
     * 表字段 : user_od.week
     */
    private Integer week;

    /**
     * 用户id
     * 表字段 : user_od.user_id
     */
    private Integer userId;

    /**
     * 手机注册号
     * 表字段 : user_od.registration_id
     */
    private String registrationId;

    /**
     * 起点站(备用)
     * 表字段 : user_od.start_station
     */
    private String startStation;

    /**
     * O点经度
     * 表字段 : user_od.start_longitude
     */
    private BigDecimal startLongitude;

    /**
     * O点纬度
     * 表字段 : user_od.start_latitude
     */
    private BigDecimal startLatitude;

    /**
     * o点半径(单位:米)
     * 表字段 : user_od.start_radius
     */
    private Integer startRadius;

    /**
     * O点平均起始时间
     * 表字段 : user_od.start_time
     */
    private Date startTime;

    /**
     * 终点站（备用）
     * 表字段 : user_od.end_station
     */
    private String endStation;

    /**
     * D点经度
     * 表字段 : user_od.end_longitude
     */
    private Double endLongitude;

    /**
     * D点纬度
     * 表字段 : user_od.end_latitude
     */
    private Double endLatitude;

    /**
     * d点半径(单位:米)
     * 表字段 : user_od.end_radius
     */
    private Integer endRadius;

    /**
     * od的距离(单位:米)
     * 表字段 : user_od.od_distance
     */
    private Double odDistance;

    /**
     * D点平均结束时间
     * 表字段 : user_od.end_time
     */
    private Date endTime;

    /**
     * 条件优先级(查询数据中TOP5的排序)
     * 表字段 : user_od.priority
     */
    private Integer priority;

    /**
     * 城市编码
     * 表字段 : user_od.city_code
     */
    private String cityCode;

    /**
     * 
     * 表字段 : user_od.gmt_create
     */
    private Date gmtCreate;

    /**
     * 
     * 表字段 : user_od.gmt_modified
     */
    private Date gmtModified;

    /**
     * 
     * 表字段 : user_od.field1
     */
    private String field1;

    /**
     * 
     * 表字段 : user_od.field2
     */
    private String field2;

    /**
     * 
     * 表字段 : user_od.field3
     */
    private String field3;

    /**
     * 获取 记录od唯一号 字段:user_od.id
     *
     * @return user_od.id, 记录od唯一号
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 记录od唯一号 字段:user_od.id
     *
     * @param id the value for user_od.id, 记录od唯一号
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 计算出来日期 字段:user_od.calculated_date
     *
     * @return user_od.calculated_date, 计算出来日期
     */
    public Date getCalculatedDate() {
        return calculatedDate;
    }

    /**
     * 设置 计算出来日期 字段:user_od.calculated_date
     *
     * @param calculatedDate the value for user_od.calculated_date, 计算出来日期
     */
    public void setCalculatedDate(Date calculatedDate) {
        this.calculatedDate = calculatedDate;
    }

    /**
     * 获取 消息属性(1:已消费，2:收藏，3:搜索计算，4:热点站点) 字段:user_od.type
     *
     * @return user_od.type, 消息属性(1:已消费，2:收藏，3:搜索计算，4:热点站点)
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置 消息属性(1:已消费，2:收藏，3:搜索计算，4:热点站点) 字段:user_od.type
     *
     * @param type the value for user_od.type, 消息属性(1:已消费，2:收藏，3:搜索计算，4:热点站点)
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取 星期(1:周一，2：周二，依此类推) 字段:user_od.week
     *
     * @return user_od.week, 星期(1:周一，2：周二，依此类推)
     */
    public Integer getWeek() {
        return week;
    }

    /**
     * 设置 星期(1:周一，2：周二，依此类推) 字段:user_od.week
     *
     * @param week the value for user_od.week, 星期(1:周一，2：周二，依此类推)
     */
    public void setWeek(Integer week) {
        this.week = week;
    }

    /**
     * 获取 用户id 字段:user_od.user_id
     *
     * @return user_od.user_id, 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置 用户id 字段:user_od.user_id
     *
     * @param userId the value for user_od.user_id, 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取 手机注册号 字段:user_od.registration_id
     *
     * @return user_od.registration_id, 手机注册号
     */
    public String getRegistrationId() {
        return registrationId;
    }

    /**
     * 设置 手机注册号 字段:user_od.registration_id
     *
     * @param registrationId the value for user_od.registration_id, 手机注册号
     */
    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId == null ? null : registrationId.trim();
    }

    /**
     * 获取 起点站(备用) 字段:user_od.start_station
     *
     * @return user_od.start_station, 起点站(备用)
     */
    public String getStartStation() {
        return startStation;
    }

    /**
     * 设置 起点站(备用) 字段:user_od.start_station
     *
     * @param startStation the value for user_od.start_station, 起点站(备用)
     */
    public void setStartStation(String startStation) {
        this.startStation = startStation == null ? null : startStation.trim();
    }

    /**
     * 获取 O点经度 字段:user_od.start_longitude
     *
     * @return user_od.start_longitude, O点经度
     */
    public BigDecimal getStartLongitude() {
        return startLongitude;
    }

    /**
     * 设置 O点经度 字段:user_od.start_longitude
     *
     * @param startLongitude the value for user_od.start_longitude, O点经度
     */
    public void setStartLongitude(BigDecimal startLongitude) {
        this.startLongitude = startLongitude;
    }

    /**
     * 获取 O点纬度 字段:user_od.start_latitude
     *
     * @return user_od.start_latitude, O点纬度
     */
    public BigDecimal getStartLatitude() {
        return startLatitude;
    }

    /**
     * 设置 O点纬度 字段:user_od.start_latitude
     *
     * @param startLatitude the value for user_od.start_latitude, O点纬度
     */
    public void setStartLatitude(BigDecimal startLatitude) {
        this.startLatitude = startLatitude;
    }

    /**
     * 获取 o点半径(单位:米) 字段:user_od.start_radius
     *
     * @return user_od.start_radius, o点半径(单位:米)
     */
    public Integer getStartRadius() {
        return startRadius;
    }

    /**
     * 设置 o点半径(单位:米) 字段:user_od.start_radius
     *
     * @param startRadius the value for user_od.start_radius, o点半径(单位:米)
     */
    public void setStartRadius(Integer startRadius) {
        this.startRadius = startRadius;
    }

    /**
     * 获取 O点平均起始时间 字段:user_od.start_time
     *
     * @return user_od.start_time, O点平均起始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置 O点平均起始时间 字段:user_od.start_time
     *
     * @param startTime the value for user_od.start_time, O点平均起始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取 终点站（备用） 字段:user_od.end_station
     *
     * @return user_od.end_station, 终点站（备用）
     */
    public String getEndStation() {
        return endStation;
    }

    /**
     * 设置 终点站（备用） 字段:user_od.end_station
     *
     * @param endStation the value for user_od.end_station, 终点站（备用）
     */
    public void setEndStation(String endStation) {
        this.endStation = endStation == null ? null : endStation.trim();
    }

    /**
     * 获取 D点经度 字段:user_od.end_longitude
     *
     * @return user_od.end_longitude, D点经度
     */
    public Double getEndLongitude() {
        return endLongitude;
    }

    /**
     * 设置 D点经度 字段:user_od.end_longitude
     *
     * @param endLongitude the value for user_od.end_longitude, D点经度
     */
    public void setEndLongitude(Double endLongitude) {
        this.endLongitude = endLongitude;
    }

    /**
     * 获取 D点纬度 字段:user_od.end_latitude
     *
     * @return user_od.end_latitude, D点纬度
     */
    public Double getEndLatitude() {
        return endLatitude;
    }

    /**
     * 设置 D点纬度 字段:user_od.end_latitude
     *
     * @param endLatitude the value for user_od.end_latitude, D点纬度
     */
    public void setEndLatitude(Double endLatitude) {
        this.endLatitude = endLatitude;
    }

    /**
     * 获取 d点半径(单位:米) 字段:user_od.end_radius
     *
     * @return user_od.end_radius, d点半径(单位:米)
     */
    public Integer getEndRadius() {
        return endRadius;
    }

    /**
     * 设置 d点半径(单位:米) 字段:user_od.end_radius
     *
     * @param endRadius the value for user_od.end_radius, d点半径(单位:米)
     */
    public void setEndRadius(Integer endRadius) {
        this.endRadius = endRadius;
    }

    /**
     * 获取 od的距离(单位:米) 字段:user_od.od_distance
     *
     * @return user_od.od_distance, od的距离(单位:米)
     */
    public Double getOdDistance() {
        return odDistance;
    }

    /**
     * 设置 od的距离(单位:米) 字段:user_od.od_distance
     *
     * @param odDistance the value for user_od.od_distance, od的距离(单位:米)
     */
    public void setOdDistance(Double odDistance) {
        this.odDistance = odDistance;
    }

    /**
     * 获取 D点平均结束时间 字段:user_od.end_time
     *
     * @return user_od.end_time, D点平均结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置 D点平均结束时间 字段:user_od.end_time
     *
     * @param endTime the value for user_od.end_time, D点平均结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取 条件优先级(查询数据中TOP5的排序) 字段:user_od.priority
     *
     * @return user_od.priority, 条件优先级(查询数据中TOP5的排序)
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * 设置 条件优先级(查询数据中TOP5的排序) 字段:user_od.priority
     *
     * @param priority the value for user_od.priority, 条件优先级(查询数据中TOP5的排序)
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * 获取 城市编码 字段:user_od.city_code
     *
     * @return user_od.city_code, 城市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置 城市编码 字段:user_od.city_code
     *
     * @param cityCode the value for user_od.city_code, 城市编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * 获取  字段:user_od.gmt_create
     *
     * @return user_od.gmt_create, 
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置  字段:user_od.gmt_create
     *
     * @param gmtCreate the value for user_od.gmt_create, 
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取  字段:user_od.gmt_modified
     *
     * @return user_od.gmt_modified, 
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置  字段:user_od.gmt_modified
     *
     * @param gmtModified the value for user_od.gmt_modified, 
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取  字段:user_od.field1
     *
     * @return user_od.field1, 
     */
    public String getField1() {
        return field1;
    }

    /**
     * 设置  字段:user_od.field1
     *
     * @param field1 the value for user_od.field1, 
     */
    public void setField1(String field1) {
        this.field1 = field1 == null ? null : field1.trim();
    }

    /**
     * 获取  字段:user_od.field2
     *
     * @return user_od.field2, 
     */
    public String getField2() {
        return field2;
    }

    /**
     * 设置  字段:user_od.field2
     *
     * @param field2 the value for user_od.field2, 
     */
    public void setField2(String field2) {
        this.field2 = field2 == null ? null : field2.trim();
    }

    /**
     * 获取  字段:user_od.field3
     *
     * @return user_od.field3, 
     */
    public String getField3() {
        return field3;
    }

    /**
     * 设置  字段:user_od.field3
     *
     * @param field3 the value for user_od.field3, 
     */
    public void setField3(String field3) {
        this.field3 = field3 == null ? null : field3.trim();
    }
}