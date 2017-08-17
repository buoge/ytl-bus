/**
* <p>Title: Result.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.carpool.model.kafkamodel;

/**
* <p>Title: Result</p>
* <p>Description: </p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年7月14日 下午4:13:53
*/
public class Result {
	//订单编号
	private String orderNo;
	
	//加入状态
	private Integer status;
	
	//拼车状态
	private Integer matchStatus;
	
	//新的撮合订单号
	private String newMatchId;
	
	//老的撮合订单号
	private String oldMatchId;

	/**
	* @return orderNo
	*/
	public String getOrderNo() {
		return orderNo;
	}

	/**
	* @param orderNo 要设置的 orderNo
	*/
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	* @return status
	*/
	public Integer getStatus() {
		return status;
	}

	/**
	* @param status 要设置的 status
	*/
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	* @return matchStatus
	*/
	public Integer getMatchStatus() {
		return matchStatus;
	}

	/**
	* @param matchStatus 要设置的 matchStatus
	*/
	public void setMatchStatus(Integer matchStatus) {
		this.matchStatus = matchStatus;
	}

	/**
	* @return newMatchId
	*/
	public String getNewMatchId() {
		return newMatchId;
	}

	/**
	* @param newMatchId 要设置的 newMatchId
	*/
	public void setNewMatchId(String newMatchId) {
		this.newMatchId = newMatchId;
	}

	/**
	* @return oldMatchId
	*/
	public String getOldMatchId() {
		return oldMatchId;
	}

	/**
	* @param oldMatchId 要设置的 oldMatchId
	*/
	public void setOldMatchId(String oldMatchId) {
		this.oldMatchId = oldMatchId;
	}
	
}
