package com.lec.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolesVO {
	private int roleSeq;
	private String roleName = "ROLE_USER";
	private int userSeq;

}
