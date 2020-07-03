
package view;
import controller.SearchController;
import controller.objects.Search;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class SababaSearch {
    private SearchController searchController= new SearchController();


    public void search() {

        Search search;
        String destination, departDateStr , returnDateStr, filters, op;
        LocalDate departDate = null, returnDate = null;
        boolean cabinClass = false, directFlight = false;
        String numOfPass;
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter;
        int passenger;
        boolean flag=false;

        // Destination:
        do{
            System.out.print("Please enter the destination: ");
            destination = scanner.nextLine();
            if(searchController.validDestination(destination))
                flag=true;
        }while (!flag);


        // Depart date and return date
        flag = false;
        System.out.println("Please enter the depart and the return date in dd/MM/yyyy format.");
        try{
            //Depart date
            do {
                formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                System.out.print("Depart date: ");
                departDateStr = scanner.nextLine();
                formatter.parse(departDateStr);
                departDate = LocalDate.parse(departDateStr, formatter);

                //Check depart date: if invalid year
                if (searchController.validateDepartDate(departDate))
                    flag=true;

            }while(!flag);

            flag=false;

            // Return date
            do {
                System.out.print("Return date: ");
                returnDateStr = scanner.nextLine();
                formatter.parse(returnDateStr);
                returnDate = LocalDate.parse(returnDateStr, formatter);

                //Check return date: if invalid year || if return date is before depart date
                if (searchController.validateReturnDepartDate(returnDate, departDate))
                    flag=true;


            }while(!flag);
        }
        catch(Exception e) {
            System.out.println("Returning to search");
            this.search();
        }


        //Number of passengers
        flag=false;
        do {
            System.out.print("Number of passengers (up to 10): ");
            numOfPass = scanner.nextLine();
            passenger = Integer.parseInt(numOfPass);

            //Validate number of passengers
            if (!searchController.validNumOfPassenger(passenger)) {
                System.out.println("Number of passengers must be between 1 to 10");
            }
            else
                flag=true;
        }while(!flag);



        // Additional filters
        System.out.print("Would you like to have additional filters? yes/no: ");
        filters= scanner.nextLine();

        if(filters.toLowerCase().equals("yes")) {

//            // Regular or low cost
//            System.out.print("Search for business class only? yes/no: ");
//           op = scanner.nextLine();
//
//           if (op.toLowerCase().equals("yes")) {
//                cabinClass = true;
//            }

            // Direct flights
            System.out.print("Search for direct flights only? yes/no: ");
            op = scanner.nextLine();

            if (op.toLowerCase().equals("yes")) {
                directFlight = true;
            }

        }


        // The search itself with all the parameters
        search=new Search(departDate,returnDate, destination,passenger, directFlight);
        searchController.searchResults(search);
    }
}
