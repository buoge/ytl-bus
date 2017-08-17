package com.lantaiyuan.ebus.realtime.model;

import org.lanqiao.ssm.common.model.Model;

/**
 * 
 * @ClassName: AppUserRegister 
 * Company:深圳市蓝泰源信息技术股份有限公司
 * @author Yuan.Tan
 * @date 2016年12月22日 下午1:51:14 
 */
public class AppUserRegister extends Model {

	/**
	 * @Fields serialVersionUID :
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 自增主键id 表字段 : base_user.userId
	 */
	private String userid;

	/**
	 * 用户名 表字段 : base_user.userName
	 */
	private String username;

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
	 * 城市编码 表字段 : base_user.cityCode
	 */
	private String citycode;
	
	private String backurl;
	
	private String sign;

	public String getBackurl() {
		return backurl;
	}

	public void setBackurl(String backurl) {
		this.backurl = backurl;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the iconurl
	 */
	public String getIconurl() {
		return iconurl;
	}

	/**
	 * @param iconurl the iconurl to set
	 */
	public void setIconurl(String iconurl) {
		this.iconurl = iconurl;
	}

	/**
	 * @return the cityname
	 */
	public String getCityname() {
		return cityname;
	}

	/**
	 * @param cityname the cityname to set
	 */
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	/**
	 * @return the citycode
	 */
	public String getCitycode() {
		return citycode;
	}

	/**
	 * @param citycode the citycode to set
	 */
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	/**
	 * @return the usercode
	 */
	public String getUsercode() {
		return usercode;
	}

	/**
	 * @param usercode the usercode to set
	 */
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	private String usercode;
	
	private String type;

	/**
	 * 获取 自增主键id 字段:base_user.userId
	 *
	 * @return base_user.userId, 自增主键id
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 设置 自增主键id 字段:base_user.userId
	 *
	 * @param userid
	 *            the value for base_user.userId, 自增主键id
	 */
	public void setUserid(String userid) {
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

}	