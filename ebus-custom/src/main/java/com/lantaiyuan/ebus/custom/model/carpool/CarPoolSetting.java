package com.lantaiyuan.ebus.custom.model.carpool;

import java.math.BigDecimal;
import java.util.Date;
import org.lanqiao.ssm.common.model.Model;

/**
 * 用户拼车设置表
 * CarPoolSetting
 * 数据库表：carpool_setting
 */
public class CarPoolSetting extends Model {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 主键
     * 表字段 : carpool_setting.id
     */
    private Integer id;

    /**
     * 用户ID
     * 表字段 : carpool_setting.user_id
     */
    private Integer userId;

    /**
     * 可接受步行范围:5-上车步行不超过500米（默认） 4-上车步行不超过400米 3-上车步行不超过300米
     * 表字段 : carpool_setting.walk_type
     */
    private String walkType;

    /**
     * 可接受延迟时间：分钟
     * 表字段 : carpool_setting.delay_minute
     */
    private BigDecimal delayMinute;

    /**
     * 可接受提前时间：分钟
     * 表字段 : carpool_setting.early_minute
     */
    private BigDecimal earlyMinute;

    /**
     * 可接受车票范围:0-不接受票价变动 1-接受票价的合理波动1-2元 2-接受票价的合理波动3-5元
     * 表字段 : carpool_setting.price_type
     */
    private String priceType;

    /**
     * 可接受车辆类型:0-不接受车型变化 1-优先拼单，合理调配车型
     * 表字段 : carpool_setting.car_type
     */
    private String carType;

    /**
     * 创建时间
     * 表字段 : carpool_setting.gmt_create
     */
    private Date gmtCreate;

    /**
     * 修改时间
     * 表字段 : carpool_setting.gmt_modified
     */
    private Date gmtModified;

    /**
     * 城市编码
     * 表字段 : carpool_setting.city_code
     */
    private String cityCode;

    /**
     * 获取 主键 字段:carpool_setting.id
     *
     * @return carpool_setting.id, 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 主键 字段:carpool_setting.id
     *
     * @param id the value for carpool_setting.id, 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 用户ID 字段:carpool_setting.user_id
     *
     * @return carpool_setting.user_id, 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置 用户ID 字段:carpool_setting.user_id
     *
     * @param userId the value for carpool_setting.user_id, 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取 可接受步行范围:5-上车步行不超过500米（默认） 4-上车步行不超过400米 3-上车步行不超过300米 字段:carpool_setting.walk_type
     *
     * @return carpool_setting.walk_type, 可接受步行范围:5-上车步行不超过500米（默认） 4-上车步行不超过400米 3-上车步行不超过300米
     */
    public String getWalkType() {
        return walkType;
    }

    /**
     * 设置 可接受步行范围:5-上车步行不超过500米（默认） 4-上车步行不超过400米 3-上车步行不超过300米 字段:carpool_setting.walk_type
     *
     * @param walkType the value for carpool_setting.walk_type, 可接受步行范围:5-上车步行不超过500米（默认） 4-上车步行不超过400米 3-上车步行不超过300米
     */
    public void setWalkType(String walkType) {
        this.walkType = walkType;
    }

    /**
     * 获取 可接受延迟时间：分钟 字段:carpool_setting.delay_minute
     *
     * @return carpool_setting.delay_minute, 可接受延迟时间：分钟
     */
    public BigDecimal getDelayMinute() {
        return delayMinute;
    }

    /**
     * 设置 可接受延迟时间：分钟 字段:carpool_setting.delay_minute
     *
     * @param delayMinute the value for carpool_setting.delay_minute, 可接受延迟时间：分钟
     */
    public void setDelayMinute(BigDecimal delayMinute) {
        this.delayMinute = delayMinute;
    }

    /**
     * 获取 可接受提前时间：分钟 字段:carpool_setting.early_minute
     *
     * @return carpool_setting.early_minute, 可接受提前时间：分钟
     */
    public BigDecimal getEarlyMinute() {
        return earlyMinute;
    }

    /**
     * 设置 可接受提前时间：分钟 字段:carpool_setting.early_minute
     *
     * @param earlyMinute the value for carpool_setting.early_minute, 可接受提前时间：分钟
     */
    public void setEarlyMinute(BigDecimal earlyMinute) {
        this.earlyMinute = earlyMinute;
    }

    /**
     * 获取 可接受车票范围:0-不接受票价变动 1-接受票价的合理波动1-2元 2-接受票价的合理波动3-5元 字段:carpool_setting.price_type
     *
     * @return carpool_setting.price_type, 可接受车票范围:0-不接受票价变动 1-接受票价的合理波动1-2元 2-接受票价的合理波动3-5元
     */
    public String getPriceType() {
        return priceType;
    }

    /**
     * 设置 可接受车票范围:0-不接受票价变动 1-接受票价的合理波动1-2元 2-接受票价的合理波动3-5元 字段:carpool_setting.price_type
     *
     * @param priceType the value for carpool_setting.price_type, 可接受车票范围:0-不接受票价变动 1-接受票价的合理波动1-2元 2-接受票价的合理波动3-5元
     */
    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    /**
     * 获取 可接受车辆类型:0-不接受车型变化 1-优先拼单，合理调配车型 字段:carpool_setting.car_type
     *
     * @return carpool_setting.car_type, 可接受车辆类型:0-不接受车型变化 1-优先拼单，合理调配车型
     */
    public String getCarType() {
        return carType;
    }

    /**
     * 设置 可接受车辆类型:0-不接受车型变化 1-优先拼单，合理调配车型 字段:carpool_setting.car_type
     *
     * @param carType the value for carpool_setting.car_type, 可接受车辆类型:0-不接受车型变化 1-优先拼单，合理调配车型
     */
    public void setCarType(String carType) {
        this.carType = carType;
    }

    /**
     * 获取 创建时间 字段:carpool_setting.gmt_create
     *
     * @return carpool_setting.gmt_create, 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置 创建时间 字段:carpool_setting.gmt_create
     *
     * @param gmtCreate the value for carpool_setting.gmt_create, 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取 修改时间 字段:carpool_setting.gmt_modified
     *
     * @return carpool_setting.gmt_modified, 修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置 修改时间 字段:carpool_setting.gmt_modified
     *
     * @param gmtModified the value for carpool_setting.gmt_modified, 修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取 城市编码 字段:carpool_setting.city_code
     *
     * @return carpool_setting.city_code, 城市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置 城市编码 字段:carpool_setting.city_code
     *
     * @param cityCode the value for carpool_setting.city_code, 城市编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }
}