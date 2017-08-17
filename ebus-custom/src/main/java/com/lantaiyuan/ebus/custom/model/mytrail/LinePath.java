package com.lantaiyuan.ebus.custom.model.mytrail;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 描述:我的行程中的轨迹打点信息
 * 作者:温海金
 * 最后更改时间:下午5:13:56
 */
public class LinePath {

    /**
     * ID
     * 表字段 : my_trail_line_path.id
     */
	@JsonIgnore
    private String id;

    /**
     * 行程ID
     * 表字段 : my_trail_line_path.myTrailId
     */
	@JsonIgnore
    private Integer mytrailid;

    /**
     * 经度
     * 表字段 : my_trail_line_path.longitude
     */
    private BigDecimal longitude;

    /**
     * 纬度
     * 表字段 : my_trail_line_path.latitude
     */
    private BigDecimal latitude;

    /**
     * 数据上传时间
     * 表字段 : my_trail_line_path.usePosTime
     */
    @JsonIgnore
    private Date usepostime;

    /**
     * 创建时间
     * 表字段 : my_trail_line_path.createTime
     */
    @JsonIgnore
    private Date createtime;

    /**
     * 获取 ID 字段:my_trail_line_path.id
     *
     * @return my_trail_line_path.id, ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 ID 字段:my_trail_line_path.id
     *
     * @param id the value for my_trail_line_path.id, ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 行程ID 字段:my_trail_line_path.myTrailId
     *
     * @return my_trail_line_path.myTrailId, 行程ID
     */
    public Integer getMytrailid() {
        return mytrailid;
    }

    /**
     * 设置 行程ID 字段:my_trail_line_path.myTrailId
     *
     * @param mytrailid the value for my_trail_line_path.myTrailId, 行程ID
     */
    public void setMytrailid(Integer mytrailid) {
        this.mytrailid = mytrailid;
    }

    /**
     * 获取 经度 字段:my_trail_line_path.longitude
     *
     * @return my_trail_line_path.longitude, 经度
     */
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
     * 设置 经度 字段:my_trail_line_path.longitude
     *
     * @param longitude the value for my_trail_line_path.longitude, 经度
     */
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    /**
     * 获取 纬度 字段:my_trail_line_path.latitude
     *
     * @return my_trail_line_path.latitude, 纬度
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * 设置 纬度 字段:my_trail_line_path.latitude
     *
     * @param latitude the value for my_trail_line_path.latitude, 纬度
     */
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    /**
     * 获取 数据上传时间 字段:my_trail_line_path.usePosTime
     *
     * @return my_trail_line_path.usePosTime, 数据上传时间
     */
    public Date getUsepostime() {
        return usepostime;
    }

    /**
     * 设置 数据上传时间 字段:my_trail_line_path.usePosTime
     *
     * @param usepostime the value for my_trail_line_path.usePosTime, 数据上传时间
     */
    public void setUsepostime(Date usepostime) {
        this.usepostime = usepostime;
    }

    /**
     * 获取 创建时间 字段:my_trail_line_path.createTime
     *
     * @return my_trail_line_path.createTime, 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置 创建时间 字段:my_trail_line_path.createTime
     *
     * @param createtime the value for my_trail_line_path.createTime, 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}