package com.lec.board;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import com_jdbc.BoardDAO;

@WebServlet("/rest")
public class RestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //문자를 문자로
   		//response.setContentType("text/html; charset=UTF-8");
   		
   		String pageGubun = request.getParameter("pageGubun");
   		String str       = request.getParameter("mykey");
		System.out.println(str  + "," + pageGubun);
		
		PrintWriter out = response.getWriter();
		out.write("111.server:String:200ok");		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
   		response.setContentType("text/html; charset=UTF-8");
   		
   		
   		String pageGubun = request.getParameter("pageGubun");
		
		if(pageGubun.equals("2test")) {   //json 형태의 문자를 문자로
			response.setContentType("text/html; charset=UTF-8");
	   		String mykeyStr       = request.getParameter("mykey");
	   		
	   		System.out.println(mykeyStr + "," +pageGubun);
			
	   		PrintWriter out = response.getWriter();
			out.write("222.server:String:200ok");
			
			/* -------------------- JsonString 을 Json 객체로 변환 -------------------- */ 
			//언마셜링(Unmarshalling): 문자열 형식으로 변환된 데이터를 다시 객체 형태로 복원하는 과정
			/* --------------------------------------------------------------------- */
			
			ObjectMapper mapper = new ObjectMapper();
			HashMap<String, String> resMap = mapper.readValue(mykeyStr, HashMap.class);
			System.out.println(resMap.get("upw"));   //{"uid":"333","upw":"1111"}
			
			JsonNode node = mapper.readTree(mykeyStr); //json 문자열을 받아서 json객체로 반환
			System.out.println(node.get("upw").asText());
			
			Gson g = new Gson();
			HashMap<String, String> resMap2 = g.fromJson(mykeyStr, HashMap.class); 
			System.out.println(resMap2.get("upw"));
			
		} else if(pageGubun.equals("3test")) { //json을 문자로
			response.setContentType("text/html; charset=UTF-8");
			String joiningStr = request.getReader().lines().collect(Collectors.joining()); //HTTP 요청 본문이 하나의 문자열로 합쳐진다.
			System.out.println(joiningStr  + "," + pageGubun);
			
			PrintWriter out = response.getWriter();
			out.write("333.server:String:200ok");
			
			
		} else if(pageGubun.equals("4test")) { //문자를 json 형태의 문자로
			response.setContentType("text/html; charset=UTF-8");  //★★★★★★★★★★★★★★★★★★★★★★★★
			
			String searchStr       = request.getParameter("searchStr");
			String userid       = request.getParameter("userid");
			String userpw       = request.getParameter("userpw");
			System.out.println(searchStr  + "," + userid + "," + userpw);
			
			
			HashMap<String, String> responseMap = new HashMap<String, String>();
			responseMap.put("status", "200");
			responseMap.put("message", "okmap444444");
			
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(responseMap);
			System.out.println(jsonString);
			
			PrintWriter out = response.getWriter();
			out.write(jsonString);	
			
		} else if(pageGubun.equals("5test")) {	//json형태의 문자를 json으로
			String mykeyStr       = request.getParameter("mykey");
	   		System.out.println(mykeyStr + "," +pageGubun);
	   		
	   		//언마셜링
	   		Gson g = new Gson();
			HashMap<String, String> resMap2 = g.fromJson(mykeyStr, HashMap.class); 
			System.out.println(resMap2.get("upw"));
		
			
			
			/* --------------------- 객체를 --> JsonString 로 변환 -------------------- */ 
			//마셜링(Marshalling): 객체 데이터를 --> 문자열 형식(JSON, XML 등)으로 변환하는 과정
			/* --------------------------------------------------------------------- */
			response.setContentType("application/json; charset=UTF-8");  //★★★★★★★★★★★★★★★★★★★★★★★★
			
			HashMap<String, String> responseMap = new HashMap<String, String>();
			responseMap.put("status", "200");
			responseMap.put("message", "okmap");
			
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(responseMap);
			System.out.println(jsonString);
			
			String jsonString2 = g.toJson(responseMap);
			System.out.println(jsonString2);
			
			PrintWriter out = response.getWriter();
			out.write(jsonString);	
		} else if(pageGubun.equals("6test")) {	//json을 json으로
		
			String joiningStr = request.getReader().lines().collect(Collectors.joining());
			System.out.println(joiningStr  + "," + pageGubun);
			
			
			/* --------------------- 객체를 --> JsonString 로 변환 -------------------- */ 
			//마셜링(Marshalling): 객체 데이터를 --> 문자열 형식(JSON, XML 등)으로 변환하는 과정
			/* --------------------------------------------------------------------- */
			response.setContentType("application/json; charset=UTF-8");  //★★★★★★★★★★★★★★★★★★★★★★★★
			
			HashMap<String, String> responseMap = new HashMap<String, String>();
			responseMap.put("status", "200");
			responseMap.put("message", "okmap666666");
			
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(responseMap);
			System.out.println(jsonString);
			
			PrintWriter out = response.getWriter();
			out.write(jsonString);
			
		} else if(pageGubun.equals("emp_rest")) {
			
			response.setContentType("application/json; charset=UTF-8");
			
			BoardDAO dao = new BoardDAO();
			ArrayList<MyBoardVO> alist = new ArrayList<MyBoardVO>();
			
			System.out.println(dao.select(2).toString());
			
			alist.add(dao.select(2));
			System.out.println(alist.toString() + "," + alist.size());
			
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(alist);
			System.out.println(jsonString);
			
			PrintWriter out = response.getWriter();
			out.write(jsonString);
			
		}
	}

}
