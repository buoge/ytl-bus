package com.lantaiyuan.ebus.custom.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;
import com.lantaiyuan.ebus.custom.model.acquisition.CustomLineStartEndSearch;
import com.lantaiyuan.ebus.custom.model.acquisition.EBoardSearch;
import com.lantaiyuan.ebus.custom.model.acquisition.EvaluationInfo;
import com.lantaiyuan.ebus.custom.model.acquisition.FavoriateAddSearch;
import com.lantaiyuan.ebus.custom.model.acquisition.FindAuthority;
import com.lantaiyuan.ebus.custom.model.acquisition.InstallAppInfo;
import com.lantaiyuan.ebus.custom.model.acquisition.LoginInfo;
import com.lantaiyuan.ebus.custom.model.acquisition.NearStationCollection;
import com.lantaiyuan.ebus.custom.model.acquisition.RouteDetail;
import com.lantaiyuan.ebus.custom.model.acquisition.StartAppInfo;
import com.lantaiyuan.ebus.custom.model.acquisition.Transfer;
import com.lantaiyuan.ebus.custom.model.acquisition.UserPosTenSInterval;
import com.lantaiyuan.ebus.custom.model.acquisition.UserStartAppInfo;
import com.lantaiyuan.ebus.custom.model.acquisition.base.BaseModel;
import com.lantaiyuan.ebus.custom.model.enummodel.CMDEnum;
import com.lantaiyuan.ebus.custom.service.DataCollectServiceI;
/**
 * 
* @Title: DataCollectServiceImpl.java 
* @Package com.lantaiyuan.ebus.custom.service.impl 
* @Description: 数据采集业务类 
* @author 刘伟  15818570028@163.com   
* @date 2017年2月15日 下午6:04:02 
* @version V1.0
 */
@Service("dataCollectService")
public class DataCollectServiceImpl implements DataCollectServiceI {

	@Autowired
	private MongoTemplate mt;

	public void save(BaseModel o,String tableName ) {
		o.setCurrenttime(new Date());
		mt.insert(o,tableName);
	}
	@Async("dcExecutor")
	public void handleDataCollection(CMDEnum cmdEnum, String json) {
		switch (cmdEnum) {
		case ROUTE_DETAIL:
			RouteDetail routeDetail = JSON.parseObject(json, RouteDetail.class);
			save(routeDetail, cmdEnum.tableName());
			break;
		case TRANSFER:
			Transfer transfer = JSON.parseObject(json, Transfer.class);
			save(transfer, cmdEnum.tableName());
			break;
		case FIND_MODEL:
			FindAuthority findAuthority = JSON.parseObject(json, FindAuthority.class);
			save(findAuthority, cmdEnum.tableName());
			break;
		case INSTALL:
			InstallAppInfo installAppInfo = JSON.parseObject(json, InstallAppInfo.class);
			save(installAppInfo, cmdEnum.tableName());
			break;
		case START:
			StartAppInfo startAppInfo = JSON.parseObject(json, StartAppInfo.class);
			save(startAppInfo, cmdEnum.tableName());
			// 记录用户初次启动app时间
			handleUserInfo(startAppInfo);
			break;
		case STATION_EVALUTION:
		case BUS_EVALUTION:
			EvaluationInfo evaluationInfo = JSON.parseObject(json, EvaluationInfo.class);
			save(evaluationInfo, cmdEnum.tableName());
			break;
		case LOGIN:
			LoginInfo loginInfo = JSON.parseObject(json, LoginInfo.class);
			save(loginInfo, cmdEnum.tableName());
			break;
		case EBOARD_SEARCH:
			EBoardSearch eBoardSearch = JSON.parseObject(json, EBoardSearch.class);
			save(eBoardSearch, cmdEnum.tableName());
			break;
		case FAVORIATE_ADD:
			FavoriateAddSearch favoriateAddSearch = JSON.parseObject(json, FavoriateAddSearch.class);
			save(favoriateAddSearch, cmdEnum.tableName());
			break;
		case INTERVAL_PER10S:
			UserPosTenSInterval userPosTenSInterval = JSON.parseObject(json, UserPosTenSInterval.class);
			save(userPosTenSInterval, cmdEnum.tableName());
			break;
		case NEAR_STATION:
		    	NearStationCollection nearStation = JSON.parseObject(json, NearStationCollection.class);
 			save(nearStation, cmdEnum.tableName());
			break;
		case NEAR_STATION_MAP_VIEW:
		    	NearStationCollection nearStation4MapView = JSON.parseObject(json, NearStationCollection.class);
			save(nearStation4MapView, cmdEnum.tableName());
			break;
		case NEAR_STATION_WALKING_NAVIGATION:
		    	NearStationCollection nearStation4WalkingNavigation = JSON.parseObject(json, NearStationCollection.class);
			save(nearStation4WalkingNavigation, cmdEnum.tableName());
			break;
		case CUSTOMLINE_STARTEND_SEARCH:
		    	CustomLineStartEndSearch customLineStartEnd = JSON.parseObject(json, CustomLineStartEndSearch.class);
			save(customLineStartEnd, cmdEnum.tableName());
			break;
		default:
			break;
		}
	}
	
	/**
	 * 记录用户初次启动app时间
	 * @auther yangyang
	 * @param info
	 */
	private void handleUserInfo(StartAppInfo info) {
		Query query = new Query(Criteria.where("phonemodel").is(info.getPhonemodel()));
		long userStart = mt.count(query,SysGlobalConstants.USER_START_APP);
		if(userStart == 0) {// 用户首次启动, 加入初次启动时间
			UserStartAppInfo ufs = new UserStartAppInfo(info);
			mt.insert(ufs, SysGlobalConstants.USER_START_APP);
		}
	}

}
