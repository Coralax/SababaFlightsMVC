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


    public void validateSearch(Search search) throws IOException, ClassNotFoundException {

        /*Does destination exists in file? */
        dest = new Destination();
               for (String destination : dest.readDestination()) {
                if (!(destination.toLowerCase().contains(search.getDestination()))) {
                    System.out.println("Destination does not exists");
                }
            }


        /*Depart date and arrival date are logical*/

        /*Depart date and arrival date are logical*/

        /*Check if there are seats left in the flight. Do not show an empty flight.
        * (Number of passengers) */

        /*Does there exist an economy/business class as requested*/

        /*Does there exist a direct flight*/


        /*If everything is OK, call to showResults below*/


    }

    public void showResults(Search search){


    }

}
