package com.yidu.filter;
 
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
 
 
public class MyFilter implements Filter{
 
	private static final Logger logger = Logger.getLogger(MyFilter.class);
	
	public void destroy() {
		System.out.println("销毁过滤器方法");
		logger.info("销毁过滤器方法");
	}
 
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest  request=(HttpServletRequest) req;
        String servletPath = request.getServletPath();
        logger.info("请求路径过滤信息路径为：" + servletPath);
        
        //访问login.html时，才放过，并且login.jsp的后续操作，继续执行，不拦截
        if (servletPath.equals("/login.html")  ) {
            chain.doFilter(req, res);
            return;
		}else {
			String contextPath=request.getContextPath();
 	        response.setCharacterEncoding("utf-8");
		    request.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			//否则拦截，跳转指定的页面
			pw.print("<script>window.top.location.href='"+contextPath + "/login.html'"+";</script>");
		}
		
	}
 
	
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("初始化过滤器的方法");
		logger.info("初始化过滤器的方法");
	}
	
 
}