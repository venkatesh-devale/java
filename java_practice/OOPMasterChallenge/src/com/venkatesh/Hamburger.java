package com.venkatesh;

public class Hamburger {
	private String name;
	private String meat;
	private double price;
	private String breadRollType;
	
	private String addOn1Name;
	private double addOn1Price;
	
	private String addOn2Name;
	private double addOn2Price;
	
	private String addOn3Name;
	private double addOn3Price;
	
	private String addOn4Name;
	private double addOn4Price;
	
	public Hamburger(String name, String meat, double price, String breadRollType) {
		this.name = name;
		this.meat = meat;
		this.price = price;
		this.breadRollType = breadRollType;
	}
	
	public void addAddOn1(String name, double price) {
		this.addOn1Name = name;
		this.addOn1Price = price;
	}
	
	
	public void addAddOn2(String name, double price) {
		this.addOn2Name = name;
		this.addOn2Price = price;
	}
	
	public void addAddOn3(String name, double price) {
		this.addOn3Name = name;
		this.addOn3Price = price;
	}
	
	public void addAddOn4(String name, double price) {
		this.addOn4Name = name;
		this.addOn4Price = price;
	}
	
	public double itemizeHamburger() {
		double hamburgerPrice = this.price;
		System.out.println(this.name + " hamburger on a " + this.breadRollType + " with " + this.meat + " roll price is " + this.price);
		if(this.addOn1Name != null) {
			hamburgerPrice += this.addOn1Price;
			System.out.println("Added " + this.addOn1Name + " at a additional price of " + this.addOn1Price);
		}
		
		if(this.addOn2Name != null) {
			hamburgerPrice += this.addOn2Price;
			System.out.println("Added " + this.addOn2Name + " at a additional price of " + this.addOn2Price);
		}
		
		if(this.addOn3Name != null) {
			hamburgerPrice += this.addOn3Price;
			System.out.println("Added " + this.addOn3Name + " at a additional price of " + this.addOn3Price);
		}
		
		if(this.addOn4Name != null) {
			hamburgerPrice += this.addOn4Price;
			System.out.println("Added " + this.addOn4Name + " at a additional price of " + this.addOn4Price);
		}

			
		
		return hamburgerPrice;
	}
	
}
