package model;


import com.example.main.Agent;
import com.example.main.Order;

import java.util.List;
import java.util.Set;

public class AgentRepositoryImpl implements AgentRepository{

    private Set<Agent> agents;

    public AgentRepositoryImpl(){

    }
    @Override
    public void add(Agent agent) {

    }

    @Override
    public void delete(int agentCode) {

    }

    @Override
    public void delete(Agent agent) {

    }

    @Override
    public Agent find(int agentCode) {
        return null;
    }

    @Override
    public List<Order> findAllOrdersForAgent(int agentCode) {
        return null;
    }

    @Override
    public List<Order> findAllOrdersForAgent(Agent agent) {
        return null;
    }

    @Override
    public List<Order> findAllOrdersForAgentByDate(int agentCode, String begin, String end) {
        return null;
    }

    @Override
    public List<Order> findAllOrdersForAgentByDate(Agent agent, String begin, String end) {
        return null;
    }
}
