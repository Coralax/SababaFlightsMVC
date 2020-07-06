
package view;
import controller.OrderController;
import controller.SearchController;
import controller.objects.Search;
import model.singletons.LoginSingleton;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class SababaSearch {
    private SearchController searchController;
    public SababaFlightsProgram sababaFlightsProgram;

    public SababaSearch(SababaFlightsProgram referer) {
        this.searchController= new SearchController();
        this.sababaFlightsProgram = referer;
    }


    public void search() {

        Search search;
        String destination, departDateStr, returnDateStr, filters, op;
        LocalDate departDate = null, returnDate = null;
        boolean cabinClass = false, directFlight = false;
        String numOfPass;
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter;
        int passenger;
        boolean flag = false;


        // Depart date and return date
        // System.out.println("Please enter the depart and the return date in dd/MM/yyyy format.");
        try {
            //Depart date
            do {
                System.out.println("1: For one way" +"\n" +"2: For round-trip");
                op= scanner.nextLine();
                formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                System.out.print("Depart date in dd/MM/yyyy format: ");
                departDateStr = scanner.nextLine();
                formatter.parse(departDateStr);
                departDate = LocalDate.parse(departDateStr, formatter);

                //Check depart date: if invalid year
                if (searchController.validateDepartDate(departDate))
                    flag = true;

            } while (!flag);

            flag = false;
            if (op.equals("2")) {
                // Return date
                do {
                    System.out.print("Return date in dd/MM/yyyy format: ");
                    returnDateStr = scanner.nextLine();
                    formatter.parse(returnDateStr);
                    returnDate = LocalDate.parse(returnDateStr, formatter);

                    //Check return date: if invalid year || if return date is before depart date
                    if (searchController.validateReturnDepartDate(returnDate, departDate))
                        flag = true;


                } while (!flag);
            }
        }
        catch(Exception e) {
            System.out.println("Returning to search");
            this.search();
        }

        flag = false;
        // Destination:
        do{
            System.out.print("Please enter the destination: ");
            destination = scanner.nextLine();
            if(searchController.validDestination(destination))
                flag=true;
        }while (!flag);

        //Number of passengers
        flag = false;
        do {
            System.out.print("Number of passengers (up to 10): ");
            numOfPass = scanner.nextLine();
            passenger = Integer.parseInt(numOfPass);

            //Validate number of passengers
            if (!searchController.validNumOfPassenger(passenger)) {
                System.out.println("Number of passengers must be between 1 to 10");
            } else
                flag = true;
        } while (!flag);

        // Additional filters
        System.out.print("Would you like to have additional filters? yes/no: ");
        filters = scanner.nextLine();

        if (filters.toLowerCase().equals("yes")) {

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
        search = new Search(departDate, returnDate, destination, passenger, directFlight);
        searchController.searchResults(search);


        System.out.println("Would you like to make an order?");
        System.out.println("1. Make an order" + "\n" + "2. Return to search page" + "\n" + "3. Return to home page");
        op = scanner.nextLine();

        try {
            switch (op) {
                case "1":
                    searchController.makeAnOrder();
                    break;
                case "2":
                    this.search();
                    break;
                case "3":
                    sababaFlightsProgram.homePage();
                    break;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }
}
