package com.lantaiyuan.ebus.custom.model;

import java.util.Date;

import org.lanqiao.ssm.common.model.Model;

/**
 * 线路站点关系表
 * RelRouteStation
 * 数据库表：rel_route_station
 */
public class RelRouteStation extends Model{

 
	private static final long serialVersionUID = 6251512614930117152L;

	/**
     * 自增主键id
     * 表字段 : rel_route_station.id
     */
    private Integer id;

    /**
     * 线路id
     * 表字段 : rel_route_station.routeId
     */
    private String routeid;

    /**
     * 站点id
     * 表字段 : rel_route_station.stationId
     */
    private String stationid;

    /**
     * 先前站点id
     * 表字段 : rel_route_station.previousStationId
     */
    private Integer previousstationid;

    /**
     * 下一站点id
     * 表字段 : rel_route_station.nextStationId
     */
    private Integer nextstationid;

    /**
     * 在该线路中是几站
     * 表字段 : rel_route_station.stationNo
     */
    private Integer stationno;

    /**
     * 创建时间
     * 表字段 : rel_route_station.createTime
     */
    private Date createtime;

    /**
     * 城市编码
     * 表字段 : rel_route_station.cityCode
     */
    private String citycode;

    /**
     * 线路方向 0-上行 1-下行
     * 表字段 : rel_route_station.direction
     */
    private Integer direction;

    /**
     * 获取 自增主键id 字段:rel_route_station.id
     *
     * @return rel_route_station.id, 自增主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 自增主键id 字段:rel_route_station.id
     *
     * @param id the value for rel_route_station.id, 自增主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 线路id 字段:rel_route_station.routeId
     *
     * @return rel_route_station.routeId, 线路id
     */
    public String getRouteid() {
        return routeid;
    }

    /**
     * 设置 线路id 字段:rel_route_station.routeId
     *
     * @param routeid the value for rel_route_station.routeId, 线路id
     */
    public void setRouteid(String routeid) {
        this.routeid = routeid == null ? null : routeid.trim();
    }

    /**
     * 获取 站点id 字段:rel_route_station.stationId
     *
     * @return rel_route_station.stationId, 站点id
     */
    public String getStationid() {
        return stationid;
    }

    /**
     * 设置 站点id 字段:rel_route_station.stationId
     *
     * @param stationid the value for rel_route_station.stationId, 站点id
     */
    public void setStationid(String stationid) {
        this.stationid = stationid == null ? null : stationid.trim();
    }

    /**
     * 获取 先前站点id 字段:rel_route_station.previousStationId
     *
     * @return rel_route_station.previousStationId, 先前站点id
     */
    public Integer getPreviousstationid() {
        return previousstationid;
    }

    /**
     * 设置 先前站点id 字段:rel_route_station.previousStationId
     *
     * @param previousstationid the value for rel_route_station.previousStationId, 先前站点id
     */
    public void setPreviousstationid(Integer previousstationid) {
        this.previousstationid = previousstationid;
    }

    /**
     * 获取 下一站点id 字段:rel_route_station.nextStationId
     *
     * @return rel_route_station.nextStationId, 下一站点id
     */
    public Integer getNextstationid() {
        return nextstationid;
    }

    /**
     * 设置 下一站点id 字段:rel_route_station.nextStationId
     *
     * @param nextstationid the value for rel_route_station.nextStationId, 下一站点id
     */
    public void setNextstationid(Integer nextstationid) {
        this.nextstationid = nextstationid;
    }

    /**
     * 获取 在该线路中是几站 字段:rel_route_station.stationNo
     *
     * @return rel_route_station.stationNo, 在该线路中是几站
     */
    public Integer getStationno() {
        return stationno;
    }

    /**
     * 设置 在该线路中是几站 字段:rel_route_station.stationNo
     *
     * @param stationno the value for rel_route_station.stationNo, 在该线路中是几站
     */
    public void setStationno(Integer stationno) {
        this.stationno = stationno;
    }

    /**
     * 获取 创建时间 字段:rel_route_station.createTime
     *
     * @return rel_route_station.createTime, 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置 创建时间 字段:rel_route_station.createTime
     *
     * @param createtime the value for rel_route_station.createTime, 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取 城市编码 字段:rel_route_station.cityCode
     *
     * @return rel_route_station.cityCode, 城市编码
     */
    public String getCitycode() {
        return citycode;
    }

    /**
     * 设置 城市编码 字段:rel_route_station.cityCode
     *
     * @param citycode the value for rel_route_station.cityCode, 城市编码
     */
    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }

    /**
     * 获取 线路方向 0-上行 1-下行 字段:rel_route_station.direction
     *
     * @return rel_route_station.direction, 线路方向 0-上行 1-下行
     */
    public Integer getDirection() {
        return direction;
    }

    /**
     * 设置 线路方向 0-上行 1-下行 字段:rel_route_station.direction
     *
     * @param direction the value for rel_route_station.direction, 线路方向 0-上行 1-下行
     */
    public void setDirection(Integer direction) {
        this.direction = direction;
    }
}