package com.lantaiyuan.ebus.custom.model;
/**
 *@see https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_7
* @Title: WeiXinReturnModel.java 
* @Package com.lantaiyuan.ebus.custom.model 
* @Description: 微信异步通知回调参数model
* @author 刘伟  15818570028@163.com   
* @date 2016年11月14日 上午9:40:19 
* @version V1.0
 */
public class WeiXinReturnModel {
	
	private String appid;
	private String bank_type;
	private String cash_fee;
	private String fee_type;
	private String is_subscribe;
	private String mch_id;//商户号
	private String nonce_str;
	private String openid;
	private String out_trade_no;//商户订单号
	private String result_code;//业务结果
	private String return_code;//返回状态码
	private String sign;
	private String time_end;
	private String total_fee;//订单金额
	private String trade_type;
	private String transaction_id;
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getBank_type() {
		return bank_type;
	}
	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}
	public String getCash_fee() {
		return cash_fee;
	}
	public void setCash_fee(String cash_fee) {
		this.cash_fee = cash_fee;
	}
	public String getFee_type() {
		return fee_type;
	}
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}
	public String getIs_subscribe() {
		return is_subscribe;
	}
	public void setIs_subscribe(String is_subscribe) {
		this.is_subscribe = is_subscribe;
	}
	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public String getReturn_code() {
		return return_code;
	}
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getTime_end() {
		return time_end;
	}
	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}
	public String getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	@Override
	public String toString() {
		return "WeiXinReturnModel [appid=" + appid + ", bank_type=" + bank_type + ", cash_fee=" + cash_fee
				+ ", fee_type=" + fee_type + ", is_subscribe=" + is_subscribe + ", mch_id=" + mch_id + ", nonce_str="
				+ nonce_str + ", openid=" + openid + ", out_trade_no=" + out_trade_no + ", result_code=" + result_code
				+ ", return_code=" + return_code + ", sign=" + sign + ", time_end=" + time_end + ", total_fee="
				+ total_fee + ", trade_type=" + trade_type + ", transaction_id=" + transaction_id + "]";
	}
	
	

}
