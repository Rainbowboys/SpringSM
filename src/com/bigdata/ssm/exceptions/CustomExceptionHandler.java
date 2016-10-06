package com.bigdata.ssm.exceptions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Title:CustomExceptionHandler
 * @Description: 自定义的全局异常处理类
 * @author:Rainbow.huahang.com
 * @date:2016年10月6日 下午6:36:10
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
			customException = new CustomException("未知异常");
		}
		message = customException.getMessage();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", message);
		modelAndView.setViewName("error");
		return modelAndView;
	}

}
