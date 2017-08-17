package com.lantaiyuan.ebus.custom.service.impl;

import com.lantaiyuan.ebus.carpool.model.CarpoolRoute;
import com.lantaiyuan.ebus.carpool.model.CarpoolRouteQueryModel;
import com.lantaiyuan.ebus.carpool.model.CarpoolRouteStation;
import com.lantaiyuan.ebus.common.util.DistanceUtil;
import com.lantaiyuan.ebus.custom.dao.CarpoolRouteMapper;
import com.lantaiyuan.ebus.custom.model.carpool.CarpoolRouteDetail;
import com.lantaiyuan.ebus.custom.model.carpool.StationToUserDistance;
import com.lantaiyuan.ebus.custom.service.CarpoolRouteServiceI;
import com.lantaiyuan.ebus.realtime.model.Path;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 拼车生成的线路
 * 
 * @author yangyang
 * @date 2017年6月14日 下午2:49:39
 */
@Service("carpoolRouteService")
public class CarpoolRouteServiceImpl extends BaseService<CarpoolRoute, CarpoolRouteQueryModel>
		implements CarpoolRouteServiceI {

	@Resource
	private CarpoolRouteMapper carpoolRouteMapper;

	@Override
	public BaseDAO<CarpoolRoute, CarpoolRouteQueryModel> getDao() {
		return carpoolRouteMapper;
	}

	/**
	 * 查看线路详情
	 * 
	 * @author yangyang
	 * @param carpoolRouteId
	 * @param userLon
	 * @param userLat
	 * @return
	 */
	@Override
	public CarpoolRouteDetail carpoolRouteDetail(String carpoolRouteId, double userLon, double userLat) {
		CarpoolRouteDetail carpoolRouteDetail = carpoolRouteMapper.selectRouteDetailByCarpoolRouteId(carpoolRouteId);
		if (StringUtils.isEmpty(carpoolRouteDetail)) {
			carpoolRouteDetail = new CarpoolRouteDetail();
			carpoolRouteDetail.setRelRouteStation(Collections.emptyList());
		}
		
		// 处理辅助站点
		List<Path> pathLine = new ArrayList<>();
		if (!StringUtils.isEmpty(carpoolRouteDetail.getStationMap())) {
			String[] stationMapArray = carpoolRouteDetail.getStationMap().split("\\|");
			for (String string : stationMapArray) {
				String[] pathPoint = string.split(",");
				pathLine.add(new Path(Double.valueOf(pathPoint[0]), Double.valueOf(pathPoint[1])));
			}
		}
		carpoolRouteDetail.setAssistStations(pathLine);

		// 计算用户距离线路上每个站点的距离
		List<StationToUserDistance> stationToUserDistances = new ArrayList<>();
		carpoolRouteDetail.getRelRouteStation().forEach(routeStation -> {
			stationToUserDistances.add(new StationToUserDistance(routeStation, DistanceUtil.countDistance(userLon,
					userLat, routeStation.getStationLon().doubleValue(), routeStation.getStationLat().doubleValue())));
		});
		// 按距离从小到大排序
		stationToUserDistances.sort(Comparator.comparing(StationToUserDistance::getUserDistance));
		
		// 用户最近站点
		if (!CollectionUtils.isEmpty(stationToUserDistances)) {
			carpoolRouteDetail.setCurrentStation(stationToUserDistances.get(0).getRelRouteStation());
		}
		// 如果没有最近站点，就初始化一个
		if (StringUtils.isEmpty(carpoolRouteDetail.getCurrentStation())) {
			carpoolRouteDetail.setCurrentStation(new CarpoolRouteStation());
		}

		return carpoolRouteDetail;
	}

}
