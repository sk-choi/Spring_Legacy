package com.spring.fake;

import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.fake.HandlerMapping;
import com.spring.fake.ViewResolver;

//@WebServlet("/DispatcherServlet.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.TO DO
		//사용자 요청 Path 정보 추출
		// http://127.0.0.1:8080/user/login.do
		String path = request.getRequestURI();  //  /login.do
		
		//2.사용자 요청 path에 해당하는 controller 검색
		HandlerMapping mapping = new HandlerMapping();
		Controller controller = mapping.getController(path); //TODO;
		
		//3.검색된 Controller의 메소드를 호출하여 로직을 처리한다.
		String viewName = controller.handlerRequest(request, response); //TODO
				
		ViewResolver viewResolver = new ViewResolver();
		viewResolver.setPrefix("/");
		viewResolver.setSuffix(".jsp");
		
		String viewPage = viewResolver.getView(viewName); //TODO
		response.sendRedirect(viewPage);
	}

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   doGet(request,response);
   }
}
