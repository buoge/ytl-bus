package com.lantaiyuan.ebus.custom.service;

import java.util.List;

import org.lanqiao.ssm.common.core.service.BaseServiceI;
import com.lantaiyuan.ebus.custom.model.EvaluationGeneralTag;
import com.lantaiyuan.ebus.custom.model.EvaluationGeneralTagQueryModel;

/**
 * 描述:综合评价自定义标签业务接口
 * 作者:温海金
 * 最后更改时间:下午3:00:17
 */
public interface EvaluationGeneralTagServiceI extends BaseServiceI<EvaluationGeneralTag, EvaluationGeneralTagQueryModel> {
	/**
	 * 功能描述:根据查询对象查找标签列表
	 * 作者:温海金
	 * 最后更改时间 : 2017年6月12日 下午3:40:07
	 */
	List<EvaluationGeneralTag> findObjectsByCondition(EvaluationGeneralTagQueryModel generalTagQueryModel);

	/**
	 * 功能描述:查询评价所给星级组合中用户评价最频繁的标签
	 * 作者:温海金
	 * 最后更改时间 : 2017年6月12日 下午4:07:14
	 */
	EvaluationGeneralTag getEvaluationGeneralTagByAllStars(EvaluationGeneralTagQueryModel generalTagQueryModel);
	
}