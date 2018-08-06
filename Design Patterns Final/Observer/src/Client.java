public class Client {
    public static void main(String[] args) {
        WeatherDataObject weatherDataObject = new WeatherDataObject();

        CurrentDisplay currentDisplay = new CurrentDisplay(weatherDataObject);
        weatherDataObject.setMeasurements(90.00, 120.00, 80.00);
        weatherDataObject.setMeasurements(20.00, 40.00, 60.00);
    }
}
