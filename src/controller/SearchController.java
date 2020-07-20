/*
 * 1. Make Singleton
 * 2. Can contain as many services as it needs
 */

package controller;

import controller.objects.Search;
import model.objects.Airport;
import model.service.SearchService;
import model.filemanager.AirportFileManager;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

public class SearchController {

    private SearchService searchService = new SearchService();

    public boolean validDestination(String destination) {
        Set<Airport> airportSet = AirportFileManager.getInstance().airportSet;
        for (Airport airport : airportSet) {
            if (airport.getCountry().toLowerCase().equals(destination.toLowerCase().trim()))
                return true;
        }
        System.out.println("\n"+"Destination not found..." +"\n");
        return false;
    }

    //Validate if the number of passenger is between 1 to 10
    public boolean validNumOfPassenger(int passengers) {
        return passengers >= 1 && passengers <= 10;
    }

    //Validate that the depart date is earlier than return date and that depart date's year is within one year
    public boolean validateDepartDate(LocalDate departDate) {
        int dt = departDate.getYear();
        if (departDate.isBefore(LocalDate.now())) {
            System.out.println("\n"+"Depart date must be later than current date!"+"\n");
            return false;
        }
        if(dt> (Calendar.getInstance().get(Calendar.YEAR)+1)){
         System.out.println("\n"+"Depart date must be within one year! "+"\n");
            return  false;
        }
        if(departDate.isBefore(LocalDate.now())){
            System.out.println("\n"+"Depart date must be equal or later than today! "+"\n");
            return  false;
        }
        return true;
    }

    //Validate that the return date is later than depart date and that the return date year is within one year from now
    public boolean validateReturnDepartDate(LocalDate returnDate,LocalDate departDate){
        int dt = returnDate.getYear();
        if(dt> (Calendar.getInstance().get(Calendar.YEAR)+1)){
            System.out.println("\n"+"Return date must be within one year!"+"\n");
            return  false;
        }
        if(returnDate.isBefore(departDate)|| departDate.isAfter(returnDate)){
            System.out.println("\n"+"Return date must be chosen after Departure date!"+"\n");
            return false;
        }
        return true;
    }

    public List<Long> searchResultsOneDirection(Search search) {
        List<Long> res;
        res = searchService.validateSearchOneDirection(search);
        return res;
    }

    public List<Long> searchResultsRoundTrip(Search search)  {
        List<Long> res;
        res=searchService.validateSearchRoundTrip(search);
        return res;
    }
}

