package com.lantaiyuan.ebus.custom.controller;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.csource.common.MyException;
import org.lanqiao.fdfs.FastDFSHelper;
import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.lantaiyuan.ebus.common.constants.ReadPropertyFromXmlBySpringBean;
import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;
import com.lantaiyuan.ebus.custom.model.Evaluation;
import com.lantaiyuan.ebus.custom.model.EvaluationSecond;
import com.lantaiyuan.ebus.custom.service.BaseRouteServiceI;
import com.lantaiyuan.ebus.custom.service.BaseStationServiceI;
import com.lantaiyuan.ebus.custom.service.EvaluationServiceI;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 
  * @ClassName: EvaluationController
  * @author Yuan.Tan
  * @date 2016年12月19日 下午12:34:57
 */
@RestController
@RequestMapping("/evaluation")
public class EvaluationController extends BasicController  {
	@Resource
	private BaseRouteServiceI baseRouteService;
	@Resource
	private BaseStationServiceI baseStationService;
	@Resource
	private EvaluationServiceI evaluationService;
	
	@ApiOperation(value = "车牌模糊查询")
	@PostMapping(value = "/queryBusNumber" )
	public Json queryBusNumList(@ApiParam(value = "车牌号") @RequestParam String busnum,@ApiParam(value = "citycode") @RequestParam String citycode) {
		return setSimpleSuccess(baseRouteService.queryBusNumList(busnum,citycode));
	}
	
	@ApiOperation(value = "站点模糊查询")
	@PostMapping(value = "/queryStationInfo" )
	public Json queryStationList(@ApiParam(value = "站点名称") @RequestParam String stationname,@ApiParam(value = "citycode") @RequestParam String citycode) {
		return setSimpleSuccess(baseStationService.queryStationList(stationname,citycode));
	}
	
	@ApiOperation(value = "站点(车辆)评价接口")
	@PostMapping(value = "/save" )
	public Json save(Evaluation evaluation) {
		return setSimpleSuccess(evaluationService.evaluate(evaluation));
	}
	
	@ApiOperation(value = "站点(车辆)评价接口-第二版:新增userid、图片路径和标签（司机评价才会传）")
	@PostMapping(value = "/create" )
	public Json create(HttpServletRequest request, EvaluationSecond evaluationSecond, @RequestParam(value = "mFile",required = false) MultipartFile[] files) {
		String attachpathsStr = getFileSavePathsStr(files);
		evaluationSecond.setAttachpaths(attachpathsStr);
		Evaluation evaluation = new Evaluation();
		evaluationService.addTagOrTagCountIncrement(evaluationSecond);
		BeanUtils.copyProperties(evaluationSecond, evaluation);
		return setSimpleSuccess(evaluationService.evaluate(evaluation));
	}
	
	/**
	 * 功能描述:拼接文件路径字符串，多个文件以“,”隔开
	 * 作者:温海金
	 * 最后更改时间 : 2016年12月5日 上午10:34:31
	 */
	private String getFileSavePathsStr(MultipartFile[] files) {
	    StringBuilder attachpaths = new StringBuilder();
	    //获取文件服务器地址
	    String FDS_ADDRESS_PRE = ReadPropertyFromXmlBySpringBean.getFdsAddressPre();
	    if(files == null){
		return "";
	    }
	    for (MultipartFile file : files) {
	    //默认扩展名“.jpg”
		String fileExtName = SysGlobalConstants.PICTURE_SUFFIX;
		String[] str = file.getOriginalFilename().split("\\.");
		if(str.length>=2){
		    fileExtName = str[str.length - 1];
		}
		try {
		    String uploadFile = FastDFSHelper.storageClient1.upload_file1(file.getBytes(), fileExtName, null);
		    attachpaths.append(FDS_ADDRESS_PRE+uploadFile);
		    attachpaths.append(',');
		} catch (IOException e) {
		    logger.error("FastDFS系列化附件出错,具体错误信息:",e);
		} catch (MyException e) {
		    logger.error("文件系统保存附件出错,具体错误信息:",e);
		}
	    }
	    String attachpathsStr = attachpaths.toString();
	    return attachpathsStr.length()>0 ? attachpathsStr.substring(0, attachpathsStr.length()-1) : attachpathsStr;
	}
}
