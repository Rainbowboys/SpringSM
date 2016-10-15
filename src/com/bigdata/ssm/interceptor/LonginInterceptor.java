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
 * @Description:��¼��֤��������
 * @author:Rainbow.huahang.com
 * @date:2016��10��7�� ����11:25:29
 */
public class LonginInterceptor implements HandlerInterceptor {
	private static Set<String> paths = new HashSet<>();

	static {
		paths.add("/users/login.action");
	}

	/**
	 * preHandle ��������ڽ���handler֮ǰִ�� false ��ʾ������ true ��ʾ ����
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// ��ȡ�����url
		String url = request.getRequestURI();
		String path=request.getServletPath();
		System.out.println(path);
		if (paths.contains(path)) {
			// ����
			return true;
		}
		// ��ȡsession
		HttpSession session = request.getSession();
		if (session.getAttribute("username") != null) {
			// ����
			return true;
		}
		// ������ ���ص�½����
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		return false;
	}

	/**
	 * postHandle �ڽ���handler֮�� ����modelAndView ֮ǰ ִ��
	 */

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle login");
	}

	/**
	 * ���ִ�� ����ͬһ����־����ȳ���
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion login");

	}

}
