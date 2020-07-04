package model.repository;

import model.objects.Order;
import model.objects.Passenger;

import java.util.List;

public interface OrderRepository {

    int generateOrderID();
    boolean addPassenger(Order order, Passenger newPassenger);
    boolean removePassengerByID(Order order, long passengerToRemove);

}
