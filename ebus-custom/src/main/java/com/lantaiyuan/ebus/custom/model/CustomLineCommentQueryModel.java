package com.lantaiyuan.ebus.custom.model;

import java.util.Date;

import org.lanqiao.ssm.common.model.BaseModel;

/**
 * 专线加开申请表
 * CustomLineComment
 * 数据库表：base_custom_line_comment
 */
public class CustomLineCommentQueryModel extends BaseModel<CustomLineComment> {

    /**
	  * @Fields serialVersionUID :
	  */
	private static final long serialVersionUID = 1L;

	/**
     * 主键
     * 表字段 : base_custom_line_comment.id
     */
    private Integer id;

    /**
     * 线路id
     * 表字段 : base_custom_line_comment.routeId
     */
    private String routeid;

    /**
     * 乘车时间
     * 表字段 : base_custom_line_comment.takeTime
     */
    private String taketime;

    /**
     * 起点
     * 表字段 : base_custom_line_comment.startStation
     */
    private String startstation;

    /**
     * 终点
     * 表字段 : base_custom_line_comment.endStation
     */
    private String endstation;

    /**
     * 城市编码
     * 表字段 : base_custom_line_comment.cityCode
     */
    private String citycode;

    /**
     * 申请加开专线人ID
     * 表字段 : base_custom_line_comment.userId
     */
    private Integer userid;

    /**
     * 加开建议
     * 表字段 : base_custom_line_comment.comment
     */
    private String comment;

    /**
     * 创建时间
     * 表字段 : base_custom_line_comment.createTime
     */
    private Date createtime;

    /**
     * 获取 主键 字段:base_custom_line_comment.id
     *
     * @return base_custom_line_comment.id, 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 主键 字段:base_custom_line_comment.id
     *
     * @param id the value for base_custom_line_comment.id, 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 线路id 字段:base_custom_line_comment.routeId
     *
     * @return base_custom_line_comment.routeId, 线路id
     */
    public String getRouteid() {
        return routeid;
    }

    /**
     * 设置 线路id 字段:base_custom_line_comment.routeId
     *
     * @param routeid the value for base_custom_line_comment.routeId, 线路id
     */
    public void setRouteid(String routeid) {
        this.routeid = routeid == null ? null : routeid.trim();
    }

    /**
     * 获取 乘车时间 字段:base_custom_line_comment.takeTime
     *
     * @return base_custom_line_comment.takeTime, 乘车时间
     */
    public String getTaketime() {
        return taketime;
    }

    /**
     * 设置 乘车时间 字段:base_custom_line_comment.takeTime
     *
     * @param taketime the value for base_custom_line_comment.takeTime, 乘车时间
     */
    public void setTaketime(String taketime) {
        this.taketime = taketime == null ? null : taketime.trim();
    }

    /**
     * 获取 起点 字段:base_custom_line_comment.startStation
     *
     * @return base_custom_line_comment.startStation, 起点
     */
    public String getStartstation() {
        return startstation;
    }

    /**
     * 设置 起点 字段:base_custom_line_comment.startStation
     *
     * @param startstation the value for base_custom_line_comment.startStation, 起点
     */
    public void setStartstation(String startstation) {
        this.startstation = startstation == null ? null : startstation.trim();
    }

    /**
     * 获取 终点 字段:base_custom_line_comment.endStation
     *
     * @return base_custom_line_comment.endStation, 终点
     */
    public String getEndstation() {
        return endstation;
    }

    /**
     * 设置 终点 字段:base_custom_line_comment.endStation
     *
     * @param endstation the value for base_custom_line_comment.endStation, 终点
     */
    public void setEndstation(String endstation) {
        this.endstation = endstation == null ? null : endstation.trim();
    }

    /**
     * 获取 城市编码 字段:base_custom_line_comment.cityCode
     *
     * @return base_custom_line_comment.cityCode, 城市编码
     */
    public String getCitycode() {
        return citycode;
    }

    /**
     * 设置 城市编码 字段:base_custom_line_comment.cityCode
     *
     * @param citycode the value for base_custom_line_comment.cityCode, 城市编码
     */
    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }

    /**
     * 获取 申请加开专线人ID 字段:base_custom_line_comment.userId
     *
     * @return base_custom_line_comment.userId, 申请加开专线人ID
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 设置 申请加开专线人ID 字段:base_custom_line_comment.userId
     *
     * @param userid the value for base_custom_line_comment.userId, 申请加开专线人ID
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 获取 加开建议 字段:base_custom_line_comment.comment
     *
     * @return base_custom_line_comment.comment, 加开建议
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置 加开建议 字段:base_custom_line_comment.comment
     *
     * @param comment the value for base_custom_line_comment.comment, 加开建议
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    /**
     * 获取 创建时间 字段:base_custom_line_comment.createTime
     *
     * @return base_custom_line_comment.createTime, 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置 创建时间 字段:base_custom_line_comment.createTime
     *
     * @param createtime the value for base_custom_line_comment.createTime, 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}