package com.synechron;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(* com.synechron.Employee.work(..)) || execution(* com.synechron.Customer.buy(..))")
	public void logBefore(JoinPoint joinpoint) {
		logger.info("***Before calling {}", joinpoint.getSignature());
	}
	
	@After("execution(* com.synechron.Employee.work(..)) || execution(* com.synechron.Customer.buy(..))")
	public void logAfter(JoinPoint joinpoint) {
		logger.info("***After calling {}", joinpoint.getSignature());
	}
	
	@Around("execution(* com.synechron.Customer.buy(..))")
	public void checkItem(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Object[] args = proceedingJoinPoint.getArgs();
		Customer customer = (Customer)proceedingJoinPoint.getThis();
		String item = (String) args[0];
		if("iPhone".equalsIgnoreCase(item)) {
			logger.error("iPhone is out of Stock; Denied");
		}
		else {
			try {
				proceedingJoinPoint.proceed();	
			}
			catch(Exception ex) {
				logger.error("Error: {}", ex.getMessage());
			}
			
		}
	}
	
	//@AfterThrowing
	
	
	
}
