package com.lantaiyuan.ebus.custom.model;

import java.util.Date;

import org.lanqiao.ssm.common.model.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 常用问题表
 * CommonQuestion
 * 数据库表：base_common_question
 */
public class CommonQuestion extends Model {

	private static final long serialVersionUID = -5006366780460918466L;

    /**
     * 自增主键
     * 表字段 : base_common_question.id
     */
    private Integer id;

    /**
     * 问题类型:2-定制 3-周边游 4-充值 5-失物招领 6-公交 7-账号 8-其他
     * 表字段 : base_common_question.question_type
     */
    private Byte questionType;

    /**
     * 标题
     * 表字段 : base_common_question.question_title
     */
    private String questionTitle;

    /**
     * 图片url
     * 表字段 : base_common_question.question_icon_url
     */
    private String questionIconUrl;

    /**
     * 内容
     * 表字段 : base_common_question.question_content
     */
    private String questionContent;

    /**
     * 创建时间
     * 表字段 : base_common_question.gmt_create
     */
    private Date gmtCreate;

    /**
     * 修改时间
     * 表字段 : base_common_question.gmt_modified
     */
    private Date gmtModified;

    /**
     * 城市编码
     * 表字段 : base_common_question.city_code
     */
    private String cityCode;

    /**
     * 获取 自增主键 字段:base_common_question.id
     *
     * @return base_common_question.id, 自增主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 自增主键 字段:base_common_question.id
     *
     * @param id the value for base_common_question.id, 自增主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 问题类型:2-定制 3-周边游 4-充值 5-失物招领 6-公交 7-账号 8-其他 字段:base_common_question.question_type
     *
     * @return base_common_question.question_type, 问题类型:2-定制 3-周边游 4-充值 5-失物招领 6-公交 7-账号 8-其他
     */
    public Byte getQuestionType() {
        return questionType;
    }

    /**
     * 设置 问题类型:2-定制 3-周边游 4-充值 5-失物招领 6-公交 7-账号 8-其他 字段:base_common_question.question_type
     *
     * @param questionType the value for base_common_question.question_type, 问题类型:2-定制 3-周边游 4-充值 5-失物招领 6-公交 7-账号 8-其他
     */
    public void setQuestionType(Byte questionType) {
        this.questionType = questionType;
    }

    /**
     * 获取 标题 字段:base_common_question.question_title
     *
     * @return base_common_question.question_title, 标题
     */
    public String getQuestionTitle() {
        return questionTitle;
    }

    /**
     * 设置 标题 字段:base_common_question.question_title
     *
     * @param questionTitle the value for base_common_question.question_title, 标题
     */
    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle == null ? null : questionTitle.trim();
    }

    /**
     * 获取 图片url 字段:base_common_question.question_icon_url
     *
     * @return base_common_question.question_icon_url, 图片url
     */
    public String getQuestionIconUrl() {
        return questionIconUrl;
    }

    /**
     * 设置 图片url 字段:base_common_question.question_icon_url
     *
     * @param questionIconUrl the value for base_common_question.question_icon_url, 图片url
     */
    public void setQuestionIconUrl(String questionIconUrl) {
        this.questionIconUrl = questionIconUrl == null ? null : questionIconUrl.trim();
    }

    /**
     * 获取 内容 字段:base_common_question.question_content
     *
     * @return base_common_question.question_content, 内容
     */
    public String getQuestionContent() {
        return questionContent;
    }

    /**
     * 设置 内容 字段:base_common_question.question_content
     *
     * @param questionContent the value for base_common_question.question_content, 内容
     */
    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent == null ? null : questionContent.trim();
    }

    /**
     * 获取 创建时间 字段:base_common_question.gmt_create
     *
     * @return base_common_question.gmt_create, 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置 创建时间 字段:base_common_question.gmt_create
     *
     * @param gmtCreate the value for base_common_question.gmt_create, 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取 修改时间 字段:base_common_question.gmt_modified
     *
     * @return base_common_question.gmt_modified, 修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置 修改时间 字段:base_common_question.gmt_modified
     *
     * @param gmtModified the value for base_common_question.gmt_modified, 修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取 城市编码 字段:base_common_question.city_code
     *
     * @return base_common_question.city_code, 城市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置 城市编码 字段:base_common_question.city_code
     *
     * @param cityCode the value for base_common_question.city_code, 城市编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }
}