package com.lec.aop;

import org.springframework.stereotype.Repository;

@Repository
public class AOPDao {
	public void delete() {
		System.out.println("3.____AOPDao.delete() 실행");
	}
}
