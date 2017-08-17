package com.lantaiyuan.ebus.model;

import java.util.Set;

import com.lantaiyuan.ebus.model.enummodel.JpushNoticeTypeEnum;
import com.lantaiyuan.ebus.model.enummodel.JpushRangeEnum;
import com.lantaiyuan.ebus.model.enummodel.JpushTypeEnum;
import com.lantaiyuan.ebus.model.enummodel.LastLoginSysTypeEnum;


/**
 * 描述:消息推送对象
 * 作者:温海金
 * 最后更改时间:上午10:16:57
 */
public class JpushDemo {
	/**
	 * 通知形式：通知或消息
	 */
	private JpushNoticeTypeEnum noticeTypeEnum;
	/**
	 * 推送类型，具体那个模块
	 */
	private JpushTypeEnum jpushTypeEnum;
	/**
	 * 推送内容
	 */
	private String msgContent;
	/**
	 * 所有用户：ALL_USER; 单个城市：THE_ONE_CITY; 用户组：USER_GROUP; 单个用户：SIGLE_USER; 标签推送：TAG; 别名推送：ALIAS;
	 */
	private JpushRangeEnum jpushRangeEnum;
	/**
	 * 最后登入系统类型 ANDROID, IOS;
	 */
	private LastLoginSysTypeEnum lastLoginSysTypeEnum;
	/**
	 * 城市编码
	 */
	private String cityCode;
	/**
	 * 按用户组发送时存储regId
	 */
	private Set<String> regIds;
	/**
	 * 单个用户指定regId
	 */
	private String regId;
	/**
	 * 按标签发送时指定标签值
	 */
	private String tagValue;
	/**
	 * 按别名发送的时候指定别名
	 */
	private String aliasValue;

	public JpushNoticeTypeEnum getNoticeTypeEnum() {
		return noticeTypeEnum;
	}

	public void setNoticeTypeEnum(JpushNoticeTypeEnum noticeTypeEnum) {
		this.noticeTypeEnum = noticeTypeEnum;
	}

	public JpushTypeEnum getJpushTypeEnum() {
		return jpushTypeEnum;
	}

	public void setJpushTypeEnum(JpushTypeEnum jpushTypeEnum) {
		this.jpushTypeEnum = jpushTypeEnum;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public JpushRangeEnum getJpushRangeEnum() {
		return jpushRangeEnum;
	}

	public void setJpushRangeEnum(JpushRangeEnum jpushRangeEnum) {
		this.jpushRangeEnum = jpushRangeEnum;
	}

	public LastLoginSysTypeEnum getLastLoginSysTypeEnum() {
		return lastLoginSysTypeEnum;
	}

	public void setLastLoginSysTypeEnum(LastLoginSysTypeEnum lastLoginSysTypeEnum) {
		this.lastLoginSysTypeEnum = lastLoginSysTypeEnum;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public Set<String> getRegIds() {
		return regIds;
	}

	public void setRegIds(Set<String> regIds) {
		this.regIds = regIds;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public String getTagValue() {
		return tagValue;
	}

	public void setTagValue(String tagValue) {
		this.tagValue = tagValue;
	}

	public String getAliasValue() {
		return aliasValue;
	}

	public void setAliasValue(String aliasValue) {
		this.aliasValue = aliasValue;
	}

}
