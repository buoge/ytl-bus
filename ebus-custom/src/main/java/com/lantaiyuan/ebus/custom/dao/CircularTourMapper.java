package com.lantaiyuan.ebus.custom.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.custom.model.CircularTour;
import com.lantaiyuan.ebus.custom.model.CircularTourQueryModel;

/***
 * 
* <p>Title: CircularTourMapper</p>
* <p>Description: 周边游dao接口</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年6月12日 下午3:14:35
 */
public interface CircularTourMapper extends BaseDAO<CircularTour, CircularTourQueryModel> {
	int deleteById(@Param("id") String id, @Param("cityCode") String cityCode);
	
	CircularTour selectById(@Param("id") String id, @Param("cityCode") String cityCode);
	
	List<CircularTour> selectByPage(CircularTourQueryModel model);
}