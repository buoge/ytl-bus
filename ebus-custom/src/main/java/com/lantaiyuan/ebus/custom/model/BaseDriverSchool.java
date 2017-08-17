package com.lantaiyuan.ebus.custom.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.lanqiao.ssm.common.model.Model;

/**
 * 驾校基本信息
 * BaseDriverSchool
 * 数据库表：base_driver_school
 */
public class BaseDriverSchool extends Model{

    /** 
	* @Fields serialVersionUID 
	*/ 
	private static final long serialVersionUID = -1838852404268739657L;

	/**
     * 主键
     * 表字段 : base_driver_school.id
     */
    private String id;

    /**
     * 驾校名称
     * 表字段 : base_driver_school.name
     */
    @NotEmpty(message = "驾校名称不能为空")
    private String name;

    /**
     * 照片
     * 表字段 : base_driver_school.image
     */
    @NotEmpty(message = "必须上传一张驾校的照片")
    private String image;

    /**
     * 地址
     * 表字段 : base_driver_school.location
     */
    @NotEmpty(message =  "驾校地址不能为空")
    private String location;

    /**
     * 联系方式
     * 表字段 : base_driver_school.tel
     */
    @NotEmpty(message = "驾校联系方式不能为空")
    private String tel;

    /**
     * 能报名的驾照类型，用逗号分隔
     * 表字段 : base_driver_school.accept_licenses
     */
    @NotEmpty(message = "必须选择驾校能接受报名的驾照类型")
    private String acceptLicenses;
    
    private String acceptLicenseTypeDesc;

    /**
     * 城市编码
     * 表字段 : base_driver_school.citycode
     */
    @NotEmpty(message = "必须选择驾校所在的城市")
    private String citycode;

    /**
     * 简介
     * 表字段 : base_driver_school.introduction
     */
    private String introduction;
    
    
    private String cityName;
    
    public String getAcceptLicenseTypeDesc() {
		return acceptLicenseTypeDesc;
	}

	public void setAcceptLicenseTypeDesc(String acceptLicenseTypeDesc) {
		this.acceptLicenseTypeDesc = acceptLicenseTypeDesc;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
     * 获取 主键 字段:base_driver_school.id
     *
     * @return base_driver_school.id, 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 主键 字段:base_driver_school.id
     *
     * @param id the value for base_driver_school.id, 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 驾校名称 字段:base_driver_school.name
     *
     * @return base_driver_school.name, 驾校名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 驾校名称 字段:base_driver_school.name
     *
     * @param name the value for base_driver_school.name, 驾校名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取 照片 字段:base_driver_school.image
     *
     * @return base_driver_school.image, 照片
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置 照片 字段:base_driver_school.image
     *
     * @param image the value for base_driver_school.image, 照片
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * 获取 地址 字段:base_driver_school.location
     *
     * @return base_driver_school.location, 地址
     */
    public String getLocation() {
        return location;
    }

    /**
     * 设置 地址 字段:base_driver_school.location
     *
     * @param location the value for base_driver_school.location, 地址
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * 获取 联系方式 字段:base_driver_school.tel
     *
     * @return base_driver_school.tel, 联系方式
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置 联系方式 字段:base_driver_school.tel
     *
     * @param tel the value for base_driver_school.tel, 联系方式
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * 获取 能报名的驾照类型，用逗号分隔 字段:base_driver_school.accept_licenses
     *
     * @return base_driver_school.accept_licenses, 能报名的驾照类型，用逗号分隔
     */
    public String getAcceptLicenses() {
        return acceptLicenses;
    }

    /**
     * 设置 能报名的驾照类型，用逗号分隔 字段:base_driver_school.accept_licenses
     *
     * @param acceptLicenses the value for base_driver_school.accept_licenses, 能报名的驾照类型，用逗号分隔
     */
    public void setAcceptLicenses(String acceptLicenses) {
        this.acceptLicenses = acceptLicenses == null ? null : acceptLicenses.trim();
    }

    /**
     * 获取 城市编码 字段:base_driver_school.citycode
     *
     * @return base_driver_school.citycode, 城市编码
     */
    public String getCitycode() {
        return citycode;
    }

    /**
     * 设置 城市编码 字段:base_driver_school.citycode
     *
     * @param citycode the value for base_driver_school.citycode, 城市编码
     */
    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }

    /**
     * 获取 简介 字段:base_driver_school.introduction
     *
     * @return base_driver_school.introduction, 简介
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * 设置 简介 字段:base_driver_school.introduction
     *
     * @param introduction the value for base_driver_school.introduction, 简介
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }
}