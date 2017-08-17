package com.lantaiyuan.ebus.custom.model;

import org.lanqiao.ssm.common.model.Model;

/**
 * 描述:在地图上打点的对象
 * 作者:温海金
 * 最后更改时间:下午2:19:41
 */

public class NoticePoint extends Model {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3955543686946210559L;    
	/**
     * 主键
     * 表字段 : weather_notice_point.id
     */
    private String id;

    /**
     * 通知主键
     * 表字段 : weather_notice_point.noticeId
     */
    private String noticeid;

    /**
     * 经度
     * 表字段 : weather_notice_point.longitude
     */
    private Double longitude;

    /**
     * 纬度
     * 表字段 : weather_notice_point.latitude
     */
    private Double latitude;

    /**
     * 获取 主键 字段:weather_notice_point.id
     *
     * @return weather_notice_point.id, 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 主键 字段:weather_notice_point.id
     *
     * @param id the value for weather_notice_point.id, 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 通知主键 字段:weather_notice_point.noticeId
     *
     * @return weather_notice_point.noticeId, 通知主键
     */
    public String getNoticeid() {
        return noticeid;
    }

    /**
     * 设置 通知主键 字段:weather_notice_point.noticeId
     *
     * @param noticeid the value for weather_notice_point.noticeId, 通知主键
     */
    public void setNoticeid(String noticeid) {
        this.noticeid = noticeid == null ? null : noticeid.trim();
    }

    /**
     * 获取 经度 字段:weather_notice_point.longitude
     *
     * @return weather_notice_point.longitude, 经度
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * 设置 经度 字段:weather_notice_point.longitude
     *
     * @param longitude the value for weather_notice_point.longitude, 经度
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * 获取 纬度 字段:weather_notice_point.latitude
     *
     * @return weather_notice_point.latitude, 纬度
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * 设置 纬度 字段:weather_notice_point.latitude
     *
     * @param latitude the value for weather_notice_point.latitude, 纬度
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}