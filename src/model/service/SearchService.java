package model.service;

import controller.objects.Search;
import model.objects.Aircraft;
import model.objects.Destination;
import model.repository.AircraftCompanyRepository;
import model.repository.FlightRepository;
import model.singletons.LoginSingleton;
import view.SababaSearch;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class SearchService {
    private FlightRepository flightRepo;
    private Aircraft aircraftRepo;
    private AircraftCompanyRepository aircraftCompanyRepo;
    private Destination dest;
    boolean flag=true;
    String op;

    /*Does destination exists in file? */
    // throws IOException, ClassNotFoundException {
    public void validateSearch(Search search) {


        if (search.getDeparture().isAfter(search.getArrival()) || search.getArrival().equals(search.getDeparture())) {
            System.out.println("Departure date must be chosen before Arrival date!");
            flag = false;
        }
        if (search.getArrival().isBefore(search.getDeparture())) {
            System.out.println("Arrival date must be chosen after Departure date!");
            flag = false;
        }

        if (search.getDestination() == null || search.getDestination().trim().equals("")) {
            System.out.println("Invalid destination!");
            flag = false;
        }
        if (search.getNumberOfPassengers() < 1 || search.getNumberOfPassengers() > 10) {
            System.out.println("Number of passengers must be between 1 to 10!");
            flag = false;
        }


        //TODO: Check if there are seats left in the flight. Do not show an empty flight
        //TODO: (Number of passengers) - CHECK IF THERE AR ENOUGH SEATS
        //TODO: Does there exist an economy/business class as requested
        //TODO: Does there exist a direct flight
        //TODO: If everything is OK, call to showResults below



        if (!flag) {
            System.out.println("1: Start a new search");
            System.out.println("2: Return to Home page");

            try (Scanner scanner = new Scanner((System.in))) {
                op = scanner.nextLine();
                switch (op) {
                    case "1":
                        //Return to new search
                        break;
                    case "2":
                        //Return to main page
                        break;
                    default:
                    System.exit(0);
                }
            }

        } else
            showResults(search);
    }

    public void showResults(Search search){
        System.out.println("Nothing in here yet");

    }

}
