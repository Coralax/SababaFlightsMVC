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

    public Order getOrderByID(int id) {
        for (Order order : this.orderSet) {
            if (order.getOrderID() == id)
                return order;
        }
        System.out.println("Could not find an order with the provided id");
        return null;
    }

    public Set<Order> getOrdersByAgentCode(int agentCode) {
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

    public boolean deleteOrderByID(int orderToDelete) {
        Scanner input = new Scanner(System.in);
        System.out.println("Are you sure you want to delete the order? (Y / N)");
        String userInput = input.nextLine();
        if (userInput.equals("Y") || userInput.equals("y")) {
            Iterator<Order> iterator = orderSet.iterator();
            while (iterator.hasNext()) {
                Order order = iterator.next();
                if (order.getOrderID() == orderToDelete) {
                    iterator.remove();
                    System.out.println("Order has been deleted");
                    return true;
                }
            }
            System.out.println("There is no order with the provided ID");
            return false;
        }
        System.out.println("Done nothing");
        return false;
    }

    public boolean cancelOrderByID(int orderToCancel) {
        Scanner input = new Scanner(System.in);
        System.out.println("Are you sure you want to cancel the order? (Y / N)");
        String userInput = input.nextLine();
        if (userInput.equals("Y") || userInput.equals("y")) {
            for (Order order : orderSet) {
                if (order.getOrderID() == orderToCancel) {
                    order.setCanceled(true);
                    System.out.println("Order has been canceled");
                    return true;
                }
            }
            System.out.println("There is no order with the provided ID");
            return false;
        }
        System.out.println("Done nothing");
        return false;
    }

    public boolean reopenOrderByID(int orderToReopen) {
        Scanner input = new Scanner(System.in);
        System.out.println("Are you sure you want to re-open the order? (Y / N)");
        String userInput = input.nextLine();
        if (userInput.equals("Y") || userInput.equals("y")) {
            for (Order order : orderSet) {
                if (order.getOrderID() == orderToReopen) {
                    order.setCanceled(false);
                    System.out.println("Order has been canceled");
                    return true;
                }
            }
            System.out.println("There is no order with the provided ID");
            return false;
        }
        System.out.println("Done nothing");
        return false;
    }

//    public Set<Order> getOrdersByDate() {
//        Set<Order> filteredOrders = new HashSet<>();
//    }

}
