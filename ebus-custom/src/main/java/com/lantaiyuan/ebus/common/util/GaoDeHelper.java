package com.lantaiyuan.ebus.common.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.lantaiyuan.ebus.realtime.model.gaode.MyPoi;
import com.lantaiyuan.ebus.realtime.model.gaode.Poi;

/***
 * 
* <p>Title: GaoDeHelper</p>
* <p>Description: 调用高德api工具类</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年4月28日 下午3:35:38
 */
public class GaoDeHelper {
	/***
	 * 
	* <p>Title: getResult</p>
	* <p>Description: 获取符合条件的地点集合</p>
	* @param url
	* @param params
	* @param srcTypecodes
	* @return
	 */
	public static List<MyPoi> getResult(String url, Map<String, String> params, String srcTypecodes,String name) {
		String result = HttpClientHelper.get(url, params);

		if (StringUtils.isEmpty(result) || result.startsWith("error")) {
			return Collections.emptyList();
		}

		JSONObject jsonObject = JSONObject.parseObject(result);
		if (jsonObject.getIntValue("status") != 1) {
			return Collections.emptyList();
		}
		result = jsonObject.getString("pois");

		List<MyPoi> mypois = new ArrayList<>();
		List<Poi> pois = JSONObject.parseArray(result, Poi.class);

		if (!CollectionUtils.isEmpty(pois)) {
			pois.forEach(poi -> {
				//类别不包含在指定类别中并且查询结果name必须匹配目标内容
				if (!excludeTypecodes(poi.getTypecode(),srcTypecodes) && checkNameContain(poi.getName(),name)) {
					MyPoi myPoi = new MyPoi();
					BeanUtils.copyProperties(poi, myPoi);
					String[] lonLat = myPoi.getLocation().split(",");
					myPoi.setLon(lonLat[0]);
					myPoi.setLat(lonLat[1]);
					mypois.add(myPoi);
				}
			});
			
			return mypois;
		}

		return Collections.emptyList();
	}

	/***
	 * 
	* <p>Title: excludeTypecodes</p>
	* <p>Description: 判断返回结果集中某个类别是否存在于指定集中，若是，返回true</p>
	* @param targetTypecode
	* @param srcTypecodes
	* @return
	 */
	private static boolean excludeTypecodes(String targetTypecode, String srcTypecodes) {
		String[] typecodes = srcTypecodes.split(",");
		for (String typecode : typecodes) {
			if (typecode.equals(targetTypecode)) {
				return true;
			}
		}

		return false;
	}
	
	/***
	 * 
	* <p>Title: checkNameContain</p>
	* <p>Description: 匹配目标名称和搜索名称是否存在包含关系</p>
	* @param targetName
	* @param srcName
	* @return
	 */
	private static boolean checkNameContain(String targetName, String srcName){
		return targetName.indexOf(srcName) != -1 || srcName.indexOf(targetName) != -1;
	}
}
