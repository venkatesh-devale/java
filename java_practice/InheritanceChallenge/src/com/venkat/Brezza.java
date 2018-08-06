package com.venkat;

public class Brezza extends Car{
	private String color;
	private String modelVersion;
	
	public Brezza(int wheels, int gears, int maxSpeed, int average, String modelName, String carType, double price,
			String color, String modelVersion) {
		super(wheels, gears, maxSpeed, average, modelName, carType, price);
		this.color = color;
		this.modelVersion = modelVersion;
	}

	public String getColor() {
		return color;
	}

	public String getModelVersion() {
		return modelVersion;
	}

	public void displayBrezzaDetails() {
		displayVehiclDetails();
		displayCarDetails();
		System.out.println("Brezza's color is:" + color + "Model Version is: " + modelVersion);
	}
}
