package com.spring.real;

public class UserServiceImpl implements UserService {

	public UserVO getUser(UserVO vo){
		UserDAO userDAO = new UserDAO();	
		return userDAO.getUser(vo);
	}
}