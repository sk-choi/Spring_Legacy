package com.lec.di;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 * Handles requests for the application home page.
 */
// @Controller


public class XmlController extends MultiActionController{
	
	private static final Logger logger = LoggerFactory.getLogger(XmlController.class);
	
	//생성자 방식 DI
//	private TestDAO dao;
//	
//	public XmlController(TestDAO dao) {
//		this.dao = dao;
//	}
	
	private TestDAO myDAO;
	public void setMyDAO(TestDAO dao) {
		this.myDAO = dao;
	}
	
	//@RequestMapping(value = "/xml_ctl", method = RequestMethod.GET)
	
	
	
	public ModelAndView xmlFunc(HttpServletRequest request, HttpServletResponse response) {
		
		//TestDAO dao = new TestDAO();
		//dao.insert();
		myDAO.insert();
		
		System.out.println("XmlController.xmlFun() 호출");
		ModelAndView mav = new ModelAndView();
		mav.addObject("MY_MSG", "OK");
		mav.setViewName("lec01/result");
		
		return mav;
	}
	
	public ModelAndView xmlFunc2(HttpServletRequest request, HttpServletResponse response) {
		
		//TestDAO dao = new TestDAO();
		//dao.insert();
		System.out.println("XmlController.xmlFun2() 호출");
		ModelAndView mav = new ModelAndView();
		mav.addObject("MY_MSG", "OK");
		mav.setViewName("lec01/result");
		
		return mav;
	}
	
}
