package com.lec.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.tx.mapper.UsersMapper;

@Service
public class UserServiceImpl implements Users {

	@Autowired
	UsersMapper mapper;
	
	@Override
	public void svcUsersRegister(UsersVO usv, RolesVO rvo) {
		System.out.println("_____Service.svcUsersRegister()...");
		int rows = mapper.usersInsert(usv, rvo);
		
		System.out.println(rows + "건 입력");
	}

	@Override
	public List<UsersJoinRolesVO> svcUsersList() {
		System.out.println("_____Service.svcUsersList()...");
		List<UsersJoinRolesVO> list = mapper.usersList();
		
		System.out.println(list.size() + "건 조회되었습니다.");
		return list;
	}

	@Override
	public UsersJoinRolesVO svcUsersDetail(int usersSeq) {
		System.out.println("_____Service.svcUsersDetail()...");
		UsersJoinRolesVO urvo = mapper.usersOne(usersSeq);
		
		return urvo;
	}

	@Override
	public void svcUsersUpdate(UsersVO usv) {
		System.out.println("_____Service.svcUsersUpdate()...");
		int rows = mapper.usersUpdate(usv);
		System.out.println(rows + "건 업데이트");
	}

	@Override
	public void svcUsersDelete(int userSeq) {
		System.out.println("_____Service.svcUsersDelete()...");
		int rows = mapper.usersDelete(userSeq);
		System.out.println(rows + "건 삭제");
	}

	@Override
	public UsersJoinRolesVO svcUsersLogin(String usersId, String usersPw) {
		
		return mapper.usersLogin(usersId, usersPw);
		// TODO Auto-generated method stub
		
	}
	
}
