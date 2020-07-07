package view;
import controller.AuthenticationController;
import controller.OrderController;
import controller.SearchController;
import controller.objects.Search;
import model.objects.Flight;
import model.objects.Passenger;
import model.singletons.LoginSingleton;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SababaSearch {
    private SearchController searchController;
    private OrderController orderController;
    private AuthenticationController authenticationController;
    public SababaFlightsProgram sababaFlightsProgram;

    public SababaSearch(SababaFlightsProgram referer) {
        this.searchController= new SearchController();
        this.orderController=new OrderController();
        this.authenticationController=new AuthenticationController();
        this.sababaFlightsProgram = referer;
    }

    public void search() {
        Search search;
        int idDeparture;
        int[] idDepartReturn;
        String destination, departDateStr, returnDateStr, filters, op;
        LocalDate departDate = null, returnDate = null;
        boolean cabinClass = false, directFlight = false;
        String numOfPass;
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter;
        int passenger;
        boolean flag = false;
        List<Flight> resOneWay = null;
        Map<Integer, List<Flight>> roundTrip = null;


        // Depart date and return date
        // System.out.println("Please enter the depart and the return date in dd/MM/yyyy format.");
        try {
            //Depart date
            do {
                System.out.println("1: For one way" + "\n" + "2: For round-trip");
                op = scanner.nextLine();
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
        } catch (Exception e) {
            System.out.println("Returning to search");
            this.search();
        }

        flag = false;
        // Destination:
        do {
            System.out.print("Please enter the destination: ");
            destination = scanner.nextLine();
            if (searchController.validDestination(destination))
                flag = true;
        } while (!flag);

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
            // Direct flights
            System.out.print("Search for direct flights only? yes/no: ");
            op = scanner.nextLine();

            if (op.toLowerCase().equals("yes")) {
                directFlight = true;
            }
        }
        // The search itself with all the parameters
        search = new Search(departDate, returnDate, destination, passenger, directFlight);
        if (returnDate == null) {
            idDeparture= searchController.searchResultsOneDirection(search);
            if(idDeparture!=-1)
                orderController.makeAnOrder(idDeparture,newPassenger());
            else{
                System.out.println("1. Start a new search" + "\n" + "2. Return to home page");
                op = scanner.nextLine();
                if (op.equals("1"))
                    this.search();
                else
                    sababaFlightsProgram.homePage();
            }
            // resOneWay = searchController.searchResultsOneDirection(search);
        } else {
            idDepartReturn=searchController.searchResultsRoundTrip(search);
            if(idDepartReturn[0]!=-1)
               orderController.makeAnOrder(idDepartReturn,newPassenger());
            // roundTrip = searchController.searchResultsRoundTrip(search);
            else{
                System.out.println("1. Start a new search" + "\n" + "2. Return to home page");
            op = scanner.nextLine();
            if (op.equals("1"))
                this.search();
            else
                sababaFlightsProgram.homePage();
            }
        }
//        System.out.println("Would you like to make an order? Y/N");
//        op=scanner.nextLine();
//        if(op.toLowerCase().equals("Y")) {
//
//            //If the user wants to order one way flight
//            if(flag) {
//                if(idDeparture!=-1)
//                    System.out.println("ID for departure flight is: " +idDeparture);
//               // orderController.addPassengerToOrder(idDeparture,newPassenger());
//            }
//
//            else {
//                System.out.println("round trip: "+ idDepartReturn[0]+ ", "+ idDepartReturn[1]);
//            //    orderController.makeAnOrder(roundTrip);
//            }
//        }
//        else {
//            System.out.println("1. Start a new search" + "\n" + "2. Return to home page");
//            op = scanner.nextLine();
//            if (op.equals("1"))
//                this.search();
//            else
//                sababaFlightsProgram.homePage();
//        }
    }

    public Passenger newPassenger()
    {
        long id;
        boolean validFlag;
        String firstName;
        String lastName;
        String email;
        String birthDateStr;
        String passport;
        String op;
        boolean meals=false,suitcase=false;
        DateTimeFormatter formatter = null;
        LocalDate birthDate;

        Scanner scanner = new Scanner(System.in);

        //Name validation
        do {
            System.out.println("First name: ");
            firstName = scanner.nextLine();
            validFlag = authenticationController.validName(firstName);
        }while(!validFlag);

        do{
            System.out.println("Last name: ");
            lastName=scanner.nextLine();
            validFlag = authenticationController.validName(lastName);
        }    while(!validFlag) ;

        //Email validation
        do{
            System.out.println("Email address :");
            email=scanner.nextLine();
            validFlag=authenticationController.emailValidation(email);
            if(!validFlag)
                System.out.println("Invalid email!");
        }    while(!validFlag) ;

        //Birthdate validation
     //   do{
            System.out.println("Birth date in dd/MM/yyyy format: ");
            birthDateStr = scanner.nextLine();
//            try {
//                formatter.parse(birthDateStr);
//                birthDate = LocalDate.parse(birthDateStr, formatter);
//            }
//            catch(NullPointerException e)
//            {
//                System.out.println("");
//            }
//        }    while(!validFlag);

        //Passport validation`
        do{
            System.out.println("Passport number: ");
            passport=scanner.nextLine();
            validFlag = authenticationController.passportValidation(passport);
        }    while(!validFlag);

      //  do{
//            System.out.println("ID number: ");
//            id=scanner.nextInt();
           // validFlag = authenticationController.passportValidation(passport);
       // }    while(!validFlag);

        System.out.println("Would you like to have a suitcase? Y/N");
        op=scanner.nextLine();
        if(op.toLowerCase().equals("y"))
        suitcase=true;

        System.out.println("Would you like to have a meal? Y/N");
        op=scanner.nextLine();
        if(op.toLowerCase().equals("y"))
            meals=true;

        //check ID
        return new Passenger(firstName,lastName,email,birthDateStr,passport,suitcase,meals);
    }

}