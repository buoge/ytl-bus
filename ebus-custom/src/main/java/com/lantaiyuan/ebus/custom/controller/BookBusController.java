package com.lantaiyuan.ebus.custom.controller;

import javax.annotation.Resource;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lantaiyuan.ebus.custom.service.BookBusServiceI;

/**
 * 
  * @ClassName: BookBusController
  * @Description: 专车
  * @author Yuan.Tan
  * @date 2016年11月8日 上午11:38:59
  *
 */
@RestController
@RequestMapping("/bookBus")
public class BookBusController extends BasicController{
	@Resource
	private BookBusServiceI bookBusService;
	
	/**
	 * 功能描述:专车开通
	 * 作者:温海金
	 * 最后更改时间 : 2017年02月21日 下午3:15:44
	 */
	@PostMapping(value = "/openCustomBus/{id}")
	public Object openCustomBus(@PathVariable String id) {
	    return setSimpleSuccess(bookBusService.openCustomBus(id));
	}
}
