package com.lantaiyuan.ebus.custom.model;

import java.math.BigDecimal;
import java.util.Date;
import org.lanqiao.ssm.common.model.BaseModel;

/**
  * @ClassName: OrderQueryModel
  * @author Yuan.Tan
  * @date 2016年11月2日 下午2:47:52
 */
public class OrderQueryModel extends BaseModel {

	private static final long serialVersionUID = 1L;
	private String orderno;
	private String orderdetailid;
	private Byte orderstatus;
	private Date createtime;
	private Date paytime;
	private Byte paytype;
	private String payperson;
	private BigDecimal amount;
	private BigDecimal orderprice;
	private String wxprepayid;

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno == null ? null : orderno.trim();
	}

	public String getOrderdetailid() {
		return orderdetailid;
	}

	public void setOrderdetailid(String orderdetailid) {
		this.orderdetailid = orderdetailid == null ? null : orderdetailid.trim();
	}

	public Byte getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(Byte orderstatus) {
		this.orderstatus = orderstatus;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getPaytime() {
		return paytime;
	}

	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}

	public Byte getPaytype() {
		return paytype;
	}

	public void setPaytype(Byte paytype) {
		this.paytype = paytype;
	}

	public String getPayperson() {
		return payperson;
	}

	public void setPayperson(String payperson) {
		this.payperson = payperson == null ? null : payperson.trim();
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @return the orderprice
	 */
	public BigDecimal getOrderprice() {
		return orderprice;
	}

	/**
	 * @param orderprice the orderprice to set
	 */
	public void setOrderprice(BigDecimal orderprice) {
		this.orderprice = orderprice;
	}

	/**
	 * @return the wxprepayid
	 */
	public String getWxprepayid() {
		return wxprepayid;
	}

	/**
	 * @param wxprepayid the wxprepayid to set
	 */
	public void setWxprepayid(String wxprepayid) {
		this.wxprepayid = wxprepayid;
	}
}