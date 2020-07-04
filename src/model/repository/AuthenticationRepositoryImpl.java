package model.repository;

import model.objects.Agent;
import model.singletons.AgentSingleton;
import model.singletons.LoginSingleton;

import java.io.File;
import java.io.IOException;
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

    // tal //
    @Override
    public boolean signUp(String firstName, String lastName, long id, String email, String birthDate,
                          boolean enabled, String userName, String password) {
        //JSON parser object to parse read file
        AgentSingleton agentSingleton = AgentSingleton.getInstance();
        Set<Agent> agents = agentSingleton.agentSet;
        boolean foundUserName = false;

        for (Agent agent : agents) {
            if (agent.getUserName().equals(userName)) {
                foundUserName = true;
                System.out.println("User already exists");
                return false;
            }
        }
        // if user not in the db,then create it.

        Agent newAgent = new Agent(id, firstName, lastName, email, userName, password, 1, birthDate);
        newAgent.setEncryptedPassword(password);
        agents.add(newAgent);
        agentSingleton.saveSet(agents);
        return true;
    }
}
