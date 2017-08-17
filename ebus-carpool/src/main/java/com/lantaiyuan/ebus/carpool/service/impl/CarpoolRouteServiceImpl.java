package com.lantaiyuan.ebus.carpool.service.impl;

import com.lantaiyuan.ebus.carpool.dao.CarpoolRouteMapper;
import com.lantaiyuan.ebus.carpool.model.CarpoolRoute;
import com.lantaiyuan.ebus.carpool.model.CarpoolRouteQueryModel;
import com.lantaiyuan.ebus.carpool.service.CarpoolRouteService;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 拼车专线service
 *
 * @author yangyang
 * @date 2017/7/13 16:03
 * @email kekecany@163.com
 */
@Service("carpoolRouteService")
public class CarpoolRouteServiceImpl extends BaseService<CarpoolRoute, CarpoolRouteQueryModel> implements CarpoolRouteService {

    @Autowired
    private CarpoolRouteMapper carpoolRouteMapper;

    @Override
    public BaseDAO getDao() {
        return carpoolRouteMapper;
    }


    /**
     * 根据CarpoolRouteId有选择的更新拼车线路基本信息表
     *
     * @param carpoolRoute 拼车线路信息
     * @return 1：更新成功 0：更新失败
     */
    @Override
    public int updateByCarpoolRouteIdSelective(CarpoolRoute carpoolRoute) {
        return carpoolRouteMapper.updateByCarpoolRouteIdSelective(carpoolRoute);
    }

    /**
     * 查看该专线是否已经存在
     *
     * @param carpoolRouteId 拼车线路id
     * @return 1：已存在 0：未存在
     */
    @Override
    public int countCarpoolRouteId(String carpoolRouteId) {
        return carpoolRouteMapper.countCarpoolRouteId(carpoolRouteId);
    }
}
