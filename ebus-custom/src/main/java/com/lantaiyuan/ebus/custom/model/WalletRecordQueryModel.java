package com.lantaiyuan.ebus.custom.model;

import java.math.BigDecimal;
import java.util.Date;
import org.lanqiao.ssm.common.model.BaseModel;

/**
 * 钱包交易记录表
 * WalletRecord
 * 数据库表：t_app_mywallet_record
 */
public class WalletRecordQueryModel extends BaseModel{

	/**
	  * @Fields serialVersionUID :
	  */
	private static final long serialVersionUID = 1L;

	/**
    * 自增id
    * 表字段 : t_app_mywallet_record.ID
    */
   private Integer id;

   /**
    * 交易流水ID
    * 表字段 : t_app_mywallet_record.RECORD_ID
    */
   private String recordId;

   /**
    * 用户ID
    * 表字段 : t_app_mywallet_record.USER_ID
    */
   private String userId;

   /**
    * 充值金额
    * 表字段 : t_app_mywallet_record.AMOUNT
    */
   private BigDecimal amount;

   /**
    * 操作类型（1：充值； 2:提现;  3:扣款）
    * 表字段 : t_app_mywallet_record.OPT_TYPE
    */
   private String optType;

   /**
    * 支付类型（1：微信； 2：支付宝  3-钱包）
    * 表字段 : t_app_mywallet_record.PAY_TYPE
    */
   private String payType;

   /**
    * 支付状态 （0-待支付  1-成功)
    * 表字段 : t_app_mywallet_record.PAY_STATUS
    */
   private String payStatus;

   /**
    * 创建时间(默认当前时间)
    * 表字段 : t_app_mywallet_record.CREATE_TIME
    */
   private String createTime;

   /**
    * 获取 自增id 字段:t_app_mywallet_record.ID
    *
    * @return t_app_mywallet_record.ID, 自增id
    */
   public Integer getId() {
       return id;
   }

   /**
    * 设置 自增id 字段:t_app_mywallet_record.ID
    *
    * @param id the value for t_app_mywallet_record.ID, 自增id
    */
   public void setId(Integer id) {
       this.id = id;
   }

   /**
    * 获取 交易流水ID 字段:t_app_mywallet_record.RECORD_ID
    *
    * @return t_app_mywallet_record.RECORD_ID, 交易流水ID
    */
   public String getRecordId() {
       return recordId;
   }

   /**
    * 设置 交易流水ID 字段:t_app_mywallet_record.RECORD_ID
    *
    * @param recordId the value for t_app_mywallet_record.RECORD_ID, 交易流水ID
    */
   public void setRecordId(String recordId) {
       this.recordId = recordId == null ? null : recordId.trim();
   }

   /**
    * 获取 用户ID 字段:t_app_mywallet_record.USER_ID
    *
    * @return t_app_mywallet_record.USER_ID, 用户ID
    */
   public String getUserId() {
       return userId;
   }

   /**
    * 设置 用户ID 字段:t_app_mywallet_record.USER_ID
    *
    * @param userId the value for t_app_mywallet_record.USER_ID, 用户ID
    */
   public void setUserId(String userId) {
       this.userId = userId == null ? null : userId.trim();
   }

   /**
    * 获取 充值金额 字段:t_app_mywallet_record.AMOUNT
    *
    * @return t_app_mywallet_record.AMOUNT, 充值金额
    */
   public BigDecimal getAmount() {
       return amount;
   }

   /**
    * 设置 充值金额 字段:t_app_mywallet_record.AMOUNT
    *
    * @param amount the value for t_app_mywallet_record.AMOUNT, 充值金额
    */
   public void setAmount(BigDecimal amount) {
       this.amount = amount;
   }

   /**
    * 获取 操作类型（1：充值； 2:提现;  3:扣款） 字段:t_app_mywallet_record.OPT_TYPE
    *
    * @return t_app_mywallet_record.OPT_TYPE, 操作类型（1：充值； 2:提现;  3:扣款）
    */
   public String getOptType() {
       return optType;
   }

   /**
    * 设置 操作类型（1：充值； 2:提现;  3:扣款） 字段:t_app_mywallet_record.OPT_TYPE
    *
    * @param optType the value for t_app_mywallet_record.OPT_TYPE, 操作类型（1：充值； 2:提现;  3:扣款）
    */
   public void setOptType(String optType) {
       this.optType = optType;
   }

   /**
    * 获取 支付类型（1：微信； 2：支付宝  3-钱包） 字段:t_app_mywallet_record.PAY_TYPE
    *
    * @return t_app_mywallet_record.PAY_TYPE, 支付类型（1：微信； 2：支付宝  3-钱包）
    */
   public String getPayType() {
       return payType;
   }

   /**
    * 设置 支付类型（1：微信； 2：支付宝  3-钱包） 字段:t_app_mywallet_record.PAY_TYPE
    *
    * @param payType the value for t_app_mywallet_record.PAY_TYPE, 支付类型（1：微信； 2：支付宝  3-钱包）
    */
   public void setPayType(String payType) {
       this.payType = payType;
   }

   /**
    * 获取 支付状态 （0-待支付  1-成功) 字段:t_app_mywallet_record.PAY_STATUS
    *
    * @return t_app_mywallet_record.PAY_STATUS, 支付状态 （0-待支付  1-成功)
    */
   public String getPayStatus() {
       return payStatus;
   }

   /**
    * 设置 支付状态 （0-待支付  1-成功) 字段:t_app_mywallet_record.PAY_STATUS
    *
    * @param payStatus the value for t_app_mywallet_record.PAY_STATUS, 支付状态 （0-待支付  1-成功)
    */
   public void setPayStatus(String payStatus) {
       this.payStatus = payStatus;
   }

   /**
    * 获取 创建时间(默认当前时间) 字段:t_app_mywallet_record.CREATE_TIME
    *
    * @return t_app_mywallet_record.CREATE_TIME, 创建时间(默认当前时间)
    */
   public String getCreateTime() {
       return createTime;
   }

   /**
    * 设置 创建时间(默认当前时间) 字段:t_app_mywallet_record.CREATE_TIME
    *
    * @param createTime the value for t_app_mywallet_record.CREATE_TIME, 创建时间(默认当前时间)
    */
   public void setCreateTime(String createTime) {
       this.createTime = createTime;
   }
}