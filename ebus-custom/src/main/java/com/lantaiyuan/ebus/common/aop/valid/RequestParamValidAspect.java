package com.lantaiyuan.ebus.common.aop.valid;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.lanqiao.ssm.common.web.valid.FieldError;
import org.lanqiao.ssm.common.web.valid.ParamValidException;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 
 * @Title: RequestParamValidAspect.java
 * @Package com.lantaiyuan.ebus.common.aop.valid
 * @Description: 前端参数验证切面
 * @author 刘伟 15818570028@163.com
 * @date 2017年3月22日 上午11:06:54
 * @version V1.2
 */
@Component
@Aspect
@Order(value = 30)
public class RequestParamValidAspect {

	private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private final ExecutableValidator validator = factory.getValidator().forExecutables();

	@Pointcut("execution (* com.lantaiyuan.ebus.*.controller..*.*(..))")
	public void controllerBefore() {
	};

	ParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();

	@Before("controllerBefore()")
	public void before(JoinPoint point) throws NoSuchMethodException, SecurityException, ParamValidException {
		Object target = point.getThis();
		Object[] args = point.getArgs();
		Method method = ((MethodSignature) point.getSignature()).getMethod();
		Set<ConstraintViolation<Object>> validResult = validMethodParams(target, method, args);
		if (!validResult.isEmpty()) {
			String[] parameterNames = parameterNameDiscoverer.getParameterNames(method);
			List<FieldError> errors = validResult.stream().map(constraintViolation -> {
				PathImpl pathImpl = (PathImpl) constraintViolation.getPropertyPath();
				int paramIndex = pathImpl.getLeafNode().getParameterIndex();
				String paramName = parameterNames[paramIndex];
				FieldError error = new FieldError();
				error.setName(paramName);
				error.setMessage(constraintViolation.getMessage());
				return error;
			}).collect(Collectors.toList());
			throw new ParamValidException(errors);
		}
	}

	private <T> Set<ConstraintViolation<T>> validMethodParams(T obj, Method method, Object[] params) {
		return validator.validateParameters(obj, method, params);
	}

}
