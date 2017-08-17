package com.lantaiyuan.ebus.custom.controller;

import java.math.BigDecimal;
import javax.annotation.Resource;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.lantaiyuan.ebus.custom.model.CustomLineQueryModel;
import com.lantaiyuan.ebus.custom.service.CustomLineApplicationServiceI;
import com.lantaiyuan.ebus.custom.service.CustomLineServiceI;
/**
 * 描述:专线控制类
 * 作者:温海金
 * 最后更改时间:下午6:14:25
 */
@RestController
@RequestMapping("/customLine")
public class CustomLineController extends BasicController {
	@Resource
	private CustomLineServiceI customLineService;
	@Resource
	private CustomLineApplicationServiceI customLineApplicationService;
	/**
	 * 功能描述:查询所有专线
	 * 作者:温海金
	 * 最后更改时间 : 2016年12月19日 下午2:40:20
	 */
	@GetMapping(value = "/findAllCustomLine")
	public Object findAllCustomLine() {
		return setSimpleSuccess(customLineService.findAllCustomLine());
	}
	
	/**
	 * 功能描述:根据创建人id查当前用户申请的专线
	 * 作者:温海金
	 * 最后更改时间 : 2016年12月19日 下午2:41:59
	 */
	@GetMapping(value = "/findCustomLineByApplicUserId")
	public Object findCustomLineByApplicUserId(@RequestParam  String applicantuserid) {
		CustomLineQueryModel customLineQueryModel = new CustomLineQueryModel();
		customLineQueryModel.setApplicantuserid(Integer.valueOf(applicantuserid));
		return customLineService.findObjectsByPage(customLineQueryModel);
	}
	
	/**
	 * 功能描述:根据创建人id查询可能关注的专线(只查已开通)
	 * 作者:温海金
	 * 最后更改时间 : 2016年12月13日 下午3:15:44
	 * 更改内容 : 新增citycode参数用于app城市切换
	 */
	@GetMapping(value = "/findMayFocLineByUserId")
	public Object findMayFocLineByUserId(@RequestParam Integer userid,@RequestParam String citycode) {
	    return setSimpleSuccess(customLineService.findMayFocLineByUserId(userid,citycode));
	}
	
	/**
	 * 功能描述:根据起始点经纬度匹配专线列表
	 * 作者:温海金
	 * 最后更改时间 : 2016年12月19日 下午2:43:15
	 */
	@GetMapping(value = "/findCustomLineByStartAndDistinctPlace")
	public Object findCustomLineByStartAndDistinctPlace(
			@RequestParam Integer userid,
			@RequestParam BigDecimal startlongitude,
			@RequestParam BigDecimal startlatitude,
			@RequestParam BigDecimal endlongitude,
			@RequestParam BigDecimal endlatitude,
			@RequestParam(required=false) String citycode,
			@RequestParam(required=false) Integer status
			){
	    return setSimpleSuccess(customLineService.findCustomLineByStartAndDistinctPlace(userid,startlongitude,startlatitude,endlongitude,endlatitude,citycode,status));
	}
	
	/**
	 * 功能描述:专线开通
	 * 作者:温海金
	 * 参数:id是base_order_detail里面的goodsId,消息推送时要查的也是base_order_detail里面的userId
	 * 最后更改时间 : 2017年02月21日 下午3:15:44
	 */
	@PostMapping(value = "/openCustomLine/{id}")
	public Object openCustomLine(@PathVariable String id) {
	    return setSimpleSuccess(customLineService.openCustomLine(id));
	}
	
}
