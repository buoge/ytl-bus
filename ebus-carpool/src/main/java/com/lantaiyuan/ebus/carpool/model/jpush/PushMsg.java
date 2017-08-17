package com.lantaiyuan.ebus.carpool.model.jpush;

import java.util.Date;

import org.lanqiao.ssm.common.model.Model;

/**
 * 记录拼车过程中推送的消息
 * pushMsg
 * 数据库表：carpool_push_msg
 */
public class PushMsg extends Model {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4270627446586723366L;

	/**
     * 主键
     * 表字段 : carpool_push_msg.id
     */
    private Long id;

    /**
     * 订单号
     * 表字段 : carpool_push_msg.order_no
     */
    private String orderNo;

    /**
     * 消息标题
     * 表字段 : carpool_push_msg.push_title
     */
    private String pushTitle;

    /**
     * 用户id
     * 表字段 : carpool_push_msg.user_id
     */
    private Integer userId;

    /**
     * 推送内容
     * 表字段 : carpool_push_msg.push_msg
     */
    private String pushMsg;

    /**
     * 推送类型（1-通知 2-消息）
     * 表字段 : carpool_push_msg.push_type
     */
    private Byte pushType;

    /**
     * 图标存储地址
     * 表字段 : carpool_push_msg.img_url
     */
    private String imgUrl;

    /**
     * 城市编码
     * 表字段 : carpool_push_msg.city_code
     */
    private String cityCode;

    /**
     * 
     * 表字段 : carpool_push_msg.gmt_create
     */
    private Date gmtCreate;

    /**
     * 
     * 表字段 : carpool_push_msg.gmt_modified
     */
    private Date gmtModified;

    /**
     * 
     * 表字段 : carpool_push_msg.field1
     */
    private String field1;

    /**
     * 
     * 表字段 : carpool_push_msg.field2
     */
    private String field2;

    /**
     * 
     * 表字段 : carpool_push_msg.field3
     */
    private String field3;

    
    public PushMsg() {
		super();
	}
    
    public PushMsg(String orderNo, String pushTitle, Integer userId, String pushMsg, String cityCode) {
		super();
		this.orderNo = orderNo;
		this.pushTitle = pushTitle;
		this.userId = userId;
		this.pushMsg = pushMsg;
		this.cityCode = cityCode;
		this.pushType = 1;
	}

	/**
     * 获取 主键 字段:carpool_push_msg.id
     *
     * @return carpool_push_msg.id, 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 主键 字段:carpool_push_msg.id
     *
     * @param id the value for carpool_push_msg.id, 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 订单号 字段:carpool_push_msg.order_no
     *
     * @return carpool_push_msg.order_no, 订单号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 设置 订单号 字段:carpool_push_msg.order_no
     *
     * @param orderNo the value for carpool_push_msg.order_no, 订单号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * 获取 消息标题 字段:carpool_push_msg.push_title
     *
     * @return carpool_push_msg.push_title, 消息标题
     */
    public String getPushTitle() {
        return pushTitle;
    }

    /**
     * 设置 消息标题 字段:carpool_push_msg.push_title
     *
     * @param pushTitle the value for carpool_push_msg.push_title, 消息标题
     */
    public void setPushTitle(String pushTitle) {
        this.pushTitle = pushTitle == null ? null : pushTitle.trim();
    }

    /**
     * 获取 用户id 字段:carpool_push_msg.user_id
     *
     * @return carpool_push_msg.user_id, 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置 用户id 字段:carpool_push_msg.user_id
     *
     * @param userId the value for carpool_push_msg.user_id, 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取 推送内容 字段:carpool_push_msg.push_msg
     *
     * @return carpool_push_msg.push_msg, 推送内容
     */
    public String getPushMsg() {
        return pushMsg;
    }

    /**
     * 设置 推送内容 字段:carpool_push_msg.push_msg
     *
     * @param pushMsg the value for carpool_push_msg.push_msg, 推送内容
     */
    public void setPushMsg(String pushMsg) {
        this.pushMsg = pushMsg == null ? null : pushMsg.trim();
    }

    /**
     * 获取 推送类型（1-通知 2-消息） 字段:carpool_push_msg.push_type
     *
     * @return carpool_push_msg.push_type, 推送类型（1-通知 2-消息）
     */
    public Byte getPushType() {
        return pushType;
    }

    /**
     * 设置 推送类型（1-通知 2-消息） 字段:carpool_push_msg.push_type
     *
     * @param pushType the value for carpool_push_msg.push_type, 推送类型（1-通知 2-消息）
     */
    public void setPushType(Byte pushType) {
        this.pushType = pushType;
    }

    /**
     * 获取 图标存储地址 字段:carpool_push_msg.img_url
     *
     * @return carpool_push_msg.img_url, 图标存储地址
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 设置 图标存储地址 字段:carpool_push_msg.img_url
     *
     * @param imgUrl the value for carpool_push_msg.img_url, 图标存储地址
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * 获取 城市编码 字段:carpool_push_msg.city_code
     *
     * @return carpool_push_msg.city_code, 城市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置 城市编码 字段:carpool_push_msg.city_code
     *
     * @param cityCode the value for carpool_push_msg.city_code, 城市编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * 获取  字段:carpool_push_msg.gmt_create
     *
     * @return carpool_push_msg.gmt_create, 
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置  字段:carpool_push_msg.gmt_create
     *
     * @param gmtCreate the value for carpool_push_msg.gmt_create, 
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取  字段:carpool_push_msg.gmt_modified
     *
     * @return carpool_push_msg.gmt_modified, 
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置  字段:carpool_push_msg.gmt_modified
     *
     * @param gmtModified the value for carpool_push_msg.gmt_modified, 
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取  字段:carpool_push_msg.field1
     *
     * @return carpool_push_msg.field1, 
     */
    public String getField1() {
        return field1;
    }

    /**
     * 设置  字段:carpool_push_msg.field1
     *
     * @param field1 the value for carpool_push_msg.field1, 
     */
    public void setField1(String field1) {
        this.field1 = field1 == null ? null : field1.trim();
    }

    /**
     * 获取  字段:carpool_push_msg.field2
     *
     * @return carpool_push_msg.field2, 
     */
    public String getField2() {
        return field2;
    }

    /**
     * 设置  字段:carpool_push_msg.field2
     *
     * @param field2 the value for carpool_push_msg.field2, 
     */
    public void setField2(String field2) {
        this.field2 = field2 == null ? null : field2.trim();
    }

    /**
     * 获取  字段:carpool_push_msg.field3
     *
     * @return carpool_push_msg.field3, 
     */
    public String getField3() {
        return field3;
    }

    /**
     * 设置  字段:carpool_push_msg.field3
     *
     * @param field3 the value for carpool_push_msg.field3, 
     */
    public void setField3(String field3) {
        this.field3 = field3 == null ? null : field3.trim();
    }
}