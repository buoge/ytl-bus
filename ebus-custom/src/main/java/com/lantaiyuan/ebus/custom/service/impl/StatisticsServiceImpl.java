package com.lantaiyuan.ebus.custom.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;
import com.lantaiyuan.ebus.common.util.AngleUtil;
import com.lantaiyuan.ebus.common.util.Tools;
import com.lantaiyuan.ebus.custom.model.AggregationGroup;
import com.lantaiyuan.ebus.custom.model.BaseStation;
import com.lantaiyuan.ebus.custom.model.BaseStationQueryModel;
import com.lantaiyuan.ebus.custom.model.Cities;
import com.lantaiyuan.ebus.custom.model.ODMap;
import com.lantaiyuan.ebus.custom.model.OriDestPoint;
import com.lantaiyuan.ebus.custom.model.StationUserCount;
import com.lantaiyuan.ebus.custom.model.Statistics;
import com.lantaiyuan.ebus.custom.model.StatisticsQueryModel;
import com.lantaiyuan.ebus.custom.model.TrendQueryModel;
import com.lantaiyuan.ebus.custom.model.TrendStatistics;
import com.lantaiyuan.ebus.custom.model.UserStatistics;
import com.lantaiyuan.ebus.custom.model.acquisition.RouteDetail;
import com.lantaiyuan.ebus.custom.model.acquisition.StartAppInfo;
import com.lantaiyuan.ebus.custom.model.acquisition.UserStartAppInfo;
import com.lantaiyuan.ebus.custom.model.enummodel.CMDEnum;
import com.lantaiyuan.ebus.custom.model.enummodel.StatFrequencyEnum;
import com.lantaiyuan.ebus.custom.service.BaseStationServiceI;
import com.lantaiyuan.ebus.custom.service.ServiceIpServiceI;
import com.lantaiyuan.ebus.custom.service.StatisticsServiceI;
import com.mongodb.BasicDBObject;

/**
 * @Title: StatisticsServiceImpl.java
 * @Package com.lantaiyuan.ebus.custom.service.impl
 * @Description: 数据统计service，先简单实现查询，虽然有了集合语句，写的也不是很完善
 * @author yangyang
 * @date 2017年2月18日 上午11:31:32
 * @version v1.0
 */
@Service("statisticsService")
public class StatisticsServiceImpl extends BaseService<Statistics, StatisticsQueryModel> implements StatisticsServiceI {

	@Autowired
	private MongoTemplate mt;

	@Autowired
	private ServiceIpServiceI serviceIpService;

	@Autowired
	private BaseStationServiceI baseStationService;

	

	/**
	 * 用户统计
	 * 
	 * @author yangyang
	 */
	@Override
	public UserStatistics userStatistics() {
		return dayStat(cityMap());
	}

	/**
	 * 趋势统计
	 * 
	 * @author yangyang
	 */
	@Override
	public List<TrendStatistics> trendStatistics(StatisticsQueryModel queryModel) {
		List<TrendQueryModel> trendQueryModel = trendQueryModels(queryModel);
		List<TrendStatistics> trend = new ArrayList<>();
		trendQueryModel.forEach(model -> {
			long newUsers = periodNewUsers(model);
			long totalUsers = periodTotalUsers(model);
			long startTimes = periodStartTimes(model);
			long activeUsers = periodActiceUsers(model);
			trend.add(new TrendStatistics().activeusers(activeUsers).newusers(newUsers).totalusers(totalUsers)
					.starttimes(startTimes).date(Tools.processDateToStr(model.getStartDate(), "yyyy-MM-dd")));
		});
		return trend;
	}

	/**
	 * 地图OD导向图
	 * 
	 * @auther yangyang
	 * @param cityCode
	 * @return
	 */
	@Override
	public List<ODMap> odMap(String cityCode) {
		return fillAllInfo(cityCode, cityMap());
	}

	/**
	 * 处理站点名称，经纬度，方位角
	 * 
	 * @auther yangyang
	 * @param cityCode
	 * @return
	 */
	private List<ODMap> fillAllInfo(String cityCode, Map<String, String> cities) {
		List<ODMap> odMap = startOrEnd(cityCode, cities);
		// stationId-cityCode
		Set<String> stationSet = new HashSet<>();
		odMap.forEach(od -> {
			stationSet.add(od.getStart().getStationId().concat("-").concat(od.getStart().getCityCode()));
			stationSet.add(od.getEnd().getStationId().concat("-").concat(od.getEnd().getCityCode()));
		});
		List<BaseStationQueryModel> model = new ArrayList<>();
		stationSet.forEach(set -> {
			BaseStationQueryModel bsqm = new BaseStationQueryModel();
			String[] array = set.split("-");
			bsqm.setCitycode(array[1]);
			bsqm.setStationid(Integer.valueOf(array[0]));
			model.add(bsqm);
		});
		if (model.size() <= 0) {
			return Collections.emptyList();
		}
		List<BaseStation> stationList = baseStationService.queryStationsByStationIdsAndCityCodes(model);
		Map<String, BaseStation> stationMap = new HashMap<>();
		stationList.forEach(station -> {
			baseStationService.updataTheCorrectOfGps(station);
			stationMap.put(station.getStationid() + "-" + station.getCitycode(), station);
		});
		odMap.forEach(od -> {
			OriDestPoint start = od.getStart();
			BaseStation startStation = stationMap.get(start.getStationId().concat("-").concat(start.getCityCode()));
			if (startStation == null) {
				od.isIgnore(true);
				return;
			}
			start.stationName(startStation.getName()).lon(startStation.getLongitude()).lat(startStation.getLatitude());
			OriDestPoint end = od.getEnd();
			BaseStation endStation = stationMap.get(end.getStationId().concat("-").concat(end.getCityCode()));
			if (endStation == null) {
				od.isIgnore(true);
				return;
			}
			end.stationName(endStation.getName()).lon(endStation.getLongitude()).lat(endStation.getLatitude());

			od.angle(AngleUtil.getAngle(start.getLat().doubleValue(), start.getLon().doubleValue(),
					end.getLat().doubleValue(), end.getLon().doubleValue()));
		});

		return odMap;
	}

	/**
	 * 
	 * @auther yangyang
	 * @param cityCode
	 * @return
	 */
	private List<ODMap> startOrEnd(String cityCode, Map<String, String> cities) {
		Map<String, Integer> map = startEndCount(cityCode, cities);
		Map<String, Integer> start = new HashMap<>();
		Map<String, Integer> end = new HashMap<>();
		map.forEach((key, value) -> { // stationid-citycode:stationid-citycode
			String[] keyArray = key.split(":");
			Integer startCount = start.get(keyArray[0]);
			if (startCount == null) {
				start.put(keyArray[0], 1);
			} else {
				start.put(keyArray[0], 1 + startCount);
			}
			Integer endCount = end.get(keyArray[1]);
			if (endCount == null) {
				end.put(keyArray[1], 1);
			} else {
				end.put(keyArray[1], 1 + endCount);
			}
		});
		List<ODMap> odMapList = new ArrayList<>();

		map.forEach((key, value) -> { // stationid-citycode:stationid-citycode
			String[] keyArray = key.split(":");
			String startPoint = keyArray[0];
			OriDestPoint odStart = new OriDestPoint();
			String[] startArrays = startPoint.split("-");
			odStart.cityCode(startArrays[1]).stationId(startArrays[0]);
			if (end.get(startPoint) == null) { // 只是起点
				odStart.startOrEnd(0).startCount(start.get(startPoint));
			} else { // 既是起点，也是终点
				odStart.startOrEnd(2).startCount(start.get(startPoint)).endCount(end.get(startPoint));
			}
			String endPoint = keyArray[1];
			String[] endArrays = endPoint.split("-");
			OriDestPoint odEnd = new OriDestPoint();
			odEnd.cityCode(endArrays[1]).stationId(endArrays[0]);
			if (start.get(endPoint) == null) { // 只是终点
				odEnd.startOrEnd(1).endCount(end.get(endPoint));
			} else { // 既是终点，也是起点
				odStart.startOrEnd(2).startCount(start.get(endPoint)).endCount(end.get(endPoint));
			}
			ODMap odMap = new ODMap().start(odStart).end(odEnd).persons(value);
			odMapList.add(odMap);
		});
		return odMapList;
	}

	/**
	 * 统计起点终点次数
	 * 
	 * @auther yangyang
	 * @param cityCode
	 * @return
	 */
	private Map<String, Integer> startEndCount(String cityCode, Map<String, String> cities) {
		Map<String, List<StationUserCount>> map = userRouteTopTwoMap(cityCode, cities);
		// 剥离用户与站点的关系
		// key start:end value 次数
		Map<String, Integer> startEndMap = new HashMap<>();
		map.forEach((key, value) -> {
			String startEndKey = value.get(0).getStationInfo().concat(":").concat(value.get(1).getStationInfo());
			Integer count = startEndMap.get(startEndKey);
			if (count == null) {
				startEndMap.put(startEndKey, 1);
			} else {
				startEndMap.put(startEndKey, count + 1);
			}
		});
		return startEndMap;
	}

	/**
	 * 返回每个用户关注最多的两个站点
	 * 
	 * @auther yangyang
	 * @param cityCode
	 * @return
	 */
	private Map<String, List<StationUserCount>> userRouteTopTwoMap(String cityCode, Map<String, String> cities) {
		Map<String, List<StationUserCount>> result = new HashMap<>();
		Map<String, Map<String, Integer>> map = userRouteMap(cityCode, cities);
		map.forEach((key, value) -> {
			if (value == null) {
				return;
			}
			List<StationUserCount> stationList = new ArrayList<>();
			value.forEach((k, v) -> { // key：stationid-citycode
				StationUserCount ru = new StationUserCount();
				ru.stationInfo(k).count(v);
				stationList.add(ru);
			});
			stationList.sort((first, second) -> {
				return second.getCount() - first.getCount();
			});
			if (stationList.size() > 2) {
				result.put(key, stationList.subList(0, 2));
			}
		});
		return result;
	}

	/**
	 * 用户与线路的映射关系
	 * 
	 * @auther yangyang
	 * @param cityCode
	 * @return
	 */
	private Map<String, Map<String, Integer>> userRouteMap(String cityCode, Map<String, String> cities) {
		Query query = new Query();
		if (!StringUtils.isEmpty(cityCode) && !cityCode.equals("0") && !cityCode.equals("-1")) {
			// TODO
			query.addCriteria(Criteria.where("citycode").regex("^"+cityCode.substring(0,4)));
		}
		List<RouteDetail> routeDetail = mt.find(query, RouteDetail.class, CMDEnum.ROUTE_DETAIL.tableName());
		// 第一个map中 key：phonemodel value： 第二个map
		// 第二个map中 key：stationid-citycode value： 次数
		// 区分是否是工作日
		Map<String, Map<String, Integer>> map = new HashMap<>();
		routeDetail.forEach(route -> {
			if (StringUtils.isEmpty(route.getCurrenttime()) || StringUtils.isEmpty(route.getRouteid())
					|| StringUtils.isEmpty(route.getDirection()) || StringUtils.isEmpty(route.getStationId())
					|| StringUtils.isEmpty(route.getCitycode())) {
				return;
			}
			if (isWorkDay(route.getCurrenttime())) { // 周一至周五
				String outerKey = route.getPhonemodel();
				//处理城市编码
				if(route.getCitycode().length() <= 4) {
					return;
				}
				route.setCitycode(processCityCode(route.getCitycode().substring(0, 4), cities));
				StringBuilder innerKey = new StringBuilder().append(route.getStationId()).append("-")
						.append(route.getCitycode());
				Map<String, Integer> innerMap = map.get(route.getPhonemodel());
				if (innerMap == null) { // 用户第一次出现
										// 站点必定也是首次出现
					innerMap = new HashMap<>();
					innerMap.put(innerKey.toString(), 1);
					map.put(outerKey, innerMap);
				} else { // 用户非首次出现
					Integer innerValue = innerMap.get(innerKey.toString());
					if (innerValue == null) { // 站点首次出现
						innerMap.put(innerKey.toString(), 1);
					} else {
						innerMap.put(innerKey.toString(), innerValue + 1);
					}
				}
			}
		});
		return map;
	}

	/**
	 * 获取周期范围内的新增用户数量
	 * 
	 * @auther yangyang
	 * @param startDate
	 * @param endDate
	 * @param cityCode
	 * @return
	 */
	private long periodNewUsers(TrendQueryModel model) {
		Query query = new Query(Criteria.where("firststarttime").gte(model.getStartDate()).lte(model.getEndDate()));
		if (!StringUtils.isEmpty(model.getCitycode()) && !model.getCitycode().equals("0")
				&& !model.getCitycode().equals("-1")) {
			query.addCriteria(Criteria.where("citycode").regex("^"+model.getCitycode().substring(0, 4)));
			// TODO
		}
		return mt.count(query, SysGlobalConstants.USER_START_APP);
	}

	/**
	 * 获取周期范围内的用户总量
	 * 
	 * @auther yangyang
	 * @param startDate
	 * @param endDate
	 * @param cityCode
	 * @return
	 */
	private long periodTotalUsers(TrendQueryModel model) {
		Query query = new Query(Criteria.where("firststarttime").lte(model.getEndDate()));
		if (!StringUtils.isEmpty(model.getCitycode()) && !model.getCitycode().equals("0")
				&& !model.getCitycode().equals("-1")) {
			query.addCriteria(Criteria.where("citycode").regex(model.getCitycode().substring(0, 4)));
			// TODO
		}
		return mt.count(query, SysGlobalConstants.USER_START_APP);
	}

	/**
	 * 获取周期范围内的启动次数
	 * 
	 * @auther yangyang
	 * @param model
	 * @return
	 */
	private long periodStartTimes(TrendQueryModel model) {
		Query query = new Query(Criteria.where("currenttime").gte(model.getStartDate()).lte(model.getEndDate()));
		if (!StringUtils.isEmpty(model.getCitycode()) && !model.getCitycode().equals("0")
				&& !model.getCitycode().equals("-1")) {
			query.addCriteria(Criteria.where("citycode").regex("^"+model.getCitycode().substring(0, 4)));
			// TODO
		}
		return mt.count(query, CMDEnum.START.tableName());
	}

	/**
	 * 获取周期内的活跃用户数
	 * 
	 * @auther yangyang
	 * @param model
	 * @return
	 */
	private long periodActiceUsers(TrendQueryModel model) {
		BasicDBObject query = new BasicDBObject();
		BasicDBObject currentTime = new BasicDBObject();
		currentTime.put("$gte", model.getStartDate());
		currentTime.put("$lte", model.getEndDate());
		query.put("currenttime", currentTime);
		if (!StringUtils.isEmpty(model.getCitycode()) && !model.getCitycode().equals("0")
				&& !model.getCitycode().equals("-1")) {
			BasicDBObject cityCode = new BasicDBObject();
			cityCode.put("$regex", "^"+model.getCitycode().substring(0, 4));
			query.put("citycode", cityCode);
			// TODO
		}
		return mt.getCollection(CMDEnum.START.tableName()).distinct("phonemodel", query).size();
	}

	/**
	 * 根据起始日期、终止日期、日或周或月，计算出查询条件
	 * 
	 * @auther yangyang
	 * @param queryModel
	 *            需要有startDate, endDate, cityCode
	 * @return
	 */
	private List<TrendQueryModel> trendQueryModels(StatisticsQueryModel queryModel) {
		Date startDate = Tools.processStrToDate(queryModel.getStartDate(), "yyyy-MM-dd");
		Date endDate = Tools.processStrToDate(queryModel.getEndDate(), "yyyy-MM-dd");
		int diff = (int) ((endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24))
				/ queryModel.getStatFrequency();
		if (diff <= 0 && queryModel.getStatFrequency() > StatFrequencyEnum.DAY.value()) {// 不足一周或一个月，不进行统计，
																						// 直接返回
			return Collections.emptyList();
		}
		List<TrendQueryModel> trendList = new ArrayList<>();
		Calendar c = Calendar.getInstance();
		c.setTime(startDate);
		for (int i = 0; i <= diff; i++) {
			TrendQueryModel trend = new TrendQueryModel();
			trend.startDate(c.getTime()).citycode(queryModel.getCityCode());
			c.set(Calendar.DATE, c.get(Calendar.DATE) + queryModel.getStatFrequency() - 1);
			c.set(Calendar.HOUR_OF_DAY, 23);
			c.set(Calendar.MINUTE, 59);
			c.set(Calendar.SECOND, 59);
			trend.endDate(c.getTime());
			c.set(Calendar.DATE, c.get(Calendar.DATE) + 1);
			c.set(Calendar.HOUR_OF_DAY, 0);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.SECOND, 0);
			trendList.add(trend);
		}
		return trendList;
	}

	/**
	 * 获取城市map， key: cityCode, value: cityName
	 * 
	 * @auther yangyang
	 * @return
	 */
	private Map<String, String> cityMap() {
		List<Cities> cities = serviceIpService.getCititesForMobile();
		Map<String, String> map = new HashMap<>();
		cities.forEach(city -> {
			map.put(city.getCitycode(), city.getCityname());
		});
		return map;
	}

	/**
	 * 用户统计
	 * 
	 * @auther yangyang
	 * @param cities
	 *            key: citycode value: cityname
	 * @return
	 */
	private UserStatistics dayStat(Map<String, String> cities) {
		// 分别获取到前天、昨天和今天的日统计信息
		List<Statistics> theDayBeforeYesterday = dayStatistics(cities, -2);
		List<Statistics> yesterday = dayStatistics(cities, -1);
		List<Statistics> today = dayStatistics(cities, 0);
		// 排序，并且处理升降序
		orderStat(theDayBeforeYesterday, yesterday, today);
		// 获取当天统计总数
		Statistics todayAllCities = dayAllCitiesStat(today);
		Statistics yesterdayAllCities = dayAllCitiesStat(yesterday);
		// 封装最后的对象
		UserStatistics userStat = new UserStatistics().todayAllCities(todayAllCities).todayEachCity(today)
				.yesterdayAllCities(yesterdayAllCities).yesterdayEachCity(yesterday);
		return userStat;
	}

	/**
	 * 排序，并且处理 升序或降序
	 * 
	 * @auther yangyang
	 * @param theDayBeforeYesterday
	 * @param yesterday
	 * @param today
	 */
	private void orderStat(List<Statistics> theDayBeforeYesterday, List<Statistics> yesterday, List<Statistics> today) {
		// 按新增用户降序排序
		theDayBeforeYesterday = sortByNewUsersDesc(theDayBeforeYesterday);
		yesterday = sortByNewUsersDesc(yesterday);
		today = sortByNewUsersDesc(today);
		// 映射成map，key为cityCode，value为当前城市统计信息
		Map<String, Statistics> tdby = mapStatistics(theDayBeforeYesterday);
		Map<String, Statistics> ytd = mapStatistics(yesterday);
		// 处理升降序
		today = upOrDown(today, ytd);
		yesterday = upOrDown(yesterday, tdby);
	}

	/**
	 * 处理升序降序
	 * 
	 * @auther yangyang
	 * @param day
	 * @param beforeDay
	 * @return
	 */
	private List<Statistics> upOrDown(List<Statistics> day, Map<String, Statistics> beforeDay) {
		day.forEach(today -> {
			Statistics before = beforeDay.get(today.getCitycode());
			if (before != null) {
				today.setUpordown(before.getOrder() - today.getOrder());
			}
		});
		return day;
	}

	/**
	 * 将List改成HashMap， Key: cityCode, Value: Statistics
	 * 
	 * @auther yangyang
	 * @param list
	 * @return
	 */
	private Map<String, Statistics> mapStatistics(List<Statistics> list) {
		Map<String, Statistics> map = new HashMap<>();
		list.forEach(e -> {
			map.put(e.getCitycode(), e);
		});
		return map;
	}

	/**
	 * 按照新增用户排序，并且设置好序号
	 * 
	 * @auther yangyang
	 * @param list
	 * @return
	 */
	private List<Statistics> sortByNewUsersDesc(List<Statistics> list) {
		list.sort((first, second) -> {
			return second.getNewusers() - first.getNewusers();
		});
		int order = 0;
		for (Statistics s : list) {
			s.order(++order);
		}
		return list;
	}

	/**
	 * 获取某天所有城市的用户统计信息
	 * 
	 * @auther yangyang
	 * @return
	 */
	private Statistics dayAllCitiesStat(List<Statistics> stat) {
		Statistics statistics = new Statistics();
		if (stat != null && stat.size() > 0) {
			statistics.citycode(stat.get(0).getCitycode()).cityname(stat.get(0).getCityname());
		}
		stat.forEach(s -> {
			statistics.activeusers(statistics.getActiveusers() + s.getActiveusers())
					.newusers(statistics.getNewusers() + s.getNewusers())
					.totalusers(statistics.getTotalusers() + s.getTotalusers())
					.starttimes(statistics.getStarttimes() + s.getStarttimes());
		});
		return statistics;
	}

	/**
	 * 获取某天的统计信息
	 * 
	 * @auther yangyang
	 * @param cities
	 * @param compareToday
	 * @return
	 */
	private List<Statistics> dayStatistics(Map<String, String> cities, int compareToday) {
		// 查出昨日各城市新增用户数量
		List<AggregationGroup> dayNewUsers = processCityCode(dayNewUsers(compareToday), cities);
		// 查出昨日各城市累计用户数量
		List<AggregationGroup> dayTotalUsers = processCityCode(dayTotalUsers(compareToday), cities);
		// 查出昨日各城市所有启动次数
		List<AggregationGroup> dayStartTimes = processCityCode(dayStartTimes(compareToday), cities);
		// 查出昨日个城市活跃用户数量
		Map<String, Integer> dayActiveUsers = dayActiveUsers(compareToday, cities);

		Map<String, Statistics> map = new HashMap<>();
		// 处理新增用户
		dayNewUsers.forEach(newUser -> {
			Statistics stat = new Statistics().newusers(newUser.getCount()).citycode(newUser.getCitycode())
					.cityname(cities.get(newUser.getCitycode()));
			map.put(newUser.getCitycode(), stat);
		});
		// 处理用户总数
		dayTotalUsers.forEach(totalUsers -> {
			Statistics stat = map.get(totalUsers.getCitycode());
			if (stat == null) {
				stat = new Statistics().newusers(0).totalusers(totalUsers.getCount()).citycode(totalUsers.getCitycode())
						.cityname(cities.get(totalUsers.getCitycode()));
				map.put(totalUsers.getCitycode(), stat);
			} else {
				stat.totalusers(totalUsers.getCount());
			}
		});
		// 处理启动次数
		dayStartTimes.forEach(startTimes -> {
			Statistics stat = map.get(startTimes.getCitycode());
			if (stat == null) {
				stat = new Statistics().newusers(0).totalusers(0).starttimes(startTimes.getCount())
						.citycode(startTimes.getCitycode()).cityname(cities.get(startTimes.getCitycode()));
				map.put(startTimes.getCitycode(), stat);
			} else {
				stat.starttimes(startTimes.getCount());
			}
		});
		// 处理活跃用户数量
		dayActiveUsers.forEach((key, value) -> {
			Statistics stat = map.get(key);
			if (stat == null) {
				stat = new Statistics().newusers(0).totalusers(0).starttimes(0).activeusers(value).citycode(key)
						.cityname(cities.get(key));
				map.put(key, stat);
			} else {
				stat.activeusers(value);
			}
		});

		cities.forEach((key, value) -> {
			if (map.get(key) == null) {
				map.put(key, new Statistics().newusers(0).totalusers(0).starttimes(0).activeusers(0).citycode(key)
						.cityname(value));
			}
		});
		List<Statistics> list = new ArrayList<>();
		list.addAll(map.values());
		return list;
	}

	/**
	 * 处理城市编码，从4位改为6位
	 * 
	 * @auther yangyang
	 * @param list
	 * @return
	 */
	private List<AggregationGroup> processCityCode(List<AggregationGroup> list, Map<String, String> cities) {
		if (!StringUtils.isEmpty(list)) {
			list.forEach(l -> {
				String incompleteCityCode = l.getCitycode();
				if (cities.get(incompleteCityCode.concat("00")) != null) { // 补0后能获取到citycode
					l.setCitycode(incompleteCityCode.concat("00"));
				} else if(cities.get(incompleteCityCode) != null){
					l.setCitycode(incompleteCityCode);
				} else {
					cities.forEach((k, v) -> { // 补0后获取不到，只能遍历
						if (k.startsWith(incompleteCityCode)) {
							l.setCitycode(k);
						}
					});
				}
			});
			return list;
		}
		return Collections.emptyList();
	}
	
	/**
	 * 处理单个不完整的cityCode
	 * @auther yangyang
	 * @param incompleteCityCode
	 * @param cities
	 * @return
	 */
	private String processCityCode(String incompleteCityCode, Map<String, String> cities) {
		if (cities.get(incompleteCityCode.concat("00")) != null) { // 补0后能获取到citycode
			return incompleteCityCode.concat("00");
		} else if(cities.get(incompleteCityCode) != null) {
			return incompleteCityCode;
		} else {
			for (Map.Entry<String, String> entry : cities.entrySet()) {
				if(entry.getKey().startsWith(incompleteCityCode)) {
					return entry.getKey();
				}
			}
		}
		return incompleteCityCode;
	}

	/**
	 * 分城市统计新增用户
	 * 
	 * @auther yangyang
	 * @param compareToday
	 * @return
	 */
	private List<AggregationGroup> dayNewUsers(int compareToday) {
		String[] dates = startAndEndTime(compareToday);
		Aggregation agg = Aggregation.newAggregation(
				Aggregation.match(Criteria.where("firststarttime").gte(Tools.processStrToDate(dates[0]))
						.lte(Tools.processStrToDate(dates[1]))),
				Aggregation.project("citycode").andExpression("substr(citycode,0,4)").as("citycode"),
				Aggregation.group("citycode").count().as("count"));
		AggregationResults<UserStartAppInfo> results = mt.aggregate(agg, SysGlobalConstants.USER_START_APP,
				UserStartAppInfo.class);
		return JSONObject.parseArray(results.getRawResults().get("result").toString().replaceAll("_id", "cityCode"),
				AggregationGroup.class);

	}

	/**
	 * 分城市统计活跃人数
	 * 
	 * @auther yangyang
	 * @param cityCode
	 * @param compareToday
	 * @return
	 */
	private Map<String, Integer> dayActiveUsers(int compareToday, Map<String, String> cities) {
		String[] dates = startAndEndTime(compareToday);
		List<StartAppInfo> startList = mt.find(new Query(Criteria.where("currenttime")
				.gte(Tools.processStrToDate(dates[0])).lte(Tools.processStrToDate(dates[1]))), StartAppInfo.class,
				CMDEnum.START.tableName());
		Map<String, Integer> map = new HashMap<>();
		// key: cityCode, value: phoneModel的set集合
		Map<String, Set<String>> startMap = new HashMap<>();
		startList.forEach(start -> {
			if (StringUtils.isEmpty(start.getPhonemodel())) {
				return;
			}
			//处理城市编码
			start.setCitycode(processCityCode(start.getCitycode(), cities));
			Set<String> cityPhoneSet = startMap.get(start.getCitycode());
			if (StringUtils.isEmpty(cityPhoneSet)) {
				cityPhoneSet = new HashSet<>();
				cityPhoneSet.add(start.getPhonemodel());
				startMap.put(start.getCitycode(), cityPhoneSet);
			} else {
				cityPhoneSet.add(start.getPhonemodel());
			}
		});

		startMap.forEach((k, v) -> {
			map.put(k, v.size());
		});
		return map;
	}

	/**
	 * 分城市统计用户总数
	 * 
	 * @auther yangyang
	 * @param compareToday
	 * @return
	 */
	private List<AggregationGroup> dayTotalUsers(int compareToday) {
		String[] dates = startAndEndTime(compareToday);
		Aggregation agg = Aggregation.newAggregation(
				Aggregation.match(Criteria.where("firststarttime").lte(Tools.processStrToDate(dates[1]))),
				Aggregation.project("citycode").andExpression("substr(citycode,0,4)").as("citycode"),
				Aggregation.group("citycode").count().as("count"));
		AggregationResults<UserStartAppInfo> results = mt.aggregate(agg, SysGlobalConstants.USER_START_APP,
				UserStartAppInfo.class);
		return JSONObject.parseArray(results.getRawResults().get("result").toString().replaceAll("_id", "cityCode"),
				AggregationGroup.class);
	}

	/**
	 * 分城市统计启动次数
	 * 
	 * @auther yangyang
	 * @param compareToday
	 * @return
	 */
	private List<AggregationGroup> dayStartTimes(int compareToday) {
		String[] dates = startAndEndTime(compareToday);
		Aggregation agg = Aggregation.newAggregation(
				Aggregation.match(Criteria.where("currenttime").gte(Tools.processStrToDate(dates[0]))
						.lte(Tools.processStrToDate(dates[1]))),
				Aggregation.project("citycode").andExpression("substr(citycode,0,4)").as("citycode"),
				Aggregation.group("citycode").count().as("count"));
		AggregationResults<StartAppInfo> results = mt.aggregate(agg, CMDEnum.START.tableName(), StartAppInfo.class);
		return JSONObject.parseArray(results.getRawResults().get("result").toString().replaceAll("_id", "cityCode"),
				AggregationGroup.class);
	}

	/**
	 * 获取一天的初始和结束时间
	 * 
	 * @param compareToday
	 *            与今天相比的天数，今天：0， 昨天：-1， 前天：-2
	 * @auther yangyang
	 * @return
	 */
	private String[] startAndEndTime(int compareToday) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, c.get(Calendar.DATE) + compareToday);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		StringBuilder sb = new StringBuilder();
		sb.append(year).append("-").append(month).append("-").append(day);
		return new String[] { sb.toString().concat(" 00:00:00"), sb.toString().concat(" 23:59:59"), sb.toString() };
	}

	/**
	 * 返回是否是工作日
	 * 
	 * @auther yangyang
	 * @param date
	 * @return true：是工作日，false：weekend
	 */
	private boolean isWorkDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		return dayOfWeek != 1 && dayOfWeek != 7;
	}

	@Override
	public BaseDAO<Statistics, StatisticsQueryModel> getDao() {
		return null;
	}

	
	
}
