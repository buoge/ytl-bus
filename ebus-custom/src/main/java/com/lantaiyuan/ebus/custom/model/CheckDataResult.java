package com.lantaiyuan.ebus.custom.model;

import java.util.Collection;

import org.lanqiao.ssm.common.model.Model;


/**
 * 
* @Title: CheckDataResult.java
* @Package com.lantaiyuan.ebus.custom.model
* @Description: 
* @author yangyang   
* @date 2017年1月18日 上午10:23:32
* @version v1.0
 */
public class CheckDataResult extends Model {

	public CheckDataResult(Collection<String> result, String desc) {
		super();
		this.result = result;
		this.desc = desc;
	}

	public CheckDataResult() {
		super();
	}

	private static final long serialVersionUID = -58982998255519116L;
	
	private String desc;
	private Collection<String> result;
	
	

	public Collection<String> getResult() {
		return result;
	}

	public void setResult(Collection<String> result) {
		this.result = result;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	

   
}