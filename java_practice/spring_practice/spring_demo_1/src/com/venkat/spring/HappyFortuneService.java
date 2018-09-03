package com.venkat.spring;

public class HappyFortuneService implements FortuneService{

	@Override
	public String getDailyFortune() {
		return "This is good day";
	}
	
}
