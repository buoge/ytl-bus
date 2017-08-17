package com.lantaiyuan.ebus.custom.model;

import java.util.Date;

/**
 * 订票详情表
 * BookTicket
 * 数据库表：base_bookticket
 */
public class BookTicket {

    /**
     * 商品id
     * 表字段 : base_bookticket.goodsId
     */
    private String goodsid;

    /**
     * 订单详情id
     * 表字段 : base_bookticket.orderDetailId
     */
    private String orderdetailid;

    /**
     * 专线线路id
     * 表字段 : base_bookticket.routeId
     */
    private String routeid;

    /**
     * 上车点
     * 表字段 : base_bookticket.sourceLocation
     */
    private String sourcelocation;

    /**
     * 下车点
     * 表字段 : base_bookticket.targetLocation
     */
    private String targetlocation;

    /**
     * 乘车时间 格式 07：00
     * 表字段 : base_bookticket.takeTime
     */
    private String taketime;

    /**
     * 乘车日期 2010-10-10
     * 表字段 : base_bookticket.takeDate
     */
    private String takedate;

    /**
     * 车票状态：0-未生效 1-有效 2-已使用 3-已过期
     * 表字段 : base_bookticket.ticketStatus
     */
    private String ticketstatus;

    /**
     * 创建时间
     * 表字段 : base_bookticket.ceateTime
     */
    private Date ceatetime;
    
    private String citycode;
    
    /**
     * 获取 商品id 字段:base_bookticket.goodsId
     *
     * @return base_bookticket.goodsId, 商品id
     */
    public String getGoodsid() {
        return goodsid;
    }

    /**
     * 设置 商品id 字段:base_bookticket.goodsId
     *
     * @param goodsid the value for base_bookticket.goodsId, 商品id
     */
    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid == null ? null : goodsid.trim();
    }

    /**
     * 获取 订单详情id 字段:base_bookticket.orderDetailId
     *
     * @return base_bookticket.orderDetailId, 订单详情id
     */
    public String getOrderdetailid() {
        return orderdetailid;
    }

    /**
     * 设置 订单详情id 字段:base_bookticket.orderDetailId
     *
     * @param orderdetailid the value for base_bookticket.orderDetailId, 订单详情id
     */
    public void setOrderdetailid(String orderdetailid) {
        this.orderdetailid = orderdetailid == null ? null : orderdetailid.trim();
    }

    /**
     * 获取 专线线路id 字段:base_bookticket.routeId
     *
     * @return base_bookticket.routeId, 专线线路id
     */
    public String getRouteid() {
        return routeid;
    }

    /**
     * 设置 专线线路id 字段:base_bookticket.routeId
     *
     * @param routeid the value for base_bookticket.routeId, 专线线路id
     */
    public void setRouteid(String routeid) {
        this.routeid = routeid == null ? null : routeid.trim();
    }

    /**
     * 获取 上车点 字段:base_bookticket.sourceLocation
     *
     * @return base_bookticket.sourceLocation, 上车点
     */
    public String getSourcelocation() {
        return sourcelocation;
    }

    /**
     * 设置 上车点 字段:base_bookticket.sourceLocation
     *
     * @param sourcelocation the value for base_bookticket.sourceLocation, 上车点
     */
    public void setSourcelocation(String sourcelocation) {
        this.sourcelocation = sourcelocation == null ? null : sourcelocation.trim();
    }

    /**
     * 获取 下车点 字段:base_bookticket.targetLocation
     *
     * @return base_bookticket.targetLocation, 下车点
     */
    public String getTargetlocation() {
        return targetlocation;
    }

    /**
     * 设置 下车点 字段:base_bookticket.targetLocation
     *
     * @param targetlocation the value for base_bookticket.targetLocation, 下车点
     */
    public void setTargetlocation(String targetlocation) {
        this.targetlocation = targetlocation == null ? null : targetlocation.trim();
    }

    /**
     * 获取 乘车时间 格式 07：00 字段:base_bookticket.takeTime
     *
     * @return base_bookticket.takeTime, 乘车时间 格式 07：00
     */
    public String getTaketime() {
        return taketime;
    }

    /**
     * 设置 乘车时间 格式 07：00 字段:base_bookticket.takeTime
     *
     * @param taketime the value for base_bookticket.takeTime, 乘车时间 格式 07：00
     */
    public void setTaketime(String taketime) {
        this.taketime = taketime == null ? null : taketime.trim();
    }

    /**
     * 获取 乘车日期 2010-10-10 字段:base_bookticket.takeDate
     *
     * @return base_bookticket.takeDate, 乘车日期 2010-10-10
     */
    public String getTakedate() {
        return takedate;
    }

    /**
     * 设置 乘车日期 2010-10-10 字段:base_bookticket.takeDate
     *
     * @param takedate the value for base_bookticket.takeDate, 乘车日期 2010-10-10
     */
    public void setTakedate(String takedate) {
        this.takedate = takedate == null ? null : takedate.trim();
    }

    /**
     * 获取 车票状态：0-未生效 1-有效 2-已使用 3-已过期 字段:base_bookticket.ticketStatus
     *
     * @return base_bookticket.ticketStatus, 车票状态：0-未生效 1-有效 2-已使用 3-已过期
     */
    public String getTicketstatus() {
        return ticketstatus;
    }

    /**
     * 设置 车票状态：0-未生效 1-有效 2-已使用 3-已过期 字段:base_bookticket.ticketStatus
     *
     * @param ticketstatus the value for base_bookticket.ticketStatus, 车票状态：0-未生效 1-有效 2-已使用 3-已过期
     */
    public void setTicketstatus(String ticketstatus) {
        this.ticketstatus = ticketstatus;
    }

    /**
     * 获取 创建时间 字段:base_bookticket.ceateTime
     *
     * @return base_bookticket.ceateTime, 创建时间
     */
    public Date getCeatetime() {
        return ceatetime;
    }

    /**
     * 设置 创建时间 字段:base_bookticket.ceateTime
     *
     * @param ceatetime the value for base_bookticket.ceateTime, 创建时间
     */
    public void setCeatetime(Date ceatetime) {
        this.ceatetime = ceatetime;
    }

	/**
	 * @return the citycode
	 */
	public String getCitycode() {
		return citycode;
	}

	/**
	 * @param citycode the citycode to set
	 */
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
}