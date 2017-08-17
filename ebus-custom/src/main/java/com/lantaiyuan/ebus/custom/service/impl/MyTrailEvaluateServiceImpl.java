package com.lantaiyuan.ebus.custom.service.impl;

import java.util.UUID;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.stereotype.Service;

import com.lantaiyuan.ebus.custom.dao.MyTrailEvaluateMapper;
import com.lantaiyuan.ebus.custom.model.MyTrailEvaluate;
import com.lantaiyuan.ebus.custom.model.MyTrailEvaluateQueryModel;
import com.lantaiyuan.ebus.custom.service.MyTrailEvaluateServiceI;

/**
 * 描述:我的行程评价业务实现类
 * 作者:温海金
 * 最后更改时间:上午10:37:50
 */
@Service
public class MyTrailEvaluateServiceImpl extends BaseService<MyTrailEvaluate, MyTrailEvaluateQueryModel> implements MyTrailEvaluateServiceI {

    @Resource
    private MyTrailEvaluateMapper myTrailEvaluateMapper;

    @Override
    public int insert(MyTrailEvaluate record) {
	record.setId(UUID.randomUUID().toString());
	return super.insert(record);
    }

    @Override
    public int insertSelective(MyTrailEvaluate record) {
	record.setId(UUID.randomUUID().toString());
	return super.insertSelective(record);
    }

    @Override
    public BaseDAO<MyTrailEvaluate, MyTrailEvaluateQueryModel> getDao() {
	return myTrailEvaluateMapper;
    }

}
