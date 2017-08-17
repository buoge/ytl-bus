package com.lantaiyuan.ebus.realtime.dao;

import java.util.List;

import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.realtime.model.AppUser;
import com.lantaiyuan.ebus.realtime.model.AppUserQueryModel;
/**
 * 
  * @ClassName: AppUserMapper
  * Company:深圳市蓝泰源信息技术股份有限公司
  * @author Yuan.Tan
  * @date 2016年12月22日 下午2:03:10
 */
public interface AppUserMapper extends BaseDAO<AppUser, AppUserQueryModel> {

	AppUser queryAppUserInfo(AppUser appUser);

	int registerAndLogin(AppUser appUser);

	AppUser selectByPrimaryKey(Integer userId);

	List<AppUser> getCityUsers(String cityCode);


}