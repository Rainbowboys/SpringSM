package com.bigdata.ssm.interceptor;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Title:LonginInterceptor
 * @Description:登录验证的拦截器
 * @author:Rainbow.huahang.com
 * @date:2016年10月7日 上午11:25:29
 */
public class LonginInterceptor implements HandlerInterceptor {
	private static Set<String> paths = new HashSet<>();

	static {
		paths.add("/users/login.action");
	}

	/**
	 * preHandle 这个方法在进入handler之前执行 false 表示不放行 true 表示 放行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 获取请求的url
		String url = request.getRequestURI();
		String path=request.getServletPath();
		System.out.println(path);
		if (paths.contains(path)) {
			// 放行
			return true;
		}
		// 获取session
		HttpSession session = request.getSession();
		if (session.getAttribute("username") != null) {
			// 放行
			return true;
		}
		// 不放行 返回登陆界面
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		return false;
	}

	/**
	 * postHandle 在进入handler之后 返回modelAndView 之前 执行
	 */

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle login");
	}

	/**
	 * 最后执行 用于同一的日志管理等场景
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion login");

	}

}
