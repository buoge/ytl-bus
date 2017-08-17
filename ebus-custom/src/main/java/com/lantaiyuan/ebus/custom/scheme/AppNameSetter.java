package com.lantaiyuan.ebus.custom.scheme;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

/** 
 * 将项目名称设置到servletContext里
 * @author yangyang
 * @date 2017年5月2日 下午3:18:26 
 */
public class AppNameSetter implements  ServletContextAware{
	@Override
    public void setServletContext(ServletContext servletContext) {
    	servletContext.setAttribute("appName", servletContext.getContextPath());
    }

}
