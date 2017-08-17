package com.lantaiyuan.ebus.custom.controller;

import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.csource.common.MyException;
import org.lanqiao.fdfs.FastDFSHelper;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lantaiyuan.ebus.common.constants.ReadPropertyFromXmlBySpringBean;
import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;
import com.lantaiyuan.ebus.custom.model.Suggestion;
import com.lantaiyuan.ebus.custom.model.SuggestionQueryModel;
import com.lantaiyuan.ebus.custom.model.SysUser;
import com.lantaiyuan.ebus.custom.service.SuggestionServiceI;

/**
 * 描述:反馈建议控制器
 * 作者:温海金
 * 最后更改时间:下午6:12:05
 */
@RestController
@RequestMapping("/suggestion")
public class SuggestionController extends BasicController {
    	@Resource
	private SuggestionServiceI suggestionService;
    	
	private static Logger logger = LoggerFactory.getLogger(SuggestionController.class);
	/**
	 * 功能描述:手机端提交的建议反馈内容
	 * 作者:温海金
	 * 最后更改时间 : 2016年12月9日 上午11:30:38
	 */
	@PostMapping(value = "/addSuggest")
	public Object addSuggest(HttpServletRequest request, Suggestion suggestion, @RequestParam(value = "mFile",required = false) MultipartFile[] files){
	    String attachpathsStr = getFileSavePathsStr(files);
	    suggestion.setId(UUID.randomUUID().toString());
	    suggestion.setAttachpaths(attachpathsStr);
	    Byte messageType = 0;
	    suggestion.setMessagetype(messageType);
	    return setSimpleSuccess(suggestionService.insertSelective(suggestion));
	}
	
	
	/**
	 * 功能描述:手机端提交的建议反馈内容
	 * 作者:温海金
	 * 最后更改时间 : 2016年12月9日 上午11:30:38
	 */
	@PostMapping(value = "/uploadMultipartFiles")
	public Object uploadMultipartFiles(HttpServletRequest request, @RequestParam(value = "mFile",required = false) MultipartFile[] files){
	    String attachpathsStr = getFileSavePathsStr(files);
	    return setSimpleSuccess(attachpathsStr);
	}
	
	/**
	 * 功能描述:系统回复接口
	 * 作者:温海金
	 * 最后更改时间 : 2016年12月9日 上午11:30:16
	 */
	@PostMapping(value = "/sysReply")
	public Object sysReply(HttpServletRequest request, Suggestion suggestion){
	    return setSimpleSuccess(suggestionService.insertSelective4reply(suggestion));
	}
	/**
	 * 功能描述:拼接文件路径字符串，多个文件以“,”隔开
	 * 作者:温海金
	 * 最后更改时间 : 2016年12月5日 上午10:34:31
	 */
	private String getFileSavePathsStr(MultipartFile[] files) {
	    StringBuilder attachpaths = new StringBuilder();
	    String FDS_ADDRESS_PRE = ReadPropertyFromXmlBySpringBean.getFdsAddressPre();//获取文件服务器地址
	    if(files == null){
		return "";
	    }
	    for (MultipartFile file : files) {
		String fileExtName = SysGlobalConstants.PICTURE_SUFFIX;//默认扩展名“.jpg”
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
	 * 功能描述:根据用户id查询建议反馈记录
	 * 作者:温海金
	 * 最后更改时间 : 2016年12月13日 下午4:41:52
	 */
	@GetMapping(value = "/getSuggestTopicByUserId")
	public Object getSuggestTopicByUserId(@RequestParam Integer userid,@RequestParam(required=false) String citycode) {
	    return setSimpleSuccess(suggestionService.getSuggestTopicByUserId(userid,citycode));
	}
	
	/**
	 * 功能描述:查看反馈建议详情
	 * 作者:温海金
	 * 最后更改时间 : 2016年12月13日 下午4:57:02
	 */
	@GetMapping(value = "/getSuggestDetailById")
	public Object getSuggestDetailById(@RequestParam String entityid) {
	    return setSimpleSuccess(suggestionService.selectDetailListByEntityId(entityid));
	}
	
	/**
	 * 功能描述:建议反馈分页查询
	 * 作者:温海金
	 * 最后更改时间 : 2016年12月13日 下午4:57:02
	 */
	@PostMapping(value = "/getSuggestionPagging")
	public Object getSuggestionByPage(SuggestionQueryModel suggestionQueryModel,int page, HttpSession session) throws Exception {
	    String cityCode = StringUtils.isEmpty(suggestionQueryModel.getCitycode()) ? ((SysUser)session.getAttribute(SysGlobalConstants.USER_SESSION_KEY)).getCitycode() : suggestionQueryModel.getCitycode();
		suggestionQueryModel.setCitycode(cityCode);
	    return setSimpleSuccess(suggestionService.getSuggestionByPage(suggestionQueryModel,page));
	}
	
}