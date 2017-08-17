package com.lantaiyuan.ebus.realtime.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lantaiyuan.ebus.realtime.dao.RelRouteAssistStationMapper;
import com.lantaiyuan.ebus.realtime.model.MapPath;
import com.lantaiyuan.ebus.realtime.model.Path;
import com.lantaiyuan.ebus.realtime.model.RelRouteAssistStation;
import com.lantaiyuan.ebus.realtime.model.RelRouteAssistStationQueryModel;
import com.lantaiyuan.ebus.realtime.service.RelRouteAssistStationServiceI;

/**
 * @Title: RelRouteAssistStationServiceImpl.java
 * @Package com.lantaiyuan.ebus.custom.service.impl
 * @Description:
 * @author yangyang
 * @date 2016年12月21日 下午4:20:15
 * @version v1.0
 */
@Service("relRouteAssistStationService")
public class RelRouteAssistStationServiceImpl extends
		BaseService<RelRouteAssistStation, RelRouteAssistStationQueryModel> implements RelRouteAssistStationServiceI {

	@Resource
	private RelRouteAssistStationMapper relRouteAssistStationMapper;

	@Override
	public BaseDAO<RelRouteAssistStation, RelRouteAssistStationQueryModel> getDao() {
		return relRouteAssistStationMapper;
	}

	@Override
	public MapPath getRelRouteAssitStation(String routeId, int direction, String cityCode) {
		RelRouteAssistStation assistStation = relRouteAssistStationMapper.getRelRouteAssitStation(routeId, direction, cityCode);
		return assistStation == null ? new MapPath(Collections.emptyList()) : GenerateMapPath(assistStation);
	}

	/**
	 * 从辅助站点生成mapPath
	 * @param assistStation
	 * @return
	 */
	private MapPath GenerateMapPath(RelRouteAssistStation assistStation) {
		MapPath mapPath = new MapPath();
		String stationMap = assistStation.getStationmap();
		if(!StringUtils.isEmpty(stationMap)){
			List<Path> pathList = new ArrayList<>();
			// 替换所有 "
			stationMap = stationMap.replaceAll("\"", "");
			// 去掉首尾 [[ ]]
			stationMap = stationMap.substring(2, stationMap.length() - 2);
			String[] strArray = stationMap.split("\\],\\[");
			for (String array: strArray) {
				String[] subArray = array.split(",");
				pathList.add(new Path(Double.valueOf(subArray[0]), Double.valueOf(subArray[1])));
			}
			mapPath.setPath(pathList);
			mapPath.setStartLatitude(assistStation.getStartlatitude() == null ? pathList.get(0).getLatitude() : assistStation.getStartlatitude().doubleValue());
			mapPath.setStartLongitude(assistStation.getStartlongitude() == null ? pathList.get(0).getLongitude() : assistStation.getStartlongitude().doubleValue());
			mapPath.setEndLatitude(assistStation.getEndlatitude() == null ? pathList.get(pathList.size()-1).getLatitude() : assistStation.getEndlatitude().doubleValue());
			mapPath.setEndLongitude(assistStation.getEndlongitude() == null ? pathList.get(pathList.size()-1).getLongitude() : assistStation.getEndlongitude().doubleValue());
		}
		return mapPath;
	}
	@Override
	public List<RelRouteAssistStation> getAllRelRouteStations() {
		return relRouteAssistStationMapper.getAllRelRouteStations();
	}
}
