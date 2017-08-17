package com.lantaiyuan.ebus.custom.model;

import java.math.BigDecimal;
import java.util.Date;

import org.lanqiao.ssm.common.model.Model;

/**
 * 用户钱包
 * Wallet
 * 数据库表：t_app_mywallet
 */
public class Wallet extends Model {

    /**
	  * @Fields serialVersionUID :
	  */
	private static final long serialVersionUID = 1L;

	/**
     * 用户ID
     * 表字段 : t_app_mywallet.USER_ID
     */
    private String userId;

    /**
     * 余额
     * 表字段 : t_app_mywallet.BALANCE
     */
    private BigDecimal balance;

    /**
     * 是否被冻结（0：否； 1：是）
     * 表字段 : t_app_mywallet.FROZEN
     */
    private int frozen;

    /**
     * 最近一次修改时间
     * 表字段 : t_app_mywallet.MODIFYTIME
     */
    private Date modifytime;

    public Wallet() {
    	 
    }
    public Wallet(String userId, BigDecimal balance) {
    	this.userId = userId;
    	this.balance = balance;
    }

	/**
     * 获取 用户ID 字段:t_app_mywallet.USER_ID
     *
     * @return t_app_mywallet.USER_ID, 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置 用户ID 字段:t_app_mywallet.USER_ID
     *
     * @param userId the value for t_app_mywallet.USER_ID, 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取 余额 字段:t_app_mywallet.BALANCE
     *
     * @return t_app_mywallet.BALANCE, 余额
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * 设置 余额 字段:t_app_mywallet.BALANCE
     *
     * @param balance the value for t_app_mywallet.BALANCE, 余额
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * 获取 是否被冻结（0：否； 1：是） 字段:t_app_mywallet.FROZEN
     *
     * @return t_app_mywallet.FROZEN, 是否被冻结（0：否； 1：是）
     */
    public int getFrozen() {
        return frozen;
    }

    /**
     * 设置 是否被冻结（0：否； 1：是） 字段:t_app_mywallet.FROZEN
     *
     * @param frozen the value for t_app_mywallet.FROZEN, 是否被冻结（0：否； 1：是）
     */
    public void setFrozen(int frozen) {
        this.frozen = frozen;
    }

	/**
	 * @return the modifytime
	 */
	public Date getModifytime() {
		return modifytime;
	}
	/**
	 * @param modifytime the modifytime to set
	 */
	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}
}