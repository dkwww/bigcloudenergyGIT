package com.yidu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.yidu.domain.Admin;

@WebFilter("/*")
public class LoginFilter implements Filter{

	private static final Logger logger = Logger.getLogger(LoginFilter.class);

	public void destroy() {
		logger.info("销毁过滤器方法");
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest)request; 
		HttpServletResponse res = (HttpServletResponse)response; 
		HttpSession session = req.getSession(); 
		Admin admin = (Admin) session.getAttribute("user"); 
		String spath = req.getServletPath(); 
		logger.info("访问地址："+spath);

		String[] urls = {"/admin","/login","/json",".js",".css",".ico",".jpg",".png"}; 
		boolean flag = true; 
		for (String str : urls) { 
			if (spath.indexOf(str) != -1) { 
				flag =false; break; 
			} 
		} 

		if (flag) { 
			if (admin != null) { 
				chain.doFilter(request, response); 
			}else { 
				res.sendRedirect(req.getContextPath()+"/pages/admin/login.html"); 
			} 
		} else { 
			chain.doFilter(request, response); 
		}

	}


	public void init(FilterConfig arg0) throws ServletException {
		logger.info("初始化过滤器的方法");
	}


}
