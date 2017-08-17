/**
* <p>Title: NeighbouringTourServiceI.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.custom.service;

import java.util.List;

import org.lanqiao.ssm.common.core.service.BaseServiceI;
import org.lanqiao.ssm.common.page.Page;
import org.springframework.web.multipart.MultipartFile;

import com.lantaiyuan.ebus.custom.model.BaseRoute;
import com.lantaiyuan.ebus.custom.model.neighbouringtour.TouristSettings;
import com.lantaiyuan.ebus.custom.model.neighbouringtour.TouristSettingsQueryModel;
import com.lantaiyuan.ebus.custom.model.travelaround.TravelAround;
import com.lantaiyuan.ebus.custom.model.travelaround.TravelAroundQueryModel;

/**
* <p>Title: NeighbouringTourServiceI</p>
* <p>Description: 周边游常用旅客业务接口</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年7月17日 下午4:40:14
*/
public interface NeighbouringTourServiceI extends BaseServiceI<TouristSettings, TouristSettingsQueryModel>{
	List<TouristSettings> findEntitiesByUserIdAndCityCode(Integer userId, String cityCode);
	
	boolean saveOrUpdate(TouristSettings userAddressSetting);
	
	Page<TravelAround> findEntityByPage(TravelAroundQueryModel model, int page);
	
	TravelAround  findTravelAroundById(String id);
	
	boolean updateTravelAround(TravelAround travelAround);
	
	boolean addTravelAround(TravelAround travelAround);
	
	boolean delTravelById(String id);
	
	List<BaseRoute> findSpecialLinesByCityCode(String cityCode);
	
	String getFilesUploadedPath(MultipartFile[] files);
}
