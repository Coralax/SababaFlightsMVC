package model.repository;

import model.objects.Order;
import model.FileManager;
import model.objects.Passenger;
import model.singletons.OrderSingleton;

import java.util.*;

public class OrderRepositoryImpl implements OrderRepository {

    private Map<Integer, Order> allOrders;
    private FileManager<Order> fileManager;

    public OrderRepositoryImpl(){}

    @Override
    public int generateOrderID() {
        Set<Order> orders = OrderSingleton.getInstance().orderSet;
        int highestOrderId = 0;
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

    //    @Override
//    public void cancelOrder(int agentCode, int orderId) {
//
//    }

//    @Override
//    public List<Order> findOrderByDates(String begin, String end) {
//        return null;
//    }
}
