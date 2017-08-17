package com.lantaiyuan.ebus.carpool.dao;

import com.lantaiyuan.ebus.carpool.model.CarpoolRoute;
import com.lantaiyuan.ebus.carpool.model.CarpoolRouteQueryModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

@Mapper
public interface CarpoolRouteMapper extends BaseDAO<CarpoolRoute, CarpoolRouteQueryModel> {

    /**
     * 根据CarpoolRouteId有选择的更新拼车线路基本信息表
     *
     * @param carpoolRoute 拼车线路信息
     * @return 1：更新成功 0：更新失败
     */
    int updateByCarpoolRouteIdSelective(CarpoolRoute carpoolRoute);

    /**
     * 查看该专线是否已经存在
     *
     * @param carpoolRouteId 拼车线路id
     * @return 1：已存在 0：未存在
     */
    int countCarpoolRouteId(@Param("carpoolRouteId") String carpoolRouteId);

}