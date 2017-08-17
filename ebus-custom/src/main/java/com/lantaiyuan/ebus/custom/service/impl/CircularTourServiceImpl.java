/**
* <p>Title: CircularTourService.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.custom.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.lanqiao.ssm.common.page.Page;
import org.springframework.stereotype.Service;

import com.lantaiyuan.ebus.custom.dao.CircularTourMapper;
import com.lantaiyuan.ebus.custom.model.CircularTour;
import com.lantaiyuan.ebus.custom.model.CircularTourQueryModel;
import com.lantaiyuan.ebus.custom.service.CircularTourServiceI;

/**
* <p>Title: CircularTourService</p>
* <p>Description: 周边游业务实现类</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年6月12日 下午3:28:11
*/
@Service("circularTourService")
public class CircularTourServiceImpl extends BaseService<CircularTour, CircularTourQueryModel> implements CircularTourServiceI {
	@Resource
	private CircularTourMapper circularTourMapper;
	
	/***
	* <p>Title: save</p>
	* <p>Description: 插入业务方法</p>
	* @param circularTour
	* @return
	*/
	@Override
	public boolean save(CircularTour circularTour) {
		return circularTourMapper.insertSelective(circularTour) > 0 ? true : false;
	}

	/***
	* <p>Title: update</p>
	* <p>Description: 更新业务方法</p>
	* @param circularTour
	* @return
	*/
	@Override
	public boolean update(CircularTour circularTour) {
		return circularTourMapper.updateByPrimaryKeySelective(circularTour) > 0 ? true : false;
	}

	/***
	* <p>Title: delete</p>
	* <p>Description: 删除业务方法</p>
	* @param id
	* @param cityCode
	* @return
	*/
	@Override
	public boolean delete(String id, String cityCode) {
		return circularTourMapper.deleteById(id, cityCode) > 0 ? true : false;
	}

	/***
	* <p>Title: findEntityById</p>
	* <p>Description: 查找单个业务方法</p>
	* @param id
	* @param cityCode
	* @return
	*/
	@Override
	public CircularTour findEntityById(String id, String cityCode) {
		return circularTourMapper.selectById(id, cityCode);
	}

	/***
	* <p>Title: findEntityByPage</p>
	* <p>Description: 分页查找业务方法</p>
	* @param page
	* @param cityCode
	* @return
	*/
	@Override
	public Page<CircularTour> findEntityByPage(CircularTourQueryModel model, int page) {
		model.getPageModel().setNowPage(page);
		List<CircularTour> list = circularTourMapper.selectByPage(model);
		model.getPageModel().setRows(list);
		return model.getPageModel();
	}

	/***
	* <p>Title: getDao</p>
	* <p>Description: mapper对象具体化</p>
	* @return
	*/
	@Override
	public BaseDAO<CircularTour, CircularTourQueryModel> getDao() {
		return this.circularTourMapper;
	}
}
