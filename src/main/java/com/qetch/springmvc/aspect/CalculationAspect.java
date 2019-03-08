package com.qetch.springmvc.aspect;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class CalculationAspect {
	private static final Logger logger = LoggerFactory.getLogger(CalculationAspect.class);
	
	/**
	 * 前置通知
	 * @param joinPoint
	 */
	@Before("execution(public int com.qetch.springmvc.service.CalculationImpl.*(int,int))")
	public void beforeMethod(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		List<Object> argsList = Arrays.asList(joinPoint.getArgs());
		logger.info("@Before ... ,method=" + name + ",args=" + argsList);
	}
	
	/**
	 * 后置通知
	 * @param joinPoint
	 */
	@After("execution(public int com.qetch.springmvc.service.CalculationImpl.*(int,int))")
	public void afterMethod(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		List<Object> argsList = Arrays.asList(joinPoint.getArgs());
		logger.info("@After ... ,method=" + name + ",args=" + argsList);
	}
	
	/**
	 * 返回通知
	 * @param joinPoint
	 */
	@AfterReturning(value = "execution(public int com.qetch.springmvc.service.CalculationImpl.*(int,int))", returning = "result")
	public void afterReturningMethod(JoinPoint joinPoint, Object result) {
		String name = joinPoint.getSignature().getName();
		List<Object> argsList = Arrays.asList(joinPoint.getArgs());
		logger.info("@AfterReturning ... ,method=" + name + ",args=" + argsList + ",return=" + result);
	}
	
	/**
	 * 异常通知
	 * @param joinPoint
	 * @param ex
	 */
	@AfterThrowing(value = "execution(public int com.qetch.springmvc.service.CalculationImpl.*(int,int))", throwing = "ex")
	public void afterThrowingMethod(JoinPoint joinPoint, Exception ex) {
		logger.info("@AfterThrowing ... ,ex=" + ex);
	}
	
	@Around("execution(public int com.qetch.springmvc.service.CalculationImpl.*(int,int))")
	public Object aroundMethod(ProceedingJoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		List<Object> argsList = Arrays.asList(joinPoint.getArgs());
		Object object = null;
		logger.info("前置通知 ... ,method=" + name + ",args=" + argsList);
		
		try {
			object = joinPoint.proceed();
			logger.info("返回通知 ... ,method=" + name + ",args=" + argsList);
		} catch (Throwable e) {
			logger.info("异常通知 ... ,e=" + e);
			e.printStackTrace();
		}
		logger.info("后置通知 ... ,method=" + name + ",args=" + argsList);
		return object;
	}
}
