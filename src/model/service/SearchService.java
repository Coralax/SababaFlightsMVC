package model.service;

import controller.objects.Search;
import model.objects.Aircraft;
import model.objects.Destination;
import model.repository.AircraftCompanyRepository;
import model.repository.FlightRepository;

import java.io.IOException;
import java.util.Iterator;

public class SearchService {
    private FlightRepository flightRepo;
    private Aircraft aircraftRepo;
    private AircraftCompanyRepository aircraftCompanyRepo;
    private Destination dest;

    /*Does destination exists in file? */
    // throws IOException, ClassNotFoundException {
    public void validateSearch(Search search)  {

     System.out.println("Nothing in here yet");

    }

//TODO: Depart date and arrival date are logical
//TODO: Arrival date and arrival date are logical
//TODO: Check if there are seats left in the flight. Do not show an empty flight
//TODO: (Number of passengers) - CHECK IF THERE AR ENOUGH SEATS
//TODO: Does there exist an economy/business class as requested
//TODO: Does there exist a direct flight
//TODO: If everything is OK, call to showResults below



    public void showResults(Search search){


    }

}
