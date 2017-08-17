package com.lantaiyuan.ebus.custom.controller;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.lanqiao.fdfs.FastDFSHelper;
import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lantaiyuan.ebus.common.constants.ReadPropertyFromXmlBySpringBean;
import com.lantaiyuan.ebus.custom.model.BaseImage;
import com.lantaiyuan.ebus.custom.model.BusNews;
import com.lantaiyuan.ebus.custom.model.BusNewsResultQueryModel;
import com.lantaiyuan.ebus.custom.model.LostPropertyQueryModel;
import com.lantaiyuan.ebus.custom.model.ServiceIp;
import com.lantaiyuan.ebus.custom.service.BaseImageServiceI;
import com.lantaiyuan.ebus.custom.service.BusNewsServiceI;
import com.lantaiyuan.ebus.custom.service.ServiceIpServiceI;

/**
 * @Title: BusNewsController.java
 * @Package com.lantaiyuan.ebus.custom.controller
 * @Description:
 * @author yangyang
 * @date 2016年12月20日 下午2:20:07
 * @version v1.0
 */
@RestController
@RequestMapping("/busnews")
public class BusNewsController extends BasicController {
	@Resource
	private BusNewsServiceI busNewsService;
	@Resource
	private BaseImageServiceI baseImageService;
	@Resource
	private ServiceIpServiceI serviceIpService;
	
	private static Logger logger = LoggerFactory.getLogger(BusNewsController.class);
		
	/**
	 * 获取小标题公交动态
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	@GetMapping(value = "/small")
	public Json getSubTitleNews(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer rows, String cityCode) {
		BusNewsResultQueryModel model = new BusNewsResultQueryModel();
		model.getPageModel().setPageShow(rows);
		model.setCityCode(cityCode);
		return setSimpleSuccess(busNewsService.findSmallNewsByPage(model, page));
	}
	
	/**
	 * 分页查询失物招领
	 * 
	 * @param page
	 * @param rows
	 * @param cityCode
	 * @return
	 */
	@GetMapping(value = "/lostProperty")
	public Json getFindProperty(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer rows, String cityCode) {
		LostPropertyQueryModel model = new LostPropertyQueryModel();
		model.getPageModel().setPageShow(rows);
		model.setCityCode(cityCode);
		return setSimpleSuccess(busNewsService.findLostPropertyByPage(model, page));
	}
	

	/**
	 * 获取大标题新闻
	 * 
	 * @param cityCode
	 * @return
	 */
	@GetMapping(value = "/big")
	public Json getHeadTitleNews(String cityCode) {
		return setSimpleSuccess(busNewsService.getFiveBigNews(cityCode));
	}
	
	/**
	 * 增加阅读数
	 * @auther yangyang
	 * 
	 * 已与查看新闻详情合并，待移除，但为了保持兼容，先留着
	 */
	@Deprecated
	@GetMapping(value = "/updateNews")
	public Json updateNews(BusNews news) {
		return busNewsService.updateNews(news) ? setSimpleSuccess() :
			setFailed("修改失败");
	}
	
	/**
	 * 获取新闻详情
	 * @auther yangyang
	 */
	@PostMapping(value = "/newsDetail")
	public Json newsDetail(int id) {
		// 阅读数加1
		busNewsService.updateNews(new BusNews(id, 1));
		// 返回新闻详情
		return setSimpleSuccess(busNewsService.getNewsDetail(id));
	}
	
	/**
	 * 获取屏闪，广告导航等图片
	 * 
	 * @param cityCode
	 * @param type
	 * @return
	 */
	@GetMapping(value = "/image")
	public Json getImage(String cityCode, Integer type) {
		List<BaseImage> image = baseImageService.getBaseImage(cityCode, type);
		return setSimpleSuccess(image == null ? Collections.emptyList() : image );
	}

	/**
	 * 获取屏闪，广告导航等图片
	 * 
	 * @param cityCode
	 * @param type
	 * @return
	 */
	@GetMapping(value = "/findAuthority")
	public Json findAuthority(String cityCode) {
		Integer result = serviceIpService.selectAuthorityByCityCode(cityCode);
		return setSimpleSuccess(result == null ? 0 : result);
	}

	@PostMapping(value = "/addNews")
	public Json add_news(@Validated BusNews news, HttpServletRequest request) {
		String cityCode = news.getCityCode();
		ServiceIp service = serviceIpService.getServiceIp(cityCode);
		if (Objects.isNull(service)) {
			return setFailed("不存在cityCode为".concat(cityCode).concat("的城市"));
		}
		String ip = request.getRemoteAddr();
		if (StringUtils.isEmpty(service.getServiceip()) || service.getServiceip().indexOf(ip) < 0) {
			return setFailed("没有权限操作");
		}
		if (Objects.isNull(news.getCreatetime())) {
			news.setCreatetime(new Date());
		}
		return busNewsService.insertNews(news, request.getRemoteAddr()) ? setSimpleSuccess()
				: setFailed("添加失败，可能是添加的信息重复，也可能是您的添加次数已达今日上限。");
	}

	/**
	 * 单张图片上传
	 * 
	 * @param request
	 * @param file
	 * @return
	 */
	@PostMapping(value = "/upload")
	public Json upload(@RequestParam(value = "imageName"/* 重要：这个名字对应前端的要传文件的key */, required = false) MultipartFile file) {
		String[] str = file.getOriginalFilename().split("\\.");
		if (str == null || str.length < 2) {
			return setFailed("请选择要上传的图片");
		}
		// 获取文件扩展名
		String file_ext_name = str[str.length - 1];
		/* 保存到文件系统 */
		String fileId = saveToFastdfs(file, file_ext_name);
		return StringUtils.isEmpty(fileId) ? setFailed("上传失败") :
				setSimpleSuccess(ReadPropertyFromXmlBySpringBean.getFdsAddressPre() + fileId );
	}
	
	@PostMapping(value = "/editorImage")
	public String uploadEditorImage(@RequestParam(required = true) MultipartFile fileName) {
		String[] str = fileName.getOriginalFilename().split("\\.");
		if (str == null || str.length < 2) {
			return "error|请选择要上传的图片";
		}
		String file_ext_name = str[1];
		String fileId = saveToFastdfs(fileName, file_ext_name);	
		return StringUtils.isEmpty(fileId) ? "error|上传失败" :
			ReadPropertyFromXmlBySpringBean.getFdsAddressPre() + fileId;
	}
	
	
	/**
	 * 
	 * @Title: saveToFastdfs
	 * @Description: 保存到文件系统
	 * @param file
	 * @param file_ext_name
	 */
	private String saveToFastdfs(MultipartFile file, String file_ext_name) {
		try {
			// 上传后返回文件保存的路径
			return FastDFSHelper.storageClient1.upload_file1(file.getBytes(), file_ext_name, null);
		} catch (Exception e) {
			logger.error("上传图片到fastdfs出现了异常", e);
			return null;
		}
	}
}