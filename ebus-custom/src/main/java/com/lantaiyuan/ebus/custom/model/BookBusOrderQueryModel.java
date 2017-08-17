package com.lantaiyuan.ebus.custom.model;

import org.lanqiao.ssm.common.model.BaseModel;

import com.wordnik.swagger.annotations.ApiModel;

/**
 * 
  * @ClassName: BookBusOrderQueryModel
  * @author Yuan.Tan
  * @date 2016年11月8日 上午11:44:34
  *
 */
@ApiModel
public class BookBusOrderQueryModel extends BaseModel<BookBusOrder> {
	private static final long serialVersionUID = -7035002549741405338L;
	private String sourcelocation;
	private String targetlocation;
	private String starttime;
	private String backtime;
	private Integer passengernum;
	private String contactname;
	private String contactphone;
	private String remark;
	private Integer bookbustype;
	private Integer userid;
	private String username;
	private String citycode;
	    
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
	 * @return the sourcelocation
	 */
	public String getSourcelocation() {
		return sourcelocation;
	}
	/**
	 * @param sourcelocation the sourcelocation to set
	 */
	public void setSourcelocation(String sourcelocation) {
		this.sourcelocation = sourcelocation;
	}
	/**
	 * @return the targetlocation
	 */
	public String getTargetlocation() {
		return targetlocation;
	}
	/**
	 * @param targetlocation the targetlocation to set
	 */
	public void setTargetlocation(String targetlocation) {
		this.targetlocation = targetlocation;
	}
	/**
	 * @return the starttime
	 */
	public String getStarttime() {
		return starttime;
	}
	/**
	 * @param starttime the starttime to set
	 */
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	/**
	 * @return the backtime
	 */
	public String getBacktime() {
		return backtime;
	}
	/**
	 * @param backtime the backtime to set
	 */
	public void setBacktime(String backtime) {
		this.backtime = backtime;
	}
	/**
	 * @return the passengernum
	 */
	public Integer getPassengernum() {
		return passengernum;
	}
	/**
	 * @param passengernum the passengernum to set
	 */
	public void setPassengernum(Integer passengernum) {
		this.passengernum = passengernum;
	}
	/**
	 * @return the contactname
	 */
	public String getContactname() {
		return contactname;
	}
	/**
	 * @param contactname the contactname to set
	 */
	public void setContactname(String contactname) {
		this.contactname = contactname;
	}
	/**
	 * @return the contactphone
	 */
	public String getContactphone() {
		return contactphone;
	}
	/**
	 * @param contactphone the contactphone to set
	 */
	public void setContactphone(String contactphone) {
		this.contactphone = contactphone;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @return the bookbustype
	 */
	public Integer getBookbustype() {
		return bookbustype;
	}
	/**
	 * @param bookbustype the bookbustype to set
	 */
	public void setBookbustype(Integer bookbustype) {
		this.bookbustype = bookbustype;
	}
	/**
	 * @return the userid
	 */
	public Integer getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
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
}	