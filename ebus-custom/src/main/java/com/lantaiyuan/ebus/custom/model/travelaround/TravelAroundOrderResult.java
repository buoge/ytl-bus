package com.lantaiyuan.ebus.custom.model.travelaround;

import java.math.BigDecimal;

import com.lantaiyuan.ebus.custom.model.BaseComparableOrder;

/**
 * 周边游订单详情表
 * TravelAroundOrder
 * 数据库表：base_booktravel
 */
public class TravelAroundOrderResult extends BaseComparableOrder {

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
     * 周边游订单状态：0-未支付 1-已支付 2-已取消 3-已完成 4-已失效
     * 表字段 : base_booktravel.status
     */
    private String status;

    private String orderNo;
    
    /**
     * 票数
     * 表字段 : base_booktravel.ticket_num
     */
    private Integer ticketNum;
    
    /**
     * 原价
     * 表字段 : travel_around.original_price
     */
    private BigDecimal originalPrice;

    /**
     * 现价
     * 表字段 : travel_around.current_price
     */
    private BigDecimal currentPrice;
    
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

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getTicketNum() {
		return ticketNum;
	}

	public void setTicketNum(Integer ticketNum) {
		this.ticketNum = ticketNum;
	}

	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}

	public BigDecimal getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(BigDecimal currentPrice) {
		this.currentPrice = currentPrice;
	}
}