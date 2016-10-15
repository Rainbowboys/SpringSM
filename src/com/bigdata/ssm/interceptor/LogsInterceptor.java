package com.bigdata.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Title:LogsInterceptor
 * @Description:统一日志的拦截器
 * @author:Rainbow.huahang.com
 * @date:2016年10月7日 上午11:25:29
 */
public class LogsInterceptor implements HandlerInterceptor {
	/**
	 * preHandle 这个方法在进入handler之前执行 false 表示不放行 true 表示 放行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle logs");
		return true;
	}

	/**
	 * postHandle 在进入handler之后 返回modelAndView 之前 执行
	 */

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle logs");
	}

	/**
	 * 最后执行 用于同一的日志管理等场景
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion logs");

	}

}
