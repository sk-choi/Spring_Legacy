//package com.lec.aop.xml;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//
//@Component("commonAspectXML")
//@Aspect
//public class CommonAspect {
//	
//	@Pointcut("execution(public void com.lec.aop..AOPServiceImpl.svcDelete())")
//	public void dummyImplCut() {
//		
//	}
//	
//	@Pointcut("execution(public void com.lec.aop..AOPServiceImpl2.svcInsert())")
//	public void dummyImplCut2() {
//		
//	}
//	
//	public void beforeAdvice() {
//		System.out.println("실행전 -- CommonAspect.beforeAdvice() 실행");
//	}
//	
//	public void afterAdvice() {
//		System.out.println("실행후 무조건(finally) -- CommonAspect.afterAdvice() 실행");
//	}
//
//	
//	
//	public void afterReturningAdvice(Object res) {
//		System.out.println("실행(정상) -- CommonAspect.afterReturningAdvice() 실행");
//	}
//	
//
//	public void afterThorwingAdvice(Exception ex) {
//		System.out.println(ex.getCause());
//		//ex.printStackTrace();
//		System.out.println("실행(에러) -- CommonAspect.afterThorwingAdvice() 실행");
//	}
//
//
//	public void aroundAdvice(ProceedingJoinPoint jp) {
////
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
//
//}
