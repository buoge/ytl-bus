package com.lantaiyuan.ebus.custom.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.lanqiao.ssm.common.page.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;
import com.lantaiyuan.ebus.custom.dao.EvaluationMapper;
import com.lantaiyuan.ebus.custom.model.Evaluation;
import com.lantaiyuan.ebus.custom.model.EvaluationPieQueryModel;
import com.lantaiyuan.ebus.custom.model.EvaluationQueryModel;
import com.lantaiyuan.ebus.custom.model.EvaluationSecond;
import com.lantaiyuan.ebus.custom.model.EvaluationTag;
import com.lantaiyuan.ebus.custom.model.EvaluationTagQueryModel;
import com.lantaiyuan.ebus.custom.model.enummodel.EvaluationRankEnum;
import com.lantaiyuan.ebus.custom.service.EvaluationServiceI;
import com.lantaiyuan.ebus.custom.service.EvaluationTagServiceI;

@Service("evaluationService")
public class EvaluationServiceImpl extends BaseService<Evaluation, EvaluationQueryModel> implements EvaluationServiceI {
	@Resource
	private EvaluationMapper evaluationMapper;
	
	@Resource
	private EvaluationTagServiceI evaluationTagService;

	@Override
	public BaseDAO<Evaluation, EvaluationQueryModel> getDao() {
		return evaluationMapper;
	}

	@Override
	public String evaluate(Evaluation evaluation) {
		if (evaluation != null) {
			evaluationMapper.insertSelective(evaluation);
		}
		return "defult";
	}

	@Override
	public Page<Evaluation> selectByCityCode(String  cityCode,String routeName, String evaluatObjName, String userName, String startDate,
			String endDate, int page, int rows, String kind) {
		EvaluationQueryModel evaluationQueryModel = new EvaluationQueryModel();
		if (!StringUtils.isEmpty(cityCode)) {
			evaluationQueryModel.setCitycode(cityCode); 
		}
		if (!StringUtils.isEmpty(routeName)) {
			evaluationQueryModel.setRoutename(routeName);
		}
		if (!StringUtils.isEmpty(evaluatObjName)) {
			evaluationQueryModel.setEvaluatobjname(evaluatObjName);
		}
		if (!StringUtils.isEmpty(userName)) {
			evaluationQueryModel.setUsername(userName);
		}
		if (!StringUtils.isEmpty(startDate)) {
			evaluationQueryModel.setStartdate(startDate);
		}
		if (!StringUtils.isEmpty(endDate)) {
			evaluationQueryModel.setEnddate(endDate); 
		}
		evaluationQueryModel.setKind(kind);// 车辆(站台)评价标识
		evaluationQueryModel.getPageModel().setPageShow(rows);
		evaluationQueryModel.getPageModel().setNowPage(page);
		List<Evaluation> busEvalutionList = evaluationMapper.findEvalutionListByPage(evaluationQueryModel);
		evaluationQueryModel.getPageModel().setRows(busEvalutionList);
		return evaluationQueryModel.getPageModel();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<EvaluationPieQueryModel> queryEvaluationPie(String  cityCode) {
		EvaluationPieQueryModel[] evaluationPieQueryModels = {
			new EvaluationPieQueryModel(EvaluationRankEnum.WORST.rankName(),EvaluationRankEnum.WORST.score(),0),
			new EvaluationPieQueryModel(EvaluationRankEnum.BAD.rankName(),EvaluationRankEnum.BAD.score(),0),
			new EvaluationPieQueryModel(EvaluationRankEnum.COMMON.rankName(),EvaluationRankEnum.COMMON.score(),0),
			new EvaluationPieQueryModel(EvaluationRankEnum.FINE.rankName(),EvaluationRankEnum.FINE.score(),0),
			new EvaluationPieQueryModel(EvaluationRankEnum.GREAT.rankName(),EvaluationRankEnum.GREAT.score(),0)
		};
		EvaluationPieQueryModel evaluationPieQueryModel = new  EvaluationPieQueryModel();
		evaluationPieQueryModel.setCitycode(cityCode);
		evaluationPieQueryModel.getPageModel().setPageShow(20);
		evaluationPieQueryModel.getPageModel().setNowPage(1);
		List<Evaluation> busEvalutionList = evaluationMapper.findEvaluationPieByPage(evaluationPieQueryModel);
		if (!CollectionUtils.isEmpty(busEvalutionList)) {
			busEvalutionList.forEach(item->{  
				int score = (int) (item.getScore()*10);
				switch (score) {
				case SysGlobalConstants.EVALUATION__WORST_SCORE:
				case SysGlobalConstants.EVALUATION__TERRIBLE_SCORE:evaluationPieQueryModels[0].setCount(evaluationPieQueryModels[0].add(Integer.valueOf(item.getKind())));
						break;
				case SysGlobalConstants.EVALUATION__AWFUL_SCORE:
				case SysGlobalConstants.EVALUATION__WRONG_SCORE:evaluationPieQueryModels[1].setCount(evaluationPieQueryModels[1].add(Integer.valueOf(item.getKind())));
						break;
				case SysGlobalConstants.EVALUATION__BAD_SCORE:
				case SysGlobalConstants.EVALUATION__COMMON_SCORE:evaluationPieQueryModels[2].setCount(evaluationPieQueryModels[2].add(Integer.valueOf(item.getKind())));
						break;
				case SysGlobalConstants.EVALUATION__GOOD_SCORE:
				case SysGlobalConstants.EVALUATION__FINE_SCORE:evaluationPieQueryModels[3].setCount(evaluationPieQueryModels[3].add(Integer.valueOf(item.getKind())));
						break;
				case SysGlobalConstants.EVALUATION__GREAT_SCORE:evaluationPieQueryModels[4].setCount(evaluationPieQueryModels[4].add(Integer.valueOf(item.getKind())));
						break;
				default:break;		
				}
	        });  
		} 
		List<EvaluationPieQueryModel> returntList = new ArrayList<>();
		for (EvaluationPieQueryModel temp : evaluationPieQueryModels) {
			returntList.add(temp);
		}
		evaluationPieQueryModel.getPageModel().setRows(returntList);
		 return evaluationPieQueryModel.getPageModel();
	}
	
	/**
	 * 具体标签业务处理
	 * 温海金
	 */
	@Override
	public void handleTags(String tags,Byte starLevel) {
	    //1.标签处理,将标签串转化为数组
	    String[] tagArr = tags.split("\\|");
	    for(String tag : tagArr) {
		EvaluationTagQueryModel evaluationTagQueryModel = new EvaluationTagQueryModel();
		evaluationTagQueryModel.setTagName(tag);
		evaluationTagQueryModel.setStarLevel(starLevel.intValue());
		List<EvaluationTag> evaluationTags = evaluationTagService.selectByCondition(evaluationTagQueryModel);
		if(evaluationTags.size() == 0){
		    //2.如果数据库中没有tag标签，则新增
		    EvaluationTag evaluationTag = new EvaluationTag();
		    evaluationTag.setId(UUID.randomUUID().toString());
		    evaluationTag.setTagName(tag);
		    evaluationTag.setStarLevel(starLevel.intValue());
		    evaluationTag.setCount(0);
		    evaluationTagService.insertSelective(evaluationTag);
		} else{
		    //3.如果数据库中存在tag标签，则Count数量+1 
		    EvaluationTag evaluationTag = evaluationTags.get(0);
		    evaluationTag.setCount(evaluationTag.getCount()+1);
		    evaluationTagService.updateByPrimaryKeySelective(evaluationTag);
		}
	    }
	}
	
	/**
	 * 将用户自定义标签存储到数据库，将用户所选的评价标签在数据库中统计数+1
	 * 温海金
	 */
	@Override
	public void addTagOrTagCountIncrement(EvaluationSecond evaluationSecond) {
	    if (4 == evaluationSecond.getType() && !StringUtils.isEmpty(evaluationSecond.getTags())) {
	        //司机评价标签处理
	        handleTags(evaluationSecond.getTags(), evaluationSecond.getTypedetail());
	    }
	    if (4 == evaluationSecond.getType() 
		    && !StringUtils.isEmpty(evaluationSecond.getComment()) 
		    && evaluationSecond.getComment().length()<=4) {
	        //4代表是司机评价，（当comment长度不超过4个字）;需要提取 comment字段到标签
	        handleTags(evaluationSecond.getComment(), evaluationSecond.getTypedetail());
	    }
	}
}