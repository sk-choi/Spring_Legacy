package com.spring.real;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		
		return mav;
	}
}
