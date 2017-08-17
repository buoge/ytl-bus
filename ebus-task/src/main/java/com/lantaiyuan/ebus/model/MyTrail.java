package com.lantaiyuan.ebus.model;

import java.math.BigDecimal;
import java.util.Date;

import org.lanqiao.ssm.common.model.Model;

/**
 * 我的行程
 * MyTrail
 * 数据库表：my_trail
 */
public class MyTrail extends Model{

    /** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = -4259246993508382622L;

	/**
     * 自增主键
     * 表字段 : my_trail.id
     */
    private Integer id;

    /**
     * 线路ID
     * 表字段 : my_trail.routeId
     */
    private String routeid;

    /**
     * 线路方向
     * 表字段 : my_trail.direction
     */
    private Integer direction;

    /**
     * 车辆编号
     * 表字段 : my_trail.vehicleId
     */
    private String vehicleid;

    /**
     * 车牌号
     * 表字段 : my_trail.busPlateNumber
     */
    private String busplatenumber;

    /**
     * 司机编号
     * 表字段 : my_trail.driverNumber
     */
    private String drivernumber;

    /**
     * 司机名称
     * 表字段 : my_trail.driverName
     */
    private String drivername;

    /**
     * 用户id
     * 表字段 : my_trail.userId
     */
    private Integer userid;

    /**
     * 上车站点id
     * 表字段 : my_trail.startStationId
     */
    private Integer startstationid;

    /**
     * 上车站经度
     * 表字段 : my_trail.startLongitude
     */
    private BigDecimal startlongitude;

    /**
     * 上车站纬度
     * 表字段 : my_trail.startLatitude
     */
    private BigDecimal startlatitude;

    /**
     * 开始时间
     * 表字段 : my_trail.startTime
     */
    private Date starttime;

    /**
     * 下车站点id
     * 表字段 : my_trail.endStationId
     */
    private Integer endstationid;

    /**
     * 下车站经度
     * 表字段 : my_trail.endLongitude
     */
    private BigDecimal endlongitude;

    /**
     * 下车站纬度
     * 表字段 : my_trail.endLatitude
     */
    private BigDecimal endlatitude;

    /**
     * 结束时间
     * 表字段 : my_trail.endTime
     */
    private Date endtime;

    /**
     * 创建时间
     * 表字段 : my_trail.createTime
     */
    private Date createtime;

    /**
     * 城市编码
     * 表字段 : my_trail.cityCode
     */
    private String citycode;

    /**
     * 总行程（km）
     * 表字段 : my_trail.trailDistance
     */
    private Double traildistance;

    /**
     * 获取 自增主键 字段:my_trail.id
     *
     * @return my_trail.id, 自增主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 自增主键 字段:my_trail.id
     *
     * @param id the value for my_trail.id, 自增主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 线路ID 字段:my_trail.routeId
     *
     * @return my_trail.routeId, 线路ID
     */
    public String getRouteid() {
        return routeid;
    }

    /**
     * 设置 线路ID 字段:my_trail.routeId
     *
     * @param routeid the value for my_trail.routeId, 线路ID
     */
    public void setRouteid(String routeid) {
        this.routeid = routeid == null ? null : routeid.trim();
    }

    /**
     * 获取 线路方向 字段:my_trail.direction
     *
     * @return my_trail.direction, 线路方向
     */
    public Integer getDirection() {
        return direction;
    }

    /**
     * 设置 线路方向 字段:my_trail.direction
     *
     * @param direction the value for my_trail.direction, 线路方向
     */
    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    /**
     * 获取 车辆编号 字段:my_trail.vehicleId
     *
     * @return my_trail.vehicleId, 车辆编号
     */
    public String getVehicleid() {
        return vehicleid;
    }

    /**
     * 设置 车辆编号 字段:my_trail.vehicleId
     *
     * @param vehicleid the value for my_trail.vehicleId, 车辆编号
     */
    public void setVehicleid(String vehicleid) {
        this.vehicleid = vehicleid == null ? null : vehicleid.trim();
    }

    /**
     * 获取 车牌号 字段:my_trail.busPlateNumber
     *
     * @return my_trail.busPlateNumber, 车牌号
     */
    public String getBusplatenumber() {
        return busplatenumber;
    }

    /**
     * 设置 车牌号 字段:my_trail.busPlateNumber
     *
     * @param busplatenumber the value for my_trail.busPlateNumber, 车牌号
     */
    public void setBusplatenumber(String busplatenumber) {
        this.busplatenumber = busplatenumber == null ? null : busplatenumber.trim();
    }

    /**
     * 获取 司机编号 字段:my_trail.driverNumber
     *
     * @return my_trail.driverNumber, 司机编号
     */
    public String getDrivernumber() {
        return drivernumber;
    }

    /**
     * 设置 司机编号 字段:my_trail.driverNumber
     *
     * @param drivernumber the value for my_trail.driverNumber, 司机编号
     */
    public void setDrivernumber(String drivernumber) {
        this.drivernumber = drivernumber == null ? null : drivernumber.trim();
    }

    /**
     * 获取 司机名称 字段:my_trail.driverName
     *
     * @return my_trail.driverName, 司机名称
     */
    public String getDrivername() {
        return drivername;
    }

    /**
     * 设置 司机名称 字段:my_trail.driverName
     *
     * @param drivername the value for my_trail.driverName, 司机名称
     */
    public void setDrivername(String drivername) {
        this.drivername = drivername == null ? null : drivername.trim();
    }

    /**
     * 获取 用户id 字段:my_trail.userId
     *
     * @return my_trail.userId, 用户id
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 设置 用户id 字段:my_trail.userId
     *
     * @param userid the value for my_trail.userId, 用户id
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 获取 上车站点id 字段:my_trail.startStationId
     *
     * @return my_trail.startStationId, 上车站点id
     */
    public Integer getStartstationid() {
        return startstationid;
    }

    /**
     * 设置 上车站点id 字段:my_trail.startStationId
     *
     * @param startstationid the value for my_trail.startStationId, 上车站点id
     */
    public void setStartstationid(Integer startstationid) {
        this.startstationid = startstationid;
    }

    /**
     * 获取 上车站经度 字段:my_trail.startLongitude
     *
     * @return my_trail.startLongitude, 上车站经度
     */
    public BigDecimal getStartlongitude() {
        return startlongitude;
    }

    /**
     * 设置 上车站经度 字段:my_trail.startLongitude
     *
     * @param startlongitude the value for my_trail.startLongitude, 上车站经度
     */
    public void setStartlongitude(BigDecimal startlongitude) {
        this.startlongitude = startlongitude;
    }

    /**
     * 获取 上车站纬度 字段:my_trail.startLatitude
     *
     * @return my_trail.startLatitude, 上车站纬度
     */
    public BigDecimal getStartlatitude() {
        return startlatitude;
    }

    /**
     * 设置 上车站纬度 字段:my_trail.startLatitude
     *
     * @param startlatitude the value for my_trail.startLatitude, 上车站纬度
     */
    public void setStartlatitude(BigDecimal startlatitude) {
        this.startlatitude = startlatitude;
    }

    /**
     * 获取 开始时间 字段:my_trail.startTime
     *
     * @return my_trail.startTime, 开始时间
     */
    public Date getStarttime() {
        return starttime;
    }

    /**
     * 设置 开始时间 字段:my_trail.startTime
     *
     * @param starttime the value for my_trail.startTime, 开始时间
     */
    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    /**
     * 获取 下车站点id 字段:my_trail.endStationId
     *
     * @return my_trail.endStationId, 下车站点id
     */
    public Integer getEndstationid() {
        return endstationid;
    }

    /**
     * 设置 下车站点id 字段:my_trail.endStationId
     *
     * @param endstationid the value for my_trail.endStationId, 下车站点id
     */
    public void setEndstationid(Integer endstationid) {
        this.endstationid = endstationid;
    }

    /**
     * 获取 下车站经度 字段:my_trail.endLongitude
     *
     * @return my_trail.endLongitude, 下车站经度
     */
    public BigDecimal getEndlongitude() {
        return endlongitude;
    }

    /**
     * 设置 下车站经度 字段:my_trail.endLongitude
     *
     * @param endlongitude the value for my_trail.endLongitude, 下车站经度
     */
    public void setEndlongitude(BigDecimal endlongitude) {
        this.endlongitude = endlongitude;
    }

    /**
     * 获取 下车站纬度 字段:my_trail.endLatitude
     *
     * @return my_trail.endLatitude, 下车站纬度
     */
    public BigDecimal getEndlatitude() {
        return endlatitude;
    }

    /**
     * 设置 下车站纬度 字段:my_trail.endLatitude
     *
     * @param endlatitude the value for my_trail.endLatitude, 下车站纬度
     */
    public void setEndlatitude(BigDecimal endlatitude) {
        this.endlatitude = endlatitude;
    }

    /**
     * 获取 结束时间 字段:my_trail.endTime
     *
     * @return my_trail.endTime, 结束时间
     */
    public Date getEndtime() {
        return endtime;
    }

    /**
     * 设置 结束时间 字段:my_trail.endTime
     *
     * @param endtime the value for my_trail.endTime, 结束时间
     */
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    /**
     * 获取 创建时间 字段:my_trail.createTime
     *
     * @return my_trail.createTime, 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置 创建时间 字段:my_trail.createTime
     *
     * @param createtime the value for my_trail.createTime, 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取 城市编码 字段:my_trail.cityCode
     *
     * @return my_trail.cityCode, 城市编码
     */
    public String getCitycode() {
        return citycode;
    }

    /**
     * 设置 城市编码 字段:my_trail.cityCode
     *
     * @param citycode the value for my_trail.cityCode, 城市编码
     */
    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }

    /**
     * 获取 总行程（km） 字段:my_trail.trailDistance
     *
     * @return my_trail.trailDistance, 总行程（km）
     */
    public Double getTraildistance() {
        return traildistance;
    }

    /**
     * 设置 总行程（km） 字段:my_trail.trailDistance
     *
     * @param traildistance the value for my_trail.trailDistance, 总行程（km）
     */
    public void setTraildistance(Double traildistance) {
        this.traildistance = traildistance;
    }
}