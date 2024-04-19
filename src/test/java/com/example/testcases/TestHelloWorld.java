package com.example.testcases;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class TestHelloWorld {
	@Test
	public void testLogin() {
		System.out.println("Test Run");		
		assertEquals(false, false);
	}
	
	@Test 
	public void testUnHappyCase() {
		assertEquals(0, 0);
	}
}
