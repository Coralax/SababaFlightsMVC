package model.service;

import controller.objects.Search;
import model.objects.Aircraft;
import model.objects.Destination;
import model.objects.Flight;
import model.repository.AircraftCompanyRepository;
import model.repository.FlightRepository;
import model.repository.FlightRepositoryImpl;

import java.util.List;
import java.util.Map;

public class SearchService {
    private FlightRepository flightRepo= new FlightRepositoryImpl();
    private Aircraft aircraftRepo;
    private AircraftCompanyRepository aircraftCompanyRepo;
    private Destination dest;


    /*Does destination exists in file? */
    // throws IOException, ClassNotFoundException {
    public void validateSearch(Search search) {
        List<Flight> flights;
        Map<Integer,List<Flight>> mappingFlights;
        if(search.getReturnDate()==null) {
            flights = flightRepo.flightResultOneDirection(search.getDestination(), search.getNumberOfPassengers(), search.getDepartureDate());
            if(flights==null)
            System.out.println("No flights suits your search, good-bye! "+"\n");
            else
            showResultOneWay(flights);

        }
        else {
            mappingFlights=flightRepo.flightResultsRoundTrip(search.getDestination(),search.getNumberOfPassengers(),search.getDepartureDate(),search.getReturnDate());
            if(mappingFlights==null)
            System.out.println("No flights suits your search, good-bye! "+"\n");
            else
                showResultRoundTrip(mappingFlights);


        }

    }

    public void showResultOneWay(List<Flight> oneWay) {
        System.out.println("Nothing in here yet");
    }

        public void showResultRoundTrip(Map<Integer,List<Flight>> mappingResults){
        int i=1, j=1;
        for(Map.Entry<Integer,List<Flight>> e :mappingResults.entrySet())
        {
            System.out.println("\n" + "Departure flight details" + "\n\n"
                    +"("+i+")"+flightRepo.getFlightById(e.getKey()).toString());

            System.out.println("\n"+"Matching return flights: " +"\n");
            for(Flight flights: e.getValue())
            {
                System.out.println("("+i+"."+j+")" + flights.toString()+"\n");
                j++;
            }
            i++;
            j=1;
        }
    }

}
