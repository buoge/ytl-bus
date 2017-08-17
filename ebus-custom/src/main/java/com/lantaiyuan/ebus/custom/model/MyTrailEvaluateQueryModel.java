package com.lantaiyuan.ebus.custom.model;

import java.util.Date;

import org.lanqiao.ssm.common.model.BaseModel;

/**
 * 
 * MyTrailEvaluate
 * 数据库表：my_trail_evaluate
 */
public class MyTrailEvaluateQueryModel extends BaseModel<MyTrailEvaluate>{

    /**
     * 
     */
    private static final long serialVersionUID = -1923546442151052330L;

    /**
     * 主键
     * 表字段 : my_trail_evaluate.ID
     */
    private String id;

    /**
     * 评价类型（1：个人行程评价）
     * 表字段 : my_trail_evaluate.TYPE
     */
    private Integer type;

    /**
     * 行程ID
     * 表字段 : my_trail_evaluate.TRAIL_ID
     */
    private Integer trailId;

    /**
     * 用户ID
     * 表字段 : my_trail_evaluate.USER_ID
     */
    private Integer userId;

    /**
     * 评价内容
     * 表字段 : my_trail_evaluate.CONTENT
     */
    private String content;

    /**
     * 城市编码
     * 表字段 : my_trail_evaluate.CITY_CODE
     */
    private String cityCode;

    /**
     * 评分
     * 表字段 : my_trail_evaluate.SCORE
     */
    private Integer score;

    /**
     * 创建时间
     * 表字段 : my_trail_evaluate.CREATE_TIME
     */
    private Date createTime;

    /**
     * 获取 主键 字段:my_trail_evaluate.ID
     *
     * @return my_trail_evaluate.ID, 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 主键 字段:my_trail_evaluate.ID
     *
     * @param id the value for my_trail_evaluate.ID, 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 评价类型（1：个人行程评价） 字段:my_trail_evaluate.TYPE
     *
     * @return my_trail_evaluate.TYPE, 评价类型（1：个人行程评价）
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置 评价类型（1：个人行程评价） 字段:my_trail_evaluate.TYPE
     *
     * @param type the value for my_trail_evaluate.TYPE, 评价类型（1：个人行程评价）
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取 行程ID 字段:my_trail_evaluate.TRAIL_ID
     *
     * @return my_trail_evaluate.TRAIL_ID, 行程ID
     */
    public Integer getTrailId() {
        return trailId;
    }

    /**
     * 设置 行程ID 字段:my_trail_evaluate.TRAIL_ID
     *
     * @param trailId the value for my_trail_evaluate.TRAIL_ID, 行程ID
     */
    public void setTrailId(Integer trailId) {
        this.trailId = trailId;
    }

    /**
     * 获取 用户ID 字段:my_trail_evaluate.USER_ID
     *
     * @return my_trail_evaluate.USER_ID, 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置 用户ID 字段:my_trail_evaluate.USER_ID
     *
     * @param userId the value for my_trail_evaluate.USER_ID, 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取 评价内容 字段:my_trail_evaluate.CONTENT
     *
     * @return my_trail_evaluate.CONTENT, 评价内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置 评价内容 字段:my_trail_evaluate.CONTENT
     *
     * @param content the value for my_trail_evaluate.CONTENT, 评价内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取 城市编码 字段:my_trail_evaluate.CITY_CODE
     *
     * @return my_trail_evaluate.CITY_CODE, 城市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置 城市编码 字段:my_trail_evaluate.CITY_CODE
     *
     * @param cityCode the value for my_trail_evaluate.CITY_CODE, 城市编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * 获取 评分 字段:my_trail_evaluate.SCORE
     *
     * @return my_trail_evaluate.SCORE, 评分
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 设置 评分 字段:my_trail_evaluate.SCORE
     *
     * @param score the value for my_trail_evaluate.SCORE, 评分
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 获取 创建时间 字段:my_trail_evaluate.CREATE_TIME
     *
     * @return my_trail_evaluate.CREATE_TIME, 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 字段:my_trail_evaluate.CREATE_TIME
     *
     * @param createTime the value for my_trail_evaluate.CREATE_TIME, 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}