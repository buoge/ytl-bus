package com.lantaiyuan.ebus.custom.service;

import org.lanqiao.ssm.common.core.service.BaseServiceI;
import org.lanqiao.ssm.common.page.Page;
import com.lantaiyuan.ebus.custom.model.Evaluation;
import com.lantaiyuan.ebus.custom.model.EvaluationPieQueryModel;
import com.lantaiyuan.ebus.custom.model.EvaluationQueryModel;
import com.lantaiyuan.ebus.custom.model.EvaluationSecond;

/**
 * 
  * @ClassName: EvaluationServiceI
  * Company:深圳市蓝泰源信息技术股份有限公司
  * @author Yuan.Tan
  * @date 2016年12月22日 下午1:58:19
 */
public interface EvaluationServiceI extends BaseServiceI<Evaluation, EvaluationQueryModel> {

	String evaluate(Evaluation evaluation);
 
	Page<Evaluation> selectByCityCode(String cityCode, String routeName, String evaluatObjName, String userName, String startDate,
			String endDate, int page, int rows, String kind);

	/**
	 * queryEvaluationPie(查询评价饼状数据 后期根据城市区分)
	 */
	Page<EvaluationPieQueryModel> queryEvaluationPie(String cityCode);
	
	void handleTags(String tags, Byte starLevel);

	void addTagOrTagCountIncrement(EvaluationSecond evaluationSecond);

}