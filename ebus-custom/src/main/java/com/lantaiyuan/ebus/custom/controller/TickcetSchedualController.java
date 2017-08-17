package com.lantaiyuan.ebus.custom.controller;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.pay.alipay.core.Config;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;
import com.lantaiyuan.ebus.custom.service.TickcetSchedualServiceI;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 
  * @ClassName: TickcetSchedualController
  * @Description: 某专线某天剩余票数表 
  * @author Yuan.Tan
  * @date 2016年11月3日 下午3:16:50
  *
 */
@RestController
@RequestMapping("/tickcetSchedual")
public class TickcetSchedualController extends BasicController   {
	@Resource
	private TickcetSchedualServiceI tickcetSchedualService;
	
	/**
	  * queryRemainTicket(给出某条路线某天 用户是否已经买票的提示，若已买的话提示 不能再购买)
	 */
	@ApiOperation(value = "查某专线 票的基本信息  ")
	@PostMapping(value = "/queryRemainTicket")
	public ModelMap queryRemainTicket( @ApiParam(value = "用户id") @RequestParam String userid,@ApiParam(value = "线路id") @RequestParam String routeid,@ApiParam(value = "城市编码") @RequestParam String citycode) {
		ModelMap modelMap = new ModelMap();
		modelMap.put(SysGlobalConstants.PARAM_TICKET_LIST, tickcetSchedualService.queryTicketByRouteId(userid,routeid,citycode));
		modelMap.put(SysGlobalConstants.PARAM_SUCCESS, SysGlobalConstants.RETURN_SUCCESS_CODE);
		modelMap.put(SysGlobalConstants.PARAM_MSG, SysGlobalConstants.QUERY_SUCCESS_MESSAGE);
		return modelMap;
	}
	
	/**
	 * 功能描述:测试代码 生成邯郸虚拟公交卡二维码
	 * 作者:YvanTan
	 * 最后更改时间 : 2017-08-3 
	 * @throws AlipayApiException 
	 */
	@GetMapping(value = "/generateVirtualCode")
	public String generateVirtualCode() throws AlipayApiException {
		//虚拟公交卡：标识（固定为3）+虚拟卡ID（6字节城市代码+9字节注册唯一码）+日期时间（yyyymmddhhmmss，14个字节）+验证码（10字节校验）
		String code = "3130400686010491"+System.currentTimeMillis()/1000;
	    return code+AlipaySignature.rsaSign(code, Config.RSA_RRIVATE_KEY, Config.CHARSET).substring(0, 10);
	}
}
