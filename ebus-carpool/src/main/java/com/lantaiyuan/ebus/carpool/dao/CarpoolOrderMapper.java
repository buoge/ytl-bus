package com.lantaiyuan.ebus.carpool.dao;

import com.lantaiyuan.ebus.carpool.model.CarpoolOrder;
import com.lantaiyuan.ebus.carpool.model.CarpoolOrderQueryModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface CarpoolOrderMapper extends BaseDAO<CarpoolOrder, CarpoolOrderQueryModel> {

    /**
     * 根据orderNo有选择地更新数据
     *
     * @param carpoolOrder 订单信息
     * @return 1：更新成功，0：更新失败
     */
    int updateByOrderNoSelective(CarpoolOrder carpoolOrder);

    /**
     * 根据matchId查询出该大拼车订单下的所有小拼车订单
     *
     * @param matchId 拼车id
     * @return 返回该拼车id下的所有小拼车订单
     */
    List<CarpoolOrder> selectByMatchId(@Param("matchId") String matchId);

    /***
     * 
    * <p>Title: selectBySendStatus</p>
    * <p>Description: 获取满足特定需求的List</p>
    * @param matchId
    * @param sendStatus
    * @return
     */
    List<CarpoolOrder> selectBySendStatus(@Param("type")Integer type);
  
    /***
     * 
    * <p>Title: updateOrdersSentToKafkaStatus</p>
    * <p>Description: 更新指定订单号发送状态</p>
    * @param orderNos
    * @return
     */
    int updateOrdersSentToKafkaStatus(@Param("orderNos")List<String>  orderNos, @Param("sendStatus")Integer sendStatus);
    
    /***
     * 
    * <p>Title: updateOrderByOrderNo</p>
    * <p>Description: 处理大数据返回的RESTfull成功结果，同步至carpool_order</p>
    * @param orderNo
    * @param matchStatus
    * @param sendStatus
    * @return
     */
    int updateOrderByOrderNoIfSucceed(@Param("orderNo")String orderNo, @Param("matchStatus")Integer matchStatus, @Param("sendStatus")Integer sendStatus);
   
    /***
     * 
    * <p>Title: updateOrderByOrderNoIfFailed</p>
    * <p>Description: 处理大数据返回的RESTfull失败结果，同步至carpool_order</p>
    * @param orderNo
    * @param matchStatus
    * @param sendStatus
    * @param newMatchId
    * @param oldMatchId
    * @return
     */
    int updateOrderByOrderNoIfFailed(@Param("orderNo")String orderNo, @Param("matchStatus")Integer matchStatus, @Param("sendStatus")Integer sendStatus, @Param("newMatchId")String newMatchId, @Param("oldMatchId")String oldMatchId);
    /***
     * 
    * <p>Title: selectByMatchStatusAndRepayFlag</p>
    * <p>Description: 获取需要补差价的用户订单List</p>
    * @param matchStatus
    * @param repayStatus
    * @return
     */
    List<CarpoolOrder> selectByMatchStatusAndRepayFlag(@Param("matchStatus")Integer matchStatus, @Param("repayStatus")Integer repayStatus);

    /***
     * 
    * <p>Title: updateCarpoolRepayPrice</p>
    * <p>Description: 补差价操作</p>
    * @param orderNo
    * @param repayStatus
    * @param repayDiffVal
    * @return
     */
    int updateCarpoolRepayPrice(@Param("orderNo")String orderNo, @Param("repayStatus")Integer repayStatus, @Param("repayDiffVal")BigDecimal repayDiffVal);

    /**
     * 根据订单号查询出拼车订单信息
     *
     * @param orderNo 订单号
     * @return 返回拼车订单信息
     *
     * @author yangyang
     * @date 2017/7/18 16:56
     */
    CarpoolOrder selectByOrderNo(@Param("orderNo") String orderNo);
    
    /***
     * 
    * <p>Title: selectRecordsToDrawback</p>
    * <p>Description: 获取需要退款的记录</p>
    * @return
     */
    List<String> selectRecordsToDrawback();
}