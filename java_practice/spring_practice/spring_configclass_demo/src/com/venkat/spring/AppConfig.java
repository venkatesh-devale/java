package com.venkat.spring;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
//@ComponentScan("com.venkat.spring")
@PropertySource("classpath:sport.properties")
public class AppConfig {

	@Bean
	public FortuneService getFortuneService() {
		return new SadFortuneService();
	}
	
	@Bean
	public SwimCoach swimCoach() {
		return new SwimCoach(getFortuneService());
	}
}
