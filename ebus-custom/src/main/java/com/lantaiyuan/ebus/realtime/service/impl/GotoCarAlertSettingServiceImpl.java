package com.lantaiyuan.ebus.realtime.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lantaiyuan.ebus.realtime.dao.GotoCarAlertSettingMapper;
import com.lantaiyuan.ebus.realtime.model.GotoCarAlertSetting;
import com.lantaiyuan.ebus.realtime.model.GotoCarAlertSettingModel;
import com.lantaiyuan.ebus.realtime.model.GotoCarAlertSettingQueryModel;
import com.lantaiyuan.ebus.realtime.service.GotoCarAlertSettingServiceI;
/**
 * 描述:消息提醒设置业务实现类
 * 作者:温海金
 * 最后更改时间:下午2:24:19
 */
@Service
public class GotoCarAlertSettingServiceImpl extends BaseService<GotoCarAlertSetting, GotoCarAlertSettingQueryModel> implements GotoCarAlertSettingServiceI{
    @Resource
    private GotoCarAlertSettingMapper gotoCarAlertSettingMapper;
    
    @Override
    public BaseDAO<GotoCarAlertSetting, GotoCarAlertSettingQueryModel> getDao() {
	return gotoCarAlertSettingMapper;
    }

    @Override
    public int insert(GotoCarAlertSetting record) {
	record.setId(UUID.randomUUID().toString());
        return super.insert(record);
    }
    
    @Override
    public int insertSelective(GotoCarAlertSetting record) {
	record.setId(UUID.randomUUID().toString());
        return super.insertSelective(record);
    }
    
    /**
     * 更新操作，重新将设置置为未提醒
     */
    @Override
    public int updateByPrimaryKeySelective(GotoCarAlertSetting record) {
	record.setIsRemind(false);
        return super.updateByPrimaryKeySelective(record);
    }
    
    /**
     * 更新操作,主要为了解决提醒后isRemind的状态变化问题，防止与updateByPrimaryKeySelective方法相冲突
     */
    @Override
    public int updateEntity(GotoCarAlertSetting record) {
        return super.updateByPrimaryKeySelective(record);
    }
    
    @Override
    public List<GotoCarAlertSetting> selectByCondition(GotoCarAlertSettingQueryModel gotoCarAlertSettingQM) {
	return gotoCarAlertSettingMapper.selectByCondition(gotoCarAlertSettingQM);
    }
    
    @Override
    public int insertArray(String gotoCarAlertSettings) {

	int countOfInsertSuccess = 0;
	String[] split = gotoCarAlertSettings.split(";");
	for(String objString : split){
	    //JSONObject obj = new JSONObject(objString); 
	    JSONObject obj = (JSONObject)JSONObject.parse(objString);
	    countOfInsertSuccess += insertSelective(GotoCarAlertSetting.buid(obj));
	}
	return countOfInsertSuccess;
    }

    @Override
    public int updateArray(String gotoCarAlertSettings) {
	int countOfUpdateSuccess = 0;
	String[] split = gotoCarAlertSettings.split(";");
	for(String objString : split){
	    //JSONObject obj = new JSONObject(objString); 
	    JSONObject obj = (JSONObject) JSONObject.parse(objString);
	    GotoCarAlertSetting buidEntity = GotoCarAlertSetting.buid(obj);
	    buidEntity.setId(obj.get("entityId").toString());//entityId很重要，更新操作就是根据entityId来更新的(这边用entityId而不是id,因为id是IOS中的关键字)
	    countOfUpdateSuccess += updateByPrimaryKeySelective(buidEntity);
	}
	return countOfUpdateSuccess;
    }

    @Override
    public List<GotoCarAlertSetting> getGotoCarAlertSettings(String cityCode, Integer userId) {
	GotoCarAlertSettingQueryModel settingQM = new GotoCarAlertSettingQueryModel();
	settingQM.setCityCode(cityCode);
	settingQM.setUserId(userId);
	return gotoCarAlertSettingMapper.selectByCondition(settingQM);
    }

    @Override
    public int insertArrayWithDataModels(List<GotoCarAlertSettingModel> voModels) {
	voModels.forEach(voModel->{
	    GotoCarAlertSetting poModel = new GotoCarAlertSetting();
	    BeanUtils.copyProperties(voModel, poModel);
	    poModel.setIsRemind(false);
	    poModel.setAlertStrategy(Integer.valueOf(voModel.getAlertStrategy()));
	    poModel.setUserId(Integer.valueOf(voModel.getUserId()));
	    poModel.setIsOpen(getBooleanValue(voModel));
	    poModel.setTag(Integer.valueOf(voModel.getTag()));
	    this.insertSelective(poModel);
	});
	return voModels.size();
    }

    private Boolean getBooleanValue(GotoCarAlertSettingModel voModel) {
	if(voModel!=null && !StringUtils.isEmpty(voModel.getIsOpen()) && (voModel.getIsOpen().trim().equals("1") || voModel.getIsOpen().trim().equals("true"))) {
	    return Boolean.TRUE;
	}
	return Boolean.FALSE;
    }

    @Override
    public int updateArrayWithDataModels(List<GotoCarAlertSettingModel> voModels) {
	voModels.forEach(voModel->{
	    GotoCarAlertSetting poModel = new GotoCarAlertSetting();
	    BeanUtils.copyProperties(voModel, poModel);
	    poModel.setId(voModel.getEntityId());
	    poModel.setIsRemind(false);
	    poModel.setAlertStrategy(Integer.valueOf(voModel.getAlertStrategy()));
	    poModel.setUserId(Integer.valueOf(voModel.getUserId()));
	    poModel.setIsOpen(getBooleanValue(voModel));
	    poModel.setTag(Integer.valueOf(voModel.getTag()));
	    poModel.setCreateTime(new Date());
	    this.updateByPrimaryKeySelective(poModel);
	});
	return voModels.size();
    }
}
