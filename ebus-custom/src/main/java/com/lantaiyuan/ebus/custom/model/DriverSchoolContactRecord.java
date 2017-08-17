package com.lantaiyuan.ebus.custom.model;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.lanqiao.ssm.common.model.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 驾校报名联系记录
 * DriverSchoolContactRecord
 * 数据库表：driver_school_contact_record
 */
public class DriverSchoolContactRecord extends Model{

    /** 
	* @Fields serialVersionUID :
	*/ 
	private static final long serialVersionUID = 2417152692327921203L;

	/**
     * 自增主键
     * 表字段 : driver_school_contact_record.id
     */
    private Integer id;

    /**
     * 报名id，对应driver_school_signup主键
     * 表字段 : driver_school_contact_record.signup_id
     */
    @NotEmpty(message = "报名id不能为空")
    private String signupId;

    /**
     * 联系时间
     * 表字段 : driver_school_contact_record.contact_time
     */
    private Date contactTime;
    
    
    @NotEmpty(message = "联系时间不能为空")
    @JsonIgnore
    private String contactTimeStr;

    /**
     * 联系记录
     * 表字段 : driver_school_contact_record.contact_record
     */
    @NotEmpty(message = "联系记录不能为空")
    private String contactRecord;

    /**
     * 获取 自增主键 字段:driver_school_contact_record.id
     *
     * @return driver_school_contact_record.id, 自增主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 自增主键 字段:driver_school_contact_record.id
     *
     * @param id the value for driver_school_contact_record.id, 自增主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 报名id，对应driver_school_signup主键 字段:driver_school_contact_record.signup_id
     *
     * @return driver_school_contact_record.signup_id, 报名id，对应driver_school_signup主键
     */
    public String getSignupId() {
        return signupId;
    }

    /**
     * 设置 报名id，对应driver_school_signup主键 字段:driver_school_contact_record.signup_id
     *
     * @param signupId the value for driver_school_contact_record.signup_id, 报名id，对应driver_school_signup主键
     */
    public void setSignupId(String signupId) {
        this.signupId = signupId == null ? null : signupId.trim();
    }

    /**
     * 获取 联系时间 字段:driver_school_contact_record.contact_time
     *
     * @return driver_school_contact_record.contact_time, 联系时间
     */
    public Date getContactTime() {
        return contactTime;
    }

    /**
     * 设置 联系时间 字段:driver_school_contact_record.contact_time
     *
     * @param contactTime the value for driver_school_contact_record.contact_time, 联系时间
     */
    public void setContactTime(Date contactTime) {
        this.contactTime = contactTime;
    }

    /**
     * 获取 联系记录 字段:driver_school_contact_record.contact_record
     *
     * @return driver_school_contact_record.contact_record, 联系记录
     */
    public String getContactRecord() {
        return contactRecord;
    }

    /**
     * 设置 联系记录 字段:driver_school_contact_record.contact_record
     *
     * @param contactRecord the value for driver_school_contact_record.contact_record, 联系记录
     */
    public void setContactRecord(String contactRecord) {
        this.contactRecord = contactRecord == null ? null : contactRecord.trim();
    }

	public String getContactTimeStr() {
		return contactTimeStr;
	}

	public void setContactTimeStr(String contactTimeStr) {
		this.contactTimeStr = contactTimeStr;
	}
    
    
}