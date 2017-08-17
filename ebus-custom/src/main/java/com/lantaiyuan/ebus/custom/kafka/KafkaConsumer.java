package com.lantaiyuan.ebus.custom.kafka;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.lantaiyuan.ebus.common.constants.GlobalMap;
import com.lantaiyuan.ebus.custom.model.UserPosRecord;

/***
 * 
* <p>Title: KafkaConsumer</p>
* <p>Description: 消费kafka用户位置数据和车辆gps数据</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年5月5日 下午2:17:41
 */
@Configuration
public class KafkaConsumer {

	@KafkaListener(topics = "${kafka.topic}")
	public void listen(ConsumerRecord<Integer, String> record) {
		String datacollection = record.value();
		JSONObject dataJsonObj = JSONObject.parseObject(datacollection);
		if (StringUtils.isEmpty(dataJsonObj.get("userid"))) {//用户没有登入
			return;
		}
		String userId = dataJsonObj.get("userid").toString();
		Double longitude = Double.valueOf(dataJsonObj.get("longitude").toString());//经度
		Double latitude = Double.valueOf(dataJsonObj.get("latitude").toString());//纬度
		String citycode = dataJsonObj.get("citycode").toString();
	
	    UserPosRecord userPosRecord = new UserPosRecord(citycode, userId, longitude, latitude);
	    if(GlobalMap.userPosMap.containsKey(citycode)) {//内存中已经存在该城市数据
	    	//更新用户位置信息到该城市map中
	    	Map<String, UserPosRecord> cityMap = GlobalMap.userPosMap.get(citycode);
	    	if(cityMap.containsKey(userId)) {
	    		cityMap.remove(citycode);
	    	}
	    	cityMap.put(userId, userPosRecord);
	    } else {//不存在该城市的数据
	    	ConcurrentHashMap<String, UserPosRecord> cityMap = new ConcurrentHashMap<>();
	    	cityMap.put(userId, userPosRecord);
	    	GlobalMap.userPosMap.put(citycode, cityMap);
	    }
	}


}