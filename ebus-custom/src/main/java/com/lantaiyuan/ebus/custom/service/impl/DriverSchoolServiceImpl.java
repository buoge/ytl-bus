package com.lantaiyuan.ebus.custom.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.lanqiao.ssm.common.page.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lantaiyuan.ebus.custom.dao.BaseDriverSchoolMapper;
import com.lantaiyuan.ebus.custom.model.BaseDriverSchool;
import com.lantaiyuan.ebus.custom.model.BaseDriverSchoolQueryModel;
import com.lantaiyuan.ebus.custom.model.CommonDescValueModel;
import com.lantaiyuan.ebus.custom.model.enummodel.LicenseTypeEnum;
import com.lantaiyuan.ebus.custom.service.DriverSchoolServiceI;

/**
 * 驾校service实现类
 * @author yangyang
 * @date 2017年4月26日 下午5:00:52 
 *
 */
@Service("driverSchoolService")
public class DriverSchoolServiceImpl extends BaseService<BaseDriverSchool, BaseDriverSchoolQueryModel> implements DriverSchoolServiceI {

	@Resource
	private BaseDriverSchoolMapper baseDriverSchoolMapper;
	

	@Override
	public BaseDAO<BaseDriverSchool, BaseDriverSchoolQueryModel> getDao() {
		return baseDriverSchoolMapper;
	}


	/**
	 * 添加驾校信息
	 * @author yangyang
	 * @param record
	 */
	@Override
	public int insert(BaseDriverSchool record) {
		record.setId(UUID.randomUUID().toString());
		return super.insert(record);
	}

	/**
	 * 分页查询驾校信息
	 * @author yangyang
	 * @param model
	 * @return
	 */
	@Override
	public Page<BaseDriverSchool> findDriverSchoolByPage(BaseDriverSchoolQueryModel model) {
		List<BaseDriverSchool> list = baseDriverSchoolMapper.findDriverSchoolByPage(model);
		// 处理驾照类别
		list.forEach(e -> {
			String[] licenseArray = e.getAcceptLicenses().split(",");
			StringBuilder licenseStr = new StringBuilder();
			for (String license: licenseArray) {
				licenseStr.append(LicenseTypeEnum.valueOf(Integer.valueOf(license)).desc()).append("/");
			}
			e.setAcceptLicenseTypeDesc(licenseStr.substring(0, licenseStr.length() - 1));
		});
		model.getPageModel().setRows(list);
		return model.getPageModel();
	}
	
	/**
     * 根据cityCode查询该城市的驾校（多于一条也只返回一条）
     * @author yangyang
     * @param cityCode
     * @return
     */
	@Override
	public BaseDriverSchool selectByCityCode(String cityCode) {
		return baseDriverSchoolMapper.selectByCityCode(cityCode);
	}
	
	/**
	 * 根据主键查询该驾校所能接受的驾照报名类型
	 * @author yangyang
	 * @param id
	 * @return
	 */
	@Override
	public List<CommonDescValueModel> selectAcceptLicensesByPrimaryKey(String id) {
		String accessLicenseTypes = baseDriverSchoolMapper.selectAcceptLicensesByPrimaryKey(id);
		if (StringUtils.isEmpty(accessLicenseTypes)) {
			return Collections.emptyList();
		}
		String[] types = accessLicenseTypes.split(",");
		List<CommonDescValueModel> list = new ArrayList<>();
		for (String type : types) {
			LicenseTypeEnum typeEnum = LicenseTypeEnum.valueOf(Integer.valueOf(type));
			list.add(new CommonDescValueModel(typeEnum.desc(), typeEnum.value()));
		}
		return list;
	}

}
