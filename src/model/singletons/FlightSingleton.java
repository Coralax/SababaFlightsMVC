package model.singletons;

import model.objects.Flight;
import java.util.Set;

public class FlightSingleton extends Singleton<Flight> {

    private static FlightSingleton flightSingletonInstance = null;
    public Set<Flight> flightSet;

    private FlightSingleton() {
        super("src/data/flights.json");
        flightSet = this.read(Flight.class);
    }

    public static FlightSingleton getInstance() {
        if (flightSingletonInstance == null)
            flightSingletonInstance = new FlightSingleton();

        return flightSingletonInstance;
    }

}
