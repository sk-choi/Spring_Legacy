package com.spring.fake;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller {
	
	public String handlerRequest(HttpServletRequest request , HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "login";
	}
}
