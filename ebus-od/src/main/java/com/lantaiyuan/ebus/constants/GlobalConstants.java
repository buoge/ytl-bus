/**
* <p>Title: GlobalConstants.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.constants;

/**
* <p>Title: GlobalConstants</p>
* <p>Description: 常用常量类</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年5月5日 下午5:55:27
*/
public class GlobalConstants {
	//m/s => km/h
	public static final double MPS_KMPH_RADIX = 3.6;
	
	//步行转车速临界点
	public static final double FOOT_TO_BUS_SPOT = 15.0;
	
	//人车合一临界点距离
	public static final double USER_BUS_TOGETHER_DISTANCE = 450.0;
	
	//人车分离临界点距离
	public static final double USER_BUS_SEPARATE_DISTANCE = 800.0;
	
	/**
	 * 存放的用户位移数目
	 * @author yangyang
	 */
	public static final int USER_RECORD_NUM = 6;
	
	/**
	 * 用于确认cityCode的最长长度
	 * @author yangyang
	 */
	public static final int MAX_CITYCODE_LEN = 6;
	/**
	 * 用户确认cityCode的最短长度
	 * @author yangyang
	 */
	public static final int MIN_CITYCODE_LEN = 4;
	
	/**
	 * 如果用户连续与一辆车的距离在USER_BUS_TOGETHER_DISTANCE范围内的次数达到该值，
	 * 认为用户与该车人车合一
	 * @author yangyang
	 */
	public static final int USER_JOIN_BUS_TIMES = 10;
	
}
