package com.lec.aop.xml;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.lec.di.AnnoController;

/**
 * Handles requests for the application home page.
 */
public class AOPController extends MultiActionController {
	
	private static final Logger logger = LoggerFactory.getLogger(AnnoController.class);
	
	private AOPService aOPService;
	
	public void setAOPService(AOPService aa) {
		this.aOPService = aa;
	}
//	public AOPController(AOPService aaa) {
//		this.aOPService = aaa;
//	}

	//@RequestMapping(value = "/xml_aop", method = RequestMethod.GET)
	public ModelAndView ctlDelete(HttpServletRequest request, HttpServletResponse response) {
		logger.info("로거 테스트------------");
		System.out.println("1._______AOPController.ctlDelete() 실행");
		//aOPService.svcDelete();
		
		try {
			aOPService.svcDelete();
		} catch(RuntimeException e) {
			System.out.println("___ctl catch...");
		}
		
		//aOPService2.svcInsert();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		
		return mav;
	}
	
}
