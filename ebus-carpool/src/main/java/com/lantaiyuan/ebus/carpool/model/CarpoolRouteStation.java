package com.lantaiyuan.ebus.carpool.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.lanqiao.ssm.common.model.Model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 拼车撮合后形成的线站关系表
 * CarpoolRouteStation
 * 数据库表：carpool_route_station
 */
public class CarpoolRouteStation extends Model{

    private static final long serialVersionUID = 6879978671386407007L;
    /**
     * 自增主键
     * 表字段 : carpool_route_station.id
     */
    private Long id;

    /**
     * 创建时间
     * 表字段 : carpool_route_station.gmt_create
     */
    @JsonIgnore
    private Date gmtCreate;

    /**
     * 最后修改时间
     * 表字段 : carpool_route_station.gmt_modified
     */
    @JsonIgnore
    private Date gmtModified;

    /**
     * 线路ID
     * 表字段 : carpool_route_station.carpool_route_id
     */
    private String carpoolRouteId;

    /**
     * 站点id
     * 表字段 : carpool_route_station.station_id
     */
    private String stationId;

    /**
     * 站点名称
     * 表字段 : carpool_route_station.station_name
     */
    private String stationName;

    /**
     * 站点经度
     * 表字段 : carpool_route_station.station_lon
     */
    private BigDecimal stationLon;

    /**
     * 站点纬度
     * 表字段 : carpool_route_station.station_lat
     */
    private BigDecimal stationLat;

    /**
     * 在该线路中是几站
     * 表字段 : carpool_route_station.station_no
     */
    private Integer stationNo;

    /**
     * 预计到达该站点时间
     * 表字段 : carpool_route_station.arrive_time
     */
    private Date arriveTime;

    /**
     * 上车人数
     * 表字段 : carpool_route_station.up_num
     */
    private Byte upNum;

    /**
     * 下车人数
     * 表字段 : carpool_route_station.down_num
     */
    private Byte downNum;

    /**
     * 站点类型：1-起点 2-中途站点 3-终点
     * 表字段 : carpool_route_station.station_type
     */
    private Byte stationType;

    /**
     * 城市编码
     * 表字段 : carpool_route_station.city_code
     */
    private String cityCode;

    /**
     * 
     * 表字段 : carpool_route_station.field1
     */
    @JsonIgnore
    private String field1;

    /**
     * 
     * 表字段 : carpool_route_station.field2
     */
    @JsonIgnore
    private String field2;

    /**
     * 
     * 表字段 : carpool_route_station.field3
     */
    @JsonIgnore
    private String field3;

    /**
     * 获取 自增主键 字段:carpool_route_station.id
     *
     * @return carpool_route_station.id, 自增主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 自增主键 字段:carpool_route_station.id
     *
     * @param id the value for carpool_route_station.id, 自增主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 创建时间 字段:carpool_route_station.gmt_create
     *
     * @return carpool_route_station.gmt_create, 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置 创建时间 字段:carpool_route_station.gmt_create
     *
     * @param gmtCreate the value for carpool_route_station.gmt_create, 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取 最后修改时间 字段:carpool_route_station.gmt_modified
     *
     * @return carpool_route_station.gmt_modified, 最后修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置 最后修改时间 字段:carpool_route_station.gmt_modified
     *
     * @param gmtModified the value for carpool_route_station.gmt_modified, 最后修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取 线路ID 字段:carpool_route_station.carpool_route_id
     *
     * @return carpool_route_station.carpool_route_id, 线路ID
     */
    public String getCarpoolRouteId() {
        return carpoolRouteId;
    }

    /**
     * 设置 线路ID 字段:carpool_route_station.carpool_route_id
     *
     * @param carpoolRouteId the value for carpool_route_station.carpool_route_id, 线路ID
     */
    public void setCarpoolRouteId(String carpoolRouteId) {
        this.carpoolRouteId = carpoolRouteId == null ? null : carpoolRouteId.trim();
    }

    /**
     * 获取 站点id 字段:carpool_route_station.station_id
     *
     * @return carpool_route_station.station_id, 站点id
     */
    public String getStationId() {
        return stationId;
    }

    /**
     * 设置 站点id 字段:carpool_route_station.station_id
     *
     * @param stationId the value for carpool_route_station.station_id, 站点id
     */
    public void setStationId(String stationId) {
        this.stationId = stationId == null ? null : stationId.trim();
    }

    /**
     * 获取 站点名称 字段:carpool_route_station.station_name
     *
     * @return carpool_route_station.station_name, 站点名称
     */
    public String getStationName() {
        return stationName;
    }

    /**
     * 设置 站点名称 字段:carpool_route_station.station_name
     *
     * @param stationName the value for carpool_route_station.station_name, 站点名称
     */
    public void setStationName(String stationName) {
        this.stationName = stationName == null ? null : stationName.trim();
    }

    /**
     * 获取 站点经度 字段:carpool_route_station.station_lon
     *
     * @return carpool_route_station.station_lon, 站点经度
     */
    public BigDecimal getStationLon() {
        return stationLon;
    }

    /**
     * 设置 站点经度 字段:carpool_route_station.station_lon
     *
     * @param stationLon the value for carpool_route_station.station_lon, 站点经度
     */
    public void setStationLon(BigDecimal stationLon) {
        this.stationLon = stationLon;
    }

    /**
     * 获取 站点纬度 字段:carpool_route_station.station_lat
     *
     * @return carpool_route_station.station_lat, 站点纬度
     */
    public BigDecimal getStationLat() {
        return stationLat;
    }

    /**
     * 设置 站点纬度 字段:carpool_route_station.station_lat
     *
     * @param stationLat the value for carpool_route_station.station_lat, 站点纬度
     */
    public void setStationLat(BigDecimal stationLat) {
        this.stationLat = stationLat;
    }

    /**
     * 获取 在该线路中是几站 字段:carpool_route_station.station_no
     *
     * @return carpool_route_station.station_no, 在该线路中是几站
     */
    public Integer getStationNo() {
        return stationNo;
    }

    /**
     * 设置 在该线路中是几站 字段:carpool_route_station.station_no
     *
     * @param stationNo the value for carpool_route_station.station_no, 在该线路中是几站
     */
    public void setStationNo(Integer stationNo) {
        this.stationNo = stationNo;
    }

    /**
     * 获取 预计到达该站点时间 字段:carpool_route_station.arrive_time
     *
     * @return carpool_route_station.arrive_time, 预计到达该站点时间
     */
    public Date getArriveTime() {
        return arriveTime;
    }

    /**
     * 设置 预计到达该站点时间 字段:carpool_route_station.arrive_time
     *
     * @param arriveTime the value for carpool_route_station.arrive_time, 预计到达该站点时间
     */
    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    /**
     * 获取 上车人数 字段:carpool_route_station.up_num
     *
     * @return carpool_route_station.up_num, 上车人数
     */
    public Byte getUpNum() {
        return upNum;
    }

    /**
     * 设置 上车人数 字段:carpool_route_station.up_num
     *
     * @param upNum the value for carpool_route_station.up_num, 上车人数
     */
    public void setUpNum(Byte upNum) {
        this.upNum = upNum;
    }

    /**
     * 获取 下车人数 字段:carpool_route_station.down_num
     *
     * @return carpool_route_station.down_num, 下车人数
     */
    public Byte getDownNum() {
        return downNum;
    }

    /**
     * 设置 下车人数 字段:carpool_route_station.down_num
     *
     * @param downNum the value for carpool_route_station.down_num, 下车人数
     */
    public void setDownNum(Byte downNum) {
        this.downNum = downNum;
    }

    /**
     * 获取 站点类型：1-起点 2-中途站点 3-终点 字段:carpool_route_station.station_type
     *
     * @return carpool_route_station.station_type, 站点类型：1-起点 2-中途站点 3-终点
     */
    public Byte getStationType() {
        return stationType;
    }

    /**
     * 设置 站点类型：1-起点 2-中途站点 3-终点 字段:carpool_route_station.station_type
     *
     * @param stationType the value for carpool_route_station.station_type, 站点类型：1-起点 2-中途站点 3-终点
     */
    public void setStationType(Byte stationType) {
        this.stationType = stationType;
    }

    /**
     * 获取 城市编码 字段:carpool_route_station.city_code
     *
     * @return carpool_route_station.city_code, 城市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置 城市编码 字段:carpool_route_station.city_code
     *
     * @param cityCode the value for carpool_route_station.city_code, 城市编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * 获取  字段:carpool_route_station.field1
     *
     * @return carpool_route_station.field1, 
     */
    public String getField1() {
        return field1;
    }

    /**
     * 设置  字段:carpool_route_station.field1
     *
     * @param field1 the value for carpool_route_station.field1, 
     */
    public void setField1(String field1) {
        this.field1 = field1 == null ? null : field1.trim();
    }

    /**
     * 获取  字段:carpool_route_station.field2
     *
     * @return carpool_route_station.field2, 
     */
    public String getField2() {
        return field2;
    }

    /**
     * 设置  字段:carpool_route_station.field2
     *
     * @param field2 the value for carpool_route_station.field2, 
     */
    public void setField2(String field2) {
        this.field2 = field2 == null ? null : field2.trim();
    }

    /**
     * 获取  字段:carpool_route_station.field3
     *
     * @return carpool_route_station.field3, 
     */
    public String getField3() {
        return field3;
    }

    /**
     * 设置  字段:carpool_route_station.field3
     *
     * @param field3 the value for carpool_route_station.field3, 
     */
    public void setField3(String field3) {
        this.field3 = field3 == null ? null : field3.trim();
    }
}