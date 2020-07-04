package model.repository;

import model.objects.Order;
import model.objects.Passenger;

import java.util.Set;

public interface OrderRepository {

    long generateOrderID();
    boolean addPassenger(Order order, long passengerID);
    boolean addPassenger(Order order, Passenger newPassenger);
    boolean removePassengerByID(Order order, long passengerToRemove);
    boolean deleteOrder(Order orderToDelete);
    boolean deactivate(Order orderToCancel);
    boolean activate(Order orderToReopen);

}
