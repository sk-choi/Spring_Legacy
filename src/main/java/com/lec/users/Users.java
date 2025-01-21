package com.lec.users;

import java.util.List;

public interface Users { //service 단,,,
	
	// 회원 가입
	public void svcUsersRegister(UsersVO usv, RolesVO rvo); 
	//ctlUsersRegister(); -- users/register -- POST
	public List<UsersJoinRolesVO> svcUsersList();
	// ctlUsersList(); -- users/list -- GET
	public UsersJoinRolesVO svcUsersDetail(int usersSeq);
	// ctlUsersDetail(); -- users /detail -- GET
	public void svcUsersUpdate(UsersVO usv);
	// ctlUsersUpdate(); -- /users/update -- POST
	public void svcUsersDelete(int userSeq);
	// ctlUsersDelete(); -- /users/delete -- POST
	public UsersJoinRolesVO svcUsersLogin(String usersId, String usersPw);
}	
