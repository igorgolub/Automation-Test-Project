package com.example.testcases;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.example.logic.HelloWorld;

import static org.junit.Assert.*;

@TestInstance(Lifecycle.PER_CLASS)
public class TestHelloWorld {
	HelloWorld hl;
	
	@BeforeAll
	public void setUp() {
		hl = new HelloWorld();
	}
	
	@Test
	public void testSayHelloInEnglish() {			
		assertEquals("Hello World", hl.sayHello("English"));
	}
	
	@Test 
	public void testSayHelloInVietNamemese() {
		assertEquals("Xin Chao", hl.sayHello("VietNameses"));
	}
	
	@Test 
	public void testSayHelloInOthers() {
		assertEquals("Do not support", hl.sayHello("Chinese"));
	}
	
	@Test 
	public void testSayHelloWithEmpty() {
		assertEquals("Do not support", hl.sayHello(""));
	}
	
	@Test 
	public void testSayHelloWithNull() {
//		assertEquals("Do not support", hl.sayHello(null));
		
		assertEquals(true, false);
		
	}
	
	@Test 
	public void testSayHelloWithLongString() {
		assertEquals("Do not support", hl.sayHello("Comments are open for 30 days after publishing a post. For any issues past this date, use the Contact form on the site."));
	}
	
}
