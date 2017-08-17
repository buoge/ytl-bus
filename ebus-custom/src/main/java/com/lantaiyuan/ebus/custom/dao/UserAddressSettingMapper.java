package com.lantaiyuan.ebus.custom.dao;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.custom.model.UserAddressSetting;
import com.lantaiyuan.ebus.custom.model.UserAddressSettingQueryModel;

public interface UserAddressSettingMapper extends BaseDAO<UserAddressSetting, UserAddressSettingQueryModel>{
    UserAddressSetting selectByUserIdAndCityCode(@Param("userId") Integer userId, @Param("cityCode") String cityCode);
   
    int updateByUserIdAndCityCodeSelective(UserAddressSetting userAddressSetting);
}