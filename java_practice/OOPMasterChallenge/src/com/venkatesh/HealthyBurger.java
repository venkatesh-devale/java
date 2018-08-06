package com.venkatesh;

public class HealthyBurger extends Hamburger{
	private String healthyExtra1Name;
	private double healthyExtra1price;
	private String healthyExtra2Name;
	private double healthyExtra2price;
	
	public HealthyBurger(String meat, double price) {
		super("Healthy", meat, price, "Brown rye");
	}
	
	public void addHealthy1(String name, double price) {
		this.healthyExtra1Name = name;
		this.healthyExtra1price = price;
	}
	
	public void addHealthy2(String name, double price) {
		this.healthyExtra2Name = name;
		this.healthyExtra2price = price;
	}

	public double itemizeHamburger() {
		double healthyHamburgerPrice = super.itemizeHamburger();
		if(healthyExtra1Name != null) {
			healthyHamburgerPrice += this.healthyExtra1price;
			System.out.println("Added " + this.healthyExtra1Name + " at a additional price of " + this.healthyExtra1price);
		}
		
		if(healthyExtra2Name != null) {
			healthyHamburgerPrice += this.healthyExtra2price;
			System.out.println("Added " + this.healthyExtra2Name + " at a additional price of " + this.healthyExtra2price);
		}
		
		return healthyHamburgerPrice;
	}
	
}
