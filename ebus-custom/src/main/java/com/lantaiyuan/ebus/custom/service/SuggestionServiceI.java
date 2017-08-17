package com.lantaiyuan.ebus.custom.service;


import java.util.List;

import org.lanqiao.ssm.common.core.service.BaseServiceI;
import org.lanqiao.ssm.common.page.Page;

import com.lantaiyuan.ebus.custom.model.Suggestion;
import com.lantaiyuan.ebus.custom.model.SuggestionQueryModel;
/**
 * 描述:反馈建议业务层接口
 * 作者:温海金
 * 最后更改时间:下午6:16:24
 */
public interface SuggestionServiceI extends BaseServiceI<Suggestion, SuggestionQueryModel> {

   List<Suggestion> getSuggestTopicByUserId(Integer userid,String citycode);

   List<SuggestionQueryModel> selectDetailListByEntityId(String entityid);

   Page<Suggestion> getSuggestionByPage(SuggestionQueryModel suggestionQM, int page);

   int insertSelective4reply(Suggestion suggestion);
   
   /***
    * 
   * <p>Title: insertThirdSelective</p>
   * <p>Description: 第三方插入</p>
   * @Author liuhao
    */
   int insertThirdSelective(Suggestion suggestion);

}
