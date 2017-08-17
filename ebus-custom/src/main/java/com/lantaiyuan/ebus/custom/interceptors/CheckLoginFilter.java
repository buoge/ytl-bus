package com.lantaiyuan.ebus.custom.interceptors;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;


/**
 * @Title: CheckLoginFilter.java
 * @Package com.lantaiyuan.ebus.custom.interceptors
 * @Description:
 * @author yangyang
 * @date 2016年12月20日 下午2:14:06
 * @version v1.0
 */

public class CheckLoginFilter implements Filter {

	private String rootPath;

	public void destroy() {
		if (!StringUtils.isEmpty(rootPath)) {
			this.rootPath = null;
		}
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;
		Object session = request.getSession().getAttribute(SysGlobalConstants.USER_SESSION_KEY);
		String uri = request.getRequestURI().toLowerCase();
		if (StringUtils.isEmpty(session) && uri.indexOf("login") < 0 && uri.indexOf("logout") < 0) {
			// 设置header，便于ajax请求做处理
			response.setHeader("sessionstatus", "timeout");
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter()
					.println("<script language='javascript'>if(window.opener==null){window.top.location.href='"
							+ rootPath + "';}else{window.opener.top.location.href='" + rootPath
							+ "';window.close();}</script>");
			
		} else {
			chain.doFilter(req, res);
		}
	}

	public void init(FilterConfig con) throws ServletException {
		this.rootPath = con.getServletContext().getContextPath().concat(con.getInitParameter("rootPath"));
	}

}
