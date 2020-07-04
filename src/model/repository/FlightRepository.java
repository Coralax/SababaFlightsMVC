package model.repository;

import model.objects.Flight;

import java.time.LocalDate;
import java.util.List;

public interface FlightRepository {
     List<Flight> flightResultsRoundTrip(String destination, int numOfPassengers, LocalDate departD, LocalDate returnD);
      List<Flight> flightResultOneDirection(String destination, int numOfPassengers, LocalDate departD);

     }
