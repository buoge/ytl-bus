/**
* <p>Title: SimpleRouteCustom.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.realtime.model;

/**
* <p>Title: SimpleRouteCustom</p>
* <p>Description: 语音精确查询接口返回结构</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年5月8日 下午1:47:58
*/
public class SimpleRouteCustom {
	private String routeid;
	private Integer direction;
	private String routename;
	
	//是否是精确查询结果标志： 0,无查询结果    1,是（1条）     2,否（多条）
	private String flag;
	
	/**
	* @return routeid
	*/
	public String getRouteid() {
		return routeid;
	}
	/**
	* @param routeid 要设置的 routeid
	*/
	public void setRouteid(String routeid) {
		this.routeid = routeid;
	}
	/**
	* @return direction
	*/
	public Integer getDirection() {
		return direction;
	}
	/**
	* @param direction 要设置的 direction
	*/
	public void setDirection(Integer direction) {
		this.direction = direction;
	}
	/**
	* @return flag
	*/
	public String getFlag() {
		return flag;
	}
	/**
	* @param flag 要设置的 flag
	*/
	public void setFlag(String flag) {
		this.flag = flag;
	}
	/**
	* @return routename
	*/
	public String getRoutename() {
		return routename;
	}
	/**
	* @param routename 要设置的 routename
	*/
	public void setRoutename(String routename) {
		this.routename = routename;
	}
	
}
