/**
 * @Title: EvaluationInfo.java
 * @Package com.lantaiyuan.ebus.custom.model.acquisition
 * Company:深圳市蓝泰源信息技术股份有限公司
 * @author Yuan.Tan
 * @date 2017年2月15日 下午2:28:31
 */
package com.lantaiyuan.ebus.custom.model.acquisition;

import com.lantaiyuan.ebus.custom.model.acquisition.base.BaseModel;

/**
  * @ClassName: EvaluationInfo 评价信息埋点
  * Company:深圳市蓝泰源信息技术股份有限公司
  * @author Yuan.Tan
  * @date 2017年2月15日 下午2:28:31
  */
public class EvaluationInfo extends BaseModel {
	/**
	  * @Fields serialVersionUID :
	  */
	private static final long serialVersionUID = 1L;
	private String evaluatobjname;	//	评价对象名（车牌号或者站台名称）
	private String routename;	//	线路名称（当评价对象是站台时，传空值）
	private String score;	//	评分
	private String username	;//	评价人
	private String citycode	;//	城市编码(必传)
	private String postion ; // 评价人所处位置
	/**
	 * @return the evaluatobjname
	 */
	public String getEvaluatobjname() {
		return evaluatobjname;
	}
	/**
	 * @param evaluatobjname the evaluatobjname to set
	 */
	public void setEvaluatobjname(String evaluatobjname) {
		this.evaluatobjname = evaluatobjname;
	}
	/**
	 * @return the routename
	 */
	public String getRoutename() {
		return routename;
	}
	/**
	 * @param routename the routename to set
	 */
	public void setRoutename(String routename) {
		this.routename = routename;
	}
	/**
	 * @return the score
	 */
	public String getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(String score) {
		this.score = score;
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
