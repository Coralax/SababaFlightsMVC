package view;
import controller.AuthenticationController;
import controller.OrderController;
import controller.SearchController;
import controller.objects.Search;
import model.objects.AESEncryption;
import model.objects.Agent;
import model.objects.Passenger;
import model.singletons.LoginSingleton;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SababaSearchView {
    private SearchController searchController;
    private OrderController orderController;
    private AuthenticationController authenticationController;
    private Agent loggedInAgent;
    public SababaFlightsProgram sababaFlightsProgram;


    public SababaSearchView(SababaFlightsProgram referer) {
        this.searchController= new SearchController();
        this.orderController=new OrderController();
        this.authenticationController=new AuthenticationController();
        this.sababaFlightsProgram = referer;
        this.loggedInAgent = LoginSingleton.getInstance().getLoggedInAgent();
    }

    public void search() {
        Search search;
        List<Long> idDeparture, idDepartReturn;
        String destination;
        String departDateStr;
        String returnDateStr;
        String filters;
        String op;
        String creditCard;
        LocalDate departDate = null, returnDate = null;
        boolean cabinClass = false, directFlight = false, suitcase = false, meals = false;
        String numOfPass;
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter;
        int passenger, test;
        boolean flag = false;


        try {
            //Depart date
            do {
                System.out.println( "Welcome to search page! " + "\n" +"1: For one way trip" + "\n" + "2: For round-trip");
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
        System.out.print("Would you like to have additional filters? Y/N: ");
        filters = scanner.nextLine();

        if (filters.toLowerCase().equals("y")) {
            // Direct flights
            System.out.print("Search for direct flights only? Y/N: ");
            op = scanner.nextLine();

            if (op.toLowerCase().equals("y")) {
                directFlight = true;
            }
        }

        // The search itself with all the parameters
        search = new Search(departDate, returnDate, destination, passenger, directFlight);

        //Only one way flight
        if (returnDate == null) {
            idDeparture = searchController.searchResultsOneDirection(search);
            if (idDeparture != null) {

                Passenger ownerPassenger = this.newPassenger();
                List<Passenger> otherPassengers = new ArrayList<>();
                int counter = 1;
                while (counter < search.getNumberOfPassengers()) {
                    otherPassengers.add(this.newPassenger());
                    counter++;
                }

                System.out.println("Would you like to have a suitcase? Y/N");
                op=scanner.nextLine();
                if(op.toLowerCase().equals("y"))
                    suitcase=true;

                System.out.println("Would you like to have a meal? Y/N");
                op=scanner.nextLine();
                if(op.toLowerCase().equals("y"))
                    meals=true;

                do {
                    System.out.println("Please insert a credit card (16 digits) (-1 to exit): ");
                    creditCard = scanner.nextLine();
                    if (creditCard.equals("-1"))
                        break;
                    flag = authenticationController.creditCardValidation(creditCard);
                }while (!flag);

//                System.out.println(1234);
//                System.out.println(creditCard);
//                System.out.println(idDeparture);
//                System.out.println(search.getNumberOfPassengers());
//                System.out.println(ownerPassenger);
//                System.out.println(otherPassengers);
//                System.out.println(meals);
//                System.out.println(suitcase);
//                System.out.println(search.getNumberOfPassengers());
                orderController.makeAnOrder(6565, creditCard, idDeparture, null,
                        search.getNumberOfPassengers(), ownerPassenger, otherPassengers, meals, suitcase, search.getNumberOfPassengers());
            }
        }
        //Round trip
        else {
            idDepartReturn = searchController.searchResultsRoundTrip(search);
            if(idDepartReturn!= null) {
                //TO BE CONTINUED
//                orderController.makeAnOrder(loggedInAgent.getAgentCode(), 123456789012663456L, idDepartReturn, null, search.getNumberOfPassengers(), ownerPassenger, otherPassengers, meals, suitcase, search.getNumberOfPassengers());
            }
        }

        System.out.println("What would you like to do? "+"\n" + "1. Start a new search" + "\n" + "2. Return to home page");
        op = scanner.nextLine();
        if (op.equals("1"))
            this.search();
        else
            sababaFlightsProgram.homePage();
    }

    public Passenger newPassenger()
    {
        boolean validFlag;
        String firstName;
        String lastName;
        String email;
        String birthDateStr;
        String passport;
        String op;
        boolean meals=false,suitcase=false;
        //DateTimeFormatter formatter;
       // LocalDate birthDate;

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

        //Date of birth validation
       //   do{
            System.out.println("Date of birth in dd/MM/yyyy format: ");
            birthDateStr = scanner.nextLine();
//            try {
//                formatter.parse(birthDateStr);
//                birthDate = LocalDate.parse(birthDateStr, formatter);
//            }
//            catch(Exception e)
//           {
//               System.out.println("Invalid date of birth string");
//            }
//        }    while(!validFlag);


        //Passport validation`
        do{
            System.out.println("Passport number: ");
            passport=scanner.nextLine();
            validFlag = authenticationController.passportValidation(passport);
        }    while(!validFlag);


        return new Passenger(firstName,lastName,email,birthDateStr,passport);
    }


}