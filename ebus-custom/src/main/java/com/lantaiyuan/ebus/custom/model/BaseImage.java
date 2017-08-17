package com.lantaiyuan.ebus.custom.model;

import java.util.Date;

import org.lanqiao.ssm.common.model.Model;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 滚动图片
 * BaseImage
 * 数据库表：base_image
 */
public class BaseImage extends Model {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8504116682191484547L;

	/**
     * 
     * 表字段 : base_image.id
     */
    private Integer id;

    /**
     * 图片标题
     * 表字段 : base_image.title
     */
    private String title;

    /**
     * 图片路径
     * 表字段 : base_image.avd_image
     */
    private String avdImage;

    /**
     * 跳转页面
     * 表字段 : base_image.html_url
     */
    private String htmlUrl;

    /**
     * 宽度
     * 表字段 : base_image.width
     */
    private Short width;

    /**
     * 高度
     * 表字段 : base_image.height
     */
    private Short height;

    /**
     * 生效日期
     * 表字段 : base_image.startDate
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startdate;

    /**
     * 失效日期
     * 表字段 : base_image.endDate
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date enddate;

    /**
     * 排序
     * 表字段 : base_image.orderNo
     */
    private Short orderno;

    /**
     * 1：闪屏，2：广告，3：滚动图片
     * 表字段 : base_image.type
     */
    private Byte type;

    /**
     * 城市编码
     * 表字段 : base_image.cityCode
     */
    private String citycode;

    /**
     * 获取  字段:base_image.id
     *
     * @return base_image.id, 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置  字段:base_image.id
     *
     * @param id the value for base_image.id, 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 图片标题 字段:base_image.title
     *
     * @return base_image.title, 图片标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置 图片标题 字段:base_image.title
     *
     * @param title the value for base_image.title, 图片标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取 图片路径 字段:base_image.avd_image
     *
     * @return base_image.avd_image, 图片路径
     */
    public String getAvdImage() {
        return avdImage;
    }

    /**
     * 设置 图片路径 字段:base_image.avd_image
     *
     * @param avdImage the value for base_image.avd_image, 图片路径
     */
    public void setAvdImage(String avdImage) {
        this.avdImage = avdImage == null ? null : avdImage.trim();
    }

    /**
     * 获取 跳转页面 字段:base_image.html_url
     *
     * @return base_image.html_url, 跳转页面
     */
    public String getHtmlUrl() {
        return htmlUrl;
    }

    /**
     * 设置 跳转页面 字段:base_image.html_url
     *
     * @param htmlUrl the value for base_image.html_url, 跳转页面
     */
    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl == null ? null : htmlUrl.trim();
    }

    /**
     * 获取 宽度 字段:base_image.width
     *
     * @return base_image.width, 宽度
     */
    public Short getWidth() {
        return width;
    }

    /**
     * 设置 宽度 字段:base_image.width
     *
     * @param width the value for base_image.width, 宽度
     */
    public void setWidth(Short width) {
        this.width = width;
    }

    /**
     * 获取 高度 字段:base_image.height
     *
     * @return base_image.height, 高度
     */
    public Short getHeight() {
        return height;
    }

    /**
     * 设置 高度 字段:base_image.height
     *
     * @param height the value for base_image.height, 高度
     */
    public void setHeight(Short height) {
        this.height = height;
    }

    /**
     * 获取 生效日期 字段:base_image.startDate
     *
     * @return base_image.startDate, 生效日期
     */
    public Date getStartdate() {
        return startdate;
    }

    /**
     * 设置 生效日期 字段:base_image.startDate
     *
     * @param startdate the value for base_image.startDate, 生效日期
     */
    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    /**
     * 获取 失效日期 字段:base_image.endDate
     *
     * @return base_image.endDate, 失效日期
     */
    public Date getEnddate() {
        return enddate;
    }

    /**
     * 设置 失效日期 字段:base_image.endDate
     *
     * @param enddate the value for base_image.endDate, 失效日期
     */
    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    /**
     * 获取 排序 字段:base_image.orderNo
     *
     * @return base_image.orderNo, 排序
     */
    public Short getOrderno() {
        return orderno;
    }

    /**
     * 设置 排序 字段:base_image.orderNo
     *
     * @param orderno the value for base_image.orderNo, 排序
     */
    public void setOrderno(Short orderno) {
        this.orderno = orderno;
    }

    /**
     * 获取 1：闪屏，2：广告，3：滚动图片 字段:base_image.type
     *
     * @return base_image.type, 1：闪屏，2：广告，3：滚动图片
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置 1：闪屏，2：广告，3：滚动图片 字段:base_image.type
     *
     * @param type the value for base_image.type, 1：闪屏，2：广告，3：滚动图片
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取 城市编码 字段:base_image.cityCode
     *
     * @return base_image.cityCode, 城市编码
     */
    public String getCitycode() {
        return citycode;
    }

    /**
     * 设置 城市编码 字段:base_image.cityCode
     *
     * @param citycode the value for base_image.cityCode, 城市编码
     */
    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }
}