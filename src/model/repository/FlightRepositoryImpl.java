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
//        List<Flight> resultOneWay = new ArrayList<>();
//        List<Flight> resultTwoWay = new ArrayList<>();
//        List<Integer> matchingResults=new ArrayList<>();
//        boolean twoWay=false; //if cant find two ways, will print (even if it finds only one way)
        int i = 1;
        List<Flight> resultFlights = new ArrayList<>();
        for (Flight flight : flights) {
            // System.out.println(flight.convertToLocalDate(flight.getDepartureDate()).compareTo(departD));

            if (flight.getDestination().toLowerCase().equals(destination.toLowerCase())) {
                if ((flight.convertToLocalDate(flight.getDepartureDate())).compareTo(departD) == 0)

                    for (Flight flightreturn: flights){
                    //chck if  destination in file the country is equal to the depart airport country
                    if(flightreturn.getDestinationAirport().getCountry().equals(flight.getDepartureAirport().getCountry()))
                        // check if the depart date from depart country is equal to return date
                        if((flightreturn.convertToLocalDate(flightreturn.getDepartureDate())).compareTo(returnD) == 0){
                            System.out.println("This is the results " + i);
                            System.out.println("flight to destination" + flight);
                            resultFlights.add(flight);
                            System.out.println("return flight" + flightreturn);
                            resultFlights.add(flightreturn);
                            i++;

                            }
                    }

            }
        }
        return resultFlights;
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

