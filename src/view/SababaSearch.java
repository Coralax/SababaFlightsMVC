
package view;
import controller.SearchController;
import controller.objects.Search;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SababaSearch {
    private SearchController searchController= new SearchController();
    public void search() throws IOException, ClassNotFoundException {
        Search search;
        String destination, departDate,returnDate,filters,op;
        LocalDate departObj, returnObj;
        boolean cabinClass=false,directFlight=false;
        String numOfPass;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the destination: ");
        destination=scanner.nextLine();
        System.out.println("Please enter the depart and the return date in dd/MM/yyyy format.");
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print("Depart date: ");
        departDate = scanner.nextLine();
        formatter.parse(departDate);
        departObj= LocalDate.parse(departDate,formatter);
        System.out.print("Return date: ");
        returnDate = scanner.nextLine();
        formatter.parse(returnDate);
        returnObj= LocalDate.parse(returnDate,formatter);
        System.out.print("Number of passengers: ");
        numOfPass= scanner.nextLine();
        int passenger= Integer.parseInt(numOfPass);
        System.out.print("Would you like to check additional filters? yes/no: ");
        filters= scanner.nextLine();
        if(filters.toLowerCase().equals("yes")) {
            System.out.print("Search for business class only? yes/no: ");
            op = scanner.nextLine();
            if (op.toLowerCase().equals("yes")) {
                cabinClass = true;
            }
            System.out.print("Search for direct flights only? yes/no: ");
            op = scanner.nextLine();
            if (op.toLowerCase().equals("yes")) {
                directFlight = true;
            }
        }
        search=new Search(departObj,returnObj, destination,passenger,cabinClass, directFlight);
        searchController.searchResults(search);
    }
}
