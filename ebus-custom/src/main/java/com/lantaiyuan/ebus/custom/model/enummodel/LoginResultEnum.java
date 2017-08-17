package com.lantaiyuan.ebus.custom.model.enummodel;

/** 
  * @Title: LoginResult.java
  * @Package com.lantaiyuan.ebus.custom.model.enummodel
  * @Description: 
  * @author yangyang   
  * @date 2017年3月29日 上午10:59:30
  * @version v1.0  
 */
public enum LoginResultEnum {
	
	SUCCESS(1,"登录成功"),
	PWD_FAIL(-1, "密码错误"),
	USER_NOT_FOUND(-2, "用户名不存在");
	
	private String desc;
	
	private int value;
	
	LoginResultEnum(int value, String desc){
		this.value = value;
		this.desc = desc;
	}
	
	public String desc() {
		return desc;
	}
	
	public int value() {
		return value;
	}
	

}
