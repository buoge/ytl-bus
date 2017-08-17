package com.lantaiyuan.ebus.custom.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.lanqiao.ssm.common.page.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lantaiyuan.ebus.custom.dao.DriverSchoolSignUpMapper;
import com.lantaiyuan.ebus.custom.model.DriverSchoolSignUp;
import com.lantaiyuan.ebus.custom.model.DriverSchoolSignUpQueryModel;
import com.lantaiyuan.ebus.custom.service.DriverSchoolSignUpServiceI;

/**
 * 驾校报名service
 * @author yangyang
 * @date 2017年4月26日 下午5:00:52 
 *
 */
@Service("driverSchoolSignUpService")
public class DriverSchoolSignUpServiceImpl extends BaseService<DriverSchoolSignUp, DriverSchoolSignUpQueryModel> implements DriverSchoolSignUpServiceI {

	@Resource
	private DriverSchoolSignUpMapper driverSchoolSignUpMapper;
	
	@Override
	public BaseDAO<DriverSchoolSignUp, DriverSchoolSignUpQueryModel> getDao() {
		return driverSchoolSignUpMapper;
	}

	/**
	 * 立即预约
	 */
	@Override
	public int insertSelective(DriverSchoolSignUp record) {
		int count = driverSchoolSignUpMapper.selectByTel(record.getTel());
		if (count >= 1) {
			return -1;
		}
		record.setId(UUID.randomUUID().toString());
		return super.insertSelective(record);
	}
	
	/**
	 * 分页查询驾校报名信息
	 * @author yangyang
	 * @param model
	 * @return
	 */
	@Override
	public Page<DriverSchoolSignUp> findDriverSchoolSignUpByPage(DriverSchoolSignUpQueryModel model) {
		if (!StringUtils.isEmpty(model.getStatus()) && !"-1".equals(model.getStatus())) {// 选择了状态
			model.setStatusArray(model.getStatus().split(","));
		}
		List<DriverSchoolSignUp> list = driverSchoolSignUpMapper.findDriverSchoolSignUpByPage(model);
		model.getPageModel().setRows(list);
		return model.getPageModel();
	}

}
