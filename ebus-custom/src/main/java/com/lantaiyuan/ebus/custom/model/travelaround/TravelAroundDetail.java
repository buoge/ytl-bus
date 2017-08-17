package com.lantaiyuan.ebus.custom.model.travelaround;

import org.lanqiao.ssm.common.model.Model;

import com.lantaiyuan.ebus.custom.model.TravelAroundRoute;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 周边游
 * TravelAround
 * 数据库表：travel_around
 */
public class TravelAroundDetail extends Model{

    private static final long serialVersionUID = -5877695155260689024L;

    /**
     * 主键
     * 表字段 : travel_around.id
     */
    private String id;

    /**
     * 类型。1：探险旅游，2：美食外卖，3：雅致生活
     * 表字段 : travel_around.travel_type
     */
    private Byte travelType;

    /**
     * 模版类型。1：普通模版，2：极简模版
     * 表字段 : travel_around.template_type
     */
    private Byte templateType;

    /**
     * 城市编码，-1代表所有城市
     * 表字段 : travel_around.city_code
     */
    private String cityCode;

    /**
     * 标题
     * 表字段 : travel_around.title
     */
    private String title;

    /**
     * 地点
     * 表字段 : travel_around.location
     */
    private String location;

    /**
     * 简介
     * 表字段 : travel_around.brief_introduction
     */
    private String briefIntroduction;

    /**
     * 是否永久有效，0：否，1：是。默认0.
     * 表字段 : travel_around.is_permanent_valid
     */
    private Boolean isPermanentValid;

    /**
     * 有效期起始时间
     * 表字段 : travel_around.start_valid_period
     */
    private Date startValidPeriod;

    /**
     * 有效期结束时间
     * 表字段 : travel_around.end_valid_period
     */
    private Date endValidPeriod;

    /**
     * 可出行日期，多个用逗号分个
     * 表字段 : travel_around.trip_date
     */
    private String tripDate;

    /**
     * 原价
     * 表字段 : travel_around.original_price
     */
    private BigDecimal originalPrice;

    /**
     * 现价
     * 表字段 : travel_around.current_price
     */
    private BigDecimal currentPrice;

    /**
     * 票数
     * 表字段 : travel_around.ticket_num
     */
    private Integer ticketNum;

    /**
     * 页面是否显示库存，0：不显示，1：显示。默认1.
     * 表字段 : travel_around.is_ticket_num_shown
     */
    private Boolean isTicketNumShown;

    /**
     * 每人限购数量
     * 表字段 : travel_around.person_limit_num
     */
    private Integer personLimitNum;

    /**
     * 图片，多条用逗号分隔
     * 表字段 : travel_around.pics
     */
    private String pics;

    /**
     * 是否开启推荐，0：否，1：是。默认0.
     * 表字段 : travel_around.is_recommended
     */
    private Boolean isRecommended;

    /**
     * 关联的专线，多条用逗号分隔
     * 表字段 : travel_around.related_customline
     */
    private String relatedCustomline;

    /**
     * 活动详情
     * 表字段 : travel_around.event_detail
     */
    private String eventDetail;

    /**
     * 购票须知
     * 表字段 : travel_around.ticket_note
     */
    private String ticketNote;

    /**
     * pv数
     * 表字段 : travel_around.pv
     */
    private Integer pv;

    /**
     * 
     * 表字段 : travel_around.gmt_create
     */
    private Date gmtCreate;

    /**
     * 
     * 表字段 : travel_around.gmt_modified
     */
    private Date gmtModified;

    /**
     * 
     * 表字段 : travel_around.field1
     */
    private String field1;

    /**
     * 
     * 表字段 : travel_around.field2
     */
    private String field2;

    /**
     * 
     * 表字段 : travel_around.field3
     */
    private String field3;
    
    private List<TravelAroundRoute> TravelAroundRouteList;

    
    /**
     * 获取 主键 字段:travel_around.id
     *
     * @return travel_around.id, 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 主键 字段:travel_around.id
     *
     * @param id the value for travel_around.id, 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 类型。1：探险旅游，2：美食外卖，3：雅致生活 字段:travel_around.travel_type
     *
     * @return travel_around.travel_type, 类型。1：探险旅游，2：美食外卖，3：雅致生活
     */
    public Byte getTravelType() {
        return travelType;
    }

    /**
     * 设置 类型。1：探险旅游，2：美食外卖，3：雅致生活 字段:travel_around.travel_type
     *
     * @param travelType the value for travel_around.travel_type, 类型。1：探险旅游，2：美食外卖，3：雅致生活
     */
    public void setTravelType(Byte travelType) {
        this.travelType = travelType;
    }

    /**
     * 获取 模版类型。1：普通模版，2：极简模版 字段:travel_around.template_type
     *
     * @return travel_around.template_type, 模版类型。1：普通模版，2：极简模版
     */
    public Byte getTemplateType() {
        return templateType;
    }

    /**
     * 设置 模版类型。1：普通模版，2：极简模版 字段:travel_around.template_type
     *
     * @param templateType the value for travel_around.template_type, 模版类型。1：普通模版，2：极简模版
     */
    public void setTemplateType(Byte templateType) {
        this.templateType = templateType;
    }

    /**
     * 获取 城市编码，-1代表所有城市 字段:travel_around.city_code
     *
     * @return travel_around.city_code, 城市编码，-1代表所有城市
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置 城市编码，-1代表所有城市 字段:travel_around.city_code
     *
     * @param cityCode the value for travel_around.city_code, 城市编码，-1代表所有城市
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * 获取 标题 字段:travel_around.title
     *
     * @return travel_around.title, 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置 标题 字段:travel_around.title
     *
     * @param title the value for travel_around.title, 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取 地点 字段:travel_around.location
     *
     * @return travel_around.location, 地点
     */
    public String getLocation() {
        return location;
    }

    /**
     * 设置 地点 字段:travel_around.location
     *
     * @param location the value for travel_around.location, 地点
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * 获取 简介 字段:travel_around.brief_introduction
     *
     * @return travel_around.brief_introduction, 简介
     */
    public String getBriefIntroduction() {
        return briefIntroduction;
    }

    /**
     * 设置 简介 字段:travel_around.brief_introduction
     *
     * @param briefIntroduction the value for travel_around.brief_introduction, 简介
     */
    public void setBriefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction == null ? null : briefIntroduction.trim();
    }

    /**
     * 获取 是否永久有效，0：否，1：是。默认0. 字段:travel_around.is_permanent_valid
     *
     * @return travel_around.is_permanent_valid, 是否永久有效，0：否，1：是。默认0.
     */
    public Boolean getIsPermanentValid() {
        return isPermanentValid;
    }

    /**
     * 设置 是否永久有效，0：否，1：是。默认0. 字段:travel_around.is_permanent_valid
     *
     * @param isPermanentValid the value for travel_around.is_permanent_valid, 是否永久有效，0：否，1：是。默认0.
     */
    public void setIsPermanentValid(Boolean isPermanentValid) {
        this.isPermanentValid = isPermanentValid;
    }

    /**
     * 获取 有效期起始时间 字段:travel_around.start_valid_period
     *
     * @return travel_around.start_valid_period, 有效期起始时间
     */
    public Date getStartValidPeriod() {
        return startValidPeriod;
    }

    /**
     * 设置 有效期起始时间 字段:travel_around.start_valid_period
     *
     * @param startValidPeriod the value for travel_around.start_valid_period, 有效期起始时间
     */
    public void setStartValidPeriod(Date startValidPeriod) {
        this.startValidPeriod = startValidPeriod;
    }

    /**
     * 获取 有效期结束时间 字段:travel_around.end_valid_period
     *
     * @return travel_around.end_valid_period, 有效期结束时间
     */
    public Date getEndValidPeriod() {
        return endValidPeriod;
    }

    /**
     * 设置 有效期结束时间 字段:travel_around.end_valid_period
     *
     * @param endValidPeriod the value for travel_around.end_valid_period, 有效期结束时间
     */
    public void setEndValidPeriod(Date endValidPeriod) {
        this.endValidPeriod = endValidPeriod;
    }

    /**
     * 获取 可出行日期，多个用逗号分个 字段:travel_around.trip_date
     *
     * @return travel_around.trip_date, 可出行日期，多个用逗号分个
     */
    public String getTripDate() {
        return tripDate;
    }

    /**
     * 设置 可出行日期，多个用逗号分个 字段:travel_around.trip_date
     *
     * @param tripDate the value for travel_around.trip_date, 可出行日期，多个用逗号分个
     */
    public void setTripDate(String tripDate) {
        this.tripDate = tripDate == null ? null : tripDate.trim();
    }

    /**
     * 获取 原价 字段:travel_around.original_price
     *
     * @return travel_around.original_price, 原价
     */
    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    /**
     * 设置 原价 字段:travel_around.original_price
     *
     * @param originalPrice the value for travel_around.original_price, 原价
     */
    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    /**
     * 获取 现价 字段:travel_around.current_price
     *
     * @return travel_around.current_price, 现价
     */
    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    /**
     * 设置 现价 字段:travel_around.current_price
     *
     * @param currentPrice the value for travel_around.current_price, 现价
     */
    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    /**
     * 获取 票数 字段:travel_around.ticket_num
     *
     * @return travel_around.ticket_num, 票数
     */
    public Integer getTicketNum() {
        return ticketNum;
    }

    /**
     * 设置 票数 字段:travel_around.ticket_num
     *
     * @param ticketNum the value for travel_around.ticket_num, 票数
     */
    public void setTicketNum(Integer ticketNum) {
        this.ticketNum = ticketNum;
    }

    /**
     * 获取 页面是否显示库存，0：不显示，1：显示。默认1. 字段:travel_around.is_ticket_num_shown
     *
     * @return travel_around.is_ticket_num_shown, 页面是否显示库存，0：不显示，1：显示。默认1.
     */
    public Boolean getIsTicketNumShown() {
        return isTicketNumShown;
    }

    /**
     * 设置 页面是否显示库存，0：不显示，1：显示。默认1. 字段:travel_around.is_ticket_num_shown
     *
     * @param isTicketNumShown the value for travel_around.is_ticket_num_shown, 页面是否显示库存，0：不显示，1：显示。默认1.
     */
    public void setIsTicketNumShown(Boolean isTicketNumShown) {
        this.isTicketNumShown = isTicketNumShown;
    }

    /**
     * 获取 每人限购数量 字段:travel_around.person_limit_num
     *
     * @return travel_around.person_limit_num, 每人限购数量
     */
    public Integer getPersonLimitNum() {
        return personLimitNum;
    }

    /**
     * 设置 每人限购数量 字段:travel_around.person_limit_num
     *
     * @param personLimitNum the value for travel_around.person_limit_num, 每人限购数量
     */
    public void setPersonLimitNum(Integer personLimitNum) {
        this.personLimitNum = personLimitNum;
    }

    /**
     * 获取 图片，多条用逗号分隔 字段:travel_around.pics
     *
     * @return travel_around.pics, 图片，多条用逗号分隔
     */
    public String getPics() {
        return pics;
    }

    /**
     * 设置 图片，多条用逗号分隔 字段:travel_around.pics
     *
     * @param pics the value for travel_around.pics, 图片，多条用逗号分隔
     */
    public void setPics(String pics) {
        this.pics = pics == null ? null : pics.trim();
    }

    /**
     * 获取 是否开启推荐，0：否，1：是。默认0. 字段:travel_around.is_recommended
     *
     * @return travel_around.is_recommended, 是否开启推荐，0：否，1：是。默认0.
     */
    public Boolean getIsRecommended() {
        return isRecommended;
    }

    /**
     * 设置 是否开启推荐，0：否，1：是。默认0. 字段:travel_around.is_recommended
     *
     * @param isRecommended the value for travel_around.is_recommended, 是否开启推荐，0：否，1：是。默认0.
     */
    public void setIsRecommended(Boolean isRecommended) {
        this.isRecommended = isRecommended;
    }

    /**
     * 获取 关联的专线，多条用逗号分隔 字段:travel_around.related_customline
     *
     * @return travel_around.related_customline, 关联的专线，多条用逗号分隔
     */
    public String getRelatedCustomline() {
        return relatedCustomline;
    }

    /**
     * 设置 关联的专线，多条用逗号分隔 字段:travel_around.related_customline
     *
     * @param relatedCustomline the value for travel_around.related_customline, 关联的专线，多条用逗号分隔
     */
    public void setRelatedCustomline(String relatedCustomline) {
        this.relatedCustomline = relatedCustomline == null ? null : relatedCustomline.trim();
    }

    /**
     * 获取 活动详情 字段:travel_around.event_detail
     *
     * @return travel_around.event_detail, 活动详情
     */
    public String getEventDetail() {
        return eventDetail;
    }

    /**
     * 设置 活动详情 字段:travel_around.event_detail
     *
     * @param eventDetail the value for travel_around.event_detail, 活动详情
     */
    public void setEventDetail(String eventDetail) {
        this.eventDetail = eventDetail == null ? null : eventDetail.trim();
    }

    /**
     * 获取 购票须知 字段:travel_around.ticket_note
     *
     * @return travel_around.ticket_note, 购票须知
     */
    public String getTicketNote() {
        return ticketNote;
    }

    /**
     * 设置 购票须知 字段:travel_around.ticket_note
     *
     * @param ticketNote the value for travel_around.ticket_note, 购票须知
     */
    public void setTicketNote(String ticketNote) {
        this.ticketNote = ticketNote == null ? null : ticketNote.trim();
    }

    /**
     * 获取 pv数 字段:travel_around.pv
     *
     * @return travel_around.pv, pv数
     */
    public Integer getPv() {
        return pv;
    }

    /**
     * 设置 pv数 字段:travel_around.pv
     *
     * @param pv the value for travel_around.pv, pv数
     */
    public void setPv(Integer pv) {
        this.pv = pv;
    }

    /**
     * 获取  字段:travel_around.gmt_create
     *
     * @return travel_around.gmt_create, 
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置  字段:travel_around.gmt_create
     *
     * @param gmtCreate the value for travel_around.gmt_create, 
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取  字段:travel_around.gmt_modified
     *
     * @return travel_around.gmt_modified, 
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置  字段:travel_around.gmt_modified
     *
     * @param gmtModified the value for travel_around.gmt_modified, 
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取  字段:travel_around.field1
     *
     * @return travel_around.field1, 
     */
    public String getField1() {
        return field1;
    }

    /**
     * 设置  字段:travel_around.field1
     *
     * @param field1 the value for travel_around.field1, 
     */
    public void setField1(String field1) {
        this.field1 = field1 == null ? null : field1.trim();
    }

    /**
     * 获取  字段:travel_around.field2
     *
     * @return travel_around.field2, 
     */
    public String getField2() {
        return field2;
    }

    /**
     * 设置  字段:travel_around.field2
     *
     * @param field2 the value for travel_around.field2, 
     */
    public void setField2(String field2) {
        this.field2 = field2 == null ? null : field2.trim();
    }

    /**
     * 获取  字段:travel_around.field3
     *
     * @return travel_around.field3, 
     */
    public String getField3() {
        return field3;
    }

    /**
     * 设置  字段:travel_around.field3
     *
     * @param field3 the value for travel_around.field3, 
     */
    public void setField3(String field3) {
        this.field3 = field3 == null ? null : field3.trim();
    }

	public List<TravelAroundRoute> getTravelAroundRouteList() {
		return TravelAroundRouteList;
	}

	public void setTravelAroundRouteList(List<TravelAroundRoute> travelAroundRouteList) {
		TravelAroundRouteList = travelAroundRouteList;
	}
}