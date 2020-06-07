package model;

import com.example.main.Agent;
import com.example.main.Order;

import javax.management.InstanceNotFoundException;
import java.io.IOException;
import java.util.List;


public interface AgentRepository {
    void add(Agent agent);//Not sure if it should be here or belong to an Admin repo...
    void delete(int agentCode);//Not sure if it should be here or belong to an Admin repo...
    void delete(Agent agent);
    Agent find(int agentCode);
    List<Order> findAllOrdersForAgent(int agentCode);
    List<Order> findAllOrdersForAgent(Agent agent);
    List<Order> findAllOrdersForAgentByDate(int agentCode, String begin, String end);
    List<Order> findAllOrdersForAgentByDate(Agent agent, String begin, String end);
}
