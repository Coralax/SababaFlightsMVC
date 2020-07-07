package model.repository;

import model.objects.Flight;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface FlightRepository {
     Map<Integer, List<Flight>> flightResultsRoundTrip(String destination, int numOfPassengers, LocalDate departD, LocalDate returnD);
     List<Flight> flightResultOneDirection(String destination, int numOfPassengers, LocalDate departD);
     Flight getFlightByID(int id);
     }
