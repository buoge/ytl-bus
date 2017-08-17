package com.lantaiyuan.ebus.carpool.model;

import org.lanqiao.ssm.common.model.Model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 拼车撮合中形成的线路信息表
 * CarpoolRoute
 * 数据库表：carpool_route
 */
public class CarpoolRoute extends Model{

    private static final long serialVersionUID = -2112021595924447569L;
    /**
     * 自增主键
     * 表字段 : carpool_route.id
     */
    private Long id;

    /**
     * 创建时间
     * 表字段 : carpool_route.gmt_create
     */
    private Date gmtCreate;

    /**
     * 最后修改时间
     * 表字段 : carpool_route.gmt_modified
     */
    private Date gmtModified;

    /**
     * 线路ID
     * 表字段 : carpool_route.carpool_route_id
     */
    private String carpoolRouteId;

    /**
     * 线路名称
     * 表字段 : carpool_route.carpool_route_name
     */
    private String carpoolRouteName;

    /**
     * 1：普通专线，2：直达专线
     * 表字段 : carpool_route.carpool_route_type
     */
    private Integer carpoolRouteType;

    /**
     * 线路里程
     * 表字段 : carpool_route.distance
     */
    private BigDecimal distance;

    /**
     * 票价(单位：元)
     * 表字段 : carpool_route.price
     */
    private String price;

    /**
     * 始发站
     * 表字段 : carpool_route.start_station
     */
    private String startStation;

    /**
     * 终点站
     * 表字段 : carpool_route.end_station
     */
    private String endStation;

    /**
     * 1:工作日规律性，2:非工作日规律性,-1：非规律性
     * 表字段 : carpool_route.status
     */
    private Byte status;

    /**
     * 城市编码
     * 表字段 : carpool_route.city_code
     */
    private String cityCode;

    /**
     * 发车次数
     * 表字段 : carpool_route.depart_times
     */
    private Integer departTimes;

    /**
     * 发车时间
     * 表字段 : carpool_route.depart_time
     */
    private Date departTime;

    /**
     * 到达时间
     * 表字段 : carpool_route.arrive_time
     */
    private Date arriveTime;

    /**
     *
     * 表字段 : carpool_route.field1
     */
    private String field1;

    /**
     *
     * 表字段 : carpool_route.field2
     */
    private String field2;

    /**
     *
     * 表字段 : carpool_route.field3
     */
    private String field3;

    /**
     * 获取 自增主键 字段:carpool_route.id
     *
     * @return carpool_route.id, 自增主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 自增主键 字段:carpool_route.id
     *
     * @param id the value for carpool_route.id, 自增主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 创建时间 字段:carpool_route.gmt_create
     *
     * @return carpool_route.gmt_create, 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置 创建时间 字段:carpool_route.gmt_create
     *
     * @param gmtCreate the value for carpool_route.gmt_create, 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取 最后修改时间 字段:carpool_route.gmt_modified
     *
     * @return carpool_route.gmt_modified, 最后修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置 最后修改时间 字段:carpool_route.gmt_modified
     *
     * @param gmtModified the value for carpool_route.gmt_modified, 最后修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取 线路ID 字段:carpool_route.carpool_route_id
     *
     * @return carpool_route.carpool_route_id, 线路ID
     */
    public String getCarpoolRouteId() {
        return carpoolRouteId;
    }

    /**
     * 设置 线路ID 字段:carpool_route.carpool_route_id
     *
     * @param carpoolRouteId the value for carpool_route.carpool_route_id, 线路ID
     */
    public void setCarpoolRouteId(String carpoolRouteId) {
        this.carpoolRouteId = carpoolRouteId == null ? null : carpoolRouteId.trim();
    }

    /**
     * 获取 线路名称 字段:carpool_route.carpool_route_name
     *
     * @return carpool_route.carpool_route_name, 线路名称
     */
    public String getCarpoolRouteName() {
        return carpoolRouteName;
    }

    /**
     * 设置 线路名称 字段:carpool_route.carpool_route_name
     *
     * @param carpoolRouteName the value for carpool_route.carpool_route_name, 线路名称
     */
    public void setCarpoolRouteName(String carpoolRouteName) {
        this.carpoolRouteName = carpoolRouteName == null ? null : carpoolRouteName.trim();
    }

    /**
     * 获取 1：普通专线，2：直达专线 字段:carpool_route.carpool_route_type
     *
     * @return carpool_route.carpool_route_type, 1：普通专线，2：直达专线
     */
    public Integer getCarpoolRouteType() {
        return carpoolRouteType;
    }

    /**
     * 设置 1：普通专线，2：直达专线 字段:carpool_route.carpool_route_type
     *
     * @param carpoolRouteType the value for carpool_route.carpool_route_type, 1：普通专线，2：直达专线
     */
    public void setCarpoolRouteType(Integer carpoolRouteType) {
        this.carpoolRouteType = carpoolRouteType;
    }

    /**
     * 获取 线路里程 字段:carpool_route.distance
     *
     * @return carpool_route.distance, 线路里程
     */
    public BigDecimal getDistance() {
        return distance;
    }

    /**
     * 设置 线路里程 字段:carpool_route.distance
     *
     * @param distance the value for carpool_route.distance, 线路里程
     */
    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    /**
     * 获取 票价(单位：元) 字段:carpool_route.price
     *
     * @return carpool_route.price, 票价(单位：元)
     */
    public String getPrice() {
        return price;
    }

    /**
     * 设置 票价(单位：元) 字段:carpool_route.price
     *
     * @param price the value for carpool_route.price, 票价(单位：元)
     */
    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    /**
     * 获取 始发站 字段:carpool_route.start_station
     *
     * @return carpool_route.start_station, 始发站
     */
    public String getStartStation() {
        return startStation;
    }

    /**
     * 设置 始发站 字段:carpool_route.start_station
     *
     * @param startStation the value for carpool_route.start_station, 始发站
     */
    public void setStartStation(String startStation) {
        this.startStation = startStation == null ? null : startStation.trim();
    }

    /**
     * 获取 终点站 字段:carpool_route.end_station
     *
     * @return carpool_route.end_station, 终点站
     */
    public String getEndStation() {
        return endStation;
    }

    /**
     * 设置 终点站 字段:carpool_route.end_station
     *
     * @param endStation the value for carpool_route.end_station, 终点站
     */
    public void setEndStation(String endStation) {
        this.endStation = endStation == null ? null : endStation.trim();
    }

    /**
     * 获取 1:工作日规律性，2:非工作日规律性,-1：非规律性 字段:carpool_route.status
     *
     * @return carpool_route.status, 1:工作日规律性，2:非工作日规律性,-1：非规律性
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置 1:工作日规律性，2:非工作日规律性,-1：非规律性 字段:carpool_route.status
     *
     * @param status the value for carpool_route.status, 1:工作日规律性，2:非工作日规律性,-1：非规律性
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取 城市编码 字段:carpool_route.city_code
     *
     * @return carpool_route.city_code, 城市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置 城市编码 字段:carpool_route.city_code
     *
     * @param cityCode the value for carpool_route.city_code, 城市编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * 获取 发车次数 字段:carpool_route.depart_times
     *
     * @return carpool_route.depart_times, 发车次数
     */
    public Integer getDepartTimes() {
        return departTimes;
    }

    /**
     * 设置 发车次数 字段:carpool_route.depart_times
     *
     * @param departTimes the value for carpool_route.depart_times, 发车次数
     */
    public void setDepartTimes(Integer departTimes) {
        this.departTimes = departTimes;
    }

    /**
     * 获取 发车时间 字段:carpool_route.depart_time
     *
     * @return carpool_route.depart_time, 发车时间
     */
    public Date getDepartTime() {
        return departTime;
    }

    /**
     * 设置 发车时间 字段:carpool_route.depart_time
     *
     * @param departTime the value for carpool_route.depart_time, 发车时间
     */
    public void setDepartTime(Date departTime) {
        this.departTime = departTime;
    }

    /**
     * 获取 到达时间 字段:carpool_route.arrive_time
     *
     * @return carpool_route.arrive_time, 到达时间
     */
    public Date getArriveTime() {
        return arriveTime;
    }

    /**
     * 设置 到达时间 字段:carpool_route.arrive_time
     *
     * @param arriveTime the value for carpool_route.arrive_time, 到达时间
     */
    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    /**
     * 获取  字段:carpool_route.field1
     *
     * @return carpool_route.field1,
     */
    public String getField1() {
        return field1;
    }

    /**
     * 设置  字段:carpool_route.field1
     *
     * @param field1 the value for carpool_route.field1,
     */
    public void setField1(String field1) {
        this.field1 = field1 == null ? null : field1.trim();
    }

    /**
     * 获取  字段:carpool_route.field2
     *
     * @return carpool_route.field2,
     */
    public String getField2() {
        return field2;
    }

    /**
     * 设置  字段:carpool_route.field2
     *
     * @param field2 the value for carpool_route.field2,
     */
    public void setField2(String field2) {
        this.field2 = field2 == null ? null : field2.trim();
    }

    /**
     * 获取  字段:carpool_route.field3
     *
     * @return carpool_route.field3,
     */
    public String getField3() {
        return field3;
    }

    /**
     * 设置  字段:carpool_route.field3
     *
     * @param field3 the value for carpool_route.field3, 
     */
    public void setField3(String field3) {
        this.field3 = field3 == null ? null : field3.trim();
    }
}