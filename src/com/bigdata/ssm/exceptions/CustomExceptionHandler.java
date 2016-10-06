package com.bigdata.ssm.exceptions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Title:CustomExceptionHandler
 * @Description: �Զ����ȫ���쳣������
 * @author:Rainbow.huahang.com
 * @date:2016��10��6�� ����6:36:10
 */
public class CustomExceptionHandler implements HandlerExceptionResolver {
	private String message;

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception ex) {
		CustomException customException = null;
		if (ex instanceof CustomException) {
			customException = (CustomException) ex;
		} else {
			customException = new CustomException("δ֪�쳣");
		}
		message = customException.getMessage();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", message);
		modelAndView.setViewName("error");
		return modelAndView;
	}

}
