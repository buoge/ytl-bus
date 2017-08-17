package com.lantaiyuan.ebus.realtime.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.stereotype.Service;

import com.lantaiyuan.ebus.realtime.dao.AlreadyAlertDynamicMapper;
import com.lantaiyuan.ebus.realtime.model.AlreadyAlertDynamic;
import com.lantaiyuan.ebus.realtime.model.AlreadyAlertDynamicQueryModel;
import com.lantaiyuan.ebus.realtime.service.AlreadyAlertDynamicServiceI;
/**
 * 描述:已经提醒的消息业务存储实现类
 * 作者:温海金
 * 最后更改时间:下午2:21:14
 */
@Service
public class AlreadyAlertDynamicServiceImpl extends BaseService<AlreadyAlertDynamic, AlreadyAlertDynamicQueryModel> implements AlreadyAlertDynamicServiceI {
    
    @Resource
    private AlreadyAlertDynamicMapper alreadyAlertDynamicMapper;
    @Override
    public BaseDAO<AlreadyAlertDynamic, AlreadyAlertDynamicQueryModel> getDao() {
	return alreadyAlertDynamicMapper;
    }
    
    @Override
    public int insert(AlreadyAlertDynamic record) {
	record.setId(UUID.randomUUID().toString());
        return super.insert(record);
    }
    
    @Override
    public int insertSelective(AlreadyAlertDynamic record) {
	record.setId(UUID.randomUUID().toString());
        return super.insertSelective(record);
    }

    @Override
    public List<AlreadyAlertDynamic> selectByCondition(AlreadyAlertDynamicQueryModel alreadyAlertDynamicQM) {
	return alreadyAlertDynamicMapper.selectByCondition(alreadyAlertDynamicQM);
    }

    @Override
    public int clearTheDataOfAlreadyAlert() {
	return alreadyAlertDynamicMapper.clearTheDataOfAlreadyAlert();
    }
    
    /**
     * 每天凌晨定时清空用户下车提醒动态表中已经提醒过的数据#DELETE from t_trave_car_setting where IS_REMIND = TRUE;
     */
    @Override
    public int clearTheDataInLeavingCarAlert() {
	return alreadyAlertDynamicMapper.clearTheDataInLeavingCarAlert();
    }
    

}
