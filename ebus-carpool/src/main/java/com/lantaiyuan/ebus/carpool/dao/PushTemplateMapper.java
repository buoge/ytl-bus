package com.lantaiyuan.ebus.carpool.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.carpool.model.jpush.PushTemplate;
import com.lantaiyuan.ebus.carpool.model.jpush.PushTemplateQueryModel;

@Mapper
public interface PushTemplateMapper extends BaseDAO<PushTemplate,PushTemplateQueryModel>{
	
	PushTemplate getPushTemplateById(@Param("id") Integer id);

}