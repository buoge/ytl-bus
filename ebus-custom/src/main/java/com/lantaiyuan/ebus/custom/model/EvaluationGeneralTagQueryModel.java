package com.lantaiyuan.ebus.custom.model;

import java.util.Date;
import org.lanqiao.ssm.common.model.BaseModel;

/**
 * 综合评价自定义标签信息表
 * EvaluationGeneralTag
 * 数据库表：base_evaluation_general_tag
 */
public class EvaluationGeneralTagQueryModel extends BaseModel<EvaluationGeneralTag> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1260647566728252059L;

	/**
     * 主键
     * 表字段 : base_evaluation_general_tag.id
     */
    private String id;

    /**
     * 星级-车辆到达及时度
     * 表字段 : base_evaluation_general_tag.bus_arrive_speed_star
     */
    private Byte busArriveSpeedStar;

    /**
     * 星级-车内舒适度
     * 表字段 : base_evaluation_general_tag.comfort_in_bus_star
     */
    private Byte comfortInBusStar;

    /**
     * 星级-司机服务态度
     * 表字段 : base_evaluation_general_tag.service_for_driver_star
     */
    private Byte serviceForDriverStar;

    /**
     * 星级-站台设施齐全度
     * 表字段 : base_evaluation_general_tag.station_facilities_star
     */
    private Byte stationFacilitiesStar;

    /**
     * 星级-乘车点是否合理
     * 表字段 : base_evaluation_general_tag.riding_place_reasonable_star
     */
    private Byte ridingPlaceReasonableStar;

    /**
     * 被使用次数
     * 表字段 : base_evaluation_general_tag.count
     */
    private Integer count;

    /**
     * 创建时间
     * 表字段 : base_evaluation_general_tag.gmt_create
     */
    private Date gmtCreate;

    /**
     * 最后修改时间
     * 表字段 : base_evaluation_general_tag.gmt_modified
     */
    private Date gmtModified;

    /**
     * 描述客户想说的话
     * 表字段 : base_evaluation_general_tag.comment
     */
    private String comment;

    /**
     * 获取 主键 字段:base_evaluation_general_tag.id
     *
     * @return base_evaluation_general_tag.id, 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 主键 字段:base_evaluation_general_tag.id
     *
     * @param id the value for base_evaluation_general_tag.id, 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 星级-车辆到达及时度 字段:base_evaluation_general_tag.bus_arrive_speed_star
     *
     * @return base_evaluation_general_tag.bus_arrive_speed_star, 星级-车辆到达及时度
     */
    public Byte getBusArriveSpeedStar() {
        return busArriveSpeedStar;
    }

    /**
     * 设置 星级-车辆到达及时度 字段:base_evaluation_general_tag.bus_arrive_speed_star
     *
     * @param busArriveSpeedStar the value for base_evaluation_general_tag.bus_arrive_speed_star, 星级-车辆到达及时度
     */
    public void setBusArriveSpeedStar(Byte busArriveSpeedStar) {
        this.busArriveSpeedStar = busArriveSpeedStar;
    }

    /**
     * 获取 星级-车内舒适度 字段:base_evaluation_general_tag.comfort_in_bus_star
     *
     * @return base_evaluation_general_tag.comfort_in_bus_star, 星级-车内舒适度
     */
    public Byte getComfortInBusStar() {
        return comfortInBusStar;
    }

    /**
     * 设置 星级-车内舒适度 字段:base_evaluation_general_tag.comfort_in_bus_star
     *
     * @param comfortInBusStar the value for base_evaluation_general_tag.comfort_in_bus_star, 星级-车内舒适度
     */
    public void setComfortInBusStar(Byte comfortInBusStar) {
        this.comfortInBusStar = comfortInBusStar;
    }

    /**
     * 获取 星级-司机服务态度 字段:base_evaluation_general_tag.service_for_driver_star
     *
     * @return base_evaluation_general_tag.service_for_driver_star, 星级-司机服务态度
     */
    public Byte getServiceForDriverStar() {
        return serviceForDriverStar;
    }

    /**
     * 设置 星级-司机服务态度 字段:base_evaluation_general_tag.service_for_driver_star
     *
     * @param serviceForDriverStar the value for base_evaluation_general_tag.service_for_driver_star, 星级-司机服务态度
     */
    public void setServiceForDriverStar(Byte serviceForDriverStar) {
        this.serviceForDriverStar = serviceForDriverStar;
    }

    /**
     * 获取 星级-站台设施齐全度 字段:base_evaluation_general_tag.station_facilities_star
     *
     * @return base_evaluation_general_tag.station_facilities_star, 星级-站台设施齐全度
     */
    public Byte getStationFacilitiesStar() {
        return stationFacilitiesStar;
    }

    /**
     * 设置 星级-站台设施齐全度 字段:base_evaluation_general_tag.station_facilities_star
     *
     * @param stationFacilitiesStar the value for base_evaluation_general_tag.station_facilities_star, 星级-站台设施齐全度
     */
    public void setStationFacilitiesStar(Byte stationFacilitiesStar) {
        this.stationFacilitiesStar = stationFacilitiesStar;
    }

    /**
     * 获取 星级-乘车点是否合理 字段:base_evaluation_general_tag.riding_place_reasonable_star
     *
     * @return base_evaluation_general_tag.riding_place_reasonable_star, 星级-乘车点是否合理
     */
    public Byte getRidingPlaceReasonableStar() {
        return ridingPlaceReasonableStar;
    }

    /**
     * 设置 星级-乘车点是否合理 字段:base_evaluation_general_tag.riding_place_reasonable_star
     *
     * @param ridingPlaceReasonableStar the value for base_evaluation_general_tag.riding_place_reasonable_star, 星级-乘车点是否合理
     */
    public void setRidingPlaceReasonableStar(Byte ridingPlaceReasonableStar) {
        this.ridingPlaceReasonableStar = ridingPlaceReasonableStar;
    }

    /**
     * 获取 被使用次数 字段:base_evaluation_general_tag.count
     *
     * @return base_evaluation_general_tag.count, 被使用次数
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置 被使用次数 字段:base_evaluation_general_tag.count
     *
     * @param count the value for base_evaluation_general_tag.count, 被使用次数
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 获取 创建时间 字段:base_evaluation_general_tag.gmt_create
     *
     * @return base_evaluation_general_tag.gmt_create, 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置 创建时间 字段:base_evaluation_general_tag.gmt_create
     *
     * @param gmtCreate the value for base_evaluation_general_tag.gmt_create, 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取 最后修改时间 字段:base_evaluation_general_tag.gmt_modified
     *
     * @return base_evaluation_general_tag.gmt_modified, 最后修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置 最后修改时间 字段:base_evaluation_general_tag.gmt_modified
     *
     * @param gmtModified the value for base_evaluation_general_tag.gmt_modified, 最后修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取 描述客户想说的话 字段:base_evaluation_general_tag.comment
     *
     * @return base_evaluation_general_tag.comment, 描述客户想说的话
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置 描述客户想说的话 字段:base_evaluation_general_tag.comment
     *
     * @param comment the value for base_evaluation_general_tag.comment, 描述客户想说的话
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}