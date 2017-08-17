package com.lantaiyuan.ebus.custom.model.carpool;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 拼车信息model
 * @author zhenghanbin
 *	
 */
public class CarpoolMatchAndRouteResultModel {
	 /**
     * 自增主键
     * 表字段 : carpool_match.id
     */
    private Long id;

    /**
     * 撮合id
     * 表字段 : carpool_match.match_id
     */
    private String matchId;

    /**
     * 创建时间
     * 表字段 : carpool_match.gmt_create
     */
    private Date gmtCreate;

    /**
     * 最后修改时间
     * 表字段 : carpool_match.gmt_modified
     */
    private Date gmtModified;

    /**
     * 拼车状态(0:处理中，1: 拼车中, 2: 拼车成功, 3: 已发车, 4: 用户已上车, 5: 用户到达下车点，9: 车到终点, 10: 用户已评价，-1: 拼车失败)
     * 表字段 : carpool_match.match_status
     */
    private Byte matchStatus;

    /**
     * 已拼车人数
     * 表字段 : carpool_match.match_persons
     */
    private Byte matchPersons;

    /**
     * 需要人数
     * 表字段 : carpool_match.required_persons
     */
    private Byte requiredPersons;

    /**
     * 实际发车车型座位数
     * 表字段 : carpool_match.depart_bus_seats
     */
    private Byte departBusSeats;

    /**
     * 撮合次数
     * 表字段 : carpool_match.match_times
     */
    private Integer matchTimes;

    /**
     * 发车时间
     * 表字段 : carpool_match.depart_time
     */
    private Date departTime;

    /**
     * 动态拼车信息，多条用;隔开
     * 表字段 : carpool_match.dynamic_msg
     */
    private String dynamicMsg;

    /**
     * 拼车预计时间，只有在拼车中时才需要，拼车完成后不再关注，单位：秒
     * 表字段 : carpool_match.match_expect_time
     */
    private Integer matchExpectTime;

    /**
     * 撮合生成的临时线路id
     * 表字段 : carpool_match.carpool_route_id
     */
    private String carpoolRouteId;

    /**
     * 城市编码
     * 表字段 : carpool_match.city_code
     */
    private String cityCode;

    /**
     * 车辆编号
     * 表字段 : carpool_match.vehicle_id
     */
    private String vehicleId;

    /**
     * 车牌号码
     * 表字段 : carpool_match.bus_plate_number
     */
    private String busPlateNumber;

    /**
     * 车型
     * 表字段 : carpool_match.depart_bus_type
     */
    private Integer departBusType;

    /**
     * 司机编号
     * 表字段 : carpool_match.driver_id
     */
    private String driverId;

    /**
     * 司机姓名
     * 表字段 : carpool_match.driver_name
     */
    private String driverName;

    /**
     * 司机手机号码
     * 表字段 : carpool_match.driver_phone_no
     */
    private String driverPhoneNo;

    /**
     * 司机评价等级
     * 表字段 : carpool_match.driver_judgement
     */
    private String driverJudgement;
    /**
     * 起点站名称（临时字段，用于移动端展示用）
     */
    private String startStationName;
    /**
     * 终点站名称（临时字段，用于移动端展示用）
     */
    private String endStationName;
    
    /**
     * 
     * 表字段 : carpool_match.field1
     */
    private String field1;

    /**
     * 
     * 表字段 : carpool_match.field2
     */
    private String field2;

    /**
     * 
     * 表字段 : carpool_match.field3
     */
    private String field3;
    
    /**
     * 线路名称
     * 表字段：carpool_route.carpool_route_name
     */
    private String carpoolRouteName;
    
    /**
     * 票价(单位：元)
     * 表字段：carpool_route.price
     */
    private BigDecimal price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatchId() {
		return matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public Byte getMatchStatus() {
		return matchStatus;
	}

	public void setMatchStatus(Byte matchStatus) {
		this.matchStatus = matchStatus;
	}

	public Byte getMatchPersons() {
		return matchPersons;
	}

	public void setMatchPersons(Byte matchPersons) {
		this.matchPersons = matchPersons;
	}

	public Byte getRequiredPersons() {
		return requiredPersons;
	}

	public void setRequiredPersons(Byte requiredPersons) {
		this.requiredPersons = requiredPersons;
	}

	public Byte getDepartBusSeats() {
		return departBusSeats;
	}

	public void setDepartBusSeats(Byte departBusSeats) {
		this.departBusSeats = departBusSeats;
	}

	public Integer getMatchTimes() {
		return matchTimes;
	}

	public void setMatchTimes(Integer matchTimes) {
		this.matchTimes = matchTimes;
	}

	public Date getDepartTime() {
		return departTime;
	}

	public void setDepartTime(Date departTime) {
		this.departTime = departTime;
	}

	public String getDynamicMsg() {
		return dynamicMsg;
	}

	public void setDynamicMsg(String dynamicMsg) {
		this.dynamicMsg = dynamicMsg;
	}

	public Integer getMatchExpectTime() {
		return matchExpectTime;
	}

	public void setMatchExpectTime(Integer matchExpectTime) {
		this.matchExpectTime = matchExpectTime;
	}

	public String getCarpoolRouteId() {
		return carpoolRouteId;
	}

	public void setCarpoolRouteId(String carpoolRouteId) {
		this.carpoolRouteId = carpoolRouteId;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getBusPlateNumber() {
		return busPlateNumber;
	}

	public void setBusPlateNumber(String busPlateNumber) {
		this.busPlateNumber = busPlateNumber;
	}

	public Integer getDepartBusType() {
		return departBusType;
	}

	public void setDepartBusType(Integer departBusType) {
		this.departBusType = departBusType;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverPhoneNo() {
		return driverPhoneNo;
	}

	public void setDriverPhoneNo(String driverPhoneNo) {
		this.driverPhoneNo = driverPhoneNo;
	}

	public String getDriverJudgement() {
		return driverJudgement;
	}

	public void setDriverJudgement(String driverJudgement) {
		this.driverJudgement = driverJudgement;
	}

	public String getStartStationName() {
		return startStationName;
	}

	public void setStartStationName(String startStationName) {
		this.startStationName = startStationName;
	}

	public String getEndStationName() {
		return endStationName;
	}

	public void setEndStationName(String endStationName) {
		this.endStationName = endStationName;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

	public String getCarpoolRouteName() {
		return carpoolRouteName;
	}

	public void setCarpoolRouteName(String carpoolRouteName) {
		this.carpoolRouteName = carpoolRouteName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}  
	
}
