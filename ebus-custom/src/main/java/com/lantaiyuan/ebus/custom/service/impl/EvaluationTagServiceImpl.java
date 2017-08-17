package com.lantaiyuan.ebus.custom.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.stereotype.Service;

import com.lantaiyuan.ebus.custom.dao.EvaluationTagMapper;
import com.lantaiyuan.ebus.custom.model.EvaluationTag;
import com.lantaiyuan.ebus.custom.model.EvaluationTagQueryModel;
import com.lantaiyuan.ebus.custom.service.EvaluationTagServiceI;
/**
 * 描述:司机评价自定义标签业务实现类
 * 作者:温海金
 * 最后更改时间:下午4:12:31
 */
@Service("evaluationTagService")
public class EvaluationTagServiceImpl extends BaseService<EvaluationTag, EvaluationTagQueryModel> implements EvaluationTagServiceI {

    @Resource
    private EvaluationTagMapper evaluationTagMapper;
    
    @Override
    public BaseDAO<EvaluationTag, EvaluationTagQueryModel> getDao() {
	return evaluationTagMapper;
    }
	
    @Override
    public int insert(EvaluationTag record) {
	record.setId(UUID.randomUUID().toString());
	return super.insert(record);
    }
    
    @Override
    public int insertSelective(EvaluationTag record) {
	record.setId(UUID.randomUUID().toString());
        return super.insertSelective(record);
    }

    @Override
    public List<EvaluationTag> selectByCondition(EvaluationTagQueryModel evaluationTagQueryModel) {
	return evaluationTagMapper.selectByCondition(evaluationTagQueryModel);
    }

    @Override
    public List<EvaluationTag> getEvaluationTagByCountDesc(Integer starLevel) {
	EvaluationTagQueryModel evaluationTagQM = new EvaluationTagQueryModel();
	evaluationTagQM.setStarLevel(starLevel);
	return evaluationTagMapper.selectByByCountDesc(evaluationTagQM);
    }
}