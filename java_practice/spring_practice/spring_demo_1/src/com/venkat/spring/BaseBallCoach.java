package com.venkat.spring;

public class BaseBallCoach implements Coach{
	
	private FortuneService fortuneService;
	
	public BaseBallCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getWorkout() {
		return "hit a homerun";
	}
	
	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}
	
	public void myInitMethod() {
		System.out.println("MyInit method from BaseBallCoach");
	}
	
	public void myDestoryMethod() {
		System.out.println("myDestoryMethod from BaseBallCoach");
	}
}
