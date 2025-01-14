package com.lec.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("aOPServiceImpl2")
public class AOPServiceImpl2 implements AOPService {
	@Autowired	
	private AOPDao dao;
	
	@Override
	public void svcDelete() {
		dao.delete();
		System.out.println("2---2.____AOPServiceImpl222222.svcDelete() 실행");
	}
	
	@Override
	public void svcInsert() {
		
		System.out.println("2---2.____AOPServiceImpl222222.svcInsert() 실행");
	}
}
