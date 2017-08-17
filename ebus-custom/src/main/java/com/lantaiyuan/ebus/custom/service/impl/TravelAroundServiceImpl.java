package com.lantaiyuan.ebus.custom.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.lantaiyuan.ebus.custom.dao.BaseRouteMapper;
import com.lantaiyuan.ebus.custom.dao.travelaround.TravelAroundMapper;
import com.lantaiyuan.ebus.custom.model.TravelAroundRoute;
import com.lantaiyuan.ebus.custom.model.travelaround.TravelAround;
import com.lantaiyuan.ebus.custom.model.travelaround.TravelAroundDetail;
import com.lantaiyuan.ebus.custom.model.travelaround.TravelAroundQueryModel;
import com.lantaiyuan.ebus.custom.service.TravelAroundServiceI;

/**
 * 
 * @ClassName: TravelAroundServiceImpl 
 * Company:深圳市蓝泰源信息技术股份有限公司
 * @author Yuan.Tan
 * @date 2017年7月18日 下午8:52:48
 */
@Service("travelAroundService")
public class TravelAroundServiceImpl extends BaseService<TravelAround, TravelAroundQueryModel>
		implements TravelAroundServiceI {
	@Resource
	private TravelAroundMapper travelAroundMapper;
	@Resource
	private BaseRouteMapper baseRouteMapper;
	
	private static Logger logger = LoggerFactory.getLogger(TravelAroundServiceImpl.class);

	@Override
	public BaseDAO<TravelAround, TravelAroundQueryModel> getDao() {
		return travelAroundMapper;
	}

	@Override
	public List<TravelAround> queryTravelList(String cityCode) {
		return travelAroundMapper.queryTravelList(cityCode);
	}

	@Override
	public TravelAroundDetail queryTravelDetail(String id) {
		//每次点击详情增加PV数
		travelAroundMapper.addPv(id);
		TravelAround travelAround = travelAroundMapper.selectByPrimaryKey(id);
		if (Objects.isNull(travelAround)) {
			return new TravelAroundDetail();
		}
		String cityCode = travelAround.getCityCode();
		String[] lineIdList = travelAround.getRelatedCustomline().split(",");
		//根据cityCode lineIdList 专线类型=2 查询该周边游下挂的专线信息
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("cityCode", cityCode);
		params.put("lineIdList", lineIdList);
		List<TravelAroundRoute> travelAroundRoutes= baseRouteMapper.queryCustomList(params);
		TravelAroundDetail travelAroundDetail = new TravelAroundDetail();
		BeanUtils.copyProperties(travelAround, travelAroundDetail);
		travelAroundDetail.setTravelAroundRouteList(travelAroundRoutes);
		return travelAroundDetail;
	}
}