package com.lantaiyuan.ebus.carpool.model;

import org.lanqiao.ssm.common.model.Model;

import java.util.Date;
import java.util.List;

/**
 * 拼车详情，大拼车订单发车时间和所有小拼车详情
 *
 * @author yangyang
 * @date 2017/7/18 16:13
 * @email kekecany@163.com
 */
public class CarpoolMatchDetail extends Model{

    private static final long serialVersionUID = 8887005299288839937L;

    private Integer id;

    private Date departTime;

    private List<CarpoolOrder> carpoolOrderList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDepartTime() {
        return departTime;
    }

    public void setDepartTime(Date departTime) {
        this.departTime = departTime;
    }

    public List<CarpoolOrder> getCarpoolOrderList() {
        return carpoolOrderList;
    }

    public void setCarpoolOrderList(List<CarpoolOrder> carpoolOrderList) {
        this.carpoolOrderList = carpoolOrderList;
    }
}
