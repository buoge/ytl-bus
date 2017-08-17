package com.lty.kafka.consumer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.lty.constant.Constants;
import com.lty.enummodel.PacketTypeEnum;
import com.lty.model.Packet;
import com.lty.redis.RedisHelper;
import com.lty.springcontext.SpringContextLoader;
import com.lty.util.TimeUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;
public class KafkaCousumerClientMain implements MessageListener<Integer, String> {

	private static Logger logger = LoggerFactory.getLogger(KafkaCousumerClientMain.class);
	
	private JedisPool pool;
	private Pipeline p;
	private String cityCode;
	private Map<String, Map<String, String>> data;
	private int counter;
	private long timeUsed;
	private int flushCount;
	
	public KafkaCousumerClientMain(JedisPool jedisPool,String cityCode, int flushCount) {
		this.pool = jedisPool;
		this.cityCode = cityCode;
		this.flushCount = flushCount;
		Jedis jedis = pool.getResource();
		p = jedis.pipelined();
		data = new HashMap<>();
		counter = 0;
		timeUsed = 0;
	}

	@Override
	public void onMessage(ConsumerRecord<Integer, String> msg) {
		long start = System.currentTimeMillis();
		String payLoad = msg.value();
		counter++;
    	try {
    		JSONObject jsonObj = JSONObject.parseObject(payLoad);
    		Packet packet = new Packet(jsonObj);
    		
    		// 存放在redis中的key
    		String key = key(packet);
    		// 存放在redis中反方向的key
			String reversedKey = reversedKey(packet);
			
    		Map<String, String> routeBusMap = data.get(key);
    		if (CollectionUtils.isEmpty(routeBusMap)) {
    			routeBusMap = new HashMap<String, String>();
    		}	
    		List<String> gpsDataList = null;
    		JSONArray gpsDataJsonArray = null;
    		if (PacketTypeEnum.GPS.value().equals(packet.getPacketType())) {	// redis hash数据格式为key-packet data list
    			int runStatus = jsonObj.getIntValue("runstatus");
    			// 车辆状态值是一个1字节整数，最低位为0表示未营运，为1表示营运中，只保存营运中、未在场、当前包的gps实时数据至redis
   			  if (((byte)runStatus & 0x01) == 1 && ((runStatus >>> 7) & 0x01) == 0 && ((runStatus >>> 5) & 0x01) == 0) {
    				String gpsDatasJsonStr = routeBusMap.get(String.valueOf(packet.getVehicleId()));
	    			if (!StringUtils.isEmpty(gpsDatasJsonStr) && gpsDatasJsonStr.startsWith("[")) {
    					gpsDataList = JSONObject.parseArray(gpsDatasJsonStr, String.class);
	    			} else {
	    				gpsDataList = new LinkedList<>();
	    			}	
	    			gpsDataList.add(0, payLoad);
	    			gpsDataJsonArray = new JSONArray();
	    			gpsDataJsonArray.addAll(gpsDataList.size() <= 12 ? gpsDataList : gpsDataList.subList(0, 12));
	    			routeBusMap.put(String.valueOf(packet.getVehicleId()), gpsDataJsonArray.toJSONString());
    			} else { // 运行状态不正常的车不关注
    				return;
    			}
    		} else if (PacketTypeEnum.INSTATION.value().equals(packet.getPacketType()) 
    				|| PacketTypeEnum.OUTSTATION.value().equals(packet.getPacketType())) {
        		// redis hash数据格式为key-packet data
        		routeBusMap.put(String.valueOf(packet.getVehicleId()), payLoad);
    		}  else { // 其余包类型不关注
				return;
			}
    		// 删除反向的车辆数据
    		removeReversedBus(reversedKey.toString(),String.valueOf(packet.getVehicleId()), packet.getEventTime());
    		p.hmset(key, routeBusMap);
    		data.put(key, routeBusMap);
    		if (counter >= flushCount) {
    			counter = 0;
    			timeUsed = 0;
    			data.clear();
    			p.sync();
    		}
    		long end = System.currentTimeMillis();
    		timeUsed = timeUsed + (end - start);
    	} catch (JSONException e) {
    		logger.error("实时网关数据格式错误，请检查！", e);
    	} catch (Exception e) {
    		logger.error("实时网关数据处理异常，请检查！", e);
    	}
	}
	
	public static void main(String[] args) {
		SpringContextLoader.getInstance();
	}
	
	/**
	 * 存放在redis里的key
	 * @auther yangyang
	 * @return
	 */
	private String key(Packet packet) {
		StringBuffer sb = new StringBuffer();
		sb.append(Constants.PROTOCOL_VERSION).append(packet.getProtocolVersion())
			.append(Constants.GPRSID).append(packet.getGprsId())
			.append(Constants.DIRECTION).append(packet.getDirection())
			.append(Constants.CITYCODE).append(cityCode);
		return sb.toString();
	}
	
	
	/**
	 * 存放在redis中，反向线路的key
	 * @auther yangyang
	 * @param protocolVersion
	 * @param gprsId
	 * @param direction
	 * @return
	 */
	private String reversedKey(Packet packet) {
		StringBuffer sb = new StringBuffer();
		sb.append(Constants.PROTOCOL_VERSION).append(packet.getProtocolVersion())
			.append(Constants.GPRSID).append(packet.getGprsId())
			.append(Constants.DIRECTION).append(packet.getDirection() == 0 ? 1 : 0)
			.append(Constants.CITYCODE).append(cityCode);
		return sb.toString();
	}
	
	/**
	 * 删除相反方向的该车信息
	 * @auther yangyang
	 * @param reversedkey
	 * @param field
	 * @param eventTime
	 */
	private void removeReversedBus(String reversedkey, String field, String eventTime) {
		// 从redis里面获取到这辆车反向的的信息
		String reversedInfo = RedisHelper.hget(reversedkey, field);
		// 存在反向信息，继续处理
		if(!StringUtils.isEmpty(reversedInfo)) {
			String reversedTime;
			if (reversedInfo.startsWith("[")) { // 如果是gps包
				List<String> gpsList = JSONObject.parseArray(reversedInfo, String.class);
				if(!CollectionUtils.isEmpty(gpsList)) {
					JSONObject jsonObject = JSONObject.parseObject(gpsList.get(0));
					// 获取该反向信息的时间
					reversedTime = jsonObject.getString("eventTime");
				}else {
					// gps信息不存在，直接返回
					return;
				}
			} else { // instation包 和 outstation包
				JSONObject jsonObject = JSONObject.parseObject(reversedInfo);
				// 先当成instation包，获取时间
				reversedTime = jsonObject.getString("eventTime");
				if (StringUtils.isEmpty(reversedTime)) { // 如果是空的，代表是outstation包
					reversedTime = jsonObject.getString("outStationTime");
				}
			}
			long timeDiff = TimeUtils.timeDiff(reversedTime, eventTime);
			if (timeDiff > 0) { // 当前包更新，去除反向的那条数据
				RedisHelper.hdel(reversedkey, field);
			}
		}
	}
}