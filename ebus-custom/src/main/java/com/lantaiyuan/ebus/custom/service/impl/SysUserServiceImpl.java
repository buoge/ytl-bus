package com.lantaiyuan.ebus.custom.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;
import com.lantaiyuan.ebus.custom.dao.SysUserMapper;
import com.lantaiyuan.ebus.custom.model.SysUser;
import com.lantaiyuan.ebus.custom.model.SysUserQueryModel;
import com.lantaiyuan.ebus.custom.model.enummodel.LoginResultEnum;
import com.lantaiyuan.ebus.custom.service.SysUserServiceI;

/**
 * @Title: SysUserServiceImpl.java
 * @Package com.lantaiyuan.ebus.custom.service.impl
 * @Description: 用户登录
 * @author yangyang
 * @date 2016年12月20日 下午2:04:25
 * @version v1.0
 */
@Service("sysUserService")
public class SysUserServiceImpl extends BaseService<SysUser, SysUserQueryModel> implements SysUserServiceI {

	@Resource
	private SysUserMapper sysUserMapper;

	@Override
	public BaseDAO<SysUser, SysUserQueryModel> getDao() {
		return sysUserMapper;
	}

	@Override
	public LoginResultEnum login(String userName, String passWord, HttpSession session) {
		SysUser user = sysUserMapper.login(userName);
		if (!StringUtils.isEmpty(user)) {// 用户名存在
			if (DigestUtils.md5Hex(passWord).equalsIgnoreCase(user.getPassword())) {
				session.setAttribute(SysGlobalConstants.USER_SESSION_KEY, user);
				return LoginResultEnum.SUCCESS;
			}
			return LoginResultEnum.PWD_FAIL;// 密码错误
		}
		return LoginResultEnum.USER_NOT_FOUND;// 用户名不存在
	}

}
