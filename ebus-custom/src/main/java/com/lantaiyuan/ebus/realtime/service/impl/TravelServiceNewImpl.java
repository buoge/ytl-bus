package com.lantaiyuan.ebus.realtime.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;
import com.lantaiyuan.ebus.common.redis.RedisHelper;
import com.lantaiyuan.ebus.common.util.DistanceUtil;
import com.lantaiyuan.ebus.common.util.GpsCorrectUtil;
import com.lantaiyuan.ebus.common.util.Tools;
import com.lantaiyuan.ebus.custom.model.BaseBus;
import com.lantaiyuan.ebus.custom.model.BaseRoute;
import com.lantaiyuan.ebus.custom.model.BaseStation;
import com.lantaiyuan.ebus.custom.model.BaseStationQueryModel;
import com.lantaiyuan.ebus.custom.model.RelRouteStation;
import com.lantaiyuan.ebus.custom.service.BaseBusServiceI;
import com.lantaiyuan.ebus.custom.service.BaseRouteServiceI;
import com.lantaiyuan.ebus.custom.service.BaseStationServiceI;
import com.lantaiyuan.ebus.custom.service.RelRouteStationServiceI;
import com.lantaiyuan.ebus.realtime.model.BusDesc;
import com.lantaiyuan.ebus.realtime.model.Path;
import com.lantaiyuan.ebus.realtime.model.RealTime;
import com.lantaiyuan.ebus.realtime.model.RealTimeQueryModel;
import com.lantaiyuan.ebus.realtime.model.enummodel.PacketType;
import com.lantaiyuan.ebus.realtime.service.RelRouteAssistStationServiceI;
import com.lantaiyuan.ebus.realtime.service.TravelServiceI;

/**
 * @Title: TravelServiceNewImpl.java
 * @Package com.lantaiyuan.ebus.custom.service.impl
 * @Description:
 * @author yangyang
 * @date 2017年1月10日 上午10:02:34
 * @version v1.0
 */
@Service("travelServiceNew")
public class TravelServiceNewImpl extends BaseService<BaseStation, BaseStationQueryModel> implements TravelServiceI {

	private static Logger logger = LoggerFactory.getLogger(TravelServiceNewImpl.class);

	@Resource
	public BaseRouteServiceI baseRouteService;
	@Resource
	public BaseStationServiceI baseStationService;
	@Resource
	public RelRouteStationServiceI relRouteStationService;
	@Resource
	public BaseBusServiceI busService;
	@Resource
	public RelRouteAssistStationServiceI relRouteAssistStationService;

	@Override
	public RealTime getNearestBus(String cityCode, BaseStation userStation, BaseRoute route, Integer userStationNo) {
		RealTimeQueryModel realTime = new RealTimeQueryModel();
		realTime.citycode(cityCode).direction(route.getDirection()).routeid(route.getRouteid())
				.userstationno(userStationNo).stationid(String.valueOf(userStation.getStationid()));
		List<RealTime> busList = getBusList(realTime, userStation);
		return getNearestBus(busList);
	}

	/**
	 * 抽出公用方法，获取最近一辆车的实时信息
	 * @author yangyang
	 * @param busList
	 * @return
	 */
	@Override
	public RealTime getNearestBus(List<RealTime> busList) {
		List<RealTime> unArrivedBusList = new ArrayList<>();
		busList.forEach(bus -> {
			if (bus.getDesc().getStationnumber() > 0 || (bus.getDesc().getStationnumber() == 0
					&& bus.getDesc().getType() == PacketType.INSTATION.getType())) {
				unArrivedBusList.add(bus);
			}
		});
		unArrivedBusList.sort((first, second) -> {
			if (first.getDesc().getStationnumber() == second.getDesc().getStationnumber()) {
				return first.getDesc().getDistance().compareTo(second.getDesc().getDistance());
			}
			return first.getDesc().getStationnumber() - second.getDesc().getStationnumber();
		});
		return unArrivedBusList.size() > 0 ? unArrivedBusList.get(0) : new RealTime(new BaseBus(), new BusDesc());
	}

	/**
	 * <p>
	 * Title: getUserStationNo
	 * </p>
	 * <p>
	 * Description: 获取用户当前站站序
	 * </p>
	 * 
	 * @author liuhao 获取用户当前站站序
	 * 
	 * @param routeId
	 * @param userStation
	 * @param direction
	 * @return
	 */
	@Override
	public Integer getUserStationNo(String routeId, BaseStation userStation, int direction) {
		return relRouteStationService.getStationNo(routeId, userStation.getStationid(), direction,
				userStation.getCitycode());
	}

	@Override
	public BaseDAO<BaseStation, BaseStationQueryModel> getDao() {
		return null;
	}

	/**
	 * 处理经纬度
	 * 
	 * @param listString
	 * @param requestParam
	 * @return
	 */
	private Path processLonAndLan(List<String> listString) {
		Path path = new Path(0.0, 0.0);
		Double lon, lan;
		for (String json : listString) {
			JSONObject requestParam = JSONObject.parseObject(json);
			lon = requestParam.getDouble("longitude");
			lan = requestParam.getDouble("latitude");
			if (lon != 0 && lan != 0) {
				path.setLatitude(lan);
				path.setLongitude(lon);
				return path;
			}
		}
		return path;
	}

	/**
	 * 返回存在redis里实时信息的key值
	 * 
	 * @auther yangyang
	 */
	private String getRealTimeKey(String protocolver, String routeId, int direction, String cityCode) {
		StringBuilder builder = new StringBuilder();
		builder.append("KEY:PROTOCOLVER:").append(protocolver).append(":GPRSID:").append(routeId).append(":DIRECTION:")
				.append(direction).append(":CITYCODE:").append(cityCode);
		return builder.toString();
	}

	/**
	 * 纠正经纬度
	 * 
	 * @auther yangyang
	 * @param path
	 * @return
	 */
	private Path correctGps(Path path) {
		double[] latlng = { 0, 0 };
		GpsCorrectUtil.transform(path.getLatitude(), path.getLongitude(), latlng);
		path.setLatitude(latlng[0]);
		path.setLongitude(latlng[1]);
		return path;
	}

	private String getBusCurrentStationId(int nextStaitonNo, String routeId,
			Map<String, RelRouteStation> keyIsStationNo) {
		// 根据bus下一站序获取bus当前站序
		int currentNo = nextStaitonNo - 1;
		// 根据bus当前站序，routeId,direction，获取站点Id
		RelRouteStation rel = keyIsStationNo.get(String.valueOf(currentNo));
		if (StringUtils.isEmpty(rel)) {
			logger.warn("数据库与gps或in station数据不一致，rel_route_station不存在如下站点信息：routeId-".concat(routeId).concat(",当前站站序-")
					.concat(String.valueOf(currentNo)));
			return null;
		}
		return rel.getStationid();
	}

	/**
	 * 初始化station
	 * 
	 * @auther yangyang
	 */
	private Map<String, BaseStation> stationMap(String cityCode, String routeId, int direction) {
		return baseStationService.getCityStations(cityCode, routeId, direction);
	}

	/**
	 * 初始化线站关系
	 * 
	 * @auther yangyang
	 */
	private Map<String, RelRouteStation> relMap(String cityCode, String routeId, int direction) {
		return relRouteStationService.getCityRelRouteStation(routeId, direction, cityCode);
	}

	/**
	 * 功能描述:查看是否是指定距离范围内的站点，直接由一期接口改造而来 作者:温海金 最后更改时间 : 2016年12月22日 下午3:00:53
	 */
	@Override
	public boolean isNearStation(BaseStation station, double longitude, double latitude, double red) {
		double distance = DistanceUtil.countDistance(station.getLongitude().doubleValue(),
				station.getLatitude().doubleValue(), longitude, latitude);
		if (red >= distance) {
			return true;
		}
		return false;
	}

	@Override
	public List<RealTime> getBusList(RealTimeQueryModel realTime, BaseStation userStation) {
		/**
		 * Redis的key
		 */
		String key = getRealTimeKey(SysGlobalConstants.PROTOCOLVER, realTime.getRouteid(), realTime.getDirection(),
				realTime.getCitycode());
		/**
		 * 获取相关的实时信息
		 */
		Map<String, String> map = RedisHelper.hgetall(key);

		if (CollectionUtils.isEmpty(map)) {
			return Collections.emptyList();
		}

		/**
		 * 获取与线路相关的站点 获取与线路相关的线站关系
		 */
		Map<String, BaseStation> stationMap = stationMap(realTime.getCitycode(), realTime.getRouteid(),
				realTime.getDirection());
		Map<String, RelRouteStation> keyIsStationNo = relMap(realTime.getCitycode(), realTime.getRouteid(),
				realTime.getDirection());
		// 如果不存在线站关系
		if (CollectionUtils.isEmpty(keyIsStationNo)) {
			return Collections.emptyList();
		}

		List<RealTime> busList = new ArrayList<>();
		map.forEach((k, v) -> {
			RealTime bus;
			if (v.startsWith("{")) {// outstation or instation
				bus = processInstationOrOutstation(v, realTime, userStation, stationMap, keyIsStationNo);
			} else {// gps
				bus = processGPS(v, realTime, userStation, keyIsStationNo);
			}
			if (bus == null) {
				return;
			}
			busList.add(bus);
		});
		return processDistance(addBusPlateNumber(busList, realTime.getCitycode()), realTime.getRouteid(),
				realTime.getCitycode(), realTime.getDirection(), realTime.getStationid());
	}

	/**
	 * 处理车辆距离，保证相对于同一站点同一辆车的距离不断减少
	 * 
	 * @auther yangyang
	 * @return
	 */
	private List<RealTime> processDistance(List<RealTime> list, String routeId, String cityCode, Integer direction,
			String stationId) {
		List<RealTime> unArrived = new ArrayList<>();
		list.forEach(bus -> {
			if (bus.getDesc().getStationnumber() > 0) {
				unArrived.add(bus);
			}
		});
		unArrived.forEach(bus -> {
			// key gprsId:direction:vehicleId:cityCode:stationId
			// value eventTime:distance
			StringBuilder sb = new StringBuilder();
			sb.append("busDistance:").append(routeId).append(":").append(direction).append(":")
					.append(bus.getBus().getVehicleid()).append(":").append(cityCode).append(":").append(stationId);
			String value = RedisHelper.get(sb.toString());
			if (value == null) {// 如果为空，就将当前的距离设置进去
				RedisHelper.setWithExpireTime(sb.toString(), String.valueOf(bus.getDesc().getDistance()),
						SysGlobalConstants.TIME_DIFF * 60);
			} else { // 如果有之前的距离
				double distance = Double.valueOf(value);
				if (distance < bus.getDesc().getDistance()) { // 距离反而变大
					bus.getDesc().setDistance(distance);
				} else {
					RedisHelper.setWithExpireTime(sb.toString(), String.valueOf(bus.getDesc().getDistance()),
							SysGlobalConstants.TIME_DIFF * 60);
				}
			}
		});
		return list;
	}

	private List<RealTime> addBusPlateNumber(List<RealTime> busList, String cityCode) {
		if (busList == null || busList.size() <= 0) {
			return Collections.emptyList();
		}
		List<RealTime> resultList = new ArrayList<>();
		Map<String, BaseBus> busMap = busService.getBuses(busList, cityCode);
		busList.forEach(bus -> {
			BaseBus busInfo = busMap.get(bus.getBus().getVehicleid());
			if (busInfo == null) {
				logger.warn("vehicleId为".concat(bus.getBus().getVehicleid()).concat(",cityCode为").concat(cityCode)
						.concat("的车辆在数据库中不存在！"));
				// 数据库中没有的车不予显示
			} else {
				bus.setBus(busInfo);
				resultList.add(bus);
			}
		});
		return resultList;
	}

	private RealTime processGPS(String json, RealTimeQueryModel realTime, BaseStation userStation,
			Map<String, RelRouteStation> keyIsStationNo) {
		List<String> gpsList = JSON.parseArray(json, String.class);
		if (gpsList != null && gpsList.size() > 0) {
			JSONObject requestParam = JSONObject.parseObject(gpsList.get(0));
			String vehicleId = requestParam.getString("vehicleId");
			String eventTime = requestParam.getString("eventTime");
			Integer busNextStationNo = requestParam.getInteger("nextStationId");

			if (busNextStationNo == null) {
				logger.error("从gps里未获取到nextStationId" + realTime);
				return null;
			}
			if (keyIsStationNo == null) {
				logger.error("未获取到线站关系" + realTime);
				return null;
			}
			if ("340300".equals(realTime.getCitycode())) { // 对蚌埠单独处理
				if (!Tools.isTimeValid(eventTime, SysGlobalConstants.BENGBU_TIME_DIFF)) {
					return null;
				}
				if (!Tools.isTimeValid(eventTime, SysGlobalConstants.TIME_DIFF)
						&& busNextStationNo >= keyIsStationNo.size()) {
					return null;
				}
				if (busNextStationNo > keyIsStationNo.size()) { // 末站后的车屏蔽
					return null;
				}
				
			} else {
				if (!Tools.isTimeValid(eventTime, SysGlobalConstants.TIME_DIFF)) {
					return null;
				}
			}

			// 获取用户当前站的站序
			if (realTime.getUserstationno() == null) {
				realTime.setUserstationno(
						getUserStationNo(realTime.getRouteid(), userStation, realTime.getDirection()));
			}
			if (realTime.getUserstationno() == null || busNextStationNo == null) {
				return null;
			}
			// 获取距离当前站点的站点数量
			Integer stationNumber = realTime.getUserstationno() - busNextStationNo + 1;

			// 计算距离当前站点的距离
			Path busLonAndLan = new Path(requestParam.getDouble("longitude"), requestParam.getDouble("latitude"));
			Double distance = busDistanceForGPS(busLonAndLan, userStation, gpsList, stationNumber,
					requestParam.getInteger("nextAway"));
			// 计算预计时间
			Integer time = expectedTime(stationNumber, requestParam.getInteger("nextTime"));
			// 构建车辆信息
			BaseBus bus = new BaseBus(vehicleId, realTime.getCitycode());

			// 获取bus当前站Id（其实这里是前一站的id，bus毕竟已经过站了）
			String stationId = getBusCurrentStationId(busNextStationNo, realTime.getRouteid(), keyIsStationNo);
			return new RealTime(bus,
					busdesc(distance, busLonAndLan, stationId, stationNumber, time, PacketType.GPS.getType()));
		}
		return null;
	}

	private RealTime processInstationOrOutstation(String json, RealTimeQueryModel realTime, BaseStation userStation,
			Map<String, BaseStation> stationMap, Map<String, RelRouteStation> keyIsStationNo) {
		// 解析json
		JSONObject requestParam = JSONObject.parseObject(json);
		String vehicleId = requestParam.getString("vehicleId");
		Integer busStationNo = requestParam.getInteger("currStationNo");
		String packetType = requestParam.getString("packetType");
		String eventTime;
		if (packetType.equals(PacketType.INSTATION.getDesc())) {
			eventTime = requestParam.getString("eventTime");
		} else {
			eventTime = requestParam.getString("outStationTime");
		}

		if (busStationNo == null) {
			logger.error("从进出站包里未获取到currStationNo" + realTime);
			return null;
		}
		if (keyIsStationNo == null) {
			logger.error("未获取到线站关系" + realTime);
			return null;
		}
		if ("340300".equals(realTime.getCitycode())) { // 对蚌埠单独处理
			if (!Tools.isTimeValid(eventTime, SysGlobalConstants.BENGBU_TIME_DIFF)) {
				return null;
			}
			if (!Tools.isTimeValid(eventTime, SysGlobalConstants.TIME_DIFF) && busStationNo >= keyIsStationNo.size()) {
				return null;
			}
			if(busStationNo == 1 || busStationNo == keyIsStationNo.size()) { // 首末站的车辆屏蔽
				return null;
			}
		} else {
			if (!Tools.isTimeValid(eventTime, SysGlobalConstants.TIME_DIFF)) {
				return null;
			}
		}

		// 获取当前站id
		String busStationId = getBusCurrentStationId(busStationNo + 1, realTime.getRouteid(), keyIsStationNo);
		if (busStationId == null) {
			return null;
		}
		// 计算站距
		if (realTime.getUserstationno() == null) {
			realTime.setUserstationno(getUserStationNo(realTime.getRouteid(), userStation, realTime.getDirection()));
		}
		if (realTime.getUserstationno() == null || busStationNo == null) {
			return null;
		}
		Integer stationNumber = realTime.getUserstationno() - busStationNo;
		// 计算距离
		BaseStation busStation = stationMap.get(busStationId);

		Path path = new Path(busStation.getLongitude().doubleValue(), busStation.getLatitude().doubleValue());

		Double distance = busDistanceForInOrOutstation(path, userStation);
		// 计算预计时间
		Integer time = expectedTime(stationNumber, requestParam.getInteger("nextTime"));

		// 构建车辆信息
		BaseBus bus = new BaseBus(vehicleId, realTime.getCitycode());

		// 构建实时信息描述
		BusDesc desc;
		if (packetType.equals(PacketType.INSTATION.getDesc())) {
			desc = busdesc(distance, path, busStationId, stationNumber, time, PacketType.INSTATION.getType());
		} else {
			desc = busdesc(distance, path, busStationId, stationNumber, time, PacketType.OUTSTATION.getType());
		}
		return new RealTime(bus, desc);
	}

	/**
	 * 
	 * @auther yangyang
	 * @param type
	 *            0 到站 1 过站
	 * @return
	 */
	private BusDesc busdesc(Double distance, Path path, String stationId, Integer stationNumber, Integer time,
			Integer type) {
		BusDesc desc = new BusDesc();
		desc.distance(distance).latitude(path.getLatitude()).longitude(path.getLongitude()).stationid(stationId)
				.stationnumber(stationNumber).time(time).type(type);
		return desc;
	}

	/**
	 * 计算预计时间
	 * 
	 * @auther yangyang
	 */
	private Integer expectedTime(Integer stationNumber, Integer nextTime) {
		return (nextTime != null && nextTime != 0)
				? SysGlobalConstants.SPEND_TIME_EVERY_STATION * (stationNumber - 1) + nextTime
				: SysGlobalConstants.SPEND_TIME_EVERY_STATION * stationNumber;
	}

	private Double busDistanceForInOrOutstation(Path path, BaseStation userStation) {
		path = correctGps(path);
		return DistanceUtil.countDistance(path.getLongitude(), path.getLatitude(),
				userStation.getLongitude().doubleValue(), userStation.getLatitude().doubleValue());
	}

	private Double busDistanceForGPS(Path path, BaseStation userStation, List<String> gpsList, Integer gpsStationNumber,
			Integer nextAway) {
		if (gpsStationNumber == 1 && nextAway != null && nextAway != 0) {
			return nextAway * 100.0;
		}
		if ((path.getLongitude() == 0 || path.getLatitude() == 0) && gpsList.size() > 1) {// 如果车的经纬度为0，且发送了不止一条数据，取该车上一次传来的经纬度
			path = processLonAndLan(gpsList.subList(1, gpsList.size()));
		}
		Double distance;
		if (path.getLongitude() != 0 && path.getLatitude() != 0) {
			path = correctGps(path);// 纠正经纬度
			distance = DistanceUtil.countDistance(path.getLongitude(), path.getLatitude(),
					userStation.getLongitude().doubleValue(), userStation.getLatitude().doubleValue());
		} else {// 传来的车的经纬度都为0，就自己重新造一个啦
			distance = Math.abs(gpsStationNumber * SysGlobalConstants.DEFAULT_STATION_DISTANCE * 1.0);
		}
		return distance;
	}

}