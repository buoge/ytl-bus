package com.lantaiyuan.ebus.custom.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.custom.model.CustomLineApplication;
import com.lantaiyuan.ebus.custom.model.CustomLineApplicationQueryModel;

public interface CustomLineApplicationMapper extends BaseDAO<CustomLineApplication, CustomLineApplicationQueryModel>{

    int findPaticalNumByLineId(String lineId);

    List<CustomLineApplication> findByLineId(String lineid);
    
    List<CustomLineApplication> findByLineId2(String lineid);
    
    List<CustomLineApplication> getByLineId(@Param("lineId")String lineId,@Param("list")List<String> list);
    
    /**
     * 分页查询专线
     * @auther yangyang
     * @param model
     * @return
     */
    List<CustomLineApplication> findCustomLineSubListByPage(CustomLineApplicationQueryModel model);
  
    
}