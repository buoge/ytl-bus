package com.lantaiyuan.ebus.custom.model;

import org.lanqiao.ssm.common.model.Model;

/**
 * @Title: BaseBus.java
 * @Package com.lantaiyuan.ebus.custom.model
 * @Description:
 * @author yangyang
 * @date 2016年12月21日 下午3:54:44
 * @version v1.0
 */
public class BaseBus extends Model {

	public BaseBus(String vehicleid, String citycode) {
		super();
		this.vehicleid = vehicleid;
		this.citycode = citycode;
	}

	public BaseBus() {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5188169831342308450L;

	/**
	 * 自增主键 表字段 : base_bus.id
	 */
	private Integer id;

	/**
	 * 车辆编号 表字段 : base_bus.vehicleId
	 */
	private String vehicleid;

	/**
	 * 车牌号码 表字段 : base_bus.busPlateNumber
	 */
	private String busplatenumber;

	/**
	 * 车牌号码备份 表字段 : base_bus.busPlateNumber2
	 */
	private String busplatenumber2;

	/**
	 * 车型 表字段 : base_bus.busType
	 */
	private Integer bustype;

	/**
	 * 城市编码 表字段 : base_bus.cityCode
	 */
	private String citycode;

	/**
	 * 获取 自增主键 字段:base_bus.id
	 *
	 * @return base_bus.id, 自增主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置 自增主键 字段:base_bus.id
	 *
	 * @param id
	 *            the value for base_bus.id, 自增主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取 车辆编号 字段:base_bus.vehicleId
	 *
	 * @return base_bus.vehicleId, 车辆编号
	 */
	public String getVehicleid() {
		return vehicleid;
	}

	/**
	 * 设置 车辆编号 字段:base_bus.vehicleId
	 *
	 * @param vehicleid
	 *            the value for base_bus.vehicleId, 车辆编号
	 */
	public void setVehicleid(String vehicleid) {
		this.vehicleid = vehicleid == null ? null : vehicleid.trim();
	}

	/**
	 * 获取 车牌号码 字段:base_bus.busPlateNumber
	 *
	 * @return base_bus.busPlateNumber, 车牌号码
	 */
	public String getBusplatenumber() {
		return busplatenumber;
	}

	/**
	 * 设置 车牌号码 字段:base_bus.busPlateNumber
	 *
	 * @param busplatenumber
	 *            the value for base_bus.busPlateNumber, 车牌号码
	 */
	public void setBusplatenumber(String busplatenumber) {
		this.busplatenumber = busplatenumber == null ? null : busplatenumber.trim();
	}

	/**
	 * 获取 车牌号码备份 字段:base_bus.busPlateNumber2
	 *
	 * @return base_bus.busPlateNumber2, 车牌号码备份
	 */
	public String getBusplatenumber2() {
		return busplatenumber2;
	}

	/**
	 * 设置 车牌号码备份 字段:base_bus.busPlateNumber2
	 *
	 * @param busplatenumber2
	 *            the value for base_bus.busPlateNumber2, 车牌号码备份
	 */
	public void setBusplatenumber2(String busplatenumber2) {
		this.busplatenumber2 = busplatenumber2 == null ? null : busplatenumber2.trim();
	}

	/**
	 * 获取 车型 字段:base_bus.busType
	 *
	 * @return base_bus.busType, 车型
	 */
	public Integer getBustype() {
		return bustype;
	}

	/**
	 * 设置 车型 字段:base_bus.busType
	 *
	 * @param bustype
	 *            the value for base_bus.busType, 车型
	 */
	public void setBustype(Integer bustype) {
		this.bustype = bustype;
	}

	/**
	 * 获取 城市编码 字段:base_bus.cityCode
	 *
	 * @return base_bus.cityCode, 城市编码
	 */
	public String getCitycode() {
		return citycode;
	}

	/**
	 * 设置 城市编码 字段:base_bus.cityCode
	 *
	 * @param citycode
	 *            the value for base_bus.cityCode, 城市编码
	 */
	public void setCitycode(String citycode) {
		this.citycode = citycode == null ? null : citycode.trim();
	}
}