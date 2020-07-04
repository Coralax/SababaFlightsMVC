package model.repository;
import model.objects.Flight;

import model.singletons.FlightSingleton;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FlightRepositoryImpl implements FlightRepository {


    Set<Flight> flights = FlightSingleton.getInstance().flightSet;

    //Find roundtrip with no filters, FIX!!!
    public List<Flight> flightResultsRoundTrip(String destination, int numOfPassengers, LocalDate departD, LocalDate returnD) {
        List<Flight> resultFlights = new ArrayList<>();

        for (Flight flight : flights) {
            // System.out.println(flight.convertToLocalDate(flight.getDepartureDate()).compareTo(departD));

            if (flight.getDestination().toLowerCase().equals(destination.toLowerCase())) {

                if ((flight.convertToLocalDate(flight.getDepartureDate())).compareTo(departD) == 0 &&
                        ((flight.convertToLocalDate(flight.getDepartureDate())).compareTo(returnD) == 0)) {

                    if (flight.getAircraft().getSeatsCount() >= numOfPassengers)
                        resultFlights.add(flight);
                }
            }
        }
        if (resultFlights.size() > 0)
            return resultFlights;
        return null;
    }

    public List<Flight> flightResultOneDirection(String destination, int numOfPassengers, LocalDate departD) {
        List<Flight> resultFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getDestination().toLowerCase().equals(destination.toLowerCase())) {
                if ((flight.convertToLocalDate(flight.getDepartureDate())).compareTo(departD) == 0) {
                    if (flight.getAircraft().getSeatsCount() >= numOfPassengers)
                        resultFlights.add(flight);
                }
            }
        }
        if (resultFlights.size() > 0)
            return resultFlights;
        return null;
    }
}

//    public List<Flight> findByDestination(String destination, int numOfPassengers, LocalDate departD,LocalDate returnD) {
//    }

