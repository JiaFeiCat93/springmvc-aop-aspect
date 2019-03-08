package com.qetch.springmvc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qetch.springmvc.service.Calculation;

public class CalculationProxy {
	private static final Logger logger = LoggerFactory.getLogger(CalculationProxy.class);
	
	private Calculation calculation;
	
	public CalculationProxy(Calculation calculation) {
		this.calculation = calculation;
	}
	
	public Calculation getCalculationLog() {
		Calculation proxy = null;
		ClassLoader classLoader = this.calculation.getClass().getClassLoader();
		Class<?>[] interfaces = new Class[] {Calculation.class};
		
		InvocationHandler handler = new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				logger.info("GP--->invoke begin,execute method is " + method.getName() + ", args are " + Arrays.asList(args));
				Object obj = method.invoke(calculation, args);
				return obj;
			}
		};
		
		proxy = (Calculation) Proxy.newProxyInstance(classLoader, interfaces, handler);
		return proxy;
	}
}
