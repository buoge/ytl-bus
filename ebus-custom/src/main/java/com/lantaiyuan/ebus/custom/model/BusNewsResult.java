package com.lantaiyuan.ebus.custom.model;

import java.util.Date;

import org.lanqiao.ssm.common.model.Model;

/** 
  * @Title: BusNewsResult.java
  * @Package com.lantaiyuan.ebus.custom.model
  * @Description: 
  * @author yangyang   
  * @date 2017年1月4日 下午3:12:23
  * @version v1.0  
 */
public class BusNewsResult extends Model{

	private static final long serialVersionUID = 1180743328410193803L;
	
	/**
     * 自增主键
     * 表字段 : base_bus_news.id
     */
    private Integer id;

    /**
     * 1:大标题，2:小标题
     * 表字段 : base_bus_news.type
     */
    private Byte type;

    /**
     * 标题
     * 表字段 : base_bus_news.title
     */
    private String title;

    /**
     * 图片url
     * 表字段 : base_bus_news.icon_url
     */
    private String icon_url;

    /**
     * 动态内容url
     * 表字段 : base_bus_news.content_url
     */
    private String content_url;

    /**
     * 创建时间
     * 表字段 : base_bus_news.createtime
     */
    private Date createtime;

    private String cityCode;
    
    private Byte newsCategory;
    
    private Byte source;
    
    private Integer peopleViews;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIcon_url() {
		return icon_url;
	}

	public void setIcon_url(String icon_url) {
		this.icon_url = icon_url;
	}

	public String getContent_url() {
		return content_url;
	}

	public void setContent_url(String content_url) {
		this.content_url = content_url;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public Byte getNewsCategory() {
		return newsCategory;
	}

	public void setNewsCategory(Byte newsCategory) {
		this.newsCategory = newsCategory;
	}

	public Byte getSource() {
		return source;
	}

	public void setSource(Byte source) {
		this.source = source;
	}

	public Integer getPeopleViews() {
		return peopleViews;
	}

	public void setPeopleViews(Integer peopleViews) {
		this.peopleViews = peopleViews;
	}
    
    
}
