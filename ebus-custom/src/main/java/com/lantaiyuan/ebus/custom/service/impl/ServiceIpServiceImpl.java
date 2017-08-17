package com.lantaiyuan.ebus.custom.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.shiro.util.CollectionUtils;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.lanqiao.ssm.common.page.Page;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lantaiyuan.ebus.custom.dao.ServiceIpMapper;
import com.lantaiyuan.ebus.custom.model.Cities;
import com.lantaiyuan.ebus.custom.model.FindAuth;
import com.lantaiyuan.ebus.custom.model.FindAuthProperty;
import com.lantaiyuan.ebus.custom.model.FindAuthPropertyWithHeadTitle;
import com.lantaiyuan.ebus.custom.model.ServiceIp;
import com.lantaiyuan.ebus.custom.model.ServiceIpQueryModel;
import com.lantaiyuan.ebus.custom.model.enummodel.FindAuthEnum;
import com.lantaiyuan.ebus.custom.model.enummodel.FindAuthServiceEnum;
import com.lantaiyuan.ebus.custom.service.ServiceIpServiceI;

/**
 * 描述:城市ip配置业务接口实现类 作者:温海金 最后更改时间:下午3:50:59
 */
@CacheConfig(cacheNames="cityCodes")
@Service("serviceIpService")
public class ServiceIpServiceImpl extends BaseService<ServiceIp, ServiceIpQueryModel> implements ServiceIpServiceI {

	@Resource
	private ServiceIpMapper serviceIpMapper;
	
	@Resource
	private ServiceIpServiceI serviceIpService;
	
	public BaseDAO<ServiceIp, ServiceIpQueryModel> getDao() {
		return serviceIpMapper;
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		int num = super.deleteByPrimaryKey(id);
		return num;
	}
	
	/**
	 * 功能描述:新增城市IP配置对象 作者:温海金 最后更改时间 : 2016年12月28日 下午2:22:56
	 */
	@Override
	public int insertSelective(ServiceIp record) {
		record.setId(UUID.randomUUID().toString());
		return super.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(ServiceIp record) {
		int num = super.updateByPrimaryKeySelective(record);
		return num;
	}

	/**
	 * 功能描述:分页查询城市IP配置对象列表 作者:温海金 最后更改时间 : 2016年12月28日 下午2:22:56
	 */
	@Override
	public Page<ServiceIp> findObjectsByPage(ServiceIpQueryModel serviceQM, int page) {
		serviceQM.getPageModel().setNowPage(page);
		List<ServiceIp> serviceIps = serviceIpMapper.findObjectsByPage(serviceQM);
		serviceQM.getPageModel().setRows(serviceIps);
		return serviceQM.getPageModel();
	}

	/**
	 * 获取所有城市
	 * 
	 * @auther yangyang
	 */
	@Override
	public List<ServiceIp> getCities(String cityCode) {
		List<ServiceIp> result = serviceIpMapper.getCitites(cityCode);
		if (CollectionUtils.isEmpty(result)) {
			result = Collections.emptyList();
		}
		if ("-1".equals(cityCode)) {
			result.add(0, new ServiceIp("所有城市", "-1"));
		}
		return result;
	}

	@Override
	public List<Cities> getCititesForMobile() {
		return serviceIpMapper.getCititesForMobile();
	}

	/**
	 * 获取发现权限
	 * 
	 * @author yangyang
	 */
	@Override
	public Integer selectAuthorityByCityCode(String cityCode) {
		return serviceIpMapper.selectAuthorityByCityCode(cityCode);
	}

	/**
	 * 根据cityCode查找城市的ip配置信息
	 * 
	 * @auther yangyang
	 */
	@Override
	public ServiceIp getServiceIp(String cityCode) {
		return serviceIpMapper.getServiceIp(cityCode);
	}
	
	
	/**
	 * 功能描述:获取所有的cityCode
	 * 作者:温海金
	 * 最后更改时间 : 2017年3月24日 下午4:54:35
	 */
	@Cacheable
	@Override
	public Set<String> getAllDistinctCityCodes() {
	    return serviceIpMapper.getAllDistinctCityCodes();
	}
	
	/**
	 * 返回城市发现模块权限
	 * @author yangyang
	 * @param cityCode
	 * @return
	 */
	@Cacheable
	@Override
	public FindAuth getCityFindAuth(String cityCode) {
		String authDesc = serviceIpMapper.selectAuthDescByCityCode(cityCode);
		if (StringUtils.isEmpty(authDesc)) {
			return null;
		}
		String[] authArray = authDesc.split(",");
		List<FindAuthProperty> busServiceList = new ArrayList<>();
		List<FindAuthProperty> customServiceList = new ArrayList<>();
		List<FindAuthProperty> thirdServiceList = new ArrayList<>();
		for (String auth: authArray) {
			FindAuthEnum findAuth = FindAuthEnum.getValueOf(auth);
			switch (findAuth.authServiceEnum()) {
			case BUS_SERVICE:
				busServiceList.add(new FindAuthProperty(findAuth));
				break;
			case CUSTOM_SERVICE:
				customServiceList.add(new FindAuthProperty(findAuth));
				break;
			case THIRD_SERVICE:
				thirdServiceList.add(new FindAuthProperty(findAuth));
				break;
			default:
				break;
			}
		}

		
		return new FindAuth(new FindAuthPropertyWithHeadTitle(
				FindAuthServiceEnum.BUS_SERVICE.title(), FindAuthServiceEnum.BUS_SERVICE.desc(),
				busServiceList),new FindAuthPropertyWithHeadTitle(
						FindAuthServiceEnum.CUSTOM_SERVICE.title(), FindAuthServiceEnum.CUSTOM_SERVICE.desc(),
						customServiceList),new FindAuthPropertyWithHeadTitle(
								FindAuthServiceEnum.THIRD_SERVICE.title(), FindAuthServiceEnum.THIRD_SERVICE.desc(),
								thirdServiceList));
	}

	
}
