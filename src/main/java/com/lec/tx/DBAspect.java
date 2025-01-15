package com.lec.tx;

import org.apache.commons.dbcp.BasicDataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DBAspect {
	
	@Autowired
	BasicDataSource ds;
	
	@Pointcut("execution(public * com.lec.tx.*DAO.*(..))")
	public void dummyDAOCut() {
		
	}
	
	@Before("dummyDAOCut()")
	public void dbConn() {
		int acnt = ds.getNumActive(); // 실행 중인 커넥션 수 //1
		int icnt = ds.getMaxIdle(); // 반납된 커넥션 수
	
		System.out.printf("실행전 -- 커넥션 가져오기 {}, {}", acnt, icnt);
	}
	
	@After("dummyDAOCut()")
	public void dbClose() {
		int acnt = ds.getNumActive(); // 실행 중인 커넥션 수
		int icnt = ds.getMaxIdle(); // 반납된 커넥션 수
		
		System.out.printf("실행후 무조건 -- 커넥션 반납 {} , {}", acnt, icnt);
	}
	
//	@AfterReturning(pointcut="dummyImplCut()", returning = "res")
//	public void afterReturningAdvice(Object res) {
//		System.out.println("실행(정상) -- CommonAspect.afterReturningAdvice() 실행");
//	}
	
	@AfterThrowing(pointcut="dummyDAOCut()", throwing = "ex")
	public void afterThorwingAdvice(Exception ex) {
		System.out.println(ex.getCause());
		//ex.printStackTrace();
		System.out.println("실행(에러) -- CommonAspect.afterThorwingAdvice() 실행");
	}
//	
//	@Around("dummyImplCut()")
//	public void aroundAdvice(ProceedingJoinPoint jp) {
//
//		try {
//			System.out.println("앞 -- aroundAdvice() 실행");
//			System.out.println(jp.getSignature());
//			jp.proceed(); //aopService.svcDelete()
//			System.out.println("뒤 -- aroundAdvice() 실행");
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
