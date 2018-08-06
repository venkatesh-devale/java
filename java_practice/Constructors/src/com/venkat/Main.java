package com.venkat;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VipCustomer person1 = new VipCustomer();
		System.out.println("Name: "+ person1.getName() + " CreditLimit: "+ person1.getCreditLimit() + " Email " + person1.getEmail());
		
		VipCustomer person2 = new VipCustomer("Tim","t@f.com");
		System.out.println("Name: "+ person2.getName() + " CreditLimit: "+ person2.getCreditLimit() + " Email " + person2.getEmail());
		
		VipCustomer person3 = new VipCustomer("Venky","2345","t@f.com");
		System.out.println("Name: "+ person3.getName() + " CreditLimit: "+ person3.getCreditLimit() + " Email " + person3.getEmail());
	}

}
