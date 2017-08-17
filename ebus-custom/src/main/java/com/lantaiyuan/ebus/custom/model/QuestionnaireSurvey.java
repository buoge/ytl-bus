package com.lantaiyuan.ebus.custom.model;

import java.util.Date;

import org.lanqiao.ssm.common.model.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 问卷调查
 * QuestionnaireSurvey
 * 数据库表：questionnaire_survey
 */
public class QuestionnaireSurvey extends Model{

	private static final long serialVersionUID = 2839831121752142504L;

	/**
     * 自增主键
     * 表字段 : questionnaire_survey.id
     */
    private Long id;

    /**
     * 问卷星中对应问卷的URL
     * 表字段 : questionnaire_survey.url
     */
    private String url;

    /**
     * 问卷标题
     * 表字段 : questionnaire_survey.title
     */
    private String title;

    /**
     * 创建时间
     * 表字段 : questionnaire_survey.gmt_create
     */
    private Date gmtCreate;

    /**
     * 最后一次修改时间
     * 表字段 : questionnaire_survey.gmt_modified
     */
    private Date gmtModified;

    /**
     * 备用字段1
     * 表字段 : questionnaire_survey.field1
     */
    @JsonIgnore
    private String field1;

    /**
     * 备用字段2
     * 表字段 : questionnaire_survey.field2
     */
    @JsonIgnore
    private String field2;

    /**
     * 备用字段3
     * 表字段 : questionnaire_survey.field3
     */
    @JsonIgnore
    private String field3;

    /**
     * 获取 自增主键 字段:questionnaire_survey.id
     *
     * @return questionnaire_survey.id, 自增主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 自增主键 字段:questionnaire_survey.id
     *
     * @param id the value for questionnaire_survey.id, 自增主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 问卷星中对应问卷的URL 字段:questionnaire_survey.url
     *
     * @return questionnaire_survey.url, 问卷星中对应问卷的URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置 问卷星中对应问卷的URL 字段:questionnaire_survey.url
     *
     * @param url the value for questionnaire_survey.url, 问卷星中对应问卷的URL
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取 问卷标题 字段:questionnaire_survey.title
     *
     * @return questionnaire_survey.title, 问卷标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置 问卷标题 字段:questionnaire_survey.title
     *
     * @param title the value for questionnaire_survey.title, 问卷标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取 创建时间 字段:questionnaire_survey.gmt_create
     *
     * @return questionnaire_survey.gmt_create, 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置 创建时间 字段:questionnaire_survey.gmt_create
     *
     * @param gmtCreate the value for questionnaire_survey.gmt_create, 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取 最后一次修改时间 字段:questionnaire_survey.gmt_modified
     *
     * @return questionnaire_survey.gmt_modified, 最后一次修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置 最后一次修改时间 字段:questionnaire_survey.gmt_modified
     *
     * @param gmtModified the value for questionnaire_survey.gmt_modified, 最后一次修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取 备用字段1 字段:questionnaire_survey.field1
     *
     * @return questionnaire_survey.field1, 备用字段1
     */
    public String getField1() {
        return field1;
    }

    /**
     * 设置 备用字段1 字段:questionnaire_survey.field1
     *
     * @param field1 the value for questionnaire_survey.field1, 备用字段1
     */
    public void setField1(String field1) {
        this.field1 = field1 == null ? null : field1.trim();
    }

    /**
     * 获取 备用字段2 字段:questionnaire_survey.field2
     *
     * @return questionnaire_survey.field2, 备用字段2
     */
    public String getField2() {
        return field2;
    }

    /**
     * 设置 备用字段2 字段:questionnaire_survey.field2
     *
     * @param field2 the value for questionnaire_survey.field2, 备用字段2
     */
    public void setField2(String field2) {
        this.field2 = field2 == null ? null : field2.trim();
    }

    /**
     * 获取 备用字段3 字段:questionnaire_survey.field3
     *
     * @return questionnaire_survey.field3, 备用字段3
     */
    public String getField3() {
        return field3;
    }

    /**
     * 设置 备用字段3 字段:questionnaire_survey.field3
     *
     * @param field3 the value for questionnaire_survey.field3, 备用字段3
     */
    public void setField3(String field3) {
        this.field3 = field3 == null ? null : field3.trim();
    }
}