package com.lantaiyuan.ebus.consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lantaiyuan.ebus.constants.GlobalConstants;
import com.lantaiyuan.ebus.map.GlobalMap;
import com.lantaiyuan.ebus.model.GpsRecord;
import com.lantaiyuan.ebus.model.UserPosRecord;
import com.lantaiyuan.ebus.model.modelenum.CityTopicEnum;
import com.lantaiyuan.ebus.model.modelenum.PackTypeEnum;
import com.lantaiyuan.ebus.task.ODAlgorithmTask;

/***
 * 
* <p>Title: KafkaConsumer</p>
* <p>Description: 消费kafka用户位置数据和车辆gps数据</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年5月5日 下午2:17:41
 */
public class KafkaConsumer {
	
	@Autowired
	private ODAlgorithmTask odAlgorithmTask;
	
//	@KafkaListener(topics = "${kafka.userpos.topic}")
//	@KafkaListener(topics="${kafka.topic}")
	@KafkaListener(topics="${kafka.topic2}")
	public void listen(ConsumerRecord<Integer, String> msg) {
		String topic = msg.topic();
		
		String content = msg.value(); 

		CityTopicEnum cityTopicEnum = CityTopicEnum.desc(topic);
		
		switch (cityTopicEnum) {
		case BENGBU_TOPIC:
			consumeKafkaData(CityTopicEnum.BENGBU_TOPIC.getCityCode(), content);
			break;
		case TIANSHUI_TOPIC:
			consumeKafkaData(CityTopicEnum.TIANSHUI_TOPIC.getCityCode(), content);
			break;
		case KAIPING_TOPIC:
			consumeKafkaData(CityTopicEnum.KAIPING_TOPIC.getCityCode(), content);
			break;
		case EERDUOSI_TOPIC:
			consumeKafkaData(CityTopicEnum.EERDUOSI_TOPIC.getCityCode(), content);
			break;
		case DATONG_TOPIC:
			consumeKafkaData(CityTopicEnum.DATONG_TOPIC.getCityCode(), content);
			break;
		case CHIBI_TOPIC:
			consumeKafkaData(CityTopicEnum.CHIBI_TOPIC.getCityCode(), content);
			break;
		case SHANGQIU_TOPIC:
			consumeKafkaData(CityTopicEnum.SHANGQIU_TOPIC.getCityCode(), content);
			break;
		case BAZHONG_TOPIC:
			consumeKafkaData(CityTopicEnum.BAZHONG_TOPIC.getCityCode(), content);
			break;
		case QINHUANGDAO_TOPIC:
			consumeKafkaData(CityTopicEnum.QINHUANGDAO_TOPIC.getCityCode(), content);
			break;
		case CHANGSHA_TOPIC:
			consumeKafkaData(CityTopicEnum.CHANGSHA_TOPIC.getCityCode(), content);
			break;
		case MUDANJIANG_TOPIC:
			consumeKafkaData(CityTopicEnum.MUDANJIANG_TOPIC.getCityCode(), content);
			break;
		case HANDAN_TOPIC:
			consumeKafkaData(CityTopicEnum.HANDAN_TOPIC.getCityCode(), content);
			break;
		case BAOJI_TOPIC:
			consumeKafkaData(CityTopicEnum.BAOJI_TOPIC.getCityCode(), content);
			break;
		case LIUZHOU_TOPIC:
			consumeKafkaData(CityTopicEnum.LIUZHOU_TOPIC.getCityCode(), content);
			break;
		case QIANJIANG_TOPIC:
			consumeKafkaData(CityTopicEnum.QIANJIANG_TOPIC.getCityCode(), content);
			break;
		case TONGREN_TOPIC:
			consumeKafkaData(CityTopicEnum.TONGREN_TOPIC.getCityCode(), content);
			break;
		default:
			break;
		}

	}
	
	@KafkaListener(topics = "userPoseTopic")
	public void listenUserPos(ConsumerRecord<Integer, String> msg) {
		String content = msg.value();
		
		JSONObject jsonObj = JSONObject.parseObject(content);
		
		String cityCode = jsonObj.getString("citycode");

		CityTopicEnum cityTopicEnum = CityTopicEnum.cityCode(cityCode);
		switch (cityTopicEnum) {
		case BENGBU_TOPIC:
			consumeKafkaData(CityTopicEnum.BENGBU_TOPIC.getCityCode(), jsonObj);
			break;
		case TIANSHUI_TOPIC:
			consumeKafkaData(CityTopicEnum.TIANSHUI_TOPIC.getCityCode(), jsonObj);
			break;
		case KAIPING_TOPIC:
			consumeKafkaData(CityTopicEnum.KAIPING_TOPIC.getCityCode(), jsonObj);
			break;
		case EERDUOSI_TOPIC:
			consumeKafkaData(CityTopicEnum.EERDUOSI_TOPIC.getCityCode(), jsonObj);
			break;
		case DATONG_TOPIC:
			consumeKafkaData(CityTopicEnum.DATONG_TOPIC.getCityCode(), jsonObj);
			break;
		case CHIBI_TOPIC:
			consumeKafkaData(CityTopicEnum.CHIBI_TOPIC.getCityCode(), jsonObj);
			break;
		case SHANGQIU_TOPIC:
			consumeKafkaData(CityTopicEnum.SHANGQIU_TOPIC.getCityCode(), jsonObj);
			break;
		case BAZHONG_TOPIC:
			consumeKafkaData(CityTopicEnum.BAZHONG_TOPIC.getCityCode(), jsonObj);
			break;
		case QINHUANGDAO_TOPIC:
			consumeKafkaData(CityTopicEnum.QINHUANGDAO_TOPIC.getCityCode(), jsonObj);
			break;
		case CHANGSHA_TOPIC:
			consumeKafkaData(CityTopicEnum.CHANGSHA_TOPIC.getCityCode(), jsonObj);
			break;
		case MUDANJIANG_TOPIC:
			consumeKafkaData(CityTopicEnum.MUDANJIANG_TOPIC.getCityCode(), jsonObj);
			break;
		case HANDAN_TOPIC:
			consumeKafkaData(CityTopicEnum.HANDAN_TOPIC.getCityCode(), jsonObj);
			break;
		case BAOJI_TOPIC:
			consumeKafkaData(CityTopicEnum.BAOJI_TOPIC.getCityCode(), jsonObj);
			break;
		case LIUZHOU_TOPIC:
			consumeKafkaData(CityTopicEnum.LIUZHOU_TOPIC.getCityCode(), jsonObj);
			break;
		case QIANJIANG_TOPIC:
			consumeKafkaData(CityTopicEnum.QIANJIANG_TOPIC.getCityCode(), jsonObj);
			break;
		case TONGREN_TOPIC:
			consumeKafkaData(CityTopicEnum.TONGREN_TOPIC.getCityCode(), jsonObj);
			break;

		default:
			break;
		}

	}

	/**
	 * <p>
	 * Title: consumeKafkaData
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param string
	 * @param content
	 */
	private void consumeKafkaData(String cityCode, String content) {
		JSONObject jsonObj = JSONObject.parseObject(content);
		String packType = jsonObj.getString("packetType");
		PackTypeEnum packTypeEnum = PackTypeEnum.value(packType);
		if (packTypeEnum == PackTypeEnum.GPS_PACK) {
			consumeGpsData(cityCode, jsonObj);
		} else {
			return;
		}
	}

	/**
	 * <p>
	 * Title: consumeGpsData
	 * </p>
	 * <p>
	 * Description:处理实时车辆gps数据
	 * </p>
	 * 
	 * @param cityCode
	 * @param jsonObj
	 */
	private void consumeGpsData(String cityCode, JSONObject jsonObj) {
		GpsRecord gpsRecord = JSON.toJavaObject(jsonObj, GpsRecord.class);
		String vehicleId = String.valueOf(gpsRecord.getVehicleId());
		
		if(GlobalMap.busPosMap.containsKey(cityCode)){
			ConcurrentHashMap<String,GpsRecord> map =  GlobalMap.busPosMap.get(cityCode);
			map.put(vehicleId, gpsRecord);
		}
		else {
			ConcurrentHashMap<String,GpsRecord> map = new ConcurrentHashMap<>();
			map.put(vehicleId, gpsRecord);
			GlobalMap.busPosMap.put(cityCode, map);
		}
		
	}
	
	

	/**
	 * <p>
	 * Title: consumeKafkaData
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	private void consumeKafkaData(String cityCode, JSONObject jsonObj) {
		consumeUserData(cityCode, jsonObj);
	}

	/**
	 * <p>
	 * Title: consumeUserData
	 * </p>
	 * <p>
	 * Description: 处理用户位置数据
	 * </p>
	 * 
	 * @param cityCode
	 * @param jsonObj
	 */
	private void consumeUserData(String cityCode, JSONObject jsonObj) {
		UserPosRecord userPosRecord = JSON.toJavaObject(jsonObj, UserPosRecord.class);

		String userId = userPosRecord.getUserid();

		if (GlobalMap.userPosMap.containsKey(cityCode)) {
			ConcurrentHashMap<String, BlockingQueue<UserPosRecord>> map = GlobalMap.userPosMap.get(cityCode);
			if (map.containsKey(userId)) {
				BlockingQueue<UserPosRecord> queue = map.get(userId);
				int size = queue.size();
				if (size >= GlobalConstants.USER_RECORD_NUM) {
					queue.poll();
					queue.add(userPosRecord);
				    
					//看是否上过车，是则进入D点计算任务
					if (GlobalMap.userBusJoinMap.containsKey(userId)){
						odAlgorithmTask.computeDTask(cityCode, userId, queue);
					}
					//看是否上过车，否则进入O点计算任务
					else{
						odAlgorithmTask.computeOTask(cityCode, userId, queue);
					}
				} else if (size <= GlobalConstants.USER_RECORD_NUM - 1) {
					queue.add(userPosRecord);
				}
			} else {
				BlockingQueue<UserPosRecord> queue = new ArrayBlockingQueue<>(GlobalConstants.USER_RECORD_NUM);
				queue.add(userPosRecord);
				map.put(userId, queue);
			}
		} else {
			ConcurrentHashMap<String, BlockingQueue<UserPosRecord>> map = new ConcurrentHashMap<>();
			BlockingQueue<UserPosRecord> queue = new ArrayBlockingQueue<>(GlobalConstants.USER_RECORD_NUM);
			queue.add(userPosRecord);
			map.put(userId, queue);
			GlobalMap.userPosMap.put(cityCode, map);
		}
	}

}