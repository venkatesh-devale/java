package com.venkatesh;

public class Main {

	public static void main(String[] args) {
		
		Hamburger hamburger = new Hamburger("Basic", "Sausage", 4, "White");
		//System.out.println("The basic total(with no add ons) to pay is: "+hamburger.itemizeHamburger());
		
		hamburger.addAddOn1("tomato", 1.5);
		hamburger.addAddOn2("lettuce", 1.7);
		System.out.println("The final total to pay now is: "+hamburger.itemizeHamburger());
		
		HealthyBurger healthyBurger = new HealthyBurger("Bacon", 5.67);
		healthyBurger.addAddOn1("Egg", 5.43);
		healthyBurger.addHealthy1("Lentils", 3.41);
		System.out.println("The final total to pay now is: " + healthyBurger.itemizeHamburger());
		
		DeluxeHamburger db = new DeluxeHamburger();
		db.addAddOn1("xyz", 1.0);
		db.itemizeHamburger();
		
		
	}

}
