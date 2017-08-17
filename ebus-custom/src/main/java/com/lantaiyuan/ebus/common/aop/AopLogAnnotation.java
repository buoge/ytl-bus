package com.lantaiyuan.ebus.common.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName: AopLogAnnotation
 * @Description:(自定义注解)
 * @author 刘伟
 * @date 2016年1月8日 下午1:26:26
 *
 */

@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AopLogAnnotation {

	String description() default "方法描述";

	String modelName() default "模块名字";

	String option() default "操作";

}