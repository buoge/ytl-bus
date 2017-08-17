package com.lantaiyuan.ebus.realtime.dao;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.realtime.model.BdCommonSearch;
import com.lantaiyuan.ebus.realtime.model.BdCommonSearchQueryModel;

/***
 * 
* <p>Title: BdCommonSearchMapper</p>
* <p>Description: 大数据常用查询mybatis DAO</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年4月27日 下午4:37:49
 */
public interface BdCommonSearchMapper extends BaseDAO<BdCommonSearch,BdCommonSearchQueryModel>{
    int deleteByPrimaryKey(Integer id);

    int insert(BdCommonSearch record);

    int insertSelective(BdCommonSearch record);

    BdCommonSearch selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BdCommonSearch record);

    int updateByPrimaryKey(BdCommonSearch record);
    
    BdCommonSearch selectRouteStationByUserId(@Param("userId") String userId, @Param("cityCode") String cityCode);
}