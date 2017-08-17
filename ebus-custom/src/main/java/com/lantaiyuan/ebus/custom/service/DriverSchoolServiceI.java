package com.lantaiyuan.ebus.custom.service;

import java.util.List;

import org.lanqiao.ssm.common.core.service.BaseServiceI;
import org.lanqiao.ssm.common.page.Page;

import com.lantaiyuan.ebus.custom.model.BaseDriverSchool;
import com.lantaiyuan.ebus.custom.model.BaseDriverSchoolQueryModel;
import com.lantaiyuan.ebus.custom.model.CommonDescValueModel;

public interface DriverSchoolServiceI extends BaseServiceI<BaseDriverSchool, BaseDriverSchoolQueryModel>{

	/**
	 * 分页查询驾校信息
	 * @author yangyang
	 * @param model
	 * @return
	 */
	Page<BaseDriverSchool> findDriverSchoolByPage(BaseDriverSchoolQueryModel model);
	
	/**
     * 根据cityCode查询该城市的驾校（多于一条也只返回一条）
     * @author yangyang
     * @param cityCode
     * @return
     */
	BaseDriverSchool selectByCityCode(String cityCode);

	/**
	 * 根据主键查询该驾校所能接受的驾照报名类型
	 * @author yangyang
	 * @param id
	 * @return
	 */
	List<CommonDescValueModel> selectAcceptLicensesByPrimaryKey(String id);

	
	
}
