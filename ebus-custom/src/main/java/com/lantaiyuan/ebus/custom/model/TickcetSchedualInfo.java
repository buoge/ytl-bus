package com.lantaiyuan.ebus.custom.model;

import org.lanqiao.ssm.common.model.Model;

/**
 * 
 * @ClassName: TickcetSchedual
 * @author Yuan.Tan
 * @date 2016年11月8日 上午11:48:24
 *
 */
public class TickcetSchedualInfo extends Model {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String routeid;

	private String servertime;

	private String serverdate;

	private Integer remainticketnum;

	private String price;

	private String isbooked;

	/**
	 * @return the isbooked
	 */
	public String getIsbooked() {
		return isbooked;
	}

	/**
	 * @param isbooked
	 *            the isbooked to set
	 */
	public void setIsbooked(String isbooked) {
		this.isbooked = isbooked;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRouteid() {
		return routeid;
	}

	public void setRouteid(String routeid) {
		this.routeid = routeid == null ? null : routeid.trim();
	}

	public String getServertime() {
		return servertime;
	}

	public void setServertime(String servertime) {
		this.servertime = servertime == null ? null : servertime.trim();
	}

	public String getServerdate() {
		return serverdate;
	}

	public void setServerdate(String serverdate) {
		this.serverdate = serverdate;
	}

	public Integer getRemainticketnum() {
		return remainticketnum;
	}

	public void setRemainticketnum(Integer remainticketnum) {
		this.remainticketnum = remainticketnum;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price == null ? null : price.trim();
	}

	@Override
	public boolean equals(Object obj) {
		TickcetSchedualInfo tickcetSchedualInfo = (TickcetSchedualInfo) obj;
		return routeid.equals(tickcetSchedualInfo.routeid) && serverdate.equals(tickcetSchedualInfo.serverdate)
				&& isbooked.equals(tickcetSchedualInfo.isbooked);
	}

	@Override
	public int hashCode() {
		String in = routeid + serverdate;
		return in.hashCode();
	}
}