package view;

import controller.AuthenticationController;
import controller.OrderController;
import controller.SearchController;
import controller.objects.Search;
import model.FileManager;
import model.objects.*;
import model.repository.AuthenticationRepositoryImpl;
import model.singletons.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class SababaFlightsProgram {

    private AuthenticationController authController;
    private OrderController orderController;
    private SababaSearch sabbaSearch;

    public SababaFlightsProgram() {
        this.authController = new AuthenticationController();
        this.orderController = new OrderController();
        this.sabbaSearch = new SababaSearch();
     }

    public void startProgram() {
        /*CLI options*/

        Set<Agent> agents = AgentSingleton.getInstance().agentSet;
        Set<AircraftCompany> aircraftCompanies = AircraftCompanySingleton.getInstance().aircraftCompanySet;
        Set<Airport> airports = AirportSingleton.getInstance().airportSet;
        Set<Flight> flights = FlightSingleton.getInstance().flightSet;
        Set<Passenger> passengers = PassengerSingleton.getInstance().passengerSet;
        Set<Order> orders = OrderSingleton.getInstance().orderSet;

//        for (Order order : orders) {
//            System.out.println(order.getOtherPassengers().size());
//        }

        Iterator<AircraftCompany> aircraftCompanyIterator = aircraftCompanies.iterator();
        Iterator<Flight> flightIterator = flights.iterator();
        Iterator<Passenger> passengerIterator = passengers.iterator();
        AircraftCompany aircraftCompany = aircraftCompanyIterator.next();
        List<Flight> flight = new ArrayList<>();
        flight.add(flightIterator.next());

        System.out.println(OrderSingleton.getInstance().orderSet.size());

        orders.add(new Order(0, aircraftCompany, false, 0, 789.0, 321321321, flight, null, passengerIterator.next(), null));

//        System.out.println(OrderSingleton.getInstance().orderSet.size());

//        OrderSingleton.getInstance().saveSet(orders);

        this.loginScreen();

    }

//    private <T> Set<T> loadData(Class<T> classType, String fileName) {
//        Set<T> data;
//        FileManager<T> fileManager = new FileManager<>(fileName);
//        data = fileManager.read(classType);
//        return data;
//    }
//
//    private <T> boolean saveData(Set<T> data, String fileName) {
//        FileManager<T> fileManager = new FileManager<>(fileName);
//        return fileManager.saveSet(data);
//    }

    public void loginScreen(){
        String op;
        do {
            System.out.println("Welcome to SababaFlight: ");
            System.out.println("1: Log in ");
            System.out.println("2: Sign up ");
            System.out.println("-1: Exit ");
            try (Scanner scanner = new Scanner((System.in))) {
                op = scanner.nextLine();
                switch (op) {
                    case "1":
                        this.login();
                        break;
                    case "2":
                        this.SignUp();
                        break;
                    case "-1":
                        break;
                    default:
                        System.exit(0);

                }
            }
        }while (!(op.equals("-1")));
    }


    public void homePage(){
        String op;
        do {
            Agent loggedInAgent = LoginSingleton.getInstance().loggedInAgent;
            System.out.println("Welcome " + loggedInAgent.getFirstName() + " ,what would you like to do?");
            System.out.println("1: Search a Flight ");
            System.out.println("2: Order a flight ");
            System.out.println("0: Logout");
            System.out.println("-1: Exit ");
            try (Scanner scanner = new Scanner((System.in))) {
                op = scanner.nextLine();
                switch (op) {
                    case "1":
                        sabbaSearch.search();
                        break;
                    case "2":
                        this.order();
                        break;
                    case "0":
                        LoginSingleton.getInstance().logOut();
                        this.loginScreen();
                        break;
                    case "-1":
                        break;
                    default:
                        LoginSingleton.getInstance().logOut();
                        this.loginScreen();
                        System.exit(0);

                }
            }
        }while (!(op.equals("-1")));
    }

    public void login() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Username: ");
            String userName = scanner.nextLine();
            System.out.println("Password: ");
            String password = scanner.nextLine();
            boolean login = authController.login(userName, password);
            if (login) {
                this.homePage();
            } else {
                this.login();
            }
            System.out.println("Login status: " + login);
        }
    }


    public void SignUp(){


    }

    public void order(){

    }


}

