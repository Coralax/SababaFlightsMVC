package view;

import controller.AuthenticationController;
import controller.OrderController;
import controller.SearchController;
import model.FileManager;
import model.objects.Agent;
import model.objects.Aircraft;

import java.util.Scanner;
import java.util.Set;

public class SababaFlightsProgram {

    private AuthenticationController authController;
    private OrderController orderController;
    private SearchController searchController;

    public SababaFlightsProgram() {
        this.authController = new AuthenticationController();
        this.orderController = new OrderController();
        this.searchController = new SearchController();
    }

    public void startProgram() {
        /*CLI options*/
        FileManager<Agent> fileManagerAgent = new FileManager<>("src/data/agents2.json");
        Set<Agent> agents = fileManagerAgent.read();
//        fileManagerAgent.saveObj(agents, "src/data/agents2.json");
        FileManager<Aircraft> fileManagerAircraft = new FileManager<>("src/data/aircrafts.json");
        Set<Aircraft> aircrafts = fileManagerAircraft.read();
        // TODO: Fix next three lines
//        System.out.println(aircrafts.get(0).toString());
//        aircrafts.get(0).setSeatsCount(88);
//        fileManagerAircraft.saveObj(aircrafts, "src/data/aircrafts.json");
    }


    public void loginScreen(){
        String op;
        do {
            System.out.println("Welcome to SababaFlight: ");
            System.out.println("1. login: ");
            System.out.println("2. SignUp: ");
            System.out.println("-1 to exit: ");
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
                    default:
                        System.exit(0);

                }
            }
        }while (op!= "-1");
    }


    public void homePage(String username){
        String op;
        do {
            System.out.println("Welcome " + username + "WHAT WOULD YOU LIKE TO DO?");
            System.out.println("a. Search Flight: ");
            System.out.println("b. Order a flight: ");
            System.out.println("-1 to exit: ");
            try (Scanner scanner = new Scanner((System.in))) {
                op = scanner.nextLine();
                switch (op) {
                    case "a":
                        this.search();
                        break;
                    case "b":
                        this.order();
                        break;
                    case "-1":
                    default:
                        System.exit(0);

                }
            }
        }while (op!= "-1");
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

    public void search(){

    }

    public void order(){

    }


}

