/**
 * @Title: Position.java
 * @Package com.lantaiyuan.ebus.custom.util
 * Company:深圳市蓝泰源信息技术股份有限公司
 * @author Yuan.Tan
 * @date 2016年11月18日 下午5:51:52
 */
package com.lantaiyuan.ebus.common.util;

import java.math.BigDecimal;

/**
 * @ClassName: Position
 * @author Yuan.Tan
 * @date 2016年11月18日 下午5:51:52
 */
public class Position {
	// 经度
	double longitude;
	// 纬度
	double latitude;

	public Position(double longitude, double latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getlatitude() {
		return latitude;
	}

	public void setlatitude(double latitude) {
		this.latitude = latitude;
	}

	/*
	 * 计算两点之间距离
	 * @param start
	 * @param end
	 * @return km
	 */
	public static BigDecimal getDistance(Position start, Position end) {
		double lon1 = (Math.PI / 180) * start.longitude;
		double lon2 = (Math.PI / 180) * end.longitude;
		double lat1 = (Math.PI / 180) * start.latitude;
		double lat2 = (Math.PI / 180) * end.latitude;
		// 地球半径
		double radius = 6371;
		// 两点间距离 km，如果想要米的话，结果*1000就可以
		double distance = Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2 - lon1))* radius;
		return BigDecimal.valueOf(distance).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

}