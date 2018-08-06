package com.venkatesh;

public class CurrentConditionsDisplay implements Observer, DisplayScreens {
    private float temp;
    private float humidity;
    private float pressure;
    private Subject subject;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.subject = weatherData;
        subject.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current Conditions: ");
        System.out.println("Temperature: " + temp);
        System.out.println("Humidity: " + humidity);
        System.out.println("Pressure: " + pressure);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
