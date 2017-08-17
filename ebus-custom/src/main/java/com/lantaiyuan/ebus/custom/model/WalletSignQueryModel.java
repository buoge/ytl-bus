package com.lantaiyuan.ebus.custom.model;

import java.util.Date;
import org.lanqiao.ssm.common.model.BaseModel;

/**
 * 用户钱包
 * WalletSign
 * 数据库表：t_app_mywallet_sign
 */
public class WalletSignQueryModel  extends BaseModel {

    /**
	  * @Fields serialVersionUID :
	  */
	private static final long serialVersionUID = 1L;

	/**
     * 用户ID
     * 表字段 : t_app_mywallet_sign.USER_ID
     */
    private String userId;

    /**
     * 余额变动时对应的签名
     * 表字段 : t_app_mywallet_sign.SIGN
     */
    private String sign;

    /**
     * 最近一次修改时间
     * 表字段 : t_app_mywallet_sign.MODIFYTIME
     */
    private Date modifytime;

    /**
     * 获取 用户ID 字段:t_app_mywallet_sign.USER_ID
     *
     * @return t_app_mywallet_sign.USER_ID, 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置 用户ID 字段:t_app_mywallet_sign.USER_ID
     *
     * @param userId the value for t_app_mywallet_sign.USER_ID, 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取 余额变动时对应的签名 字段:t_app_mywallet_sign.SIGN
     *
     * @return t_app_mywallet_sign.SIGN, 余额变动时对应的签名
     */
    public String getSign() {
        return sign;
    }

    /**
     * 设置 余额变动时对应的签名 字段:t_app_mywallet_sign.SIGN
     *
     * @param sign the value for t_app_mywallet_sign.SIGN, 余额变动时对应的签名
     */
    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    /**
     * 获取 最近一次修改时间 字段:t_app_mywallet_sign.MODIFYTIME
     *
     * @return t_app_mywallet_sign.MODIFYTIME, 最近一次修改时间
     */
    public Date getModifytime() {
        return modifytime;
    }

    /**
     * 设置 最近一次修改时间 字段:t_app_mywallet_sign.MODIFYTIME
     *
     * @param modifytime the value for t_app_mywallet_sign.MODIFYTIME, 最近一次修改时间
     */
    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }
}