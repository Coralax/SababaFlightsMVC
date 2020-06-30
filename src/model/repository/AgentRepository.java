package model.repository;

import model.objects.Agent;
//import model.objects.Order;

import java.time.LocalDate;
import java.util.List;


public interface AgentRepository {

    String encryptPassword(String password);
//    void delete(int agentCode);
//    Agent find(int agentCode);
//    List<Order> findAllOrdersForAgent(int agentCode);
//    List<Order> findAllOrdersForAgentByDate(int agentCode, LocalDate begin, LocalDate end);

}
