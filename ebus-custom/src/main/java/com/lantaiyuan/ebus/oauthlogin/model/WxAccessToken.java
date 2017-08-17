package com.lantaiyuan.ebus.oauthlogin.model;

import org.lanqiao.ssm.common.model.Model;

/**
 * 微信获取AccessToken返回结果的model
 * 
 * @author yangyang
 * @date 2017年6月19日 下午4:04:35
 */
public class WxAccessToken extends Model {

	private static final long serialVersionUID = 5967138290751058665L;

	private String access_token; // 接口调用凭证
	private Long expires_in; // access_token接口调用凭证超时时间，单位（秒）
	private String refresh_token; // 用户刷新access_token
	private String openid; // 授权用户唯一标识
	private String scope; // 用户授权的作用域，使用逗号（,）分隔
	private String unionid; // 当且仅当该移动应用已获得该用户的userinfo授权时，才会出现该字段

	private Integer errcode; // 错误码
	private String errmsg; // 错误消息
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public Long getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(Long expires_in) {
		this.expires_in = expires_in;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	public Integer getErrcode() {
		return errcode;
	}
	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	
}
