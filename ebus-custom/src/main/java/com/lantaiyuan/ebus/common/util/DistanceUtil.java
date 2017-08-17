package com.lantaiyuan.ebus.common.util;

/**
 * 
 * @Title: DistanceUtil.java
 * @Package com.lantaiyuan.ebus.custom.util
 * @Description: 根据经纬度计算两点之间的距离和角度
 * @author yangyang
 * @date 2016年12月20日 上午11:07:18
 * @version v1.0
 */
public class DistanceUtil {
	private static final int EARTH_RADIUS = 6378137; // 地球半径

	/**
	 * 计算地球上任意两点(经纬度)距离
	 * 
	 * @param long1
	 *            第一点经度
	 * @param lat1
	 *            第一点纬度
	 * @param long2
	 *            第二点经度
	 * @param lat2
	 *            第二点纬度
	 * @return 返回距离 单位：米
	 */
	public static double countDistance(double long1, double lat1, double long2, double lat2) {
		lat1 = lat1 * Math.PI / 180.0;
		lat2 = lat2 * Math.PI / 180.0;
		double lat_differ = Math.abs(lat1 - lat2), long_differ = (Math.abs(long1 - long2)) * Math.PI / 180.0;
		double lat_sin = Math.sin(lat_differ / 2.0), long_sin = Math.sin(long_differ / 2.0);
		return 2 * EARTH_RADIUS
				* Math.asin(Math.sqrt(lat_sin * lat_sin + Math.cos(lat1) * Math.cos(lat2) * long_sin * long_sin));
	}
	

}
