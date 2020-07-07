package model.singletons;

import model.objects.Flight;
import java.util.Set;

public class FlightSingleton extends Singleton<Flight> {

    private static FlightSingleton flightSingletonInstance = null;
    public Set<Flight> flightSet;
    private int currency;   // 0 - USD; 1 - ILS

    private FlightSingleton() {
        super("src/data/flights.json");
        flightSet = this.read(Flight.class);
        this.currency = 0;
    }

    public static FlightSingleton getInstance() {
        if (flightSingletonInstance == null)
            flightSingletonInstance = new FlightSingleton();

        return flightSingletonInstance;
    }

    public Flight getFlightById(int id) {
        for (Flight flight : this.flightSet) {
            if (flight.getId() == id) {
                return flight;
            }
        }
        System.out.println("Could not find a flight with this id");
        return null;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public int getCurrency() {
        return currency;
    }
}
