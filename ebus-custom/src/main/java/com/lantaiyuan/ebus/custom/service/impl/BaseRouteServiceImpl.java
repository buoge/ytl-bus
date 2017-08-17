package com.lantaiyuan.ebus.custom.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.google.common.base.CharMatcher;
import com.lantaiyuan.ebus.carpool.model.CarpoolMatch;
import com.lantaiyuan.ebus.carpool.model.CarpoolRouteStation;
import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;
import com.lantaiyuan.ebus.common.util.DistanceUtil;
import com.lantaiyuan.ebus.common.util.GaoDeHelper;
import com.lantaiyuan.ebus.common.util.GpsCorrectUtil;
import com.lantaiyuan.ebus.common.util.TimeUtils;
import com.lantaiyuan.ebus.custom.dao.BaseBusMapper;
import com.lantaiyuan.ebus.custom.dao.BaseRouteMapper;
import com.lantaiyuan.ebus.custom.dao.RelRouteBusMapper;
import com.lantaiyuan.ebus.custom.dao.RelRouteStationMapper;
import com.lantaiyuan.ebus.custom.model.AllLines;
import com.lantaiyuan.ebus.custom.model.AllRoutesVo;
import com.lantaiyuan.ebus.custom.model.BaseBus;
import com.lantaiyuan.ebus.custom.model.BaseRoute;
import com.lantaiyuan.ebus.custom.model.BaseRouteQueryModel;
import com.lantaiyuan.ebus.custom.model.BaseStation;
import com.lantaiyuan.ebus.custom.model.BusNumInfo;
import com.lantaiyuan.ebus.custom.model.CustomLine;
import com.lantaiyuan.ebus.custom.model.GeneralRoute;
import com.lantaiyuan.ebus.custom.model.RelRouteBus;
import com.lantaiyuan.ebus.custom.model.RelRouteStation;
import com.lantaiyuan.ebus.custom.model.SysUser;
import com.lantaiyuan.ebus.custom.model.UpAndDownStation;
import com.lantaiyuan.ebus.custom.model.carpool.CarpoolMatchAndRouteResultModel;
import com.lantaiyuan.ebus.custom.model.enummodel.CarpoolStationTypeEnum;
import com.lantaiyuan.ebus.custom.model.enummodel.CustomLineStatusEnum;
import com.lantaiyuan.ebus.custom.service.BaseRouteServiceI;
import com.lantaiyuan.ebus.custom.service.BaseStationServiceI;
import com.lantaiyuan.ebus.custom.service.CarpoolMatchServiceI;
import com.lantaiyuan.ebus.custom.service.CustomLineServiceI;
import com.lantaiyuan.ebus.custom.service.ServiceIpServiceI;
import com.lantaiyuan.ebus.realtime.model.AssistPoint;
import com.lantaiyuan.ebus.realtime.model.MapPath;
import com.lantaiyuan.ebus.realtime.model.Path;
import com.lantaiyuan.ebus.realtime.model.RealTime;
import com.lantaiyuan.ebus.realtime.model.RealTimeQueryModel;
import com.lantaiyuan.ebus.realtime.model.RelRouteAssistStation;
import com.lantaiyuan.ebus.realtime.model.RouteDetail;
import com.lantaiyuan.ebus.realtime.model.RouteDetailQueryModel;
import com.lantaiyuan.ebus.realtime.model.RouteInBaseLine;
import com.lantaiyuan.ebus.realtime.model.RouteSimpleInfo;
import com.lantaiyuan.ebus.realtime.model.RouteStation;
import com.lantaiyuan.ebus.realtime.model.SimpleRouteCustom;
import com.lantaiyuan.ebus.realtime.model.enummodel.AudioRouteReturnEnum;
import com.lantaiyuan.ebus.realtime.model.gaode.MyPoi;
import com.lantaiyuan.ebus.realtime.service.RelRouteAssistStationServiceI;
import com.lantaiyuan.ebus.realtime.service.TravelServiceI;

/**
 * 描述:公交线路业务类 作者:温海金 最后更改时间:下午2:45:12
 */
@CacheConfig(cacheNames = "routeDetail")
@Service("baseRouteService")
public class BaseRouteServiceImpl extends BaseService<BaseRoute, BaseRouteQueryModel> implements BaseRouteServiceI {
	@Resource
	private BaseRouteMapper baseRouteMapper;

	@Resource
	private BaseStationServiceI baseStationService;

	@Resource
	private RelRouteStationMapper relRouteStationMapper;

	@Resource
	private RelRouteAssistStationServiceI relRouteAssistStationService;

	@Resource
	private TravelServiceI travelServiceNew;

	@Resource
	private ServiceIpServiceI serviceIpService;

	@Resource
	private RelRouteBusMapper relRouteBusMapper;

	@Resource
	private BaseBusMapper baseBusMapper;

	@Resource
	private CustomLineServiceI customLineService;
	
	@Resource
	private CarpoolMatchServiceI carpoolMatchService;
	
	@Override
	public BaseDAO<BaseRoute, BaseRouteQueryModel> getDao() {
		return baseRouteMapper;
	}

	/**
	 * 模糊查询车牌号码
	 */
	@Override
	public List<BusNumInfo> queryBusNumList(String busnum, String citycode) {
		return baseRouteMapper.queryBusNumList(busnum, citycode);
	}

	/**
	 * <p>
	 * Title: getRouteByName
	 * </p>
	 * <p>
	 * Description: 模糊查询线路信息
	 * </p>
	 * 
	 * @author:liuhao
	 */
	@Override
	public List<RouteInBaseLine> getRouteByName(String routeName, String cityCode, int decideSeason) {
		return baseRouteMapper.getRouteByName(routeName, cityCode, decideSeason);
	}

	/**
	 * <p>
	 * Title: getRouteAndStationByName
	 * </p>
	 * <p>
	 * Description: 模糊查询站点和线路信息
	 * </p>
	 * 
	 * @author:liuhao
	 */
	@Override
	public RouteStation getRouteAndStationByName(String name, String cityCode) {
		List<RouteInBaseLine> routes = getRoutesByKeyword(name, cityCode);
		// 模糊查询出相关的站点信息
		List<BaseStation> stations = baseStationService.getStationByName(name, cityCode);

		// 为每一个站点的经纬度做GPS矫正
		baseStationService.updataTheCorrectOfGps(stations);

		// duplicate: 去重名的station
		Set<BaseStation> set = new HashSet<>();
		set.addAll(stations);

		//调用高德api，匹配查询地点
		Map<String, String> paramsMap = new HashMap<>();
		paramsMap.put("city", cityCode);
		paramsMap.put("key", SysGlobalConstants.GAODE_API_KEY);
		paramsMap.put("keywords", name);
		paramsMap.put("output", SysGlobalConstants.GAODE_API_OUTPUT);

		List<MyPoi> myPois = GaoDeHelper.getResult(SysGlobalConstants.GAODE_API_URL, paramsMap, SysGlobalConstants.GAODE_EXCLUDE_CODE, name);
		// 整合所有查询到的线路和站点数据
		return new RouteStation(routes, set, !CollectionUtils.isEmpty(myPois) ? myPois : Collections.emptyList());
	}

	/***
	 * *
	* @author:liuhao
	* <p>Title: getRoutesByAudioInfo</p>
	* <p>Description: 模糊查询线路信息</p>
	* @param routeName
	* @param cityCode
	* @return
	 */
	@Override
	public List<RouteInBaseLine> getRoutesByAudioInfo(String rawRouteName, String cityCode) {
		//解析出线路名称
		String routeName = parseRouteName(rawRouteName);

		List<RouteInBaseLine> routes = getRoutesByKeyword(routeName, cityCode);

		//返回线路集合数据
		return CollectionUtils.isEmpty(routes) ? Collections.emptyList() : routes;
	}

	/***
	* @author:liuhao
	* <p>Title: parseRouteName</p>
	* <p>Description: 根据特定规则提取线路名称</p>
	* @param rawRouteName
	* @return
	 */
	private String parseRouteName(String rawRouteName) {
		String pattern = "\\d+";

		// Create a Pattern object
		Pattern r = Pattern.compile(pattern);

		// Now create matcher object.
		Matcher m = r.matcher(rawRouteName);

		if (m.find()) {
			return m.group();
		}

		return "";
	}

	/**
	* <p>Title: getRoutesByKeyword</p>
	* <p>Description:从模糊查询中抽离线路查询逻辑，以便重用</p>
	* @author:liuhao
	* @param name
	* @param cityCode
	* @return
	*/
	private List<RouteInBaseLine> getRoutesByKeyword(String name, String cityCode) {
		// 模糊查询出相关的线路信息
		List<RouteInBaseLine> routes = getRouteByName(name, cityCode, TimeUtils.decideSeason());
		// 按线路名称中的数字从小到大进行排序
		routes.sort((a, b) -> {
			// 线路a中不含数字
			if (StringUtils.isEmpty(CharMatcher.DIGIT.retainFrom(a.getRoutename()))) {
				return 1;
			}
			// 线路b中不含数字
			if (StringUtils.isEmpty(CharMatcher.DIGIT.retainFrom(b.getRoutename()))) {
				return -1;
			} else {
				return Integer.valueOf(CharMatcher.DIGIT.retainFrom(a.getRoutename())) - Integer.valueOf(CharMatcher.DIGIT.retainFrom(b.getRoutename()));
			}
		});
		return routes;
	}

	@Cacheable
	@Override
	public RouteDetail getRouteDetail(RouteDetailQueryModel routeDetail) {

		// 根据routeId获取到Route
		RouteInBaseLine route = baseRouteMapper.getRouteByRouteId(routeDetail.getRouteid(), routeDetail.getDirection(), routeDetail.getCitycode(),
				TimeUtils.decideSeason());
		// 分别根据每个站点Id获取到对应的站点信息
		List<BaseStation> station = baseStationService.getStationsByIds(routeDetail.getRouteid(), routeDetail.getCitycode(), routeDetail.getDirection());

		// 为每一个站点的经纬度做GPS矫正,并计算距离
		BaseStation nearestStation = processStations(station, routeDetail.getLongitude(), routeDetail.getLatitude());

		// 按照站序进行排序
		station.sort((first, second) -> {
			return first.getStationno() - second.getStationno();
		});

		// 获取nearestStation的车辆信息
		List<RealTime> carlist = new ArrayList<>();
		if (nearestStation != null) {
			carlist = processCarList(routeDetail, nearestStation);// 前三后一
		}

		// 处理线路辅助站点信息
		MapPath mapPath = route == null ? null : processMapPath(route.getRouteid(), route.getDirection(), route.getCitycode());

		// 改变车辆的经纬度，使其能在辅助线上
		correctBusLonAndLan(carlist, mapPath);

		return new RouteDetail(route == null ? new RouteInBaseLine() : route, station == null ? Collections.emptyList() : station,
				nearestStation == null ? new BaseStation() : nearestStation, carlist, mapPath);
	}

	/**
	 * 处理车辆经纬度，使其能正确显示在辅助线上
	 * 
	 * @auther yangyang
	 * @param carlist
	 * @param mapPath
	 */
	@Override
	public void correctBusLonAndLan(List<RealTime> carlist, MapPath mapPath) {
		if (StringUtils.isEmpty(mapPath)) {
			return;
		}
		List<Path> path = mapPath.getPath();
		List<AssistPoint> pointList = new ArrayList<>();
		carlist.forEach(car -> {
			if (car.getDesc().getLongitude() == null || car.getDesc().getLatitude() == null || car.getDesc().getLongitude() == 0 || car.getDesc().getLatitude() == 0) {
				// 如果车辆没有经纬度或传来的经纬度为0，暂不处理

				return;
			}
			path.forEach(point -> {
				pointList.add(
						new AssistPoint(DistanceUtil.countDistance(car.getDesc().getLongitude(), car.getDesc().getLatitude(), point.getLongitude(), point.getLatitude()),
								point.getLongitude(), point.getLatitude()));
			});

			pointList.sort((first, second) -> {
				return first.getDistance().compareTo(second.getDistance());
			});

			if (pointList.size() > 0) {
				car.getDesc().setLongitude(pointList.get(0).getLongitude());
				car.getDesc().setLatitude(pointList.get(0).getLatitude());
			}
			pointList.clear();
		});
	}

	/**
	 * 处理辅助站点，并对辅助站点进行纠偏
	 * 
	 * @auther yangyang
	 * @param route
	 * @param longitude
	 * @param latitude
	 * @param direction
	 * @param cityCode
	 * @return
	 */
	@Override
	public MapPath processMapPath(String routeId, Integer direction, String cityCode) {
		// 处理线路辅助站点信息
		MapPath mapPath = relRouteAssistStationService.getRelRouteAssitStation(routeId, direction, cityCode);
		// 纠偏处理
		correctMapPathGPS(mapPath);
		return mapPath;
	}

	// 纠偏处理
	private void correctMapPathGPS(MapPath mapPath) {
		if (mapPath == null || mapPath.getStartLatitude() == null)
			return;
		// 处理辅助站点起始点
		Path point = new Path(mapPath.getStartLongitude(), mapPath.getStartLatitude());
		processPathGPS(point);
		mapPath.setStartLongitude(point.getLongitude());
		mapPath.setStartLatitude(point.getLatitude());
		// 处理辅助站点终点
		point = new Path(mapPath.getEndLongitude(), mapPath.getEndLatitude());
		processPathGPS(point);
		mapPath.setEndLongitude(point.getLongitude());
		mapPath.setEndLatitude(point.getLatitude());
		// 处理一系列辅助点
		mapPath.getPath().forEach(path -> {
			processPathGPS(path);
		});
	}

	private void processPathGPS(Path path) {
		if (path == null || path.getLongitude() == null || path.getLatitude() == null)
			return;
		double[] latlng = new double[2];
		GpsCorrectUtil.transform(path.getLatitude(), path.getLongitude(), latlng);
		path.setLatitude(latlng[0]);
		path.setLongitude(latlng[1]);
	}

	/**
	 * 为每一个站点的经纬度做GPS矫正,并计算距离
	 * 
	 * @auther yangyang
	 * @param stations
	 * @return 返回距离用户最近的站点
	 */
	private BaseStation processStations(List<BaseStation> stations, double longitude, double latitude) {
		stations.forEach(s -> {
			double[] latlng = new double[2];
			GpsCorrectUtil.transform(s.getLatitude().doubleValue(), s.getLongitude().doubleValue(), latlng);
			s.setLatitude(new BigDecimal(latlng[0]));
			s.setLongitude(new BigDecimal(latlng[1]));
			s.setDistance(DistanceUtil.countDistance(longitude, latitude, s.getLongitude().doubleValue(), s.getLatitude().doubleValue()));
		});
		// 用户当前的最近站点
		stations.sort((first, second) -> {
			return first.getDistance().compareTo(second.getDistance());
		});
		return (CollectionUtils.isEmpty(stations)) ? null : stations.get(0);
	}

	/**
	 * 未过站的最多返回三辆，过站的最多返回一辆
	 * 
	 * @auther yangyang
	 * @param routeDetail
	 * @param nearestStation
	 * @return
	 */
	private List<RealTime> processCarList(RouteDetailQueryModel routeDetail, BaseStation nearestStation) {
		RealTimeQueryModel model = new RealTimeQueryModel();
		model.citycode(routeDetail.getCitycode()).direction(routeDetail.getDirection()).routeid(routeDetail.getRouteid())
				.stationid(String.valueOf(nearestStation.getStationid())).userstationno(nearestStation.getStationno());
		List<RealTime> carlist = travelServiceNew.getBusList(model, nearestStation);
		List<RealTime> overlist = new ArrayList<>();// 获取已过站数据
		List<RealTime> noOverlist = new ArrayList<>();// 获取未过站数据
		if (!CollectionUtils.isEmpty(carlist)) {
			carlist.forEach(busDetail -> {
				int stationNumber = busDetail.getDesc().getStationnumber();
				if (stationNumber < 0) {
					overlist.add(busDetail);
				}
				if (stationNumber >= 0) {
					noOverlist.add(busDetail);
				}
			});
			overlist.sort((b1, b2) -> {
				if (b1.getDesc().getStationnumber() == b2.getDesc().getStationnumber()) {
					return b1.getDesc().getDistance().compareTo(b2.getDesc().getDistance());
				}
				return b2.getDesc().getStationnumber() - b1.getDesc().getStationnumber();
			});
			noOverlist.sort((b1, b2) -> {
				if (b1.getDesc().getStationnumber() == b2.getDesc().getStationnumber()) {
					return b1.getDesc().getDistance().compareTo(b2.getDesc().getDistance());
				}
				return b1.getDesc().getStationnumber() - b2.getDesc().getStationnumber();
			});
			carlist.clear();
			if (overlist.size() >= 1) {
				carlist.addAll(overlist.subList(0, 1));
			}
			if (noOverlist.size() >= 3) {
				carlist.addAll(noOverlist.subList(0, 3));
			} else if (noOverlist.size() > 0) {
				carlist.addAll(noOverlist.subList(0, noOverlist.size()));
			}
		} else {
			carlist = Collections.emptyList();
		}
		return carlist;
	}

	/***
	 * <p>
	 * Title: getRoutesByIds
	 * </p>
	 * <p>
	 * Description: 根据routeIds获取所有经过该站点的线路信息
	 * </p>
	 * 
	 * @author liuhao
	 */
	@Override
	public List<BaseRoute> getRoutesByIds(List<RouteSimpleInfo> routeSimple) {
		if (CollectionUtils.isEmpty(routeSimple))
			return Collections.emptyList();
		return baseRouteMapper.queryRoutesByIds(routeSimple, TimeUtils.decideSeason());
	}

	/***
	 * <p>
	 * Title: getRoutesByStationId
	 * </p>
	 * <p>
	 * Description:根据stationId返回所有经过的BaseRoute
	 * </p>
	 * 
	 * @author liuhao
	 */
	@Override
	public List<BaseRoute> getRoutesByStationId(String stationId, String cityCode, int decideSeason) {
		return baseRouteMapper.queryRoutesByStationId(stationId, cityCode, decideSeason);
	}

	/***
	 * <p>
	 * Title: queryRoutesByStationIdAndStationName
	 * </p>
	 * <p>
	 * Description:根据当前stationId/stationName/cityCode获取到达目标站点所有线路集合
	 * </p>
	 * 
	 * @author liuhao
	 */
	@Override
	public List<RouteInBaseLine> queryRoutesByStationIdAndStationName(String stationId, String stationName, String cityCode, int decideSeason) {
		return baseRouteMapper.queryRoutesByStationIdAndStationName(stationId, stationName, cityCode, decideSeason);
	}

	/**
	 * 找到重复的线站关系
	 * 
	 * @author yangyang
	 * @return 返回的数据结构：routeId:direction:stationId:cityCode
	 */
	@Override
	public Set<String> findErrorData() {
		List<RelRouteStation> routeStations = relRouteStationMapper.getAllRelRouteStations();
		// key: routeId:direction:stationId:cityCode
		Map<String, Integer> map = new HashMap<>();
		Set<String> repeated = new HashSet<>();
		routeStations.forEach(rs -> {
			StringBuilder sb = new StringBuilder().append(rs.getRouteid()).append(":").append(rs.getDirection()).append(":").append(rs.getStationid()).append(":")
					.append(rs.getCitycode());
			if (!map.containsKey(sb.toString())) {
				map.put(sb.toString(), 1);
			} else {
				repeated.add(sb.toString());
			}
		});
		return repeated;
	}

	/**
	 * 找到没有线站关系的线路
	 * 
	 * @author yangyang
	 * @return 返回数据结构：routeId:direction:cityCode
	 */
	@Override
	public List<String> findErrorRoutes() {
		List<RouteInBaseLine> routes = baseRouteMapper.getAllRoutes(TimeUtils.decideSeason());
		List<String> result = new ArrayList<>();
		routes.forEach(r -> {
			List<RelRouteStation> routeStations = relRouteStationMapper.getCityRelRouteStation(r.getRouteid(), r.getDirection(), r.getCitycode());
			if (CollectionUtils.isEmpty(routeStations)) {
				StringBuilder sb = new StringBuilder().append(r.getRouteid()).append(":").append(r.getDirection()).append(":").append(r.getCitycode());
				result.add(sb.toString());
			}
		});
		return result;
	}

	/**
	 * 找到存在错误站序的线站关系
	 * 
	 * @author yangyang
	 * @return 返回数据结构：routeId:direction:cityCode
	 */
	@Override
	public List<String> findErrorStationNo() {
		List<RouteInBaseLine> routes = baseRouteMapper.getAllRoutes(TimeUtils.decideSeason());
		List<String> result = new ArrayList<>();
		routes.forEach(r -> {
			List<RelRouteStation> routeStations = relRouteStationMapper.getCityRelRouteStation(r.getRouteid(), r.getDirection(), r.getCitycode());
			if (!CollectionUtils.isEmpty(routeStations)) {
				int num = routeStations.size();
				routeStations.sort((first, second) -> {
					return first.getStationno() - second.getStationno();
				});
				RelRouteStation last = routeStations.get(num - 1);
				if (last.getStationno() != num) {
					StringBuilder sb = new StringBuilder().append(r.getRouteid()).append(":").append(r.getDirection()).append(":").append(r.getCitycode());
					result.add(sb.toString());
				}
			}
		});
		return result;
	}

	/**
	 * 找到重复的站点
	 * 
	 * @author yangyang
	 * @return 返回数据结构stationId:cityCode
	 */
	@Override
	public Set<String> findDuplicatedStations() {
		List<BaseStation> stations = baseStationService.getAllStations();
		Set<String> repeated = new HashSet<>();
		Map<String, Integer> map = new HashMap<>();
		// key stationId:cityCode
		stations.forEach(s -> {
			String key = String.valueOf(s.getStationid()).concat(":").concat(s.getCitycode());
			if (!map.containsKey(key)) {
				map.put(key, 1);
			} else {
				repeated.add(key);
			}
		});
		return repeated;
	}

	/**
	 * 找到重复的辅助站点
	 * 
	 * @author yangyang
	 * @return 返回的数据结构routeId:direction:cityCode
	 */
	@Override
	public Set<String> findDuplicateAssistStations() {
		List<RelRouteAssistStation> result = relRouteAssistStationService.getAllRelRouteStations();
		Set<String> repeated = new HashSet<>();
		Map<String, Integer> map = new HashMap<>();
		// key: routeId:direction:cityCode
		result.forEach(r -> {
			StringBuilder sb = new StringBuilder().append(r.getRouteid()).append(":").append(r.getDirection()).append(":").append(r.getCitycode());
			if (!map.containsKey(sb.toString())) {
				map.put(sb.toString(), 1);
			} else {
				repeated.add(sb.toString());
			}
		});
		return repeated;
	}

	/**
	 * 找出重复的线车关系
	 * 
	 * @author yangyang
	 * @return 返回的数据结构vehicleId:cityCode
	 */
	@Override
	public Set<String> findDuplicateRelRouteBus() {
		List<RelRouteBus> result = relRouteBusMapper.getAllRelRouteBus();
		Set<String> repeated = new HashSet<>();
		Map<String, Integer> map = new HashMap<>();
		// key为 vehicleId:cityCode
		result.forEach(rb -> {
			String key = rb.getVehicleid().concat(":").concat(rb.getCitycode());
			if (!map.containsKey(key)) {
				map.put(key, 1);
			} else {
				repeated.add(key);
			}
		});
		return repeated;
	}

	/**
	 * 找出重复的车辆
	 * 
	 * @author yangyang
	 * @return 返回的数据结构vehicleId:cityCode
	 */
	@Override
	public Set<String> findDuplicateBus() {
		List<BaseBus> result = baseBusMapper.getAllBuses();
		Set<String> repeated = new HashSet<>();
		Map<String, Integer> map = new HashMap<>();
		// key为 vehicleId:cityCode
		result.forEach(bus -> {
			String key = bus.getVehicleid().concat(":").concat(bus.getCitycode());
			if (!map.containsKey(key)) {
				map.put(key, 1);
			} else {
				repeated.add(key);
			}
		});
		return repeated;
	}

	/**
	 * 找出重复的线路
	 * 
	 * @author yangyang
	 * @return 返回的数据结构routeId:direction:cityCode
	 */
	@Override
	public Set<String> findDuplicateRoute() {
		List<RouteInBaseLine> routes = baseRouteMapper.getAllRoutes(TimeUtils.decideSeason());
		Set<String> repeated = new HashSet<>();
		Map<String, Integer> map = new HashMap<>();
		// key: routeId:direction:cityCode
		routes.forEach(r -> {
			StringBuilder sb = new StringBuilder().append(r.getRouteid()).append(":").append(r.getDirection()).append(":").append(r.getCitycode());
			if (!map.containsKey(sb.toString())) {
				map.put(sb.toString(), 1);
			} else {
				repeated.add(sb.toString());
			}
		});
		return repeated;
	}

	/**
	 * 查看线路换向是否正确
	 * 
	 * @author yangyang
	 * @return 返回数据结构routeId:cityCode
	 */
	@Override
	public List<String> checkRouteReversal() {
		List<String> result = new ArrayList<>();
		List<RouteInBaseLine> routes = baseRouteMapper.getAllRoutes(TimeUtils.decideSeason());
		// key: routeId:cityCode
		routes.forEach(r -> {
			RouteInBaseLine route = baseRouteMapper.getRouteByRouteId(r.getRouteid(), r.getDirection() == 0 ? 1 : 0, r.getCitycode(), TimeUtils.decideSeason());
			if (StringUtils.isEmpty(route) || StringUtils.isEmpty(route.getRouteid())) { // 如果反方向的线路不存在
				if (r.getReversal() == 0) { // 需要从可换向变成不可换向
					result.add(r.getRouteid().concat(":").concat(r.getCitycode()));
				}
			} else { // 如果反方向的线路存在
				if (r.getReversal() == 1) { // 需要从不可换向变成可换向
					result.add(r.getRouteid().concat(":").concat(r.getCitycode()));
				}
			}
		});
		return result;
	}

	/**
	 * 找出没有线路的站点
	 * 
	 * @auther yangyang
	 * @return 返回的数据结构stationId:cityCode
	 */
	@Override
	public List<String> stationWithOutRoutes() {
		List<BaseStation> stations = baseStationService.getAllStations();
		List<String> result = new ArrayList<>();
		// key: stationId:cityCode
		stations.forEach(s -> {
			List<RelRouteStation> routeStations = relRouteStationMapper.getStationRoutes(s.getStationid(), s.getCitycode());
			if (CollectionUtils.isEmpty(routeStations)) {
				result.add(String.valueOf(s.getStationid()).concat(":").concat(s.getCitycode()));
			}
		});
		return result;
	}

	/*
	 * 根据城市编码，线路id，线路方向获取线路信息 温海金
	 */
	@Override
	public BaseRoute getRouteByIdAndDirection(String citycode, String routeid, Integer direction) {
		return baseRouteMapper.getRouteByIdAndDirection(citycode, routeid, direction);
	}

	@Override
	public List<RouteInBaseLine> getRoutesByRouteName(String routeName, SysUser currentUser) {
		Assert.notNull(currentUser, "操作失败，请先登入app后台系统！");
		String citycode = currentUser.getCitycode();
		//Assert.isTrue(!SysGlobalConstants.ADMIN_CITYCODE.equals(citycode), "admin用户不能执行此操作，请切换为公交公司后台系统用户登入！");
		return baseRouteMapper.getRouteByName(routeName, citycode, TimeUtils.decideSeason());
	}

	/***
	 * *
	* <p>Title: getRoutesByKeywordNumber</p>
	* <p>Description: 语音查询结果精确匹配查询</p>
	* @param keyword
	* @param cityCode
	* @return
	 * @throws NoSuchMethodException 
	 */
	@Override
	public SimpleRouteCustom getRoutesByKeywordNumber(String keyword, String cityCode) {
		List<BaseRoute> baseRoutes = baseRouteMapper.getRoutesByKeywordNumber(cityCode, keyword);
		SimpleRouteCustom simpleRouteCustom = new SimpleRouteCustom();

		BaseRoute baseRoute = null;

		int count = baseRoutes.size();

		if (count == 0) {
			//无目标结果
			simpleRouteCustom.setFlag(AudioRouteReturnEnum.EMPTY_RESULT.getType().toString());
		} else if (count > 0 && count <= 2) {
			//精确匹配仅含个结果
			baseRoute = baseRoutes.get(0);
			BeanUtils.copyProperties(baseRoute, simpleRouteCustom);
			simpleRouteCustom.setFlag(AudioRouteReturnEnum.UNIQUE_RESULT.getType().toString());
		} else {
			//精确匹配含多个结果
			simpleRouteCustom.setFlag(AudioRouteReturnEnum.MULTIPLE_RESULT.getType().toString());
		}

		return simpleRouteCustom;
	}

	/**
	 * 功能描述:查询符合起始点经纬度范围内乘车方案的人民公交
	 * 作者:温海金
	 * 最后更改时间 : 2017年6月8日 下午5:29:05
	 */
	@Override
	public List<GeneralRoute> findRoutesByStartAndDistinctPlace(BigDecimal startlongitude, BigDecimal startlatitude, BigDecimal endlongitude, BigDecimal endlatitude,
			String citycode) {
		List<BaseRoute> routes = baseRouteMapper.findRoutesByStartAndDistinctPlace(startlongitude, startlatitude, endlongitude, endlatitude, citycode);
		List<GeneralRoute> generalRoutes = new ArrayList<>();
		routes.forEach(route ->{
			UpAndDownStation upStation = relRouteStationMapper.getNearestStation(route.getRouteid(),route.getDirection(),route.getCitycode(),startlongitude, startlatitude);
			UpAndDownStation downStation = relRouteStationMapper.getNearestStation(route.getRouteid(),route.getDirection(),route.getCitycode(),endlongitude, endlatitude);
			RealTime nearestBus = baseStationService.getNearestBusRealTime(new RealTimeQueryModel(route.getRouteid(), upStation.getStationid().toString(), route.getDirection(), upStation.getStationNo(), route.getCitycode()));
			generalRoutes.add(new GeneralRoute(route, upStation, downStation, nearestBus));
		});
		return generalRoutes;
	}

	@Override
	public AllRoutesVo findAllRoutesByStartAndDistinctPlace(BigDecimal startlongitude, BigDecimal startlatitude, BigDecimal endlongitude, BigDecimal endlatitude,
			String citycode) {
		List<GeneralRoute> generalRoutes = findRoutesByStartAndDistinctPlace(startlongitude, startlatitude, endlongitude, endlatitude, citycode);
		List<CustomLine> customLines = customLineService.findCustomLineByStartAndDistinctPlace(null, startlongitude, startlatitude, endlongitude, endlatitude, citycode, CustomLineStatusEnum.ALREAD_OPEN.value());
		return new AllRoutesVo(generalRoutes, customLines);
	}
	
	/**
	 * 功能描述:根据当前位置查询经过该位置附近站点的人民公交
	 * 作者:温海金
	 * 最后更改时间 : 2017年7月17日 下午6:04:49
	 */
	private List<BaseRoute> findRoutesByCurrentPlace(BigDecimal startlongitude, BigDecimal startlatitude, String citycode) {
		return baseRouteMapper.findRoutesByCurrentPlace(startlongitude, startlatitude, citycode);
	}
	
	/**
	 * 功能描述:根据当前位置查询经过该位置附近站点的专线信息
	 * 作者:温海金
	 * 最后更改时间 : 2017年7月17日 下午6:04:49
	 */
	private List<CustomLine> findCustomRoutesByCurrentPlace(BigDecimal startlongitude, BigDecimal startlatitude, String citycode) {
		return customLineService.findCustomRoutesByCurrentPlace(startlongitude, startlatitude, citycode);
	}
	/**
	 * 功能描述:根据当前位置查询经过该位置附近站点的拼车信息
	 * 作者:温海金
	 * 最后更改时间 : 2017年7月18日 下午5:34:16
	 */
	private List<CarpoolMatchAndRouteResultModel> findCarpoolRoutesByCurrentPlace(BigDecimal startlongitude, BigDecimal startlatitude, String citycode) {
		List<CarpoolMatchAndRouteResultModel> carpoolMatchs = carpoolMatchService.findCarpoolRoutesByCurrentPlace(startlongitude, startlatitude, citycode);
		Map<String, CarpoolMatchAndRouteResultModel> carpoolMatchMap = new HashMap<>();//存放最后一次撮合结果
		carpoolMatchs.forEach(carpoolMatch ->{
			String carpoolRouteId = carpoolMatch.getCarpoolRouteId();
			CarpoolMatchAndRouteResultModel carpoolInMap = carpoolMatchMap.get(carpoolRouteId);
			if (carpoolInMap == null || carpoolMatch.getMatchTimes()>carpoolInMap.getMatchTimes()) {
				carpoolMatchMap.put(carpoolRouteId, carpoolMatch);
			}
		});
		Iterator<CarpoolMatchAndRouteResultModel> iterator = carpoolMatchMap.values().iterator();
		List<CarpoolMatchAndRouteResultModel> results = new ArrayList<>();
		while(iterator.hasNext()) {
			CarpoolMatchAndRouteResultModel carpoolMatch = iterator.next();
			convert(carpoolMatch);
			results.add(carpoolMatch);
		}
		return results;
	}
	/**
	 * 功能描述:加入起点站与终点站信息
	 * 作者:温海金
	 * 最后更改时间 : 2017年7月18日 下午6:26:06
	 */
	private void convert(CarpoolMatchAndRouteResultModel carpoolMatch) {
		CarpoolRouteStation startStation = carpoolMatchService.findStartOrEndStation(carpoolMatch.getCarpoolRouteId(), CarpoolStationTypeEnum.START_STATION.value());
		CarpoolRouteStation endStation = carpoolMatchService.findStartOrEndStation(carpoolMatch.getCarpoolRouteId(), CarpoolStationTypeEnum.END_STATION.value());
		carpoolMatch.setStartStationName(startStation==null ? "" : startStation.getStationName());
		carpoolMatch.setEndStationName(endStation==null ? "" : endStation.getStationName());
	}
	/**
	 * 功能描述:根据当前位置查询经过该位置附近站点的所有公交（包括人民公交，公交专线，拼车信息）
	 * 作者:温海金
	 * 最后更改时间 : 2017年7月17日 下午4:40:38
	 */
	@Override
	public AllLines findAllLinesByCurrentLocation(BigDecimal startlongitude, BigDecimal startlatitude, String citycode) {
		//有效经纬度范围判断（中国的经纬度范围大约为：纬度3.86~53.55，经度73.66~135.05）
		if (startlongitude.doubleValue()<73.66 || startlongitude.doubleValue()>135.05 || startlatitude.doubleValue()<3.86 || startlatitude.doubleValue()>53.55) {
			return new AllLines(Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
		}
		//1.获取人民公交信息
		List<BaseRoute> baseRoutes = this.findRoutesByCurrentPlace(startlongitude, startlatitude, citycode);
		//2.获取专线信息  
		List<CustomLine> customLines = this.findCustomRoutesByCurrentPlace(startlongitude, startlatitude, citycode);
		//3.获取拼车信息 TODO
		List<CarpoolMatchAndRouteResultModel> carpoolMatchs = this.findCarpoolRoutesByCurrentPlace(startlongitude, startlatitude, citycode);
		return new AllLines(baseRoutes, customLines, carpoolMatchs);
	}
	
	@Override
	public List<BaseRoute> findSpecialLines(String cityCode, Integer routeType){
		return this.baseRouteMapper.selectByCityCode(cityCode, routeType);
	}
}
