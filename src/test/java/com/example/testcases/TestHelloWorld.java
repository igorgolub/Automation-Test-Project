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
	public void test01SayHelloInEnglish() {			
		assertEquals("Hello World", hl.sayHello("English"));
	}
	
	@Test 
	public void test02SayHelloInVietNamemese() {
		assertEquals("Xin Chao", hl.sayHello("VietNameses"));
	}
	
	@Test 
	public void test03SayHelloInOthers() {
		assertEquals("Do not support", hl.sayHello("Chinese"));
	}
	
	@Test 
	public void test04SayHelloWithEmpty() {
		assertEquals("Do not support", hl.sayHello(""));
	}
	
	@Test 
	public void test05SayHelloWithNull() {
		assertEquals("Do not support", hl.sayHello(null));
	}
	
	@Test 
	public void test06SayHelloWithCaseSensitive() {
		assertEquals("Do not support", hl.sayHello("english"));
	}
	
	@Test 
	public void test07SayHelloWithLongString() {
		assertEquals("Do not support", hl.sayHello("Comments are open for 30 days after publishing a post. For any issues past this date, use the Contact form on the site."));
	}	
}
