package com.lantaiyuan.ebus.common.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;

/***
 * 
* <p>Title: GpsCorrect</p>
* <p>Description:站台经纬度纠偏 </p>
* <p>Company: lty</p>
* @author liuhao
* @date 2016年12月20日 下午6:31:57
* version 1.0
 */
public class GpsCorrectUtil {
	final static double PI = 3.14159265358979324;
	final static int EARTH_RADIUS = 6378245;
	final static double EE = 0.00669342162296594323;
	static List<String> cityCodes = 
		new ArrayList<String>(){
			private static final long serialVersionUID = 1L;
			{
				add("111111");
			}
		};
	
	/**
	 * 重载纠偏方法，传入cityCode
	 * @auther yangyang
	 * @param wgLat
	 * @param wgLon
	 * @param latlng
	 * @param cityCode 	若为空，调用之前的transform方法，建议除站点以外的纠偏，均传入空
	 */
	public static void transform(double wgLat, double wgLon, double[] latlng, String cityCode) {
		if(!StringUtils.isEmpty(cityCode) && cityCodes.indexOf(cityCode) >= 0) {
			latlng[0] = wgLat;
			latlng[1] = wgLon;
		}else{
			transform(wgLat, wgLon, latlng);
		}
	}
	
	/***
	 * 
	* <p>Title: transform</p>
	* <p>Description: 传递经纬度，返回纠偏后的double数组</p>
	 */
	public static void transform(double wgLat, double wgLon, double[] latlng) {
		if (outOfChina(wgLat, wgLon)) {
			latlng[0] = wgLat;
			latlng[1] = wgLon;
			return;
		}
		double dLat = transformLat(wgLon - 105.0, wgLat - 35.0);
		double dLon = transformLon(wgLon - 105.0, wgLat - 35.0);
		double radLat = wgLat / 180.0 * PI;
		double magic = Math.sin(radLat);
		magic = 1 - EE * magic * magic;
		double sqrtMagic = Math.sqrt(magic);
		dLat = (dLat * 180.0) / ((EARTH_RADIUS * (1 - EE)) / (magic * sqrtMagic) * PI);
		dLon = (dLon * 180.0) / (EARTH_RADIUS / sqrtMagic * Math.cos(radLat) * PI);
		latlng[0] = wgLat + dLat;
		latlng[1] = wgLon + dLon;
	}
	
	/***
	 * 
	* <p>Title: transform</p>
	* <p>Description: 传递经纬度，看坐标是否在国内</p>
	 */
	private static boolean outOfChina(double lat, double lon) {
		if (lon < SysGlobalConstants.CN_MIN_LON || lon > SysGlobalConstants.CN_MAX_LON)
			return true;
		if (lat < SysGlobalConstants.CN_MIN_LAT || lat > SysGlobalConstants.CN_MAX_LAT)
			return true;
		return false;
	}

	/***
	 * 
	* <p>Title: transform</p>
	* <p>Description: 纬度转换</p>
	 */
	private static double transformLat(double x, double y) {
		double ret = -100.0 + 2.0 * x + 3.0 * y + 0.2 * y * y + 0.1 * x * y + 0.2 * Math.sqrt(Math.abs(x));
		ret += (20.0 * Math.sin(6.0 * x * PI) + 20.0 * Math.sin(2.0 * x * PI)) * 2.0 / 3.0;
		ret += (20.0 * Math.sin(y * PI) + 40.0 * Math.sin(y / 3.0 * PI)) * 2.0 / 3.0;
		ret += (160.0 * Math.sin(y / 12.0 * PI) + 320 * Math.sin(y * PI / 30.0)) * 2.0 / 3.0;
		return ret;
	}

	/***
	 * 
	* <p>Title: transform</p>
	* <p>Description: 经度转换</p>
	 */
	private static double transformLon(double x, double y) {
		double ret = 300.0 + x + 2.0 * y + 0.1 * x * x + 0.1 * x * y + 0.1 * Math.sqrt(Math.abs(x));
		ret += (20.0 * Math.sin(6.0 * x * PI) + 20.0 * Math.sin(2.0 * x * PI)) * 2.0 / 3.0;
		ret += (20.0 * Math.sin(x * PI) + 40.0 * Math.sin(x / 3.0 * PI)) * 2.0 / 3.0;
		ret += (150.0 * Math.sin(x / 12.0 * PI) + 300.0 * Math.sin(x / 30.0 * PI)) * 2.0 / 3.0;
		return ret;
	}
	
	/**
	 * 从高德纠偏到google
	 */
	public static double[] gcj02_To_Gps84(double lat, double lon) { 
		double[] gps = new double[2];
	    transform(lat, lon, gps);  
	    double lontitude = lon * 2 - gps[1];  
	    double latitude = lat * 2 - gps[0];  
	    return new double[]{latitude, lontitude};  
	} 
	
	public static void main(String[] args) {
		double[] gcj02_To_Gps84 = gcj02_To_Gps84(34.340490, 107.297249);
		System.out.println(gcj02_To_Gps84[0]);
		System.out.println(gcj02_To_Gps84[1]);
		/*double[] arr = new double[2];
		transform(34.33825, 107.283056, arr);*/
	}
}
