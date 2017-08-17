package com.lantaiyuan.ebus.realtime.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;
import com.lantaiyuan.ebus.common.util.DesUtil;
import com.lantaiyuan.ebus.realtime.dao.AppUserMapper;
import com.lantaiyuan.ebus.realtime.model.AppUser;
import com.lantaiyuan.ebus.realtime.model.AppUserQueryModel;
import com.lantaiyuan.ebus.realtime.model.AppUserRegister;
import com.lantaiyuan.ebus.realtime.service.AppUserServiceI;

/**
 * 
 * @ClassName: AppUserServiceImpl 
 * Company:深圳市蓝泰源信息技术股份有限公司
 * @author Yuan.Tan
 * @date 2016年12月22日 下午2:03:40
 */
@Service("appUserService")
public class AppUserServiceImpl extends BaseService<AppUser, AppUserQueryModel> implements AppUserServiceI {
	@Resource
	private AppUserMapper appUserMapper;

	@Override
	public BaseDAO<AppUser, AppUserQueryModel> getDao() {
		return appUserMapper;
	}

	@Override
	public AppUserRegister registerAndLogin(AppUserRegister appUserRegister) {
		AppUser appUser = setAppUserType(appUserRegister);
		// 查询用户 是否已经注册
		AppUser registeredAppUser = queryAppUserInfo(appUser);
		// 1 用户注册
		if (StringUtils.isEmpty(registeredAppUser)) {
			appUserMapper.insertSelective(appUser);
			// 2 查询id
			appUser = appUserMapper.queryAppUserInfo(appUser);
		} else {
			appUser = registeredAppUser;
		}
		BeanUtils.copyProperties(appUser, appUserRegister);
		return appUserRegister;
	}

	@Override
	public HashMap<String, Integer> update(AppUserRegister appUserRegister) {
		AppUser appUser = setAppUserType(appUserRegister);
		String userId = queryAppUserInfo(appUser).getUserid();
		appUser.setUserid(userId);
		HashMap<String, Integer> updateFlagMap = new HashMap<>();
		updateFlagMap.put(SysGlobalConstants.PARAM_FLAG, appUserMapper.updateByPrimaryKeySelective(appUser));
		return updateFlagMap;
	}

	@Override
	public HashMap<String, Integer> logout(AppUserRegister appUserRegister) {
		return update(appUserRegister);
	}

	@Override
	public AppUser queryAppUserInfo(AppUser appUser) {
		return appUserMapper.queryAppUserInfo(appUser);
	}

	/**
	 * setAppUserType(根据前端传来参数确定用户将注册的类型)
	 * @param appUserRegister
	 */
	private AppUser setAppUserType(AppUserRegister appUserRegister) {
		AppUser appUser = new AppUser();
		BeanUtils.copyProperties(appUserRegister, appUser);
		// 获取用户手机号、微信、QQ、微博账号其中的一个账号
		String userCode = appUserRegister.getUsercode();
		// 判断用户类型
		String userType = appUserRegister.getType();
		switch (userType) {
		case SysGlobalConstants.APP_USER_TPYE_PHONEUSER:
			appUser.setPhoneno(userCode);
			break;
		case SysGlobalConstants.APP_USER_TPYE_WECHATUSER:
			appUser.setWechatno(userCode);
			break;
		case SysGlobalConstants.APP_USER_TPYE_QQUSER:
			appUser.setQqno(userCode);
			break;
		case SysGlobalConstants.APP_USER_TPYE_MICROBLOGUSER:
			appUser.setMicroblogno(userCode);
			break;
		default:
			break;
		}
		return appUser;
	}

	/**
	 * 功能描述:保存jpush返回给app端的registrationId
	 * 规则:如果用户数据中不存在或者registrationId与前端传过来的registrationId不一样，
	 * 则用参数中的registrationId替换数据库中的registrationId
	 * 作者:温海金
	 * 最后更改时间 : 2016年12月19日 下午2:40:20
	 */
	@Override
	public void setRegistrationIdIfNotExist(Integer userId, String registrationId, int lastLoginSysType) {
		AppUser appUser = appUserMapper.selectByPrimaryKey(userId);
		if (null != appUser && (StringUtils.isEmpty(appUser.getRegistrationId()) || registrationId.trim() != appUser.getRegistrationId().trim())) {
			appUser.setRegistrationId(registrationId);
			appUser.setLastLoginSysType(lastLoginSysType);
			appUserMapper.updateByPrimaryKeySelective(appUser);
		}
	}

	@Override
	public AppUser getAppUserById(Integer userId) {
		return appUserMapper.selectByPrimaryKey(userId);
	}

	/**
	 * 根据用户id修改用户信息
	 * @author yangyang
	 */
	@Override
	public int updateByUserId(AppUser appUser) {
		appUser.setUserid(DesUtil.decrypt(appUser.getUserid()));
		return appUserMapper.updateByPrimaryKeySelective(appUser);
	}

	/**
	 * 根据城市编码获取城市所有用户
	 * @param cityCode
	 * @author yangyang
	 */
	@Override
	public List<AppUser> getCityUsers(String cityCode) {
		return appUserMapper.getCityUsers(cityCode);
	}

	@Override
	public String getRegIdByUserId(Integer userId) {
		AppUser appUser = appUserMapper.selectByPrimaryKey(userId);
		if(appUser != null) {
			return appUser.getRegistrationId();
		}
		return null;
	}

}