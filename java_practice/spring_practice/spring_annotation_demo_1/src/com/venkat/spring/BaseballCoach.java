package com.venkat.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myBaseballCoach")
public class BaseballCoach implements Coach{
	
	private FortuneService theFortuneService;
	
	@Autowired
	public BaseballCoach(FortuneService fortuneService) {
		theFortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Hit a Home Run!";
	}
	
	@Override
	public String getFortuneService() {
		return theFortuneService.getFortuneService();
	}
}
