package com.lantaiyuan.ebus.carpool.enums;

/**
 * 收费方式
 *
 * @author yangyang
 * @date 2017/8/2 9:57
 * @email kekecany@163.com
 */
public enum ChargingModelEnum {

    UNITE_PRICE(1, "一票制"),
    SECTION_PRICE(2, "分段制");

    private Integer val;
    private String desc;

    ChargingModelEnum(Integer val, String desc) {
        this.val = val;
        this.desc = desc;
    }

    public Integer val() {
        return val;
    }

    public String desc() {
        return desc;
    }
}
