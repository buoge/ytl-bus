package com.lantaiyuan.ebus.custom.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.lantaiyuan.ebus.custom.model.enummodel.CMDEnum;
import com.lantaiyuan.ebus.custom.service.DataCollectServiceI;

/**
 * 描述:该拦截器用于处理前端传过来的埋点信息 作者:温海金 最后更改时间:下午3:36:32
 */
public class DataCollectionInterceptor implements HandlerInterceptor {
	private DataCollectServiceI dataCollectService;

	/**
	 * 命令模式类型参数名称，用来区分某个具体的埋点操作
	 */
	private static final String CMD = "cmd";
	/**
	 * 具体埋点数据json串参数名称
	 */
	private static final String DATA_COLLECTION = "datacollection";

	public DataCollectServiceI getDataCollectService() {
		return dataCollectService;
	}

	public void setDataCollectService(DataCollectServiceI dataCollectService) {
		this.dataCollectService = dataCollectService;
	}

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	/**
	 * 描述:该方法处理前端传过来的埋点信息 作者:温海金 参数: 1. cmd:埋点类型 2.
	 * dataAcquisition:具体的埋点信息json串,例如:{userid:"10",phonemodel:"JKFDIJF",citycode:"440300",startplace:"西丽法庭",endplace:"豪威大厦",currentposition:"西丽法庭",currentlongitude:"109.265667",currentlatitude:"24.366528"}
	 * 调用格式:
	 * http://localhost:8080/version/needUpdate/600440/1.1.2/0?cmd=1&datacollection={userid:"10",phonemodel:"JKFDIJF",citycode:"440300",startplace:"西丽法庭",endplace:"豪威大厦",currentposition:"西丽法庭",currentlongitude:"109.265667",currentlatitude:"24.366528"}
	 * 最后更改时间:下午3:36:32
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String cmd = request.getParameter(CMD);
		String datacollection = request.getParameter(DATA_COLLECTION);
		if (!StringUtils.isEmpty(cmd) && !StringUtils.isEmpty(datacollection)) {
			// 根据埋点类型（cmd）处理具体的埋点信息
			handleDataCollection(cmd, datacollection);
		}
		return true;
	}

	private void handleDataCollection(String cmd, String datacollection) {
		CMDEnum cmdEnum = CMDEnum.valueOf(Integer.valueOf(cmd));
		dataCollectService.handleDataCollection(cmdEnum, datacollection);
	}
}
