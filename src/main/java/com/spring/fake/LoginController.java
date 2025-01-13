package com.spring.fake;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spring.fake.UserService;


public class LoginController implements Controller {
	public String handlerRequest(HttpServletRequest request,
			HttpServletResponse response) {
//		String key = request.getParameter("key");
//		if(key.equals("login.do")) {
//		}else if(key.equals("login.do")) {
//		}
		//@ModelAttribute
		//1. 사용자 입력정보(id,pw) 추출 코드
		UserVO vo = new UserVO(); 
		vo.setId(request.getParameter("id"));
		vo.setPw(request.getParameter("pw"));
		
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
		return viewName;
	}
}
