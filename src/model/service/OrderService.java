package model.service;

import model.objects.Flight;
import model.objects.Order;
import model.objects.Passenger;
import model.repository.FlightRepositoryImpl;
import model.repository.OrderRepositoryImpl;
import model.singletons.OrderSingleton;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OrderService {

    private OrderRepositoryImpl orderRepository;
    private OrderSingleton orderSingletonInstance;
    private FlightRepositoryImpl flightRepository;
    private Set<Order> orders;

    public OrderService() {
        orderSingletonInstance = OrderSingleton.getInstance();
        orders = orderSingletonInstance.orderSet;
        orderRepository = new OrderRepositoryImpl();
        flightRepository=new FlightRepositoryImpl();
    }

    public Order getOrderByID(long orderID) {
        return orderRepository.getOrderById(orderID);
    }

    public Set<Order> getOrdersByAgentCode(long agentCode) {
        return orderRepository.getOrdersByAgentCode(agentCode);
    }

    public Set<Order> getOrdersByPassengerID(long passengerID) {
        return orderRepository.getOrdersByPassengerID(passengerID);
    }

    public boolean addPassengerToOrder(Order order, long passengerID) {
        return orderRepository.addPassenger(order, passengerID);
    }

    public boolean removePassengerByID(Order order, long passengerID) {
        return orderRepository.removePassengerByID(order, passengerID);
    }

    public boolean cancelOrder(Order order) {
        return orderRepository.deactivate(order);
    }

    public boolean reActivateOrder(Order order) {
        return orderRepository.activate(order);
    }

    public boolean deleteOrder(Order order) {
        return orderRepository.deleteOrder(order);
    }


    public void makeNewOrder(long agentCode,String creditCard, List<Long> flightToIDs, List<Long> flightFromIDs, int seatsCount,
                             Passenger ownerPassenger, List<Passenger> otherPassengers, boolean isMeal, boolean isSuitcase, int numOfPassegers) {

        // Process order data
        boolean roundTrip = false;
        double totalPrice = 0;
        if (flightToIDs.size() > 0) {
            if (flightFromIDs != null && flightFromIDs.size() != 0)
                roundTrip = true;
        }
        for (long flightID : flightToIDs)
            totalPrice += flightRepository.getFlightPriceById(flightID);
        if (isMeal)
            totalPrice += 25;
        if(isSuitcase)
            totalPrice += 25;
        totalPrice *= numOfPassegers;

        long ownerPassengerID = ownerPassenger.getId();
        List<Long> otherPassengersIDs = new ArrayList<>();
        for (Passenger otherPassenger : otherPassengers)
            otherPassengersIDs.add(otherPassenger.getId());

        // Decrease amount of remaining seats
        for (long flightID : flightToIDs)
            flightRepository.decreaseSeats(flightID, seatsCount);

        // Create the order itself
        Order newOrder = new Order(agentCode, creditCard, totalPrice, flightToIDs, flightFromIDs, ownerPassengerID, otherPassengersIDs);
        System.out.println(newOrder.toString());

    }

}