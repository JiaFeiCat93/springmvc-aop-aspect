package com.qetch.springmvc.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qetch.springmvc.service.Calculation;

public class CalculationAspectMainTest {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springmvc-servlet.xml");
		Calculation calculation = (Calculation) context.getBean("calculationImpl");
//		System.out.println(calculation.add(1, 2));
		System.out.println(calculation.div(1, 2));
	}
}
