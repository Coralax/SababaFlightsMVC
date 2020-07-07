package model.repository;

import model.objects.Order;
import model.FileManager;
import model.objects.Passenger;
import model.singletons.OrderSingleton;
import model.singletons.PassengerSingleton;

import java.util.*;

public class OrderRepositoryImpl implements OrderRepository {

    private Map<Integer, Order> allOrders;
    private FileManager<Order> fileManager;
    private Set<Order> orders;

    public OrderRepositoryImpl(){
        orders = OrderSingleton.getInstance().orderSet;
    }

    @Override
    public boolean addPassenger(Order order, long passengerID) {
        if (order.getOwnerPassenger().getId() == passengerID) {
            System.out.println("The provided passenger is the order's owner");
            return false;
        } else {
            if (order.getOtherPassengers() == null) {
                List<Passenger> passengers = Arrays.asList(PassengerSingleton.getInstance().getPassengerByID(passengerID));
                order.setOtherPassengers(passengers);
                System.out.println("Successfully added passenger to order");
                return true;
            } else {
                for (Passenger passenger : order.getOtherPassengers()) {
                    if (passenger.getId() == passengerID) {
                        System.out.println("Passenger is already in order");
                        return false;
                    }
                }
                List<Passenger> newPassengersList = order.getOtherPassengers();
                newPassengersList.add(PassengerSingleton.getInstance().getPassengerByID(passengerID));
                order.setOtherPassengers(newPassengersList);
                return true;
            }
        }
    }

    @Override
    public boolean addPassenger(Order order, Passenger newPassenger) {
        return this.addPassenger(order, newPassenger.getId());
    }

    @Override
    public boolean removePassengerByID(Order order, long passengerToRemove) {
        boolean successfullyRemoved = false;
        Scanner input = new Scanner(System.in);
        System.out.println("Sure? (Y / N)");
        String userInput = input.nextLine();
        if (userInput.equals("Y") || userInput.equals("y")) {
            List<Passenger> p = new ArrayList<>();
            for (Passenger passenger : order.getOtherPassengers()) {
                if (passenger.getId() == passengerToRemove) {
                    successfullyRemoved = true;
                    continue;
                }
                p.add(passenger);
            }
            if (successfullyRemoved) {
                order.setOtherPassengers(p);
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
                if (order.getId() == orderToDelete.getId()) {
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
    public boolean deactivate(Order orderToCancel) {
        Scanner input = new Scanner(System.in);
        System.out.println("Are you sure you want to cancel the order? (Y / N)");
        String userInput = input.nextLine();
        if (userInput.equals("Y") || userInput.equals("y")) {
            for (Order order : this.orders) {
                if (order.getId() == orderToCancel.getId()) {
                    order.setCanceled(true);
                    System.out.println("Order has been deactivated");
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
    public boolean activate(Order orderToReopen) {
        Scanner input = new Scanner(System.in);
        System.out.println("Are you sure you want to re-open the order? (Y / N)");
        String userInput = input.nextLine();
        if (userInput.equals("Y") || userInput.equals("y")) {
            for (Order order : this.orders) {
                if (order.getId() == orderToReopen.getId()) {
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
