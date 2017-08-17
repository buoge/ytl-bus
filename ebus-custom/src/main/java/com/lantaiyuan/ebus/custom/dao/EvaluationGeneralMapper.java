package com.lantaiyuan.ebus.custom.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.custom.model.EvaluationGeneral;
import com.lantaiyuan.ebus.custom.model.EvaluationGeneralQueryModel;

public interface EvaluationGeneralMapper extends BaseDAO<EvaluationGeneral, EvaluationGeneralQueryModel>{
	/***
	 *   
	* <p>Title: selectByPage</p>
	* <p>Description: 分页查询综合评价</p>
	* <p>author: liuhao</p>
	* 
	 */
	List<EvaluationGeneral> selectByPage(EvaluationGeneralQueryModel model);
	
	/***
	 *   
	* <p>Title: selectById</p>
	* <p>Description: 单项查询综合评价</p>
	* <p>author: liuhao</p>
	* 
	 */
	EvaluationGeneral selectById(@Param("id") String id, @Param("cityCode") String cityCode);
}