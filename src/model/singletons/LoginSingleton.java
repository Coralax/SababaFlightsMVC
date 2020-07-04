package model.singletons;

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
        System.out.println("Logged out successfully.");
    }

}
