
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
        String destination, departDateStr, returnDateStr, filters, op;
        LocalDate departDate, returnDate;
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
        departDateStr = scanner.nextLine();
        formatter.parse(departDateStr);
        departDate = LocalDate.parse(departDateStr,formatter);


        // Return date
        System.out.print("Return date: ");
        returnDateStr = scanner.nextLine();
        formatter.parse(returnDateStr);
        returnDate = LocalDate.parse(returnDateStr,formatter);

        // Passengers count
        System.out.print("Number of passengers (up to 10): ");
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
        search=new Search(departDate,returnDate, destination,passenger,cabinClass, directFlight);
        searchController.searchResults(search);

    }
}
