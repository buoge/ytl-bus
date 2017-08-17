/**
* <p>Title: NeighbouringTourServiceImpl.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.custom.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.csource.common.MyException;
import org.lanqiao.fdfs.FastDFSHelper;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.lanqiao.ssm.common.page.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.lantaiyuan.ebus.common.constants.ReadPropertyFromXmlBySpringBean;
import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;
import com.lantaiyuan.ebus.custom.dao.neighbouringtour.TouristSettingsMapper;
import com.lantaiyuan.ebus.custom.dao.travelaround.TravelAroundMapper;
import com.lantaiyuan.ebus.custom.model.BaseRoute;
import com.lantaiyuan.ebus.custom.model.neighbouringtour.TouristSettings;
import com.lantaiyuan.ebus.custom.model.neighbouringtour.TouristSettingsQueryModel;
import com.lantaiyuan.ebus.custom.model.travelaround.TravelAround;
import com.lantaiyuan.ebus.custom.model.travelaround.TravelAroundQueryModel;
import com.lantaiyuan.ebus.custom.service.BaseRouteServiceI;
import com.lantaiyuan.ebus.custom.service.NeighbouringTourServiceI;

/**
* <p>Title: NeighbouringTourServiceImpl</p>
* <p>Description: 周边游常用旅客业务实现类</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年7月17日 下午4:44:32
*/
@Service("neighbouringTourService")
public class NeighbouringTourServiceImpl extends BaseService<TouristSettings, TouristSettingsQueryModel>
		implements NeighbouringTourServiceI {
	@Resource
	private TouristSettingsMapper touristSettingsMapper;

	@Resource
	private TravelAroundMapper travelAroundMapper;

	@Resource
	private BaseRouteServiceI baseRouteService;

	/***
	 * <p>
	 * Title: findEntitiesByUserIdAndCityCode
	 * </p>
	 * <p>
	 * Description: 根据userId和cityCode查询该用户下的旅客信息
	 * </p>
	 * 
	 * @param userId
	 * @param cityCode
	 * @return
	 */
	@Override
	public List<TouristSettings> findEntitiesByUserIdAndCityCode(Integer userId, String cityCode) {
		return touristSettingsMapper.selectByUserIdAndCityCode(userId, cityCode);
	}

	/***
	 * <p>
	 * Title: saveOrUpdate
	 * </p>
	 * <p>
	 * Description: 插入或更新常用游客记录
	 * </p>
	 * 
	 * @param userAddressSetting
	 * @return
	 */
	@Override
	public boolean saveOrUpdate(TouristSettings touristSettings) {
		int rows = 0;

		if (StringUtils.isEmpty(touristSettings.getId())) {
			touristSettings.setId(UUID.randomUUID().toString());
			rows = touristSettingsMapper.insertSelective(touristSettings);
		} else {
			rows = touristSettingsMapper.updateByPrimaryKeySelective(touristSettings);
		}

		return rows > 0 ? true : false;
	}

	/***
	 * <p>
	 * Title: getDao
	 * </p>
	 * <p>
	 * Description: mapper具体化
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public BaseDAO<TouristSettings, TouristSettingsQueryModel> getDao() {
		return this.touristSettingsMapper;
	}

	@Override
	public Page<TravelAround> findEntityByPage(TravelAroundQueryModel model, int page) {
		model.getPageModel().setNowPage(page);
		if (!StringUtils.isEmpty(model.getCityCode()) && "-1".equals(model.getCityCode().trim())) {
			model.setCityCode(null);
		}
		List<TravelAround> list = travelAroundMapper.selectByPage(model);
		model.getPageModel().setRows(list);
		return model.getPageModel();
	}

	@Override
	public TravelAround findTravelAroundById(String id) {
		return this.travelAroundMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean updateTravelAround(TravelAround travelAround) {
		return travelAroundMapper.updateByPrimaryKeySelective(travelAround) > 0 ? true : false;
	}

	@Override
	public boolean addTravelAround(TravelAround travelAround) {
		return travelAroundMapper.insertSelective(travelAround) > 0 ? true : false;
	}

	@Override
	public boolean delTravelById(String id) {
		return travelAroundMapper.deleteByPrimaryKey(id) > 0 ? true : false;
	}

	@Override
	public List<BaseRoute> findSpecialLinesByCityCode(String cityCode) {
		return baseRouteService.findSpecialLines(cityCode, 2);
	}

	@Override
	public String getFilesUploadedPath(MultipartFile[] files) {
		StringBuilder attachpaths = new StringBuilder();
		// 获取文件服务器地址
		String FDS_ADDRESS_PRE = ReadPropertyFromXmlBySpringBean.getFdsAddressPre();
		if (files == null) {
			return "";
		}
		for (MultipartFile file : files) {
			// 默认扩展名“.jpg”
			String fileExtName = SysGlobalConstants.PICTURE_SUFFIX;
			String[] str = file.getOriginalFilename().split("\\.");
			if (str.length >= 2) {
				fileExtName = str[str.length - 1];
			}
			try {
				String uploadFile = FastDFSHelper.storageClient1.upload_file1(file.getBytes(), fileExtName, null);
				attachpaths.append(FDS_ADDRESS_PRE + uploadFile);
				attachpaths.append(',');
			} catch (IOException e) {
				logger.error("FastDFS系列化附件出错,具体错误信息:", e);
			} catch (MyException e) {
				logger.error("文件系统保存附件出错,具体错误信息:", e);
			}
		}
		String attachpathsStr = attachpaths.toString();
		return attachpathsStr.length() > 0 ? attachpathsStr.substring(0, attachpathsStr.length() - 1) : attachpathsStr;
	}
}
