package model.singletons;

import model.objects.Aircraft;
import model.objects.Airport;
import java.util.Set;

public class AirportSingleton extends Singleton<Airport> {

    private static AirportSingleton airportSingletonInstance = null;
    public Set<Airport> airportSet;

    private AirportSingleton() {
        super("src/data/airports.json");
        airportSet = this.read(Airport.class);
    }

    public static AirportSingleton getInstance() {
        if (airportSingletonInstance == null)
            airportSingletonInstance = new AirportSingleton();

        return airportSingletonInstance;
    }

    public Airport getAirportById(int id) {
        for (Airport airport : this.airportSet) {
            if (airport.getId() == id) {
                return airport;
            }
        }
        System.out.println("Could not find an airport with this id");
        return null;
    }

}
