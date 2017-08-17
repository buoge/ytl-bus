package com.lantaiyuan.ebus.custom.model.carpool;

import java.util.Date;

import org.lanqiao.ssm.common.model.Model;

/**
 * 拼车撮合后行程的线路辅助站点表
 * CarpoolRouteAssistStation
 * 数据库表：carpool_route_assit_station
 */
public class CarpoolRouteAssistStation extends Model{

	private static final long serialVersionUID = -6750075374879968305L;

	/**
     * 自增主键
     * 表字段 : carpool_route_assit_station.id
     */
    private Long id;

    /**
     * 创建时间
     * 表字段 : carpool_route_assit_station.gmt_create
     */
    private Date gmtCreate;

    /**
     * 最后修改时间
     * 表字段 : carpool_route_assit_station.gmt_modified
     */
    private Date gmtModified;

    /**
     * 线路ID
     * 表字段 : carpool_route_assit_station.carpool_route_id
     */
    private String carpoolRouteId;

    /**
     * 城市编码
     * 表字段 : carpool_route_assit_station.city_code
     */
    private String cityCode;

    /**
     * 
     * 表字段 : carpool_route_assit_station.field1
     */
    private String field1;

    /**
     * 
     * 表字段 : carpool_route_assit_station.field2
     */
    private String field2;

    /**
     * 
     * 表字段 : carpool_route_assit_station.field3
     */
    private String field3;

    /**
     * 辅助站点信息
     * 表字段 : carpool_route_assit_station.station_map
     */
    private String stationMap;

    /**
     * 获取 自增主键 字段:carpool_route_assit_station.id
     *
     * @return carpool_route_assit_station.id, 自增主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 自增主键 字段:carpool_route_assit_station.id
     *
     * @param id the value for carpool_route_assit_station.id, 自增主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 创建时间 字段:carpool_route_assit_station.gmt_create
     *
     * @return carpool_route_assit_station.gmt_create, 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置 创建时间 字段:carpool_route_assit_station.gmt_create
     *
     * @param gmtCreate the value for carpool_route_assit_station.gmt_create, 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取 最后修改时间 字段:carpool_route_assit_station.gmt_modified
     *
     * @return carpool_route_assit_station.gmt_modified, 最后修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置 最后修改时间 字段:carpool_route_assit_station.gmt_modified
     *
     * @param gmtModified the value for carpool_route_assit_station.gmt_modified, 最后修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取 线路ID 字段:carpool_route_assit_station.carpool_route_id
     *
     * @return carpool_route_assit_station.carpool_route_id, 线路ID
     */
    public String getCarpoolRouteId() {
        return carpoolRouteId;
    }

    /**
     * 设置 线路ID 字段:carpool_route_assit_station.carpool_route_id
     *
     * @param carpoolRouteId the value for carpool_route_assit_station.carpool_route_id, 线路ID
     */
    public void setCarpoolRouteId(String carpoolRouteId) {
        this.carpoolRouteId = carpoolRouteId == null ? null : carpoolRouteId.trim();
    }

    /**
     * 获取 城市编码 字段:carpool_route_assit_station.city_code
     *
     * @return carpool_route_assit_station.city_code, 城市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置 城市编码 字段:carpool_route_assit_station.city_code
     *
     * @param cityCode the value for carpool_route_assit_station.city_code, 城市编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * 获取  字段:carpool_route_assit_station.field1
     *
     * @return carpool_route_assit_station.field1, 
     */
    public String getField1() {
        return field1;
    }

    /**
     * 设置  字段:carpool_route_assit_station.field1
     *
     * @param field1 the value for carpool_route_assit_station.field1, 
     */
    public void setField1(String field1) {
        this.field1 = field1 == null ? null : field1.trim();
    }

    /**
     * 获取  字段:carpool_route_assit_station.field2
     *
     * @return carpool_route_assit_station.field2, 
     */
    public String getField2() {
        return field2;
    }

    /**
     * 设置  字段:carpool_route_assit_station.field2
     *
     * @param field2 the value for carpool_route_assit_station.field2, 
     */
    public void setField2(String field2) {
        this.field2 = field2 == null ? null : field2.trim();
    }

    /**
     * 获取  字段:carpool_route_assit_station.field3
     *
     * @return carpool_route_assit_station.field3, 
     */
    public String getField3() {
        return field3;
    }

    /**
     * 设置  字段:carpool_route_assit_station.field3
     *
     * @param field3 the value for carpool_route_assit_station.field3, 
     */
    public void setField3(String field3) {
        this.field3 = field3 == null ? null : field3.trim();
    }

    /**
     * 获取 辅助站点信息 字段:carpool_route_assit_station.station_map
     *
     * @return carpool_route_assit_station.station_map, 辅助站点信息
     */
    public String getStationMap() {
        return stationMap;
    }

    /**
     * 设置 辅助站点信息 字段:carpool_route_assit_station.station_map
     *
     * @param stationMap the value for carpool_route_assit_station.station_map, 辅助站点信息
     */
    public void setStationMap(String stationMap) {
        this.stationMap = stationMap == null ? null : stationMap.trim();
    }
}