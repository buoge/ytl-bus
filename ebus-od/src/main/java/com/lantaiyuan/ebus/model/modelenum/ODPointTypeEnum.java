package com.lantaiyuan.ebus.model.modelenum;

/**
 * O点，D点
 * @author yangyang
 * @date 2017年5月25日 下午4:02:59 
 *
 */
public enum ODPointTypeEnum {
	O_POINT(1, "O点"),
	D_POINT(2, "D点");
	
	private ODPointTypeEnum(int val, String desc) {
		this.val = val;
		this.desc = desc;
	}
	private int val;
	private String desc;
	public int val() {
		return val;
	}
	public String desc() {
		return desc;
	}
	
	
	

}
