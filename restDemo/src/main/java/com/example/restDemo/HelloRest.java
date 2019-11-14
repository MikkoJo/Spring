package com.example.restDemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRest {

	private static int count = 1;
	@RequestMapping("/hello")
	public String hello() {
		return "HELLO Spring Boot REST";
		
	}
	
	@RequestMapping("/count")
	public String count() {
		return "<b>Laskurin arvo on: " + HelloRest.count++;
		
		
	}
	
	@RequestMapping("/test")
	public Test test() {
		return new Test(count, "Mikko");
	}
	
}
