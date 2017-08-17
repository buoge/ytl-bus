package com.lantaiyuan.ebus.custom.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.stereotype.Service;

import com.lantaiyuan.ebus.custom.dao.CommonQuestionMapper;
import com.lantaiyuan.ebus.custom.model.CommonQuestion;
import com.lantaiyuan.ebus.custom.model.CommonQuestionQueryModel;
import com.lantaiyuan.ebus.custom.service.CommonQuestionServiceI;

/**
 * 常见问题
 * @author yangyang
 * @date 2017年6月12日 下午2:07:23 
 *
 */
@Service("commonQuestionService")
public class CommonQuestionServiceImpl extends BaseService<CommonQuestion,CommonQuestionQueryModel> 
	implements CommonQuestionServiceI {

	@Resource
	private CommonQuestionMapper commonQuestionMapper;
	

	@Override
	public BaseDAO<CommonQuestion,CommonQuestionQueryModel> getDao() {
		return commonQuestionMapper;
	}

	/**
	 * 查出所有的常见问题
	 * @author yangyang
	 * @return
	 */
	@Override
	public List<CommonQuestion> selectAll() {
		return commonQuestionMapper.selectAll();
	}
	

}
