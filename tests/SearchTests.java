import controller.SearchController;
import controller.objects.Search;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class SearchTests {


    @Test
    public void failSearchResultsTest(){
        SearchController searchController = new SearchController();
         LocalDate departureDate = LocalDate.now().plusDays(3);
         LocalDate returnDate = LocalDate.now().plusDays(10);
         String destination = "Spain";
         int numberOfPassengers = 2;
         Search search=new Search(departureDate,returnDate, destination,numberOfPassengers, true);

        searchController.searchResults(search);

    }

    @Test
    public void notValidDepartDateTest(){
        SearchController searchController = new SearchController();

        boolean depDateValid = searchController.validateDepartDate( LocalDate.of(2019,12,21));
        assertEquals(false,depDateValid);

    }
    @Test
    public void validReturnDepartDate() {
        SearchController searchController = new SearchController();
        LocalDate depDate = LocalDate.of(2020,9,1);
        LocalDate returnDate = LocalDate.of(2020,9,9);
        boolean datesValidation = searchController.validateReturnDepartDate(returnDate,depDate);
        assertEquals(true,datesValidation);
    }
    @Test
    public void errorReturnDepartDate() {
        SearchController searchController = new SearchController();
        LocalDate depDate = LocalDate.of(2020,9,1);
        LocalDate returnDate = LocalDate.of(2020,9,9);
        //there is a mistake in purpose
        boolean datesValidation = searchController.validateReturnDepartDate(depDate,returnDate);
        assertEquals(false,datesValidation);
    }

    @Test
    public void notValidDestinationTest() {
        SearchController searchController = new SearchController();
        boolean validDestination = searchController.validDestination("iran");
        assertEquals(false,validDestination);
    }

    @Test
    public void validDestinationTest() {
        SearchController searchController = new SearchController();
        boolean validDestination = searchController.validDestination("Barcelona");
        assertEquals(true,validDestination);
    }

    @Test
    public void numOfPassengerIsEmpty() {
        SearchController searchController = new SearchController();
        boolean zeroPassenger = searchController.validNumOfPassenger(0);
        assertEquals(false,zeroPassenger);
    }

}
