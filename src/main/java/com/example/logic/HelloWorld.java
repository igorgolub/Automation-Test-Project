package com.example.logic;

public class HelloWorld {
	
	public String sayHello(String language) {
		switch (language) {
		case "English":
			return "Hello World";
		case "Viet Name":	
			return "Xin Chao";
		default:
			return "Do not support";			
		}
	}
}
