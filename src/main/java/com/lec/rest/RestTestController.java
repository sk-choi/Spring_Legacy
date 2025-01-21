package com.lec.rest;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



/**
 * 
 * Handles requests for the application home page.
 */
@RestController
public class RestTestController {
	
	private static final Logger logger = LoggerFactory.getLogger(RestTestController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/rest", method = RequestMethod.GET)
	public String restTest() {
		
		
		return "home";
	}
	
}
