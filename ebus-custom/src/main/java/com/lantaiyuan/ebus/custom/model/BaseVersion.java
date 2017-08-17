package com.lantaiyuan.ebus.custom.model;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.lanqiao.ssm.common.model.Model;

/**
 * 版本表
 * BaseVersion
 * 数据库表：base_app_version
 */
public class BaseVersion extends Model {

    /**
     * 
     */
    private static final long serialVersionUID = -2564159543464801712L;

    /**
     * 
     * 表字段 : base_app_version.id
     */
    private String id;

    /**
     * 版本号
     * 表字段 : base_app_version.versionId
     */
    @NotEmpty(message = "版本号不能为空")
    private String versionid;

    /**
     * 0:安卓，1：ISO
     * 表字段 : base_app_version.type
     */
    @NotEmpty(message = "版本类型不能为空，0:安卓，1：ISO")
    private String type;

    /**
     * 版本URL
     * 表字段 : base_app_version.versionURL
     */
    @NotEmpty(message = "下载链接不能为空")
    private String versionurl;

    /**
     * 
     * 表字段 : base_app_version.cityCode
     */
    @NotEmpty(message = "城市编码不能为空")
    private String citycode;

    /**
     * 创建时间
     * 表字段 : base_app_version.createTime
     */
    private Date createtime;

    /**
     * 是否需要进行版本更新（true:需要进行版本更新；false:不需要进行版本更新）
     */
    private Boolean isneedupdate;
    /**
     * 获取  字段:base_app_version.id
     *
     * @return base_app_version.id, 
     */
    public String getId() {
        return id;
    }

    /**
     * 设置  字段:base_app_version.id
     *
     * @param id the value for base_app_version.id, 
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 版本号 字段:base_app_version.versionId
     *
     * @return base_app_version.versionId, 版本号
     */
    public String getVersionid() {
        return versionid;
    }

    /**
     * 设置 版本号 字段:base_app_version.versionId
     *
     * @param versionid the value for base_app_version.versionId, 版本号
     */
    public void setVersionid(String versionid) {
        this.versionid = versionid == null ? null : versionid.trim();
    }

    /**
     * 获取 0:安卓，1：ISO 字段:base_app_version.type
     *
     * @return base_app_version.type, 0:安卓，1：ISO
     */
    public String getType() {
        return type;
    }

    /**
     * 设置 0:安卓，1：ISO 字段:base_app_version.type
     *
     * @param type the value for base_app_version.type, 0:安卓，1：ISO
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取 版本URL 字段:base_app_version.versionURL
     *
     * @return base_app_version.versionURL, 版本URL
     */
    public String getVersionurl() {
        return versionurl;
    }

    /**
     * 设置 版本URL 字段:base_app_version.versionURL
     *
     * @param versionurl the value for base_app_version.versionURL, 版本URL
     */
    public void setVersionurl(String versionurl) {
        this.versionurl = versionurl == null ? null : versionurl.trim();
    }

    /**
     * 获取  字段:base_app_version.cityCode
     *
     * @return base_app_version.cityCode, 
     */
    public String getCitycode() {
        return citycode;
    }

    /**
     * 设置  字段:base_app_version.cityCode
     *
     * @param citycode the value for base_app_version.cityCode, 
     */
    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }

    /**
     * 获取 创建时间 字段:base_app_version.createTime
     *
     * @return base_app_version.createTime, 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置 创建时间 字段:base_app_version.createTime
     *
     * @param createtime the value for base_app_version.createTime, 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Boolean getIsneedupdate() {
        return isneedupdate;
    }

    public void setIsneedupdate(Boolean isneedupdate) {
        this.isneedupdate = isneedupdate;
    }
    
    
}