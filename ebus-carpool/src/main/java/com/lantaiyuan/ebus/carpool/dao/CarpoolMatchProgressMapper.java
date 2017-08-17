package com.lantaiyuan.ebus.carpool.dao;

import com.lantaiyuan.ebus.carpool.model.CarpoolMatchProgress;
import com.lantaiyuan.ebus.carpool.model.CarpoolMatchProgressQueryModel;
import org.apache.ibatis.annotations.Mapper;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
@Mapper
public interface CarpoolMatchProgressMapper extends BaseDAO<CarpoolMatchProgress, CarpoolMatchProgressQueryModel>{
}