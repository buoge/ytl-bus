/**
* <p>Title: MySettingsController.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.custom.controller;

import javax.annotation.Resource;
import org.lanqiao.fdfs.FastDFSHelper;
import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.lantaiyuan.ebus.common.constants.ReadPropertyFromXmlBySpringBean;
import com.lantaiyuan.ebus.custom.service.MySettingsServiceI;

/**
* <p>Title: MySettingsController</p>
* <p>Description: 我的设置控制器</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年2月18日 上午9:53:39
*/
@RestController
@RequestMapping("/mySettings")
public class MySettingsController extends BasicController{
	@Resource
	private MySettingsServiceI mySettingsService;
	
	/**
	 * 功能描述:根据用户Id查看我的行程列表
	 * 作者:温海金
	 * 最后更改时间 : 2017年2月23日 下午5:08:39
	 */
	@GetMapping(value = "/getMyTrailByUserId/{userId}")
	public Json getMyTrailByUserId(@PathVariable Integer userId) {
		return setSimpleSuccess(mySettingsService.selectByUserId(userId));
	}
	
	/**
	 * 获取我的行程
	 * 
	 * @param request
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/myTrailById")
	public Json getMyTrailById(@RequestParam(value = "id", required = false) String id) {
		return setSimpleSuccess(mySettingsService.getMyTrailById(id));
	}
	/**
	 * 背景墙图片上传
	 * 
	 * @param request
	 * @param file
	 * @return
	 */
	@PostMapping(value = "/upload")
	public Json upload(@RequestParam(value = "imageName"/* 重要：这个名字对应前端的要传文件的key */, required = false) MultipartFile file) {
		String[] str = file.getOriginalFilename().split("\\.");
		if (str == null || str.length < 2) {
			return setFailed("请选择要上传的背景图片");
		}
		// 获取文件扩展名
		String file_ext_name = str[1];
		/* 保存到文件系统 */
		String fileId = saveToFastdfs(file, file_ext_name);
		return StringUtils.isEmpty(fileId) ? setFailed("上传失败") :
				setSimpleSuccess(ReadPropertyFromXmlBySpringBean.getFdsAddressPre() + fileId );
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
