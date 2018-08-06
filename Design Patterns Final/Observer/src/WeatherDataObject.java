import java.util.ArrayList;

public class WeatherDataObject implements Subject{
    private Double temperature;
    private Double pressure;
    private Double humidity;
    private ArrayList<Observer> observers;

    public WeatherDataObject() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int index = observers.indexOf(o);
        if(index >= 0)
            observers.remove(o);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer observer: observers ) {
            observer.update(temperature, pressure, humidity);
        }
    }

    public void measurementsChanged() {
        notifyAllObservers();
    }

    public void setMeasurements(Double temperature, Double humidity, Double pressure) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        measurementsChanged();
    }

    public Double getTemperature() {
        return temperature;
    }

    public Double getPressure() {
        return pressure;
    }

    public Double getHumidity() {
        return humidity;
    }
}
