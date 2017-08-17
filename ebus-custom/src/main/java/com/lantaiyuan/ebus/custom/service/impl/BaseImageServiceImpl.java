package com.lantaiyuan.ebus.custom.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.lanqiao.ssm.common.page.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.lantaiyuan.ebus.custom.dao.BaseImageMapper;
import com.lantaiyuan.ebus.custom.model.BaseImage;
import com.lantaiyuan.ebus.custom.model.BaseImageDetail;
import com.lantaiyuan.ebus.custom.model.BaseImageQueryModel;
import com.lantaiyuan.ebus.custom.service.BaseImageServiceI;

@Service("baseImageService")
public class BaseImageServiceImpl extends BaseService<BaseImage, BaseImageQueryModel> implements BaseImageServiceI {
	@Resource
	private BaseImageMapper baseImageMapper;
	
	@Override
	public BaseDAO<BaseImage, BaseImageQueryModel> getDao() {
		return baseImageMapper;
	}
	
	@Override
	public List<BaseImage> getBaseImage(String cityCode,Integer type) {
		return baseImageMapper.queryImage(cityCode, type);
	}
	 
	@Override
	public Page queryImageList(String type, String isValid, String cityCode, Integer page, Integer rows) {
		BaseImageQueryModel imageQueryModel = new BaseImageQueryModel();
		if (!StringUtils.isEmpty(type)) {
			imageQueryModel.setType((byte)Integer.valueOf(type).intValue());
		}
		if (!StringUtils.isEmpty(cityCode)) {
			imageQueryModel.setCitycode(cityCode);
		}
		imageQueryModel.getPageModel().setPageShow(rows);
		imageQueryModel.getPageModel().setNowPage(page);
		List<BaseImageDetail> imageResultList = new ArrayList<>();
		if (StringUtils.isEmpty(isValid)) {
			imageResultList = baseImageMapper.findAllImageByPage(imageQueryModel);
		}
		if ("1".equals(isValid)) {
			imageResultList =  baseImageMapper.findValidListByPage(imageQueryModel);
		}
		if ("0".equals(isValid)) {
			imageResultList = baseImageMapper.findUnValidListByPage(imageQueryModel);
		}
		imageQueryModel.getPageModel().setRows(imageResultList);
		return imageQueryModel.getPageModel();
	}
	 
	@Override
	public int modifyImageToUnValid(String id) {
		return baseImageMapper.modifyImageToUnValid(id);
	}

	@Override
	public int modifyImageToValid(String id) {
		return baseImageMapper.modifyImageToValid(id);
	}
}
