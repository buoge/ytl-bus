package com.lantaiyuan.ebus.custom.model.enummodel;

/**
 * 拼车状态枚举
 *
 * @author yangyang
 * @date 2017/7/14 15:43
 * @email kekecany@163.com
 *
 *
 * 拼车状态(0:处理中，1: 拼车中, 2: 拼车成功, 3: 已发车, 4: 用户已上车, 5: 用户到达下车点，9: 车到终点, 10: 用户已评价，-1: 拼车失败))
 */
public enum CarpoolMatchStatusEnum {

    INPROCESS((byte)0, "处理中"),
    CARPOOLING((byte)1, "拼车中"),
    CARPOOL_SUCCESS((byte)2, "拼车成功"),
    DEPARTING((byte)3, "发车中"),
    USER_INBUS((byte)4, "已上车"),
    USER_OFFBUS((byte)5, "用户到达下车点"),
    BUS_FINISH_TASK((byte)9, "车到终点"),
    USER_EVALUATED((byte)10, "用户已评价"),
    CARPOOL_FAIL((byte)-1, "拼车失败");

    private Byte val;

    private String desc;

    CarpoolMatchStatusEnum(Byte val, String desc) {
        this.val = val;
        this.desc = desc;
    }

    public Byte val() {
        return val;
    }

    public String desc() {
        return desc;
    }



}
