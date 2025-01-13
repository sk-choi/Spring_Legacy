package com.spring.fake;

import java.util.HashMap;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;
	
	public HandlerMapping(){
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/logout.do", new LogoutController());
	}
	
	public Controller getController(String path) {
		//TODO. 특정 요청 URL에 해당하는 Controller 리턴
		return mappings.get(path);	
	}
}
