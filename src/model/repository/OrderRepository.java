package model.repository;

import java.util.List;

public interface OrderRepository {

    void addOrder(int agentCode,int orderId);
    void cancelOrder(int agentCode, int orderId);
//    Order findOrderByID(int orderId);
//    List<Order> findOrderByDates(String begin, String end);  //IndexOutOfBoundsException;

}
