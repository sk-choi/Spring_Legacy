package com.sb.rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sb.board.MyboardDAO;
import com.sb.board.MyboardVO;

@WebServlet("/search")
public class BoardRestSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("UTF-8");
   		response.setContentType("text/html; charset=UTF-8");
		
   		//--------------------------------------------------------------- request : 요청파라미터
   		//searchGubun=title&searchStr=대한
   		String searchGubun = request.getParameter("searchGubun");
   		String searchStr   = request.getParameter("searchStr");
   		System.out.println(searchGubun + "," + searchStr);
   	
   		//---------------------------------------------------------------
   		//TODO 비즈니스로직
   		MyboardDAO dao = new MyboardDAO();
   		ArrayList<MyboardVO>  alist = dao.myboardSelect(searchGubun, searchStr);
   		//for(MyboardVO bvo : alist) { 
   		//	System.out.println(bvo.getTitle());
   		//}
   		
   		//--------------------------------------------------------------- response : JSON응답생성
   		response.setContentType("application/json; charset=UTF-8");
   		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(alist);
		System.out.println(jsonString);
		
		PrintWriter out = response.getWriter();
		out.write(jsonString);	
   		
   		
   		
	}

}
