/**
 * <p>Title: TaskTimerServiceImpl.java</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: lty</p>
 */
package com.lantaiyuan.ebus.carpool.service.impl;

import com.alibaba.fastjson.JSON;
import com.lantaiyuan.ebus.carpool.dao.CarpoolOrderMapper;
import com.lantaiyuan.ebus.carpool.model.CarpoolOrder;
import com.lantaiyuan.ebus.carpool.model.CarpoolOrderQueryModel;
import com.lantaiyuan.ebus.carpool.model.kafkamodel.Result;
import com.lantaiyuan.ebus.carpool.model.kafkamodel.ReturnResult;
import com.lantaiyuan.ebus.carpool.model.kafkamodel.UserCarpoolBasic;
import com.lantaiyuan.ebus.carpool.rest.RestTask;
import com.lantaiyuan.ebus.carpool.service.TaskTimerServiceI;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: TaskTimerServiceImpl</p>
 * <p>Description: 定时器业务类</p>
 * <p>Company: lty</p>
 * @author liuhao
 * @date 2017年7月13日 下午1:52:22
 */
@Service("taskTimerService")
public class TaskTimerServiceImpl extends BaseService<CarpoolOrder, CarpoolOrderQueryModel> implements TaskTimerServiceI {
    @Autowired
    private CarpoolOrderMapper carpoolOrderMapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private RestTask restTask;


    /***
     * <p>Title: getDao</p>
     * <p>Description: </p>
     * @return
     */
    @Override
    public BaseDAO<CarpoolOrder, CarpoolOrderQueryModel> getDao() {
        return this.carpoolOrderMapper;
    }

    /***
     * <p>Title: selectBySendStatus</p>
     * <p>Description: 处理拼车订单发送到kafka业务逻辑</p>
     * @param matchId
     * @param sendStatus
     * @return
     */
    @Override
    public int handleUsersInitiatingCarpool(Integer type) {
        List<CarpoolOrder> carpoolOrders = carpoolOrderMapper.selectBySendStatus(type);

        List<String> orderNos = new ArrayList<>();

        List<UserCarpoolBasic> userCarpoolBasics = new ArrayList<>();
        carpoolOrders.forEach(carpoolOrder -> {
            orderNos.add(carpoolOrder.getOrderNo());
            userCarpoolBasics.add(UserCarpoolBasic.parse(carpoolOrder));
        });

        userCarpoolBasics.forEach(userCarpoolBasic -> kafkaTemplate.sendDefault(JSON.toJSONString(userCarpoolBasic)));
        if (!CollectionUtils.isEmpty(carpoolOrders)) {
            carpoolOrderMapper.updateOrdersSentToKafkaStatus(orderNos, 1);
        }

        return carpoolOrders.size();
    }

    /***
     * <p>Title: handleUsersJoiningCarpool</p>
     * <p>Description: 处理加入已有拼车订单业务逻辑</p>
     * @param matchId
     * @param sendStatus
     * @return
     */
    @Override
    public int handleUsersJoiningCarpool(Integer type) {
        List<CarpoolOrder> carpoolOrders = carpoolOrderMapper.selectBySendStatus(type);
        //TODO 处理加入拼车请求，调用大数据RESTfull接口
        if (CollectionUtils.isEmpty(carpoolOrders)) {
            return 0;
        }
        carpoolOrders.forEach(carpoolOrder -> {
            ReturnResult returnResult = restTask.invokeUrl(UserCarpoolBasic.parse(carpoolOrder));
            // restful接口调用成功
            if (!StringUtils.isEmpty(returnResult) && returnResult.getStatusCode() == HttpStatus.OK.value()) {
                Result obj = returnResult.getObj();
                if (obj.getMatchStatus() == 1) { //加入成功
                    carpoolOrderMapper.updateOrderByOrderNoIfSucceed(obj.getOrderNo(), obj.getMatchStatus(), 1);
                } else { // 加入失败
                    carpoolOrderMapper.updateOrderByOrderNoIfFailed(obj.getOrderNo(), obj.getMatchStatus(), 1, null, obj.getOldMatchId());
                }
            }
        });
        return carpoolOrders.size();
    }

    /***
     * <p>Title: handleUsersCompensatingCarpool</p>
     * <p>Description: 处理补差价业务逻辑</p>
     * @param matchStatus
     * @param repayStatus
     * @return
     */
    @Override
    public int handleUsersCompensatingCarpool(Integer matchStatus, Integer repayStatus) {
        List<CarpoolOrder> carpoolOrders = carpoolOrderMapper.selectByMatchStatusAndRepayFlag(matchStatus, repayStatus);

        if (!CollectionUtils.isEmpty(carpoolOrders)) {
            carpoolOrders.forEach(carpoolOrder -> {
                BigDecimal diffVal = carpoolOrder.getRealPrice().subtract(carpoolOrder.getPaidPrice());
                //需要补差价
                if (diffVal.compareTo(BigDecimal.valueOf(0)) > 0) {
                    carpoolOrderMapper.updateCarpoolRepayPrice(carpoolOrder.getOrderNo(), 1, diffVal);
                }
            });
        }
        //TODO 处理补差价业务逻辑
        return carpoolOrders.size();
    }

	/***
	* <p>Title: handleUsersDrawbackCarpool</p>
	* <p>Description: 处理退款业务逻辑</p>
	* @return
	*/
	@Override
	public int handleUsersDrawbackCarpool() {
		List<String> carpoolOrders = carpoolOrderMapper.selectRecordsToDrawback();
		restTask.invokeUrl(carpoolOrders);
		return CollectionUtils.isEmpty(carpoolOrders) ? 0 : carpoolOrders.size();
	}

}