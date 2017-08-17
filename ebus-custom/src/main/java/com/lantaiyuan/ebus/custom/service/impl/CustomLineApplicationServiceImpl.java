package com.lantaiyuan.ebus.custom.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.stereotype.Service;
import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;
import com.lantaiyuan.ebus.common.util.AngleUtil;
import com.lantaiyuan.ebus.common.util.DistanceUtil;
import com.lantaiyuan.ebus.custom.dao.CustomLineApplicationMapper;
import com.lantaiyuan.ebus.custom.dao.CustomLineCommentMapper;
import com.lantaiyuan.ebus.custom.model.CustomLineApplication;
import com.lantaiyuan.ebus.custom.model.CustomLineApplicationQueryModel;
import com.lantaiyuan.ebus.custom.model.CustomLineComment;
import com.lantaiyuan.ebus.custom.model.CustomLineSubList;
import com.lantaiyuan.ebus.custom.model.StationCount;
import com.lantaiyuan.ebus.custom.model.StationRelation;
import com.lantaiyuan.ebus.custom.model.TimePersonCount;
import com.lantaiyuan.ebus.custom.service.CustomLineApplicationServiceI;
import com.lantaiyuan.ebus.custom.service.CustomLineServiceI;
import com.lantaiyuan.ebus.realtime.model.enummodel.StationType;

@Service("customLineApplicationService")
public class CustomLineApplicationServiceImpl extends
		BaseService<CustomLineApplication, CustomLineApplicationQueryModel> implements CustomLineApplicationServiceI {
	@Resource
	private CustomLineApplicationMapper customLineApplicationMapper;
	@Resource
	private CustomLineCommentMapper customLineCommentMapper;
	@Resource
	private CustomLineServiceI customLineService;

	@Override
	public BaseDAO<CustomLineApplication, CustomLineApplicationQueryModel> getDao() {
		return customLineApplicationMapper;
	}

	@Override
	public List<CustomLineApplication> findByLineId(String lineid) {
		return customLineApplicationMapper.findByLineId(lineid);
	}
 
	@Override
	public int extraApply(CustomLineComment customLineComment) {
		return customLineCommentMapper.insertSelective(customLineComment);
	}

	@Override
	public int insertSelective(CustomLineApplication application) {
		int count = super.insertSelective(application);
		if (application != null && application.getLineid() != null) {
			customLineService.updateLineStatusIfCountFull(application.getLineid());// 加入之后的操作，详情咨询author:whj
		}
		return count;
	}

	/**
	 * 分页查询定制公交加入人 and 地图次数统计
	 * 
	 * @author yangyang
	 */
	@Override
	public CustomLineSubList findCustomLineSubListByPage(CustomLineApplicationQueryModel model, int page) {
		model.getPageModel().setNowPage(page);
		List<CustomLineApplication> list = customLineApplicationMapper.findCustomLineSubListByPage(model);
		model.getPageModel().setRows(list);
		List<CustomLineApplication> all = customLineApplicationMapper.findByLineId2(model.getLineid());
		return this.getCountStat(model, all);
	}

	/**
	 * 地图统计
	 * 
	 * @param lineId
	 * @return
	 * @author yangyang
	 */
	@Override
	public Collection<StationRelation> getMapCount(String lineId) {
		return this.getCountStatVer2(lineId);
	}

	/**
	 * 地图统计具体操作 version 2.0
	 * 
	 * @param model
	 * @param list
	 * @return
	 * @author yangyang
	 */
	private Collection<StationRelation> getCountStatVer2(String lineId) {
		List<String> strList = null;
		if (!StringUtils.isEmpty(lineId)) {
			strList = Arrays.asList(lineId.split(","));
		}
		List<CustomLineApplication> list = customLineApplicationMapper.getByLineId(lineId, strList);
		// 去重，新增站点
		list = this.dupilcateRemoval(list);
		Map<String, StationRelation> map = new HashMap<>();
		Map<String, Integer> startMap = new HashMap<>();
		Map<String, Integer> endMap = new HashMap<>();
		String key;
		StationRelation sr;
		StationCount start, end;
		List<TimePersonCount> tpc;
		boolean isTimeEquals = false;
		for (CustomLineApplication c : list) {
			key = c.getSourcelocation() + "-" + c.getTargetlocation();
			sr = map.get(key);
			if (sr == null) {// first
				start = StationCount.newInstance(c.getSourcelocation(), c.getStartlongitude(), c.getStartlatitude(), 0,
						0);
				start.setStart_count(1);
				startMap.put(c.getSourcelocation(), 1);
				end = StationCount.newInstance(c.getTargetlocation(), c.getEndlongitude(), c.getEndlatitude(), 0, 1);
				end.setEnd_count(1);
				endMap.put(c.getTargetlocation(), 1);
				tpc = new ArrayList<>();
				tpc.add(TimePersonCount.newInstance(c.getStarttime(), 1));
				map.put(key, StationRelation.newInstance(start, end, tpc));
			} else {// not first
				tpc = sr.getTime_person();
				isTimeEquals = false;
				// 起始次数增1
				sr.getStart().setStart_count(sr.getStart().getStart_count() + 1);
				// 终点次数增1
				sr.getEnd().setEnd_count(sr.getEnd().getEnd_count() + 1);
				for (TimePersonCount e : tpc) {
					if (c.getStarttime().equals(e.getTime())) {
						e.setCount(e.getCount() + 1);
						isTimeEquals = true;
						break;
					}
				}
				if (!isTimeEquals) {
					tpc.add(TimePersonCount.newInstance(c.getStarttime(), 1));
				}

			}
		}

		/** 合并同一站点的起始，终点次数 至 total_map */
		Map<String, StationCount> total_map = new HashMap<>();
		StationCount e;
		for (StationRelation s : map.values()) {
			e = total_map.get(s.getStart().getStationName());
			if (e == null) {// 起始站点在total_map中不存在
				// 看此起始站点是否也是终点，如果是终点，则设置其start_or_end为2
				if (endMap.get(s.getStart().getStationName()) != null) {
					s.getStart().setStart_or_end(2);
				}
				// 将此站点放入total_map
				total_map.put(s.getStart().getStationName(), s.getStart());
			} else {// 起始站点在total_map中已存在，将其起始次数（终点次数一定为0）与total_map中
					// 的站点合并
				e.setStart_count(e.getStart_count() + s.getStart().getStart_count());
			}
			// 处理终点，与处理起点的逻辑类似，不再赘述
			e = total_map.get(s.getEnd().getStationName());
			if (e == null) {
				if (startMap.get(s.getEnd().getStationName()) != null) {
					s.getEnd().setStart_or_end(2);
				}
				total_map.put(s.getEnd().getStationName(), s.getEnd());
			} else {
				e.setEnd_count(e.getEnd_count() + s.getEnd().getEnd_count());
			}
		}
		// 将所有站点替换为total_map中的站点
		for (StationRelation s : map.values()) {
			e = total_map.get(s.getStart().getStationName());
			s.setStart(e);
			e = total_map.get(s.getEnd().getStationName());
			s.setEnd(e);
			s.setAngle(AngleUtil.getAngle(s.getStart().getLan().doubleValue(), s.getStart().getLon().doubleValue(),
					s.getEnd().getLan().doubleValue(), s.getEnd().getLon().doubleValue()));
			tpc = s.getTime_person();
			Collections.sort(tpc, (a, b) -> {
				return a.getTime().compareTo(b.getTime());
			});
		}

		return map.values();
	}
	
	

	/**
	 * 去重，新增
	 * 
	 * @param list
	 * @return
	 * 
	 * @author yangyang
	 */
	private List<CustomLineApplication> dupilcateRemoval(List<CustomLineApplication> list) {
		/** key: stationName, value: station count */
		Map<String, Integer> duplicate_station = new HashMap<>();
		/** key: stationName, value: station detail */
		Map<String, StationCount> retain_station = new HashMap<>();
		List<CustomLineApplication> result = new ArrayList<CustomLineApplication>();
		for (CustomLineApplication c : list) {
			if(filterInvalidLonAndLat(c,null)){
				continue;
			}
			this.processStartAndEndStation(c, duplicate_station, retain_station, 0);
			this.processStartAndEndStation(c, duplicate_station, retain_station, 1);
			result.add(c);
		}
		return result;
	}

	/**
	 * 去重的具体操作
	 * 
	 * @param c
	 * @param duplicate_station
	 * @param retain_station
	 * @param start_or_end		
	 * @author yangyang
	 */
	private void processStartAndEndStation(CustomLineApplication c, Map<String, Integer> duplicate_station,
			Map<String, StationCount> retain_station, int start_or_end) {
		
		String stationName = (start_or_end == StationType.STRART.getType() ? c.getSourcelocation() : c.getTargetlocation());
		StationCount sc;
		BigDecimal lon = (start_or_end == StationType.STRART.getType() ? c.getStartlongitude() : c.getEndlongitude());
		BigDecimal lan = (start_or_end == StationType.STRART.getType() ? c.getStartlatitude() : c.getEndlatitude());
		Integer count = duplicate_station.get(stationName);
		double distance;
		boolean isSame = false;
		if (count == null) {// 首次出现
			duplicate_station.put(stationName, 1);
			retain_station.put(stationName, StationCount.newInstance(stationName, lon, lan, 0, start_or_end));
		} else {// 非首次
			for (int i = 1; i <= count; i++) {// 与之前出现的每一个同名站点比较距离
				sc = retain_station.get(i == 1 ? stationName : stationName + i);
				distance = DistanceUtil.countDistance(lon.doubleValue(), lan.doubleValue(), sc.getLon().doubleValue(),
						sc.getLan().doubleValue());
				if (distance < SysGlobalConstants.SAME_DISTANCE) {// 认为是同一站点
					if (start_or_end == 0) {
						c.setStartlatitude(sc.getLan());
						c.setStartlongitude(sc.getLon());
					} else {
						c.setEndlongitude(sc.getLon());
						c.setEndlatitude(sc.getLan());
					}
					isSame = true;
					break;
				}
			}
			if (!isSame) {
				count++;
				if (start_or_end == 0) {
					c.setSourcelocation(stationName + count);
				} else {
					c.setTargetlocation(stationName + count);
				}
				// 待确认是否还需再put一遍
				duplicate_station.put(stationName, count);
				retain_station.put(stationName + count,
						StationCount.newInstance(stationName + count, lon, lan, 0, start_or_end));
			}
		}
	}

	/**
	 * 地图统计具体操作 version 1.0
	 * 
	 * @param model
	 * @param list
	 * @return
	 * @author yangyang
	 */
	private CustomLineSubList getCountStat(CustomLineApplicationQueryModel model, List<CustomLineApplication> list) {
		String promoter = null;
		// **process 次数 start
		// 存放开始站点的map
		Map<String, StationCount> start = new HashMap<>();
		// 存放结束站点的map
		Map<String, StationCount> end = new HashMap<>();
		// 存放被过滤站点的list
		List<CustomLineApplication> filteredResult = new ArrayList<>();
		StationCount temp;
		for (CustomLineApplication app : list) {
			if(filterInvalidLonAndLat(app,filteredResult)){//被过滤，直接看下一条数据
				continue;
			}
			if (app.getFlag() == 0) {// 发起人
				promoter = app.getUsername();
			}
			temp = start.get(app.getSourcelocation());
			if (temp == null) {//起始站点首次出现，将其放入start站点的map中
				temp = StationCount.newInstance(app.getSourcelocation(), app.getStartlongitude(),
						app.getStartlatitude(), 1, 0);
				start.put(app.getSourcelocation(), temp);
			} else {//非首次出现，次数增加1
				temp.setCount(temp.getCount() + 1);
			}
			temp = end.get(app.getTargetlocation());
			if (temp == null) {//终止站点首次出现，将其放入end站点的map中
				temp = StationCount.newInstance(app.getTargetlocation(), app.getEndlongitude(), app.getEndlatitude(), 1,
						1);
				end.put(app.getTargetlocation(), temp);
			} else {//非首次出现，次数增加1
				temp.setCount(temp.getCount() + 1);
			}
		}
		List<StationCount> start_count = new ArrayList<>(start.values());
		Collections.sort(start_count, (a, b) -> {
			return b.getCount() - a.getCount();
		});
		List<StationCount> end_count = new ArrayList<>(end.values());
		Collections.sort(end_count, (a, b) -> {
			return b.getCount() - a.getCount();
		});
		// process 次数 end
		return new CustomLineSubList(promoter, start_count, end_count, model == null ? null : model.getPageModel(),
				filteredResult);
	}
	
	/**
	 * 过滤空的或者不在国内的站点
	 * @auther yangyang
	 * @param app
	 * @param filteredResult		
	 * 				如果需要记录被过滤的站点，就传递引用
	 * 				不需要记录，直接传递null
	 * @return
	 */
	private boolean filterInvalidLonAndLat(CustomLineApplication app, List<CustomLineApplication> filteredResult) {
		if (app.getStartlatitude() == null || app.getStartlongitude() == null || app.getEndlatitude() == null
				|| app.getEndlongitude() == null) {
			if(filteredResult!=null)
				filteredResult.add(app);
			return true;
		}
		if (app.getStartlatitude().floatValue() < SysGlobalConstants.CN_MIN_LAT 
				|| app.getStartlatitude().floatValue() > SysGlobalConstants.CN_MAX_LAT
				|| app.getStartlongitude().floatValue() > SysGlobalConstants.CN_MAX_LON 
				|| app.getStartlongitude().floatValue() < SysGlobalConstants.CN_MIN_LON
				|| app.getEndlatitude().floatValue() < SysGlobalConstants.CN_MIN_LAT 
				|| app.getEndlatitude().floatValue() > SysGlobalConstants.CN_MAX_LAT
				|| app.getEndlongitude().floatValue() > SysGlobalConstants.CN_MAX_LON
				|| app.getEndlongitude().floatValue() < SysGlobalConstants.CN_MIN_LON) {
			if(filteredResult!=null)
				filteredResult.add(app);
			return true;
		}
		return false;
	}

}
