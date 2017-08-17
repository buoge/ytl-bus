/**
* <p>Title: ConstantMap.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.map;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

import com.lantaiyuan.ebus.model.CachedRecord;
import com.lantaiyuan.ebus.model.GpsRecord;
import com.lantaiyuan.ebus.model.StationRecord;
import com.lantaiyuan.ebus.model.UserPosRecord;

/**
* <p>Title: ConstantMap</p>
* <p>Description: 用到的相关Map定义</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年5月5日 下午3:31:11
*/
public class GlobalMap {
	//记录车辆位置map，用于存放车辆最近位置
	public static ConcurrentHashMap<String, ConcurrentHashMap<String,GpsRecord>> busPosMap = new ConcurrentHashMap<>();
	
	//站点Map
	public static ConcurrentHashMap<String, ConcurrentHashMap<String,StationRecord>> stationMap = new ConcurrentHashMap<>();
	
	//记录人车合一时用户id/车辆gps包
	public static ConcurrentHashMap<String, Integer> userBusJoinMap = new ConcurrentHashMap<>();
	
	//记录用户位置map，用于存放用户最近6次位置
	public static ConcurrentHashMap<String, ConcurrentHashMap<String,BlockingQueue<UserPosRecord>>> userPosMap = new ConcurrentHashMap<>();

	//缓存用户初始位置及车辆初始位置Map
	public static ConcurrentHashMap<String,BlockingQueue<CachedRecord>> cachedMap = new ConcurrentHashMap<>();
}
