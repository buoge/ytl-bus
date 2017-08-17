package com.lantaiyuan.ebus.custom.model;

import org.lanqiao.ssm.common.model.BaseModel;

public class BusNewsQueryModel extends BaseModel<BusNews>{
	
	private static final long serialVersionUID = 6753422446931533244L;

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

    private String startTime;
    
    private String endTime;
    
    private String cityCode;
    
    private Byte newsCategory;

	

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
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
	
}
