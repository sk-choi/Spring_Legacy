package com.spring.real;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {
	//@Override
	//public ModelAndView  handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView myLogin(@ModelAttribute UserVO vo, HttpServletRequest request) {
//		String key = request.getParameter("key");
//		if(key.equals("login.do")) {
//		}else if(key.equals("login.do")) {
//		}
		//@ModelAttribute
		//1. 사용자 입력정보(id,pw) 추출 코드
		
		
		//2. 사용자 입력 정보 이용 UserVO 객체 조회
		//setter()로 UserService객체 못 받아올 경우 아래 주석풀고 실행
		UserService userService = new UserServiceImpl();
		vo = userService.getUser(vo);
		
		//3. DB 연동 로직 구현(USERDAO 객체 사용)
		String viewName="";
		if(!vo.getName().equals("")) {
			HttpSession session = request.getSession();
			session.setAttribute("SESS_ID", vo.getId());
			session.setAttribute("SESS_NAME", vo.getName());
			viewName = "main";
		} else {
			viewName = "login";
		} 
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("KEY_VO", vo);
		return mav;
	}
}
