package com.lantaiyuan.ebus.service.impl;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lantaiyuan.ebus.dao.MyTrailMapper;
import com.lantaiyuan.ebus.model.BaseStation;
import com.lantaiyuan.ebus.model.MyTrail;
import com.lantaiyuan.ebus.model.MyTrailQueryModel;
import com.lantaiyuan.ebus.model.ProduceDestPoint;
import com.lantaiyuan.ebus.model.ProduceOriginPoint;
import com.lantaiyuan.ebus.service.BaseStationServiceI;
import com.lantaiyuan.ebus.service.MyTrailServiceI;
import com.lantaiyuan.ebus.util.DistanceUtil;

/**
 * @author yangyang
 * @date 2017年4月20日 下午3:54:13
 */
@Service("myTrailService")
public class MyTrailServiceImpl extends BaseService<MyTrail, MyTrailQueryModel> implements MyTrailServiceI {
	@Resource
	private MyTrailMapper myTrailMapper;
	@Resource
	private BaseStationServiceI baseStationService;

	@Override
	public BaseDAO<MyTrail, MyTrailQueryModel> getDao() {
		return myTrailMapper;
	}

	/**
	 * 增加O点信息
	 */
	@Override
	public void insertOriginPoint(ProduceOriginPoint originPoint) {
		myTrailMapper.insertOriginPoint(originPoint);
	}

	/**
	 * 更新D点信息
	 */
	@Override
	public void updateDestPoint(ProduceDestPoint destPoint) {
		// 查出当前行程
		MyTrail myTrail = myTrailMapper.getCurrentTrail(destPoint.getUserId());
		
		MyTrail updateTrail = new MyTrail();
		updateTrail.setId(myTrail.getId()); // 设置行程id
		
		BaseStation endStation = baseStationService.getStationByStationIdAndCityCode(
				Integer.valueOf(destPoint.getEndStationId()), destPoint.getCityCode());
		
		double distance;
		if (StringUtils.isEmpty(myTrail.getTraildistance())) { // 首次计算trailDistance
			BaseStation startStation = baseStationService.getStationByStationIdAndCityCode(myTrail.getStartstationid(),
					myTrail.getCitycode());
			updateTrail.setStartlatitude(startStation.getLatitude());
			updateTrail.setStartlongitude(startStation.getLongitude());
			distance = DistanceUtil.countDistance(startStation.getLongitude().doubleValue(), startStation.getLatitude().doubleValue(),
					endStation.getLongitude().doubleValue(), endStation.getLatitude().doubleValue());
		} else { // 非首次计算
			// Dn-1 到 Dn的距离
			distance = DistanceUtil.countDistance(myTrail.getEndlongitude().doubleValue(), myTrail.getEndlatitude().doubleValue(), 
					endStation.getLongitude().doubleValue(), endStation.getLatitude().doubleValue());
			// O - Dn-1的距离 + Dn-1 到 Dn的距离
			distance += myTrail.getTraildistance();
		}
		updateTrail.setEndstationid(endStation.getStationid());
		updateTrail.setEndlongitude(endStation.getLongitude());
		updateTrail.setEndlatitude(endStation.getLatitude());
		updateTrail.setEndtime(destPoint.getEndTime());
		updateTrail.setTraildistance(distance);

		myTrailMapper.updateByPrimaryKey(updateTrail);
	}

}
