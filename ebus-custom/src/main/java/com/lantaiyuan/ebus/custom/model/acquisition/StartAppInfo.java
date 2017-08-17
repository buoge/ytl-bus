/**
 * @Title: StartAppInfo.java
 * @Package com.lantaiyuan.ebus.custom.model.acquisition
 * Company:深圳市蓝泰源信息技术股份有限公司
 * @author Yuan.Tan
 * @date 2017年2月15日 下午2:42:53
 */
package com.lantaiyuan.ebus.custom.model.acquisition;

import com.lantaiyuan.ebus.custom.model.acquisition.base.BaseModel;

/**
  * @ClassName: StartAppInfo 埋点启动app数据
  * Company:深圳市蓝泰源信息技术股份有限公司
  * @author Yuan.Tan
  * @date 2017年2月15日 下午2:42:53
  */
public class StartAppInfo extends BaseModel {
	/**
	  * @Fields serialVersionUID :
	  */
	private static final long serialVersionUID = 1L;
	private String startplace; //所处位置
	private String appversion; //app版本
	private String citycode; //城市编码
	 
	/**
	 * @return the startplace
	 */
	public String getStartplace() {
		return startplace;
	}
	/**
	 * @param startplace the startplace to set
	 */
	public void setStartplace(String startplace) {
		this.startplace = startplace;
	}
	/**
	 * @return the appversion
	 */
	public String getAppversion() {
		return appversion;
	}
	/**
	 * @param appversion the appversion to set
	 */
	public void setAppversion(String appversion) {
		this.appversion = appversion;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

}
