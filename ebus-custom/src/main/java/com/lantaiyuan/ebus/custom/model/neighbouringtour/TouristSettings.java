package com.lantaiyuan.ebus.custom.model.neighbouringtour;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.lanqiao.ssm.common.model.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/***
 * 
* <p>Title: TouristSettings</p>
* <p>Description: 周边游常用旅客实体类</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年7月17日 下午4:28:46
 */
public class TouristSettings extends Model{
    /***serialVersionUID***/
	private static final long serialVersionUID = 1L;

	private String id;

	@NotBlank(message="中文姓名不能为空!")
    private String name;

	@NotBlank(message="身份证号码不能为空!")
	@Pattern(regexp="(^\\d{15}$)|(^\\d{17}(\\d|x|X)$)",message="身份证号码格式错误!")
    private String idcardNo;

	@NotBlank(message="手机号码不能为空!")
    @Pattern(regexp="^1(3|4|5|7|8)\\d{9}$",message="手机号码格式错误!")
    private String phoneNo;

	@NotNull(message="用户id不能为空!")
    private Integer userId;

	@NotBlank(message="城市编码不能为空!")
    private String cityCode;

	@JsonIgnore
    private Date gmtCreate;

	@JsonIgnore
    private Date gmtModified;

	@JsonIgnore
    private String field1;

	@JsonIgnore
    private String field2;

	@JsonIgnore
    private String field3;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdcardNo() {
        return idcardNo;
    }

    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo == null ? null : idcardNo.trim();
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo == null ? null : phoneNo.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1 == null ? null : field1.trim();
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2 == null ? null : field2.trim();
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3 == null ? null : field3.trim();
    }
}