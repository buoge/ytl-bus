package com.lantaiyuan.ebus.custom.model;

import java.util.Date;

import org.lanqiao.ssm.common.model.Model;
import org.springframework.util.StringUtils;

import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;
import com.xiaoleilu.hutool.http.HtmlUtil;

public class LostProperty extends Model {

	private static final long serialVersionUID = -6644987868784172322L;

	/**
	 * 自增主键 表字段 : base_bus_news.id
	 */
	private Integer id;

	/**
	 * 1:大标题，2:小标题 表字段 : base_bus_news.type
	 */
	private Byte type;

	/**
	 * 标题 表字段 : base_bus_news.title
	 */
	private String title;

	/**
	 * 图片url 表字段 : base_bus_news.icon_url
	 */
	private String icon_url;

	/**
	 * 动态内容url 表字段 : base_bus_news.content_url
	 */
	private String content_url;

	private String brief;
	/**
	 * 创建时间 表字段 : base_bus_news.createtime
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

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		if (!StringUtils.isEmpty(brief)) {
			brief = extractHTML(brief);
			this.brief = brief.length() >= SysGlobalConstants.BRIEF_LENGTH
					? brief.substring(0, SysGlobalConstants.BRIEF_LENGTH).concat("...") : brief;
		} else {
			this.brief = "";
		}
	}

	// 从html中提取纯文本
	private String extractHTML(String strHtml) {
		// 去除html标签
		strHtml = HtmlUtil.cleanHtmlTag(strHtml);
		// 将&nbsp; &lt;等 转换为空格和<
		return HtmlUtil.restoreEscaped(strHtml);
	}

}
