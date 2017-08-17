package com.lantaiyuan.ebus.custom.model;

import java.math.BigDecimal;
import java.util.Date;
import org.lanqiao.ssm.common.model.BaseModel;

/**
 * 
  * @ClassName: BookBusQueryModel
  * @author Yuan.Tan
  * @date 2016年11月8日 上午11:44:44
  *
 */
public class BookBusQueryModel extends BaseModel<BookBus> {
	private static final long serialVersionUID = -8211951135250380931L;

	/**
     * 商品Id
     * 表字段 : base_bookbus.goodsId
     */
    private String goodsid;

    /**
     * 起点
     * 表字段 : base_bookbus.sourceLocation
     */
    private String sourcelocation;

    /**
     * 终点
     * 表字段 : base_bookbus.targetLocation
     */
    private String targetlocation;

    /**
     * 出发时间
     * 表字段 : base_bookbus.startTime
     */
    private String starttime;

    /**
     * 返回时间
     * 表字段 : base_bookbus.backTime
     */
    private String backtime;

    /**
     * 乘客人数
     * 表字段 : base_bookbus.passengerNum
     */
    private Integer passengernum;

    /**
     * 联系人
     * 表字段 : base_bookbus.contactName
     */
    private String contactname;

    /**
     * 联系电话
     * 表字段 : base_bookbus.contactPhone
     */
    private String contactphone;

    /**
     * 备注
     * 表字段 : base_bookbus.remark
     */
    private String remark;

    /**
     * 包车类型（1-单程包车 2-往返包车 3-包天包车）
     * 表字段 : base_bookbus.bookBusType
     */
    private Integer bookbustype;

    /**
     * 报价（单位：元）
     * 表字段 : base_bookbus.quotedPrice
     */
    private BigDecimal quotedprice;

    /**
     * 报价时间
     * 表字段 : base_bookbus.quotedTime
     */
    private Date quotedtime;

    /**
     * 报价员id
     * 表字段 : base_bookbus.quotedId
     */
    private String quotedid;

    /**
     * 报价员姓名
     * 表字段 : base_bookbus.quotedName
     */
    private String quotedname;

    /**
     * 包车状态（0-待报价 1-待付款 2-待派车 3-已取消）
     * 表字段 : base_bookbus.status
     */
    private Integer status;

    private String citycode;
    
    private String orderNo;
    
    private Integer orderStatus;
    
    public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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

	/**
     * 获取 商品Id 字段:base_bookbus.goodsId
     *
     * @return base_bookbus.goodsId, 商品Id
     */
    public String getGoodsid() {
        return goodsid;
    }

    /**
     * 设置 商品Id 字段:base_bookbus.goodsId
     *
     * @param goodsid the value for base_bookbus.goodsId, 商品Id
     */
    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid == null ? null : goodsid.trim();
    }

    /**
     * 获取 起点 字段:base_bookbus.sourceLocation
     *
     * @return base_bookbus.sourceLocation, 起点
     */
    public String getSourcelocation() {
        return sourcelocation;
    }

    /**
     * 设置 起点 字段:base_bookbus.sourceLocation
     *
     * @param sourcelocation the value for base_bookbus.sourceLocation, 起点
     */
    public void setSourcelocation(String sourcelocation) {
        this.sourcelocation = sourcelocation == null ? null : sourcelocation.trim();
    }

    /**
     * 获取 终点 字段:base_bookbus.targetLocation
     *
     * @return base_bookbus.targetLocation, 终点
     */
    public String getTargetlocation() {
        return targetlocation;
    }

    /**
     * 设置 终点 字段:base_bookbus.targetLocation
     *
     * @param targetlocation the value for base_bookbus.targetLocation, 终点
     */
    public void setTargetlocation(String targetlocation) {
        this.targetlocation = targetlocation == null ? null : targetlocation.trim();
    }

    /**
     * 获取 出发时间 字段:base_bookbus.startTime
     *
     * @return base_bookbus.startTime, 出发时间
     */
    public String getStarttime() {
        return starttime;
    }

    /**
     * 设置 出发时间 字段:base_bookbus.startTime
     *
     * @param starttime the value for base_bookbus.startTime, 出发时间
     */
    public void setStarttime(String starttime) {
        this.starttime = starttime == null ? null : starttime.trim();
    }

    /**
     * 获取 返回时间 字段:base_bookbus.backTime
     *
     * @return base_bookbus.backTime, 返回时间
     */
    public String getBacktime() {
        return backtime;
    }

    /**
     * 设置 返回时间 字段:base_bookbus.backTime
     *
     * @param backtime the value for base_bookbus.backTime, 返回时间
     */
    public void setBacktime(String backtime) {
        this.backtime = backtime == null ? null : backtime.trim();
    }

    /**
     * 获取 乘客人数 字段:base_bookbus.passengerNum
     *
     * @return base_bookbus.passengerNum, 乘客人数
     */
    public Integer getPassengernum() {
        return passengernum;
    }

    /**
     * 设置 乘客人数 字段:base_bookbus.passengerNum
     *
     * @param passengernum the value for base_bookbus.passengerNum, 乘客人数
     */
    public void setPassengernum(Integer passengernum) {
        this.passengernum = passengernum;
    }

    /**
     * 获取 联系人 字段:base_bookbus.contactName
     *
     * @return base_bookbus.contactName, 联系人
     */
    public String getContactname() {
        return contactname;
    }

    /**
     * 设置 联系人 字段:base_bookbus.contactName
     *
     * @param contactname the value for base_bookbus.contactName, 联系人
     */
    public void setContactname(String contactname) {
        this.contactname = contactname == null ? null : contactname.trim();
    }

    /**
     * 获取 联系电话 字段:base_bookbus.contactPhone
     *
     * @return base_bookbus.contactPhone, 联系电话
     */
    public String getContactphone() {
        return contactphone;
    }

    /**
     * 设置 联系电话 字段:base_bookbus.contactPhone
     *
     * @param contactphone the value for base_bookbus.contactPhone, 联系电话
     */
    public void setContactphone(String contactphone) {
        this.contactphone = contactphone == null ? null : contactphone.trim();
    }

    /**
     * 获取 备注 字段:base_bookbus.remark
     *
     * @return base_bookbus.remark, 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置 备注 字段:base_bookbus.remark
     *
     * @param remark the value for base_bookbus.remark, 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取 包车类型（1-单程包车 2-往返包车 3-包天包车） 字段:base_bookbus.bookBusType
     *
     * @return base_bookbus.bookBusType, 包车类型（1-单程包车 2-往返包车 3-包天包车）
     */
    public Integer getBookbustype() {
        return bookbustype;
    }

    /**
     * 设置 包车类型（1-单程包车 2-往返包车 3-包天包车） 字段:base_bookbus.bookBusType
     *
     * @param bookbustype the value for base_bookbus.bookBusType, 包车类型（1-单程包车 2-往返包车 3-包天包车）
     */
    public void setBookbustype(Integer bookbustype) {
        this.bookbustype = bookbustype;
    }

    /**
     * 获取 报价（单位：元） 字段:base_bookbus.quotedPrice
     *
     * @return base_bookbus.quotedPrice, 报价（单位：元）
     */
    public BigDecimal getQuotedprice() {
        return quotedprice;
    }

    /**
     * 设置 报价（单位：元） 字段:base_bookbus.quotedPrice
     *
     * @param quotedprice the value for base_bookbus.quotedPrice, 报价（单位：元）
     */
    public void setQuotedprice(BigDecimal quotedprice) {
        this.quotedprice = quotedprice;
    }

    /**
     * 获取 报价时间 字段:base_bookbus.quotedTime
     *
     * @return base_bookbus.quotedTime, 报价时间
     */
    public Date getQuotedtime() {
        return quotedtime;
    }

    /**
     * 设置 报价时间 字段:base_bookbus.quotedTime
     *
     * @param quotedtime the value for base_bookbus.quotedTime, 报价时间
     */
    public void setQuotedtime(Date quotedtime) {
        this.quotedtime = quotedtime;
    }

    /**
     * 获取 报价员id 字段:base_bookbus.quotedId
     *
     * @return base_bookbus.quotedId, 报价员id
     */
    public String getQuotedid() {
        return quotedid;
    }

    /**
     * 设置 报价员id 字段:base_bookbus.quotedId
     *
     * @param quotedid the value for base_bookbus.quotedId, 报价员id
     */
    public void setQuotedid(String quotedid) {
        this.quotedid = quotedid == null ? null : quotedid.trim();
    }

    /**
     * 获取 报价员姓名 字段:base_bookbus.quotedName
     *
     * @return base_bookbus.quotedName, 报价员姓名
     */
    public String getQuotedname() {
        return quotedname;
    }

    /**
     * 设置 报价员姓名 字段:base_bookbus.quotedName
     *
     * @param quotedname the value for base_bookbus.quotedName, 报价员姓名
     */
    public void setQuotedname(String quotedname) {
        this.quotedname = quotedname == null ? null : quotedname.trim();
    }

    /**
     * 获取 包车状态（0-待报价 1-待付款 2-待派车 3-已取消） 字段:base_bookbus.status
     *
     * @return base_bookbus.status, 包车状态（0-待报价 1-待付款 2-待派车 3-已取消）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置 包车状态（0-待报价 1-待付款 2-待派车 3-已取消） 字段:base_bookbus.status
     *
     * @param status the value for base_bookbus.status, 包车状态（0-待报价 1-待付款 2-待派车 3-已取消）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}