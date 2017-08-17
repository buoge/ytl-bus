package com.lantaiyuan.ebus.custom.model.travelaround;

import java.math.BigDecimal;
import java.util.Date;
import org.lanqiao.ssm.common.model.BaseModel;

/**
 * 周边游订单详情表
 * TravelAroundOrder
 * 数据库表：base_booktravel
 */
public class TravelAroundOrderQueryModel extends BaseModel<TravelAround> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 自增主键
     * 表字段 : base_booktravel.id
     */
    private Long id;

    /**
     * 创建时间
     * 表字段 : base_booktravel.create_time
     */
    private Date createTime;

    /**
     * 最后修改时间
     * 表字段 : base_booktravel.modified_time
     */
    private Date modifiedTime;

    /**
     * 商品id
     * 表字段 : base_booktravel.goods_id
     */
    private String goodsId;

    /**
     * 周边游ID
     * 表字段 : base_booktravel.travel_around_id
     */
    private String travelAroundId;

    /**
     * 标题
     * 表字段 : base_booktravel.title
     */
    private String title;

    /**
     * 地点
     * 表字段 : base_booktravel.location
     */
    private String location;

    /**
     * 图片url，多条用逗号分隔
     * 表字段 : base_booktravel.pics
     */
    private String pics;

    /**
     * 可出行日期，多个用逗号分个
     * 表字段 : base_booktravel.trip_date
     */
    private String tripDate;

    /**
     * 旅客ID，多个ID用逗号分隔
     * 表字段 : base_booktravel.tourist_id
     */
    private String touristId;

    /**
     * 用户id，对应base_user
     * 表字段 : base_booktravel.user_id
     */
    private Integer userId;

    /**
     * 用户名
     * 表字段 : base_booktravel.user_name
     */
    private String userName;

    /**
     * 单张票价
     * 表字段 : base_booktravel.single_price
     */
    private BigDecimal singlePrice;

    /**
     * 票数
     * 表字段 : base_booktravel.ticket_num
     */
    private Integer ticketNum;

    /**
     * 周边游订单状态：0-未支付 1-已支付 2-已取消 3-已完成 4-已失效
     * 表字段 : base_booktravel.status
     */
    private String status;

    /**
     * 城市编码
     * 表字段 : base_booktravel.city_code
     */
    private String cityCode;

    /**
     * 备用字段1
     * 表字段 : base_booktravel.field1
     */
    private String field1;

    /**
     * 备用字段2
     * 表字段 : base_booktravel.field2
     */
    private String field2;

    /**
     * 备用字段3
     * 表字段 : base_booktravel.field3
     */
    private String field3;

    /**
     * 获取 自增主键 字段:base_booktravel.id
     *
     * @return base_booktravel.id, 自增主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 自增主键 字段:base_booktravel.id
     *
     * @param id the value for base_booktravel.id, 自增主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 创建时间 字段:base_booktravel.create_time
     *
     * @return base_booktravel.create_time, 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 字段:base_booktravel.create_time
     *
     * @param createTime the value for base_booktravel.create_time, 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 最后修改时间 字段:base_booktravel.modified_time
     *
     * @return base_booktravel.modified_time, 最后修改时间
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * 设置 最后修改时间 字段:base_booktravel.modified_time
     *
     * @param modifiedTime the value for base_booktravel.modified_time, 最后修改时间
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    /**
     * 获取 商品id 字段:base_booktravel.goods_id
     *
     * @return base_booktravel.goods_id, 商品id
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * 设置 商品id 字段:base_booktravel.goods_id
     *
     * @param goodsId the value for base_booktravel.goods_id, 商品id
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    /**
     * 获取 周边游ID 字段:base_booktravel.travel_around_id
     *
     * @return base_booktravel.travel_around_id, 周边游ID
     */
    public String getTravelAroundId() {
        return travelAroundId;
    }

    /**
     * 设置 周边游ID 字段:base_booktravel.travel_around_id
     *
     * @param travelAroundId the value for base_booktravel.travel_around_id, 周边游ID
     */
    public void setTravelAroundId(String travelAroundId) {
        this.travelAroundId = travelAroundId == null ? null : travelAroundId.trim();
    }

    /**
     * 获取 标题 字段:base_booktravel.title
     *
     * @return base_booktravel.title, 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置 标题 字段:base_booktravel.title
     *
     * @param title the value for base_booktravel.title, 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取 地点 字段:base_booktravel.location
     *
     * @return base_booktravel.location, 地点
     */
    public String getLocation() {
        return location;
    }

    /**
     * 设置 地点 字段:base_booktravel.location
     *
     * @param location the value for base_booktravel.location, 地点
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * 获取 图片url，多条用逗号分隔 字段:base_booktravel.pics
     *
     * @return base_booktravel.pics, 图片url，多条用逗号分隔
     */
    public String getPics() {
        return pics;
    }

    /**
     * 设置 图片url，多条用逗号分隔 字段:base_booktravel.pics
     *
     * @param pics the value for base_booktravel.pics, 图片url，多条用逗号分隔
     */
    public void setPics(String pics) {
        this.pics = pics == null ? null : pics.trim();
    }

    /**
     * 获取 可出行日期，多个用逗号分个 字段:base_booktravel.trip_date
     *
     * @return base_booktravel.trip_date, 可出行日期，多个用逗号分个
     */
    public String getTripDate() {
        return tripDate;
    }

    /**
     * 设置 可出行日期，多个用逗号分个 字段:base_booktravel.trip_date
     *
     * @param tripDate the value for base_booktravel.trip_date, 可出行日期，多个用逗号分个
     */
    public void setTripDate(String tripDate) {
        this.tripDate = tripDate == null ? null : tripDate.trim();
    }

    /**
     * 获取 旅客ID，多个ID用逗号分隔 字段:base_booktravel.tourist_id
     *
     * @return base_booktravel.tourist_id, 旅客ID，多个ID用逗号分隔
     */
    public String getTouristId() {
        return touristId;
    }

    /**
     * 设置 旅客ID，多个ID用逗号分隔 字段:base_booktravel.tourist_id
     *
     * @param touristId the value for base_booktravel.tourist_id, 旅客ID，多个ID用逗号分隔
     */
    public void setTouristId(String touristId) {
        this.touristId = touristId == null ? null : touristId.trim();
    }

    /**
     * 获取 用户id，对应base_user 字段:base_booktravel.user_id
     *
     * @return base_booktravel.user_id, 用户id，对应base_user
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置 用户id，对应base_user 字段:base_booktravel.user_id
     *
     * @param userId the value for base_booktravel.user_id, 用户id，对应base_user
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取 用户名 字段:base_booktravel.user_name
     *
     * @return base_booktravel.user_name, 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置 用户名 字段:base_booktravel.user_name
     *
     * @param userName the value for base_booktravel.user_name, 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取 单张票价 字段:base_booktravel.single_price
     *
     * @return base_booktravel.single_price, 单张票价
     */
    public BigDecimal getSinglePrice() {
        return singlePrice;
    }

    /**
     * 设置 单张票价 字段:base_booktravel.single_price
     *
     * @param singlePrice the value for base_booktravel.single_price, 单张票价
     */
    public void setSinglePrice(BigDecimal singlePrice) {
        this.singlePrice = singlePrice;
    }

    /**
     * 获取 票数 字段:base_booktravel.ticket_num
     *
     * @return base_booktravel.ticket_num, 票数
     */
    public Integer getTicketNum() {
        return ticketNum;
    }

    /**
     * 设置 票数 字段:base_booktravel.ticket_num
     *
     * @param ticketNum the value for base_booktravel.ticket_num, 票数
     */
    public void setTicketNum(Integer ticketNum) {
        this.ticketNum = ticketNum;
    }

    /**
     * 获取 周边游订单状态：0-未支付 1-已支付 2-已取消 3-已完成 4-已失效 字段:base_booktravel.status
     *
     * @return base_booktravel.status, 周边游订单状态：0-未支付 1-已支付 2-已取消 3-已完成 4-已失效
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置 周边游订单状态：0-未支付 1-已支付 2-已取消 3-已完成 4-已失效 字段:base_booktravel.status
     *
     * @param status the value for base_booktravel.status, 周边游订单状态：0-未支付 1-已支付 2-已取消 3-已完成 4-已失效
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取 城市编码 字段:base_booktravel.city_code
     *
     * @return base_booktravel.city_code, 城市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置 城市编码 字段:base_booktravel.city_code
     *
     * @param cityCode the value for base_booktravel.city_code, 城市编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * 获取 备用字段1 字段:base_booktravel.field1
     *
     * @return base_booktravel.field1, 备用字段1
     */
    public String getField1() {
        return field1;
    }

    /**
     * 设置 备用字段1 字段:base_booktravel.field1
     *
     * @param field1 the value for base_booktravel.field1, 备用字段1
     */
    public void setField1(String field1) {
        this.field1 = field1 == null ? null : field1.trim();
    }

    /**
     * 获取 备用字段2 字段:base_booktravel.field2
     *
     * @return base_booktravel.field2, 备用字段2
     */
    public String getField2() {
        return field2;
    }

    /**
     * 设置 备用字段2 字段:base_booktravel.field2
     *
     * @param field2 the value for base_booktravel.field2, 备用字段2
     */
    public void setField2(String field2) {
        this.field2 = field2 == null ? null : field2.trim();
    }

    /**
     * 获取 备用字段3 字段:base_booktravel.field3
     *
     * @return base_booktravel.field3, 备用字段3
     */
    public String getField3() {
        return field3;
    }

    /**
     * 设置 备用字段3 字段:base_booktravel.field3
     *
     * @param field3 the value for base_booktravel.field3, 备用字段3
     */
    public void setField3(String field3) {
        this.field3 = field3 == null ? null : field3.trim();
    }
}