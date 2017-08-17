package com.lantaiyuan.ebus.custom.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.lanqiao.ssm.common.model.Model;

/**
 * 驾校报名
 * DriverSchoolSignUp
 * 数据库表：driver_school_signup
 */
public class DriverSchoolSignUp extends Model{

    /** 
	* @Fields serialVersionUID 
	*/ 
	private static final long serialVersionUID = -6441669834450271142L;

	/**
     * 主键
     * 表字段 : driver_school_signup.id
     */
    private String id;

    /**
     * 驾校id，对应base_driver_school主键（通过驾校id也就可以查询到citycode了）
     * 表字段 : driver_school_signup.driver_school_id
     */
    @NotEmpty(message = "必须选择一个报名的驾校")
    private String driverSchoolId;

    /**
     * 驾照类型
     * 表字段 : driver_school_signup.license_type
     */
    @NotNull(message = "必须选择驾照类型")
    private Byte licenseType;

    /**
     * 报名人姓名
     * 表字段 : driver_school_signup.name
     */
    @NotEmpty(message = "必须填写姓名")
    private String name;

    /**
     * 性别
     * 表字段 : driver_school_signup.sex
     */
    
    private Byte sex;

    /**
     * 年龄
     * 表字段 : driver_school_signup.age
     */
    private Byte age;

    /**
     * 手机号码
     * 表字段 : driver_school_signup.tel
     */
    @NotEmpty(message = "必须填写联系方式")
    private String tel;

    /**
     * 报名时间
     * 表字段 : driver_school_signup.signup_time
     */
    private Date signupTime;

    /**
     * 最后一次联系时间
     * 表字段 : driver_school_signup.last_contact_time
     */
    private Date lastContactTime;

    /**
     * 联系人
     * 表字段 : driver_school_signup.tel
     */
    private String contactPerson;
    
    /**
     * 状态。1：待联系，2：下次联系，3：已报名
     * 表字段 : driver_school_signup.status
     */
    private Byte status;

    /**
     * 获取 主键 字段:driver_school_signup.id
     *
     * @return driver_school_signup.id, 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 主键 字段:driver_school_signup.id
     *
     * @param id the value for driver_school_signup.id, 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 驾校id，对应base_driver_school主键（通过驾校id也就可以查询到citycode了） 字段:driver_school_signup.driver_school_id
     *
     * @return driver_school_signup.driver_school_id, 驾校id，对应base_driver_school主键（通过驾校id也就可以查询到citycode了）
     */
    public String getDriverSchoolId() {
        return driverSchoolId;
    }

    /**
     * 设置 驾校id，对应base_driver_school主键（通过驾校id也就可以查询到citycode了） 字段:driver_school_signup.driver_school_id
     *
     * @param driverSchoolId the value for driver_school_signup.driver_school_id, 驾校id，对应base_driver_school主键（通过驾校id也就可以查询到citycode了）
     */
    public void setDriverSchoolId(String driverSchoolId) {
        this.driverSchoolId = driverSchoolId == null ? null : driverSchoolId.trim();
    }

    /**
     * 获取 驾照类型 字段:driver_school_signup.license_type
     *
     * @return driver_school_signup.license_type, 驾照类型
     */
    public Byte getLicenseType() {
        return licenseType;
    }

    /**
     * 设置 驾照类型 字段:driver_school_signup.license_type
     *
     * @param licenseType the value for driver_school_signup.license_type, 驾照类型
     */
    public void setLicenseType(Byte licenseType) {
        this.licenseType = licenseType;
    }

    /**
     * 获取 报名人姓名 字段:driver_school_signup.name
     *
     * @return driver_school_signup.name, 报名人姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 报名人姓名 字段:driver_school_signup.name
     *
     * @param name the value for driver_school_signup.name, 报名人姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    
    
    public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	/**
     * 获取 性别 字段:driver_school_signup.sex
     *
     * @return driver_school_signup.sex, 性别
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * 设置 性别 字段:driver_school_signup.sex
     *
     * @param sex the value for driver_school_signup.sex, 性别
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * 获取 年龄 字段:driver_school_signup.age
     *
     * @return driver_school_signup.age, 年龄
     */
    public Byte getAge() {
        return age;
    }

    /**
     * 设置 年龄 字段:driver_school_signup.age
     *
     * @param age the value for driver_school_signup.age, 年龄
     */
    public void setAge(Byte age) {
        this.age = age;
    }

    /**
     * 获取 手机号码 字段:driver_school_signup.tel
     *
     * @return driver_school_signup.tel, 手机号码
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置 手机号码 字段:driver_school_signup.tel
     *
     * @param tel the value for driver_school_signup.tel, 手机号码
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * 获取 报名时间 字段:driver_school_signup.signup_time
     *
     * @return driver_school_signup.signup_time, 报名时间
     */
    public Date getSignupTime() {
        return signupTime;
    }

    /**
     * 设置 报名时间 字段:driver_school_signup.signup_time
     *
     * @param signupTime the value for driver_school_signup.signup_time, 报名时间
     */
    public void setSignupTime(Date signupTime) {
        this.signupTime = signupTime;
    }

    /**
     * 获取 最后一次联系时间 字段:driver_school_signup.last_contact_time
     *
     * @return driver_school_signup.last_contact_time, 最后一次联系时间
     */
    public Date getLastContactTime() {
        return lastContactTime;
    }

    /**
     * 设置 最后一次联系时间 字段:driver_school_signup.last_contact_time
     *
     * @param lastContactTime the value for driver_school_signup.last_contact_time, 最后一次联系时间
     */
    public void setLastContactTime(Date lastContactTime) {
        this.lastContactTime = lastContactTime;
    }

    /**
     * 获取 状态。1：待联系，2：下次联系，3：已报名 字段:driver_school_signup.status
     *
     * @return driver_school_signup.status, 状态。1：待联系，2：下次联系，3：已报名
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置 状态。1：待联系，2：下次联系，3：已报名 字段:driver_school_signup.status
     *
     * @param status the value for driver_school_signup.status, 状态。1：待联系，2：下次联系，3：已报名
     */
    public void setStatus(Byte status) {
        this.status = status;
    }
}