package com.venkatesh;

import java.util.ArrayList;

public class WeatherData implements Subject {

    private ArrayList<Observer> observers;
    private float temp;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float t, float h, float p) {
        temp = t;
        humidity = h;
        pressure = p;
        measurementsChanged();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o: observers) {
            o.update(temp, humidity, pressure);
        }
    }
}
