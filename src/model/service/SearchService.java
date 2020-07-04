package model.service;

import controller.objects.Search;
import model.objects.Aircraft;
import model.objects.Destination;
import model.objects.Flight;
import model.repository.AircraftCompanyRepository;
import model.repository.FlightRepository;
import model.repository.FlightRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class SearchService {
    private FlightRepository flightRepo= new FlightRepositoryImpl();
    private Aircraft aircraftRepo;
    private AircraftCompanyRepository aircraftCompanyRepo;
    private Destination dest;


    /*Does destination exists in file? */
    // throws IOException, ClassNotFoundException {
    public void validateSearch(Search search) {
        List<Flight> flights;
        if(search.getReturnDate()==null) {
            flights = flightRepo.flightResultOneDirection(search.getDestination(), search.getNumberOfPassengers(), search.getDepartureDate());
            System.out.println("inside one way");
            //IF(NULL)
            //System.out.println("No flights suits your search");

        }
        else {
            flights=flightRepo.flightResultsRoundTrip(search.getDestination(),search.getNumberOfPassengers(),search.getDepartureDate(),search.getReturnDate());
            System.out.println("inside round trip");
            //IF(null)
            //System.out.println("No flights suits your search");

        }


            for(Flight flight: flights)
                System.out.println(flight);
              showResults(search);

        //TODO: Check if there are seats left in the flight. Do not show an empty flight
        //TODO: (Number of passengers) - CHECK IF THERE AR ENOUGH SEATS
        //TODO: Does there exist an economy/business class as requested
        //TODO: Does there exist a direct flight
        //TODO: If everything is OK, call to showResults below

    }

    public void showResults(Search search){

        System.out.println("Nothing in here yet");

    }

}
