package com.lantaiyuan.ebus.custom.model;

import java.util.Date;

/**
 * 
  * @ClassName: BaseComparableOrder
  * @Description:项目中有TicketOrder、CarpoolOrderResult两个类，其中均含有属性：java.util.Date createTime；
  * TicketOrder中含有若干个属性a1…an，CarpoolOrderResult中含有若干个属性b1…bm，现在有TicketOrder的若干个实例 ，CarpoolOrderResult的若干个实例。
  * 结果现在按照createTime属性进行降序排序，依次输出TicketOrder和CarpoolOrderResult的所有实例。
  * @author Yuan.Tan
  * @date 2017年6月20日 下午2:46:26
  *
 */

public class BaseComparableOrder implements Comparable<BaseComparableOrder> {
	private Date createTime;
	private String orderType;
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	
	@Override
	public int compareTo(BaseComparableOrder order) {
		 // TODO Auto-generated method stub
        long i = this.getCreateTime().getTime() - order.getCreateTime().getTime();
        if (i == 0) {
            return 0;
        } else if (i > 0) {
            return -1;
        } else {
            return 1;
        }
	}

}