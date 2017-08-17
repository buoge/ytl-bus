package com.lantaiyuan.ebus.model;

import java.util.Date;
import org.lanqiao.ssm.common.model.Model;

/**
 * 线路与车辆关系表
 * RelRouteBus
 * 数据库表：rel_route_bus
 */
public class RelRouteBus extends Model {

	private static final long serialVersionUID = 3439316215809170743L;

	/**
     * 自增主键id
     * 表字段 : rel_route_bus.id
     */
    private Integer id;

    /**
	
	  * 创建一个新的实例 RelRouteBus. 
	  * <p>Title: </p>
	  * <p>Description: </p>
	  * @param routeno
	  * @param vehicleid
	  * @param citycode
	  */
	public RelRouteBus(String routeno, int vehicleid, String citycode) {
		super();
		this.routeno = routeno;
		this.vehicleid = vehicleid;
		this.citycode = citycode;
	}
	
	public RelRouteBus() {
		super();
	}

	/**
     * 线路id
     * 表字段 : rel_route_bus.routeNo
     */
    private String routeno;

    /**
     * 执行线路车辆id
     * 表字段 : rel_route_bus.vehicleId
     */
    private Integer vehicleid;

    /**
     * 创建时间
     * 表字段 : rel_route_bus.createTime
     */
    private Date createtime;

    /**
     * 城市编码
     * 表字段 : rel_route_bus.cityCode
     */
    private String citycode;

    /**
     * 获取 自增主键id 字段:rel_route_bus.id
     *
     * @return rel_route_bus.id, 自增主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 自增主键id 字段:rel_route_bus.id
     *
     * @param id the value for rel_route_bus.id, 自增主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 线路id 字段:rel_route_bus.routeNo
     *
     * @return rel_route_bus.routeNo, 线路id
     */
    public String getRouteno() {
        return routeno;
    }

    /**
     * 设置 线路id 字段:rel_route_bus.routeNo
     *
     * @param routeno the value for rel_route_bus.routeNo, 线路id
     */
    public void setRouteno(String routeno) {
        this.routeno = routeno == null ? null : routeno.trim();
    }

    /**
     * 获取 执行线路车辆id 字段:rel_route_bus.vehicleId
     *
     * @return rel_route_bus.vehicleId, 执行线路车辆id
     */
    public Integer getVehicleid() {
        return vehicleid;
    }

    /**
     * 设置 执行线路车辆id 字段:rel_route_bus.vehicleId
     *
     * @param vehicleid the value for rel_route_bus.vehicleId, 执行线路车辆id
     */
    public void setVehicleid(Integer vehicleid) {
        this.vehicleid = vehicleid;
    }

    /**
     * 获取 创建时间 字段:rel_route_bus.createTime
     *
     * @return rel_route_bus.createTime, 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置 创建时间 字段:rel_route_bus.createTime
     *
     * @param createtime the value for rel_route_bus.createTime, 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取 城市编码 字段:rel_route_bus.cityCode
     *
     * @return rel_route_bus.cityCode, 城市编码
     */
    public String getCitycode() {
        return citycode;
    }

    /**
     * 设置 城市编码 字段:rel_route_bus.cityCode
     *
     * @param citycode the value for rel_route_bus.cityCode, 城市编码
     */
    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }
}