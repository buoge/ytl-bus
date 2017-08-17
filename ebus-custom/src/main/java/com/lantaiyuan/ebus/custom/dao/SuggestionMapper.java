package com.lantaiyuan.ebus.custom.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.custom.model.Suggestion;
import com.lantaiyuan.ebus.custom.model.SuggestionQueryModel;
/**
 * 描述:反馈建议数据访问层接口
 * 作者:温海金
 * 最后更改时间:下午6:17:39
 */
public interface SuggestionMapper extends BaseDAO<Suggestion, SuggestionQueryModel>{

    List<Suggestion> getSuggestTopicByUserId(Map<String,String> map);

    Suggestion getSysLastReplySuggestionByTopicId(String entityId);

    List<Suggestion> selectDetailListByEntityId(String entityid);

    List<Suggestion> getSuggestionByPage(SuggestionQueryModel suggestionQM);

    int updateLastUpdateTime(@Param(value="topicid") String topicid, @Param(value="currenttime") Date currenttime);
    
}