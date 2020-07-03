package model.repository;
import model.objects.Agent;
import model.objects.Flight;

import model.singletons.AgentSingleton;
import model.singletons.FlightSingleton;
import model.singletons.LoginSingleton;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FlightRepositoryImpl implements FlightRepository{


    Set<Flight> flights = FlightSingleton.getInstance().flightSet;

//Find roundtrip with no filters
    public List<Flight> flightResults(String destination, int numOfPassengers, LocalDate departD, LocalDate returnD){
        List<Flight> resultFlights= new ArrayList<>();

        for(Flight flight: flights){
            if(flight.getDestinationAirport().getAddress().equals(destination)){

                if((flight.convertToLocalDate(flight.getDepartureDate()).equals(departD)) &&
                        (flight.convertToLocalDate(flight.getDepartureDate()).equals(returnD))){
                    if(flight.getAircraftID().getSeatsCount()>=numOfPassengers)
                    {
                    resultFlights.add(flight);
                    }
                }
            }
        }
        if(resultFlights.size()>0)
            return resultFlights;
        return null;
    }
//    public List<Flight> findByDestination(String destination, int numOfPassengers, LocalDate departD,LocalDate returnD) {
//    }

}
