package com.lantaiyuan.ebus.custom.dao;

import java.util.List;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import com.lantaiyuan.ebus.custom.model.EvaluationTag;
import com.lantaiyuan.ebus.custom.model.EvaluationTagQueryModel;
/**
 * 描述:自定义评价标签dao持久层
 * 作者:温海金
 * 最后更改时间:上午11:48:54
 */
public interface EvaluationTagMapper  extends BaseDAO<EvaluationTag, EvaluationTagQueryModel>{
    List<EvaluationTag> selectByCondition(EvaluationTagQueryModel evaluationTagQueryModel);

    List<EvaluationTag> selectByByCountDesc(EvaluationTagQueryModel evaluationTagQM);

}