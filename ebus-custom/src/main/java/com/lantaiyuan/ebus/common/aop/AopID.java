package com.lantaiyuan.ebus.common.aop;

/**
 * 
* @Title: AopID.java 
* @Package com.lantaiyuan.ebus.custom.aop 
* @Description: 存放aop日志ID
* @author 刘伟  15818570028@163.com   
* @date 2016年11月18日 下午5:53:51 
* @version V1.0
 */

public class AopID {
	/**
	 * 线程的日志ID
	 */
	static ThreadLocal<String> logid = new ThreadLocal<>();
}
