package com.lantaiyuan.ebus.carpool.model.jpush;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lantaiyuan.ebus.carpool.enums.JpushNoticeTypeEnum;
import com.lantaiyuan.ebus.carpool.enums.LastLoginSysTypeEnum;

/**
 * 描述:消息推送对象
 * 作者:温海金
 * 最后更改时间:下午4:43:34
 */
public class JpushData {
	/**
	 * 通知形式：通知或消息
	 */
	private JpushNoticeTypeEnum noticeTypeEnum;
	/**
	 * 模板ID
	 */
	private Integer pushTemplateId;
	 /**
     * 消息标题
     * 表字段 : carpool_push_msg.push_title
     */
    private String pushTitle;
    /**
     * 推送内容
     * 表字段 : carpool_push_msg.push_msg
     */
    private String pushMsg;
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
	/**
     * 用户id
     */
    private Integer userId;
    /**
     * 用户ID集合
     */
    private List<Integer> userIds;
    
    /**
     * 需要传递的变量信息：比如变更的站点、时间等
     */
    private Map<String, String> varMap;

    public JpushData() {
		super();
	}
    
	public JpushData(Integer pushTemplateId, Integer userId, Map<String, String> varMap) {
		super();
		this.pushTemplateId = pushTemplateId;
		this.noticeTypeEnum = JpushNoticeTypeEnum.NOTICE;
		this.userId = userId;
		this.varMap = varMap;
	}

	public Integer getPushTemplateId() {
		return pushTemplateId;
	}

	public void setPushTemplateId(Integer pushTemplateId) {
		this.pushTemplateId = pushTemplateId;
	}

	public List<Integer> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<Integer> userIds) {
		this.userIds = userIds;
	}

	public String getPushTitle() {
		return pushTitle;
	}

	public void setPushTitle(String pushTitle) {
		this.pushTitle = pushTitle;
	}

	public String getPushMsg() {
		return pushMsg;
	}

	public void setPushMsg(String pushMsg) {
		this.pushMsg = pushMsg;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public JpushNoticeTypeEnum getNoticeTypeEnum() {
		return noticeTypeEnum;
	}

	public void setNoticeTypeEnum(JpushNoticeTypeEnum noticeTypeEnum) {
		this.noticeTypeEnum = noticeTypeEnum;
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

	public Map<String, String> getVarMap() {
		return varMap;
	}

	public void setVarMap(Map<String, String> varMap) {
		this.varMap = varMap;
	}

	@Override
	public String toString() {
		return "JpushData [noticeTypeEnum=" + noticeTypeEnum + ", pushTemplateId=" + pushTemplateId + ", pushTitle=" + pushTitle + ", pushMsg=" + pushMsg
				+ ", lastLoginSysTypeEnum=" + lastLoginSysTypeEnum + ", cityCode=" + cityCode + ", regIds=" + regIds + ", regId=" + regId + ", tagValue=" + tagValue
				+ ", aliasValue=" + aliasValue + ", userId=" + userId + ", userIds=" + userIds + ", varMap=" + varMap + "]";
	}


}
