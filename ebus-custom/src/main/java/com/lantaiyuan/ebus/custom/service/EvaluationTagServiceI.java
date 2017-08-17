package com.lantaiyuan.ebus.custom.service;

import java.util.List;

import org.lanqiao.ssm.common.core.service.BaseServiceI;
import com.lantaiyuan.ebus.custom.model.EvaluationTag;
import com.lantaiyuan.ebus.custom.model.EvaluationTagQueryModel;
/**
 * 描述:司机评价标签自定义处理
 * 作者:温海金
 * 最后更改时间:下午4:09:39
 */
public interface EvaluationTagServiceI extends BaseServiceI<EvaluationTag, EvaluationTagQueryModel> {

    List<EvaluationTag> selectByCondition(EvaluationTagQueryModel evaluationTagQueryModel);

    List<EvaluationTag> getEvaluationTagByCountDesc(Integer starLevel);
}