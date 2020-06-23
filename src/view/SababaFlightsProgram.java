package view;

import controller.AuthenticationController;
import controller.OrderController;
import controller.SearchController;
import controller.objects.Search;
import model.FileManager;
import model.objects.Agent;
import model.objects.Aircraft;
import model.objects.AircraftCompany;

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

        sabbaSearch.search();

    }

    private <T> Set<T> loadData(Class<T> classType, String fileName) {
        Set<T> data;
        FileManager<T> fileManager = new FileManager<>(fileName);
        data = fileManager.read(classType);
        return data;
    }

    private<T> boolean saveData(Set<T> data, String fileName) {
        FileManager<T> fileManager = new FileManager<>(fileName);
        return fileManager.saveObj(data, fileName);
    }

    public void loginScreen(){
        String op;
        do {
            System.out.println("Welcome to SababaFlight: ");
            System.out.println("1: Sign up ");
            System.out.println("2: Log in ");
            System.out.println("-1: Exit ");
            try (Scanner scanner = new Scanner((System.in))) {
                op = scanner.nextLine();
                switch (op) {
                    case "1":
                        this.SignUp();
                        break;
                    case "2":
                        this.login();
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

