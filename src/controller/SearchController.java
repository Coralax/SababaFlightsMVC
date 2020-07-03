/*
 * 1. Make Singleton
 * 2. Can contain as many services as it needs
 */

package controller;

import controller.objects.Search;
import model.objects.Airport;
import model.objects.Destination;
import model.objects.Passenger;
import model.service.SearchService;
import model.singletons.AirportSingleton;
import model.singletons.DestinationSingleton;
import model.singletons.PassengerSingleton;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Set;

public class SearchController {


    private SearchService searchService = new SearchService();

    public void searchResults(Search search)  {
            searchService.validateSearch(search);
    }

//    public boolean validDestination(String destination) {
//        Set<Destination> destinationSet = DestinationSingleton.getInstance().destinationSet;
//        for (Destination dest : destinationSet) {
//            System.out.println(dest.toString());
//            if (dest.toString().toLowerCase().equals(destination.toLowerCase()))
//                return true;
//        }
//        System.out.println("Destination not found");
//        return false;
//    }


    // Validate if destination exist in Airport.json (Name)
    public boolean validDestination(String destination) {
        Set<Airport> AirportSet = AirportSingleton.getInstance().airportSet;
        for (Airport dest : AirportSet) {
            if (dest.getAddress().toLowerCase().equals(destination.toLowerCase()))
                return true;
        }
        System.out.println("Destination not found");
        return false;
    }

    //Validate if number of passenger is between 1 to 10
    public boolean validNumOfPassenger(int passengers)
    {
        if(passengers<1 || passengers>10)
            return false;
        return true;
    }

    //Validate if depart date year is from year.now until year.now+1, id depart date mount is not smaller then mount now, if depart date day is not before day.now
    public boolean validateDepartDate(LocalDate departDate) { // Parse to int - coral
        int dt = departDate.getYear();
        int month=departDate.getMonthValue();
        int day= departDate.getDayOfMonth();
         if (dt < Calendar.getInstance().get(Calendar.YEAR) || dt>(Calendar.getInstance().get(Calendar.YEAR) +1) ||
         month<Calendar.getInstance().get(Calendar.MONTH) || day<Calendar.getInstance().get(Calendar.DAY_OF_MONTH))
         {
             System.out.println("Invalid depart date");
             return  false;
         }
        return true;
    }

    //Validate if return date is not before depart date, return date year is not smaller then year now or bigger then year +1
    public boolean validateReturnDepartDate(LocalDate returnDate,LocalDate departDate){
        int dt = returnDate.getYear();
        if (dt < Calendar.getInstance().get(Calendar.YEAR) || dt>(Calendar.getInstance().get(Calendar.YEAR) +1))
        {
            System.out.println("Return date must be within one year");
            return false;
        }
        if(returnDate.isBefore(departDate)|| departDate.isAfter(returnDate)){
            System.out.println("Return date must be chosen after Departure date!");
            return false;
        }
        return true;

    }

}

