package model.repository;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import model.objects.Agent;
//import model.objects.Order;
import model.FileManager;
import model.singletons.AgentSingleton;
import sun.util.resources.LocaleData;

import java.io.File;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.*;

public class AgentRepositoryImpl implements AgentRepository {


    private final String agentFile = "SababaFlights\\src\\data\\agents.json";
    private final String adminFile = "SababaFlights\\src\\data\\admin.json";
    private Set<Agent> agents;
    private FileManager<Agent> fileManager;
    private AgentSingleton agentSingletonInstance;


    public AgentRepositoryImpl() {
        this.fileManager=new FileManager<>(agentFile);
        this.agentSingletonInstance = AgentSingleton.getInstance();
        this.agents = agentSingletonInstance.agentSet;
    }

    // we need to verify if the first if is required because the AuthenticationService should prevent it
    @Override
    public void add(Agent agent) throws Exception {
        if(agent == null){
            throw new Exception(("must have a value"));
        }
        if(this.agents.contains(agent)){
            throw new Exception("Agent already exist!");
        }

        if(agent.isVerified())
        {
            this.agents.add(agent);
            agentSingletonInstance.saveSet(this.agents);
        }


    }

    @Override
    public void delete(int agentCode) {
        // need to implement delete in FileManger
    }

    //check if there is a shorter way to find agent by agent code if this is a set
    @Override
    public Agent find(int agentCode) {
        for (Agent agent : this.agents) {
            if (agent.getAgentCode() == agentCode) {
                return agent;
            }
        }
        return null;

    }

//    @Override
//    public List<Order> findAllOrdersForAgent(int agentCode) {
//        return null;
//    }
//
//    @Override
//    public List<Order> findAllOrdersForAgentByDate(int agentCode, LocalDate begin, LocalDate end) {
//        return null;
//    }
}
