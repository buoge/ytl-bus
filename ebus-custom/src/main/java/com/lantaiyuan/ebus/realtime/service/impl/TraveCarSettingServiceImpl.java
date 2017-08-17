package com.lantaiyuan.ebus.realtime.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.stereotype.Service;

import com.lantaiyuan.ebus.realtime.dao.TraveCarSettingMapper;
import com.lantaiyuan.ebus.realtime.model.TraveCarSetting;
import com.lantaiyuan.ebus.realtime.model.TraveCarSettingQueryModel;
import com.lantaiyuan.ebus.realtime.service.TraveCarSettingServiceI;

/**
 * 功能描述:上下车提醒业务实现类
 * 作者:温海金
 * 最后更改时间 : 2017年02月17日 上午10:28:42
 */
@Service("traveCarSettingService")
public class TraveCarSettingServiceImpl extends BaseService<TraveCarSetting, TraveCarSettingQueryModel> implements TraveCarSettingServiceI {

	@Resource
	private TraveCarSettingMapper traveCarSettingMapper;
	
	@Override
	public BaseDAO<TraveCarSetting, TraveCarSettingQueryModel> getDao() {
	    return traveCarSettingMapper;
	}
	
	@Override
	public int insertSelective(TraveCarSetting record) {
	    record.setId(UUID.randomUUID().toString());
	    return super.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKey(TraveCarSetting record) {
	    record.setIsRemind(false);
	    return super.updateByPrimaryKey(record);
	}
	
	@Override
	public int updateByPrimaryKeySelective(TraveCarSetting record) {
	    record.setIsRemind(false);
	    return super.updateByPrimaryKeySelective(record);
	}
	
	 /**
	   * 功能描述:更新实体类，不设置提醒状态为未提醒，主要供后台自己更改提醒状态调用
	   * 作者:温海金
	   * 最后更改时间 : 2017年3月21日 下午5:14:04
	   */
	@Override
	public int updateEntity(TraveCarSetting record) {
	    return super.updateByPrimaryKeySelective(record);
	}
	
	@Override
	public List<TraveCarSetting> selectByCondition(TraveCarSettingQueryModel traveCarSettingQM) {
	    return traveCarSettingMapper.selectByCondition(traveCarSettingQM);
	}
	
}