package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@ServletComponentScan
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
//		printAllBeans(context);

	}

	public static void printAllBeans(ApplicationContext context) {
		String[] beans = context.getBeanDefinitionNames();
//		for(int i = 1; i < beans.length; i++) {
//			System.out.println(i + ": " + beans[i]);
//		}
		int i = 0;
		for(String bean: beans) {
			System.out.println((i++) + ": " + bean);
		}
	}

}
