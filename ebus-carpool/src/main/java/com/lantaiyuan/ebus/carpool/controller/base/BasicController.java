package com.lantaiyuan.ebus.carpool.controller.base;

import org.lanqiao.ssm.common.model.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import com.lantaiyuan.ebus.carpool.enums.ReturnStatusEnum;

/**
 * 
 * @Title: BasicController.java
 * @Package org.lanqiao.ssm.common.web.controller.base
 * @Description: (基础的控制类)
 * @author 刘伟 15818570028@163.com
 * @date 2016年10月2日 下午5:32:35
 * @version V1.0
 */
public class BasicController {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 
	 * @Title: setSuccessModelMap
	 * @Description: (标准格式设置成功响应代码)
	 * @param @param
	 *            modelMap 需要返回的数据modelmap
	 * @param @return
	 *            设定文件
	 * @return ResponseEntity<ModelMap> 返回类型
	 * 
	 */
	protected ResponseEntity<ModelMap> setSuccessModelMap(ModelMap modelMap) {
		return setSuccessModelMap(modelMap, null);
	}

	/** 设置成功响应代码 */
	/**
	 * 
	 * @Title: setSuccessModelMap
	 * @Description: (标准格式设置成功响应代码)
	 * @param @param
	 *            modelMap 需要返回的数据modelmap
	 * @param @param
	 *            data 需要返回的数据集
	 * @param @return
	 *            设定文件
	 * @return ResponseEntity<ModelMap> 返回类型
	 * 
	 */
	protected ResponseEntity<ModelMap> setSuccessModelMap(ModelMap modelMap, Object data) {
		return setModelMap(modelMap, ReturnStatusEnum.SUCCESS, data, null);
	}

	/**
	 * 
	 * 
	 * @Description: (标准格式设置成功响应代码)
	 * @param @param
	 *            modelMap
	 * @param @param
	 *            code 代码
	 * @param @return
	 *            设定文件
	 * @return ResponseEntity<ModelMap> 返回类型
	 * 
	 */
	protected ResponseEntity<ModelMap> setModelMap(ModelMap modelMap, ReturnStatusEnum code) {
		return setModelMap(modelMap, code, null, null);
	}

	/**
	 * 
	 * @Title: setModelMap
	 * @Description: (这里用一句话描述这个方法的作用)
	 * @param @param
	 *            modelMap
	 * @param @param
	 *            code
	 * @param @param
	 *            data
	 * @param @param
	 *            msg
	 * @param @return
	 *            ResponseEntity<ModelMap>
	 * @return ResponseEntity<ModelMap> 返回类型
	 * 
	 */
	protected ResponseEntity<ModelMap> setModelMap(ModelMap modelMap, ReturnStatusEnum status, Object data,
			String msg) {
		if (data != null) {
			modelMap.put("data", data);
		} else {
			modelMap.put("data", "defult");
		}
		modelMap.put("statusCode", status.value());
		if (!StringUtils.isEmpty(msg)) {
			modelMap.put("msg", "1111");
		} else {
			modelMap.put("msg", status.description());
		}
		return ResponseEntity.ok(modelMap);
	}

	/**
	 * 
	 * @Title: setSimpleSuccess
	 * @Description: (简单设置成功)
	 * @param @return
	 * @return 返回类型 Json
	 * 
	 */
	protected Json setSimpleSuccess() {
		return setSimpleSuccess(null);
	}

	/**
	 * 
	 * @Title: setSimpleSuccess
	 * @Description: (简单设置成功)
	 * @param @param
	 *            succecss
	 * @param @return
	 * @return 返回类型 Json
	 * 
	 */
	protected Json setSimpleSuccess(boolean succecss) {
		return setSimpleSuccess(null);
	}

	/**
	 * 
	 * @Title: setSimpleSuccess
	 * @Description: (简单设置成功)
	 * @param @param
	 *            obj 需要返回的数据集
	 * @param @return
	 * @return 返回类型 Json
	 * 
	 */
	protected Json setSimpleSuccess(Object obj) {
		return setSimpleSuccess(ReturnStatusEnum.SUCCESS.description(), obj);
	}

	/**
	 * 
	 * @Title: setSimpleSuccess
	 * @Description: (快速设置失败)
	 * @param @param
	 *            msg 返回的提示信息
	 * @param @param
	 *            obj 返回的数据集
	 * @param @return
	 * @return 返回类型 Json
	 * 
	 */
	protected Json setSimpleSuccess(String msg, Object obj) {
		return new Json().setMsg(msg).setObj(obj).setSuccess(true).setStatusCode(ReturnStatusEnum.SUCCESS.value());
	}

	/**
	 * 
	 * @Title: setFailed
	 * @Description: (快速失败)
	 * @param @return
	 * @return 返回类型 Json
	 * 
	 */
	protected Json setFailed() {
		return setFailed(ReturnStatusEnum.OPERATOR_FAIL);
	}

	/**
	 * 
	 * @Title: setFailed
	 * @Description: (快速设置失败)
	 * @param @param
	 *            msg 失败的提示信息
	 * @param @return
	 * @return 返回类型 Json
	 * 
	 */
	protected Json setFailed(String msg) {
		return setFailed(ReturnStatusEnum.OPERATOR_FAIL, null, msg);
	}

	protected Json setFailed(ReturnStatusEnum status) {
		return setFailed(status, null);
	}

	/**
	 * 
	 * @Title: setFailed
	 * @Description: (快速设置失败)
	 * @param @param
	 *            msg 失败的提示信息
	 * @param @return
	 * @return 返回类型 Json
	 * 
	 */
	protected Json setFailed(ReturnStatusEnum status, Object obj) {
		return setFailed(status, obj, null);
	}

	/**
	 * 
	 * @Title: setFailed
	 * @Description: (快速设置失败)
	 * @param @param
	 *            msg 失败的提示信息
	 * @param @return
	 * @return 返回类型 Json
	 * 
	 */
	protected Json setFailed(ReturnStatusEnum status, Object obj, String msg) {
		Json json = new Json();
		if (status == null) {
			status = ReturnStatusEnum.SERVER_INSIDE_FAIL;
		}
		if (StringUtils.isEmpty(msg)) {
			json.setMsg(status.description());
		} else {
			json.setMsg(msg);
		}
		return json.setObj(obj).setStatusCode(status.value());
	}

}
