package model.singletons;

import model.objects.Order;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class OrderSingleton extends Singleton<Order> {

    private static OrderSingleton orderSingletonInstance = null;
    public Set<Order> orderSet;

    private OrderSingleton() {
        super("src/data/orders.json");
        orderSet = this.read(Order.class);
    }

    public static OrderSingleton getInstance() {
        if (orderSingletonInstance == null)
            orderSingletonInstance = new OrderSingleton();

        return orderSingletonInstance;
    }

    public Order getOrderByID(long id) {
        /*  Tal
                if(this.orderSet == null)
            return null;
         */

        for (Order order : this.orderSet) {
            if (order.getOrderID() == id)
                return order;
        }
        System.out.println("Could not find an order with the provided id");
        return null;
    }

    public Set<Order> getOrdersByAgentCode(long agentCode) {
        Set<Order> ordersByAgent = new HashSet<>();
        for (Order order : this.orderSet) {
            if (order.getAgentCode() == agentCode) {
                ordersByAgent.add(order);
            }
        }
        if (ordersByAgent.size() == 0)
            System.out.println("Could not find orders created by provided agent");

        return ordersByAgent;
    }

    public Set<Order> getOrdersByPassengerID(long passengerID) {
        Set<Order> ordersByPassenger = new HashSet<>();
        for (Order order : this.orderSet) {
            if (order.getOwnerPassenger().getId() == passengerID) {
                ordersByPassenger.add(order);
            }
        }
        if (ordersByPassenger.size() == 0)
            System.out.println("Could not find orders associated with provided passenger");

        return ordersByPassenger;
    }

//    public Set<Order> getOrdersByDate() {
//        Set<Order> filteredOrders = new HashSet<>();
//    }

}
