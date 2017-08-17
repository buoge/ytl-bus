package com.lantaiyuan.ebus.custom.model;

import java.util.Date;

import org.lanqiao.ssm.common.model.Model;

/**
 * 综合评价表
 * EvaluationGeneral
 * 数据库表：base_evaluation_general
 */
public class EvaluationGeneral extends Model {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4243617154974504952L;

	/**
     * 自增主键
     * 表字段 : base_evaluation_general.id
     */
    private String id;

    /**
     * 
     * 表字段 : base_evaluation_general.user_id
     */
    private Integer userId;

    /**
     * 评价人
     * 表字段 : base_evaluation_general.user_name
     */
    private String userName;

    /**
     * 线路名称（当评价对象是站台时为空）
     * 表字段 : base_evaluation_general.route_name
     */
    private String routeName;

    /**
     * 线路方向（0-上行 1-下行 2-环线）
     * 表字段 : base_evaluation_general.direction
     */
    private Integer direction;

    /**
     * 司机
     * 表字段 : base_evaluation_general.driver
     */
    private String driver;

    /**
     * 车牌号
     * 表字段 : base_evaluation_general.bus_plate_number
     */
    private String busPlateNumber;

    /**
     * 创建时间
     * 表字段 : base_evaluation_general.gmt_create
     */
    private Date gmtCreate;

    /**
     * 最后修改时间
     * 表字段 : base_evaluation_general.gmt_modified
     */
    private Date gmtModified;

    /**
     * 评价纬度（0-综合评价，后续可能会把车辆评价和站台评价整合进来）
     * 表字段 : base_evaluation_general.kind
     */
    private Integer kind;

    /**
     * 城市编码
     * 表字段 : base_evaluation_general.city_code
     */
    private String cityCode;

    /**
     * 车辆到站速度
     * 表字段 : base_evaluation_general.attach_paths
     */
    private String attachPaths;

    /**
     * 
     * 表字段 : base_evaluation_general.bus_arrive_speed_star
     */
    private Byte busArriveSpeedStar;

    /**
     * 车内舒适度
     * 表字段 : base_evaluation_general.comfort_in_bus_star
     */
    private Byte comfortInBusStar;

    /**
     * 司机服务态度
     * 表字段 : base_evaluation_general.service_for_driver_star
     */
    private Byte serviceForDriverStar;

    /**
     * 站台设施齐全度
     * 表字段 : base_evaluation_general.station_facilities_star
     */
    private Byte stationFacilitiesStar;

    /**
     * 乘车点是否合理
     * 表字段 : base_evaluation_general.riding_place_reasonable_star
     */
    private Byte ridingPlaceReasonableStar;

    /**
     * 评价（更多细节）
     * 表字段 : base_evaluation_general.comment
     */
    private String comment;
    
    /**
     * 位置
     * 表字段 : base_evaluation_general.position
     */
    private String position;

    /**
     * 获取 自增主键 字段:base_evaluation_general.id
     *
     * @return base_evaluation_general.id, 自增主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 自增主键 字段:base_evaluation_general.id
     *
     * @param id the value for base_evaluation_general.id, 自增主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取  字段:base_evaluation_general.user_id
     *
     * @return base_evaluation_general.user_id, 
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置  字段:base_evaluation_general.user_id
     *
     * @param userId the value for base_evaluation_general.user_id, 
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取 评价人 字段:base_evaluation_general.user_name
     *
     * @return base_evaluation_general.user_name, 评价人
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置 评价人 字段:base_evaluation_general.user_name
     *
     * @param userName the value for base_evaluation_general.user_name, 评价人
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取 线路名称（当评价对象是站台时为空） 字段:base_evaluation_general.route_name
     *
     * @return base_evaluation_general.route_name, 线路名称（当评价对象是站台时为空）
     */
    public String getRouteName() {
        return routeName;
    }

    /**
     * 设置 线路名称（当评价对象是站台时为空） 字段:base_evaluation_general.route_name
     *
     * @param routeName the value for base_evaluation_general.route_name, 线路名称（当评价对象是站台时为空）
     */
    public void setRouteName(String routeName) {
        this.routeName = routeName == null ? null : routeName.trim();
    }

    /**
     * 获取 线路方向（0-上行 1-下行 2-环线） 字段:base_evaluation_general.direction
     *
     * @return base_evaluation_general.direction, 线路方向（0-上行 1-下行 2-环线）
     */
    public Integer getDirection() {
        return direction;
    }

    /**
     * 设置 线路方向（0-上行 1-下行 2-环线） 字段:base_evaluation_general.direction
     *
     * @param direction the value for base_evaluation_general.direction, 线路方向（0-上行 1-下行 2-环线）
     */
    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    /**
     * 获取 司机 字段:base_evaluation_general.driver
     *
     * @return base_evaluation_general.driver, 司机
     */
    public String getDriver() {
        return driver;
    }

    /**
     * 设置 司机 字段:base_evaluation_general.driver
     *
     * @param driver the value for base_evaluation_general.driver, 司机
     */
    public void setDriver(String driver) {
        this.driver = driver == null ? null : driver.trim();
    }

    /**
     * 获取 车牌号 字段:base_evaluation_general.bus_plate_number
     *
     * @return base_evaluation_general.bus_plate_number, 车牌号
     */
    public String getBusPlateNumber() {
        return busPlateNumber;
    }

    /**
     * 设置 车牌号 字段:base_evaluation_general.bus_plate_number
     *
     * @param busPlateNumber the value for base_evaluation_general.bus_plate_number, 车牌号
     */
    public void setBusPlateNumber(String busPlateNumber) {
        this.busPlateNumber = busPlateNumber == null ? null : busPlateNumber.trim();
    }

    /**
     * 获取 创建时间 字段:base_evaluation_general.gmt_create
     *
     * @return base_evaluation_general.gmt_create, 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置 创建时间 字段:base_evaluation_general.gmt_create
     *
     * @param gmtCreate the value for base_evaluation_general.gmt_create, 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取 最后修改时间 字段:base_evaluation_general.gmt_modified
     *
     * @return base_evaluation_general.gmt_modified, 最后修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置 最后修改时间 字段:base_evaluation_general.gmt_modified
     *
     * @param gmtModified the value for base_evaluation_general.gmt_modified, 最后修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取 评价纬度（0-综合评价，后续可能会把车辆评价和站台评价整合进来） 字段:base_evaluation_general.kind
     *
     * @return base_evaluation_general.kind, 评价纬度（0-综合评价，后续可能会把车辆评价和站台评价整合进来）
     */
    public Integer getKind() {
        return kind;
    }

    /**
     * 设置 评价纬度（0-综合评价，后续可能会把车辆评价和站台评价整合进来） 字段:base_evaluation_general.kind
     *
     * @param kind the value for base_evaluation_general.kind, 评价纬度（0-综合评价，后续可能会把车辆评价和站台评价整合进来）
     */
    public void setKind(Integer kind) {
        this.kind = kind;
    }

    /**
     * 获取 城市编码 字段:base_evaluation_general.city_code
     *
     * @return base_evaluation_general.city_code, 城市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置 城市编码 字段:base_evaluation_general.city_code
     *
     * @param cityCode the value for base_evaluation_general.city_code, 城市编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * 获取 车辆到站速度 字段:base_evaluation_general.attach_paths
     *
     * @return base_evaluation_general.attach_paths, 车辆到站速度
     */
    public String getAttachPaths() {
        return attachPaths;
    }

    /**
     * 设置 车辆到站速度 字段:base_evaluation_general.attach_paths
     *
     * @param attachPaths the value for base_evaluation_general.attach_paths, 车辆到站速度
     */
    public void setAttachPaths(String attachPaths) {
        this.attachPaths = attachPaths == null ? null : attachPaths.trim();
    }

    /**
     * 获取  字段:base_evaluation_general.bus_arrive_speed_star
     *
     * @return base_evaluation_general.bus_arrive_speed_star, 
     */
    public Byte getBusArriveSpeedStar() {
        return busArriveSpeedStar;
    }

    /**
     * 设置  字段:base_evaluation_general.bus_arrive_speed_star
     *
     * @param busArriveSpeedStar the value for base_evaluation_general.bus_arrive_speed_star, 
     */
    public void setBusArriveSpeedStar(Byte busArriveSpeedStar) {
        this.busArriveSpeedStar = busArriveSpeedStar;
    }

    /**
     * 获取 车内舒适度 字段:base_evaluation_general.comfort_in_bus_star
     *
     * @return base_evaluation_general.comfort_in_bus_star, 车内舒适度
     */
    public Byte getComfortInBusStar() {
        return comfortInBusStar;
    }

    /**
     * 设置 车内舒适度 字段:base_evaluation_general.comfort_in_bus_star
     *
     * @param comfortInBusStar the value for base_evaluation_general.comfort_in_bus_star, 车内舒适度
     */
    public void setComfortInBusStar(Byte comfortInBusStar) {
        this.comfortInBusStar = comfortInBusStar;
    }

    /**
     * 获取 司机服务态度 字段:base_evaluation_general.service_for_driver_star
     *
     * @return base_evaluation_general.service_for_driver_star, 司机服务态度
     */
    public Byte getServiceForDriverStar() {
        return serviceForDriverStar;
    }

    /**
     * 设置 司机服务态度 字段:base_evaluation_general.service_for_driver_star
     *
     * @param serviceForDriverStar the value for base_evaluation_general.service_for_driver_star, 司机服务态度
     */
    public void setServiceForDriverStar(Byte serviceForDriverStar) {
        this.serviceForDriverStar = serviceForDriverStar;
    }

    /**
     * 获取 站台设施齐全度 字段:base_evaluation_general.station_facilities_star
     *
     * @return base_evaluation_general.station_facilities_star, 站台设施齐全度
     */
    public Byte getStationFacilitiesStar() {
        return stationFacilitiesStar;
    }

    /**
     * 设置 站台设施齐全度 字段:base_evaluation_general.station_facilities_star
     *
     * @param stationFacilitiesStar the value for base_evaluation_general.station_facilities_star, 站台设施齐全度
     */
    public void setStationFacilitiesStar(Byte stationFacilitiesStar) {
        this.stationFacilitiesStar = stationFacilitiesStar;
    }

    /**
     * 获取 乘车点是否合理 字段:base_evaluation_general.riding_place_reasonable_star
     *
     * @return base_evaluation_general.riding_place_reasonable_star, 乘车点是否合理
     */
    public Byte getRidingPlaceReasonableStar() {
        return ridingPlaceReasonableStar;
    }

    /**
     * 设置 乘车点是否合理 字段:base_evaluation_general.riding_place_reasonable_star
     *
     * @param ridingPlaceReasonableStar the value for base_evaluation_general.riding_place_reasonable_star, 乘车点是否合理
     */
    public void setRidingPlaceReasonableStar(Byte ridingPlaceReasonableStar) {
        this.ridingPlaceReasonableStar = ridingPlaceReasonableStar;
    }

    /**
     * 获取 评价（更多细节） 字段:base_evaluation_general.comment
     *
     * @return base_evaluation_general.comment, 评价（更多细节）
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置 评价（更多细节） 字段:base_evaluation_general.comment
     *
     * @param comment the value for base_evaluation_general.comment, 评价（更多细节）
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

	/**
	* @return position
	*/
	public String getPosition() {
		return position;
	}

	/**
	* @param position 要设置的 position
	*/
	public void setPosition(String position) {
		this.position = position;
	}
    
}