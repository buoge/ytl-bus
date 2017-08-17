package com.lantaiyuan.ebus.carpool.model.jpush;

public class UserSimpleInfo {
	/**
	 * 用户ID
	 */
	private Integer userId;
	/**
	 * 用户名称
	 */
	private String userName;
	/**
	 * regId:极光推送用
	 */
	private String registrationId;
	/**
	 * 最后登入系统类型(1-ANDROID 2-IOS)
	 */
	private Integer lastLoginSysType;
	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	public Integer getLastLoginSysType() {
		return lastLoginSysType;
	}

	public void setLastLoginSysType(Integer lastLoginSysType) {
		this.lastLoginSysType = lastLoginSysType;
	}
	
	
}
