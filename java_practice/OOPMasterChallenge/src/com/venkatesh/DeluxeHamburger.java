package com.venkatesh;

public class DeluxeHamburger extends Hamburger{
	
	public DeluxeHamburger() {
		super("Deluxe", "Sausage and Bacon", 14.54, "White");
		super.addAddOn1("chips", 2.57);
		super.addAddOn2("drinks", 1.81);
	}

	@Override
	public void addAddOn1(String name, double price) {
		// TODO Auto-generated method stub
		System.out.println("Cannot add additional items to a deluxe hamburger");
	}

	@Override
	public void addAddOn2(String name, double price) {
		// TODO Auto-generated method stub
		System.out.println("Cannot add additional items to a deluxe hamburger");
	}

	@Override
	public void addAddOn3(String name, double price) {
		// TODO Auto-generated method stub
		System.out.println("Cannot add additional items to a deluxe hamburger");
	}

	@Override
	public void addAddOn4(String name, double price) {
		// TODO Auto-generated method stub
		System.out.println("Cannot add additional items to a deluxe hamburger");
	}
	
	
	
	
}
