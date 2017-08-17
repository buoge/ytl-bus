/**
* <p>Title: ComputeODTask.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.task;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.lantaiyuan.ebus.constants.GlobalConstants;
import com.lantaiyuan.ebus.map.GlobalMap;
import com.lantaiyuan.ebus.model.CachedRecord;
import com.lantaiyuan.ebus.model.GpsRecord;
import com.lantaiyuan.ebus.model.ProduceDestPoint;
import com.lantaiyuan.ebus.model.ProduceOriginPoint;
import com.lantaiyuan.ebus.model.StationRecord;
import com.lantaiyuan.ebus.model.UserPosRecord;
import com.lantaiyuan.ebus.model.modelenum.ODPointTypeEnum;
import com.lantaiyuan.ebus.util.DistanceUtil;

/**
 * <p>Title: ComputeODTask</p>
 * <p>Description:计算OD点算法核心类 </p>
 * <p> Company: lty</p>
 * @author liuhao
 * @date 2017年5月5日 下午3:48:34
 */
@Component
public class ODAlgorithmTask {
	private static final Logger logger = LoggerFactory.getLogger(ODAlgorithmTask.class);
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	/***
	 * 
	 * <p>Title: computeODTask</p>
	 * <p>Description: 计算O点</p>
	 */
	@Async("taskOAsync")
	public void computeOTask(String cityCode, String userId, BlockingQueue<UserPosRecord> queue) {
		//先简单处理 如果已经上车就不再计算O点	yangyang
		if (GlobalMap.userBusJoinMap.containsKey(userId)) {
			return;
		}
		double speed = computeSpeed(queue);
		// 存放疑似人车合一车辆
		Map<String, GpsRecord> targetMap = new HashMap<>();

		if (speed >= GlobalConstants.FOOT_TO_BUS_SPOT) {//速度达到人车合一临界值，计算o
			ConcurrentHashMap<String, GpsRecord> map = GlobalMap.busPosMap.get(cityCode);
			map.forEach((k, v) -> {
				if (computeUser2BusDistance(queue, v) < GlobalConstants.USER_BUS_TOGETHER_DISTANCE) {
					targetMap.put(k, v);
				}
			});
		}else{//速度未达标，直接返回
			return;
		}

		int count = targetMap.size();

		if (count == 0) {
			return;
		} else if (count == 1) { // 只有一辆车符合条件
			// 如果之前缓存过
			if (GlobalMap.cachedMap.containsKey(userId)) {
				BlockingQueue<CachedRecord> cachedRecords = GlobalMap.cachedMap.get(userId);
		
				for (Map.Entry<String, GpsRecord> entry : targetMap.entrySet()) {
					GpsRecord gpsRecord = entry.getValue();

					// 取最初缓存记录，并将此GpsRecord加入O点
					for (Iterator<CachedRecord> iter = cachedRecords.iterator(); iter.hasNext();) {
						CachedRecord cachedRecord = iter.next();
						if (cachedRecord.getGpsRecord().getVehicleId() == gpsRecord.getVehicleId()) {
							GlobalMap.userBusJoinMap.put(userId, cachedRecord.getGpsRecord().getVehicleId());
							// 计入O点
							odStoredToMap(cityCode, userId, cachedRecord.getGpsRecord(), ODPointTypeEnum.O_POINT.val());
							break;
						}
					}
				}

				//清空cachedMap?
				clearMapRecord(userId, GlobalMap.cachedMap);
			} else {
				GpsRecord gpsRecord = null;

				for (Map.Entry<String, GpsRecord> entry : targetMap.entrySet()) {
					gpsRecord = entry.getValue();
				}

				GlobalMap.userBusJoinMap.put(userId, gpsRecord.getVehicleId());

				// 计入O点
				odStoredToMap(cityCode, userId, gpsRecord, ODPointTypeEnum.O_POINT.val());

			}

			//清空userPosMap?
			clearMapRecord(cityCode, userId, GlobalMap.userPosMap);
		} else if (count >= 2) {
			// 如果之前缓存过
			if (GlobalMap.cachedMap.containsKey(userId)) {
				BlockingQueue<CachedRecord> cachedRecords = GlobalMap.cachedMap.get(userId);

				// 缓存次数
				targetMap.forEach((k, v) -> {
					cachedRecords.forEach(cachedRecord -> {
						if (cachedRecord.getGpsRecord().getVehicleId() == v.getVehicleId()) {
							cachedRecord.setTimes(cachedRecord.getTimes() + 1);
						}
					});
				});
				
				//先简单处理，遍历若某个缓存车辆次数达到了10次，则将此GpsRecord加入O点
				for (Iterator<CachedRecord> iter = cachedRecords.iterator(); iter.hasNext();) {
					CachedRecord cachedRecord = iter.next();
					if (cachedRecord.getTimes() >= GlobalConstants.USER_JOIN_BUS_TIMES) {
						GlobalMap.userBusJoinMap.put(userId, cachedRecord.getGpsRecord().getVehicleId());

						// 计入O点
						odStoredToMap(cityCode, userId, cachedRecord.getGpsRecord(), ODPointTypeEnum.O_POINT.val());

						//清空userPosMap?
						clearMapRecord(cityCode, userId, GlobalMap.userPosMap);
						//清空cachedMap?
						clearMapRecord(userId, GlobalMap.cachedMap);
						return;
					}
				}
				
				
			}
			// 首次计算
			else {
				BlockingQueue<CachedRecord> cachedRecords = new ArrayBlockingQueue<>(targetMap.size());

				// 所有满足条件的车辆GpsRecord初始化入cachedMap
				targetMap.forEach((k, v) -> {
					CachedRecord cachedRecord = new CachedRecord();
					cachedRecord.setGpsRecord(v);
					// 初始化1次
					cachedRecord.setTimes(1);
					cachedRecords.add(cachedRecord);
				});

				GlobalMap.cachedMap.put(userId, cachedRecords);
			}
		}
	}

	/***
	 * 
	 * <p> Title: oStoredToMap</p>
	 * <p> Description: od点存入Map</p>
	 */
	private void odStoredToMap(String cityCode, String userId, GpsRecord gpsRecord, int odType) {
		ConcurrentHashMap<String, StationRecord> stationRecordMap = GlobalMap.stationMap.get(cityCode);
		StringBuilder sb = new StringBuilder().append(gpsRecord.getGprsId()).append("_")
				.append(gpsRecord.getDirection()).append("_").append(gpsRecord.getNextStationId() - 1);
		StationRecord stationRecord = stationRecordMap.get(sb.toString());
		if (stationRecord == null || stationRecord.getStationid() == null) {
			logger.warn("数据库中没有的线站关系(routeId-direction-nextStationNo-cityCode)：" + gpsRecord.getGprsId() + "-"
					+ gpsRecord.getDirection() + "-" + gpsRecord.getNextStationId() + "-" + cityCode);
			if (odType == ODPointTypeEnum.D_POINT.val()) {
				GlobalMap.userBusJoinMap.remove(userId);// 手动让此人下车
			}
			return;
		}
		if (odType == ODPointTypeEnum.O_POINT.val()) {
			// 将O点信息存入kafka	yangyang
			ProduceOriginPoint originPoint = new ProduceOriginPoint().cityCode(cityCode).userId(userId)
					.routeId(gpsRecord.getGprsId()).direction(gpsRecord.getDirection())
					.startStationId(stationRecord.getStationid()).startTime(gpsRecord.getEventTime())
					.vehicleId(gpsRecord.getVehicleId()).lat(gpsRecord.getLatitude().doubleValue())
					.lon(gpsRecord.getLongitude().doubleValue());
			kafkaTemplate.sendDefault(JSONObject.toJSONString(originPoint));
			logger.info("成功写入kafka之O点：详细信息-->" + originPoint.toString());
		} else {
			// 将D点信息存入kafka	yangyang
			ProduceDestPoint destPoint = new ProduceDestPoint().cityCode(cityCode).userId(userId)
					.routeId(gpsRecord.getGprsId()).direction(gpsRecord.getDirection())
					.endStationId(stationRecord.getStationid()).endTime(gpsRecord.getEventTime())
					.vehicleId(gpsRecord.getVehicleId()).lat(gpsRecord.getLatitude().doubleValue())
					.lon(gpsRecord.getLongitude().doubleValue());
			kafkaTemplate.sendDefault(JSONObject.toJSONString(destPoint));
			logger.info("成功写入kafka之D点：详细信息-->" + destPoint.toString());
		}
	}

	/***
	 * <p>Title: computeDTask</p>
	 * <p>Description: 计算D点，进入该方法表明该用户已上过车</p>
	 */
	@Async("taskDAsync")
	public void computeDTask(String cityCode, String userId, BlockingQueue<UserPosRecord> queue) {
		GpsRecord realtimeBusPosRecord = getVehicleRealPos(cityCode, GlobalMap.userBusJoinMap.get(userId));
		double speed = computeSpeed(queue);
		if (speed < GlobalConstants.FOOT_TO_BUS_SPOT && computeUser2BusDistance(queue,
				realtimeBusPosRecord) >= GlobalConstants.USER_BUS_SEPARATE_DISTANCE) {
			// 对D点进行最后修正（确认下车）
			odStoredToMap(cityCode, userId, realtimeBusPosRecord, ODPointTypeEnum.D_POINT.val());
			//清空userBusJoinMap？
			clearMapRecord(userId, GlobalMap.userBusJoinMap);
			return;
		}else {
			// 必须放在else里 不然真正下车的 会重复存两次
			// 覆盖存入D点（疑似D点，或者说每分钟运行轨迹）
			odStoredToMap(cityCode, userId, realtimeBusPosRecord, ODPointTypeEnum.D_POINT.val());
		}
	}

	/***
	 * 
	 * <p>Title: clearMapRecord</p>
	 * <p>Description: 清除map中相应记录</p>
	 */
	private void clearMapRecord(String userId, ConcurrentHashMap recordMap) {
		recordMap.remove(userId);
	}

	/***
	 * 
	 * <p> Title: clearMapRecord</p>
	 * <p> Description: 清除map中相应记录</p>
	 */
	private void clearMapRecord(String cityCode, String userId, ConcurrentHashMap recordMap) {
		ConcurrentHashMap map = (ConcurrentHashMap) recordMap.get(cityCode);
		map.remove(userId);
	}

	/***
	 * 
	 * <p>Title: getVehicleRealPos</p>
	 * <p>Description: 获取车辆实时位置</p>
	 */
	public GpsRecord getVehicleRealPos(String cityCode, Integer vehicleId) {
		ConcurrentHashMap<String, GpsRecord> curBusPosMap = GlobalMap.busPosMap.get(cityCode);
		return curBusPosMap.get(vehicleId.toString());
	}

	/**
	 * <p>Title: computeUser2BusDistance</p>
	 * <p> Description: 计算人车距离</p>
	 */
	private double computeUser2BusDistance(BlockingQueue<UserPosRecord> queue, GpsRecord v) {
		// 强转会失败，改用这种方式	yangyang
		UserPosRecord[] userPosRecords = new UserPosRecord[GlobalConstants.USER_RECORD_NUM];
		queue.toArray(userPosRecords);
		UserPosRecord userPosRecord = userPosRecords[userPosRecords.length - 1];
		if (userPosRecord == null || v == null) {
			throw new NullPointerException();
		}
		double distance = DistanceUtil.countDistance(userPosRecord.getLongitude().doubleValue(),
				userPosRecord.getLatitude().doubleValue(), v.getLongitude().doubleValue(),
				v.getLatitude().doubleValue());
		if (distance < GlobalConstants.USER_BUS_TOGETHER_DISTANCE) {
			logger.info("bus person distance: " + distance);
		}
		return distance;
	}

	/**
	 * <p>Title: computeSpeed</p>
	 * <p>Description:计算第一点和最后一点UserPosRecord之间的平均速度</p>
	 */
	private double computeSpeed(BlockingQueue<UserPosRecord> queue) {
		// 强转会失败，改用这种方式	yangyang
		UserPosRecord[] userPosRecords = new UserPosRecord[GlobalConstants.USER_RECORD_NUM];
		queue.toArray(userPosRecords);

		UserPosRecord start = userPosRecords[0];
		UserPosRecord end = userPosRecords[userPosRecords.length - 1];

		double distance = DistanceUtil.countDistance(start.getLongitude().doubleValue(),
				start.getLatitude().doubleValue(), end.getLongitude().doubleValue(), end.getLatitude().doubleValue());

		long time1 = start.getCurrenttime().getTime();
		long time2 = end.getCurrenttime().getTime();

		long time = (time2 - time1) / 1000;
		return mPerSecondToKMPerHour(distance / time);
	}
	
	/**
	 * 从m/s 转换为 km/h
	 * 1m/s = 3.6km/h 所以要乘以3.6
	 * @author yangyang
	 * @param mPerSecond
	 * @return
	 */
	private double mPerSecondToKMPerHour(double mPerSecond){
		return mPerSecond * GlobalConstants.MPS_KMPH_RADIX;
	}
}
