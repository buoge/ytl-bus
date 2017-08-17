package com.lantaiyuan.ebus.custom.service.impl;


import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lantaiyuan.ebus.common.util.Tools;
import com.lantaiyuan.ebus.custom.dao.BaseDriverSchoolMapper;
import com.lantaiyuan.ebus.custom.dao.DriverSchoolContactRecordMapper;
import com.lantaiyuan.ebus.custom.dao.DriverSchoolSignUpMapper;
import com.lantaiyuan.ebus.custom.model.BaseDriverSchool;
import com.lantaiyuan.ebus.custom.model.DriverSchoolContactRecord;
import com.lantaiyuan.ebus.custom.model.DriverSchoolContactRecordQueryModel;
import com.lantaiyuan.ebus.custom.model.DriverSchoolSignUp;
import com.lantaiyuan.ebus.custom.model.DriverSchoolSignUpContact;
import com.lantaiyuan.ebus.custom.service.DriverSchoolContactRecordServiceI;

/**
 * 驾校报名联系记录service
 * @author yangyang
 * @date 2017年4月26日 下午5:00:52 
 *
 */
@Service("driverSchoolContactRecordService")
public class DriverSchoolContactRecordServiceImpl extends BaseService<DriverSchoolContactRecord,DriverSchoolContactRecordQueryModel> implements DriverSchoolContactRecordServiceI {

	@Resource
	private DriverSchoolContactRecordMapper driverSchoolContactRecordMapper;
	@Resource
	private DriverSchoolSignUpMapper driverSchoolSignUpMapper;
	@Resource
	private BaseDriverSchoolMapper baseDriverSchoolMapper;

	@Override
	public BaseDAO<DriverSchoolContactRecord,DriverSchoolContactRecordQueryModel> getDao() {
		return driverSchoolContactRecordMapper;
	}

	/**
	 * 添加联系记录
	 * 更新报名人信息，最后一次联系时间
	 * @author yangyang
	 */
	@Override
	public int insertSelective(DriverSchoolContactRecord record, DriverSchoolSignUp signUp) {
		record.setContactTime(Tools.processStrToDate(record.getContactTimeStr()));
		// 更改driver_school_signup表
		signUp.setLastContactTime(record.getContactTime());
		signUp.setId(record.getSignupId());
		driverSchoolSignUpMapper.updateByPrimaryKeySelective(signUp);
		
		return super.insertSelective(record);
	}

	/**
	 * 后台添加驾校报名信息
	 * @author yangyang
	 */
	@Override
	public int insertSelective(DriverSchoolSignUpContact signUpContact, String cityCode) {
		BaseDriverSchool driverSchool = baseDriverSchoolMapper.selectByCityCode(cityCode);
		if (Objects.isNull(driverSchool) || StringUtils.isEmpty(driverSchool.getId())) {
			// 城市不存在驾校，无法报名
			return -1;
		}
		DriverSchoolSignUp signUp = signUpContact.driverSchoolSignUp(driverSchool.getId());
		DriverSchoolContactRecord record = signUpContact.driverSchoolContactRecord(signUp.getId());
		int signUpResult = driverSchoolSignUpMapper.insertSelective(signUp);
		int contactResult = 0;
		if (signUpResult >= 1) {
			contactResult = super.insertSelective(record);
		}
		return contactResult;
	}
	
	/**
	 * 根据报名id获取当前报名人的所有联系记录
	 * @author yangyang
	 * @param signUpId
	 * @return
	 */
	@Override
	public List<DriverSchoolContactRecord> selectBySignUpId(String signUpId) {
		return driverSchoolContactRecordMapper.selectBySignUpId(signUpId);
	}

}
