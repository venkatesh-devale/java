package com.venkat.spring;

public class CricketCoach implements Coach{
	
	private FortuneService fortuneService;
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}

	@Override
	public String getWorkout() {
		// TODO Auto-generated method stub
		return "Nothing to do";
	}
	
	public void setFortuneService(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
}
