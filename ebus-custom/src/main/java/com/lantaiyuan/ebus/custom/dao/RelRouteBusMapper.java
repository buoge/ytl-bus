package com.lantaiyuan.ebus.custom.dao;

import java.util.List;

import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.custom.model.RelRouteBus;
import com.lantaiyuan.ebus.custom.model.RelRouteBusQueryModel;

/**
 * @Title: RelRouteBusMapper.java
 * @Package com.lantaiyuan.ebus.custom.dao
 * @Description:
 * @author yangyang
 * @date 2017年1月16日 上午9:49:23
 * @version v1.0
 */
public interface RelRouteBusMapper extends BaseDAO<RelRouteBus, RelRouteBusQueryModel> {
	
	/**
	 * 获取所有线车关系
	 * @auther yangyang
	 * @return
	 */
	List<RelRouteBus> getAllRelRouteBus();
	
}