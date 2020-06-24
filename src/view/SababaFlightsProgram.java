package view;

import controller.AuthenticationController;
import controller.OrderController;
import controller.SearchController;
import controller.objects.Search;
import model.FileManager;
import model.objects.*;

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

        Set<Agent> agents = this.loadData(Agent.class, "src/data/agents.json");
        Set<AircraftCompany> aircraftCompanies = this.loadData(AircraftCompany.class, "src/data/aircraftCompanies.json");
        Set<Airport> airports = this.loadData(Airport.class, "src/data/airports.json");
        Set<Flight> flights = new HashSet<>();

        flights.add(new Flight(new Aircraft(new AircraftCompany("El-Al"), 78, "Boeing-797"), new Airport("Israel, TLV", "Ben-Gurion", Arrays.asList("T1", "T3")), new Airport("New-York, JFK", "JFK", Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8")), "31/07/2020-23:15", "01/08/2020-03:23", 512, true));
//        saveData(flights, "src/data/flights.json");
        flights = this.loadData(Flight.class, "src/data/flights.json");
        System.out.println(flights);
        sabbaSearch.search();

    }

    private <T> Set<T> loadData(Class<T> classType, String fileName) {
        Set<T> data;
        FileManager<T> fileManager = new FileManager<>(fileName);
        data = fileManager.read(classType);
        return data;
    }

    private <T> boolean saveData(Set<T> data, String fileName) {
        FileManager<T> fileManager = new FileManager<>(fileName);
        return fileManager.saveObj(data);
    }

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

