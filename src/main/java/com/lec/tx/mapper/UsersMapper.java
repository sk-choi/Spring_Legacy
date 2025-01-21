package com.lec.tx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lec.users.RolesVO;
import com.lec.users.UsersJoinRolesVO;
import com.lec.users.UsersVO;

@Repository
@Mapper
public interface UsersMapper {
	// 회원 목록
	List<UsersJoinRolesVO> usersList();
	// 인증(id & pw)
	UsersJoinRolesVO usersOne(int usersSeq);
	// 가입(입력)
	//insert into users values(users_seq.nextval, 'hong','어드민','222', sysdate);
	UsersJoinRolesVO usersLogin(@Param("usersId") String id, @Param("usersPw") String pw);
	
	int usersInsert(@Param("usersVO") UsersVO usv, @Param("rolesVO") RolesVO rvo);
	int reg111(UsersVO usv);
	int reg222(RolesVO rvo);
	
	// 수정
	//update users set user_name='홍길동' where user_seq=1;
	int usersUpdate(UsersVO usv);
	// 삭제
	int usersDelete(int userSeq);
	
}
