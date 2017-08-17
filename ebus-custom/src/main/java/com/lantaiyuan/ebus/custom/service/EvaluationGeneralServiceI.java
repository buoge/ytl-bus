package com.lantaiyuan.ebus.custom.service;

import org.lanqiao.ssm.common.core.service.BaseServiceI;
import org.lanqiao.ssm.common.page.Page;

import com.lantaiyuan.ebus.custom.model.EvaluationGeneral;
import com.lantaiyuan.ebus.custom.model.EvaluationGeneralQueryModel;
import com.lantaiyuan.ebus.custom.model.SuggestionGroup;

/**
 * 描述:综合评价业务接口
 * 作者:温海金
 * 最后更改时间:下午4:04:50
 */
public interface EvaluationGeneralServiceI extends BaseServiceI<EvaluationGeneral, EvaluationGeneralQueryModel> {
	/***
	 *   
	* <p>Title: findEntityByPage</p>
	* <p>Description: 分页查询综合评价</p>
	* <p>author: liuhao</p>
	* 
	 */
	Page<EvaluationGeneral> findEntityByPage(EvaluationGeneralQueryModel model, int page);
	
	/***
	 *   
	* <p>Title: findEntityByPage</p>
	* <p>Description: 根据id组合查询</p>
	* <p>author: liuhao</p>
	* 
	 */
	SuggestionGroup findEntityById(String id, String cityCode);
}