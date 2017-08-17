package com.lantaiyuan.ebus.carpool.dao;

import com.lantaiyuan.ebus.carpool.model.CarpoolRouteStation;
import com.lantaiyuan.ebus.carpool.model.CarpoolRouteStationQueryModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import java.util.List;

@Mapper
public interface CarpoolRouteStationMapper extends BaseDAO<CarpoolRouteStation, CarpoolRouteStationQueryModel> {

    /**
     * 删除carpoolRouteId专线的线站关系
     *
     * @param carpoolRouteId 拼车专线id
     * @return 返回删除的数目
     */
    int deleteByCarpoolRouteId(String carpoolRouteId);

    /**
     * 批量插入该拼车专线的线站关系
     *
     * @param carpoolRouteStations 线站关系list
     * @return 返回插入的数量
     */
    int insertBatch(@Param("carpoolRouteStations") List<CarpoolRouteStation> carpoolRouteStations);
}