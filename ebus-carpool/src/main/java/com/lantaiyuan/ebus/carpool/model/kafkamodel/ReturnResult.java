/**
* <p>Title: ReturnResult.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.carpool.model.kafkamodel;

/**
* <p>Title: ReturnResult</p>
* <p>Description: 大数据RESTful返回结构</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年7月14日 下午3:20:35
*/
public class ReturnResult {
	private Integer statusCode;
	private String msg;
	
	private Result obj;

	/**
	* @return statusCode
	*/
	public Integer getStatusCode() {
		return statusCode;
	}

	/**
	* @param statusCode 要设置的 statusCode
	*/
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	/**
	* @return msg
	*/
	public String getMsg() {
		return msg;
	}

	/**
	* @param msg 要设置的 msg
	*/
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	* @return obj
	*/
	public Result getObj() {
		return obj;
	}

	/**
	* @param obj 要设置的 obj
	*/
	public void setObj(Result obj) {
		this.obj = obj;
	}
	
}
