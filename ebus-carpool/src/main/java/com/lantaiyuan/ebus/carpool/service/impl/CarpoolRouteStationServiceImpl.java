package com.lantaiyuan.ebus.carpool.service.impl;

import com.lantaiyuan.ebus.carpool.dao.CarpoolRouteStationMapper;
import com.lantaiyuan.ebus.carpool.model.CarpoolRouteStation;
import com.lantaiyuan.ebus.carpool.model.CarpoolRouteStationQueryModel;
import com.lantaiyuan.ebus.carpool.service.CarpoolRouteStationService;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 拼车专线线站关系service
 *
 * @author yangyang
 * @date 2017/7/13 16:57
 * @email kekecany@163.com
 */
@Service("carpoolRouteStationService")
public class CarpoolRouteStationServiceImpl extends BaseService<CarpoolRouteStation, CarpoolRouteStationQueryModel> implements CarpoolRouteStationService {

    @Autowired
    private CarpoolRouteStationMapper carpoolRouteStationMapper;

    @Override
    public BaseDAO getDao() {
        return carpoolRouteStationMapper;
    }

    /**
     * 删除carpoolRouteId专线的线站关系
     *
     * @param carpoolRouteId 拼车专线id
     * @return 返回删除的数目
     */
    @Override
    public int deleteByCarpoolRouteId(String carpoolRouteId) {
        return carpoolRouteStationMapper.deleteByCarpoolRouteId(carpoolRouteId);
    }

    /**
     * 批量插入该拼车专线的线站关系
     *
     * @param carpoolRouteStations 线站关系list
     * @return 返回插入的数量
     */
    @Override
    public int insertBatch(List<CarpoolRouteStation> carpoolRouteStations) {
        return carpoolRouteStationMapper.insertBatch(carpoolRouteStations);
    }


}
