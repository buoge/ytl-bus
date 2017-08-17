package com.lantaiyuan.ebus.custom.model.carpool;

import java.math.BigDecimal;
import java.util.Date;

import org.lanqiao.ssm.common.model.Model;

/**
 * 动态撮合表(拼车业务)
 * CarpoolMatch
 * 数据库表：carpool_match
 * @author yangyang
 * 2017-06-13
 */
public class CarpoolMatchResult extends Model{

	private static final long serialVersionUID = 1926789478672879417L;

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
     * 状态(参考枚举:CarPoolMatchStatusEnum)
     * 表字段 : carpool_match.status
     */
    private Byte status;

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
     * 表字段 : carpool_match.real_depart_seats
     */
    private Byte realDepartSeats;

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
     * 表字段 : carpool_match.bus_number
     */
    private String busNumber;

    /**
     * 车型
     * 表字段 : carpool_match.bus_type
     */
    private Integer busType;

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
    
    private String driverPhoneNo;
    
    private String driverJudgement;
    /**
     * 
     * 表字段 : carpool_match.field1
     */
    private String field1;

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
    private BigDecimal price;

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
     * 线路状态(1:临时 2:已开通)
     * 表字段 : carpool_route.status
     */
    private Boolean routeStatus;

    /**
     * 发车次数
     * 表字段 : carpool_route.depart_times
     */
    private Integer departTimes;


    /**
     * 到达时间
     * 表字段 : carpool_route.arrive_time
     */
    private Date arriveTime;

    /**
     * 获取 自增主键 字段:carpool_match.id
     *
     * @return carpool_match.id, 自增主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 自增主键 字段:carpool_match.id
     *
     * @param id the value for carpool_match.id, 自增主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 撮合id 字段:carpool_match.match_id
     *
     * @return carpool_match.match_id, 撮合id
     */
    public String getMatchId() {
        return matchId;
    }

    /**
     * 设置 撮合id 字段:carpool_match.match_id
     *
     * @param matchId the value for carpool_match.match_id, 撮合id
     */
    public void setMatchId(String matchId) {
        this.matchId = matchId == null ? null : matchId.trim();
    }

    /**
     * 获取 创建时间 字段:carpool_match.gmt_create
     *
     * @return carpool_match.gmt_create, 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置 创建时间 字段:carpool_match.gmt_create
     *
     * @param gmtCreate the value for carpool_match.gmt_create, 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取 最后修改时间 字段:carpool_match.gmt_modified
     *
     * @return carpool_match.gmt_modified, 最后修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置 最后修改时间 字段:carpool_match.gmt_modified
     *
     * @param gmtModified the value for carpool_match.gmt_modified, 最后修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取 状态(参考枚举:CarPoolMatchStatusEnum) 字段:carpool_match.status
     *
     * @return carpool_match.status, 状态(参考枚举:CarPoolMatchStatusEnum)
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置 状态(参考枚举:CarPoolMatchStatusEnum) 字段:carpool_match.status
     *
     * @param status the value for carpool_match.status, 状态(参考枚举:CarPoolMatchStatusEnum)
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取 已拼车人数 字段:carpool_match.match_persons
     *
     * @return carpool_match.match_persons, 已拼车人数
     */
    public Byte getMatchPersons() {
        return matchPersons;
    }

    /**
     * 设置 已拼车人数 字段:carpool_match.match_persons
     *
     * @param matchPersons the value for carpool_match.match_persons, 已拼车人数
     */
    public void setMatchPersons(Byte matchPersons) {
        this.matchPersons = matchPersons;
    }

    /**
     * 获取 需要人数 字段:carpool_match.required_persons
     *
     * @return carpool_match.required_persons, 需要人数
     */
    public Byte getRequiredPersons() {
        return requiredPersons;
    }

    /**
     * 设置 需要人数 字段:carpool_match.required_persons
     *
     * @param requiredPersons the value for carpool_match.required_persons, 需要人数
     */
    public void setRequiredPersons(Byte requiredPersons) {
        this.requiredPersons = requiredPersons;
    }

    /**
     * 获取 实际发车车型座位数 字段:carpool_match.real_depart_seats
     *
     * @return carpool_match.real_depart_seats, 实际发车车型座位数
     */
    public Byte getRealDepartSeats() {
        return realDepartSeats;
    }

    /**
     * 设置 实际发车车型座位数 字段:carpool_match.real_depart_seats
     *
     * @param realDepartSeats the value for carpool_match.real_depart_seats, 实际发车车型座位数
     */
    public void setRealDepartSeats(Byte realDepartSeats) {
        this.realDepartSeats = realDepartSeats;
    }

    /**
     * 获取 撮合次数 字段:carpool_match.match_times
     *
     * @return carpool_match.match_times, 撮合次数
     */
    public Integer getMatchTimes() {
        return matchTimes;
    }

    /**
     * 设置 撮合次数 字段:carpool_match.match_times
     *
     * @param matchTimes the value for carpool_match.match_times, 撮合次数
     */
    public void setMatchTimes(Integer matchTimes) {
        this.matchTimes = matchTimes;
    }

    /**
     * 获取 发车时间 字段:carpool_match.depart_time
     *
     * @return carpool_match.depart_time, 发车时间
     */
    public Date getDepartTime() {
        return departTime;
    }

    /**
     * 设置 发车时间 字段:carpool_match.depart_time
     *
     * @param departTime the value for carpool_match.depart_time, 发车时间
     */
    public void setDepartTime(Date departTime) {
        this.departTime = departTime;
    }

    /**
     * 获取 动态拼车信息，多条用;隔开 字段:carpool_match.dynamic_msg
     *
     * @return carpool_match.dynamic_msg, 动态拼车信息，多条用;隔开
     */
    public String getDynamicMsg() {
        return dynamicMsg;
    }

    /**
     * 设置 动态拼车信息，多条用;隔开 字段:carpool_match.dynamic_msg
     *
     * @param dynamicMsg the value for carpool_match.dynamic_msg, 动态拼车信息，多条用;隔开
     */
    public void setDynamicMsg(String dynamicMsg) {
        this.dynamicMsg = dynamicMsg == null ? null : dynamicMsg.trim();
    }

    /**
     * 获取 拼车预计时间，只有在拼车中时才需要，拼车完成后不再关注，单位：秒 字段:carpool_match.match_expect_time
     *
     * @return carpool_match.match_expect_time, 拼车预计时间，只有在拼车中时才需要，拼车完成后不再关注，单位：秒
     */
    public Integer getMatchExpectTime() {
        return matchExpectTime;
    }

    /**
     * 设置 拼车预计时间，只有在拼车中时才需要，拼车完成后不再关注，单位：秒 字段:carpool_match.match_expect_time
     *
     * @param matchExpectTime the value for carpool_match.match_expect_time, 拼车预计时间，只有在拼车中时才需要，拼车完成后不再关注，单位：秒
     */
    public void setMatchExpectTime(Integer matchExpectTime) {
        this.matchExpectTime = matchExpectTime;
    }

    /**
     * 获取 撮合生成的临时线路id 字段:carpool_match.carpool_route_id
     *
     * @return carpool_match.carpool_route_id, 撮合生成的临时线路id
     */
    public String getCarpoolRouteId() {
        return carpoolRouteId;
    }

    /**
     * 设置 撮合生成的临时线路id 字段:carpool_match.carpool_route_id
     *
     * @param carpoolRouteId the value for carpool_match.carpool_route_id, 撮合生成的临时线路id
     */
    public void setCarpoolRouteId(String carpoolRouteId) {
        this.carpoolRouteId = carpoolRouteId == null ? null : carpoolRouteId.trim();
    }

    /**
     * 获取 城市编码 字段:carpool_match.city_code
     *
     * @return carpool_match.city_code, 城市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置 城市编码 字段:carpool_match.city_code
     *
     * @param cityCode the value for carpool_match.city_code, 城市编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * 获取 车辆编号 字段:carpool_match.vehicle_id
     *
     * @return carpool_match.vehicle_id, 车辆编号
     */
    public String getVehicleId() {
        return vehicleId;
    }

    /**
     * 设置 车辆编号 字段:carpool_match.vehicle_id
     *
     * @param vehicleId the value for carpool_match.vehicle_id, 车辆编号
     */
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId == null ? null : vehicleId.trim();
    }

    /**
     * 获取 车牌号码 字段:carpool_match.bus_number
     *
     * @return carpool_match.bus_number, 车牌号码
     */
    public String getBusNumber() {
        return busNumber;
    }

    /**
     * 设置 车牌号码 字段:carpool_match.bus_number
     *
     * @param busNumber the value for carpool_match.bus_number, 车牌号码
     */
    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber == null ? null : busNumber.trim();
    }

    /**
     * 获取 车型 字段:carpool_match.bus_type
     *
     * @return carpool_match.bus_type, 车型
     */
    public Integer getBusType() {
        return busType;
    }

    /**
     * 设置 车型 字段:carpool_match.bus_type
     *
     * @param busType the value for carpool_match.bus_type, 车型
     */
    public void setBusType(Integer busType) {
        this.busType = busType;
    }

    /**
     * 获取 司机编号 字段:carpool_match.driver_id
     *
     * @return carpool_match.driver_id, 司机编号
     */
    public String getDriverId() {
        return driverId;
    }

    /**
     * 设置 司机编号 字段:carpool_match.driver_id
     *
     * @param driverId the value for carpool_match.driver_id, 司机编号
     */
    public void setDriverId(String driverId) {
        this.driverId = driverId == null ? null : driverId.trim();
    }

    /**
     * 获取 司机姓名 字段:carpool_match.driver_name
     *
     * @return carpool_match.driver_name, 司机姓名
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * 设置 司机姓名 字段:carpool_match.driver_name
     *
     * @param driverName the value for carpool_match.driver_name, 司机姓名
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName == null ? null : driverName.trim();
    }

    /**
     * 获取  字段:carpool_match.field1
     *
     * @return carpool_match.field1, 
     */
    public String getField1() {
        return field1;
    }

    /**
     * 设置  字段:carpool_match.field1
     *
     * @param field1 the value for carpool_match.field1, 
     */
    public void setField1(String field1) {
        this.field1 = field1 == null ? null : field1.trim();
    }

    /**
     * 获取  字段:carpool_match.field2
     *
     * @return carpool_match.field2, 
     */
    public String getField2() {
        return field2;
    }

    /**
     * 设置  字段:carpool_match.field2
     *
     * @param field2 the value for carpool_match.field2, 
     */
    public void setField2(String field2) {
        this.field2 = field2 == null ? null : field2.trim();
    }

    /**
     * 获取  字段:carpool_match.field3
     *
     * @return carpool_match.field3, 
     */
    public String getField3() {
        return field3;
    }

    /**
     * 设置  字段:carpool_match.field3
     *
     * @param field3 the value for carpool_match.field3, 
     */
    public void setField3(String field3) {
        this.field3 = field3 == null ? null : field3.trim();
    }

	public String getCarpoolRouteName() {
		return carpoolRouteName;
	}

	public void setCarpoolRouteName(String carpoolRouteName) {
		this.carpoolRouteName = carpoolRouteName;
	}

	public Integer getCarpoolRouteType() {
		return carpoolRouteType;
	}

	public void setCarpoolRouteType(Integer carpoolRouteType) {
		this.carpoolRouteType = carpoolRouteType;
	}

	public BigDecimal getDistance() {
		return distance;
	}

	public void setDistance(BigDecimal distance) {
		this.distance = distance;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getStartStation() {
		return startStation;
	}

	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}

	public String getEndStation() {
		return endStation;
	}

	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}

	public Boolean getRouteStatus() {
		return routeStatus;
	}

	public void setRouteStatus(Boolean routeStatus) {
		this.routeStatus = routeStatus;
	}

	public Integer getDepartTimes() {
		return departTimes;
	}

	public void setDepartTimes(Integer departTimes) {
		this.departTimes = departTimes;
	}

	public Date getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(Date arriveTime) {
		this.arriveTime = arriveTime;
	}
}