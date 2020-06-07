package model;

import com.example.main.Agent;
import com.example.main.Order;
import java.util.List;
import java.util.Map;

public class OrderRepositoryImpl implements OrderRepository {

    private Map<Integer, Order> allOrders;

    public OrderRepositoryImpl(){

    }

    @Override
    public void addOrder(Agent agent, Order order) {

    }

    @Override
    public void cancelOrder(Agent agent, Order order) {

    }

    @Override
    public void addOrder(int agentCode, Order order) {

    }

    @Override
    public void cancelOrder(int agentCode, Order order) {

    }

    @Override
    public Order findOrderByID(int orderId) {
        return null;
    }

    @Override
    public List<Order> findOrderByDates(String begin, String end) {
        return null;
    }
}
