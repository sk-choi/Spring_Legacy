package com.lec.di;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller //@Controller 자체가 bean 등록 된 것.
public class AnnoController {
	
	private static final Logger logger = LoggerFactory.getLogger(AnnoController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired //setter function 만들기와 같다.
	//annotation 방식과 생성자 방식이 공존할 수 있다.
	private TestDAO dao;
	
	@RequestMapping(value = "/kosta/anno", method = RequestMethod.GET)
	public ModelAndView anno(Model model) { // String, Void, Model, Model and View
		
		dao.insert();
//		model.addAttribute("MY_MSG", "OK");
//		
//		return "lec01/result";
		
		System.out.println("AnnoController.anno() 호출");
		ModelAndView mav = new ModelAndView();
		mav.addObject("MY_MSG", "OK");
		mav.setViewName("lec01/result");
		
		return mav;
	}
	
}
