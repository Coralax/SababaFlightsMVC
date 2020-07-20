package model.repository;
import model.objects.Flight;

import model.filemanager.FlightFileManager;

import java.time.LocalDate;
import java.util.*;


public class FlightRepositoryImpl implements FlightRepository {

    Set<Flight> flights = FlightFileManager.getInstance().flightSet;

    //A method that searches and pairs a depart flight with a list of return flights. Returns a Map that links between a particular departure flight (by ID) and a corresponding List<Flight>
    public Map<Integer, List<Flight>> flightResultsRoundTrip(String destination, int numOfPassengers, LocalDate departD, LocalDate returnD,boolean direct) {
        List<Flight> resultOneWay = new ArrayList<>();
        Map<Integer,List<Flight>> resultTwoWayMapping = new HashMap<>();
        List<Flight> flightBackFound = new ArrayList<>();
        boolean twoWay=false;
        int i = 0;
        for (Flight flight : flights) {
            if (flight.getDestination().toLowerCase().equals(destination.toLowerCase())) {
                if ((flight.convertToLocalDateDepart(flight.getDepartureDate())).compareTo(departD) == 0) {
                    if (flight.getSeatsLeft() >= numOfPassengers) {
                        if(flight.isDirect()==direct) {
                            resultOneWay.add(flight);
                            i++;
                        }
                    }
                }
            }
        }
        if(i>=1) {
            AirportRepositoryImpl airportRepository = new AirportRepositoryImpl();
            for (Flight foundOneWay : resultOneWay) {
                flightBackFound.clear();
                for (Flight flightReturn : flights) {
                    if (flightReturn.getDestination().toLowerCase().equals(airportRepository.getAirportById(foundOneWay.getDepartureAirportID()).getCountry().toLowerCase()))
                    {
                        if((flightReturn.convertToLocalDateDepart(flightReturn.getDepartureDate())).compareTo(returnD)==0)
                            if(flightReturn.getSeatsLeft()>=numOfPassengers) {
                                if (flightReturn.isDirect() == direct) {
                                    flightBackFound.add(flightReturn);
                                    twoWay = true;
                                }
                            }
                    }
                }
                resultTwoWayMapping.put((foundOneWay.getId()),flightBackFound);
            }
            if(!twoWay) //no return flight found
            {
                System.out.println("\n"+"No return flight found!"+"\n");
                return null;
            }
        }
        //No flights at all, not even the depart flight
        else
            return null;
        return resultTwoWayMapping;
    }

    //A method that searches departure flights with the given arguments from the user. Returns a corresponding List<Flight>
    public List<Flight> flightResultOneDirection(String destination, int numOfPassengers, LocalDate departD,boolean direct) {
        List<Flight> resultFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getDestination().toLowerCase().equals(destination.toLowerCase())) {
                if ((flight.convertToLocalDateDepart(flight.getDepartureDate())).compareTo(departD) == 0) {
                    if (flight.getSeatsLeft() >= numOfPassengers)
                        if(flight.isDirect()==direct)
                        resultFlights.add(flight);
                }
            }
        }
        if (resultFlights.size() > 0)
            return resultFlights;
        return null;
    }


    public boolean deleteFlightFromFile(int id){

        if(getFlightByID(id) ==null)
        {
            System.out.println("\n"+"Flight does not exist!"+"\n");
            return false;
        }
        else
        {
            FlightFileManager.getInstance().flightSet.remove(getFlightByID(id));
            FlightFileManager.getInstance().saveSet(flights);
        }
        return true;
    }

    public void addFlightToFile(Flight flight){
         FlightFileManager.getInstance().flightSet.add(flight);
         FlightFileManager.getInstance().saveSet(flights);
    }

    public Flight getFlightByID(long id)
    {
        for(Flight flight: flights)
        {
            if(flight.getId() == id)
                return flight;
        }
        return null;
    }

    public boolean changeDepartureDate(long id,String newDate){
        Flight flight =getFlightByID(id);
        if(flight==null)
        {
            System.out.println("\n"+"Flight does not exist!"+"\n");
            return false;
        }

        if(flight.convertToLocalDateDepart(newDate).isAfter(flight.convertToLocalDateArrival(flight.getArrivalDate())))
        {
            System.out.println("\n"+"Flight departure date must be earlier or equal to arrival date!" +"\n");
            return false;
        }
        else
        {
            flight.setDepartureDate(newDate);
            FlightFileManager.getInstance().flightSet.remove(getFlightByID(id));
            flights.add(flight);
            FlightFileManager.getInstance().saveSet(flights);
        }
        return true;
    }

    public boolean changeArrivalDate(long id,String newDate){
        Flight flight =getFlightByID(id);
        if(flight==null)
        {
            System.out.println("\n"+"Flight does not exist!"+"\n");
            return false;
        }

        if(flight.convertToLocalDateArrival(newDate).isBefore(flight.convertToLocalDateDepart(flight.getDepartureDate())))
        {
            System.out.println("\n"+"Flight arrival date must be earlier or equal to departure date!" +"\n");
            return false;
        }
        else
        {
            flight.setArrivalDate(newDate);
            FlightFileManager.getInstance().flightSet.remove(getFlightByID(id));
            flights.add(flight);
            FlightFileManager.getInstance().saveSet(flights);
        }
        return true;
    }

    @Override
    public double getFlightPriceById(long flightID) {
        return this.getFlightByID(flightID).getFlightPrice();
    }

    @Override
    public void decreaseSeats(long flightID, int seatsAmount) {
        Flight flight = getFlightByID(flightID);
        flight.setSeatsLeft(flight.getSeatsLeft() - seatsAmount);
    }
}