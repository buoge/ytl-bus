package com.lantaiyuan.ebus.custom.model.enummodel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.lantaiyuan.ebus.custom.model.CommonDescValueModel;

/**
 * 驾照类型枚举
 * @author yangyang
 * @date 2017年4月25日 下午3:22:48 
 */
public enum LicenseTypeEnum {
	
	A1(1,"A1"),
	A2(2,"A2"),
	A3(3,"A3"),
	B1(4,"B1"),
	B2(5,"B2"),
	C1(6,"C1"),
	C2(7,"C2"),
	DEFAULT(0,"default");
	
	private LicenseTypeEnum(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	private int value;
	
	private String desc;
	
	private static List<CommonDescValueModel> licenseTypeList = new ArrayList<>();
	
	public int value() {
		return value;
	}
	
	public String desc() {
		return desc;
	}
	
	/**
	 * 获取所有的驾照类型
	 * @author yangyang
	 * @return
	 */
	public static List<CommonDescValueModel> licenseTypeList() {
		if (CollectionUtils.isEmpty(licenseTypeList)) {
			synchronized (LicenseTypeEnum.class) {
				if (CollectionUtils.isEmpty(licenseTypeList)) {
					for(LicenseTypeEnum typeEnum: LicenseTypeEnum.values()) {
						if (typeEnum.value != DEFAULT.value) {
							licenseTypeList.add(new CommonDescValueModel(typeEnum.desc, typeEnum.value));
						}
					}
				}
			}
		}
		return licenseTypeList;
	}
	
	/**
	 * 根据value判断是哪一个驾照类型
	 * @author yangyang
	 * @param value
	 * @return
	 */
	public static LicenseTypeEnum valueOf(int value) {
		for (LicenseTypeEnum typeEnum: LicenseTypeEnum.values()) {
			if(value == typeEnum.value) {
				return typeEnum;
			}
		}
		return DEFAULT;
	}	
}
