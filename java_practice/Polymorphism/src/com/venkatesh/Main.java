package com.venkatesh;

class Car {
	private boolean engines;
	private int wheels;
	private int cylinders;
	private String carName;
	
	public Car(int cylinders, String carName) {
		this.cylinders = cylinders;
		this.carName = carName;
		this.wheels = 4;
		this.engines = true;
	}

		public int getCylinders() {
		return cylinders;
	}

	public String getCarName() {
		return carName;
	}
	
	public String startEngine() {
		return "Car -> startEngine()";
	}
	
	public String accelerate() {
		return "Car -> accelerate()";
	}
	
	public String brake() {
		return "Car -> brake()";
	}
	
}

class Mitsubishi extends Car {

	public Mitsubishi(int cylinders, String carName) {
		super(cylinders, carName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String startEngine() {
		return "Mitsubishi -> startEngine()";
	}

	@Override
	public String accelerate() {
		return "Mitsubishi -> accelerate()";
	}

	@Override
	public String brake() {
		return "Mitsubishi -> brake()";
	}
	
	
	
}

class Ford extends Car {

	public Ford(int cylinders, String carName) {
		super(cylinders, carName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String startEngine() {
		return "Ford -> startEngine()";
	}

	@Override
	public String accelerate() {
		return "Ford -> accelerate()";
	}

	@Override
	public String brake() {
		return "Ford -> brake()";
	}
	
	
	
}

public class Main {

	public static void main(String[] args) {
		Car car = new Car(8, "Base Car");
		System.out.println(car.startEngine());
		System.out.println(car.accelerate());
		System.out.println(car.brake());
		
		
		Mitsubishi mitsubishi = new Mitsubishi(6, "Outlander");
		System.out.println(mitsubishi.startEngine());
		System.out.println(mitsubishi.accelerate());
		System.out.println(mitsubishi.brake());
		
		Ford ford = new Ford(6, "Ford Fiesta");
		System.out.println(ford.startEngine());
		System.out.println(ford.accelerate());
		System.out.println(ford.brake());
		
		
	}

}
