package com.qetch.springmvc.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)// 表示优先执行此切入方法。数值越小，优先级越高
public class ValidateAspect {
	private static final Logger logger = LoggerFactory.getLogger(ValidateAspect.class);

//	@Before("execution(public int com.qetch.springmvc.service.CalculationImpl.*(int,int))")
//	public void validate() {
//		logger.info("--->validate--->");
//	}
	
	@Before("com.qetch.springmvc.aspect.CalculationAspect.aspectName()")
	public void validate2() {
		logger.info("--->validate--->");
	}
}
