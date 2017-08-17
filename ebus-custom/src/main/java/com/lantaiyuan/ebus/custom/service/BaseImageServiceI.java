package com.lantaiyuan.ebus.custom.service;

import java.util.List;
import org.lanqiao.ssm.common.core.service.BaseServiceI;
import com.lantaiyuan.ebus.custom.model.BaseImage;
import com.lantaiyuan.ebus.custom.model.BaseImageQueryModel;

public interface BaseImageServiceI extends BaseServiceI<BaseImage, BaseImageQueryModel>{

	List<BaseImage> getBaseImage(String cityCode, Integer type);

	/**
	  * queryImageList(后台管理系统：查询广告屏闪列表记录)
	  */
	Object queryImageList(String type, String isValid, String cityCode, Integer page, Integer rows);

	/**
	  * modifyImageToUnValid(后台管理系统：修改广告闪屏记录状态》使其失效)
	  */
	int modifyImageToUnValid(String id);

	/**
	  * modifyImageToValid(后台管理系统：修改广告闪屏记录状态》使其重新生效(从当天开始的七天内))
	  */
	int modifyImageToValid(String id);

}
