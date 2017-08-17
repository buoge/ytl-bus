/**
 * @Title: InstallAppInfo.java
 * @Package com.lantaiyuan.ebus.custom.model.acquisition
 * Company:深圳市蓝泰源信息技术股份有限公司
 * @author Yuan.Tan
 * @date 2017年2月15日 下午2:49:07
 */
package com.lantaiyuan.ebus.custom.model.acquisition;

import com.lantaiyuan.ebus.custom.model.acquisition.base.BaseModel;

/**
  * @ClassName: InstallAppInfo 埋点启动app数据
  * Company:深圳市蓝泰源信息技术股份有限公司
  * @author Yuan.Tan
  * @date 2017年2月15日 下午2:49:07
  */
public class InstallAppInfo extends BaseModel{

	/**
	  * @Fields serialVersionUID :
	  */
	private static final long serialVersionUID = 1L;
	private String phonenumber; // 手机号码
	private String networktype; //网络类型 NetWork_Type_Normal = 0, NetWork_Type_2G = 1, NetWork_Type_3G = 2,NetWork_Type_4G = 3, NetWork_Type_5G = 4, NetWork_Type_Wifi = 5 
	private String phonebrand ;//手机品牌
	private String phoneosversion;//手机系统版本
	private String downloadchanneltype;// 下载渠道类型
	private String downloadchannelname;// 下载渠道名称
	private String installplace ;//安装地点名称
	
	/**
	 * @return the phonenumber
	 */
	public String getPhonenumber() {
		return phonenumber;
	}
	/**
	 * @param phonenumber the phonenumber to set
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	/**
	 * @return the networktype
	 */
	public String getNetworktype() {
		return networktype;
	}
	/**
	 * @param networktype the networktype to set
	 */
	public void setNetworktype(String networktype) {
		this.networktype = networktype;
	}
	 
	/**
	 * @return the phonebrand
	 */
	public String getPhonebrand() {
		return phonebrand;
	}
	/**
	 * @param phonebrand the phonebrand to set
	 */
	public void setPhonebrand(String phonebrand) {
		this.phonebrand = phonebrand;
	}
	/**
	 * @return the phoneosversion
	 */
	public String getPhoneosversion() {
		return phoneosversion;
	}
	/**
	 * @param phoneosversion the phoneosversion to set
	 */
	public void setPhoneosversion(String phoneosversion) {
		this.phoneosversion = phoneosversion;
	}
	/**
	 * @return the downloadchanneltype
	 */
	public String getDownloadchanneltype() {
		return downloadchanneltype;
	}
	/**
	 * @param downloadchanneltype the downloadchanneltype to set
	 */
	public void setDownloadchanneltype(String downloadchanneltype) {
		this.downloadchanneltype = downloadchanneltype;
	}
	/**
	 * @return the downloadchannelname
	 */
	public String getDownloadchannelname() {
		return downloadchannelname;
	}
	/**
	 * @param downloadchannelname the downloadchannelname to set
	 */
	public void setDownloadchannelname(String downloadchannelname) {
		this.downloadchannelname = downloadchannelname;
	}
	/**
	 * @return the installplace
	 */
	public String getInstallplace() {
		return installplace;
	}
	/**
	 * @param installplace the installplace to set
	 */
	public void setInstallplace(String installplace) {
		this.installplace = installplace;
	}

}
