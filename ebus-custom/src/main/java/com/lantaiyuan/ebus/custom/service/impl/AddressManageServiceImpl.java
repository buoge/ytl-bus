/**
* <p>Title: AddressManageServiceImpl.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.custom.service.impl;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.stereotype.Service;

import com.lantaiyuan.ebus.custom.dao.UserAddressSettingMapper;
import com.lantaiyuan.ebus.custom.model.UserAddressSetting;
import com.lantaiyuan.ebus.custom.model.UserAddressSettingQueryModel;
import com.lantaiyuan.ebus.custom.service.AddressManageServiceI;

/**
* <p>Title: AddressManageServiceImpl</p>
* <p>Description: 地址管理业务实现类</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年6月8日 下午3:23:06
*/
@Service("addressManageService")
public class AddressManageServiceImpl extends BaseService<UserAddressSetting, UserAddressSettingQueryModel> implements AddressManageServiceI {
	@Resource
	private UserAddressSettingMapper userAddressSettingMapper;
	
	/***
	* <p>Title: save</p>
	* <p>Description: 业务保存方法</p>
	* @param userAddressSetting
	*/
	@Override
	public boolean saveOrUpdate(UserAddressSetting userAddressSetting) {
		UserAddressSetting entity = findEntityByUserIdAndCityCode(userAddressSetting.getAddressUserId(), userAddressSetting.getCityCode());
		
		if(entity == null){
			return userAddressSettingMapper.insertSelective(userAddressSetting) > 0 ? true : false;
		}
		
		return update(userAddressSetting);
	}

	/***
	* <p>Title: update</p>
	* <p>Description: 业务更新方法</p>
	* @param userAddressSetting
	*/
	@Override
	public boolean update(UserAddressSetting userAddressSetting) {
		return userAddressSettingMapper.updateByUserIdAndCityCodeSelective(userAddressSetting) > 0 ? true : false;
	}

	/***
	* <p>Title: findEntityByUserId</p>
	* <p>Description: 业务查询方法（单个）</p>
	*/
	@Override
	public UserAddressSetting findEntityByUserIdAndCityCode(Integer userId, String cityCode) {
		return userAddressSettingMapper.selectByUserIdAndCityCode(userId, cityCode);
	}
	
	/***
	* <p>Title: getDao</p>
	* <p>Description:具体化Dao接口</p>
	* @return
	*/
	@Override
	public BaseDAO<UserAddressSetting, UserAddressSettingQueryModel> getDao() {
		return this.userAddressSettingMapper;
	}

}
