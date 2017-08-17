package com.lantaiyuan.ebus.custom.controller;

import javax.annotation.Resource;

import org.hibernate.validator.constraints.NotEmpty;
import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lantaiyuan.ebus.custom.model.BaseDriverSchool;
import com.lantaiyuan.ebus.custom.model.BaseDriverSchoolQueryModel;
import com.lantaiyuan.ebus.custom.model.DriverSchoolContactRecord;
import com.lantaiyuan.ebus.custom.model.DriverSchoolSignUp;
import com.lantaiyuan.ebus.custom.model.DriverSchoolSignUpContact;
import com.lantaiyuan.ebus.custom.model.DriverSchoolSignUpQueryModel;
import com.lantaiyuan.ebus.custom.model.enummodel.DriverSchoolSignUpStatusEnum;
import com.lantaiyuan.ebus.custom.model.enummodel.LicenseTypeEnum;
import com.lantaiyuan.ebus.custom.service.DriverSchoolContactRecordServiceI;
import com.lantaiyuan.ebus.custom.service.DriverSchoolServiceI;
import com.lantaiyuan.ebus.custom.service.DriverSchoolSignUpServiceI;
/**
 * 驾校管理
 * @author yangyang
 * @date 2017年4月25日 下午3:50:33 
 *
 */
@RestController
@RequestMapping("/driver/school")
public class DriverSchoolController extends BasicController {
	
	@Resource
	private DriverSchoolServiceI driverSchoolService;
	@Resource
	private DriverSchoolSignUpServiceI driverSchoolSignUpService;
	@Resource
	private DriverSchoolContactRecordServiceI driverSchoolContactRecordService;
	
	/**
	 * 分页查询驾校信息
	 * @author yangyang
	 * @param queryModel
	 * @return
	 */
	@GetMapping("/list")
	public Json driverSchoolList(BaseDriverSchoolQueryModel queryModel) {
		return setSimpleSuccess(driverSchoolService.findDriverSchoolByPage(queryModel));
	}
	
	/**
	 * 获取某个驾校的详细信息
	 * @author yangyang
	 * @param id
	 * @return
	 */
	@GetMapping("/get/{id}")
	public Json getDriverSchool(@PathVariable String id) {
		return setSimpleSuccess(driverSchoolService.selectByPrimaryKey(id));
	}
	
	/**
	 * 往数据库中加入一个驾校
	 * @author yangyang
	 * @param driverSchool
	 * @return
	 */
	@PostMapping("/insert")
	public Json addDriverSchool(@Validated BaseDriverSchool driverSchool) {
		int result = driverSchoolService.insert(driverSchool);
		return result >= 1 ? setSimpleSuccess() : setFailed("添加失败"); 
	}
	
	/**
	 * 更新某个驾校的信息
	 * @author yangyang
	 * @param driverSchool
	 * @return
	 */
	@PostMapping("/update")
	public Json updateDriverSchool(@Validated BaseDriverSchool driverSchool) {
		int result = driverSchoolService.updateByPrimaryKeySelective(driverSchool);
		return result >= 1 ? setSimpleSuccess() : setFailed("修改失败"); 
	}
	
	/**
	 * 删除某个驾校
	 * @author yangyang
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public Json deleteDriverSchool(@PathVariable String id) {
		int result = driverSchoolService.deleteByPrimaryKey(id);
		return result >= 1 ? setSimpleSuccess() : setFailed("删除失败"); 
	}
	
	/**
	 * 返回所有的驾照类型
	 * @author yangyang
	 * @return
	 */
	@GetMapping("/licenseTypes")
	public Json licenseTypes() {
		return  setSimpleSuccess(LicenseTypeEnum.licenseTypeList());
	}
	
	/**
	 * 返回所有的报名状态
	 * @author yangyang
	 * @return
	 */
	@GetMapping("/signUp/status")
	public Json signUpStatus() {
		return setSimpleSuccess(DriverSchoolSignUpStatusEnum.signUpStatusList());
	}
	
	/**
	 * 分页查询驾校报名信息
	 * @author yangyang
	 * @param queryModel
	 * @return
	 */
	@GetMapping("/signUp/list")
	public Json driverSchoolSignUpList(DriverSchoolSignUpQueryModel queryModel) {
		return setSimpleSuccess(driverSchoolSignUpService.findDriverSchoolSignUpByPage(queryModel));
	}
	
	/**
	 * 添加联系记录，更新报名人信息、最后一次联系时间
	 * @author yangyang
	 * @param record
	 * @param signUp
	 * @return
	 */
	@PostMapping("/signUp/contact/insert")
	public Json signUpContactInfo(@Validated DriverSchoolContactRecord record, DriverSchoolSignUp signUp) {
		int result = driverSchoolContactRecordService.insertSelective(record, signUp);
		return result >= 1 ? setSimpleSuccess() : setFailed("操作失败"); 
	}
	
	/**
	 * 通过web后台添加报名信息
	 * @author yangyang
	 * @param signUpContact
	 * @param session
	 * @return
	 */
	@PostMapping("/signUp/insert")
	public Json signUpInsert(@Validated DriverSchoolSignUpContact signUpContact, @NotEmpty(message = "城市编码不能为空") String cityCode) {
		int result = driverSchoolContactRecordService.insertSelective(signUpContact, cityCode);
		return result >= 1 ? setSimpleSuccess() : setFailed("操作失败"); 
	}
	
	/**
	 * 获取报名人的联系记录
	 * @author yangyang
	 * @param signupId
	 * @return
	 */
	@GetMapping("/signUp/contact/get/{signupId}")
	public Json signUpContactList(@PathVariable String signupId) {
		return setSimpleSuccess(driverSchoolContactRecordService.selectBySignUpId(signupId));
	}
	
	
	// 以下接口为手机端提供
	/**
	 * 获取某个城市的驾校信息(多于一条也只返回一条)
	 * @author yangyang
	 * @param cityCode
	 * @return
	 */
	@GetMapping("/cityCode/{cityCode}")
	public Json driverSchoolDetail(@PathVariable String cityCode) {
		return setSimpleSuccess(driverSchoolService.selectByCityCode(cityCode));
	}
	
	/**
	 * 获取某驾校能提供报名的驾校类型
	 * @author yangyang
	 * @param id
	 * @return
	 */
	@GetMapping("/licenseTypes/{id}")
	public Json driverSchoolLicenseTypes(@PathVariable  String id) {
		return setSimpleSuccess(driverSchoolService.selectAcceptLicensesByPrimaryKey(id));
	}
	
	/**
	 * 立即预约（报名）
	 * @author yangyang
	 * @param signUp
	 * @return
	 */
	@PostMapping("/signUp/join")
	public Json signUp(@Validated DriverSchoolSignUp signUp) {
		int result = driverSchoolSignUpService.insertSelective(signUp);
		if (result == -1) {
			return setFailed("该手机号已预约过，请不要重复预约");
		}
		return result >= 1 ? setSimpleSuccess() : setFailed("预约失败"); 
	}

}