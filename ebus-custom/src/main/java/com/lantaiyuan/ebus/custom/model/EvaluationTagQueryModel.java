package com.lantaiyuan.ebus.custom.model;

import java.util.Date;

import org.lanqiao.ssm.common.model.BaseModel;

/**
 * 
 * EvaluationTag
 * 数据库表：base_evaluation_tag
 */
public class EvaluationTagQueryModel extends BaseModel<EvaluationTag>{

    /**
     * 
     */
    private static final long serialVersionUID = -1283709676749925985L;

    /**
     * 主键
     * 表字段 : base_evaluation_tag.ID
     */
    private String id;

    /**
     * 星级
     * 表字段 : base_evaluation_tag.STAR_LEVEL
     */
    private Integer starLevel;

    /**
     * 标签名称
     * 表字段 : base_evaluation_tag.TAG_NAME
     */
    private String tagName;

    /**
     * 被使用次数
     * 表字段 : base_evaluation_tag.COUNT
     */
    private Integer count;

    /**
     * 创建时间
     * 表字段 : base_evaluation_tag.CREATE_TIME
     */
    private Date createTime;

    /**
     * 获取 主键 字段:base_evaluation_tag.ID
     *
     * @return base_evaluation_tag.ID, 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 主键 字段:base_evaluation_tag.ID
     *
     * @param id the value for base_evaluation_tag.ID, 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 星级 字段:base_evaluation_tag.STAR_LEVEL
     *
     * @return base_evaluation_tag.STAR_LEVEL, 星级
     */
    public Integer getStarLevel() {
        return starLevel;
    }

    /**
     * 设置 星级 字段:base_evaluation_tag.STAR_LEVEL
     *
     * @param starLevel the value for base_evaluation_tag.STAR_LEVEL, 星级
     */
    public void setStarLevel(Integer starLevel) {
        this.starLevel = starLevel;
    }

    /**
     * 获取 标签名称 字段:base_evaluation_tag.TAG_NAME
     *
     * @return base_evaluation_tag.TAG_NAME, 标签名称
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * 设置 标签名称 字段:base_evaluation_tag.TAG_NAME
     *
     * @param tagName the value for base_evaluation_tag.TAG_NAME, 标签名称
     */
    public void setTagName(String tagName) {
        this.tagName = tagName == null ? null : tagName.trim();
    }

    /**
     * 获取 被使用次数 字段:base_evaluation_tag.COUNT
     *
     * @return base_evaluation_tag.COUNT, 被使用次数
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置 被使用次数 字段:base_evaluation_tag.COUNT
     *
     * @param count the value for base_evaluation_tag.COUNT, 被使用次数
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 获取 创建时间 字段:base_evaluation_tag.CREATE_TIME
     *
     * @return base_evaluation_tag.CREATE_TIME, 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 字段:base_evaluation_tag.CREATE_TIME
     *
     * @param createTime the value for base_evaluation_tag.CREATE_TIME, 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}