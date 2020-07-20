package model.repository;

import model.objects.Airport;
import model.filemanager.AirportFileManager;

import java.util.Set;

public class AirportRepositoryImpl implements AirportRepository {

    private Set<Airport> airportSet;

    public AirportRepositoryImpl() {
        this.airportSet = AirportFileManager.getInstance().airportSet;
    }

    public Airport getAirportById(long id) {
        for (Airport airport : this.airportSet) {
            if (airport.getId() == id) {
                return airport;
            }
        }
        System.out.println("\n"+"Could not find an airport with the provided ID!"+"\n");
        return null;
    }

}
