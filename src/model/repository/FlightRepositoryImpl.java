package model.repository;
import model.objects.Flight;

import model.singletons.FlightSingleton;

import java.time.LocalDate;
import java.util.*;


public class FlightRepositoryImpl implements FlightRepository {

    Set<Flight> flights = FlightSingleton.getInstance().flightSet;

    public Flight getFlightByID(int id)
    {
        for(Flight flight: flights)
        {
            if(flight.getFlightID()==id)
                return flight;
        }
        return null;
    }
    public Map<Integer, List<Flight>> flightResultsRoundTrip(String destination, int numOfPassengers, LocalDate departD, LocalDate returnD) {
            List<Flight> resultOneWay = new ArrayList<>();
            Map<Integer,List<Flight>> resultTwoWayMapping = new HashMap<>();
            List<Flight> flightBackFound = new ArrayList<>();
            boolean twoWay=false;
            int i = 0;
             for (Flight flight : flights) {
                if (flight.getDestination().toLowerCase().equals(destination.toLowerCase())) {
                  if ((flight.convertToLocalDate(flight.getDepartureDate())).compareTo(departD) == 0) {
                    if (flight.getSeatsLeft() >= numOfPassengers) {
                        resultOneWay.add(flight);
                        i++;
                    }
                }
            }
        }
            if(i>=1) {
                for (Flight foundOneWay : resultOneWay) {
                    flightBackFound.clear();
                    for (Flight flightReturn : flights) {
                        if (flightReturn.getDestination().toLowerCase().equals(foundOneWay.getDepartureAirport().getCountry().toLowerCase()))
                        {
                            if((flightReturn.convertToLocalDate(flightReturn.getDepartureDate())).compareTo(returnD)==0)
                                if(flightReturn.getSeatsLeft()>=numOfPassengers)
                                {
                                    flightBackFound.add(flightReturn);
                                    twoWay=true;
                                }
                        }
                    }
                    resultTwoWayMapping.put((foundOneWay.getFlightID()),flightBackFound);
                }
                if(!twoWay) //no return flight found
                {
                    System.out.println("No return flight found");
                    return null;
                }
            }
            //No flights at all, not even depart flight
           else
                return null;
        return resultTwoWayMapping;
    }

    public List<Flight> flightResultOneDirection(String destination, int numOfPassengers, LocalDate departD) {
        List<Flight> resultFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getDestination().toLowerCase().equals(destination.toLowerCase())) {
                if ((flight.convertToLocalDate(flight.getDepartureDate())).compareTo(departD) == 0) {
                    if (flight.getSeatsLeft() >= numOfPassengers)
                        resultFlights.add(flight);
                }
            }
        }
        if (resultFlights.size() > 0)
            return resultFlights;
        return null;
    }
}
