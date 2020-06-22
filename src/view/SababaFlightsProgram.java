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


    public void HomePage(){
        System.out.println("Welcome to SababaFlight: ");
        System.out.println("1. login: ");
        System.out.println("2. Orders: ");
        System.out.println("2. Search: ");
        System.out.println("Q. exit: ");

        try(Scanner scanner = new Scanner((System.in))){
            String command = scanner.nextLine();
            switch(command){
                case "1":
                    this.login();
                    break;
                case "2":
                    this.order();
                    break;
                case "3":
                    this.search();
                    break;
                case "Q":
                case "q":
                default:
                    System.exit(0);

        }
            }
    }

    public void login() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("username: ");
            String username = scanner.nextLine();
            System.out.println("password: ");
            String password = scanner.nextLine();

            boolean login = authController.login(username, password);
            System.out.println("Login status: " + login);

        }
    }


    public void order(){

    }

    public void search(){

    }


}

