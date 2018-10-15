package com.venkat.spring.model;

public class Circle {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String setNameToUpperCase(String name) {
		this.name = name.toUpperCase();
		return this.name;
	}
	
	public void setNameWithException(String name) {
		throw (new RuntimeException());
	}
	
	public String setNameWithExceptionAndReturningString(String name) {
		throw (new RuntimeException());
		
	}
}
