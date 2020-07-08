package model.repository;
import model.objects.Flight;

import model.singletons.FlightSingleton;

import java.time.LocalDate;
import java.util.*;


public class FlightRepositoryImpl implements FlightRepository {

    private Set<Flight> flightSet;

    public FlightRepositoryImpl() {
        this.flightSet = FlightSingleton.getInstance().flightSet;
    }

    @Override
    public Flight getFlightById(long id) {
        for (Flight flight : this.flightSet) {
            if (flight.getId() == id) {
                return flight;
            }
        }
        System.out.println("Could not find a flight with this id");
        return null;
    }

    @Override
    public Map<Integer, List<Flight>> flightResultsRoundTrip(String destination, int numOfPassengers, LocalDate departD, LocalDate returnD) {
            List<Flight> resultOneWay = new ArrayList<>();
            Map<Integer,List<Flight>> resultTwoWayMapping = new HashMap<>();
            List<Flight> flightBackFound = new ArrayList<>();
            boolean twoWay=false;
            int i = 0;
             for (Flight flight : flightSet) {
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
                    for (Flight flightReturn : flightSet) {
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
                    resultTwoWayMapping.put((foundOneWay.getId()),flightBackFound);
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

    @Override
    public List<Flight> flightResultOneDirection(String destination, int numOfPassengers, LocalDate departD) {
        List<Flight> resultFlights = new ArrayList<>();
        for (Flight flight : flightSet) {
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

//    public List<Flight> findByDestination(String destination, int numOfPassengers, LocalDate departD,LocalDate returnD) {
//    }

