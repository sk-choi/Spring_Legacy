package com.lec.aop.xml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service("aOPServiceImpl")
public class AOPServiceImpl implements AOPService {
	//@Autowired	
	private AOPDao dao;
	public AOPServiceImpl(AOPDao dao) {
		this.dao = dao;
	}
	
	@Override
	public void svcDelete() throws RuntimeException{
		
		System.out.println("2--1.____AOPServiceImpl.svcDelete() 실행");
		dao.delete();
		
		//강제 에러 발생 :: 정상적 형태라면 try catch 처리. aop 결과 확인을 위해 throws RuntimeException
		//throw new RuntimeException();
		System.out.println("2--1.____AOPServiceImpl.svcDelete() 실행");
		dao.delete();
			
			//강제 에러 발생
		//throw new RuntimeException();
		
	}
	
	@Override
	public void svcInsert() {
		
		System.out.println("2---1.____AOPServiceImpl.svcInsert() 실행");
	}
}
