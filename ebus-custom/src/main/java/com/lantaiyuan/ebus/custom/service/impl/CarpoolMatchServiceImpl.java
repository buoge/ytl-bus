package com.lantaiyuan.ebus.custom.service.impl;

import com.lantaiyuan.ebus.carpool.model.CarpoolMatch;
import com.lantaiyuan.ebus.carpool.model.CarpoolMatchQueryModel;
import com.lantaiyuan.ebus.carpool.model.CarpoolRouteStation;
import com.lantaiyuan.ebus.custom.dao.CarpoolMatchMapper;
import com.lantaiyuan.ebus.custom.dao.CarpoolRouteStationMapper;
import com.lantaiyuan.ebus.custom.model.carpool.CarpoolMatchAndRouteResultModel;
import com.lantaiyuan.ebus.custom.service.CarpoolMatchServiceI;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

/**
 * 动态撮合
 * @author yangyang
 * @date 2017年6月13日 下午3:21:21 
 *
 */
@Service("carpoolMatchService")
public class CarpoolMatchServiceImpl extends BaseService<CarpoolMatch, CarpoolMatchQueryModel>
		implements CarpoolMatchServiceI {

	@Resource
	private CarpoolMatchMapper carpoolMatchMapper;
	
	@Resource
	private CarpoolRouteStationMapper carpoolRouteStationMapper;

	@Override
	public BaseDAO<CarpoolMatch, CarpoolMatchQueryModel> getDao() {
		return carpoolMatchMapper;
	}
	

	/**
	 * 根据撮合id找出该撮合的最新动态 
	 * @param matchId
	 * @return
	 */
	@Override
	public CarpoolMatch selectByMatchId(String matchId) {
		return carpoolMatchMapper.selectByMatchId(matchId);
	}

	/**
	 * 功能描述:根据当前位置获取经过该位置的拼车信息
	 * 作者:温海金
	 * 最后更改时间 : 2017年7月18日 下午4:17:55
	 */
	@Override
	public List<CarpoolMatchAndRouteResultModel> findCarpoolRoutesByCurrentPlace(BigDecimal startlongitude, BigDecimal startlatitude, String citycode) {
		return carpoolMatchMapper.findCarpoolRoutesByCurrentPlace(startlongitude, startlatitude, citycode);
	}


	@Override
	public CarpoolRouteStation findStartOrEndStation(String carpoolRouteId, Byte stationType) {
		return carpoolRouteStationMapper.findStartOrEndStation(carpoolRouteId, stationType);
	}

}
