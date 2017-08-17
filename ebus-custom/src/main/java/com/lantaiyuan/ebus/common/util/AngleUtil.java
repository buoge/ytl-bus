package com.lantaiyuan.ebus.common.util;

/**
 * 
 * @Title: AngleUtil.java
 * @Package com.lantaiyuan.ebus.custom.util
 * @Description: 根据经纬度计算角度
 * @author yangyang
 * @date 2016年12月20日 下午1:43:53
 * @version v1.0
 */
public class AngleUtil {

	/**
	 * 获取AB连线与正北方向的角度
	 * 
	 * @param A
	 *            A点的经纬度
	 * @param B
	 *            B点的经纬度
	 * @return AB连线与正北方向的角度（0~360）
	 */
	public static double getAngle(double lat_a, double lng_a, double lat_b, double lng_b) {
		return getAngle(new AngleUtil.MyLatLng(lng_a, lat_a), new AngleUtil.MyLatLng(lng_b, lat_b));
	}
	
	private static double getAngle(MyLatLng A, MyLatLng B) {
		double dx = (B.m_RadLo - A.m_RadLo) * A.ed;
		double dy = (B.m_RadLa - A.m_RadLa) * A.ec;
		double angle = 0.0;
		angle = Math.atan(Math.abs(dx / dy)) * 180. / Math.PI;
		double dLo = B.m_Longitude - A.m_Longitude;
		double dLa = B.m_Latitude - A.m_Latitude;
		if (dLo > 0 && dLa <= 0) {
			angle = (90. - angle) + 90;
		} else if (dLo <= 0 && dLa < 0) {
			angle = angle + 180.;
		} else if (dLo < 0 && dLa >= 0) {
			angle = (90. - angle) + 270;
		}
		return angle;
	}

	static class MyLatLng {
		final static double RC = 6378137;
		final static double RJ = 6356725;
		double m_LoDeg, m_LoMin, m_LoSec;
		double m_LaDeg, m_LaMin, m_LaSec;
		double m_Longitude, m_Latitude;
		double m_RadLo, m_RadLa;
		double ec;
		double ed;

		public MyLatLng(double longitude, double latitude) {
			m_LoDeg = (int) longitude;
			m_LoMin = (int) ((longitude - m_LoDeg) * 60);
			m_LoSec = (longitude - m_LoDeg - m_LoMin / 60.) * 3600;

			m_LaDeg = (int) latitude;
			m_LaMin = (int) ((latitude - m_LaDeg) * 60);
			m_LaSec = (latitude - m_LaDeg - m_LaMin / 60.) * 3600;

			m_Longitude = longitude;
			m_Latitude = latitude;
			m_RadLo = longitude * Math.PI / 180.;
			m_RadLa = latitude * Math.PI / 180.;
			ec = RJ + (RC - RJ) * (90. - m_Latitude) / 90.;
			ed = ec * Math.cos(m_RadLa);
		}
	}
	
	
	
	
}
