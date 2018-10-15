package com.venkatesh.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.venkat.spring.service.ShapeService;

public class AopMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ShapeService shapeService = ctx.getBean("shapeService", ShapeService.class);
		
		//System.out.println(shapeService.getTriangle().getName());
		
		//shapeService.getCircle().setNameWithException("My Circle");
		
		shapeService.getCircle();
	}

}
