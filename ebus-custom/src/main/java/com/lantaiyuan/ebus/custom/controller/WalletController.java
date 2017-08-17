/**
 * @Title: WalletController.java
 * @Package com.lantaiyuan.ebus.custom.controller
 * Company:深圳市蓝泰源信息技术股份有限公司
 * @author Yuan.Tan
 * @date 2017年2月17日 下午5:12:56
 */
package com.lantaiyuan.ebus.custom.controller;

import javax.annotation.Resource;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Range;
import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.lantaiyuan.ebus.custom.service.WalletRecordServiceI;
import com.lantaiyuan.ebus.custom.service.WalletServiceI;
import com.wordnik.swagger.annotations.ApiParam;

/**
  * @ClassName: WalletController 钱包控制器类
  * Company:深圳市蓝泰源信息技术股份有限公司
  * @author Yuan.Tan
  * @date 2017年2月17日 下午5:12:56
  */
@RestController
@RequestMapping("/myWallet")
public class WalletController extends BasicController{
	@Resource
	private WalletServiceI walletService;
	@Resource
	private WalletRecordServiceI walletRecordService;
	
	/**
	 * 查询余额
	 */
	@GetMapping(value = "/balance")
	public Json queryMyBalance(@Pattern(regexp ="^[1-9]\\d*$",message ="用户id只能是大余0的整数") @Range(min = 1, message = "用户id只能是大余0的数字") @ApiParam(value = "用户id") @RequestParam(name = "userid", required = true) String userid) {
		//思路：查询我的钱包表 判断是否有记录：
	    //如果存在记录，直接返回余额字段给前端
		//如果不存在记录，则新增此用户记录（userid）到钱包表，返回余额：0.00 给前端
		//说明:钱包表属于新功能表，暂时没有数据，目前做法是：用户第一次调用此查询余额接口时，初始化记录到表中
		return setSimpleSuccess(walletService.queryMyBalance(String.valueOf(userid)));
	}
	
	/**
	 * 查询账单
	 */
	@GetMapping(value = "/bills")
	public Json queryMyBills(@ApiParam(value = "用户id") @RequestParam String userid) {
		//直接根据用户id，按时间倒序从钱包交易记录表中查出用户的账单明细
		return setSimpleSuccess(walletRecordService.queryMyBills(userid));
	}
	
	/**
	 * 充值，返回充值签名给前端
	 */
	@PostMapping(value = "/topUp")
	public Json topUp(@ApiParam(value = "用户id") @RequestParam String userid,@ApiParam(value = "支付方式") @RequestParam String paytype,
			@ApiParam(value = "充值金额") @RequestParam String amount) {
		//userid 用户id
		//amount 金额:控制 1元以上整数金额
		//paytype 支付类型 ：1-微信支付 2-支付宝支付
		//直接在钱包交易记录表新增记录，返回充值签名给前端 然后在支付回调里取得流水记录号和金额，事物操作：根据流水号更新流水记录表的金额和状态，在流水表里查询userid，更新钱包表的余额记录（增加操作），
		return setSimpleSuccess(walletRecordService.topUp(userid,paytype,amount));
	}
	
	/**
	 * 充值，返回充值签名给前端
	 */
	@PostMapping(value = "/generateWalletSign")
	public Json generateWalletSign(@ApiParam(value = "用户id") @RequestParam String userId) {
		return setSimpleSuccess(walletService.generateWalletSign(userId));
	}
}
