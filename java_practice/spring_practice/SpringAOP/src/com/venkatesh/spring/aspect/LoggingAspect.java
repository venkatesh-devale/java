package com.venkatesh.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	@Before("allLoggingMethods()")
	public void logSomethingFor(JoinPoint joinPoint) {
		System.out.println("Calling the log something in before advice " + joinPoint.toString());
	}
	
	@Before("execution(* getCircle())")
	public void beforeLogSomethingForCircle() {
		System.out.println("Calling the log something in before advice for Circle ");
	}
	
	@After("execution(* getCircle())")
	public void afterLogSomethingForCircle() {
		System.out.println("Calling the log something in after advice for Circle ");
	}
	
	@Pointcut("execution(* get*(..))")
	public void allLoggingMethods() {}
	
	@AfterReturning(pointcut = "args(name)", returning = "upperCaseName")
	public void afterSetName(JoinPoint jp, String name, String upperCaseName) {
		System.out.println("Called afterSetName @AfterReturning from "+jp.getTarget()+" and the name is set to: " + upperCaseName);
	}

	
	@AfterThrowing(pointcut = "args(name)", throwing="ex")
	public void callAfterThrowingException(String name, Exception ex) {
		System.out.println("Called @AfterThrowing callAfterThrowingException: " + ex);
	}
	
	@After("args(name)")
	public void afterSetName(JoinPoint jp, String name) {
		System.out.println("Called afterSetName from @After:"+jp.getTarget());
	}
	
	@Around("allLoggingMethods()") 
	public void aroundMethod(ProceedingJoinPoint pjp) {
		//before code
		System.out.println("Before calling the aroundMethod");
		
		//code for actual execution of method
		try {
			pjp.proceed();
		} catch (Throwable e) {
			System.out.println("Some exception came while execution...in around advice for aroundMethod: "+ e.getMessage());
		}
		
		//after code
		System.out.println("After calling the aroundMethod");
	}
	
	
}
