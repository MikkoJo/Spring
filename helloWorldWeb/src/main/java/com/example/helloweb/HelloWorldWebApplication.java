package com.example.helloweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;

//@SpringBootApplication
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class HelloWorldWebApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HelloWorldWebApplication.class, args);
		printAllBeans(context);

	}

	public static void printAllBeans(ApplicationContext context) {
		String[] beans = context.getBeanDefinitionNames();
		for(int i = 1; i < beans.length; i++) {
			System.out.println(i+ ": " + beans[i]);
		}
		
	}
}
