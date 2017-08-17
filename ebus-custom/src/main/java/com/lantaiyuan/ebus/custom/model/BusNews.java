package com.lantaiyuan.ebus.custom.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.lanqiao.ssm.common.model.Model;

/**
 * 公交动态
 * BusNews
 * 数据库表：base_bus_news
 */
public class BusNews extends Model{

	private static final long serialVersionUID = 1215948275244892549L;

	public BusNews() {
		super();
	}
	


	public BusNews(Integer id, Integer peopleViews) {
		super();
		this.id = id;
		this.peopleViews = peopleViews;
	}



	/**
     * 自增主键
     * 表字段 : base_bus_news.id
     */
    private Integer id;

    /**
     * 1:大标题，2:小标题
     * 表字段 : base_bus_news.type
     */
    @NotNull(message = "资讯类型不能为空")
    private Byte type;

    /**
     * 标题
     * 表字段 : base_bus_news.title
     */
    @NotEmpty(message = "标题不能为空")
    private String title;

    /**
     * 图片url
     * 表字段 : base_bus_news.icon_url
     */
    @NotEmpty(message = "图标url不能为空")
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

    /**
     * 动态内容
     * 表字段 : base_bus_news.content
     */
    @NotEmpty(message = "内容不能为空")
    private String content;
    @NotEmpty(message = "城市编码不能为空")
    private String cityCode;
    
    private Byte newsCategory;
    
    private Byte source;
    
    private String source_ip;
    
    private Integer peopleViews; 
    
    private String cityName;
    
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Byte getSource() {
		return source;
	}

	public void setSource(Byte source) {
		this.source = source;
	}

	public String getSource_ip() {
		return source_ip;
	}

	public void setSource_ip(String source_ip) {
		this.source_ip = source_ip;
	}

	public Integer getPeopleViews() {
		return peopleViews;
	}

	public void setPeopleViews(Integer peopleViews) {
		this.peopleViews = peopleViews;
	}

	public Byte getNewsCategory() {
		return newsCategory;
	}

	public void setNewsCategory(Byte newsCategory) {
		this.newsCategory = newsCategory;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	/**
     * 获取 自增主键 字段:base_bus_news.id
     *
     * @return base_bus_news.id, 自增主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 自增主键 字段:base_bus_news.id
     *
     * @param id the value for base_bus_news.id, 自增主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 1:大标题，2:小标题 字段:base_bus_news.type
     *
     * @return base_bus_news.type, 1:大标题，2:小标题
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置 1:大标题，2:小标题 字段:base_bus_news.type
     *
     * @param type the value for base_bus_news.type, 1:大标题，2:小标题
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取 标题 字段:base_bus_news.title
     *
     * @return base_bus_news.title, 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置 标题 字段:base_bus_news.title
     *
     * @param title the value for base_bus_news.title, 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取 图片url 字段:base_bus_news.icon_url
     *
     * @return base_bus_news.icon_url, 图片url
     */
   

    /**
     * 获取 动态内容url 字段:base_bus_news.content_url
     *
     * @return base_bus_news.content_url, 动态内容url
     */

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

    /**
     * 获取 创建时间 字段:base_bus_news.createtime
     *
     * @return base_bus_news.createtime, 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置 创建时间 字段:base_bus_news.createtime
     *
     * @param createtime the value for base_bus_news.createtime, 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }


    /**
     * 获取 动态内容 字段:base_bus_news.content
     *
     * @return base_bus_news.content, 动态内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置 动态内容 字段:base_bus_news.content
     *
     * @param content the value for base_bus_news.content, 动态内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}