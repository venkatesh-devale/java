public class CurrentDisplay implements Observer, DisplayComponent {
    private Subject weatherDataObject;
    private Double temperature;
    private Double pressure;
    private Double humidity;

    public CurrentDisplay(Subject weatherDataObject) {
        this.weatherDataObject = weatherDataObject;
        this.weatherDataObject.addObserver(this);
    }


    @Override
    public void display() {
        System.out.println("Current Conditions:");
        System.out.println("Temperature: " + this.temperature);
        System.out.println("Pressure: " + this.pressure);
        System.out.println("Humidity: " + this.humidity);
    }

    @Override
    public void update(Double humidity, Double temperature, Double pressure) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }
}
