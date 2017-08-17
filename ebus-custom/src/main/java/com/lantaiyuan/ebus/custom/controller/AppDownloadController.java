/**
* <p>Title: QueryController.java</p>
* <p>Copyright: Copyright (c) 2016</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.custom.controller;

import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
* @Title: AppDownloadController.java
* @Package com.lantaiyuan.ebus.custom.controller
* @Description: 
* @author yangyang   
* @date 2017年1月18日 上午10:02:48
* @version v1.0
 */
@Controller
@RequestMapping("/gj")
public class AppDownloadController extends BasicController{
	
	
	@GetMapping(value = "/zuogongjiao")
	public String appDownload () {
	    return "redirect:/appDownload/index.html"; 
	}
	
	@GetMapping(value = "/baoji")
	public String appDownloadForBaoji () {
	    return "redirect:/appDownload/index.html"; 
	}
	
	
}
