package com.lec.users;

import java.net.http.HttpResponse;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;


@Controller
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private Users svc;
	
	private static Logger logger = LoggerFactory.getLogger(UsersController.class);
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String ctlUsersList(Model model, @SessionAttribute(name="SESS_USER_ID", 
					required=false) String sessUserID,
			@SessionAttribute(name="SESS_USER_NAME", 
			required=false) String sessUserName,
			@CookieValue(name="COOK_LOGIN_CHECK", 
			required=false) String cookieVal
			) {
		System.out.println("______Controller.ctlUsersList() 호출");
		
		List<UsersJoinRolesVO> list = svc.svcUsersList();
		
		model.addAttribute("ULIST", list);
		return "users/user_list";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String ctlUsersRegister(Model model,
			@ModelAttribute UsersVO usv,
			@ModelAttribute RolesVO rvo) {
		
		if(rvo == null) {
			rvo = new RolesVO();
			rvo.setRoleName("ROLE_USER");
		}
		svc.svcUsersRegister(usv, rvo);
		return "users/user_login";
		//return "redirect:users/login_form";
	}
	
	
	@RequestMapping(value = "/login_ready", method = RequestMethod.GET)
	public String ctlUserDetail(Model model) {
		
		return "users/user_login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String ctlUsersDetail(Model model, 
            @RequestParam("usersId") String usersId, 
            @RequestParam("usersPw") String usersPw, 
            //HttpServletRequest request, // 세션 추가
            HttpSession session) {
			UsersJoinRolesVO urvo = svc.svcUsersLogin(usersId, usersPw);
			
			//uvo.getRoleList().get(0).getRoleName();
			
			if (urvo != null) {
				session.setAttribute("SESS_USER_ID", urvo.getUsersId());
				session.setAttribute("SESS_USER_NAME", urvo.getUsersName());
				
				//session.setAttribute("SESS_ROLES", rvo.getRoleName());
				
				
				return "redirect:/users/list";
			} else {
				return "redirect:/users/login_ready";
			}
			
			
			//세션?????
		//return "redirect:/users/list";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String strLogout(HttpSession session, HttpServletResponse response) {
		
		session.invalidate();
		session.setMaxInactiveInterval(0);
		
		response.setHeader("Expires", "0");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "private, no-cache, no-store, must-revalidate");
		return "redirect:/users/list";
		
	}
	
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String ctlUsersDetail(Model model, 
	                              @RequestParam("usersSeq") int usersSeq) {
		UsersJoinRolesVO urvo = svc.svcUsersDetail(usersSeq);
	    model.addAttribute("usersSeq", usersSeq);
	    model.addAttribute("URVO", urvo);
	    
	    return "users/user_detail";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String ctlUsersUpdate(@ModelAttribute UsersVO usv) {
		svc.svcUsersUpdate(usv);
		
		return "tx/test";
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String ctlUsersDelete(
			@RequestParam("userSeq") int seq) {
		
		svc.svcUsersDelete(seq);
		return "tx/test";
	}
	
}
