package model.repository;

import model.objects.Order;
import model.FileManager;
import model.objects.Passenger;
import model.singletons.OrderSingleton;

import java.util.*;

public class OrderRepositoryImpl implements OrderRepository {

    private Map<Integer, Order> allOrders;
    private FileManager<Order> fileManager;
    private Set<Order> orders;

    public OrderRepositoryImpl(){
        orders = OrderSingleton.getInstance().orderSet;
    }

    @Override
    public long generateOrderID() {
        Set<Order> orders = OrderSingleton.getInstance().orderSet;
        long highestOrderId = 0;
        for (Order order : orders) {
            if (order.getOrderID() > highestOrderId)
                highestOrderId = order.getOrderID();
        }
        return highestOrderId++;
    }

    @Override
    public boolean addPassenger(Order order, Passenger newPassenger) {
        if (order.getOwnerPassenger() == newPassenger) {
            System.out.println("The provided passenger is the order's owner");
            return false;
        } else {
            for (Passenger passenger : order.getOtherPassengers()) {
                if (passenger == newPassenger) {
                    System.out.println("Passenger is already in order");
                    return false;
                }
            }
            List<Passenger> newPassengersList = order.getOtherPassengers();
            newPassengersList.add(newPassenger);
            order.setOtherPassengers(newPassengersList);
        }
        return false;
    }

    @Override
    public boolean removePassengerByID(Order order, long passengerToRemove) {
        Scanner input = new Scanner(System.in);
        System.out.println("Sure? (Y / N)");
        String userInput = input.nextLine();
        if (userInput.equals("Y") || userInput.equals("y")) {
            if (order.getOtherPassengers().removeIf(passenger -> passenger.getId() == passengerToRemove)) {
                System.out.println("Successfully removed passenger from order");
                return true;
            } else {
                System.out.println("Could not find a passenger with the given ID in provided order");
                return false;
            }
        }
        System.out.println("Done nothing");
        return false;
    }

    @Override
    public boolean deleteOrder(Order orderToDelete) {
        Scanner input = new Scanner(System.in);
        System.out.println("Are you sure you want to delete the order? (Y / N)");
        String userInput = input.nextLine();
        if (userInput.equals("Y") || userInput.equals("y")) {
            Iterator<Order> iterator = orders.iterator();
            while (iterator.hasNext()) {
                Order order = iterator.next();
                if (order.getOrderID() == orderToDelete.getOrderID()) {
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

    @Override
    public boolean cancelOrder(Order orderToCancel) {
        Scanner input = new Scanner(System.in);
        System.out.println("Are you sure you want to cancel the order? (Y / N)");
        String userInput = input.nextLine();
        if (userInput.equals("Y") || userInput.equals("y")) {
            for (Order order : this.orders) {
                if (order.getOrderID() == orderToCancel.getOrderID()) {
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

    @Override
    public boolean reopenOrder(Order orderToReopen) {
        Scanner input = new Scanner(System.in);
        System.out.println("Are you sure you want to re-open the order? (Y / N)");
        String userInput = input.nextLine();
        if (userInput.equals("Y") || userInput.equals("y")) {
            for (Order order : this.orders) {
                if (order.getOrderID() == orderToReopen.getOrderID()) {
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

    //    @Override
//    public void cancelOrder(int agentCode, int orderId) {
//
//    }

//    @Override
//    public List<Order> findOrderByDates(String begin, String end) {
//        return null;
//    }
}
