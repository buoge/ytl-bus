package com.lantaiyuan.ebus.custom.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;
import com.lantaiyuan.ebus.common.util.GpsCorrectUtil;
import com.lantaiyuan.ebus.common.util.TimeUtils;
import com.lantaiyuan.ebus.custom.dao.BaseRouteMapper;
import com.lantaiyuan.ebus.custom.dao.BaseStationMapper;
import com.lantaiyuan.ebus.custom.model.BaseRoute;
import com.lantaiyuan.ebus.custom.model.BaseStation;
import com.lantaiyuan.ebus.custom.model.BaseStationQueryModel;
import com.lantaiyuan.ebus.custom.model.StationNameInfo;
import com.lantaiyuan.ebus.custom.service.BaseRouteServiceI;
import com.lantaiyuan.ebus.custom.service.BaseStationServiceI;
import com.lantaiyuan.ebus.realtime.dao.BdCommonSearchMapper;
import com.lantaiyuan.ebus.realtime.model.BaseLine;
import com.lantaiyuan.ebus.realtime.model.NearStationsWithLine;
import com.lantaiyuan.ebus.realtime.model.RealTime;
import com.lantaiyuan.ebus.realtime.model.RealTimeQueryModel;
import com.lantaiyuan.ebus.realtime.model.RouteDetail;
import com.lantaiyuan.ebus.realtime.model.RouteDetailAndRealTime;
import com.lantaiyuan.ebus.realtime.model.RouteDetailQueryModel;
import com.lantaiyuan.ebus.realtime.model.RouteInBaseLine;
import com.lantaiyuan.ebus.realtime.model.StationAndBaseLines;
import com.lantaiyuan.ebus.realtime.model.StationNearInfo;
import com.lantaiyuan.ebus.realtime.service.TravelServiceI;

/**
 * 描述:站点管理业务类 作者:温海金 最后更改时间:上午11:50:22 待修改
 */
@CacheConfig(cacheNames = "nearStation")
@Service("baseStationService")
public class BaseStationServiceImpl extends BaseService<BaseStation, BaseStationQueryModel>
		implements BaseStationServiceI {
	@Resource
	private BaseStationMapper baseStationMapper;

	@Resource
	private BdCommonSearchMapper bdCommonSearchMapper;

	@Resource
	private BaseRouteMapper baseRouteMapper;

	@Resource
	private TravelServiceI travelServiceNew;;

	@Resource
	private BaseRouteServiceI baseRouteService;

	@Override
	public BaseDAO<BaseStation, BaseStationQueryModel> getDao() {
		return baseStationMapper;
	}

	@Override
	public BaseStation queryStationByName(String stationName, String cityCode) {
		return baseStationMapper.queryStationByName(stationName, cityCode);
	}

	/**
	 * 模糊查询车站信息
	 */
	@Override
	public List<StationNameInfo> queryStationList(String stationname, String citycode) {
		return baseStationMapper.queryStationList(stationname, citycode);
	}

	/**
	 * <p>
	 * Title: getStationByName
	 * </p>
	 * <p>
	 * Description: 模糊查询站点信息
	 * </p>
	 * 
	 * @author:liuhao
	 */
	@Override
	public List<BaseStation> getStationByName(String stationName, String cityCode) {
		return baseStationMapper.getStationByName(stationName, cityCode);
	}

	/**
	 * <p>
	 * Title: getStationByName
	 * </p>
	 * <p>
	 * Description: 根据stationId查询站点信息
	 * </p>
	 * 
	 * @author:liuhao
	 */
	public BaseStation getStationById(String stationId, String cityCode) {
		return baseStationMapper.getStationById(stationId, cityCode);
	}

	/**
	 * 根据站点id list，routeid，citycode，direction查出站点list
	 * 
	 * @author yangyang
	 */
	@Override
	public List<BaseStation> getStationsByIds(String routeId, String cityCode, int direction) {
		return baseStationMapper.getStationsByIds(routeId, cityCode, direction);
	}

	/**
	 * 描述:获取当前站点附近的站点及线路信息 （原 最近站点&附近站点QueryController.java中的nearestStation接口）
	 * 作者:温海金 最后更改时间:上午11:50:22
	 */
	@Override
	@Cacheable
	public StationNearInfo getNearestInfo(BaseStation baseStation) {
		/***************************
		 * 常用查询业务逻辑***new added by liuhao
		 ****************************/
		// BdCommonSearch bdCommonSearch =
		// bdCommonSearchMapper.selectRouteStationByUserId("15",
		// baseStation.getCitycode());
		// BaseStation regularStation = baseStationMapper
		// .getStationByStationId(bdCommonSearch.getAboardStationId().toString(),
		// baseStation.getCitycode());
		//
		// // 对站点进行GPS纠偏处理
		// updataTheCorrectOfGps(regularStation);
		//
		// BaseRoute regularRoute =
		// baseRouteMapper.getRouteByIdAndDirection(baseStation.getCitycode(),
		// bdCommonSearch.getRouteId(), bdCommonSearch.getDirection());
		//
		// RouteInBaseLine riBaseLine = new RouteInBaseLine();
		// BeanUtils.copyProperties(regularRoute, riBaseLine);
		//
		// RealTime realTime = getBusDetailInfo(baseStation.getCitycode(),
		// regularStation, regularRoute);
		// BaseLine regularLine = new BaseLine(riBaseLine, realTime);
		/******************************* end ****************************************/

		// 对当前位置进行纠偏处理
		correctOfGpsFromGaode2Google(baseStation);
		// 1.获取附近站点,按距离从近到远排序
		List<BaseStation> nearStations = baseStationMapper.getNearStations(baseStation, SysGlobalConstants.THREE_KM);
		if (!CollectionUtils.isEmpty(nearStations)) {
			// 2.得到最近的站点
			BaseStation nearestStation = nearStations.get(0);
			// 3.对站点进行GPS纠偏处理
			updataTheCorrectOfGps(nearestStation);

			if (nearestStation.getDistance() == null) {
				nearestStation.setDistance(0.0);
			}
			if (nearestStation.getStationno() == null) {
				nearestStation.setStationno(0);
			}

			// 4.得到附近的路线
			List<BaseRoute> baseRoutes = baseRouteService.getRoutesByStationId(nearestStation.getStationid().toString(),
					nearestStation.getCitycode(), TimeUtils.decideSeason());

			List<BaseLine> lines = new ArrayList<>();// 线路信息
			// 5.得到实时车辆信息
			baseRoutes.forEach(baseRoute -> {
				RouteInBaseLine routeInBaseLine = new RouteInBaseLine();
				BeanUtils.copyProperties(baseRoute, routeInBaseLine);
				RealTime busRealTimeInfo = getBusDetailInfo(baseStation.getCitycode(), nearestStation, baseRoute);
				lines.add(new BaseLine(routeInBaseLine, busRealTimeInfo));
			});
			return new StationNearInfo(nearestStation == null ? new BaseStation() : nearestStation, lines, nearStations,
					null, null);
		}
		BaseStation emptyStation = new BaseStation();
		// 此处return null的话前端会显示default，无法解析，返回以下结构;
		// 温海金 2017-05-12
		return new StationNearInfo(emptyStation, Collections.EMPTY_LIST, Collections.EMPTY_LIST, emptyStation,
				new BaseLine());
	}

	/**
	 * 根据站点Id和城市编码查询站点信息
	 * 
	 * @auther yangyang
	 * @param stationId
	 * @param cityCode
	 * @return
	 */
	private BaseStation getStationByStationId(String stationId, String cityCode) {
		return baseStationMapper.getStationByStationId(stationId, cityCode);
	}

	/**
	 * 描述:查出包含5分钟和10分钟步行范围内的站点信息（包含经过该站点的线路信息） （原
	 * 附近站点（5min，10min）QueryController.java中的nearStationsFiveAndTen接口） 作者:温海金
	 * 最后更改时间:上午11:50:22
	 */
	@Override
	@Cacheable
	public Map<String, List<StationAndBaseLines>> nearStationsWithRouteFiveAndTen(BaseStation baseStation) {
		// 对当前位置进行纠偏处理
		correctOfGpsFromGaode2Google(baseStation);
		// 1.获取步行10分钟内站点,按距离从近到远排序
		List<BaseStation> stationsWithTen = baseStationMapper.getNearStations(baseStation,
				SysGlobalConstants.TEN_DISTANCE);
		// 2.获取步行5分钟内站点,按距离从近到远排序
		List<BaseStation> stationsWithFive = getStationsWalkInFive(baseStation, stationsWithTen);
		// 3.移除步行5分钟内的站点，得到步行距离从5分钟到10分钟范围的站点
		stationsWithTen.removeAll(stationsWithFive);
		// 4.纠偏处理
		updataTheCorrectOfGps(stationsWithFive);
		updataTheCorrectOfGps(stationsWithTen);
		// 5.得到步行5分钟内的站点及线路信息
		List<StationAndBaseLines> stationWithRouteInFive = getStationWithRouteInfo(baseStation.getCitycode(),
				stationsWithFive);
		// 6.得到步行5分钟到10分钟范围内的站点及线路信息
		List<StationAndBaseLines> stationWithRouteInTen = getStationWithRouteInfo(baseStation.getCitycode(),
				stationsWithTen);
		Map<String, List<StationAndBaseLines>> stationBaseLinesIn5And10Map = new HashMap<>();
		stationBaseLinesIn5And10Map.put("stationWithRouteInFive", stationWithRouteInFive);
		stationBaseLinesIn5And10Map.put("stationWithRouteInTen", stationWithRouteInTen);
		return stationBaseLinesIn5And10Map;
	}

	private void correctOfGpsFromGaode2Google(BaseStation station) {
		if (station == null || station.getLatitude() == null || station.getLongitude() == null)
			return;
		double[] latlng = GpsCorrectUtil.gcj02_To_Gps84(station.getLatitude().doubleValue(),
				station.getLongitude().doubleValue());
		station.setLatitude(BigDecimal.valueOf(latlng[0]));
		station.setLongitude(BigDecimal.valueOf(latlng[1]));
	}

	/**
	 * 功能描述:从步行范围10分钟范围内的站点中过滤出步行范围5分钟的站点,避免再次查询数据库 作者:温海金 最后更改时间 : 2016年12月23日
	 * 下午5:26:04
	 */
	private List<BaseStation> getStationsWalkInFive(BaseStation curentStation, List<BaseStation> stationsWithTen) {
		List<BaseStation> stationsWithFive = new ArrayList<>();
		stationsWithTen.forEach(station -> {
			if (station != null && travelServiceNew.isNearStation(station, curentStation.getLongitude().doubleValue(),
					curentStation.getLatitude().doubleValue(), SysGlobalConstants.FIVE_DISTANCE)) {
				stationsWithFive.add(station);
			}
		});
		return stationsWithFive;
	}

	/**
	 * 功能描述:为集合中的每个站点添加线路及实时车辆信息 作者:温海金 最后更改时间 : 2016年12月22日 下午3:00:53
	 */
	private List<StationAndBaseLines> getStationWithRouteInfo(String cityCode, List<BaseStation> stations) {
		List<StationAndBaseLines> stationAndBaseLinesList = new ArrayList<>();
		// 在站点信息中加入线路及实时车辆信息
		stations.forEach(station -> {
			if (station.getStationid() != null && !StringUtils.isEmpty(cityCode)) {
				List<BaseRoute> baseRoutes = baseRouteService.getRoutesByStationId(station.getStationid().toString(),
						cityCode, TimeUtils.decideSeason());
				List<BaseLine> lines = new ArrayList<>();// 线路信息
				// 得到实时车辆信息
				baseRoutes.forEach(baseRoute -> {
					RouteInBaseLine routeInBaseLine = new RouteInBaseLine();
					BeanUtils.copyProperties(baseRoute, routeInBaseLine);
					RealTime busRealTimeInfo = getBusDetailInfo(cityCode, station, baseRoute);
					lines.add(new BaseLine(routeInBaseLine, busRealTimeInfo));
				});
				// 构建站点及线路信息对象
				StationAndBaseLines stationAndBaseLines = new StationAndBaseLines(station, lines);
				stationAndBaseLinesList.add(stationAndBaseLines);
			}

		});
		// 若要去重则调用travelService.duplicateStations(stationAndRoutesList)即可，这边不做处理，一期是因为数据问题
		return stationAndBaseLinesList;
	}

	/***
	 * *
	 * <p>
	 * Title: getRoutesByStationName
	 * </p>
	 * <p>
	 * Description: 根据stationName获取所有经过该站点的线路
	 * </p>
	 * 
	 * @author liuhao
	 * @param stationName
	 * @param cityCode
	 * @return
	 */
	@Override
	public List<BaseLine> getRoutesByStationName(String stationName, String cityCode) {
		List<BaseStation> baseStations = getStationByName(stationName, cityCode);

		// 查询不到结果，返回空集合
		if (CollectionUtils.isEmpty(baseStations)) {
			return Collections.emptyList();
		}

		// 为每一个站点的经纬度做GPS矫正
		baseStations.forEach(baseStation -> {
			this.updataTheCorrectOfGps(baseStation);
		});

		// 返回结果集合
		List<BaseLine> baseLines = new ArrayList<>();

		// 集合所有满足条件的线路
		baseStations.forEach(baseStation -> {
			List<BaseRoute> routes = baseRouteService.getRoutesByStationId(String.valueOf(baseStation.getStationid()),
					cityCode, TimeUtils.decideSeason());
			if (!CollectionUtils.isEmpty(routes)) {
				routes.forEach(r -> {
					RealTime bd = travelServiceNew.getNearestBus(cityCode, baseStation, r,
							travelServiceNew.getUserStationNo(r.getRouteid(), baseStation, r.getDirection()));
					baseLines.add(new BaseLine(new RouteInBaseLine(r), bd == null ? new RealTime() : bd));
				});
			}
		});

		// 排序
		if (!CollectionUtils.isEmpty(baseLines)) {
			baseLines.sort((first, second) -> {
				if (first.getRouteInBaseLine().getRouteid() == second.getRouteInBaseLine().getRouteid()) {
					return second.getRouteInBaseLine().getId() - first.getRouteInBaseLine().getId();
				}
				return Integer.valueOf(second.getRouteInBaseLine().getRouteid())
						- Integer.valueOf(first.getRouteInBaseLine().getRouteid());
			});
		}

		return baseLines;
	}

	/**
	 * 功能描述:获取默认范围内的附近站点信息 作者:温海金 最后更改时间 : 2016年12月22日 下午3:00:53
	 */
	private RealTime getBusDetailInfo(String cityCode, BaseStation station, BaseRoute baseRoute) {
		return travelServiceNew.getNearestBus(cityCode, station, baseRoute, null);
	}

	/**
	 * 功能描述:获取默认范围内的附近站点信息 (原 附近站点QueryController.java 中的nearStations接口) 作者:温海金
	 * 最后更改时间 : 2016年12月22日 下午3:00:53
	 */
	@Override
	public NearStationsWithLine nearStations(BaseStation baseStation) {
		// 1.获取默认范围内的附近站点信息,按距离从近到远排序
		List<BaseStation> stationsWithDefaltDistance = baseStationMapper.getNearStations(baseStation,
				SysGlobalConstants.DEFAULT_DISTANCE);
		// 2.纠偏处理
		updataTheCorrectOfGps(stationsWithDefaltDistance);
		List<StationAndBaseLines> StationAndBaseLinesList = getStationWithRouteInfo(baseStation.getCitycode(),
				stationsWithDefaltDistance);
		return new NearStationsWithLine(StationAndBaseLinesList);
	}

	/**
	 * 功能描述:为单个站点进行GPS纠偏处理 作者:温海金 最后更改时间 : 2016年12月22日 下午3:58:32
	 */
	@Override
	public void updataTheCorrectOfGps(BaseStation station) {
		if (station == null)
			return;
		double[] latlng = new double[2];
		GpsCorrectUtil.transform(station.getLatitude().doubleValue(), station.getLongitude().doubleValue(), latlng);
		station.setLatitude(BigDecimal.valueOf(latlng[0]));
		station.setLongitude(BigDecimal.valueOf(latlng[1]));
	}

	/**
	 * 功能描述:为站点集合进行GPS纠偏处理 作者:温海金 最后更改时间 : 2016年12月22日 下午3:58:32
	 */
	@Override
	public void updataTheCorrectOfGps(List<BaseStation> stations) {
		stations.forEach(station -> {
			updataTheCorrectOfGps(station);
		});
	}

	/**
	 * <p>
	 * Title: getRoutesByStationId
	 * </p>
	 * <p>
	 * Description: 根据stationId获取所有经过该站点的线路
	 * </p>
	 * 
	 * @author liuhao
	 */
	@Override
	public List<BaseLine> getRoutesByStationId(String stationId, String cityCode) {
		BaseStation station = getStationById(stationId, cityCode);

		// 为每一个站点的经纬度做GPS矫正
		this.updataTheCorrectOfGps(station);

		List<BaseRoute> baseRoutes = baseRouteService.getRoutesByStationId(stationId, cityCode,
				TimeUtils.decideSeason());

		List<BaseLine> list = new ArrayList<>();

		if (CollectionUtils.isEmpty(baseRoutes)) {
			baseRoutes = new ArrayList<>();
		}

		baseRoutes.forEach(r -> {
			RealTime bd = travelServiceNew.getNearestBus(cityCode, station, r,
					travelServiceNew.getUserStationNo(r.getRouteid(), station, r.getDirection()));
			list.add(new BaseLine(new RouteInBaseLine(r), bd == null ? new RealTime() : bd));
		});

		return list;
	}

	/**
	 * <p>
	 * Title: getRoutesByStationIdAndStationName
	 * </p>
	 * <p>
	 * Description: 根据当前stationId/stationName/cityCode获取到达目标站点所有线路集合
	 * </p>
	 * 
	 * @author liuhao
	 */
	@Override
	public List<BaseLine> getRoutesByStationIdAndStationName(String stationId, String stationName, String cityCode) {
		List<RouteInBaseLine> routeInBaseLines = baseRouteService.queryRoutesByStationIdAndStationName(stationId,
				stationName, cityCode, TimeUtils.decideSeason());

		BaseStation userStation = baseStationMapper.getStationById(stationId, cityCode);

		List<BaseLine> baseLines = new ArrayList<>();
		if (!CollectionUtils.isEmpty(routeInBaseLines)) {
			routeInBaseLines.forEach(routeInBaseLine -> {
				BaseLine baseLine = new BaseLine();
				baseLine.setRouteInBaseLine(routeInBaseLine);
				BaseRoute baseRoute = new BaseRoute();
				BeanUtils.copyProperties(routeInBaseLine, baseRoute);
				RealTime realTime = travelServiceNew.getNearestBus(cityCode, userStation, baseRoute, travelServiceNew
						.getUserStationNo(routeInBaseLine.getRouteid(), userStation, routeInBaseLine.getDirection()));
				baseLine.setRealTime(realTime);
				baseLines.add(baseLine);
			});
		}

		return baseLines;
	}

	/**
	 * 获取城市所有站点
	 * 
	 * @auther yangyang
	 * @param cityCode
	 * @return
	 */
	@Override
	public Map<String, BaseStation> getCityStations(String cityCode, String routeId, int direction) {
		List<BaseStation> stationList = baseStationMapper.getCityStations(cityCode, routeId, direction);
		if (StringUtils.isEmpty(stationList)) {
			return Collections.emptyMap();
		}
		Map<String, BaseStation> map = new HashMap<>();
		stationList.forEach(station -> {
			map.put(String.valueOf(station.getStationid()), station);
		});
		return map;
	}

	@Override
	public BaseStation queryStationByTicketIdAndStationNo(String ticketId, int direction, int onBusStationNo) {
		return baseStationMapper.queryStationByTicketIdAndStationNo(ticketId, direction, onBusStationNo);
	}

	@Override
	public List<RealTime> getRealTimeInfo(RealTimeQueryModel realTime) {
		// 根据stationId获取到目标站点
		BaseStation station = this.getStationByStationId(realTime.getStationid(), realTime.getCitycode());
		// 为站点的经纬度做GPS矫正
		this.updataTheCorrectOfGps(station);

		List<RealTime> list = travelServiceNew.getBusList(realTime, station);
		if (CollectionUtils.isEmpty(list)) {
			list = Collections.emptyList();
		}
		Collections.sort(list, (a, b) -> { // 站序从小到大排序
			if (a.getDesc().getStationnumber() == b.getDesc().getStationnumber()) {
				return a.getDesc().getDistance().compareTo(b.getDesc().getDistance());
			}
			return a.getDesc().getStationnumber() - b.getDesc().getStationnumber();
		});
		baseRouteService.correctBusLonAndLan(list, baseRouteService.processMapPath(realTime.getRouteid(),
				realTime.getDirection(), realTime.getCitycode()));
		return list;
	}

	/**
	 * 返回最近一辆车的实时信息
	 * 
	 * @author yangyang
	 * @param realTime
	 * @return
	 */
	@Override
	public RealTime getNearestBusRealTime(RealTimeQueryModel realTime) {
		List<RealTime> busList = this.getRealTimeInfo(realTime);
		return travelServiceNew.getNearestBus(busList);

	}

	/**
	 * 获取线路详情和最近一辆车的信息
	 * @author yangyang
	 * @param routeDetailQueryModel
	 * @return
	 */
	@Override
	public RouteDetailAndRealTime getRouteDetailAndRealTime(RouteDetailQueryModel routeDetailQueryModel) {
		RouteDetail routeDetail = baseRouteService.getRouteDetail(routeDetailQueryModel);
		RealTimeQueryModel realTimeQueryModel = new RealTimeQueryModel();
		realTimeQueryModel.citycode(routeDetailQueryModel.getCitycode()).direction(routeDetailQueryModel.getDirection())
		.routeid(routeDetailQueryModel.getRouteid()).userstationno(routeDetail.getCurrentStation().getStationno())
		.stationid(String.valueOf(routeDetail.getCurrentStation().getStationid()));
		RealTime realTime = travelServiceNew.getNearestBus(routeDetail.getCarList());
		return new RouteDetailAndRealTime(routeDetail, realTime);

	}

	@Override
	public List<BaseStation> getAllStations() {
		return baseStationMapper.getAllStations();
	}

	@Override
	public List<BaseStation> queryStationsByStationIdsAndCityCodes(List<BaseStationQueryModel> model) {
		return baseStationMapper.queryStationsByStationIdsAndCityCodes(model);
	}

	@Override
	public Object removeDduplicateStation(String cityCode) {
		List<Map<String, String>> stationMap = baseStationMapper.queryTimesOfStation(cityCode, 1);
		for (Map<String, String> stationSample : stationMap) {
			stationSample.get("name");
			stationSample.get("count");
			BaseStation[] stationArr = new BaseStation[Integer.valueOf(stationSample.get("count"))];
		}
		List<BaseStation> stationList = baseStationMapper.queryStationDetail(cityCode, 1);
		return null;
	}

	/**
	 * 功能描述:根据站点信息得到线路信息（包含实时数据） 作者:温海金 最后更改时间 : 2017年6月22日 下午2:09:09
	 */
	@Override
	@Cacheable
	public List<BaseLine> getLinesNearBy(BaseStation nearestStation) {
		// 对当前位置进行纠偏处理
		// correctOfGpsFromGaode2Google(baseStation);
		// 3.对站点进行GPS纠偏处理
		// updataTheCorrectOfGps(nearestStation);
		// 4.得到附近的路线
		List<BaseRoute> baseRoutes = baseRouteService.getRoutesByStationId(nearestStation.getStationid().toString(),
				nearestStation.getCitycode(), TimeUtils.decideSeason());

		List<BaseLine> lines = new ArrayList<>();// 线路信息
		// 5.得到实时车辆信息
		baseRoutes.forEach(baseRoute -> {
			RouteInBaseLine routeInBaseLine = new RouteInBaseLine();
			BeanUtils.copyProperties(baseRoute, routeInBaseLine);
			RealTime busRealTimeInfo = getBusDetailInfo(nearestStation.getCitycode(), nearestStation, baseRoute);
			lines.add(new BaseLine(routeInBaseLine, busRealTimeInfo));
		});
		
		Collections.sort(lines, (a, b) -> {
			if(a!=null && b!=null) {
				return 0;
			}
			return a.getRealTime().getDesc().getTime() - b.getRealTime().getDesc().getTime();
		});
		return lines;
	}
	
}
