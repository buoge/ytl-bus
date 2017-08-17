package com.lantaiyuan.ebus.carpool.enums;

import java.util.Objects;

/**
 * 要推送的消息类型
 *
 * @author yangyang
 * @date 2017/7/18 14:28
 * @email kekecany@163.com
 *
 */
public enum PushMsgType {

    MATCH_SUCCESS(10, "订单撮合成功"),
    MATCH_FAIL(11, "订单撮合失败"),

    UP_POINT_CHANGE(30, "上车点变更"),
    DOWN_POINT_CHANGE(31, "下车点变更"),
    UP_DOWN_POINTS_BOTH_CHANGED(32, "上下车点均变更"),
    UP_DOWN_POINTS_BOTH_NOT_CHANGED(33, "上下车点均保持不变"),

    ABOUT_TO_DEPART(41, "即将发车"),
    DEPART(42, "开始发车"),
    DEFAULT(0, "default");

    private Integer val;
    private String desc;

    PushMsgType(Integer val, String desc) {
        this.val = val;
        this.desc = desc;
    }

    public Integer val() {
        return val;
    }

    public String desc() {
        return desc;
    }

    public static PushMsgType valueOf(Integer val) {
        for (PushMsgType pushMsgType: PushMsgType.values()) {
            if (Objects.equals(pushMsgType.val, val)) {
                return pushMsgType;
            }
        }
        return DEFAULT;
    }
}