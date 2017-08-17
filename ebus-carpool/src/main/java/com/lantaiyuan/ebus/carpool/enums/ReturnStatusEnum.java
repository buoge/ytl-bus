package com.lantaiyuan.ebus.carpool.enums;

public enum ReturnStatusEnum {
	SUCCESS(200, "操作成功！"), AUTHENTICATION_ERROR(1001, "授权异常！"),

	LOGIN_FAIL(1002, "登录用户或密码不正确！"),

	NO_ACCOUNT(1003, "用户不存在！"),

	LOCKED_ACCOUNT(1004, "账号已经锁定！"),

	OPERATOR_REQUESTPRARM_ERROR(3003, "请求参数异常！"),

	OPERATOR_REQUESTPRARM_MISS(3004, "请求参数丢失！"),

	OPERATOR_REQUESTPRARM_ILLEGAL_ARGUMENT(3005, "无效请求参数！"),

	ILLEGAL_REQUEST(4001, "非法请求！"),

	NEED_HIGH_VERSION(4002, "需更新到高版本！"),
	
	UNAUTHORIED(4003, "未授权！"),

	OPERATOR_SUCCESS(5001, "业务操作成功！"),

	OPERATOR_FAIL(5002, "业务操作失败！"),

	SIGN_FAIL(6001, "数据签名错误！"),
	

	SERVER_INSIDE_FAIL(9001, "服务内部错误！");

	private int statusCode;
	private String description;

	private ReturnStatusEnum(int statusCode, String description) {
		this.statusCode = statusCode;
		this.description = description;
	}

	public int value() {
		return statusCode;
	}

	public String description() {
		return description;
	}

	public static ReturnStatusEnum valueOf(int statusCode) {
	
		for (ReturnStatusEnum status : values()) {
			if (status.statusCode == statusCode) {
				return status;
			}
		}
		throw new IllegalArgumentException("No matching constant for [" + statusCode + "]");
	}
}
