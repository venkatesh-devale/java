package com.venkat;

public class VipCustomer {
	private String name;
	private String creditLimit;
	private String email;
	
	public VipCustomer(){
		this("Venkatesh","10000","ve@gmail.com");
	}
	
	public VipCustomer(String name, String email){
		this(name,"unknown",email);
		
	}
	
	public VipCustomer(String name, String creditLimit, String email){
		this.name = name;
		this.creditLimit = creditLimit;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public String getCreditLimit() {
		return creditLimit;
	}
	public String getEmail() {
		return email;
	}
	
	
}
