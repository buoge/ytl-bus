package com.lantaiyuan.ebus.custom.dao.neighbouringtour;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.custom.model.neighbouringtour.TouristSettings;
import com.lantaiyuan.ebus.custom.model.neighbouringtour.TouristSettingsQueryModel;

/***
 * 
* <p>Title: TouristSettingsMapper</p>
* <p>Description: 周边游常用旅客Dao接口</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年7月17日 下午4:31:36
 */
public interface TouristSettingsMapper extends BaseDAO<TouristSettings, TouristSettingsQueryModel>{
	List<TouristSettings> selectByUserIdAndCityCode(@Param("userId") Integer userId, @Param("cityCode") String cityCode);

	List<TouristSettings> queryTouristList(Map<String, Object> params);
}