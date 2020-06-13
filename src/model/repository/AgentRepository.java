package model.repository;

import model.objects.Agent;
import model.objects.Order;

import java.util.List;


public interface AgentRepository {
    void add(int agentCode);
    void delete(int agentCode);
    Agent find(int agentCode);
    List<Order> findAllOrdersForAgent(int agentCode);
    List<Order> findAllOrdersForAgentByDate(int agentCode, String begin, String end);
}
