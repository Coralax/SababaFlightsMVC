/* 1.Make Singleton
   2. Can contain as many services as it needs*/

package controller;

import model.objects.Order;
import model.service.OrderService;

import java.util.Set;

public class OrderController {

    private OrderService orderService = new OrderService();

    // boolean because order might not exist/no orders in the range of dates/agent code...
    public Order getOrderByID(long orderID) {
        return orderService.getOrderByID(orderID);
    }

    public Set<Order> getOrdersByAgentCode(long agentCode) {
        return orderService.getOrdersByAgentCode(agentCode);
    }

    public Set<Order> getOrdersByPassengerID(long passengerID) {
        return orderService.getOrdersByPassengerID(passengerID);
    }

    public boolean searchByDate() {
        return false;
    }

    public boolean addPassengerToOrder(Order order, long passengerID) {
        return orderService.addPassengerToOrder(order, passengerID);
    }

    public boolean removePassengerFromOrder(Order order, long passengerID) {
        return orderService.removePassengerByID(order, passengerID);
    }

    public boolean cancelOrder(Order order) {
        return orderService.cancelOrder(order);
    }

    public boolean reActivateOrder(Order order) {
        return orderService.cancelOrder(order);
    }

    public boolean deleteOrder(Order order) {
        return orderService.deleteOrder(order);
    }

}
