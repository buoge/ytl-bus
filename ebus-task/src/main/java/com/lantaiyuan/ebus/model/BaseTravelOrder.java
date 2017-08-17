package com.lantaiyuan.ebus.model;

public class BaseTravelOrder  {
    
    /**
     * 主键
     * 表字段 : travel_around.id
     */
    private String id;
    
    /**
     * 票数
     * 表字段 : travel_around.ticket_num
     */
    private Integer num;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
}