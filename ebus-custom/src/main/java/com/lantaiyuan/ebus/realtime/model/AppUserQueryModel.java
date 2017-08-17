package com.lantaiyuan.ebus.realtime.model;

import java.util.Date;
import org.lanqiao.ssm.common.model.BaseModel;

/**
 * 
 * @ClassName: AppUserQueryModel
 * Company:深圳市蓝泰源信息技术股份有限公司
 * @author Yuan.Tan
 * @date 2016年12月22日 下午1:51:14 
 */
public class AppUserQueryModel extends BaseModel {

	/**
	 * @Fields serialVersionUID :
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 自增主键id 表字段 : base_user.userId
	 */
	private Integer userid;

	/**
	 * 用户名 表字段 : base_user.userName
	 */
	private String username;

	/**
	 * 手机号码 表字段 : base_user.phoneNo
	 */
	private String phoneno;

	/**
	 * 微信号 表字段 : base_user.wechatNo
	 */
	private String wechatno;

	/**
	 * QQ号码 表字段 : base_user.qqNo
	 */
	private String qqno;

	/**
	 * 微博号 表字段 : base_user.microBlogNo
	 */
	private String microblogno;

	/**
	 * 昵称 表字段 : base_user.nickName
	 */
	private String nickname;

	/**
	 * 0:女 1:男 表字段 : base_user.sex
	 */
	private String sex;

	/**
	 * 图片URL 表字段 : base_user.iconURL
	 */
	private String iconurl;

	/**
	 * 所在城市 表字段 : base_user.cityName
	 */
	private String cityname;

	/**
	 * 0：在线 1：离线 表字段 : base_user.onlineStatus
	 */
	private Integer onlinestatus;

	/**
	 * 登录时间 表字段 : base_user.loginTime
	 */
	private Date logintime;

	/**
	 * 城市编码 表字段 : base_user.cityCode
	 */
	private String citycode;

	/**
	 * 用户状态 0：有效 1：失效 表字段 : base_user.status
	 */
	private Integer status;

	/**
	 * 获取 自增主键id 字段:base_user.userId
	 *
	 * @return base_user.userId, 自增主键id
	 */
	public Integer getUserid() {
		return userid;
	}

	/**
	 * 设置 自增主键id 字段:base_user.userId
	 *
	 * @param userid
	 *            the value for base_user.userId, 自增主键id
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	/**
	 * 获取 用户名 字段:base_user.userName
	 *
	 * @return base_user.userName, 用户名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设置 用户名 字段:base_user.userName
	 *
	 * @param username
	 *            the value for base_user.userName, 用户名
	 */
	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	/**
	 * 获取 手机号码 字段:base_user.phoneNo
	 *
	 * @return base_user.phoneNo, 手机号码
	 */
	public String getPhoneno() {
		return phoneno;
	}

	/**
	 * 设置 手机号码 字段:base_user.phoneNo
	 *
	 * @param phoneno
	 *            the value for base_user.phoneNo, 手机号码
	 */
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno == null ? null : phoneno.trim();
	}

	/**
	 * 获取 微信号 字段:base_user.wechatNo
	 *
	 * @return base_user.wechatNo, 微信号
	 */
	public String getWechatno() {
		return wechatno;
	}

	/**
	 * 设置 微信号 字段:base_user.wechatNo
	 *
	 * @param wechatno
	 *            the value for base_user.wechatNo, 微信号
	 */
	public void setWechatno(String wechatno) {
		this.wechatno = wechatno == null ? null : wechatno.trim();
	}

	/**
	 * 获取 QQ号码 字段:base_user.qqNo
	 *
	 * @return base_user.qqNo, QQ号码
	 */
	public String getQqno() {
		return qqno;
	}

	/**
	 * 设置 QQ号码 字段:base_user.qqNo
	 *
	 * @param qqno
	 *            the value for base_user.qqNo, QQ号码
	 */
	public void setQqno(String qqno) {
		this.qqno = qqno == null ? null : qqno.trim();
	}

	/**
	 * 获取 微博号 字段:base_user.microBlogNo
	 *
	 * @return base_user.microBlogNo, 微博号
	 */
	public String getMicroblogno() {
		return microblogno;
	}

	/**
	 * 设置 微博号 字段:base_user.microBlogNo
	 *
	 * @param microblogno
	 *            the value for base_user.microBlogNo, 微博号
	 */
	public void setMicroblogno(String microblogno) {
		this.microblogno = microblogno == null ? null : microblogno.trim();
	}

	/**
	 * 获取 昵称 字段:base_user.nickName
	 *
	 * @return base_user.nickName, 昵称
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * 设置 昵称 字段:base_user.nickName
	 *
	 * @param nickname
	 *            the value for base_user.nickName, 昵称
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname == null ? null : nickname.trim();
	}

	/**
	 * 获取 0:女 1:男 字段:base_user.sex
	 *
	 * @return base_user.sex, 0:女 1:男
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * 设置 0:女 1:男 字段:base_user.sex
	 *
	 * @param sex
	 *            the value for base_user.sex, 0:女 1:男
	 */
	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	/**
	 * 获取 图片URL 字段:base_user.iconURL
	 *
	 * @return base_user.iconURL, 图片URL
	 */
	public String getIconurl() {
		return iconurl;
	}

	/**
	 * 设置 图片URL 字段:base_user.iconURL
	 *
	 * @param iconurl
	 *            the value for base_user.iconURL, 图片URL
	 */
	public void setIconurl(String iconurl) {
		this.iconurl = iconurl == null ? null : iconurl.trim();
	}

	/**
	 * 获取 所在城市 字段:base_user.cityName
	 *
	 * @return base_user.cityName, 所在城市
	 */
	public String getCityname() {
		return cityname;
	}

	/**
	 * 设置 所在城市 字段:base_user.cityName
	 *
	 * @param cityname
	 *            the value for base_user.cityName, 所在城市
	 */
	public void setCityname(String cityname) {
		this.cityname = cityname == null ? null : cityname.trim();
	}

	/**
	 * 获取 0：在线 1：离线 字段:base_user.onlineStatus
	 *
	 * @return base_user.onlineStatus, 0：在线 1：离线
	 */
	public Integer getOnlinestatus() {
		return onlinestatus;
	}

	/**
	 * 设置 0：在线 1：离线 字段:base_user.onlineStatus
	 *
	 * @param onlinestatus
	 *            the value for base_user.onlineStatus, 0：在线 1：离线
	 */
	public void setOnlinestatus(Integer onlinestatus) {
		this.onlinestatus = onlinestatus;
	}

	/**
	 * 获取 登录时间 字段:base_user.loginTime
	 *
	 * @return base_user.loginTime, 登录时间
	 */
	public Date getLogintime() {
		return logintime;
	}

	/**
	 * 设置 登录时间 字段:base_user.loginTime
	 *
	 * @param logintime
	 *            the value for base_user.loginTime, 登录时间
	 */
	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}

	/**
	 * 获取 城市编码 字段:base_user.cityCode
	 *
	 * @return base_user.cityCode, 城市编码
	 */
	public String getCitycode() {
		return citycode;
	}

	/**
	 * 设置 城市编码 字段:base_user.cityCode
	 *
	 * @param citycode
	 *            the value for base_user.cityCode, 城市编码
	 */
	public void setCitycode(String citycode) {
		this.citycode = citycode == null ? null : citycode.trim();
	}

	/**
	 * 获取 用户状态 0：有效 1：失效 字段:base_user.status
	 *
	 * @return base_user.status, 用户状态 0：有效 1：失效
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 设置 用户状态 0：有效 1：失效 字段:base_user.status
	 *
	 * @param status
	 *            the value for base_user.status, 用户状态 0：有效 1：失效
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
}