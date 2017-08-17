package com.lantaiyuan.ebus.carpool.model;

import org.lanqiao.ssm.common.model.Model;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户拼车业务订单表
 * CarpoolOrder
 * 数据库表：carpool_order
 */
public class CarpoolOrder extends Model{

    private static final long serialVersionUID = 1688719502634335073L;
    /**
     * 自增主键
     * 表字段 : carpool_order.id
     */
    private Long id;

    /**
     * 创建时间
     * 表字段 : carpool_order.gmt_create
     */
    private Date gmtCreate;

    /**
     * 最后修改时间
     * 表字段 : carpool_order.gmt_modified
     */
    private Date gmtModified;

    /**
     * 用户id，对应base_user
     * 表字段 : carpool_order.user_id
     */
    private Integer userId;

    /**
     * 与大数据对接的撮合id
     * 表字段 : carpool_order.match_id
     */
    private String matchId;

    /**
     * 加入失败，记录手动选择要加入的matchId
     * 表字段 : carpool_order.old_match_id
     */
    private String oldMatchId;

    /**
     * 订单编号
     * 表字段 : carpool_order.order_no
     */
    private String orderNo;

    /**
     * 用户名
     * 表字段 : carpool_order.user_name
     */
    private String userName;

    /**
     * 初始起点
     * 表字段 : carpool_order.initial_start_place
     */
    private String initialStartPlace;

    /**
     * 初始起点经度
     * 表字段 : carpool_order.initial_start_lon
     */
    private BigDecimal initialStartLon;

    /**
     * 初始起点纬度
     * 表字段 : carpool_order.initial_start_lat
     */
    private BigDecimal initialStartLat;

    /**
     * 初始终点
     * 表字段 : carpool_order.initial_end_place
     */
    private String initialEndPlace;

    /**
     * 初始终点经度
     * 表字段 : carpool_order.initial_end_lon
     */
    private BigDecimal initialEndLon;

    /**
     * 初始终点纬度
     * 表字段 : carpool_order.initial_end_lat
     */
    private BigDecimal initialEndLat;

    /**
     * 初始上车时间
     * 表字段 : carpool_order.initial_aboard_time
     */
    private Date initialAboardTime;

    /**
     * 初始估计票价（单个座位，单张票）
     * 表字段 : carpool_order.initial_price
     */
    private BigDecimal initialPrice;

    /**
     * 座位数
     * 表字段 : carpool_order.seats
     */
    private Byte seats;

    /**
     * 已支付的金额
     * 表字段 : carpool_order.paid_price
     */
    private BigDecimal paidPrice;

    /**
     * 规律型专用：工作日是到达终点时间，非工作日是从起点出发时间
     * 表字段 : carpool_order.arrive_or_start_time
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date arriveOrStartTime;

    /**
     * 规律型专用：工作日或非工作日均是从终点返回时间
     * 表字段 : carpool_order.return_time
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date returnTime;

    /**
     * 能接受的最大步行距离
     * 表字段 : carpool_order.max_walk_distance
     */
    private Integer maxWalkDistance;

    /**
     * 临时型专用：最早出发时间
     * 表字段 : carpool_order.earliest_start_time
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date earliestStartTime;

    /**
     * 临时型专用：最晚出发时间
     * 表字段 : carpool_order.latest_start_time
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date latestStartTime;

    /**
     * 是否规律性（0：否，1：是）
     * 表字段 : carpool_order.is_regular
     */
    private Byte isRegular;

    /**
     * 1:工作日，2:非工作日
     * 表字段 : carpool_order.regular_detail
     */
    private Byte regularDetail;

    /**
     * 城市编码
     * 表字段 : carpool_order.city_code
     */
    private String cityCode;

    /**
     * 初始专线类别。1：直达专线，2：普通专线
     * 表字段 : carpool_order.initial_line_type
     */
    private Byte initialLineType;

    /**
     * 实际起点
     * 表字段 : carpool_order.real_start_place
     */
    private String realStartPlace;

    /**
     * 实际起点经度
     * 表字段 : carpool_order.real_start_lon
     */
    private BigDecimal realStartLon;

    /**
     * 实际起点纬度
     * 表字段 : carpool_order.real_start_lat
     */
    private BigDecimal realStartLat;

    /**
     * 实际终点
     * 表字段 : carpool_order.real_end_place
     */
    private String realEndPlace;

    /**
     * 实际终点经度
     * 表字段 : carpool_order.real_end_lon
     */
    private BigDecimal realEndLon;

    /**
     * 实际终点纬度
     * 表字段 : carpool_order.real_end_lat
     */
    private BigDecimal realEndLat;

    /**
     * 预计上车时间
     * 表字段 : carpool_order.expect_aboard_time
     */
    private Date expectAboardTime;

    /**
     * 预计下车时间
     * 表字段 : carpool_order.expect_off_bus_time
     */
    private Date expectOffBusTime;

    /**
     * 实际应该支付的金额
     * 表字段 : carpool_order.real_price
     */
    private BigDecimal realPrice;

    /**
     * 该用户被撮合的次数
     * 表字段 : carpool_order.match_times
     */
    private Integer matchTimes;

    /**
     * 实际专线类别。1：直达专线，2：普通专线
     * 表字段 : carpool_order.real_line_type
     */
    private Byte realLineType;

    /**
     * 是否需要补差价，0：不需要，1：需要，默认0
     * 表字段 : carpool_order.is_need_repay
     */
    private Byte isNeedRepay;

    /**
     * 需要补差价的金额
     * 表字段 : carpool_order.need_repay_price
     */
    private Byte needRepayPrice;

    /**
     * 补差价订单号
     * 表字段 : carpool_order.repay_order_no
     */
    private String repayOrderNo;

    /**
     * 申请时间
     * 表字段 : carpool_order.apply_time
     */
    private Date applyTime;

    /**
     * 0-申请未支付  1-已支付拼车中 2-待发车  3-完成
     * 表字段 : carpool_order.status
     */
    private Byte status;

    /**
     * 拼车状态(0:处理中，1: 拼车中, 2: 拼车成功, 3: 已发车, 4: 用户已上车, 5: 用户到达下车点，9: 车到终点, 10: 用户已评价，-1: 拼车失败)
     * 表字段 : carpool_order.match_status
     */
    private Byte matchStatus;

    /**
     * 发送给大数据的状态(0:未发送，1:已发送-restful接口一定要有返回结果才认为已发送)
     * 表字段 : carpool_order.send_status
     */
    private Byte sendStatus;

    /**
     * 联系人
     * 表字段 : carpool_order.contact_name
     */
    private String contactName;

    /**
     * 联系人电话
     * 表字段 : carpool_order.contact_phone
     */
    private String contactPhone;

    /**
     * 
     * 表字段 : carpool_order.field1
     */
    private String field1;

    /**
     * 
     * 表字段 : carpool_order.field2
     */
    private String field2;

    /**
     * 
     * 表字段 : carpool_order.field3
     */
    private String field3;

    /**
     * 获取 自增主键 字段:carpool_order.id
     *
     * @return carpool_order.id, 自增主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 自增主键 字段:carpool_order.id
     *
     * @param id the value for carpool_order.id, 自增主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 创建时间 字段:carpool_order.gmt_create
     *
     * @return carpool_order.gmt_create, 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置 创建时间 字段:carpool_order.gmt_create
     *
     * @param gmtCreate the value for carpool_order.gmt_create, 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取 最后修改时间 字段:carpool_order.gmt_modified
     *
     * @return carpool_order.gmt_modified, 最后修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置 最后修改时间 字段:carpool_order.gmt_modified
     *
     * @param gmtModified the value for carpool_order.gmt_modified, 最后修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取 用户id，对应base_user 字段:carpool_order.user_id
     *
     * @return carpool_order.user_id, 用户id，对应base_user
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置 用户id，对应base_user 字段:carpool_order.user_id
     *
     * @param userId the value for carpool_order.user_id, 用户id，对应base_user
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取 与大数据对接的撮合id 字段:carpool_order.match_id
     *
     * @return carpool_order.match_id, 与大数据对接的撮合id
     */
    public String getMatchId() {
        return matchId;
    }

    /**
     * 设置 与大数据对接的撮合id 字段:carpool_order.match_id
     *
     * @param matchId the value for carpool_order.match_id, 与大数据对接的撮合id
     */
    public void setMatchId(String matchId) {
        this.matchId = matchId == null ? null : matchId.trim();
    }

    /**
     * 获取 加入失败，记录手动选择要加入的matchId 字段:carpool_order.old_match_id
     *
     * @return carpool_order.old_match_id, 加入失败，记录手动选择要加入的matchId
     */
    public String getOldMatchId() {
        return oldMatchId;
    }

    /**
     * 设置 加入失败，记录手动选择要加入的matchId 字段:carpool_order.old_match_id
     *
     * @param oldMatchId the value for carpool_order.old_match_id, 加入失败，记录手动选择要加入的matchId
     */
    public void setOldMatchId(String oldMatchId) {
        this.oldMatchId = oldMatchId == null ? null : oldMatchId.trim();
    }

    /**
     * 获取 订单编号 字段:carpool_order.order_no
     *
     * @return carpool_order.order_no, 订单编号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 设置 订单编号 字段:carpool_order.order_no
     *
     * @param orderNo the value for carpool_order.order_no, 订单编号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * 获取 用户名 字段:carpool_order.user_name
     *
     * @return carpool_order.user_name, 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置 用户名 字段:carpool_order.user_name
     *
     * @param userName the value for carpool_order.user_name, 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取 初始起点 字段:carpool_order.initial_start_place
     *
     * @return carpool_order.initial_start_place, 初始起点
     */
    public String getInitialStartPlace() {
        return initialStartPlace;
    }

    /**
     * 设置 初始起点 字段:carpool_order.initial_start_place
     *
     * @param initialStartPlace the value for carpool_order.initial_start_place, 初始起点
     */
    public void setInitialStartPlace(String initialStartPlace) {
        this.initialStartPlace = initialStartPlace == null ? null : initialStartPlace.trim();
    }

    /**
     * 获取 初始起点经度 字段:carpool_order.initial_start_lon
     *
     * @return carpool_order.initial_start_lon, 初始起点经度
     */
    public BigDecimal getInitialStartLon() {
        return initialStartLon;
    }

    /**
     * 设置 初始起点经度 字段:carpool_order.initial_start_lon
     *
     * @param initialStartLon the value for carpool_order.initial_start_lon, 初始起点经度
     */
    public void setInitialStartLon(BigDecimal initialStartLon) {
        this.initialStartLon = initialStartLon;
    }

    /**
     * 获取 初始起点纬度 字段:carpool_order.initial_start_lat
     *
     * @return carpool_order.initial_start_lat, 初始起点纬度
     */
    public BigDecimal getInitialStartLat() {
        return initialStartLat;
    }

    /**
     * 设置 初始起点纬度 字段:carpool_order.initial_start_lat
     *
     * @param initialStartLat the value for carpool_order.initial_start_lat, 初始起点纬度
     */
    public void setInitialStartLat(BigDecimal initialStartLat) {
        this.initialStartLat = initialStartLat;
    }

    /**
     * 获取 初始终点 字段:carpool_order.initial_end_place
     *
     * @return carpool_order.initial_end_place, 初始终点
     */
    public String getInitialEndPlace() {
        return initialEndPlace;
    }

    /**
     * 设置 初始终点 字段:carpool_order.initial_end_place
     *
     * @param initialEndPlace the value for carpool_order.initial_end_place, 初始终点
     */
    public void setInitialEndPlace(String initialEndPlace) {
        this.initialEndPlace = initialEndPlace == null ? null : initialEndPlace.trim();
    }

    /**
     * 获取 初始终点经度 字段:carpool_order.initial_end_lon
     *
     * @return carpool_order.initial_end_lon, 初始终点经度
     */
    public BigDecimal getInitialEndLon() {
        return initialEndLon;
    }

    /**
     * 设置 初始终点经度 字段:carpool_order.initial_end_lon
     *
     * @param initialEndLon the value for carpool_order.initial_end_lon, 初始终点经度
     */
    public void setInitialEndLon(BigDecimal initialEndLon) {
        this.initialEndLon = initialEndLon;
    }

    /**
     * 获取 初始终点纬度 字段:carpool_order.initial_end_lat
     *
     * @return carpool_order.initial_end_lat, 初始终点纬度
     */
    public BigDecimal getInitialEndLat() {
        return initialEndLat;
    }

    /**
     * 设置 初始终点纬度 字段:carpool_order.initial_end_lat
     *
     * @param initialEndLat the value for carpool_order.initial_end_lat, 初始终点纬度
     */
    public void setInitialEndLat(BigDecimal initialEndLat) {
        this.initialEndLat = initialEndLat;
    }

    /**
     * 获取 初始上车时间 字段:carpool_order.initial_aboard_time
     *
     * @return carpool_order.initial_aboard_time, 初始上车时间
     */
    public Date getInitialAboardTime() {
        return initialAboardTime;
    }

    /**
     * 设置 初始上车时间 字段:carpool_order.initial_aboard_time
     *
     * @param initialAboardTime the value for carpool_order.initial_aboard_time, 初始上车时间
     */
    public void setInitialAboardTime(Date initialAboardTime) {
        this.initialAboardTime = initialAboardTime;
    }

    /**
     * 获取 初始估计票价（单个座位，单张票） 字段:carpool_order.initial_price
     *
     * @return carpool_order.initial_price, 初始估计票价（单个座位，单张票）
     */
    public BigDecimal getInitialPrice() {
        return initialPrice;
    }

    /**
     * 设置 初始估计票价（单个座位，单张票） 字段:carpool_order.initial_price
     *
     * @param initialPrice the value for carpool_order.initial_price, 初始估计票价（单个座位，单张票）
     */
    public void setInitialPrice(BigDecimal initialPrice) {
        this.initialPrice = initialPrice;
    }

    /**
     * 获取 座位数 字段:carpool_order.seats
     *
     * @return carpool_order.seats, 座位数
     */
    public Byte getSeats() {
        return seats;
    }

    /**
     * 设置 座位数 字段:carpool_order.seats
     *
     * @param seats the value for carpool_order.seats, 座位数
     */
    public void setSeats(Byte seats) {
        this.seats = seats;
    }

    /**
     * 获取 已支付的金额 字段:carpool_order.paid_price
     *
     * @return carpool_order.paid_price, 已支付的金额
     */
    public BigDecimal getPaidPrice() {
        return paidPrice;
    }

    /**
     * 设置 已支付的金额 字段:carpool_order.paid_price
     *
     * @param paidPrice the value for carpool_order.paid_price, 已支付的金额
     */
    public void setPaidPrice(BigDecimal paidPrice) {
        this.paidPrice = paidPrice;
    }

    /**
     * 获取 规律型专用：工作日是到达终点时间，非工作日是从起点出发时间 字段:carpool_order.arrive_or_start_time
     *
     * @return carpool_order.arrive_or_start_time, 规律型专用：工作日是到达终点时间，非工作日是从起点出发时间
     */
    public Date getArriveOrStartTime() {
        return arriveOrStartTime;
    }

    /**
     * 设置 规律型专用：工作日是到达终点时间，非工作日是从起点出发时间 字段:carpool_order.arrive_or_start_time
     *
     * @param arriveOrStartTime the value for carpool_order.arrive_or_start_time, 规律型专用：工作日是到达终点时间，非工作日是从起点出发时间
     */
    public void setArriveOrStartTime(Date arriveOrStartTime) {
        this.arriveOrStartTime = arriveOrStartTime;
    }

    /**
     * 获取 规律型专用：工作日或非工作日均是从终点返回时间 字段:carpool_order.return_time
     *
     * @return carpool_order.return_time, 规律型专用：工作日或非工作日均是从终点返回时间
     */
    public Date getReturnTime() {
        return returnTime;
    }

    /**
     * 设置 规律型专用：工作日或非工作日均是从终点返回时间 字段:carpool_order.return_time
     *
     * @param returnTime the value for carpool_order.return_time, 规律型专用：工作日或非工作日均是从终点返回时间
     */
    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    /**
     * 获取 能接受的最大步行距离 字段:carpool_order.max_walk_distance
     *
     * @return carpool_order.max_walk_distance, 能接受的最大步行距离
     */
    public Integer getMaxWalkDistance() {
        return maxWalkDistance;
    }

    /**
     * 设置 能接受的最大步行距离 字段:carpool_order.max_walk_distance
     *
     * @param maxWalkDistance the value for carpool_order.max_walk_distance, 能接受的最大步行距离
     */
    public void setMaxWalkDistance(Integer maxWalkDistance) {
        this.maxWalkDistance = maxWalkDistance;
    }

    /**
     * 获取 临时型专用：最早出发时间 字段:carpool_order.earliest_start_time
     *
     * @return carpool_order.earliest_start_time, 临时型专用：最早出发时间
     */
    public Date getEarliestStartTime() {
        return earliestStartTime;
    }

    /**
     * 设置 临时型专用：最早出发时间 字段:carpool_order.earliest_start_time
     *
     * @param earliestStartTime the value for carpool_order.earliest_start_time, 临时型专用：最早出发时间
     */
    public void setEarliestStartTime(Date earliestStartTime) {
        this.earliestStartTime = earliestStartTime;
    }

    /**
     * 获取 临时型专用：最晚出发时间 字段:carpool_order.latest_start_time
     *
     * @return carpool_order.latest_start_time, 临时型专用：最晚出发时间
     */
    public Date getLatestStartTime() {
        return latestStartTime;
    }

    /**
     * 设置 临时型专用：最晚出发时间 字段:carpool_order.latest_start_time
     *
     * @param latestStartTime the value for carpool_order.latest_start_time, 临时型专用：最晚出发时间
     */
    public void setLatestStartTime(Date latestStartTime) {
        this.latestStartTime = latestStartTime;
    }

    /**
     * 获取 是否规律性（0：否，1：是） 字段:carpool_order.is_regular
     *
     * @return carpool_order.is_regular, 是否规律性（0：否，1：是）
     */
    public Byte getIsRegular() {
        return isRegular;
    }

    /**
     * 设置 是否规律性（0：否，1：是） 字段:carpool_order.is_regular
     *
     * @param isRegular the value for carpool_order.is_regular, 是否规律性（0：否，1：是）
     */
    public void setIsRegular(Byte isRegular) {
        this.isRegular = isRegular;
    }

    /**
     * 获取 1:工作日，2:非工作日 字段:carpool_order.regular_detail
     *
     * @return carpool_order.regular_detail, 1:工作日，2:非工作日
     */
    public Byte getRegularDetail() {
        return regularDetail;
    }

    /**
     * 设置 1:工作日，2:非工作日 字段:carpool_order.regular_detail
     *
     * @param regularDetail the value for carpool_order.regular_detail, 1:工作日，2:非工作日
     */
    public void setRegularDetail(Byte regularDetail) {
        this.regularDetail = regularDetail;
    }

    /**
     * 获取 城市编码 字段:carpool_order.city_code
     *
     * @return carpool_order.city_code, 城市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置 城市编码 字段:carpool_order.city_code
     *
     * @param cityCode the value for carpool_order.city_code, 城市编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * 获取 初始专线类别。1：直达专线，2：普通专线 字段:carpool_order.initial_line_type
     *
     * @return carpool_order.initial_line_type, 初始专线类别。1：直达专线，2：普通专线
     */
    public Byte getInitialLineType() {
        return initialLineType;
    }

    /**
     * 设置 初始专线类别。1：直达专线，2：普通专线 字段:carpool_order.initial_line_type
     *
     * @param initialLineType the value for carpool_order.initial_line_type, 初始专线类别。1：直达专线，2：普通专线
     */
    public void setInitialLineType(Byte initialLineType) {
        this.initialLineType = initialLineType;
    }

    /**
     * 获取 实际起点 字段:carpool_order.real_start_place
     *
     * @return carpool_order.real_start_place, 实际起点
     */
    public String getRealStartPlace() {
        return realStartPlace;
    }

    /**
     * 设置 实际起点 字段:carpool_order.real_start_place
     *
     * @param realStartPlace the value for carpool_order.real_start_place, 实际起点
     */
    public void setRealStartPlace(String realStartPlace) {
        this.realStartPlace = realStartPlace == null ? null : realStartPlace.trim();
    }

    /**
     * 获取 实际起点经度 字段:carpool_order.real_start_lon
     *
     * @return carpool_order.real_start_lon, 实际起点经度
     */
    public BigDecimal getRealStartLon() {
        return realStartLon;
    }

    /**
     * 设置 实际起点经度 字段:carpool_order.real_start_lon
     *
     * @param realStartLon the value for carpool_order.real_start_lon, 实际起点经度
     */
    public void setRealStartLon(BigDecimal realStartLon) {
        this.realStartLon = realStartLon;
    }

    /**
     * 获取 实际起点纬度 字段:carpool_order.real_start_lat
     *
     * @return carpool_order.real_start_lat, 实际起点纬度
     */
    public BigDecimal getRealStartLat() {
        return realStartLat;
    }

    /**
     * 设置 实际起点纬度 字段:carpool_order.real_start_lat
     *
     * @param realStartLat the value for carpool_order.real_start_lat, 实际起点纬度
     */
    public void setRealStartLat(BigDecimal realStartLat) {
        this.realStartLat = realStartLat;
    }

    /**
     * 获取 实际终点 字段:carpool_order.real_end_place
     *
     * @return carpool_order.real_end_place, 实际终点
     */
    public String getRealEndPlace() {
        return realEndPlace;
    }

    /**
     * 设置 实际终点 字段:carpool_order.real_end_place
     *
     * @param realEndPlace the value for carpool_order.real_end_place, 实际终点
     */
    public void setRealEndPlace(String realEndPlace) {
        this.realEndPlace = realEndPlace == null ? null : realEndPlace.trim();
    }

    /**
     * 获取 实际终点经度 字段:carpool_order.real_end_lon
     *
     * @return carpool_order.real_end_lon, 实际终点经度
     */
    public BigDecimal getRealEndLon() {
        return realEndLon;
    }

    /**
     * 设置 实际终点经度 字段:carpool_order.real_end_lon
     *
     * @param realEndLon the value for carpool_order.real_end_lon, 实际终点经度
     */
    public void setRealEndLon(BigDecimal realEndLon) {
        this.realEndLon = realEndLon;
    }

    /**
     * 获取 实际终点纬度 字段:carpool_order.real_end_lat
     *
     * @return carpool_order.real_end_lat, 实际终点纬度
     */
    public BigDecimal getRealEndLat() {
        return realEndLat;
    }

    /**
     * 设置 实际终点纬度 字段:carpool_order.real_end_lat
     *
     * @param realEndLat the value for carpool_order.real_end_lat, 实际终点纬度
     */
    public void setRealEndLat(BigDecimal realEndLat) {
        this.realEndLat = realEndLat;
    }

    /**
     * 获取 预计上车时间 字段:carpool_order.expect_aboard_time
     *
     * @return carpool_order.expect_aboard_time, 预计上车时间
     */
    public Date getExpectAboardTime() {
        return expectAboardTime;
    }

    /**
     * 设置 预计上车时间 字段:carpool_order.expect_aboard_time
     *
     * @param expectAboardTime the value for carpool_order.expect_aboard_time, 预计上车时间
     */
    public void setExpectAboardTime(Date expectAboardTime) {
        this.expectAboardTime = expectAboardTime;
    }

    /**
     * 获取 预计下车时间 字段:carpool_order.expect_off_bus_time
     *
     * @return carpool_order.expect_off_bus_time, 预计下车时间
     */
    public Date getExpectOffBusTime() {
        return expectOffBusTime;
    }

    /**
     * 设置 预计下车时间 字段:carpool_order.expect_off_bus_time
     *
     * @param expectOffBusTime the value for carpool_order.expect_off_bus_time, 预计下车时间
     */
    public void setExpectOffBusTime(Date expectOffBusTime) {
        this.expectOffBusTime = expectOffBusTime;
    }

    /**
     * 获取 实际应该支付的金额 字段:carpool_order.real_price
     *
     * @return carpool_order.real_price, 实际应该支付的金额
     */
    public BigDecimal getRealPrice() {
        return realPrice;
    }

    /**
     * 设置 实际应该支付的金额 字段:carpool_order.real_price
     *
     * @param realPrice the value for carpool_order.real_price, 实际应该支付的金额
     */
    public void setRealPrice(BigDecimal realPrice) {
        this.realPrice = realPrice;
    }

    /**
     * 获取 该用户被撮合的次数 字段:carpool_order.match_times
     *
     * @return carpool_order.match_times, 该用户被撮合的次数
     */
    public Integer getMatchTimes() {
        return matchTimes;
    }

    /**
     * 设置 该用户被撮合的次数 字段:carpool_order.match_times
     *
     * @param matchTimes the value for carpool_order.match_times, 该用户被撮合的次数
     */
    public void setMatchTimes(Integer matchTimes) {
        this.matchTimes = matchTimes;
    }

    /**
     * 获取 实际专线类别。1：直达专线，2：普通专线 字段:carpool_order.real_line_type
     *
     * @return carpool_order.real_line_type, 实际专线类别。1：直达专线，2：普通专线
     */
    public Byte getRealLineType() {
        return realLineType;
    }

    /**
     * 设置 实际专线类别。1：直达专线，2：普通专线 字段:carpool_order.real_line_type
     *
     * @param realLineType the value for carpool_order.real_line_type, 实际专线类别。1：直达专线，2：普通专线
     */
    public void setRealLineType(Byte realLineType) {
        this.realLineType = realLineType;
    }

    /**
     * 获取 是否需要补差价，0：不需要，1：需要，默认0 字段:carpool_order.is_need_repay
     *
     * @return carpool_order.is_need_repay, 是否需要补差价，0：不需要，1：需要，默认0
     */
    public Byte getIsNeedRepay() {
        return isNeedRepay;
    }

    /**
     * 设置 是否需要补差价，0：不需要，1：需要，默认0 字段:carpool_order.is_need_repay
     *
     * @param isNeedRepay the value for carpool_order.is_need_repay, 是否需要补差价，0：不需要，1：需要，默认0
     */
    public void setIsNeedRepay(Byte isNeedRepay) {
        this.isNeedRepay = isNeedRepay;
    }

    /**
     * 获取 需要补差价的金额 字段:carpool_order.need_repay_price
     *
     * @return carpool_order.need_repay_price, 需要补差价的金额
     */
    public Byte getNeedRepayPrice() {
        return needRepayPrice;
    }

    /**
     * 设置 需要补差价的金额 字段:carpool_order.need_repay_price
     *
     * @param needRepayPrice the value for carpool_order.need_repay_price, 需要补差价的金额
     */
    public void setNeedRepayPrice(Byte needRepayPrice) {
        this.needRepayPrice = needRepayPrice;
    }

    /**
     * 获取 补差价订单号 字段:carpool_order.repay_order_no
     *
     * @return carpool_order.repay_order_no, 补差价订单号
     */
    public String getRepayOrderNo() {
        return repayOrderNo;
    }

    /**
     * 设置 补差价订单号 字段:carpool_order.repay_order_no
     *
     * @param repayOrderNo the value for carpool_order.repay_order_no, 补差价订单号
     */
    public void setRepayOrderNo(String repayOrderNo) {
        this.repayOrderNo = repayOrderNo == null ? null : repayOrderNo.trim();
    }

    /**
     * 获取 申请时间 字段:carpool_order.apply_time
     *
     * @return carpool_order.apply_time, 申请时间
     */
    public Date getApplyTime() {
        return applyTime;
    }

    /**
     * 设置 申请时间 字段:carpool_order.apply_time
     *
     * @param applyTime the value for carpool_order.apply_time, 申请时间
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * 获取 0-申请未支付  1-已支付拼车中 2-待发车  3-完成 字段:carpool_order.status
     *
     * @return carpool_order.status, 0-申请未支付  1-已支付拼车中 2-待发车  3-完成
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置 0-申请未支付  1-已支付拼车中 2-待发车  3-完成 字段:carpool_order.status
     *
     * @param status the value for carpool_order.status, 0-申请未支付  1-已支付拼车中 2-待发车  3-完成
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取 拼车状态(0:处理中，1: 拼车中, 2: 拼车成功, 3: 已发车, 4: 用户已上车, 5: 用户到达下车点，9: 车到终点, 10: 用户已评价，-1: 拼车失败) 字段:carpool_order.match_status
     *
     * @return carpool_order.match_status, 拼车状态(0:处理中，1: 拼车中, 2: 拼车成功, 3: 已发车, 4: 用户已上车, 5: 用户到达下车点，9: 车到终点, 10: 用户已评价，-1: 拼车失败)
     */
    public Byte getMatchStatus() {
        return matchStatus;
    }

    /**
     * 设置 拼车状态(0:处理中，1: 拼车中, 2: 拼车成功, 3: 已发车, 4: 用户已上车, 5: 用户到达下车点，9: 车到终点, 10: 用户已评价，-1: 拼车失败) 字段:carpool_order.match_status
     *
     * @param matchStatus the value for carpool_order.match_status, 拼车状态(0:处理中，1: 拼车中, 2: 拼车成功, 3: 已发车, 4: 用户已上车, 5: 用户到达下车点，9: 车到终点, 10: 用户已评价，-1: 拼车失败)
     */
    public void setMatchStatus(Byte matchStatus) {
        this.matchStatus = matchStatus;
    }

    /**
     * 获取 发送给大数据的状态(0:未发送，1:已发送-restful接口一定要有返回结果才认为已发送) 字段:carpool_order.send_status
     *
     * @return carpool_order.send_status, 发送给大数据的状态(0:未发送，1:已发送-restful接口一定要有返回结果才认为已发送)
     */
    public Byte getSendStatus() {
        return sendStatus;
    }

    /**
     * 设置 发送给大数据的状态(0:未发送，1:已发送-restful接口一定要有返回结果才认为已发送) 字段:carpool_order.send_status
     *
     * @param sendStatus the value for carpool_order.send_status, 发送给大数据的状态(0:未发送，1:已发送-restful接口一定要有返回结果才认为已发送)
     */
    public void setSendStatus(Byte sendStatus) {
        this.sendStatus = sendStatus;
    }

    /**
     * 获取 联系人 字段:carpool_order.contact_name
     *
     * @return carpool_order.contact_name, 联系人
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * 设置 联系人 字段:carpool_order.contact_name
     *
     * @param contactName the value for carpool_order.contact_name, 联系人
     */
    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    /**
     * 获取 联系人电话 字段:carpool_order.contact_phone
     *
     * @return carpool_order.contact_phone, 联系人电话
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * 设置 联系人电话 字段:carpool_order.contact_phone
     *
     * @param contactPhone the value for carpool_order.contact_phone, 联系人电话
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    /**
     * 获取  字段:carpool_order.field1
     *
     * @return carpool_order.field1, 
     */
    public String getField1() {
        return field1;
    }

    /**
     * 设置  字段:carpool_order.field1
     *
     * @param field1 the value for carpool_order.field1, 
     */
    public void setField1(String field1) {
        this.field1 = field1 == null ? null : field1.trim();
    }

    /**
     * 获取  字段:carpool_order.field2
     *
     * @return carpool_order.field2, 
     */
    public String getField2() {
        return field2;
    }

    /**
     * 设置  字段:carpool_order.field2
     *
     * @param field2 the value for carpool_order.field2, 
     */
    public void setField2(String field2) {
        this.field2 = field2 == null ? null : field2.trim();
    }

    /**
     * 获取  字段:carpool_order.field3
     *
     * @return carpool_order.field3, 
     */
    public String getField3() {
        return field3;
    }

    /**
     * 设置  字段:carpool_order.field3
     *
     * @param field3 the value for carpool_order.field3, 
     */
    public void setField3(String field3) {
        this.field3 = field3 == null ? null : field3.trim();
    }
}