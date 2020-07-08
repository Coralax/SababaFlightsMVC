package model.repository;

import model.objects.Flight;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface FlightRepository {
     Map<Integer, List<Flight>> flightResultsRoundTrip(String destination, int numOfPassengers, LocalDate departD, LocalDate returnD);
     List<Flight> flightResultOneDirection(String destination, int numOfPassengers, LocalDate departD);
     List<Flight> flightResultsOneDirectionInRange(String destination, int numOfPassengers, LocalDate departD);
     Map<Integer, List<Flight>> flightResultsRoundTripInRange(String destination, int numOfPassengers, LocalDate departD, LocalDate returnD);
     Flight getFlightByID(long id);
     boolean deleteFlightFromFile(int id);
     boolean addFlightToFile(Flight flight);
     double getFlightPriceById(long flightID);
     void decreaseSeats(long flightID, int seatsAmount);
}