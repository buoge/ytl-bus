package com.lantaiyuan.ebus.carpool.service;

import com.lantaiyuan.ebus.carpool.model.CarpoolRoute;
import com.lantaiyuan.ebus.carpool.model.CarpoolRouteQueryModel;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.service.BaseServiceI;

/**
 * 拼车专线信息service
 *
 * @author yangyang
 * @date 2017/7/13 16:02
 * @email kekecany@163.com
 */
public interface CarpoolRouteService extends BaseServiceI<CarpoolRoute, CarpoolRouteQueryModel> {

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
