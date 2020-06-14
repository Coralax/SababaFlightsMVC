package view;

import controller.AuthenticationController;
import controller.OrderController;
import controller.SearchController;
import model.FileManager;
import model.objects.Agent;
import model.objects.Aircraft;
import model.objects.Passenger;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        List<Agent> agents = fileManagerAgent.read();
//        fileManagerAgent.saveObj(agents, "src/data/agents2.json");
        FileManager<Aircraft> fileManagerAircraft = new FileManager<>("src/data/aircrafts.json");
        List<Aircraft> aircrafts = fileManagerAircraft.read();
        // TODO: Fix next three lines
//        System.out.println(aircrafts.get(0).toString());
//        aircrafts.get(0).setSeatsCount(88);
//        fileManagerAircraft.saveObj(aircrafts, "src/data/aircrafts.json");
    }
}

