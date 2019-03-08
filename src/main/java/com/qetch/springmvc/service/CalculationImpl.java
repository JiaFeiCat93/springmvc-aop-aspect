package com.qetch.springmvc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CalculationImpl implements Calculation {
	private static final Logger logger = LoggerFactory.getLogger(CalculationImpl.class);

	@Override
	public int add(int numA, int numB) {
		int result = numA + numB;
		logger.info("--->executing--->");
		return result;
	}

	@Override
	public int sub(int numA, int numB) {
		int result = numA - numB;
		return result;
	}

	@Override
	public int multi(int numA, int numB) {
		int result = numA * numB;
		return result;
	}

	@Override
	public int div(int numA, int numB) {
		try {
			int result = numA / numB;
			return result;
		} catch (Exception e) {
			throw e;
		}
	}
}
