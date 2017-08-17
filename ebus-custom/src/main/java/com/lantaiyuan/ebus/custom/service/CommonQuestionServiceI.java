package com.lantaiyuan.ebus.custom.service;

import java.util.List;

import org.lanqiao.ssm.common.core.service.BaseServiceI;

import com.lantaiyuan.ebus.custom.model.CommonQuestion;
import com.lantaiyuan.ebus.custom.model.CommonQuestionQueryModel;

/**
 * 常见问题
 * @author yangyang
 * @date 2017年6月12日 下午2:09:07 
 *
 */
public interface CommonQuestionServiceI extends BaseServiceI<CommonQuestion, CommonQuestionQueryModel>{

	/**
	 * 查出所有的常见问题
	 * @author yangyang
	 * @return
	 */
	List<CommonQuestion> selectAll();

	
}
