package com.lantaiyuan.ebus.realtime.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.realtime.model.BaseFavoriteTag;
import com.lantaiyuan.ebus.realtime.model.BaseFavoriteTagQueryModel;

/***
 * 
* <p>Title: BaseFavoriteTagMapper</p>
* <p>Description: 用户自定义标签相关接口</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年4月26日 下午8:42:13
 */
public interface BaseFavoriteTagMapper extends BaseDAO<BaseFavoriteTag,BaseFavoriteTagQueryModel>{
    int deleteByPrimaryKey(Integer id);

    int insert(BaseFavoriteTag record);

    int insertSelective(BaseFavoriteTag record);

    BaseFavoriteTag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseFavoriteTag record);

    int updateByPrimaryKey(BaseFavoriteTag record);
    
    int queryCountByName(@Param("name") String name, @Param("userId") String userId, @Param("cityCode") String cityCode);
    
    int queryCountById(@Param("id") String id, @Param("userId") String userId, @Param("cityCode") String cityCode);
    
    List<String> queryCollectionTagsByUserId(@Param("userId") String userId, @Param("cityCode") String cityCode);
}