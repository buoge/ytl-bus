package com.lantaiyuan.ebus.carpool.service.impl;

import com.lantaiyuan.ebus.carpool.dao.CarpoolOrderMapper;
import com.lantaiyuan.ebus.carpool.model.*;
import com.lantaiyuan.ebus.carpool.service.CarpoolOrderService;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 单个用户拼车订单service
 *
 * @author yangyang
 * @date 2017/7/13 10:17
 * @email kekecany@163.com
 */
@Service("carpoolOrderService")
public class CarpoolOrderServiceImpl extends BaseService<CarpoolOrder, CarpoolOrderQueryModel> implements CarpoolOrderService {

    @Autowired
    private CarpoolOrderMapper carpoolOrderMapper;

    @Override
    public BaseDAO<CarpoolOrder, CarpoolOrderQueryModel> getDao() {
        return carpoolOrderMapper;
    }


    /**
     * 根据orderNo有选择地更新数据
     *
     * @param carpoolOrder 订单信息
     * @return 1：更新成功，0：更新失败
     */
    @Override
    public int updateByOrderNoSelective(CarpoolOrder carpoolOrder) {
        return carpoolOrderMapper.updateByOrderNoSelective(carpoolOrder);
    }

    /**
     * 根据matchId查询出该大拼车订单下的所有小拼车订单
     *
     * @param matchId 拼车id
     * @return 返回该拼车id下的所有小拼车订单
     */
    @Override
    public List<CarpoolOrder> selectByMatchId(String matchId) {
        return carpoolOrderMapper.selectByMatchId(matchId);
    }

    /**
     * 根据订单号查询出拼车订单信息
     *
     * @param orderNo 订单号
     * @return 返回拼车订单信息
     *
     * @author yangyang
     * @date 2017/7/18 16:56
     */
    @Override
    public CarpoolOrder selectByOrderNo(String orderNo) {
        return carpoolOrderMapper.selectByOrderNo(orderNo);
    }


}
