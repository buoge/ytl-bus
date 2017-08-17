package com.lantaiyuan.ebus.realtime.model;

import java.math.BigDecimal;
import java.util.Date;

import org.lanqiao.ssm.common.model.Model;

/**
 * 线路辅助站点关系表
 * RelRouteAssistStation
 * 数据库表：rel_route_assit_station
 */
public class RelRouteAssistStation extends Model{


	private static final long serialVersionUID = -6562423882321888809L;

	/**
     * 自增主键id
     * 表字段 : rel_route_assit_station.id
     */
    private Integer id;

    /**
     * 线路id(GPSID)
     * 表字段 : rel_route_assit_station.routeId
     */
    private String routeid;

    /**
     * 线路名称
     * 表字段 : rel_route_assit_station.routeName
     */
    private String routename;

    /**
     * 线路别名
     * 表字段 : rel_route_assit_station.lineAlias
     */
    private String linealias;

    /**
     * 方向0：上行 1：下行
     * 表字段 : rel_route_assit_station.direction
     */
    private String direction;

    /**
     * 创建时间
     * 表字段 : rel_route_assit_station.createTime
     */
    private Date createtime;

    /**
     * 标记0：原先存在 1：手动添加
     * 表字段 : rel_route_assit_station.flag
     */
    private String flag;

    /**
     * 起始点经度
     * 表字段 : rel_route_assit_station.startLongitude
     */
    private BigDecimal startlongitude;

    /**
     * 起始点纬度
     * 表字段 : rel_route_assit_station.startLatitude
     */
    private BigDecimal startlatitude;

    /**
     * 终点经度
     * 表字段 : rel_route_assit_station.endLongitude
     */
    private BigDecimal endlongitude;

    /**
     * 终点纬度
     * 表字段 : rel_route_assit_station.endLatitude
     */
    private BigDecimal endlatitude;

    /**
     * 城市编码
     * 表字段 : rel_route_assit_station.cityCode
     */
    private String citycode;
    
    /**
     * 辅助站点信息
     * 表字段 : rel_route_assit_station.stationMap
     */
    private String stationmap;

    /**
     * 辅助站点信息2
     * 表字段 : rel_route_assit_station.stationMap2
     */
    private String stationmap2;

    /**
     * 获取 辅助站点信息 字段:rel_route_assit_station.stationMap
     *
     * @return rel_route_assit_station.stationMap, 辅助站点信息
     */
    public String getStationmap() {
        return stationmap;
    }

    /**
     * 设置 辅助站点信息 字段:rel_route_assit_station.stationMap
     *
     * @param stationmap the value for rel_route_assit_station.stationMap, 辅助站点信息
     */
    public void setStationmap(String stationmap) {
        this.stationmap = stationmap == null ? null : stationmap.trim();
    }

    /**
     * 获取 辅助站点信息2 字段:rel_route_assit_station.stationMap2
     *
     * @return rel_route_assit_station.stationMap2, 辅助站点信息2
     */
    public String getStationmap2() {
        return stationmap2;
    }

    /**
     * 设置 辅助站点信息2 字段:rel_route_assit_station.stationMap2
     *
     * @param stationmap2 the value for rel_route_assit_station.stationMap2, 辅助站点信息2
     */
    public void setStationmap2(String stationmap2) {
        this.stationmap2 = stationmap2 == null ? null : stationmap2.trim();
    }

    /**
     * 获取 自增主键id 字段:rel_route_assit_station.id
     *
     * @return rel_route_assit_station.id, 自增主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 自增主键id 字段:rel_route_assit_station.id
     *
     * @param id the value for rel_route_assit_station.id, 自增主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 线路id(GPSID) 字段:rel_route_assit_station.routeId
     *
     * @return rel_route_assit_station.routeId, 线路id(GPSID)
     */
    public String getRouteid() {
        return routeid;
    }

    /**
     * 设置 线路id(GPSID) 字段:rel_route_assit_station.routeId
     *
     * @param routeid the value for rel_route_assit_station.routeId, 线路id(GPSID)
     */
    public void setRouteid(String routeid) {
        this.routeid = routeid == null ? null : routeid.trim();
    }

    /**
     * 获取 线路名称 字段:rel_route_assit_station.routeName
     *
     * @return rel_route_assit_station.routeName, 线路名称
     */
    public String getRoutename() {
        return routename;
    }

    /**
     * 设置 线路名称 字段:rel_route_assit_station.routeName
     *
     * @param routename the value for rel_route_assit_station.routeName, 线路名称
     */
    public void setRoutename(String routename) {
        this.routename = routename == null ? null : routename.trim();
    }

    /**
     * 获取 线路别名 字段:rel_route_assit_station.lineAlias
     *
     * @return rel_route_assit_station.lineAlias, 线路别名
     */
    public String getLinealias() {
        return linealias;
    }

    /**
     * 设置 线路别名 字段:rel_route_assit_station.lineAlias
     *
     * @param linealias the value for rel_route_assit_station.lineAlias, 线路别名
     */
    public void setLinealias(String linealias) {
        this.linealias = linealias == null ? null : linealias.trim();
    }

    /**
     * 获取 方向0：上行 1：下行 字段:rel_route_assit_station.direction
     *
     * @return rel_route_assit_station.direction, 方向0：上行 1：下行
     */
    public String getDirection() {
        return direction;
    }

    /**
     * 设置 方向0：上行 1：下行 字段:rel_route_assit_station.direction
     *
     * @param direction the value for rel_route_assit_station.direction, 方向0：上行 1：下行
     */
    public void setDirection(String direction) {
        this.direction = direction == null ? null : direction.trim();
    }

    /**
     * 获取 创建时间 字段:rel_route_assit_station.createTime
     *
     * @return rel_route_assit_station.createTime, 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置 创建时间 字段:rel_route_assit_station.createTime
     *
     * @param createtime the value for rel_route_assit_station.createTime, 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取 标记0：原先存在 1：手动添加 字段:rel_route_assit_station.flag
     *
     * @return rel_route_assit_station.flag, 标记0：原先存在 1：手动添加
     */
    public String getFlag() {
        return flag;
    }

    /**
     * 设置 标记0：原先存在 1：手动添加 字段:rel_route_assit_station.flag
     *
     * @param flag the value for rel_route_assit_station.flag, 标记0：原先存在 1：手动添加
     */
    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    /**
     * 获取 起始点经度 字段:rel_route_assit_station.startLongitude
     *
     * @return rel_route_assit_station.startLongitude, 起始点经度
     */
    public BigDecimal getStartlongitude() {
        return startlongitude;
    }

    /**
     * 设置 起始点经度 字段:rel_route_assit_station.startLongitude
     *
     * @param startlongitude the value for rel_route_assit_station.startLongitude, 起始点经度
     */
    public void setStartlongitude(BigDecimal startlongitude) {
        this.startlongitude = startlongitude;
    }

    /**
     * 获取 起始点纬度 字段:rel_route_assit_station.startLatitude
     *
     * @return rel_route_assit_station.startLatitude, 起始点纬度
     */
    public BigDecimal getStartlatitude() {
        return startlatitude;
    }

    /**
     * 设置 起始点纬度 字段:rel_route_assit_station.startLatitude
     *
     * @param startlatitude the value for rel_route_assit_station.startLatitude, 起始点纬度
     */
    public void setStartlatitude(BigDecimal startlatitude) {
        this.startlatitude = startlatitude;
    }

    /**
     * 获取 终点经度 字段:rel_route_assit_station.endLongitude
     *
     * @return rel_route_assit_station.endLongitude, 终点经度
     */
    public BigDecimal getEndlongitude() {
        return endlongitude;
    }

    /**
     * 设置 终点经度 字段:rel_route_assit_station.endLongitude
     *
     * @param endlongitude the value for rel_route_assit_station.endLongitude, 终点经度
     */
    public void setEndlongitude(BigDecimal endlongitude) {
        this.endlongitude = endlongitude;
    }

    /**
     * 获取 终点纬度 字段:rel_route_assit_station.endLatitude
     *
     * @return rel_route_assit_station.endLatitude, 终点纬度
     */
    public BigDecimal getEndlatitude() {
        return endlatitude;
    }

    /**
     * 设置 终点纬度 字段:rel_route_assit_station.endLatitude
     *
     * @param endlatitude the value for rel_route_assit_station.endLatitude, 终点纬度
     */
    public void setEndlatitude(BigDecimal endlatitude) {
        this.endlatitude = endlatitude;
    }

    /**
     * 获取 城市编码 字段:rel_route_assit_station.cityCode
     *
     * @return rel_route_assit_station.cityCode, 城市编码
     */
    public String getCitycode() {
        return citycode;
    }

    /**
     * 设置 城市编码 字段:rel_route_assit_station.cityCode
     *
     * @param citycode the value for rel_route_assit_station.cityCode, 城市编码
     */
    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }
}