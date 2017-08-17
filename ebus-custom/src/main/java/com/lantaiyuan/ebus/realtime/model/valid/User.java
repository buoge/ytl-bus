package com.lantaiyuan.ebus.realtime.model.valid;

import java.util.Date;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.lanqiao.ssm.common.model.Model;
import com.lantaiyuan.ebus.realtime.model.valid.First;
import com.lantaiyuan.ebus.realtime.model.valid.Second;

public class User extends Model {
	/**
	 * *
	 */
	private static final long serialVersionUID = 1L;

	private String roleIds;

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	private String id;
	@NotEmpty(message = "姓名不能为空")
	private String loginName;
	@NotEmpty(message = "密码不能为空")
	@Length(min = 6, message = "密码长度不能小于6位")
	private String password;
	@NotEmpty(message = "不能为空", groups = { Second.class })
	private String status;
	@NotEmpty(message = "不能为空", groups = { First.class })
	private String type;

	private String paymentCode;

	private Date createtime;

	private Long userNo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName == null ? null : loginName.trim();
	}

	public String getPassword() {
		return password;
	}

	 

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public String getPaymentCode() {
		return paymentCode;
	}

	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode == null ? null : paymentCode.trim();
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
}