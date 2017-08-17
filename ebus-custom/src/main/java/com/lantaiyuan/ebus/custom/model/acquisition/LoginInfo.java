/**
 * @Title: LoginInfo.java
 * @Package com.lantaiyuan.ebus.custom.model.acquisition
 * Company:深圳市蓝泰源信息技术股份有限公司
 * @author Yuan.Tan
 * @date 2017年2月15日 下午2:13:34
 */
package com.lantaiyuan.ebus.custom.model.acquisition;

import com.lantaiyuan.ebus.custom.model.acquisition.base.BaseModel;

/**
  * @ClassName: LoginInfo 埋点用户登录信息
  * Company:深圳市蓝泰源信息技术股份有限公司
  * @author Yuan.Tan
  * @date 2017年2月15日 下午2:13:34
  */
public class LoginInfo extends BaseModel{
	/**
	  * @Fields serialVersionUID :
	  */
	private static final long serialVersionUID = 1L;
	private String citycode;
	private String cityname;
	private String sex;
	private String type;
	private String usercode;
	private String username;
	private String postion;
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	 
	/**
	 * @return the postion
	 */
	public String getPostion() {
		return postion;
	}
	/**
	 * @param postion the postion to set
	 */
	public void setPostion(String postion) {
		this.postion = postion;
	}
	
}
