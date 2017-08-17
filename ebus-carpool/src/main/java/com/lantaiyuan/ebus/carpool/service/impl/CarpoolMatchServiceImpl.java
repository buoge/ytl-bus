package com.lantaiyuan.ebus.carpool.service.impl;

import com.lantaiyuan.ebus.carpool.dao.CarpoolMatchMapper;
import com.lantaiyuan.ebus.carpool.model.CarpoolMatch;
import com.lantaiyuan.ebus.carpool.model.CarpoolMatchDetail;
import com.lantaiyuan.ebus.carpool.model.CarpoolMatchQueryModel;
import com.lantaiyuan.ebus.carpool.service.CarpoolMatchService;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 大拼车订单service
 *
 * @author yangyang
 * @date 2017/7/13 13:40
 * @email kekecany@163.com
 */
@Service("carpoolMatchService")
public class CarpoolMatchServiceImpl extends BaseService<CarpoolMatch, CarpoolMatchQueryModel> implements CarpoolMatchService {

    @Autowired
    private CarpoolMatchMapper carpoolMatchMapper;

    @Override
    public BaseDAO<CarpoolMatch, CarpoolMatchQueryModel> getDao() {
        return carpoolMatchMapper;
    }

    /**
     * 查看该matchId是否存在
     *
     * @param matchId 要查看的matchId
     * @return 存在的数目
     */
    @Override
    public int countMatchId(String matchId) {
        return carpoolMatchMapper.countMatchId(matchId);
    }

    /**
     * 根据matchId有选择的更新拼车大订单
     *
     * @param carpoolMatch 大订单信息
     * @return 1：更新成功，0：更新失败
     */
    @Override
    public int updateByMatchIdSelective(CarpoolMatch carpoolMatch) {
        return carpoolMatchMapper.updateByMatchIdSelective(carpoolMatch);
    }

    /**
     * 根据matchId返回该拼车的发车时间和小订单信息
     *
     * @param matchId 拼车id
     * @return 返回拼车详情
     * @author yangyang
     * @date 2017/7/18 16:33
     */
    @Override
    public CarpoolMatchDetail matchDetail(String matchId) {
        return carpoolMatchMapper.matchDetail(matchId);
    }


}
