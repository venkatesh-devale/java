package com.venkat.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach coach = context.getBean("myBaseBallCoach",Coach.class);
		
		System.out.println(coach.getWorkout()+" "+coach.getDailyFortune());
		
		context.close();
	}

}
