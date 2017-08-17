package com.lantaiyuan.ebus.custom.controller;

import java.math.BigDecimal;
import java.util.UUID;
import javax.annotation.Resource;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;
import com.lantaiyuan.ebus.common.util.RandomGeneratorUtil;
import com.lantaiyuan.ebus.custom.model.CustomLine;
import com.lantaiyuan.ebus.custom.model.CustomLineApplication;
import com.lantaiyuan.ebus.custom.model.CustomLineApplicationQueryModel;
import com.lantaiyuan.ebus.custom.model.CustomLineComment;
import com.lantaiyuan.ebus.custom.service.CustomLineApplicationServiceI;
import com.lantaiyuan.ebus.custom.service.CustomLineServiceI;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @ClassName: CustomLineApplicationController
 * @Description: 专线申请
 * @author Yuan.Tan
 * @date 2016年11月8日 上午11:40:02
 *
 */
@RestController
@RequestMapping("/customLineApplication")
public class CustomLineApplicationController extends BasicController {
	@Resource
	private CustomLineApplicationServiceI customLineApplicationService;
	@Resource
	private CustomLineServiceI customLineService;

	@ApiOperation(value = "定制公交专线申请接口")
	@PostMapping(value = "/apply")
	public Object apply(ModelMap modelMap, @ApiParam(value = "用户id") @RequestParam String userid,
			@ApiParam(value = "用户名") @RequestParam String username,
			@ApiParam(value = "起点名") @RequestParam String sourcelocation,
			@ApiParam(value = "终点名") @RequestParam String targetlocation,
			@ApiParam(value = "起始点经度") @RequestParam String startlongitude,
			@ApiParam(value = "起始点纬度") @RequestParam String startlatitude,
			@ApiParam(value = "终点经度") @RequestParam String endlongitude,
			@ApiParam(value = "终点纬度") @RequestParam String endlatitude,
			@ApiParam(value = "上班时间") @RequestParam String starttime,
			@ApiParam(value = "下班时间") @RequestParam String backtime,
			@ApiParam(value = "城市编码") @RequestParam String citycode) {
		String id = UUID.randomUUID().toString();
		CustomLine customLine = new CustomLine(id, RandomGeneratorUtil.getRandomStringByLength(20), starttime, backtime,
				sourcelocation, new BigDecimal(startlongitude), new BigDecimal(startlatitude), targetlocation,
				new BigDecimal(endlongitude), new BigDecimal(endlatitude), citycode, Integer.valueOf(userid));
		CustomLineApplication customLineApplication = new CustomLineApplication(id, Integer.valueOf(userid), username,
				sourcelocation, targetlocation, new BigDecimal(startlongitude), new BigDecimal(startlatitude),
				new BigDecimal(endlongitude), new BigDecimal(endlatitude), starttime, backtime, Integer.valueOf(userid),0);
		customLineService.apply(customLine, customLineApplication);
		modelMap.put(SysGlobalConstants.PARAM_SUCCESS, SysGlobalConstants.RETURN_SUCCESS_CODE);
		modelMap.put(SysGlobalConstants.PARAM_MSG, SysGlobalConstants.APPLY_SUCCESS_MESSAGE);
		modelMap.put(SysGlobalConstants.PARAM_DATA, "");
		return JSON.toJSON(modelMap);
	}

	@ApiOperation(value = "定制公交专线加入接口")
	@PostMapping(value = "/join")
	public Object join(ModelMap modelMap, @ApiParam(value = "用户id") @RequestParam String userid,
			@ApiParam(value = "用户名") @RequestParam String username,
			@ApiParam(value = "专线id") @RequestParam String routeid,
			@ApiParam(value = "起点名") @RequestParam String sourcelocation,
			@ApiParam(value = "终点名") @RequestParam String targetlocation,
			@ApiParam(value = "起始点经度") @RequestParam String startlongitude,
			@ApiParam(value = "起始点纬度") @RequestParam String startlatitude,
			@ApiParam(value = "终点经度") @RequestParam String endlongitude,
			@ApiParam(value = "终点纬度") @RequestParam String endlatitude,
			@ApiParam(value = "上班时间") @RequestParam String starttime,
			@ApiParam(value = "下班时间") @RequestParam String backtime,
			@ApiParam(value = "发起人id") @RequestParam String applicantid) {
		CustomLineApplication customLineApplication = new CustomLineApplication(routeid, Integer.valueOf(userid),
				username, sourcelocation, targetlocation, new BigDecimal(startlongitude), new BigDecimal(startlatitude),
				new BigDecimal(endlongitude), new BigDecimal(endlatitude), starttime, backtime, Integer.valueOf(userid),1);
		customLineApplicationService.insertSelective(customLineApplication);
		modelMap.put(SysGlobalConstants.PARAM_SUCCESS, SysGlobalConstants.RETURN_SUCCESS_CODE);
		modelMap.put(SysGlobalConstants.PARAM_MSG, SysGlobalConstants.JOIN_SUCCESS_MESSAGE);
		modelMap.put(SysGlobalConstants.PARAM_DATA, "");
		return JSON.toJSON(modelMap);
	}

	@ApiOperation(value = "分页接口")
	@PostMapping(value = "/findObjectsByPage")
	public Object findObjectsByPage(ModelMap modelMap, @ApiParam(value = "查询条件") @RequestParam String routeid) {
		CustomLineApplicationQueryModel customLineApplicationQueryModel = new CustomLineApplicationQueryModel();
		customLineApplicationQueryModel.setLineid(routeid);
		customLineApplicationQueryModel.getPageModel().setNowPage(2);
		customLineApplicationQueryModel.getPageModel().setPageShow(10);
		customLineApplicationService.findObjectsByPage(customLineApplicationQueryModel);
		return JSON.toJSON(customLineApplicationService.findObjectsByPage(customLineApplicationQueryModel));
	}

	@ApiOperation(value = "专线加开接口")
	@PostMapping(value = "/extraApply")
	public Object extraApply(CustomLineComment customLineComment) {
		return setSimpleSuccess(customLineApplicationService.extraApply(customLineComment));
	}

}
