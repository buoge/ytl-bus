package com.lantaiyuan.ebus.custom.service.impl;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.lanqiao.ssm.common.page.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lantaiyuan.ebus.custom.dao.SuggestionMapper;
import com.lantaiyuan.ebus.custom.model.Suggestion;
import com.lantaiyuan.ebus.custom.model.SuggestionQueryModel;
import com.lantaiyuan.ebus.custom.service.SuggestionServiceI;
/**
 * 描述:反馈建议业务实现类
 * 作者:温海金
 * 最后更改时间:下午6:17:12
 */
@Service("suggestionService")
public class SuggestionServiceImpl extends BaseService<Suggestion, SuggestionQueryModel> implements SuggestionServiceI {

	@Resource
	private SuggestionMapper suggestionMapper;
	
	@Override
	public BaseDAO<Suggestion, SuggestionQueryModel> getDao() {
		return suggestionMapper;
	}
	

	@Override
	public List<Suggestion> getSuggestTopicByUserId(Integer userid,String citycode) {
	    Map<String,String> paramMap = new HashMap<String,String>();
	    paramMap.put("userid", userid.toString());
	    paramMap.put("citycode", citycode);
	    List<Suggestion> suggestions = suggestionMapper.getSuggestTopicByUserId(paramMap);
	    suggestions.forEach(suggestion -> handleSuggestion(suggestion));//为建议加上系统最后反馈内容共前台显示
	    return suggestions;
	}
	/**
	 * 功能描述:为建议加上系统最后反馈内容共前台显示
	 * 作者:温海金
	 * 最后更改时间 : 2016年11月27日 上午4:39:27
	 */
	private void handleSuggestion(Suggestion suggestion) {
	    String entityId = suggestion.getId();
	    Suggestion sysLastReply = suggestionMapper.getSysLastReplySuggestionByTopicId(entityId);
	    if(sysLastReply!=null && sysLastReply.getContent()!=null){
		suggestion.setSysLastReply(sysLastReply.getContent());
	    }
	}

	@Override
	public List<SuggestionQueryModel> selectDetailListByEntityId(String entityid) {
	    List<Suggestion> suggestions = suggestionMapper.selectDetailListByEntityId(entityid);
	    List<SuggestionQueryModel> sugestionQms = new ArrayList<SuggestionQueryModel>();
	    for(Suggestion suggestion : suggestions) {
		SuggestionQueryModel suggestionQM = new SuggestionQueryModel();
		BeanUtils.copyProperties(suggestion, suggestionQM, "attapaths");
		String attapathsStr = suggestion.getAttachpaths();
		if(attapathsStr!=null && !"".equals(attapathsStr)) {
		    String[] attapathArr = attapathsStr.split("\\,");
		    suggestionQM.setAttachpaths(attapathArr);
		}else {
		    suggestionQM.setAttachpaths(new String[0]);
		}
		sugestionQms.add(suggestionQM);
	    }
	    return sugestionQms.size()>0 ? sugestionQms : Collections.emptyList();
	}

	@Override
	public Page<Suggestion> getSuggestionByPage(SuggestionQueryModel suggestionQM, int page) {
	    suggestionQM.getPageModel().setNowPage(page);
	    if(suggestionQM.getCitycode()!=null && "-1".equals(suggestionQM.getCitycode().trim())) {
		suggestionQM.setCitycode(null);
	    }
	    List<Suggestion> suggestions = suggestionMapper.getSuggestionByPage(suggestionQM);
	    suggestionQM.getPageModel().setRows(suggestions);
	    return suggestionQM.getPageModel();
	}
	
	@Override
	public int insertSelective(Suggestion suggestion) {
	    //更改主suggestion的lastUpdateTime
	    if(!StringUtils.isEmpty(suggestion.getTopicid())) {
		suggestionMapper.updateLastUpdateTime(suggestion.getTopicid(),new Date());
	    }
	    return super.insertSelective(suggestion);
	}
	
	/***
	 * 
	* <p>Title: insertThirdSelective</p>
	* <p>Description: 第三方插入</p>
	* @Author: liuhao
	 */
	@Override
	public int insertThirdSelective(Suggestion suggestion) {
	    return super.insertSelective(suggestion);
	}

	@Override
	public int insertSelective4reply(Suggestion suggestion) {
	    suggestion.setId(UUID.randomUUID().toString());
	    Byte messageType = 1;
	    suggestion.setMessagetype(messageType);
	    //更改主suggestion的lastUpdateTime
	    if(!StringUtils.isEmpty(suggestion.getTopicid())) {
		suggestionMapper.updateLastUpdateTime(suggestion.getTopicid(),new Date());
	    }
	    //新增系统回复信息
	    return super.insertSelective(suggestion);
	}
	
}
