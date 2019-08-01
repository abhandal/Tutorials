package observer;

/*
Purpose
In general, you want to use this pattern to reduce coupling.
If you have an object that needs to share it's state with others, without knowing who those objects are,
the Observer is exactly what you need.
 */

public class Client {
    public static void run() {
        System.out.println("\n---------------------");
        System.out.println("Observer pattern\n---------------------");
        ObserverClient();
    }

    private static void ObserverClient() {
        // Create the Subject
        Subject weatherData = new WeatherData();

        // Create the observer
        Observer currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

        // Simulate the data
        ((WeatherData) weatherData).setMeasurement(20,35,10);
        ((WeatherData) weatherData).setMeasurement(10,45,30);
    }
}
