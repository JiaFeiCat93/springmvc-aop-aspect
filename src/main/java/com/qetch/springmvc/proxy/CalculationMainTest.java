package com.qetch.springmvc.proxy;

import com.qetch.springmvc.service.Calculation;
import com.qetch.springmvc.service.CalculationImpl;

public class CalculationMainTest {
	
	public static void main(String[] args) {
		Calculation calculation = new CalculationImpl();
		CalculationProxy calculationProxy = new CalculationProxy(calculation);
		Calculation calculationLog = calculationProxy.getCalculationLog();
		System.out.println(calculationLog.add(1, 2));
		System.out.println(calculationLog.sub(1, 2));
	}
}
