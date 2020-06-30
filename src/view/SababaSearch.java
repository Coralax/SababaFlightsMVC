
package view;
import controller.SearchController;
import controller.objects.Search;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SababaSearch {
    private SearchController searchController= new SearchController();
    public void search() {

        Search search;
        String destination, departDate, returnDate, filters, op;
        LocalDate departObj, returnObj;
        boolean cabinClass = false, directFlight = false;
        String numOfPass;
        Scanner scanner = new Scanner(System.in);

        // Destination:
        System.out.print("Please enter the destination: ");
        destination = scanner.nextLine();

        // Declaring date string parser
        System.out.println("Please enter the depart and the return date in dd/MM/yyyy format.");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Depart date
        System.out.print("Depart date: ");
        departDate = scanner.nextLine();
        formatter.parse(departDate);
        departObj = LocalDate.parse(departDate,formatter);

        // Return date
        System.out.print("Return date: ");
        returnDate = scanner.nextLine();
        formatter.parse(returnDate);
        returnObj = LocalDate.parse(returnDate,formatter);

        // Passengers count
        System.out.print("Number of passengers: ");
        numOfPass = scanner.nextLine();
        int passenger= Integer.parseInt(numOfPass);

        // Additional filters
        System.out.print("Would you like to check additional filters? yes/no: ");
        filters= scanner.nextLine();

        if(filters.toLowerCase().equals("yes")) {

            // Business class
            System.out.print("Search for business class only? yes/no: ");
            op = scanner.nextLine();

            if (op.toLowerCase().equals("yes")) {
                cabinClass = true;
            }

            // Direct flights
            System.out.print("Search for direct flights only? yes/no: ");
            op = scanner.nextLine();

            if (op.toLowerCase().equals("yes")) {
                directFlight = true;
            }

        }

        // The search itself with all the parameters
        search=new Search(departObj,returnObj, destination,passenger,cabinClass, directFlight);
        searchController.searchResults(search);

    }
}
