package model.repository;

import model.objects.Agent;
//import model.objects.Order;

import java.time.LocalDate;
import java.util.List;


public interface AgentRepository {

    String encryptPassword(String password);
    Agent getAgentById(long id);

}
