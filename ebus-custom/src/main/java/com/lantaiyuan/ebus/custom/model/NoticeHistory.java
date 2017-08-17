package com.lantaiyuan.ebus.custom.model;

import java.util.Date;
import java.util.UUID;

import org.lanqiao.ssm.common.model.Model;

/**
 * 
 * NoticeHistory
 * 数据库表：WEATHER_NOTICE_HISTORY
 */
public class NoticeHistory extends Model {

    /**
     * 
     */
    private static final long serialVersionUID = -2939414598436343246L;

    /**
     * 主键
     * 表字段 : weather_notice_history.ID
     */
    private String id;

    /**
     * 天气紧急通知ID
     * 表字段 : WEATHER_NOTICE_HISTORY.NOTICE_ID
     */
    private String noticeId;

    /**
     * APP用户ID
     * 表字段 : WEATHER_NOTICE_HISTORY.USER_ID
     */
    private String userId;

    /**
     * 创建时间
     * 表字段 : WEATHER_NOTICE_HISTORY.CREATE_TIME
     */
    private Date createTime;

    /**
     * 通知内容
     */
    private String content;
    
    /**
     * 公交公司标题
     */
    private String busCompanyTitle;
    
    /**
     * 公交公司图标地址
     */
    private String imgUrl;
    
    /**
     * 获取 主键 字段:WEATHER_NOTICE_HISTORY.ID
     *
     * @return WEATHER_NOTICE_HISTORY.ID, 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 主键 字段:WEATHER_NOTICE_HISTORY.ID
     *
     * @param id the value for WEATHER_NOTICE_HISTORY.ID, 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 天气紧急通知ID 字段:WEATHER_NOTICE_HISTORY.NOTICE_ID
     *
     * @return WEATHER_NOTICE_HISTORY.NOTICE_ID, 天气紧急通知ID
     */
    public String getNoticeId() {
        return noticeId;
    }

    /**
     * 设置 天气紧急通知ID 字段:WEATHER_NOTICE_HISTORY.NOTICE_ID
     *
     * @param noticeId the value for WEATHER_NOTICE_HISTORY.NOTICE_ID, 天气紧急通知ID
     */
    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId == null ? null : noticeId.trim();
    }

    /**
     * 获取 APP用户ID 字段:WEATHER_NOTICE_HISTORY.USER_ID
     *
     * @return WEATHER_NOTICE_HISTORY.USER_ID, APP用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置 APP用户ID 字段:WEATHER_NOTICE_HISTORY.USER_ID
     *
     * @param userId the value for WEATHER_NOTICE_HISTORY.USER_ID, APP用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    
    public String getBusCompanyTitle() {
		return busCompanyTitle;
	}

	public void setBusCompanyTitle(String busCompanyTitle) {
		this.busCompanyTitle = busCompanyTitle;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	/**
     * 获取 创建时间 字段:WEATHER_NOTICE_HISTORY.CREATE_TIME
     *
     * @return WEATHER_NOTICE_HISTORY.CREATE_TIME, 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 字段:WEATHER_NOTICE_HISTORY.CREATE_TIME
     *
     * @param createTime the value for WEATHER_NOTICE_HISTORY.CREATE_TIME, 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	
	
	public NoticeHistory() {
	}

	public NoticeHistory(String noticeId, String userId, String content) {
		super();
		this.id = UUID.randomUUID().toString();
		this.noticeId = noticeId;
		this.userId = userId;
		this.content = content;
	}

	public NoticeHistory(String noticeId, String userId, String content, String busCompanyTitle, String imgUrl) {
		super();
		this.noticeId = noticeId;
		this.userId = userId;
		this.content = content;
		this.busCompanyTitle = busCompanyTitle;
		this.imgUrl = imgUrl;
	}
	
}