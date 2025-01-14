package com.lec.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.di.AnnoController;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AOPController {
	
	private static final Logger logger = LoggerFactory.getLogger(AnnoController.class);
	
	@Autowired
	@Qualifier("aOPServiceImpl")
	private AOPService aOPService;
	
	@Autowired
	@Qualifier("aOPServiceImpl2")
	private AOPService aOPService2;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/anno_app", method = RequestMethod.GET)
	public String ctlDelete() {
		logger.info("로거 테스트------------");
		System.out.println("1._______AOPController.ctlDelete() 실행");
		aOPService.svcDelete();
		
		try {
			aOPService.svcDelete();
		} catch(RuntimeException e) {
			System.out.println("___ctl catch...");
		}
		
		aOPService2.svcInsert();
		
		return "home";
	}
	
}
