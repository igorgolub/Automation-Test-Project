package com.example.logic;

public class HelloWorld {

	public String sayHello(String language) {
		if (language != null) {
			switch (language) {
			case "English":
				return "Hello World";
			case "VietNameses":
				return "Xin Chao";
			default:
				return "Do not support";
			}
		}
		return "Do not support";
	}
}
