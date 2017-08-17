package com.lantaiyuan.ebus.custom.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.lanqiao.ssm.common.page.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.google.common.base.Joiner;
import com.lantaiyuan.ebus.custom.dao.EvaluationGeneralMapper;
import com.lantaiyuan.ebus.custom.model.EvaluationGeneral;
import com.lantaiyuan.ebus.custom.model.EvaluationGeneralQueryModel;
import com.lantaiyuan.ebus.custom.model.EvaluationGeneralTag;
import com.lantaiyuan.ebus.custom.model.EvaluationGeneralTagQueryModel;
import com.lantaiyuan.ebus.custom.model.Suggestion;
import com.lantaiyuan.ebus.custom.model.SuggestionGroup;
import com.lantaiyuan.ebus.custom.model.SuggestionQueryModel;
import com.lantaiyuan.ebus.custom.service.EvaluationGeneralServiceI;
import com.lantaiyuan.ebus.custom.service.EvaluationGeneralTagServiceI;
import com.lantaiyuan.ebus.custom.service.SuggestionServiceI;
import com.xiaoleilu.hutool.util.BeanUtil;

@Service("evaluationGeneralService")
public class EvaluationGeneralServiceImpl extends BaseService<EvaluationGeneral, EvaluationGeneralQueryModel> implements EvaluationGeneralServiceI {
	
	@Resource
	private EvaluationGeneralMapper evaluationGeneralMapper;

	@Resource
	private EvaluationGeneralTagServiceI evaluationGeneralTagService;
	
	@Resource
	private SuggestionServiceI suggestionService;
	
	@Override
	public BaseDAO<EvaluationGeneral, EvaluationGeneralQueryModel> getDao() {
		return evaluationGeneralMapper;
	}
	
	@Override
	public int insertSelective(EvaluationGeneral record) {
		String id = UUID.randomUUID().toString();
		
		//存入base_suggestion表--->added by liuhao
		Suggestion suggestion = new Suggestion();
		suggestion.setUserid(record.getUserId());
		suggestion.setUsername(record.getUserName());
		suggestion.setContent(record.getComment());
		suggestion.setAttachpaths(record.getAttachPaths());
		suggestion.setCitycode(record.getCityCode());
		suggestion.setMessagetype((byte)0);
		suggestion.setTopicid(id);
		suggestionService.insertThirdSelective(suggestion);
		
		record.setId(id);
		handleEvaluationGeneralTag(record);
		return super.insertSelective(record);
	}

	/**
	 * 功能描述:处理综合评价标签信息
	 * 作者:温海金
	 * 最后更改时间 : 2017年6月12日 下午3:54:39
	 */
	public void handleEvaluationGeneralTag(EvaluationGeneral evaluationGeneral) {
		EvaluationGeneralTagQueryModel generalTagQueryModel = new EvaluationGeneralTagQueryModel();
		BeanUtil.copyProperties(evaluationGeneral, generalTagQueryModel);
		List<EvaluationGeneralTag> generalTags = evaluationGeneralTagService.findObjectsByCondition(generalTagQueryModel);
		if (generalTags.size() == 0) {
			EvaluationGeneralTag generalTag = new EvaluationGeneralTag();
			BeanUtil.copyProperties(evaluationGeneral, generalTag);
			generalTag.setId(UUID.randomUUID().toString());
			evaluationGeneralTagService.insertSelective(generalTag);
		} else {
			EvaluationGeneralTag evaluationGeneralTag = generalTags.get(0);
			Integer count = evaluationGeneralTag.getCount();
			evaluationGeneralTag.setCount(count+1);
			evaluationGeneralTagService.updateByPrimaryKey(evaluationGeneralTag);
		}
	}
	
	@Override
	public Page<EvaluationGeneral> findEntityByPage(EvaluationGeneralQueryModel model, int page) {
		model.getPageModel().setNowPage(page);
		if(!StringUtils.isEmpty(model.getCityCode()) && "-1".equals(model.getCityCode().trim())) {
			model.setCityCode(null);
		}
		List<EvaluationGeneral> list = evaluationGeneralMapper.selectByPage(model);
		model.getPageModel().setRows(list);
		return model.getPageModel();
	}
	
	@Override
	public SuggestionGroup findEntityById(String id, String cityCode) {
		EvaluationGeneral evaluationGeneral = evaluationGeneralMapper.selectById(id, cityCode);
		List<SuggestionQueryModel> suggestionQueryModels = suggestionService.selectDetailListByEntityId(id);
		
		List<Suggestion> suggestions = new ArrayList<>();
		suggestionQueryModels.forEach(model -> {
			Suggestion suggestion = new Suggestion();
			BeanUtil.copyProperties(model, suggestion);
			
			//将数组转为字符串拼接","
			String[] attachPaths = model.getAttachpaths();
			String s = "";
			if((attachPaths.length > 1)){
				s = Joiner.on(",").skipNulls().join(attachPaths);
			}
			else if(attachPaths.length > 0){
				s = attachPaths[0];
			}
			
			suggestion.setAttachpaths(s);
			suggestions.add(suggestion);
		});
		
		return new SuggestionGroup(evaluationGeneral,suggestions);
	}
}