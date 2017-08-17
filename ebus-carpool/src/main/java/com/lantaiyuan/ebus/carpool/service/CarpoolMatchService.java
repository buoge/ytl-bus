package com.lantaiyuan.ebus.carpool.service;

import com.lantaiyuan.ebus.carpool.model.CarpoolMatch;
import com.lantaiyuan.ebus.carpool.model.CarpoolMatchDetail;
import com.lantaiyuan.ebus.carpool.model.CarpoolMatchQueryModel;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.service.BaseServiceI;

/**
 * 大拼车订单service
 *
 * @author yangyang
 * @date 2017/7/13 13:39
 * @email kekecany@163.com
 */
public interface CarpoolMatchService extends BaseServiceI<CarpoolMatch, CarpoolMatchQueryModel>{

    /**
     * 查看该matchId是否存在
     *
     * @param matchId 要查看的matchId
     * @return 存在的数目
     */
    int countMatchId(String matchId);


    /**
     * 有选择的更新拼车大订单
     *
     * @param carpoolMatch 大订单信息
     * @return 1：更新成功，0：更新失败
     */
    int updateByMatchIdSelective(CarpoolMatch carpoolMatch);

    /**
     * 根据matchId返回该拼车的发车时间和小订单信息
     *
     * @param matchId 拼车id
     * @return 返回拼车详情
     *
     * @author yangyang
     * @date 2017/7/18 16:33
     */
    CarpoolMatchDetail matchDetail(@Param("matchId") String matchId);
}
