package com.lantaiyuan.ebus.carpool.model.jpush;

import java.util.Date;

import org.lanqiao.ssm.common.model.Model;

/**
 * 拼车模块消息推送模板表
 * PushTemplate
 * 数据库表：carpool_push_template
 */
public class PushTemplate extends Model{

    /**
	 * 
	 */
	private static final long serialVersionUID = 8459818959088097868L;

	/**
     * 主键
     * 表字段 : carpool_push_template.id
     */
    private Integer id;

    /**
     * 模板名称
     * 表字段 : carpool_push_template.name
     */
    private String name;

    /**
     * 推送标题
     * 表字段 : carpool_push_template.title
     */
    private String title;

    /**
     * 推送内容
     * 表字段 : carpool_push_template.content
     */
    private String content;

    /**
     * 
     * 表字段 : carpool_push_template.gmt_create
     */
    private Date gmtCreate;

    /**
     * 
     * 表字段 : carpool_push_template.gmt_modified
     */
    private Date gmtModified;

    /**
     * 
     * 表字段 : carpool_push_template.field1
     */
    private String field1;

    /**
     * 
     * 表字段 : carpool_push_template.field2
     */
    private String field2;

    /**
     * 
     * 表字段 : carpool_push_template.field3
     */
    private String field3;

    /**
     * 获取 主键 字段:carpool_push_template.id
     *
     * @return carpool_push_template.id, 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 主键 字段:carpool_push_template.id
     *
     * @param id the value for carpool_push_template.id, 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 模板名称 字段:carpool_push_template.name
     *
     * @return carpool_push_template.name, 模板名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 模板名称 字段:carpool_push_template.name
     *
     * @param name the value for carpool_push_template.name, 模板名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取 推送标题 字段:carpool_push_template.title
     *
     * @return carpool_push_template.title, 推送标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置 推送标题 字段:carpool_push_template.title
     *
     * @param title the value for carpool_push_template.title, 推送标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取 推送内容 字段:carpool_push_template.content
     *
     * @return carpool_push_template.content, 推送内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置 推送内容 字段:carpool_push_template.content
     *
     * @param content the value for carpool_push_template.content, 推送内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取  字段:carpool_push_template.gmt_create
     *
     * @return carpool_push_template.gmt_create, 
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置  字段:carpool_push_template.gmt_create
     *
     * @param gmtCreate the value for carpool_push_template.gmt_create, 
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取  字段:carpool_push_template.gmt_modified
     *
     * @return carpool_push_template.gmt_modified, 
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置  字段:carpool_push_template.gmt_modified
     *
     * @param gmtModified the value for carpool_push_template.gmt_modified, 
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取  字段:carpool_push_template.field1
     *
     * @return carpool_push_template.field1, 
     */
    public String getField1() {
        return field1;
    }

    /**
     * 设置  字段:carpool_push_template.field1
     *
     * @param field1 the value for carpool_push_template.field1, 
     */
    public void setField1(String field1) {
        this.field1 = field1 == null ? null : field1.trim();
    }

    /**
     * 获取  字段:carpool_push_template.field2
     *
     * @return carpool_push_template.field2, 
     */
    public String getField2() {
        return field2;
    }

    /**
     * 设置  字段:carpool_push_template.field2
     *
     * @param field2 the value for carpool_push_template.field2, 
     */
    public void setField2(String field2) {
        this.field2 = field2 == null ? null : field2.trim();
    }

    /**
     * 获取  字段:carpool_push_template.field3
     *
     * @return carpool_push_template.field3, 
     */
    public String getField3() {
        return field3;
    }

    /**
     * 设置  字段:carpool_push_template.field3
     *
     * @param field3 the value for carpool_push_template.field3, 
     */
    public void setField3(String field3) {
        this.field3 = field3 == null ? null : field3.trim();
    }
}