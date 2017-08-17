package com.lantaiyuan.ebus.custom.model;

import java.math.BigDecimal;
import java.util.Date;
import org.lanqiao.ssm.common.model.BaseModel;

/**
 * 
  * @ClassName: BookTicketOrderQueryModel
  * @author Yuan.Tan
  * @date 2016年11月8日 上午11:45:54
  *
 */
public class BookTicketOrderQueryModel  extends BaseModel<BookTicketOrder>{
	private static final long serialVersionUID = 1L;
	private String routeid;
    private String sourcelocation;
    private String targetlocation;
    private String taketime;
    private String takedate;
    private BigDecimal amount;
	private Integer userid;
    private String username;
    private Integer goodsnum;
    private String ticketstatus;
    private Date ceatetime;
    private String citycode;
	
    /**
	 * @return the routeid
	 */
	public String getRouteid() {
		return routeid;
	}
	/**
	 * @param routeid the routeid to set
	 */
	public void setRouteid(String routeid) {
		this.routeid = routeid;
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
	 * @return the taketime
	 */
	public String getTaketime() {
		return taketime;
	}
	/**
	 * @param taketime the taketime to set
	 */
	public void setTaketime(String taketime) {
		this.taketime = taketime;
	}
	/**
	 * @return the takedate
	 */
	public String getTakedate() {
		return takedate;
	}
	/**
	 * @param takedate the takedate to set
	 */
	public void setTakedate(String takedate) {
		this.takedate = takedate;
	}
	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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
	/**
	 * @return the goodsnum
	 */
	public Integer getGoodsnum() {
		return goodsnum;
	}
	/**
	 * @param goodsnum the goodsnum to set
	 */
	public void setGoodsnum(Integer goodsnum) {
		this.goodsnum = goodsnum;
	}
	/**
	 * @return the ticketstatus
	 */
	public String getTicketstatus() {
		return ticketstatus;
	}
	/**
	 * @param ticketstatus the ticketstatus to set
	 */
	public void setTicketstatus(String ticketstatus) {
		this.ticketstatus = ticketstatus;
	}
	/**
	 * @return the ceatetime
	 */
	public Date getCeatetime() {
		return ceatetime;
	}
	/**
	 * @param ceatetime the ceatetime to set
	 */
	public void setCeatetime(Date ceatetime) {
		this.ceatetime = ceatetime;
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
    
   }