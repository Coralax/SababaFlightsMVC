package model.repository;


import model.objects.Agent;
import model.objects.Order;
import model.FileManager;

import java.util.List;
import java.util.Set;

public class AgentRepositoryImpl implements AgentRepository {

    private Set<Agent> agents;
    private FileManager<Agent> fileManager;

    public AgentRepositoryImpl(){

    }

    @Override
    public void add(int agentCode) {

    }

    @Override
    public void delete(int agentCode) {

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
    public List<Order> findAllOrdersForAgentByDate(int agentCode, String begin, String end) {
        return null;
    }
}
