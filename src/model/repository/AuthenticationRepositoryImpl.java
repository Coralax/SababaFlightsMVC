package model.repository;

import model.objects.Agent;
import model.singletons.AgentSingleton;
import model.singletons.LoginSingleton;

import java.util.Set;

public class AuthenticationRepositoryImpl implements AuthenticationRepository {

    @Override
    public boolean userNameLogin(String userName, String password) {

        AgentRepositoryImpl agentRepository = new AgentRepositoryImpl();
        Set<Agent> agents = AgentSingleton.getInstance().agentSet;

        boolean foundUserName = false;

        for (Agent agent : agents) {
            if (agent.getUserName().equals(userName)) {
                foundUserName = true;
                if (agent.getPassword().equals(agentRepository.encryptPassword(password))) {
                    LoginSingleton.getInstance().logIn(agent);
                    System.out.println("Logged in successfully");
                    return true;
                } else {
                    System.out.println("Wrong password, please try again.");
                    break;
                }
            }
        }
        if (!foundUserName)
            System.out.println("Username does not exist in the system");
        return false;
    }

    @Override
    public void logOut() {
        LoginSingleton.getInstance().logOut();
        System.out.println("Logged out successfully");
    }

    @Override
    public boolean isLoggedin() {
        return LoginSingleton.getInstance().isLoggedIn();
    }

}
