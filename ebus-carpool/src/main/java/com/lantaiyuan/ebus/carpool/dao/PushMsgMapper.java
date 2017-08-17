package com.lantaiyuan.ebus.carpool.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.carpool.model.jpush.PushMsg;
import com.lantaiyuan.ebus.carpool.model.jpush.PushMsgQueryModel;
import com.lantaiyuan.ebus.carpool.model.jpush.UserSimpleInfo;

@Mapper
public interface PushMsgMapper extends BaseDAO<PushMsg,PushMsgQueryModel>{
	/**
	 * 功能描述:根据用户ID查找极光注册ID
	 * 作者:温海金
	 * 最后更改时间 : 2017年7月14日 下午6:37:57
	 */
	String getRegIdByUserId(@Param("userId") Integer userId);
	/**
	 * 功能描述:根据用户ID查询用户的一些简单信息
	 * 作者:温海金
	 * 最后更改时间 : 2017年7月17日 下午1:40:31
	 */
	UserSimpleInfo getUserSimpleInfoByUserId(@Param("userId") Integer userId);
}