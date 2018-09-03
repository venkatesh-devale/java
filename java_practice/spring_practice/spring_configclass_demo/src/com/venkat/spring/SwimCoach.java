package com.venkat.spring;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;
	
	@Value("${email}")
	private String email;
	
	@Value("${team}")
	private String team;
	
	
	public SwimCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getDailyFortune();
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Swim for 1 KM";
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

}
