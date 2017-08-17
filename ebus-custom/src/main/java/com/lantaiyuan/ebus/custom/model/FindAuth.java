package com.lantaiyuan.ebus.custom.model;

import org.lanqiao.ssm.common.model.Model;

/**
 * 发现模块权限
 * 
 * @author yangyang
 * @date 2017年6月8日 下午3:27:23
 *
 */
public class FindAuth extends Model {


	private static final long serialVersionUID = 3076665083791265253L;

	private FindAuthPropertyWithHeadTitle busService;

	private FindAuthPropertyWithHeadTitle customService;

	private FindAuthPropertyWithHeadTitle thirdService;

	public FindAuth() {
		super();
	}

	public FindAuth(FindAuthPropertyWithHeadTitle busService, FindAuthPropertyWithHeadTitle customService,
			FindAuthPropertyWithHeadTitle thirdService) {
		super();
		this.busService = busService;
		this.customService = customService;
		this.thirdService = thirdService;
	}

	public FindAuthPropertyWithHeadTitle getBusService() {
		return busService;
	}

	public void setBusService(FindAuthPropertyWithHeadTitle busService) {
		this.busService = busService;
	}

	public FindAuthPropertyWithHeadTitle getCustomService() {
		return customService;
	}

	public void setCustomService(FindAuthPropertyWithHeadTitle customService) {
		this.customService = customService;
	}

	public FindAuthPropertyWithHeadTitle getThirdService() {
		return thirdService;
	}

	public void setThirdService(FindAuthPropertyWithHeadTitle thirdService) {
		this.thirdService = thirdService;
	}
	
}
