package view;

import controller.AuthenticationController;
import controller.OrderController;
import controller.SearchController;
import model.FileManager;
import model.objects.Agent;
import model.objects.Aircraft;
import model.objects.Passenger;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;

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

        FileManager<Agent> fileManagerAgent = new FileManager<>("src/data/agents.json");
        Set<Agent> agents = fileManagerAgent.read();
        for (Agent agent : agents) {
            System.out.println(agent.getUserName());
        }
    }
}

