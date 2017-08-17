package com.lantaiyuan.ebus.custom.dao;

import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.custom.model.SysUser;
import com.lantaiyuan.ebus.custom.model.SysUserQueryModel;

/**
 * 系统用户mapper
 * @Title: SysUserMapper.java
 * @Package com.lantaiyuan.ebus.custom.dao
 * @Description:
 * @author yangyang
 * @date 2017年3月22日 上午10:34:52
 * @version v1.0
 */
public interface SysUserMapper extends BaseDAO<SysUser, SysUserQueryModel> {

	/**
	 * 用户登录
	 * @auther yangyang
	 * @param userName
	 * @return
	 */
	SysUser login(String userName);

}