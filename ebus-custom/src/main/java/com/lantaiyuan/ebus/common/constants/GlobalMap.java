package com.lantaiyuan.ebus.common.constants;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.lantaiyuan.ebus.custom.model.UserPosRecord;



/**
 * 描述:TODO
 * 作者:温海金
 * 最后更改时间:下午2:05:06
 */
public class GlobalMap {
	//外层map分城市存放用户最新的位置埋点 KEY:citycode  VALUE:也是一个map
	//里面的map保存具体城市的用户位置埋点 KEY:userId VALUE:UserPosRecord
	public static ConcurrentHashMap<String, Map<String, UserPosRecord>> userPosMap = new ConcurrentHashMap<>();
}
