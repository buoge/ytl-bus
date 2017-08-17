package com.lantaiyuan.ebus.custom.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.csource.common.MyException;
import org.lanqiao.fdfs.FastDFSHelper;
import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lantaiyuan.ebus.common.constants.ReadPropertyFromXmlBySpringBean;
import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;
import com.lantaiyuan.ebus.custom.model.EvaluationGeneral;
import com.lantaiyuan.ebus.custom.model.EvaluationGeneralQueryModel;
import com.lantaiyuan.ebus.custom.service.EvaluationGeneralServiceI;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 描述:综合评价控制类
 * 作者:温海金
 * 最后更改时间:下午4:10:43
 */
@RestController
@RequestMapping("/evaluationGeneral")
public class EvaluationGeneralController extends BasicController  {
	@Resource
	private EvaluationGeneralServiceI evaluationGeneralService;
	
	@ApiOperation(value = "综合评价新增接口")
	@PostMapping(value = "/create" )
	public Json create(HttpServletRequest request, EvaluationGeneral evaluationGeneral, @RequestParam(value = "mFile",required = false) MultipartFile[] files) {
		String attachpathsStr = getFileSavePathsStr(files);
		evaluationGeneral.setAttachPaths(attachpathsStr);
		return setSimpleSuccess(evaluationGeneralService.insertSelective(evaluationGeneral));
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
	
	/**
	 * 分页查询综合评价
	 * 
	 * @param page
	 * @param rows
	 */
	@GetMapping(value = "/list")
	public Json getByPage(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer rows, @ApiParam(value = "cityCode") EvaluationGeneralQueryModel model) {
		model.getPageModel().setPageShow(rows);
		return setSimpleSuccess(evaluationGeneralService.findEntityByPage(model, page));
	}
	
	/**
	 * 分页查询综合评价
	 * 
	 * @param page
	 * @param rows
	 */
	@GetMapping(value = "/get")
	public Json get(@RequestParam String id, @ApiParam(value = "cityCode") String cityCode) {
		return setSimpleSuccess(evaluationGeneralService.findEntityById(id, cityCode));
	}
}
