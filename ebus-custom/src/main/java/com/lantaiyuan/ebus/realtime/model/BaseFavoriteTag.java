/**
* <p>Title: BaseFavoriteTag.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.realtime.model;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.lanqiao.ssm.common.model.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lantaiyuan.ebus.realtime.model.valid.First;
import com.lantaiyuan.ebus.realtime.model.valid.Second;

/**
* <p>Title: BaseFavoriteTag</p>
* <p>Description: 用户自定义收藏标签model</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年4月25日 下午8:03:30
*/
public class BaseFavoriteTag extends Model{

	/***serialVersionUID***/
	private static final long serialVersionUID = 1L;
	
	//主键id：手动赋值
	@NotEmpty(message = "id不能为空！",groups = { Second.class})
	private String id;
	
	//标签名称
	@NotEmpty(message = "标签名称不能为空！",groups = { First.class, Second.class})
	private String name;
	
	//用户id
	@NotEmpty(message = "用户id不能为空！",groups = { First.class, Second.class})
	private String userid;
	
	//创建时间
	@JsonIgnore
	private Date createtime;
	
	//城市编码
	@NotEmpty(message = "城市编码不能为空！",groups = { First.class, Second.class})
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
	public String getUserid() {
		return userid;
	}
	/**
	* @param userid 要设置的 userid
	*/
	public void setUserid(String userid) {
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
