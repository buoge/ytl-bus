package com.lantaiyuan.ebus.custom.dao;

import java.util.List;

import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.custom.model.BaseStation;
import com.lantaiyuan.ebus.custom.model.BaseStationQueryModel;
import com.lantaiyuan.ebus.custom.model.Bus;
import com.lantaiyuan.ebus.custom.model.StationRecord;
import com.lantaiyuan.ebus.custom.model.RouteStationRelationCollection;

/***
 * 
* <p>Title: AppCustomMapper</p>
* <p>Description: App自定义Mapper接口</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年3月31日 下午3:35:52
 */
public interface AppCustomMapper extends BaseDAO<BaseStation, BaseStationQueryModel>{

	List<RouteStationRelationCollection> getRouteStationRelationsByCitycode(String citycode);
	
	List<StationRecord> getRouteIdDirectionStationNoByCityCode(String citycode);
	
	List<StationRecord> getRouteIdDirectionStationNoAllCities();
	
	List<Bus> selectAllBus();
}