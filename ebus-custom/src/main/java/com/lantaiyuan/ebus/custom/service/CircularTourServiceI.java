/**
* <p>Title: AddressManageServiceI.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.custom.service;

import org.lanqiao.ssm.common.core.service.BaseServiceI;
import org.lanqiao.ssm.common.page.Page;

import com.lantaiyuan.ebus.custom.model.CircularTour;
import com.lantaiyuan.ebus.custom.model.CircularTourQueryModel;

/**
* <p>Title: AddressManageServiceI</p>
* <p>Description: 周边游业务接口</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年6月8日 下午3:15:52
*/
public interface CircularTourServiceI extends BaseServiceI<CircularTour, CircularTourQueryModel>{
	boolean save(CircularTour circularTour);
	boolean update(CircularTour circularTour);
	
	boolean delete(String id, String cityCode);
	
	CircularTour findEntityById(String id, String cityCode);
	
	Page<CircularTour> findEntityByPage(CircularTourQueryModel model, int page);
}
