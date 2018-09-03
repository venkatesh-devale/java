package com.venkat.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach coach = context.getBean("myBaseballCoach", Coach.class);
		
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getFortuneService());
		
		context.close();
	}

}
