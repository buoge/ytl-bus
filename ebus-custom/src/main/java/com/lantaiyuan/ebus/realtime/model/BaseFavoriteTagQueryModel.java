/**
* <p>Title: BaseFavoriteTag.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.realtime.model;

import java.util.Date;

import org.lanqiao.ssm.common.model.BaseModel;

/**
* <p>Title: BaseFavoriteTag</p>
* <p>Description: 用户自定义收藏标签model</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年4月25日 下午8:03:30
*/
public class BaseFavoriteTagQueryModel extends BaseModel<BaseFavoriteTag>{

	/***serialVersionUID***/
	private static final long serialVersionUID = 1L;
	
	//主键id：手动赋值
	private String id;
	
	//标签名称
	private String name;
	
	//用户id
	private Integer userid;
	
	//创建时间
	private Date createtime;
	
	//城市编码
	private String citycode;
	
	/**
	* @return id
	*/
	public String getId() {
		return id;
	}
	/**
	* @param id 要设置的 id
	*/
	public void setId(String id) {
		this.id = id;
	}
	/**
	* @return name
	*/
	public String getName() {
		return name;
	}
	/**
	* @param name 要设置的 name
	*/
	public void setName(String name) {
		this.name = name;
	}
	/**
	* @return userid
	*/
	public Integer getUserid() {
		return userid;
	}
	/**
	* @param userid 要设置的 userid
	*/
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	/**
	* @return createtime
	*/
	public Date getCreatetime() {
		return createtime;
	}
	/**
	* @param createtime 要设置的 createtime
	*/
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	* @return citycode
	*/
	public String getCitycode() {
		return citycode;
	}
	/**
	* @param citycode 要设置的 citycode
	*/
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	
}
