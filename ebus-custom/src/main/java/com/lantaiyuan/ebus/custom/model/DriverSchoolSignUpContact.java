package com.lantaiyuan.ebus.custom.model;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.lanqiao.ssm.common.model.Model;
import org.springframework.util.StringUtils;

import com.lantaiyuan.ebus.common.util.Tools;

/**
 * web后台新增或修改驾校报名
 * 
 * @author yangyang
 * @date 2017年5月8日 下午6:17:08
 */
public class DriverSchoolSignUpContact extends Model {

	private static final long serialVersionUID = 4285403642849328984L;
	@NotEmpty(message = "姓名不能为空")
	private String name;
	private Byte sex;
	private Byte age;
	@NotNull(message = "驾照类型不能为空")
	private Byte licenseType;
	@NotEmpty(message = "联系方式不能为空")
	private String tel;
	private String signUpTimeStr;
	@NotEmpty(message = "联系人不能为空")
	private String contactPerson;
	@NotNull(message = "状态不能为空")
	private Byte status;
	private String contactTimeStr;
	@NotEmpty(message = "联系记录不能为空")
	private String contactRecord;

	/**
	 * 返回报名对象
	 * @author yangyang
	 * @return
	 */
	public DriverSchoolSignUp driverSchoolSignUp(String driverSchoolId) {
		DriverSchoolSignUp signUp = new DriverSchoolSignUp();
		signUp.setId(UUID.randomUUID().toString());
		signUp.setName(name);
		signUp.setContactPerson(contactPerson);
		signUp.setTel(tel);
		signUp.setLicenseType(licenseType);
		signUp.setStatus(status);
		signUp.setDriverSchoolId(driverSchoolId);
		if (!StringUtils.isEmpty(signUpTimeStr)) {
			signUp.setSignupTime(Tools.processStrToDate(signUpTimeStr));
		} else {
			signUp.setSignupTime(new Date());
		}
		if (!StringUtils.isEmpty(contactTimeStr)) {
			signUp.setLastContactTime(Tools.processStrToDate(contactTimeStr));
		} else {
			signUp.setLastContactTime(new Date());
		}
		if (!Objects.isNull(age)) {
			signUp.setAge(age);
		}
		if (!Objects.isNull(sex)) {
			signUp.setSex(sex);
		}
		return signUp;
	}
	
	/**
	 * 返回联系记录对象
	 * @author yangyang
	 * @return
	 */
	public DriverSchoolContactRecord driverSchoolContactRecord(String signUpId) {
		DriverSchoolContactRecord record = new DriverSchoolContactRecord();
		record.setContactRecord(contactRecord);
		record.setSignupId(signUpId);
		if (!StringUtils.isEmpty(contactTimeStr)) {
			record.setContactTime(Tools.processStrToDate(contactTimeStr));
		} else {
			record.setContactTime(new Date());
		}
		return record;
	}
	
	
	public Byte getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(Byte licenseType) {
		this.licenseType = licenseType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Byte getSex() {
		return sex;
	}

	public void setSex(Byte sex) {
		this.sex = sex;
	}

	public Byte getAge() {
		return age;
	}

	public void setAge(Byte age) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSignUpTimeStr() {
		return signUpTimeStr;
	}

	public void setSignUpTimeStr(String signUpTimeStr) {
		this.signUpTimeStr = signUpTimeStr;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getContactTimeStr() {
		return contactTimeStr;
	}

	public void setContactTimeStr(String contactTimeStr) {
		this.contactTimeStr = contactTimeStr;
	}

	public String getContactRecord() {
		return contactRecord;
	}

	public void setContactRecord(String contactRecord) {
		this.contactRecord = contactRecord;
	}

}
