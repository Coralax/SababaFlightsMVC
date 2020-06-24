package view;

import controller.AuthenticationController;
import controller.OrderController;
import controller.SearchController;
import controller.objects.Search;
import model.FileManager;
import model.objects.*;
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

    public void startProgram() throws IOException, ClassNotFoundException {
        /*CLI options*/

        Set<Agent> agents = AgentSingleton.getInstance().agentSet;
        Set<AircraftCompany> aircraftCompanies = AircraftCompanySingleton.getInstance().aircraftCompanySet;
        Set<Airport> airports = AirportSingleton.getInstance().airportSet;
        Set<Flight> flights = FlightSingleton.getInstance().flightSet;
        Set<Passenger> passengers = PassengerSingleton.getInstance().passengerSet;

        for (Agent agent : agents) {
            System.out.println(agent.getPassword());
        }

        sabbaSearch.search();

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


    public void homePage(String username){
        String op = null;
        do {
            System.out.println("Welcome " + username + ",what would you like to do?");
            System.out.println("1: Search a Flight ");
            System.out.println("2: Order a flight ");
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
                    case "-1":
                        break;
                    default:
                        System.exit(0);

                }
            } catch (IOException  |ClassNotFoundException e) {
                e.printStackTrace();
            }
        }while (!(op.equals("-1")));
    }

    public void login() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("username: ");
            String username = scanner.nextLine();
            System.out.println("password: ");
            String password = scanner.nextLine();
            boolean login = authController.login(username, password);
            System.out.println("Login status: " + login);

            homePage(username);
        }
    }


    public void SignUp(){


    }

    public void order(){

    }


}

