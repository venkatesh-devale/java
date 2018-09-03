package com.venkat.spring;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneClass implements FortuneService {

	@Override
	public String getFortuneService() {
		return "Today is your lucky day";
	}
}
