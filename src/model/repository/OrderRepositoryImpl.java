package model.repository;

import model.objects.Order;
import model.FileManager;

import java.util.List;
import java.util.Map;

public class OrderRepositoryImpl implements OrderRepository {

    private Map<Integer, Order> allOrders;
    private FileManager<Order> fileManager;
    public OrderRepositoryImpl(){

    }

    @Override
    public void addOrder(int agentCode, int orderId) {

    }

    @Override
    public void cancelOrder(int agentCode, int orderId) {

    }

//    @Override
//    public Order findOrderByID(int orderId) {
//        return null;
//    }
//
//    @Override
//    public List<Order> findOrderByDates(String begin, String end) {
//        return null;
//    }
}
