package com.bigdata.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Title:LogsInterceptor
 * @Description:ͳһ��־��������
 * @author:Rainbow.huahang.com
 * @date:2016��10��7�� ����11:25:29
 */
public class LogsInterceptor implements HandlerInterceptor {
	/**
	 * preHandle ��������ڽ���handler֮ǰִ�� false ��ʾ������ true ��ʾ ����
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle logs");
		return true;
	}

	/**
	 * postHandle �ڽ���handler֮�� ����modelAndView ֮ǰ ִ��
	 */

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle logs");
	}

	/**
	 * ���ִ�� ����ͬһ����־����ȳ���
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion logs");

	}

}
