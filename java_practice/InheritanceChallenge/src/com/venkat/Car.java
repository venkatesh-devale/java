package com.venkat;

public class Car extends Vehicle {
	private String modelName;
	private String carType;
	private double price;
	

	public Car(int wheels, int gears, int maxSpeed, int average, String modelName, String carType, double price) {
		super(wheels, gears, maxSpeed, average);
		this.modelName = modelName;
		this.carType = carType;
		this.price = price;
	}
	public String getModelName() {
		return modelName;
	}
	public String getCarType() {
		return carType;
	}
	public double getPrice() {
		return price;
	}
	
	public void displayCarDetails() {
		
		System.out.println("Model Name is: "+ modelName + "Car Type is: "+ carType +"Price is: "+ price);
	}
	
}
