package com.lantaiyuan.ebus.custom.model.enummodel;

import org.springframework.util.CollectionUtils;

import com.lantaiyuan.ebus.custom.model.CommonDescValueModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 驾校报名状态枚举
 * @author yangyang
 * @date 2017年4月27日 下午2:17:06 
 */
public enum DriverSchoolSignUpStatusEnum {
	
	 TO_CONTACT(1, "待联系"),
	 NEXT_CONTACT(2, "下次联系"),
	 ALREADY_SIGNED_UP(3, "已报名"),
	 DEFAULT(0, "默认");
	
	
	private DriverSchoolSignUpStatusEnum(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	private int value;
	private String desc;
	private static List<CommonDescValueModel> signUpStatusList;
	
	/**
	 * 返回驾校报名状态list
	 * @author yangyang
	 * @return
	 */
	public static List<CommonDescValueModel> signUpStatusList() {
		if (CollectionUtils.isEmpty(signUpStatusList)) {
			synchronized (DriverSchoolSignUpStatusEnum.class) {
				if (CollectionUtils.isEmpty(signUpStatusList)) {
					signUpStatusList = new ArrayList<>();
					for (DriverSchoolSignUpStatusEnum signUpEnum : DriverSchoolSignUpStatusEnum.values()) {
						if (signUpEnum.value != DEFAULT.value) {
							signUpStatusList.add(new CommonDescValueModel(signUpEnum.desc, signUpEnum.value));
						}
					}
				}
			}
		}
		return signUpStatusList;
	}
	
	/**
	 * 根据value判断是哪个枚举
	 * @author yangyang
	 * @param value
	 * @return
	 */
	public static DriverSchoolSignUpStatusEnum valueOf(int value) {
		for (DriverSchoolSignUpStatusEnum signUpStatusEnum : DriverSchoolSignUpStatusEnum.values()) {
			if (signUpStatusEnum.value == value) {
				return signUpStatusEnum;
			}
		}
		return DEFAULT;
	}
	
	public int value() {
		return value;
	}
	
	public String desc() {
		return desc;
	}

}
