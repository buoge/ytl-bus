package com.lantaiyuan.ebus.model;

import java.util.Date;

import org.lanqiao.ssm.common.model.BaseModel;

/**
 * 
 * NoticeHistory
 * 数据库表：WEATHER_NOTICE_HISTORY
 */
public class NoticeHistoryQueryModel extends BaseModel<NoticeHistory> {

    /**
     * 
     */
    private static final long serialVersionUID = -7731503406686687571L;

    /**
     * 主键
     * 表字段 : WEATHER_NOTICE_HISTORY.ID
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
}