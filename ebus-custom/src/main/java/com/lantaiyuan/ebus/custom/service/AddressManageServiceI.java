/**
* <p>Title: AddressManageServiceI.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.custom.service;

import org.lanqiao.ssm.common.core.service.BaseServiceI;

import com.lantaiyuan.ebus.custom.model.UserAddressSetting;
import com.lantaiyuan.ebus.custom.model.UserAddressSettingQueryModel;

/**
* <p>Title: AddressManageServiceI</p>
* <p>Description: 地址管理业务接口</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年6月8日 下午3:15:52
*/
public interface AddressManageServiceI extends BaseServiceI<UserAddressSetting, UserAddressSettingQueryModel>{
	boolean saveOrUpdate(UserAddressSetting userAddressSetting);
	boolean update(UserAddressSetting userAddressSetting);
	
	UserAddressSetting findEntityByUserIdAndCityCode(Integer userId, String cityCode);
}
