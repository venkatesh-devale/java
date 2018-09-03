package com.venkat.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService randomFortuneService;
	
	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService happyFortuneService;
	
	public TennisCoach() {
		System.out.println("Hello");
	}
	
	/*
	@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	*/
	
	@Override
	public String getDailyWorkout() {
		return "Practice back of the hand";
	}

	@Override
	public String getDailyFortune() {
		return randomFortuneService.getDailyFortune() +" "+ happyFortuneService.getDailyFortune();
	}

}
