package view;

import controller.AuthenticationController;
import controller.OrderController;
import controller.SearchController;
import model.FileManager;
import model.objects.Agent;
import model.objects.AircraftCompany;

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

        Set<Agent> agents = this.loadData(Agent.class, "src/data/agents.json");
        Set<AircraftCompany> aircraftCompanies = this.loadData(AircraftCompany.class, "src/data/aircraftCompanies.json");


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
}

