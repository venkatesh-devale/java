package com.venkatesh;

public class WeatherStation {
    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(80, 65, 50);
        weatherData.setMeasurements(90, 55, 40);
        weatherData.setMeasurements(70, 35, 30);
    }
}
