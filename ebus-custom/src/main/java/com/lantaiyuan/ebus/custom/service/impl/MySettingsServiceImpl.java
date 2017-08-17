/**
* <p>Title: MySettingsServiceImpl.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.custom.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.stereotype.Service;

import com.lantaiyuan.ebus.common.util.Tools;
import com.lantaiyuan.ebus.custom.dao.MyTrailMapper;
import com.lantaiyuan.ebus.custom.model.BaseRoute;
import com.lantaiyuan.ebus.custom.model.MyTrail;
import com.lantaiyuan.ebus.custom.model.MyTrailQueryModel;
import com.lantaiyuan.ebus.custom.model.MyTrailSchedule;
import com.lantaiyuan.ebus.custom.model.MyTrailVo;
import com.lantaiyuan.ebus.custom.model.enummodel.WeekEnum;
import com.lantaiyuan.ebus.custom.model.mytrail.BusInMyTrail;
import com.lantaiyuan.ebus.custom.model.mytrail.LinePath;
import com.lantaiyuan.ebus.custom.model.mytrail.MyTrailDetail;
import com.lantaiyuan.ebus.custom.model.mytrail.RouteInMyTrail;
import com.lantaiyuan.ebus.custom.model.mytrail.StationInMyTrail;
import com.lantaiyuan.ebus.custom.service.BaseRouteServiceI;
import com.lantaiyuan.ebus.custom.service.LinePathServiceI;
import com.lantaiyuan.ebus.custom.service.MySettingsServiceI;
import com.lantaiyuan.ebus.custom.service.RelRouteStationServiceI;

/**
* <p>Title: MySettingsServiceImpl</p>
* <p>Description:我的设置业务逻辑实现类 </p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年2月18日 下午5:27:59
*/
@Service("mySettingsService")
public class MySettingsServiceImpl extends BaseService<MyTrail, MyTrailQueryModel> implements MySettingsServiceI {
	@Resource
	private MyTrailMapper myTrailMapper;
	@Resource 
	private BaseRouteServiceI baseRouteService;
	@Resource 
	private RelRouteStationServiceI relRouteStationService;
	@Resource 
	private LinePathServiceI linePathService;
	/***
	* <p>Title: getDao</p>
	* <p>Description: </p>
	*/
	@Override
	public BaseDAO<MyTrail, MyTrailQueryModel> getDao() {
		return myTrailMapper;
	}

	/***
	* <p>Title: getMyTrailById</p>
	* <p>Description: 根据主键id获取MyTrail对象</p>
	*/
	@Override
	public MyTrail getMyTrailById(String id) {
		return myTrailMapper.selectByPrimaryKey(id);
	}
	/**
	 * 功能描述:为行程添加日期、星期、行程时间、开始时间格式化
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月5日 下午5:07:38
	 */
	private void handleMyTrailVo(MyTrailVo entity) {
		Date startTime = entity.getStartTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String startTimeStr = dateFormat.format(startTime);
		//1.加上日期
		if(startTimeStr.length()>10){
			String monthAndDay = startTimeStr.substring(5, 10);
			entity.setDate(monthAndDay);
		}
		//2.加上星期
		WeekEnum weekEnum = WeekEnum.valueOf(Tools.getDayForWeek(startTime));
		entity.setWeek(weekEnum.description());
		//3.加上行程时间（分）
		if(entity.getStartTime() != null && entity.getEndTime() != null) {
			long startTimeLong = entity.getStartTime().getTime();
			long endTimeLong = entity.getEndTime().getTime();
			long timeUnit = (Long.valueOf(endTimeLong)-Long.valueOf(startTimeLong))/ (1000 * 60);
			entity.setTimeUnit(Integer.valueOf(String.valueOf(timeUnit)));
		}
		//4.开始时间格式化
		SimpleDateFormat hourAndMin = new SimpleDateFormat("HH:mm");
		entity.setStartTimeVal(hourAndMin.format(startTime));
		
	}
	
	@Override
	public List<MyTrailSchedule> selectByUserId(Integer userId) {
		List<MyTrailVo> myTrailVos = myTrailMapper.selectByUserId(userId);
		Map<String,List<MyTrailVo>> myTrailMaps = new HashMap<>();
		myTrailVos.forEach(entity -> {
			//行程处理
			handleMyTrailVo(entity);
			//行程按日期分组
			groupByDate(myTrailMaps, entity);
		});
		//map转集合显示
		List<MyTrailSchedule> myTrailSchedules = new ArrayList<>();
		//将map转化为集合供前端展示
		covertToList(myTrailMaps, myTrailSchedules);
		return myTrailSchedules;
	}
	
	/**
	 * 功能描述:将map转化为list供前端展示
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月5日 下午6:40:54
	 */
	private void covertToList(Map<String, List<MyTrailVo>> myTrailMaps, List<MyTrailSchedule> myTrailSchedules) {
		Set<Entry<String, List<MyTrailVo>>> entrySet = myTrailMaps.entrySet();
		entrySet.forEach(map ->{
			MyTrailSchedule myTrailSchedule = new MyTrailSchedule();
			myTrailSchedule.setScheduleTime(map.getKey());
			myTrailSchedule.setSchedule(map.getValue());
			myTrailSchedules.add(myTrailSchedule);
		});
	}
	/**
	 * 功能描述:按日期分组处理
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月5日 下午6:39:40
	 */
	private void groupByDate(Map<String, List<MyTrailVo>> myTrailMaps, MyTrailVo entity) {
		String key = entity.getDate()+" "+entity.getWeek();
		if(myTrailMaps.containsKey(key)){
			List<MyTrailVo> myTrailEntitys = myTrailMaps.get(key);
			myTrailEntitys.add(entity);
		} else {
			List<MyTrailVo> myTrailEntitys = new ArrayList<>();
			myTrailEntitys.add(entity);
			myTrailMaps.put(key, myTrailEntitys);
		}
	}

	@Override
	public MyTrailDetail getMyTrailDetail(String entityId) {
		MyTrail myTrail = myTrailMapper.selectByPrimaryKey(entityId);
		//得到行程中的车辆信息
		BusInMyTrail busInMyTrail = new BusInMyTrail(myTrail.getVehicleId(), myTrail.getBusPlateNumber());
		//得到行程中的线路信息
		RouteInMyTrail routeInMyTrail = getRouteInMyTrail(myTrail);
		//TODO 得到行程中轨迹打点信息集合linePaths
		List<LinePath> linePaths = getLinePathInMyTrail(myTrail);
		//得到行程中经过的站点集
		List<StationInMyTrail> stationsInMyTrail = getStationsInMyTrail(myTrail);
		return new MyTrailDetail(busInMyTrail, routeInMyTrail, linePaths, stationsInMyTrail);
	}
	
	/**
	 * 功能描述:TODO 得到行程中的地图打点信息
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月25日 上午11:10:19
	 */
	private List<LinePath> getLinePathInMyTrail(MyTrail myTrail) {
		List<LinePath> linePaths = new ArrayList<>();
		LinePath linePath1 = new LinePath();
		linePath1.setMytrailid(myTrail.getId());
		linePath1.setUsepostime(new Date());
		linePath1.setLongitude(new BigDecimal(119.601611));
		linePath1.setLatitude(new BigDecimal(39.933833));
		LinePath linePath2 = new LinePath();
		linePath2.setMytrailid(myTrail.getId());
		linePath2.setUsepostime(new Date());
		linePath2.setLongitude(new BigDecimal(119.601713));
		linePath2.setLatitude(new BigDecimal(39.933935));
		linePaths.add(linePath1);
		linePaths.add(linePath2);
		linePaths = linePathService.getLinePathsByMyTrailId(myTrail.getId());
		return linePaths;
	}

	/**
	 * 功能描述:拼装行程中经过的站点信息
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月25日 上午10:45:14
	 */
	private List<StationInMyTrail> getStationsInMyTrail(MyTrail myTrail) {
		String routeId = myTrail.getRouteId();
		Integer startstationid = myTrail.getStartstationid();
		Integer endstationid = myTrail.getEndstationid();
		int startStationNo = relRouteStationService.getStationNo(routeId, startstationid, myTrail.getDirection(), myTrail.getCitycode());
		int endStationNo = relRouteStationService.getStationNo(routeId, endstationid, myTrail.getDirection(), myTrail.getCitycode());
		return relRouteStationService.getRelRouteStationBetweenTwoStations(routeId, myTrail.getDirection(), myTrail.getCitycode(), startStationNo, endStationNo);
	}

	/**
	 * 功能描述:拼装行程中的线路信息
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月24日 下午6:20:52
	 */
	private RouteInMyTrail getRouteInMyTrail(MyTrail myTrail) {
		BaseRoute routeInfo = baseRouteService.getRouteByIdAndDirection(myTrail.getCitycode(), myTrail.getRouteId(), myTrail.getDirection());
		String direction = "开往"+routeInfo.getEndstation();
		//TODO 计算两个时间点的时间差
		//long timeEnd = myTrail.getEndtime().getTime();
		//long timeStart = myTrail.getStarttime().getTime();
		//(myTrail.getEndtime().getTime() - myTrail.getStarttime().getTime()) / (1000 * 60);
		int time = 30;
		RouteInMyTrail routeInMyTrail = new RouteInMyTrail(myTrail.getRouteId(), direction, myTrail.getTrailDistance(), routeInfo.getRoutename(), myTrail.getStarttime(), myTrail.getEndtime(), time);
		return routeInMyTrail;
	}
	
}
