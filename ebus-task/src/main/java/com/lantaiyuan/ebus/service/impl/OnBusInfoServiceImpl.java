package com.lantaiyuan.ebus.service.impl;

import javax.annotation.Resource;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.stereotype.Service;
import com.lantaiyuan.ebus.dao.OnBusInfoMapper;
import com.lantaiyuan.ebus.model.OnBusInfo;
import com.lantaiyuan.ebus.model.OnBusInfoQueryModel;
import com.lantaiyuan.ebus.service.OnBusInfoServiceI;

/**
 * 
 * @ClassName: OnBusInfoServiceImpl 
 * Company:深圳市蓝泰源信息技术股份有限公司
 * @author Yuan.Tan
 * @date 2016年12月22日 下午2:03:40
 */
@Service("onBusInfoService")
public class OnBusInfoServiceImpl extends BaseService<OnBusInfo, OnBusInfoQueryModel> implements OnBusInfoServiceI {
	@Resource
	private OnBusInfoMapper onBusInfoMapper;

	@Override
	public BaseDAO<OnBusInfo, OnBusInfoQueryModel> getDao() {
		return onBusInfoMapper;
	}
}