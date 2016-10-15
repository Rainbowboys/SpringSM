package com.bigdata.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class LoginController {
	/**
	 * µÇÂ½À¹½ØÆ÷²âÊÔ
	 * 
	 * @param session
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/login")
	public String login(HttpSession session, String username, String password) {
		session.setAttribute("username", username);
		return "redirect:/items/queryItems.action";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session, String username, String password) {

		session.removeAttribute("username");
		return "login";
	}
}
