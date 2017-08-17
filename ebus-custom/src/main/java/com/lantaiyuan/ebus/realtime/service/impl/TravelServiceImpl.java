package com.lantaiyuan.ebus.realtime.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
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
import com.lantaiyuan.ebus.realtime.service.RelRouteAssistStationServiceI;
import com.lantaiyuan.ebus.realtime.service.TravelServiceI;

/**
 * @Title: TravelServiceImpl.java
 * @Package com.lantaiyuan.ebus.custom.service.impl
 * @Description:
 * @author yangyang
 * @date 2016年12月21日 下午3:47:19
 * @version v1.0
 */
@Service("travelService")
public class TravelServiceImpl extends BaseService<BaseStation, BaseStationQueryModel> implements TravelServiceI {

	private static Logger logger = LoggerFactory.getLogger(TravelServiceImpl.class);

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

	/**
	 * 比较eventTime和当前时间
	 * 
	 * @param str
	 *            eventTime
	 * @return true : eventTime 不早于当前时间的二分钟，不晚于当前时间 false : eventTime 不在时间范围内
	 */
	private boolean isTimeValid(String str) {
		Date date = Tools.processStrToDate(str);
		// 当前时间
		Calendar right = Calendar.getInstance();
		// TIME_DIFF之前的时间
		Calendar left = Calendar.getInstance();
		left.set(Calendar.MINUTE, left.get(Calendar.MINUTE) - SysGlobalConstants.TIME_DIFF);
		// eventTime的时间
		Calendar d = Calendar.getInstance();
		d.setTime(date);
		return d.compareTo(left) >= 0 && d.compareTo(right) <= 0;
	}

	private List<RealTime> getBusListByInStation(RealTimeQueryModel realTime,BaseStation userStation, Map<String, BaseBus> busMap,
			Map<String, BaseStation> stationMap,Map<String, RelRouteStation> keyIsStationNo) {
		List<RealTime> instationBusList = new ArrayList<>();
		String key = getRealTimeKey(SysGlobalConstants.PROTOCOLVER, SysGlobalConstants.PACKETYPE_IN_STATION,
				realTime.getRouteid(), realTime.getDirection(), realTime.getCitycode());
		Map<String, String> map = RedisHelper.hgetall(key);
		if (map == null || map.size() <= 0) {
			return null;
		}
		JSONObject requestParam;
		RealTime instationBus;
		String vehicleId, instationEventTime;
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (entry.getValue().startsWith("{")) {
				requestParam = JSONObject.parseObject(entry.getValue());
			} else {
				requestParam = JSONObject.parseObject(JSON.parseArray(entry.getValue(), String.class).get(0));
			}
			// 获取时间
			instationEventTime = requestParam.getString("eventTime");
			if (!isTimeValid(instationEventTime)) {// 该条数据在五分钟之前，继续解析下一条
				continue;
			}
			// 获取车辆编号
			vehicleId = requestParam.getString("vehicleId");
			instationBus = this.processSingleInstation(vehicleId, requestParam, realTime, userStation,busMap,stationMap,keyIsStationNo);
			if(instationBus == null) {
				continue;
			}
			instationBusList.add(instationBus);
		}
		return instationBusList;
	}
	
	private RealTime getNearestBusByInstation(RealTimeQueryModel model, BaseStation userStation,Map<String, BaseBus> busMap,
			Map<String, BaseStation> stationMap,Map<String, RelRouteStation> keyIsStationNo) {
		String key = getRealTimeKey(SysGlobalConstants.PROTOCOLVER, SysGlobalConstants.PACKETYPE_IN_STATION, model.getRouteid(),
				model.getDirection(), model.getCitycode());
		Map<String, String> map = RedisHelper.hgetall(key);
		if (map == null) {
			return null;
		}
		JSONObject requestParam;
		RealTime instationBus = null, tempBus;
		String vehicleId, instationEventTime;
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (entry.getValue().startsWith("{")) {
				requestParam = JSONObject.parseObject(entry.getValue());
			} else {
				requestParam = JSONObject.parseObject(JSON.parseArray(entry.getValue(), String.class).get(0));
			}
			instationEventTime = requestParam.getString("eventTime");
			if (!isTimeValid(instationEventTime)) {
				continue;
			}
			vehicleId = requestParam.getString("vehicleId");	
			
			tempBus = this.processSingleInstation(vehicleId, requestParam, model, userStation, busMap, stationMap, keyIsStationNo);
			if(tempBus == null) {
				continue;
			}
			if (instationBus == null || (tempBus.getDesc().getStationnumber() < instationBus.getDesc().getStationnumber()
					&& tempBus.getDesc().getStationnumber() >= 0)) {
				instationBus = tempBus;
			}
		}
		return instationBus;
	}

	
	private RealTime compareBus(RealTimeQueryModel realTime, String vehicleId, String gpsEventTime,
			BaseStation userStation, Map<String, BaseBus> busMap, 
			Map<String, BaseStation> stationMap,Map<String, RelRouteStation> keyIsStationNo) {
		String key = getRealTimeKey(SysGlobalConstants.PROTOCOLVER, SysGlobalConstants.PACKETYPE_IN_STATION,
				realTime.getRouteid(), realTime.getDirection(), realTime.getCitycode());
		Map<String, String> map = RedisHelper.hgetall(key);
		JSONObject requestParam;
		String instationValue = map.get(vehicleId);
		if (!StringUtils.isEmpty(instationValue)) {
			if (instationValue.startsWith("{")) {
				requestParam = JSONObject.parseObject(instationValue);
			} else {
				requestParam = JSONObject.parseObject(JSON.parseArray(instationValue, String.class).get(0));
			}
			String instationEventTime = requestParam.getString("eventTime");
			/**
			 * 如果in station的时间不在2分钟内（在SysGlobalConstants.TIME_DIFF里配置），返回null
			 */
			if (!isTimeValid(instationEventTime)) {
				return null;
			}
			/** 如果in station的时间比gps的时间更新，获取in station的数据 */
			if (Tools.processStrToDate(gpsEventTime).before(Tools.processStrToDate(instationEventTime))) {
				return processNearestBusInStation(realTime, vehicleId, requestParam, userStation,busMap, stationMap,keyIsStationNo);
			}
		}
		return null;
	}

	
	@Override
	public RealTime getNearestBus(String cityCode, BaseStation userStation, BaseRoute route,Integer userStationNo) {
		String key = getRealTimeKey(SysGlobalConstants.PROTOCOLVER, SysGlobalConstants.PACKETTYPE_GPS, route.getRouteid(),
				route.getDirection(), cityCode);
		Map<String, String> map = RedisHelper.hgetall(key);
		Map<String, BaseBus> busMap = this.initBusMap(cityCode);
		Map<String, BaseStation> stationMap = this.initStationMap(cityCode, route.getRouteid(), route.getDirection());
		Map<String, RelRouteStation> keyIsStationNo = this.initRelMap(cityCode, route.getRouteid(),
				route.getDirection());
		RealTimeQueryModel model = new RealTimeQueryModel();
		model.citycode(cityCode).direction(route.getDirection()).routeid(route.getRouteid()).userstationno(userStationNo);
		if (map.isEmpty()) {
			return this.getNearestBusByInstation(model, userStation, busMap, stationMap, keyIsStationNo);
		}
		JSONObject requestParam;
		RealTime nearestBus = null, gpsBus, instationBus;
		String vehicleId, gpsEventTime;
		for (Map.Entry<String, String> entry : map.entrySet()) {
			List<String> listString = JSON.parseArray(entry.getValue(), String.class);
			if (listString != null && listString.size() > 0) {
				requestParam = JSONObject.parseObject(listString.get(0));
				// 获取时间
				gpsEventTime = requestParam.getString("eventTime");
				if (!isTimeValid(gpsEventTime)) {// 该条数据在五分钟之前，继续解析下一条
					continue;
				}
				// 获取车辆编号
				vehicleId = requestParam.getString("vehicleId");
				// 与 in station 的 bus 相比较，如果 in station 的 bus 时间更新， 就用 in
				// station
				instationBus = this.compareBus(model, vehicleId, gpsEventTime, userStation, busMap, stationMap, keyIsStationNo);
				if (instationBus != null) {
					// in station 的数据更加新，那么就与之前的bd比较是否更近，是就替换掉，不是就拉倒
					// 继续下一次循环
					if ((nearestBus == null && instationBus.getDesc().getStationnumber() >= 0)
							|| (nearestBus != null && instationBus.getDesc().getStationnumber() < nearestBus.getDesc().getStationnumber()
									&& instationBus.getDesc().getStationnumber() >= 0)) {
						nearestBus = instationBus;
						continue;
					}
				} else {
					// 处理单条gps数据
					
					gpsBus = this.processSingleGPS(vehicleId, requestParam, model, userStation, listString, busMap, stationMap, keyIsStationNo);
					if (gpsBus == null) {
						continue;
					}
					if ((nearestBus == null && gpsBus.getDesc().getStationnumber() > 0)
							|| (nearestBus != null && gpsBus.getDesc().getStationnumber() < nearestBus.getDesc().getStationnumber()
									&& gpsBus.getDesc().getStationnumber() > 0)) {
						nearestBus = gpsBus;
					}
				}
			}
		}
		return nearestBus == null ? new RealTime(new BaseBus(), new BusDesc()) : nearestBus;
	}

	
	private RealTime processNearestBusInStation(RealTimeQueryModel realTime, String vehicleId,
			JSONObject requestParam, BaseStation userStation,
			 Map<String, BaseBus> busMap,  Map<String, BaseStation> stationMap,Map<String, RelRouteStation> keyIsStationNo) {
		return processSingleInstation(vehicleId, requestParam, realTime, userStation, busMap, stationMap,keyIsStationNo);

	}
	

	/**
	 * <p>Title: getUserStationNo</p> 
	 * <p>Description: 获取用户当前站站序</p>
	 * @author liuhao
	 * 获取用户当前站站序
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
	private Path processLonAndLan(List<String> listString, JSONObject requestParam) {
		Path path = new Path(0.0, 0.0);
		double lon, lan;
		for (String json : listString) {
			requestParam = JSONObject.parseObject(json);
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
	private static String getRealTimeKey(String protocolver, String packettype, String routeId, int direction,
			String cityCode) {
		StringBuilder builder = new StringBuilder();
		builder.append("KEY:PROTOCOLVER:").append(protocolver).append(":PACKETTYPE:").append(packettype)
				.append(":GPRSID:").append(routeId).append(":DIRECTION:").append(direction).append(":CITYCODE:")
				.append(cityCode);
		return builder.toString();
	}

	/**
	 * 纠正经纬度
	 * 
	 * @auther yangyang
	 * @param path
	 * @return
	 */
	private static Path correctGps(Path path) {
		double[] latlng = { 0, 0 };
		GpsCorrectUtil.transform(path.getLatitude(), path.getLongitude(), latlng);
		path.setLatitude(latlng[0]);
		path.setLongitude(latlng[1]);
		return path;
	}

	/**
	 * 处理单条gps数据
	 * 
	 * @auther yangyang
	 */
	
	private RealTime processSingleGPS(String vehicleId, JSONObject requestParam, RealTimeQueryModel realTime,
			BaseStation userStation, List<String> listString,Map<String, BaseBus> busMap, Map<String, BaseStation> stationMap,
			Map<String, RelRouteStation> keyIsStationNo) {
		// 根据车辆编号获取到数据库中的车辆详情
		BaseBus bus = busMap.get(vehicleId);
		double distance;
		if (StringUtils.isEmpty(bus)) {
			logger.warn("vehicleId为".concat(vehicleId).concat(",cityCode为")
					.concat(realTime.getCitycode()).concat("的车辆在数据库中不存在！"));
			return null;
		}
		// 获取bus的下一站站序
		Integer no = requestParam.getInteger("nextStationId");
		// 获取用户当前站的站序
		if (realTime.getUserstationno() == null) {
			realTime.setUserstationno(getUserStationNo(realTime.getRouteid(), userStation, realTime.getDirection()));
		}
		if(realTime.getUserstationno() == null || no == null) {
			return null;
		}
		// 获取距离当前站点的站点数量
		Integer stationNumber = realTime.getUserstationno() - no + 1;
		// 计算距离当前站点的距离
		Path busLonAndLan = new Path(requestParam.getDouble("longitude"), requestParam.getDouble("latitude"));
		if (busLonAndLan.getLongitude() == 0 || busLonAndLan.getLatitude() == 0) {// 如果车的经纬度为0，取该车上一次传来的经纬度
			busLonAndLan = this.processLonAndLan(listString, requestParam);
		}
		busLonAndLan = correctGps(busLonAndLan);// 纠正经纬度

		if (busLonAndLan.getLongitude() != 0 && busLonAndLan.getLatitude() != 0) {
			distance = DistanceUtil.countDistance(busLonAndLan.getLongitude(), busLonAndLan.getLatitude(),
					userStation.getLongitude().doubleValue(), userStation.getLatitude().doubleValue());
		} else {// 十二次传来的车的经纬度都为0，就自己重新造一个啦
			distance = Math.abs(stationNumber * SysGlobalConstants.DEFAULT_STATION_DISTANCE);
		}
		// 计算预计时间
		int time = SysGlobalConstants.SPEND_TIME_EVERY_STATION * stationNumber;
		// 获取bus当前站Id（其实这里是前一站的id，bus毕竟已经过站了）
		String stationId = this.getBusCurrentStationId(no, realTime.getRouteid(), keyIsStationNo);
		BusDesc desc = new BusDesc();
		desc.distance(distance).latitude(busLonAndLan.getLatitude()).longitude(busLonAndLan.getLongitude())
		.stationid(stationId).stationnumber(stationNumber).time(time).type(1);
		return new RealTime(bus, desc);
	}
	
	/**
	 * 处理单条in station的数据
	 * 
	 * @auther yangyang
	 */
	
	private RealTime processSingleInstation(String vehicleId, JSONObject requestParam, RealTimeQueryModel realTime, BaseStation userStation,
			Map<String, BaseBus> busMap, Map<String, BaseStation> stationMap, Map<String, RelRouteStation> keyIsStationNo) {
		BaseBus bus = busMap.get(vehicleId);
		if (StringUtils.isEmpty(bus)) {
			logger.warn("vehicleId为".concat(vehicleId).concat(",cityCode为")
					.concat(realTime.getCitycode()).concat("的车辆在数据库中不存在！"));
			return null;
		}
		// 获取bus的当前站站序
		Integer busStationNo = requestParam.getInteger("currStationNo");
		// 获取bus的当前站信息
		String busStationId = this.getBusCurrentStationId(busStationNo + 1, realTime.getRouteid(),keyIsStationNo);
		// 获取用户当前站的站序
		if (realTime.getUserstationno() == null) {
			realTime.setUserstationno(getUserStationNo(realTime.getRouteid(), userStation, realTime.getDirection()));
		}
		if(realTime.getUserstationno() == null || busStationNo == null) {
			return null;
		}
		// 获取距离当前站点的站点数量
		int stationNumber = realTime.getUserstationno() - busStationNo;
		// 获取到当前bus的经度和纬度,in station won't pass longitude and latitude, so get
		// the station's
		BaseStation busStation = stationMap.get(busStationId);
		Path path = new Path(busStation.getLongitude().doubleValue(), busStation.getLatitude().doubleValue());
		path = correctGps(path);
		double distance = DistanceUtil.countDistance(path.getLongitude(), path.getLatitude(),
				userStation.getLongitude().doubleValue(), userStation.getLatitude().doubleValue());
		// 计算预计时间
		Integer time = SysGlobalConstants.SPEND_TIME_EVERY_STATION * stationNumber;
		BusDesc desc = new BusDesc();
		desc.distance(distance).latitude(path.getLatitude()).longitude(path.getLongitude())
		.stationid(busStationId).stationnumber(stationNumber).time(time).type(0);
		return new RealTime(bus,desc);
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
	 * 初始化bus
	 * 
	 * @auther yangyang
	 */
	private Map<String, BaseBus> initBusMap(String cityCode) {
		return busService.getCityBus(cityCode);
	}

	/**
	 * 初始化station
	 * 
	 * @auther yangyang
	 */
	private Map<String, BaseStation> initStationMap(String cityCode, String routeId, int direction) {
		return baseStationService.getCityStations(cityCode, routeId, direction);
	}

	/**
	 * 初始化线站关系
	 * 
	 * @auther yangyang
	 */
	private Map<String, RelRouteStation> initRelMap(String cityCode, String routeId, int direction) {
		return relRouteStationService.getCityRelRouteStation(routeId, direction, cityCode);
	}

	/**
	 * duplicate 去除过多重复的站点信息
	 * 
	 * @param list
	 *            包含station和station对应的所有线路信息
	 * @return 只返回两条站点
	 */
	

	/**
	 * 功能描述:查看是否是指定距离范围内的站点，直接由一期接口改造而来
	 * 作者:温海金
	 * 最后更改时间 : 2016年12月22日 下午3:00:53
	 */
	@Override
	public boolean isNearStation(BaseStation station, double longitude, double latitude, double red) {
    	    	double distance = DistanceUtil.countDistance(station.getLongitude().doubleValue(), station.getLatitude().doubleValue(), longitude, latitude);
    	    	if (red >= distance) {
    			return true;
    		}
    		return false;
        }

	@Override
	public List<RealTime> getBusList(RealTimeQueryModel realTime, BaseStation userStation) {
		List<RealTime> busList = new ArrayList<>();
		String key = getRealTimeKey(SysGlobalConstants.PROTOCOLVER, SysGlobalConstants.PACKETTYPE_GPS, realTime.getRouteid(),
				realTime.getDirection(), realTime.getCitycode());
		Map<String, String> map = RedisHelper.hgetall(key);
		Map<String, BaseBus> busMap = this.initBusMap(realTime.getCitycode());
		Map<String, BaseStation> stationMap = this.initStationMap(realTime.getCitycode(), 
				realTime.getRouteid(), realTime.getDirection());
		Map<String, RelRouteStation> keyIsStationNo = this.initRelMap(realTime.getCitycode(), 
				realTime.getRouteid(), realTime.getDirection());
		if (map == null || map.size() <= 0) {
			return this.getBusListByInStation(realTime, userStation, busMap, stationMap,keyIsStationNo);
		}
		RealTime gpsBus, instationBus;
		JSONObject requestParam;
		String vehicleId, gpsEventTime;
		for (Map.Entry<String, String> entry : map.entrySet()) {
			List<String> listString = JSON.parseArray(entry.getValue(), String.class);
			if (listString != null && listString.size() > 0) {
				String str = listString.get(0);
				requestParam = JSONObject.parseObject(str);
				vehicleId = requestParam.getString("vehicleId");
				gpsEventTime = requestParam.getString("eventTime");
				// gps的数据与in station的数据比较，谁新就用谁
				instationBus = this.compareBus(realTime,vehicleId, gpsEventTime, userStation, busMap,stationMap,keyIsStationNo);
				if (instationBus != null) {
					busList.add(instationBus);
					continue;
				}
				// 继续解析gps的数据
				if (!isTimeValid(gpsEventTime)) {// gps的数据在SysGlobalConstants.TIME_DIFF分钟之前，继续解析下一条
					continue;
				}
				gpsBus = this.processSingleGPS(vehicleId, requestParam,realTime , userStation, listString, busMap, stationMap, keyIsStationNo);
				if (gpsBus == null) {
					continue;
				}
				busList.add(gpsBus);
			}
		}
		return busList;
	}

	@Override
	public RealTime getNearestBus(List<RealTime> busList) {
		// TODO Auto-generated method stub
		return null;
	}

}