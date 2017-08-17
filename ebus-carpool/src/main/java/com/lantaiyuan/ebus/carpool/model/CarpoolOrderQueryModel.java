package com.lantaiyuan.ebus.carpool.model;

import org.lanqiao.ssm.common.model.BaseModel;

/**
 * TODO 简单说明
 *
 * @author yangyang
 * @date 2017/7/12 16:36
 * @email kekecany@163.com
 */
public class CarpoolOrderQueryModel extends BaseModel<CarpoolOrder> {
    private static final long serialVersionUID = 8095443334417711931L;

    private String cityCode ;
    private String matchId;
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
}
