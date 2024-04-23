package com.example.logic;

public class HelloWorld {	
	
	public String sayHello(String language) {
		switch (language) {
		case "English":
			return "Hello World";
		case "VietNameses":	
			return "Xin Chao";
		default:
			return "Do not support";			
		}
	}
	
	public String sayHiWith(String name) {		
		return "Hi " + name;				
		}
	}
}
