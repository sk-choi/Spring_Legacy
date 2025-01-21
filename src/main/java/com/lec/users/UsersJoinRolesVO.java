package com.lec.users;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersJoinRolesVO {
	private int usersSeq;
	private String usersId;
	private String usersName;
	private String usersPw;
	private Date regdate;
	private int roleSeq;
	private String roleName;
}
