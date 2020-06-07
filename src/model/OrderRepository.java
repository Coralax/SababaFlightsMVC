package model;

import com.example.main.Agent;
import com.example.main.Order;
import java.io.IOException;
import java.util.List;

public interface OrderRepository {

    void addOrder(Agent agent,Order order);
    void cancelOrder(Agent agent, Order order);
    void addOrder(int agentCode,Order order);
    void cancelOrder(int agentCode, Order order) throws IOException;
    Order findOrderByID(int orderId)throws Exception;
    List<Order> findOrderByDates(String begin, String end) throws Exception; //IndexOutOfBoundsException;

}
