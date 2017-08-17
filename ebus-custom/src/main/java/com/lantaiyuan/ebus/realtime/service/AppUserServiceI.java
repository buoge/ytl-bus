package com.lantaiyuan.ebus.realtime.service;

import java.util.HashMap;
import java.util.List;

import org.lanqiao.ssm.common.core.service.BaseServiceI;
import com.lantaiyuan.ebus.realtime.model.AppUser;
import com.lantaiyuan.ebus.realtime.model.AppUserQueryModel;
import com.lantaiyuan.ebus.realtime.model.AppUserRegister;
/**
 * 
  * @ClassName: AppUserServiceI
  * Company:深圳市蓝泰源信息技术股份有限公司
  * @author Yuan.Tan
  * @date 2016年12月22日 下午2:03:29
 */
public interface AppUserServiceI extends BaseServiceI<AppUser, AppUserQueryModel> {
 
	AppUserRegister registerAndLogin(AppUserRegister appUserRegister);

	/**
	  * queryAppUserInfo(查询app用户信息)
	  */
	AppUser queryAppUserInfo(AppUser appUser);

	HashMap<String, Integer> update(AppUserRegister appUserRegister);

	HashMap<String, Integer> logout(AppUserRegister appUserRegister);

	/**
	 * 功能描述:保存jpush返回的设备编码
	 * 作者:温海金
	 * 最后更改时间 : 2017年2月20日 下午2:41:21
	 * @param lastLoginSysType 
	 */
	void setRegistrationIdIfNotExist(Integer userId, String registrationId, int lastLoginSysType);
	
	/**
	 * 功能描述:根据用户id查询app用户信息
	 * 作者:温海金
	 * 最后更改时间 : 2017年2月20日 下午2:41:21
	 */
	AppUser getAppUserById(Integer userId);

	int updateByUserId(AppUser appUser);

	/**
	 * 获取城市所有用户
	 * @author yangyang
	 * @param cityCode
	 * @return
	 */
	List<AppUser> getCityUsers(String cityCode);
	
	String getRegIdByUserId(Integer userId);

}