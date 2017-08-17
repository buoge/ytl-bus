
package com.lantaiyuan.ebus.carpool.model.kafkamodel;

import org.lanqiao.ssm.common.model.Model;

/**
 * 拼车推送消息
 *
 * @author yangyang
 * @date 2017/7/12 18:29
 * @email kekecany@163.com
 */
public class CarpoolPushMsg extends Model{
    private static final long serialVersionUID = 8421236247075405908L;

    private String cityCode;
    private String matchId;
    private Integer msgType;
    private String orderNo;
    private String userId;
    private String pushMsg;
    private Long pushTime;
    private Long departTime;

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPushMsg() {
        return pushMsg;
    }

    public void setPushMsg(String pushMsg) {
        this.pushMsg = pushMsg;
    }

    public Long getPushTime() {
        return pushTime;
    }

    public void setPushTime(Long pushTime) {
        this.pushTime = pushTime;
    }

    public Long getDepartTime() {
        return departTime;
    }

    public void setDepartTime(Long departTime) {
        this.departTime = departTime;
    }
}