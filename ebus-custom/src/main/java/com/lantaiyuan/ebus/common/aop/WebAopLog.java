package com.lantaiyuan.ebus.common.aop;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.lanqiao.ssm.common.constant.LogConstant;
import org.lanqiao.ssm.common.util.DateFormatUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;

/**
 * 
 * @ClassName: AopLog
 * @Description: 接入层aop日志
 * @author 刘伟
 * @date 2016年1月8日 下午12:26:15
 *
 */
@Component
@Aspect
@Order(value = 5)
public class WebAopLog {
	private final static Logger logger = LoggerFactory.getLogger(WebAopLog.class);

	private final static String WEB = "WEB层：";

	@Pointcut("execution (* com.lantaiyuan.ebus.*.controller..*.*(..))")
	public void webLog() {

	}

	// 方法执行的前后调用
	@Around("webLog()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		if (logger.isInfoEnabled()) {

			AopID.logid.set(LogConstant.LOG_MARK.concat("AopID:").concat(String.valueOf(System.currentTimeMillis()))
					.concat("========》"));
			logger.info("{}{}拦截方法,进入日志记录,请求时间是==={}", AopID.logid.get(), WEB,
					DateFormatUtil.getDateFormat().format(new Date()));
		}
		// 拦截的实体类
		Object target = point.getTarget();

		// 拦截的方法名称
		String methodName = point.getSignature().getName();
		String methodFullName = point.getSignature().toShortString();
		logger.info("{}{},拦截的方法名称:{}", AopID.logid.get(), WEB, methodFullName);
		// 拦截的方法参数
		Object[] args = point.getArgs();

		// 拦截的放参数类型
		@SuppressWarnings("rawtypes")
		Class[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();

		Object object = null;
		String jsonString = "";
		// 需要转换成Json的HashMap
		Map<String, Object> maps = Maps.newHashMap();
		Map<String, Object> parammaps = Maps.newHashMap();
		// 获得被拦截的方法
		Method method = target.getClass().getMethod(methodName, parameterTypes);
		if (null != method) {
			// 判断是否包含自定义的注解 和controller的注解
			if (method.isAnnotationPresent(RequestMapping.class)) {
				// 获取自定义注解实体
				RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
				logger.info("{}{}请求路径:{}", AopID.logid.get(), WEB, requestMapping.value()[0]);
				// 循环获得所有参数对象
				for (int i = 0; i < args.length; i++) {
					if (null != args[i]) {
						parammaps.put("args[" + i + "]", args[i]);
					} else {
						parammaps.put("args[" + i + "]", "空参数");
					}
				}
				maps.put("参数", parammaps);
				if (logger.isInfoEnabled()) {

					try {
						jsonString = new JSONObject(maps).toJSONString();
					} catch (Exception e) {
					}
					logger.info("{}{}方法执行之前的参数{}", AopID.logid.get(), WEB, jsonString);
				}

				// 获取服务运行结果
				object = point.proceed();// 执行该方法
				if (logger.isInfoEnabled()) {

					try {
						jsonString = new JSONObject(maps).toJSONString();
					} catch (Exception e) {
					}
					logger.info("{}{}方法执行之后的参数{}", AopID.logid.get(), WEB, jsonString);
				}

			} else { // 没有包含该注解则不进行其他处理
				object = point.proceed();// 执行该方法
			}

		} else { // 不需要拦截，直接运行
			object = point.proceed(); // 执行该方法
		}
		return object;
	}

	@AfterReturning(pointcut = "webLog()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		if (logger.isInfoEnabled()) {
			logger.info("{}{}方法执行之后返回内容:The method{} return with{}", AopID.logid.get(), WEB, methodName,
					JSON.toJSONString(result));
			logger.info("{}{}方法结束时间是：{}", AopID.logid.get(), WEB, DateFormatUtil.getDateFormat().format(new Date()));
		}
	}

	// 方法运行出现异常时调用
	@AfterThrowing(pointcut = "webLog()", throwing = "ex")
	public void afterThrowing(Exception ex) {
		logger.error(AopID.logid.get() + WEB + "出现异常了==========afterThrowing=============", ex);
	}

}
