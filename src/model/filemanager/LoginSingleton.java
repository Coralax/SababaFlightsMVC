package model.filemanager;

import model.objects.Agent;

public class LoginSingleton {

    private static LoginSingleton loginSingletonInstance = null;
    public boolean isLoggedIn;
    public Agent loggedInAgent;

    private LoginSingleton() {
        this.isLoggedIn = false;
    }

    public static LoginSingleton getInstance() {
        if (loginSingletonInstance == null)
            loginSingletonInstance = new LoginSingleton();
        return loginSingletonInstance;
    }

    public Agent getLoggedInAgent() {
        return loggedInAgent;
    }

    public boolean isLoggedIn() {
        return this.isLoggedIn;
    }

    public void logIn(Agent agent){
        this.loggedInAgent = agent;
        this.isLoggedIn = true;
    }

    public void logOut() {
        this.loggedInAgent = null;
        this.isLoggedIn = false;
        this.saveData();
    }

    private void saveData() {
        AgentFileManager.getInstance().saveSet(AgentFileManager.getInstance().agentSet);
        AircraftCompanyFileManager.getInstance().saveSet(AircraftCompanyFileManager.getInstance().aircraftCompanySet);
        AircraftFileManager.getInstance().saveSet(AircraftFileManager.getInstance().aircraftSet);
        AirportFileManager.getInstance().saveSet(AirportFileManager.getInstance().airportSet);
        FlightFileManager.getInstance().saveSet(FlightFileManager.getInstance().flightSet);
        OrderFileManager.getInstance().saveSet(OrderFileManager.getInstance().orderSet);
        PassengerFileManager.getInstance().saveSet(PassengerFileManager.getInstance().passengerSet);
    }

}
