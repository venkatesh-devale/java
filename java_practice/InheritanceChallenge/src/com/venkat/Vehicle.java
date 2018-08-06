package com.venkat;

public class Vehicle {
	private int wheels;
	private int gears;
	private int maxSpeed;
	private int average;
	
	public Vehicle(int wheels, int gears, int maxSpeed, int average) {
		super();
		this.wheels = wheels;
		this.gears = gears;
		this.maxSpeed = maxSpeed;
		this.average = average;
	}

	public int getWheels() {
		return wheels;
	}

	public int getGears() {
		return gears;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public int getAverage() {
		return average;
	}
	
	public void displayVehiclDetails() {
		System.out.println("Wheels are: "+ wheels + "Gears are: "+ gears + "Max Speed of the Vehicle is: "+ maxSpeed + "Average is: "+ average);
	}
	
}
