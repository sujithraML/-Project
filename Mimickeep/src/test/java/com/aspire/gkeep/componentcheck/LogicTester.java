package com.aspire.gkeep.componentcheck;

import static org.junit.Assert.*;

import org.junit.Test;

public class LogicTester {

	@Test
	public void test() {
		Logic test = new Logic();
		boolean checkValue = test.isPrime(1);
		assertEquals(false,checkValue);
	}

}
